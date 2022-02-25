<%@page import="fr.eni.enchere.bo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
  
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>Account</title>
</head>
<body>

<%@ include file="Header.jsp" %>
<div class="container">
<h1>${utilisateur.getPseudo()} </h1>
	<form method="get"  action="${pageContext.request.contextPath}/ModifyAccountPage">
			<div class="form-row row align-items-center">
				<div class="">
					<label>Pseudo </label> 
					<input type="text"  value="${utilisateur.getPseudo()}" class="form-control" placeholder="" disabled >
				</div>
				<div class="">
					<label>Nom</label> 
					<input type="text" value="${utilisateur.getNom()}" class="form-control" placeholder=" " disabled>
				</div>
				<div class="">
					<label>Prenom </label> 
					<input type="text"  value="${utilisateur.getPrenom()}" class="form-control" placeholder="" disabled>
				</div>
			</div>
			<div class="">
				<label>Email </label> 
				<input type="email" value="${utilisateur.getEmail()}" class="form-control" placeholder="" disabled> 
			</div>	
			<div class="">
				<label>Telephone </label> 
				<input type="text" value="${utilisateur.getTelephone()}" class="form-control" placeholder="" disabled> 
			</div>	
				<div class="">
					<div class="">
					<label>Rue</label> 
					<input type="text" value="${utilisateur.getNomRue()}" class="form-control" disabled>
					</div>	
				</div>
				<div class="">
					<div class="">
					<label>Code Postal</label> 
					<input type="text" value="${utilisateur.getCodePostale()}" class="form-control" disabled>
					</div>	
				</div>
				<div class="">
					<div class="">
					<label>Ville</label> 
					<input type="text" value="${utilisateur.getVille()}" class="form-control" disabled>
					</div>	
				</div>
				
			
				<div class="form-row">
					<button type="submit" class="btn btn-primary btn-lg active">Modifier</button>
					<a href="<%=request.getContextPath()%>/" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Retour</a>
				
				</div>
	</form>
</div>	
</body>
</html>