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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Modification cours</title>
		</head>
		<c:import url="/resources/header.jsp"></c:import>
		<body>
		
		
		<div class="container">
				<div class="row justify-content-md-center" style="padding-top: 10% !important;">
					<div class="col-lg-12">
						<div aria-label="breadcrumb">
						  <ol class="breadcrumb">
						    <li class="breadcrumb-item"><a href="/gnote/dashboard">Tableau de bord</a></li>
						    <li class="breadcrumb-item"><a href="/gnote/cours">Liste des Cours</a></li>
		    				<li class="breadcrumb-item active" aria-current="page">Modification de ${C.intitule }</li>
						  </ol>
						</div>
					</div>
					<div class="col-lg-6 col-lg-auto bg-dark text-white rounded">
					<center><h4 class="mt-sm-2">Modification de ${C.intitule }</h4></center>
					<form:form action="#" method="post" commandName="cours">
						<div class="form-group">
							<form:label path="intitule">Noms Cours</form:label>
							<form:input type="text" path="intitule" cssClass="form-control" value="${C.intitule }" required="true" id="intitule" />
						</div>
						<div class="form-group">
							<form:label path="nb_heure">Nombre d'heures</form:label>
							<form:input type="nb_heure" value="${C.nb_heure }" path="nb_heure" cssClass="form-control" required="true" id="nb_heure" />
						</div>
						
						<div class="form-group">
							<form:label path="coefficient">Coefficient</form:label>
							<form:input type="text" value="${C.coefficient}" path="coefficient" cssClass="form-control" required="true" id="coefficient" />
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