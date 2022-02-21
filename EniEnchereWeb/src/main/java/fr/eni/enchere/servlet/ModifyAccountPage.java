package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;

/**
 * Servlet implementation class AccountPage
 */
@WebServlet("/ModifyAccountPage")
public class ModifyAccountPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager utilisateurManager = new UtilisateurManager();
        Utilisateur utilisateur = null;
        
		HttpSession session = request.getSession();
		
        int id = (int) session.getAttribute("idUtilisateur");
	
        try {
        	
			utilisateur=utilisateurManager.AfficherCompteUtilisateurById(id);
			
			request.setAttribute("utilisateur", utilisateur);
			
		} catch (DALException e) {
			e.printStackTrace();
		}
        
		getServletContext().getRequestDispatcher("/WEB-INF/ModifyAccountPage.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		HttpSession session = request.getSession();
		
        int id = (int) session.getAttribute("idUtilisateur");
		Utilisateur utilisateur = null;
		
		
		try {
		utilisateur = utilisateurManager.AfficherCompteUtilisateurById(id);
		
		
		utilisateur.setNoUtilisateur(id);
        utilisateur.setPseudo((String) request.getParameter("pseudo"));
		utilisateur.setNom((String)request.getParameter("nom"));
		utilisateur.setPrenom((String)request.getParameter("prenom"));
		utilisateur.setEmail((String)request.getParameter("email"));
		utilisateur.setTelephone((String)request.getParameter("telephone"));
		utilisateur.setNomRue((String)request.getParameter("nomRue"));
		utilisateur.setCodePostale((String)request.getParameter("codePostal"));
		utilisateur.setVille((String) request.getParameter("ville"));
		utilisateur.setMotDePasse((String) request.getParameter("password"));
		utilisateur.setCredit(Integer.parseInt( request.getParameter("credit")));
		
		
		utilisateurManager.ModifyAccount(id, utilisateur);

		
		
		} catch (DALException e) {
			e.printStackTrace();
		
		}
		
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}

}
