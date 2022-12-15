<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Liste des Departements</h1>

<sec:authorize access="isAuthenticated()"> Bienvenue <sec:authentication property="name"/>
(<a href="<c:url value="/logout" />" >Logout</a>)
</sec:authorize>

<table>

<c:forEach items= "${liste}" var="m">

<tr> <td>${m.id}</td>
	 <td>${m.titre}</td>
	 
	 <td><sec:authorize access="hasRole('ADMIN')"><a href="Departement/${m.id}" >liste des matériels</a> </sec:authorize></td>
</tr>

</c:forEach>

</table>

</body>
</html>