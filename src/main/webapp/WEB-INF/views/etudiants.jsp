<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Etudiants</title>
</head>
<c:import url="/resources/header.jsp"></c:import>
<body>
	<div class="container" style="padding-top: 10% !important;">
		<div class="row justify-content-md-center">
			<c:choose>
				<c:when test='${msg == "OK"}'>
					<div id="ok" class="alert alert-success" role="alert">
					  Modification de ${E.nom} effectue 
					</div>
				</c:when>
			</c:choose>
			<div class="col-lg-12">
				<div aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="dashboard">Tableau de bord</a></li>
    				<li class="breadcrumb-item active" aria-current="page">Liste des étudiants</li>
				  </ol>
				</div>
			</div>
			<p><button id="a" class="btn btn-success mb-sm-2 mr-sm-2" data-toggle="collapse" data-target="#nouveau" aria-expanded="true" aria-controls="nouveau"><span class="oi oi-plus" title="Modifier" aria-hidden="true"></span></button></p>
			<p><button id="b" class="btn btn-danger mb-sm-2 mr-sm-2" data-toggle="collapse" data-target="#nouveau" aria-expanded="true" aria-controls="nouveau"><span class="oi oi-circle-x" title="Modifier" aria-hidden="true"></span></button></p>
			<div class="collapse" id="nouveau">
				<div class="card card-body mb-sm-2">
					<h4>Informations du nouvel étudiant</h4>
					<form:form action="#" method="post" commandName="etudiant">
						<div class="form-group">
							<form:label path="nom">Noms et prénoms</form:label>
							<form:input type="text" path="nom" cssClass="form-control" required="true" id="nom" />
						</div>
						<div class="form-group">
							<form:label path="date_naissance">Date de naissance</form:label>
							<form:input type="date" path="date_naissance" cssClass="form-control" required="true" id="date_naissance" />
						</div>
						<div class="form-group">
							<form:label path="genre">Genre</form:label>
							<form:select id="genre" path="genre" cssClass="form-control">
								<form:option value="Masculin" selected="true">Masculin</form:option>
								<form:option value="Feminin">Feminin</form:option>
							</form:select>
						</div>
						<div class="form-group">
							<form:label path="adresse">Adresse</form:label>
							<form:input type="text" path="adresse" cssClass="form-control" required="true" id="adresse" />
						</div>
						<button type="submit" class="btn btn-warning">Envoyer</button>
					</form:form>
				</div>
			</div>
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
			      	<tr>
				      <td scope="row">${boucle.count}</td>
				      <td>${e.nom }</td>
				      <td>${e.date_naissance }</td>
				      <td>${e.genre }</td>
				      <td>${e.adresse }</td>
				      <td>
				      <a href="etudiants/${e.id_etudiant }" class="btn edit"><span class="oi oi-pencil mr-sm-2" title="Modifier" aria-hidden="true"></a>
				      <a href="${e.id_etudiant}|${e.nom }" class="btn remove" data-toggle="modal" data-target="#modal"><span class="oi oi-trash mr-sm-2" title="Supprimer" aria-hidden="true"></a>
				      </td>
				    </tr>
			     </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="modalLabel"></h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="modalBody">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary">Oui</button>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Non</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script>
		$(function(){
			$('#b').hide();
			$('#a').click(function(){
				$('#b').show();
				$(this).hide();
			});
			$('#b').click(function(){
				$('#a').show();
				$(this).hide();
			});
			
			
			$('.remove').each(function(){
				$(this).click(function(){
					var texte = $(this).attr('href');
					var tab = texte.split('|');
					$('#modalLabel').text("Suppression de "+ tab[1]);
					$('#modalBody').text("Voulez vraiment supprimer cet étudiant ?");
				});
			});
			
			$('#ok').fadeOut(2000);
		});
	</script>
</body>
</html>