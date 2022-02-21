<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<title>Modify Account Page</title>
</head>
<body>
<h1> Modifier mon profil </h1>
<form method="post"  action="${pageContext.request.contextPath}/ModifyAccountPage">
		<div class="form-row row align-items-center">
			<div class="">
				<label>Pseudo </label> 
				<input type="text" class="form-control" name="pseudo" value="${utilisateur.getPseudo()}" >
			</div>
			
			<div class="">
				<label>Nom</label> 
				<input type="text" class="form-control" name="nom" value="${utilisateur.getNom()}">
			</div>
			
			<div class="">
				<label>Prenom </label> 
				<input type="text" class="form-control" name="prenom" value="${utilisateur.getPrenom()}" >
			</div>
			
			
			<div class="">
				<label>Email </label> 
				<input type="email" class="form-control" name="email" value="${utilisateur.getEmail()}" > 
			</div>	
			
			<div class="">
				<label>Telephone </label> 
				<input type="text" class="form-control" name="telephone" value="${utilisateur.getTelephone()}" > 
			</div>	
				
			<div class="">
				<label>Rue</label> 
				<input type="text" class="form-control" name="nomRue" value="${utilisateur.getNomRue()}" >
			</div>	
			
			
			<div class="">
				<label>Code Postal</label> 
				<input type="text" class="form-control" name="codePostal" value="${utilisateur.getCodePostale()}" >
			</div>	
			
			<div class="">
				<div class="">
				<label>Ville</label> 
				<input type="text" class="form-control" name="ville" value="${utilisateur.getVille()}">
				</div>	
			</div>
				
			<div class=" ">
					<label>Modifier votre mot de passe</label> 
					<input class="form-control" type="password" name="password" value="${utilisateur.getMotDePasse()}">
			</div>
					
			<div class="mb-3">
				<label>Confirmez votre mot de passe</label> <input
					class="form-control" type="text" name="confirm_password" value="${utilisateur.getMotDePasse()}">
			</div>	
			
			<div class="mb-3">
				<label>Crédit</label> <input
					class="form-control" type="text" name="credit" value="${utilisateur.getCredit()}">
			</div>	
			
		
			<div class="form-row">
				<a href="<%=request.getContextPath()%>/AccountServlet " class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Retour</a>
				<a href="<%=request.getContextPath()%>/DeleteAccountServlet " class="btn btn-danger btn-lg active" role="button" aria-pressed="true">Supprimer mon compte</a>
				<button type="submit" class="btn btn-primary btn-lg active">Enregistrer</button>
			</div>
		</div>
	</form>
</body>
</html>
