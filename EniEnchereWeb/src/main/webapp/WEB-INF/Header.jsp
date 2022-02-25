
<header class="row align-items-center mb-3 ">
	
	<c:choose>
		<c:when test='${not empty sessionScope["idUtilisateur"]}'>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="<%= request.getContextPath() %>/"><img src="https://i.ibb.co/w7wz00P/LogoEni.png" width=75%></a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>//MesArticles">Mes articles </a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" href="<%= request.getContextPath() %>/NewSale">Vendre un article</a>
			        </li>
			        <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            Mon Compte
			          </a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/AccountServlet">Mes informations</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="<%= request.getContextPath() %>/LogoutServlet">Se Deconnecter</a></li>
			          </ul>
			        </li>
			       </div>
			  </div>
			</nav>
		</c:when>
			
			
		

		<c:otherwise>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="container-fluid">
			    <a class="navbar-brand" href=""<%= request.getContextPath() %>/HomePageServlet"><img src="https://i.ibb.co/w7wz00P/LogoEni.png" width=75%></a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath() %>/RegisterServlet">S'inscrire</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="<%= request.getContextPath() %>/LoginServlet">Se Connecter</a>
			        </li>
			      </div>
			  </div>
			</nav>
	
		</c:otherwise>	
	</c:choose>



</header>
		
   
		