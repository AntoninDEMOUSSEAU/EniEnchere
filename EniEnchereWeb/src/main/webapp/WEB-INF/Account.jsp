<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>Account</title>
</head>
<body>


<h1> Mon Pseudo </h1>
	<form>
			<div class="form-row row align-items-center">
				<div class="">
					<label>Pseudo </label> 
					<input type="text" value="" class="form-control" placeholder="" disabled >
				</div>
				<div class="">
					<label>Nom</label> 
					<input type="text" value="" class="form-control" placeholder=" " disabled>
				</div>
				<div class="">
					<label>Prenom </label> 
					<input type="text"  value="" class="form-control" placeholder="" disabled>
				</div>
			</div>
			<div class="">
				<label>Email </label> 
				<input type="email" value="" class="form-control" placeholder="" disabled> 
			</div>	
				<div class="">
					<div class="">
					<label>Rue</label> 
					<input type="text" value="" class="form-control" disabled>
					</div>	
				</div>
				<div class="">
					<div class="">
					<label>Code Postal</label> 
					<input type="text" value="" class="form-control" disabled>
					</div>	
				</div>
				<div class="">
					<div class="">
					<label>Ville</label> 
					<input type="text" value="" class="form-control" disabled>
					</div>	
				</div>
				
			
				<div class="form-row">
					<button type="submit" class="btn btn-primary btn-block">Modifier</button>
					<button type="submit" class="btn btn-primary btn-block">Retour</button>
				
				</div>
	</form>
</body>
</html>