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

<%@ include file="Header.jsp" %>

	<div class="container">
		<c:if test='${not empty sessionScope["idUtilisateur"]}'>
        <div class="row">
            <h2>Filtres : </h2>		
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
		  <label class="form-check-label" for="flexRadioDefault1">Achats</label>    
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Enchère ouvertes
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Mes enchères en cours
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Mes enchères remportées
			  </label>
			</div>
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
		  <label class="form-check-label" for="flexRadioDefault1">Mes ventes</label>    
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Mes ventes en cours
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Ventes non débutées
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
			  <label class="form-check-label" for="defaultCheck1">
			    Ventes terminées
			  </label>
			</div>
		</div>
		</c:if>
		
		<form action="" method="post">
			            <div class="mb-3 row">
                <label for="categories" class="col-sm-2 col-form-label">Catégories</label>
              
               		
                <div class="col-sm-10">
                    <select class="form-select" name="categorie" aria-label="Default select example">                        
                        <c:forEach items="${listeCategorie }" var="categorie">
                        	<option value="${categorie.getNoCategorie()}">${categorie.getLibelle()}</option>
                        </c:forEach>
                        
                      </select>
                </div>
              </div>

            <div class="form-group">
                <input type="text" class="form-control" name="rechercher" placeholder="Le nom de l'article contient">
            </div>

            <button type="submit" class="btn btn-primary btn-lg mt-3">Rechercher</button>
		</form>
		
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
		                         <h5 class="card-title"><a href="<%= request.getContextPath() %>/BidDetail?id=${article.getNoArticle()}"> ${article.getNomArticle()}</a></h5>
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
</body>
</html>