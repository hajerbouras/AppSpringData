package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String titre;
	
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Departement(Integer id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}


	private Integer getId() {
		return id;
	}


	private void setId(Integer id) {
		this.id = id;
	}


	private String getTitre() {
		return titre;
	}


	private void setTitre(String titre) {
		this.titre = titre;
	}


	
	
	
	
	
	

}
