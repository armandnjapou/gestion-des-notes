<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
		<c:import url="/resources/includes.jsp"></c:import>
	</head>
	<body>
		<div class="container">
			<div class="row justify-content-md-center" style="padding-top: 10% !important;">
		  		<div class="col-lg-6 col-lg-auto bg-dark text-white rounded">
		    		<center>
		    			<!-- <img alt="logo" class="img-fluid" src="<c:url value="/resources/images/logo GN.png" />"> -->
		    			<h2 class="center">Connectez vous</h2>
		    		</center>
		    		<c:choose>
						<c:when test='${msg == "Error"}'>
							<div class="alert alert-danger" role="alert">
							  Adresse email et/ou mot de passe incorrect !
							</div>
						</c:when>
					</c:choose>
		    		<form:form action="#" method="post" commandName="user">
		    			<div class="form-group">
							<form:label path="login">Email</form:label>
							<form:input required="true" path="login" type="email" name="email" cssClass="form-control" id="email" aria-describedby="emailHelp" placeholder="Votre email" />
							<small id="emailHelp" class="form-text text-muted">Votre adresse email reste confidentielle.</small>
 						</div>
						  <div class="form-group">
						    <form:label path="password">Mot de passe</form:label>
						    <form:input required="true" path="password" type="password" name="password" cssClass="form-control" id="password" placeholder="Mot de passe" />
						  </div>
						  <a href="forgotPassword" >Mot de passe oublié ?</a><br><br>
						  <button type="submit" class="btn btn-outline-success">Submit</button>
		    		</form:form>
		  		</div>
		 	</div>
		</div>
	</body>
</html>
