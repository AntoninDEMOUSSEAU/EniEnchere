<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<title>Register Page</title>
</head>
<body>
<%@ include file="Header.jsp" %>




	<div class="container-sm-flex pt-5 mx-auto col-8  ">
	<h1> Créer un compte</h1>
		<form method="post" action="${pageContext.request.contextPath}/RegisterServlet" >
				<div class="form-row row align-items-center">
					<div class="">
						<label>Pseudo </label> 
						<input type="text" class="form-control" name="pseudo" placeholder="">
					</div>
					<div class="">
						<label>Nom</label> <input type="text" class="form-control" name="nom" placeholder=" ">
					</div>
					<div class="">
						<label>Prenom </label> <input type="text" class="form-control" name="prenom" placeholder="">
					</div>
				</div>
				<div class="">
					<label>Email </label> 
					<input type="email" class="form-control" name="email" placeholder=""> 
				</div>	
				
				<div class="">
					<label>Téléphone </label> 
					<input type="number" class="form-control" name="telephone" placeholder=""> 
				</div>	
					<div class="">
						<div class="">
						<label>Rue</label> 
						<input type="text" class="form-control" name="rue">
						</div>	
					</div>
					<div class="">
						<div class="">
						<label>Code Postal</label> 
						<input type="text" class="form-control" name="codePostal">
						</div>	
					</div>
					<div class="">
						<div class="">
						<label>Ville</label> 
						<input type="text" name="ville" class="form-control" name="ville" >
						</div>	
					</div>
					
					<div class=" ">
						<label>Créer votre mot de passe</label> <input
							class="form-control" type="password" name="password">
					</div>
					
					<div class="mb-3">
						<label>Confirmez votre mot de passe</label> <input
							class="form-control" type="password" name="confirm_password">
					</div>
				

					<div class="form-row">
						<button type="submit" class="btn btn-primary btn-block">Créer</button>
						<button type="submit" class="btn btn-primary btn-block">Annuler</button>
					
					</div>
			
			
			<div class="border-top card-body text-center">
				Vous avez déjà un compte ? <a
					href="<%=request.getContextPath()%>/LoginServlet ">Connectez-vous</a>
			</div>
	
	</form>
	</div>
</body>
</html>
