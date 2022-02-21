package fr.eni.enchere.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("idUtilisateur") != null) {
			response.sendRedirect(request.getContextPath() + "/BidPageServlet");
		} else {
			getServletContext().getRequestDispatcher("/WEB-INF/LoginPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// R�cup�rer les donn�es passer dans le formulaire
		
		HttpSession session = request.getSession();
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utilisateur currentUser = null;
		boolean error = false; 
				
		UtilisateurManager manager = new UtilisateurManager();
	
	
		try {
			
			currentUser = manager.LoginByEmail(email, password);
			
			if (currentUser.getNoUtilisateur() <= 0) {	
				error = true;
				response.sendRedirect(request.getContextPath() + "/LoginServlet");
				session.setAttribute("ErrorLogin", "Erreur veuillez recommencer");
			} else {
				error = false;
			}
			
			System.out.println(session.getAttribute("idUtilisateur"));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// Rediriger sur la page profile
		
		
		
		if (error == false) {
			session.setAttribute("idUtilisateur", currentUser.getNoUtilisateur());
			response.sendRedirect(request.getContextPath() + "/BidPageServlet");
		}
		
		
	}

}
