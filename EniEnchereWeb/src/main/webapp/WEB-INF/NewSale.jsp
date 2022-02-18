<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Nouvelle vente</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<h2>Nouvelle vente</h2>
	<div class="form-group">
		<label for="categories" class="col-sm-2 col-form-label">Article : </label>
        <input type="text" class="form-control" name="article" placeholder="Le nom de l'article">
    </div>
	<label for="categories" class="col-sm-2 col-form-label">Catégories</label>
	    <div class="col-sm-10">
	        <select class="form-select" aria-label="Default select example" name="nocategorie">
	            <option selected>Toutes</option>
	            <option value="1">One</option>
	            <option value="2">Two</option>
	            <option value="3">Three</option>
	          </select>
	    </div>
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
	  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
	</div>
	<div>
		<label for="exampleFormControlTextarea1" class="form-label">Photo de l'article</label>
		<button type="button" class="btn btn-primary">Uploader</button>
	</div>
	<div class="p-2">	
		<img src="https://via.placeholder.com/250C/" class="img-fluid rounded-start" alt="...">		
	</div>
	<label for="prixinitial" class="col-sm-2 col-form-label">Prix initial : </label>
	<div class="col-sm-10">
		<input type="number" value="150" name="prixinitial">        
	</div>
	<label for="prixinitial" class="col-sm-2 col-form-label">Début de l'enchère : </label>
	<div class="col-sm-10">
		<input type="date" name="debutenchere">        
	</div>
	<label for="prixinitial" class="col-sm-2 col-form-label">Fin de l'enchère : </label>
	<div class="col-sm-10">
		<input type="date" name="finenchere">        
	</div>	
	<div class="container">
  	<div class="row align-items-start">
	    <div class="col">
	      Retrait :
	    </div>
	    <div class="col">
	      5 rue des Pinsons, 44000 Nantes
	    </div>
	</div>
	<div>
		<button type="button" class="btn btn-primary">Enregistrer</button>
		<button type="button" class="btn btn-primary">Annuler</button>
	</div>  
</body>
</html>