<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Modifier l'enchere</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%@ include file="Header.jsp" %>
<div class="container">
<h1> Modifier mon Enchere </h1>
<form method="post"  action="${pageContext.request.contextPath}/ModifyBidServlet">
		<div class="form-row row align-items-center">
			<div class="">
				<label>Nom Article </label> 
				<input type="text" class="form-control" name="nomArticle" value="${article.getNomArticle()}" >
			</div>
			
			   <label for="categories" class="col-sm-2 col-form-label">Catégories</label>
         
         <div class="col-sm-10">
             <select class="form-select" name="nocategorie" aria-label="Default select example">                        
                 <c:forEach items="${listeCategorie}" var="categorie">
                 	<option value="${categorie.getNoCategorie()}">${categorie.getLibelle()}</option>
                 </c:forEach>
             </select>
   		</div>
		<div class="mb-3">
	  		<label for="exampleFormControlTextarea1" class="form-label">Description</label>
	  		<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description" value="${article.getDescription()}"></textarea>
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
		<input type="number" value="150" name="prixinitial" value="${article.getPrixVente()}">        
	</div>
	<label for="prixinitial" class="col-sm-2 col-form-label">Début de l'enchère : </label>
	<div class="col-sm-10">
		<input type="text" name="debutenchere" value="${article.getDatedebutEncheres()}">        
	</div>
	<label for="prixinitial" class="col-sm-2 col-form-label">Fin de l'enchère : </label>
	<div class="col-sm-10">
		<input type="text" name="finenchere" value="${article.getDateFinEncheres()}">        
	</div>	

	    <div class="col">
	      Retrait :
	    </div>
	    <div class="col">
	      5 rue des Pinsons, 44000 Nantes
	    </div>
	
		<button type="submit" class="btn btn-primary p-2 m-2">Enregistrer</button>
		<a href="<%=request.getContextPath()%>/AccountServlet " class="btn btn-primary btn-lg active m-2" role="button" aria-pressed="true">Retour</a>
	</div>  
	</form>
</div>
</body>
</html>