<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-12 mt-5">
                <h1 class="title">ENI-Enchères</h1>
                <a href="<%= request.getContextPath() %>/RegisterServlet">S'inscrire</a> - <a href="<%= request.getContextPath() %>/RegisterServlet">Se connecter</a>
            </div>
        </div>
       

        <div class="row">
            <h4 class="mt-3">Filtres :</h4>
            <div class="mb-3 row">
                <label for="categories" class="col-sm-2 col-form-label">Catégories</label>
                <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example">                        
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                </div>
              </div>

            <div class="form-group">
                <input type="text" class="form-control" name="rechercher" placeholder="Le nom de l'article contient">
            </div>

            <button type="submit" class="btn btn-primary btn-lg mt-3">Rechercher</button>
        </div>
		<c:forEach items="${listeArticle}" var="article" >
			<div class="row mt-3">
		            <div class="col-12">
		                <div class="card mb-3" style="max-width: 540px;">
		                    <div class="row g-0">
		                      <div class="col-md-4">
		                        <img src="https://via.placeholder.com/250C/" class="img-fluid rounded-start" alt="...">
		                      </div>
		                      <div class="col-md-8">
		                        <div class="card-body">
		                          <h5 class="card-title">${article.getNomArticle()}</h5>
		                          <p class="card-text">Prix de départ : ${article.getPrixVente()} €</p>
		                          <p class="card-text">Date de fin d'enchère : ${article.getDateFinEncheres()}</p>
		                          <p class="card-text">Adresse de retrait : ${article.getRetrait().getCodePostal()} ${article.getRetrait().getNomRue()} à ${article.getRetrait().getVille()}</p>
		                          <p class="card-text">Vendu par ${article.getUtilisateur().getPseudo()}</p>
		                       	</div>
		                      </div>
		                    </div>
		                  </div>
		            </div>
		        </div>
		</c:forEach>
	  </div>      
</body>
</html>