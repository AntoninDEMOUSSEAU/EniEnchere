<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <h3>PC Gamer pour travailler</h3>
                <img src="https://via.placeholder.com/500x200" alt="">
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <p>Description : Lorem ipsum dolor sit amet consectetur adipisicing elit. Maiores eveniet quod adipisci ex aliquid repellendus!</p>
                <p>Catégorie : Informatique</p>
                <p>Meilleur offre : 210 pts par Bob</p>
                <p>Mise à prix : 185 points</p>
                <p>Retrait : 10 allée des alouettes 44800 Saint Herblain</p>
                <p>Vendeur: jojo44</p>
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

             
                  <button type="submit" class="btn btn-primary">Back</button>
            </div>
        </div>
    </div>
</body>
</html>