<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion des notes</title>
	</head>
	<c:import url="/resources/header.jsp"></c:import>
	<body>
	<br><br><br><br><br>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-lg-12">
				<div aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="dashboard">Tableau de bord</a></li>
    				<li class="breadcrumb-item active" aria-current="page">Gestion des notes</li>
				  </ol>
				</div>
			</div>
			<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Noms et Prénoms</th>
			      <c:forEach items="${listeCours}" var="lc" varStatus="boucle">
			      	<th scope="col">${lc.intitule}</th>
			      </c:forEach>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${liste}" var="en" varStatus="boucle">
			  	 <tr>
			      <th scope="row">${boucle.count}</th>
			      <td>${en.etudiant.nom}</td>
			      <c:forEach items="${en.notes}" var="note" varStatus="boucle">
			      	<td scope="col">${note}</td>
			      </c:forEach>
			      <td><a href="notes/${en.etudiant.id_etudiant}" class="btn edit"><span class="oi oi-pencil mr-sm-2" title="Modifier" aria-hidden="true"></a>
				  </td>
			    </tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>