package fr.eni.enchere.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		getServletContext().getRequestDispatcher("/WEB-INF/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les données passer dans le formulaire
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Vérifier avec les données passer que un utilisateur correspond dans la base de donnée
		
		UtilisateurManager manager = new UtilisateurManager();
		
		try {
			Utilisateur currentUser = manager.LoginByEmail(email, password);
			System.out.println(currentUser);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		// manager.LoginByEmail();
		
		// Mettre en session l'id de l'utilisateur
		
		// Rediriger sur la page profile
	
		response.sendRedirect(request.getContextPath() + "/BidPageServlet");
		
	}

}
