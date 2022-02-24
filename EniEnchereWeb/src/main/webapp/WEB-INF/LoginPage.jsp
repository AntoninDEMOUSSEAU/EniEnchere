<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>Page de connection</title>
</head>
<body>
	<%@ include file="Header.jsp" %>
	<!------ Include the above in your HEAD tag ---------->
<div class="container"> 
	<div class="wrapper fadeInDown">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	    
	     <c:if test="${ !empty sessionScope.ErrorLogin }">
        	<div class="alert alert-danger">${sessionScope.ErrorLogin }</div>
    	</c:if>
	
	    <!-- Login Form -->
	    <form method="post" action="<%= request.getContextPath() %>/LoginServlet">
	      <input type="text" id="login" class="fadeIn second" name="email" placeholder="Nom d'utilisateur" value="${error}">
	      <input type="text" id="password" class="fadeIn third" name="password" placeholder="Mot de passe">
	      <input class="col" type="submit" class="fadeIn fourth" value="Se Connecter">
	    </form>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a class="underlineHover" href="<%=request.getContextPath()%>/ForgottenPasswordServlet ">Mot de Passe oubliée ?</a><br>
	      <a class="underlineHover" href="<%=request.getContextPath()%>/RegisterServlet ">Créer un compte</a>
	    </div>
	
	  </div>
	  
	 <c:set var="ErrorLogin" value="" scope="session" />
</div>
</div>
</body>
</html>