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
		<title>Notes des étudiants en ${C.intitule}</title>
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
		    				<li class="breadcrumb-item active" aria-current="page">Notes des étudiants en ${C.intitule}</li>
						  </ol>
						</div>
					</div>
					<div class="col-lg-10 col-lg-auto rounded">
					<center><h4 class="mt-sm-2">Notes des étudiants en ${C.intitule}</h4></center>
					<form action="/gnote/editNotesCours" method="post">
						<table class="table">
							<thead>
								<tr>
									<td scope="col">Etudiants</td>
									<td scope="col">Notes obtenues</td>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${EN}" var="en" varStatus="i">
								<tr>
									<td>${en.etudiant.nom}</td>
									<td>
										<c:choose>
											<c:when test='${en.note == "/"}'>
												<input required="true" type="number" step="any" name="note${i.count}" class="form-control">
											</c:when>
											<c:otherwise>
												<input type="number" required="true" step="any" value="${en.note}" name="note${i.count}" class="form-control">
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<input type="hidden" name="taille" value="${EN.size()}" />
						<input type="hidden" name="id_cours" value="${C.id_cours}" />
						<button type="submit" class="btn btn-outline-success mb-sm-2">Valider</button>
					</form>
					</div>
				</div>
			</div>
		</body>
	</c:otherwise>
</c:choose>
</html>