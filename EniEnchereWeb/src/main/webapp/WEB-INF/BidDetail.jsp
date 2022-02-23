<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail de l'enchère</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%@ include file="Header.jsp" %>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 class="text-center">Détail vente</h2>
                <h3>${article.getNomArticle()}</h3>
                <img src="https://via.placeholder.com/500x200" alt="">
            </div>
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

        <div class="row">
            <div class="col-12">
                <div class="mb-3 row">
                    <label for="categories" class="col-4 col-form-label">Ma proposition</label>
                    <div class="col-4">
                        <select class="form-select" aria-label="Default select example">
                            <option selected>220</option>
                            <option value="1">230</option>
                            <option value="2">240</option>
                            <option value="3">250</option>
                        </select>
                    </div>

                    <div class="col-2">
                        <button type="submit" class="btn btn-primary">Enchérir</button>
                    </div>
    
                  </div>

             
                  <a href="<%=request.getContextPath()%>/HomePageServlet " class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Retour</a>
            </div>
        </div>
    </div>
</body>
</html>