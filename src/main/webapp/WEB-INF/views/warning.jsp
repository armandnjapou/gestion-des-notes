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
        </button></nav>
	</body>
	<header class="bg-danger text-white">
      <div class="container text-center">
        <h1>Il semblerait qu'il y ait un problème</h1>
        <p class="lead">Veuillez vous connecter pour accéder à cette section</p>
        <a href="/gnote">Connectez vous</a>
      </div>
    </header>
</html>