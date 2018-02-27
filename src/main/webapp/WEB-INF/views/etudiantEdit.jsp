<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:choose>
	<c:when test="${userSession == null }">
		<c:import url="/warning"></c:import>
	</c:when>
	<c:otherwise>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Modification Etudiant</title>
		</head>
		<c:import url="/resources/header.jsp"></c:import>
		<body>
			<div class="container">
				<div class="row justify-content-md-center" style="padding-top: 10% !important;">
					<div class="col-lg-12">
						<div aria-label="breadcrumb">
						  <ol class="breadcrumb">
						    <li class="breadcrumb-item"><a href="/gnote/dashboard">Tableau de bord</a></li>
						    <li class="breadcrumb-item"><a href="/gnote/etudiants">Liste des étudiants</a></li>
		    				<li class="breadcrumb-item active" aria-current="page">Modification de ${E.nom }</li>
						  </ol>
						</div>
					</div>
					<div class="col-lg-6 col-lg-auto bg-dark text-white rounded">
					<center><h4 class="mt-sm-2">Modification de ${E.nom }</h4></center>
					<form:form action="#" method="post" commandName="etudiant">
						<div class="form-group">
							<form:label path="nom">Noms et prénoms</form:label>
							<form:input type="text" path="nom" cssClass="form-control" value="${E.nom }" required="true" id="nom" />
						</div>
						<div class="form-group">
							<form:label path="date_naissance">Date de naissance</form:label>
							<form:input type="date" value="${E.date_naissance }" path="date_naissance" cssClass="form-control" required="true" id="date_naissance" />
						</div>
						<div class="form-group">
							<form:label path="genre">Genre </form:label>
							<form:select id="genre" path="genre" cssClass="form-control">
								<c:choose>
									<c:when test='${E.genre == "Masculin"}'>
										<form:option value="Masculin" selected="true">Masculin</form:option>
										<form:option value="Feminin">Feminin</form:option>
									</c:when>
									<c:otherwise>
										<form:option value="Masculin">Masculin</form:option>
										<form:option value="Feminin" selected="true">Feminin</form:option>
									</c:otherwise>
								</c:choose>
								
								
							</form:select>
						</div>
						<div class="form-group">
							<form:label path="adresse">Adresse</form:label>
							<form:input type="text" value="${E.adresse}" path="adresse" cssClass="form-control" required="true" id="adresse" />
						</div>
						<button type="submit" class="btn btn-warning mb-sm-2">Envoyer</button>
					</form:form>
					</div>
				</div>
			</div>
		</body>
	</c:otherwise>
</c:choose>
</html>