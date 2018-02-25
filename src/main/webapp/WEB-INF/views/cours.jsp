<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<title>Gestion des Cours</title>
		</head>
		<c:import url="/resources/header.jsp"></c:import>
		<body>
		<div class="container" style="padding-top: 10% !important;">
			<div class="row">
				<c:choose>
					<c:when test='${msg == "OK"}'>
						<div id="ok" class="alert alert-success" role="alert">
						  Modification de ${C.intitule} effectue 
						</div>
					</c:when>
				</c:choose>
				<div id="del" class="alert alert-danger" role="alert"></div>
				<div class="col-lg-12">
					<div aria-label="breadcrumb">
					  <ol class="breadcrumb">
					    <li class="breadcrumb-item"><a href="dashboard">Tableau de bord</a></li>
	    				<li class="breadcrumb-item active" aria-current="page">Gestion des Cours</li>
					  </ol>
					</div>
				</div>
				<p><button id="a" class="btn btn-success mb-sm-2 mr-sm-2" data-toggle="collapse" data-target="#nouveau" aria-expanded="true" aria-controls="nouveau"><span class="oi oi-plus" title="Modifier" aria-hidden="true"></span></button></p>
				<p><button id="b" class="btn btn-danger mb-sm-2 mr-sm-2" data-toggle="collapse" data-target="#nouveau" aria-expanded="true" aria-controls="nouveau"><span class="oi oi-circle-x" title="Modifier" aria-hidden="true"></span></button></p>
				<div class="collapse" id="nouveau">
					<div class="card card-body mb-sm-2">
						<h4>Information du nouveau cours </h4>
						<form:form action="#" method="post" commandName="cours">
							<div class="form-group">
								<form:label path="intitule">Intitulé</form:label>
								<form:input type="text" path="intitule" cssClass="form-control" required="true" id="intitule" />
							</div>
							<div class="form-group">
								<form:label path="nb_heure">Nombre d'heures</form:label>
								<form:input type="number" path="nb_heure" cssClass="form-control" required="true" id="nb_heure" />
							</div>
							
							<div class="form-group">
								<form:label path="coefficient">Coefficient</form:label>
								<form:input type="number" path="coefficient" cssClass="form-control" required="true" id="coefficient" />
							</div>
							<button type="submit" class="btn btn-warning">Envoyer</button>
						</form:form>
					</div>
				</div>
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
				  <c:forEach items="${listeCours}" var="c" varStatus="boucle">
				      	<tr id="etu${c.id_cours}">
					      <td scope="row">${boucle.count}</td>
					      <td>${c.intitule }</td>
					      <td>${c.nb_heure }</td>
					      <td>${c.coefficient }</td>
					     
					      <td>
					      <a href="cours/${c.id_cours }" class="btn edit"><span class="oi oi-pencil mr-sm-2" title="Modifier" aria-hidden="true"></a>
					      <a href="${c.id_cours}|${c.intitule }" class="btn remove" data-toggle="modal" data-target="#modal"><span class="oi oi-trash mr-sm-2" title="Supprimer" aria-hidden="true"></a>
					      </td>
					    </tr>
				     </c:forEach>
				  </tbody>
				</table>
		
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
		        <button type="button" id="delete" class="btn btn-primary" data-dismiss="modal">Oui</button>
		        <button type="button" id="close" class="btn btn-secondary" data-dismiss="modal">Non</button>
		      </div>
		    </div>
		  </div>
		</div>
		<script>
			$(function(){
				$('#b').hide();
				$('#del').hide();
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
						$('#modalBody').text("Voulez vraiment supprimer ce Cours ?");
						$('#delete').click(function(){
							var id = tab[0];
							var adresse = "supprimerCours/"+id;
							$.ajax({
								type: 'GET',
								url : adresse,
								success: function(data){
									$('#del').text("Le cours "+data.intitule+" a été supprimé avec succuès !");
									$('#del').fadeIn(2000);
									$('#del').fadeOut(2000);
									//window.setTimeout(location.reload(true), 5000);
									location.reload(true);
									//$('#cou'+data.id_cours).hide();
								},
								error: function(){
									alert("Error occured !");
								}
							});
						});
					});
				});
				
				$('#ok').fadeOut(2000);
			});
		</script>
		</body>
	</c:otherwise>
</c:choose>
	
</html>