package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.enchere.bll.UtilisateurManager;

import fr.eni.echere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/RegisterPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ajouter confirm password, administrateur dans le formulaire
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		int telephone =  Integer.parseInt(request.getParameter("telephone"));
		String nomRue = request.getParameter("rue");
		int codePostal= Integer.parseInt(request.getParameter("codePostal"));
		String ville= request.getParameter("ville");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirm_password");
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setNomRue(nomRue);
		utilisateur.setCodePostale(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(password);
	
		utilisateurManager.Register(utilisateur);
		
		response.sendRedirect(request.getContextPath() + "/LoginPage");
	}

}
