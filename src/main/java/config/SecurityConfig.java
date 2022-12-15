package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder crypt = cryptageMP();
		auth.inMemoryAuthentication().withUser("ali").password(crypt.encode("enig")).roles("USER");
		auth.inMemoryAuthentication().withUser("emna").password(crypt.encode("enig")).roles("Admin");
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, active from user where username=? ")
			.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_roles where user_username=?")
			.passwordEncoder(crypt)
			.rolePrefix("ROLE_");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/ADD**/**","/DEL**/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		
		http.csrf();
		
		
	}
	
	@Bean
	public PasswordEncoder cryptageMP() {
		
		return new BCryptPasswordEncoder();
		
	}

}
