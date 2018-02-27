<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:choose>
	<c:when test="${userSession == null }">
		<c:import url="/warning"></c:import>
	</c:when>
	<c:otherwise>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Modifier Notes</title>
		</head>
		<c:import url="/resources/header.jsp"></c:import>
		<body>
		<div class="container">
				<div class="row justify-content-md-center" style="padding-top: 10% !important;">
					<div class="col-lg-12">
						<div aria-label="breadcrumb">
						  <ol class="breadcrumb">
						    <li class="breadcrumb-item"><a href="/gnote/dashboard">Tableau de bord</a></li>
						    <li class="breadcrumb-item"><a href="/gnote/notes">Gestion des notes</a></li>
		    				<li class="breadcrumb-item active" aria-current="page">Notes de ${EN.etudiant.nom}</li>
						  </ol>
						</div>
					</div>
					<div class="col-lg-10 col-lg-auto rounded">
					<center><h4 class="mt-sm-2">Notes de ${EN.etudiant.nom}</h4></center>
					<form action="/gnote/editNotes" method="post">
						<table class="table">
							<thead>
								<tr>
									<td scope="col">Cours suivis</td>
									<c:forEach items="${cours}" var="c">
										<td>${c.intitule}</td>
									</c:forEach>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Notes obtenues</td>
									<c:forEach items="${EN.notes}" var="note" varStatus="i">
										<td>
											<c:choose>
												<c:when test='${note == "/"}'>
													<input type="number" step="any" name="note${i.count}" class="form-control" required="true">
												</c:when>
												<c:otherwise>
													<input type="number" required="true" step="any" value="${note}" name="note${i.count}" class="form-control">
												</c:otherwise>
											</c:choose>
										</td>
									</c:forEach>
								</tr>
							</tbody>
						</table>
						<input type="hidden" name="taille" value="${EN.notes.size()}" />
						<input type="hidden" name="id_etudiant" value="${EN.etudiant.id_etudiant}" />
						<button type="submit" class="btn btn-warning mb-sm-2">Valider</button>
					</form>
					</div>
				</div>
			</div>
		</body>
	</c:otherwise>
</c:choose>
</html>