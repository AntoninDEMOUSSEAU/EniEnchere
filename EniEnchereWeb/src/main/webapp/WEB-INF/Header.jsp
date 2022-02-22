<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.enchere.bo.*" %>


<header class="row align-items-center mb-3 ">
<div class="col">
	<a href="<%= request.getContextPath() %>/HomePageServlet"><img src="https://i.ibb.co/w7wz00P/LogoEni.png" width=75%></a>
</div>
<div class="col row justify-content-end">
	<c:choose>
		<c:when test='${not empty sessionScope["idUtilisateur"]}'>
			<div class="d-flex align-items-end">
				<ul class="">
				 <li class="nav-item">
				    <a class="nav-link" href="<%= request.getContextPath() %>/LogoutServlet">Se Deconnecter</a>
				  </li>
				  <li class="">
				    <a class="nav-link active" href="<%= request.getContextPath() %>/AccountServlet">Mon Compte</a>
				  </li>
				</ul>
			</div>
		</c:when>
		

		<c:otherwise>
				<div class="d-flex align-items-end">
				<ul class="nav nav-pills">
				  <li class="nav-item">
				    <a class="nav-link active" href="<%= request.getContextPath() %>/RegisterServlet">S'inscrire</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="<%= request.getContextPath() %>/LoginServlet">Se Connecter</a>
				  </li>
				</ul>
			</div>
		</c:otherwise>	
	</c:choose>

</div>


</header>
		
   
		