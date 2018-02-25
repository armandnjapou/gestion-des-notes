<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<c:choose>
	<c:when test="${userSession == null }">
		<c:import url="/warning"></c:import>
	</c:when>
	<c:otherwise>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tableau de bord</title>
		<c:import url="/resources/includes.jsp"></c:import>
	</head>
	<body id="page-top">
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Gestion des notes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="etudiants">Etudiants</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="cours">Cours</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="notes">Notes</a>
            </li>
          </ul>
        </div>
        <div class="ml-sm-4">
			<form class="form-inline" action="search" method="get">
			    <input name="q" class="form-control mr-sm-2" type="search" placeholder="Que cherchez vous ?" aria-label="recherche">
			    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
			</form>
        </div>
      </div>
      <a href="disconnect"><span class="oi oi-power-standby text-white mr-sm-2" title="Déconnexion" aria-hidden="true"></span></a>
    </nav>
    
    <header class="bg-success text-white">
      <div class="container text-center">
        <h1>Bienvenue sur la plateforme de gestion des notes</h1>
        <p class="lead">Cette plateforme assure le suivi de vos évaluations et de vos cours</p>
      </div>
    </header>
    
	<div class="row mt-4 mr-2 ml-2">
	  <div class="col-sm-4">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Etudiants</h5>
	        <p class="card-text">Ajouter, rechercher, modifier, supprimer, consulter les informations sur les étudiants.</p>
	        <a href="etudiants" class="btn btn-outline-success">Commencer</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-4">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Cours</h5>
	        <p class="card-text">Ajouter, rechercher, modifier, supprimer, consulter les informations sur les cours.</p>
	        <a href="cours" class="btn btn-outline-success">Commencer</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-4">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Notes</h5>
	        <p class="card-text">Ajouter, rechercher, modifier, supprimer, consulter les informations sur les notes des étudiants.</p>
	        <a href="notes" class="btn btn-outline-success">Commencer</a>
	      </div>
	    </div>
	  </div>
	</div>
    
	</body>
	</c:otherwise>
</c:choose>
</html>