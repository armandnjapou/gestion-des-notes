<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tableau de bord</title>
		<c:import url="/resources/includes.jsp"></c:import>
	</head>
	<body id="page-top">
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/gnote/dashboard">Gestion des notes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/gnote/etudiants">Etudiants</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/gnote/cours">Cours</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="/gnote/notes">Notes</a>
            </li>
          </ul>
        </div>
        <div class="ml-sm-4">
			<form class="form-inline" action="#" method="get">
			    <input name="q" class="form-control mr-sm-2" type="search" placeholder="Que cherchez vous ?" aria-label="recherche">
			    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
			</form>
        </div>
      </div>
      <a href="/gnote/disconnect"><span class="oi oi-power-standby text-white mr-sm-2" title="Déconnexion" aria-hidden="true"></span></a>
    </nav>
	</body>
</html>