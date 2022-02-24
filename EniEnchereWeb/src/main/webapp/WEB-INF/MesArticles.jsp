<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mes articles</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<%@ include file="Header.jsp" %>

	<div class="container">
		
		<c:forEach items="${listeArticleByUser}" var="article" >
			<div class="row mt-3">
		            <div class="col-12">
		                <div class="card mb-3" style="max-width: 540px;">
		     
		                        <div class="card-body">
		                        <div class="col-12">
					                <h5 class="card-title"><a href="<%= request.getContextPath() %>/BidDetail?id=${article.getNoArticle()}"> ${article.getNomArticle()}</a></h5>
					                <img src="https://via.placeholder.com/500x200" alt="">
					            </div>
					      			
						      	  <div class="row">
						            <div class="col-12">
						                <p>Description :${article.getDescription()}  </p>
						                <p>Catégorie :${article.getCategorie().getLibelle()} </p>
						                <p>Meilleur offre : ${article.getEnchere().getMontantEnchere()}</p>
						                <p>Mise à prix : ${article.getPrixVente()}</p>
						                <p>Retrait : ${article.getRetrait().getCodePostal()} ${article.getRetrait().getNomRue()} à ${article.getRetrait().getVille()}</p>
						                <p>Vendeur: ${article.getUtilisateur().getPseudo()}</p>
						            </div>
		                       	</div>
		                    
		                  </div>
		            </div>
		        </div>
		</c:forEach>
	</div>	
		
</body>
</html>