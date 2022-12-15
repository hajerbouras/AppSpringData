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

<h1>Liste des Matériels</h1>
<h2>Departement choisi: Departement ${dept}</h2>

<p>
<sec:authorize access="hasRole('ADMIN')" >
<a href="/AppSpringData/AjouterMateriel/${Departement_id}"> Ajouter un Materiel </a>
</sec:authorize>

</p>

<table>

<c:forEach items="${liste}" var="mat">

<tr> <td> ${mat.titre} </td>
	 <td> ${mat.type} </td>
	 <td> ${mat.numserie} </td>
	 <td> ${mat.qte} </td>
	 <td> ${mat.etat} </td>
	 
	 <td><sec:authorize access="hasRole('ADMIN')"><a href="/AppSpringData/deleteMat/${mat.id}">Supprimer</a></sec:authorize></td>
	 
	 
</tr>	 
	 
</c:forEach>
</table>

</body>
</html>