<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Bid Win</title>
	</head>
	
	<body>
	
	<%@ include file="Header.jsp" %>
	
		<h1> Vous avez remporté l'enchère </h1>
		
		<div class="p-2">
			<h2>PC Gamer pour travailler</h2> <!-- h2 récupérera le nom de l'article -->
			<img src="https://via.placeholder.com/250C/" class="img-fluid rounded-start" alt="...">		</div>
		<div class="p-2">
			<label>Meilleure offre: </label>
			<input type="text" class="form-control" placeholder=" " disabled>
		</div>
		<div class="p-2">
			<label>Mise à prix: </label>
			<input type="text" class="form-control" placeholder=" " disabled>
		</div>
		
		<div class="card col-10 m-2" >
		 	<div class="card-header">Retrait</div>
		  	<div class="card-body">
			    <p class="card-text">10, allée des Alouette</p> <!-- Il faudra récupérer l'adresse de l'utilisateur qui a gagné l'enchere -->
				<p class="card-text">44800 Saint Herblain</p> 
				
			</div>
			<div class="p-2">
				<label>Vendeur: </label>
				<input type="text" class="form-control" placeholder="Jojo44 " disabled>
			</div>
			<div class="p-2">
				<label>Tel: </label>
				<input type="text" class="form-control" placeholder="0606066006 " disabled>
			</div>
		</div>
		
		<div class="form-row m-3">
				<button type="submit" class="btn btn-primary btn-block">Retrait effectué</button>
				
			
		</div>
	
		
	
	</body>
	
</html>