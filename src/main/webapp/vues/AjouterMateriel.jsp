<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Ajouter un matériel</h1>

<form:form method="POST" action="/save" modelAttribute="mat" >

<p> Tite : <form:input path="titre"/> </p>

<form:select path ="Type">
<form:option value = "Réseau"> Reseau </form:option>
<form:option value = "Télécom"> Telecom </form:option>
<form:option value = "Télécom"> Info </form:option>
</form:select>

<p> Serie : <form:input path="numserie"/> </p>
<p> Quantite : <form:input path="qte"/> </p>

<form:select path ="Etat">
<form:option value = "fonctionnel"> Fonctionnel </form:option>
<form:option value = "défectueux"> Defectueux </form:option>
</form:select>

<p> Departement : <form:select path="dep.id": items="${dept}" itemlabel="titre" itemValue="id"/>

<p> <input type="submit" value="Ajouter" />
</form:form>


</body>
</html>