<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<title>Liste des enchères</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
		<div>
			<a class="underlineHover" href="<%=request.getContextPath()%>/VendreArticleServlet ">Vendre un article</a>
			<a class="underlineHover" href="<%=request.getContextPath()%>/MonProfilServlet ">Mon Profil</a>
			<a class="underlineHover" href="<%=request.getContextPath()%>/DeconnexionServlet">Déconnexion</a>
		</div>
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
		<div class="mb-3 row">
			<label for="categories" class="col-sm-2 col-form-label">Catégories</label>
				<div class="col-sm-10">
					<select class="form-select" aria-label="Default select example">
					<option selected>Toutes</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
					<option value="4">Viva l'Algérie</option>
					</select>
				</div>
		</div>		
		<div class="form-group">
        	<input type="text" class="form-control" name="rechercher" placeholder="Le nom de l'article contient">
        </div>
            <button type="submit" class="btn btn-primary btn-lg mt-3">Rechercher</button>
        <div class="row mt-3">
            <div class="col-12">
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                      <div class="col-md-4">
                        <img src="https://via.placeholder.com/250C/" class="img-fluid rounded-start" alt="...">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">PC gamer pour travailler</h5>
                          <p class="card-text">Prix : 210 points Classement : 2</p>
                          <p class="card-text">Fin de l'enchère : 10/08/2018</p>
                          <p class="card-text">Retrait : 10 allée des Alouettes 44800 Saint Herblain</p>
                          <p class="card-text">Vendeur : jojo44</p>
                        </div>
                      </div>
                    </div>
                  </div>
            </div>
        </div>
	
</body>
</html>