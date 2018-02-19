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
			      <th scope="col">Noms et Pr�noms</th>
			      <c:forEach items="${cours}" var="c" varStatus="boucle">
			      	<th scope="col">${c}</th>
			      </c:forEach>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <c:forEach items="${cours}" var="c" varStatus="boucle">
			      	<td scope="col">${c}</td>
			      </c:forEach>
			      <td>D�tails</td>
			    </tr>
			    <tr>
			      <th scope="row">1</th>
			      <td>Mark</td>
			      <c:forEach items="${cours}" var="c" varStatus="boucle">
			      	<td scope="col">${c}</td>
			      </c:forEach>
			      <td><a href="noteEtudiant?id=">D�tails</a></td>
			    </tr>
			  </tbody>
			</table>
		</div>
	</div>
	</body>
</html>