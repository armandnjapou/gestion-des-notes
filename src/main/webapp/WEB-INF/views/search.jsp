<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:choose>
	<c:when test="${userSession == null }">
		<c:import url="/warning"></c:import>
	</c:when>
	<c:otherwise>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Résultats</title>
		</head>
		<c:import url="/resources/header.jsp"></c:import>
		<body>
			<div class="container" style="padding-top: 10% !important;">
				<div class="row">
					<div class="col-lg-12">
						<div aria-label="breadcrumb">
						  <ol class="breadcrumb">
						    <li class="breadcrumb-item"><a href="/gnote/dashboard">Tableau de bord</a></li>
		    				<li class="breadcrumb-item active" aria-current="page">Résultats pour les mots <i>${key}</i></li>
						  </ol>
						</div>
					</div>
					
					<c:choose>
						<c:when test="${etudiants.size() > 0 }">
							<table class="table">
							  <thead class="thead-dark">
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Noms et Prénoms</th>
							      <th scope="col">Date de naissance</th>
							      <th scope="col">Genre</th>
							      <th scope="col">Adresse</th>
							      <th scope="col">Actions</th>
							    </tr>
							  </thead>
							  <tbody>
							  	<c:forEach items="${etudiants}" var="e" varStatus="boucle">
							      	<tr id="etu${e.id_etudiant}">
								      <td scope="row">${boucle.count}</td>
								      <td>${e.nom }</td>
								      <td>${e.date_naissance }</td>
								      <td>${e.genre }</td>
								      <td>${e.adresse }</td>
								      <td>
								      <a href="etudiants/${e.id_etudiant }" class="btn edit"><span class="oi oi-pencil mr-sm-2" title="Modifier" aria-hidden="true"></a>
								      </td>
								    </tr>
							     </c:forEach>
							  </tbody>
							</table>
						</c:when>
						<c:otherwise>
						<div class="alert alert-danger">
							<h4>Aucun étudiant trouvé pour les mots-clés : ${key}</h4>
						</div>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${cours.size() > 0 }">
							<table class="table">
							  <thead class="thead-dark">
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Noms des cours</th>
							       <th scope="col">Nombre d'heures</th>
							      <th scope="col">Coefficient</th>
							      <th scope="col">Actions</th>
							    </tr>
							  </thead>
							    <tbody>
							  <c:forEach items="${cours}" var="c" varStatus="boucle">
							      	<tr id="etu${c.id_cours}">
								      <td scope="row">${boucle.count}</td>
								      <td>${c.intitule }</td>
								      <td>${c.nb_heure }</td>
								      <td>${c.coefficient }</td>
								     
								      <td>
								      <a href="cours/${c.id_cours }" class="btn edit"><span class="oi oi-pencil mr-sm-2" title="Modifier" aria-hidden="true"></a>
								      </td>
								    </tr>
							     </c:forEach>
							  </tbody>
							</table>
						</c:when>
						<c:otherwise>
							<br><br>
							<div class="alert alert-danger">
								<h4>Aucun cours trouvé pour les mots-clés : ${key}</h4>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</body>
	</c:otherwise>
</c:choose>
</html>