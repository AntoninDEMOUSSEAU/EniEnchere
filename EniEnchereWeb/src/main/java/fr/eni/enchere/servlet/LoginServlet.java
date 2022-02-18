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
		getServletContext().getRequestDispatcher("/WEB-INF/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// R�cup�rer les donn�es passer dans le formulaire
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utilisateur currentUser = null;
		
		// V�rifier avec les donn�es passer que un utilisateur correspond dans la base de donn�e
		
		UtilisateurManager manager = new UtilisateurManager();
		
		try {
			currentUser = manager.LoginByEmail(email, password);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("idUtilisateur", currentUser.getNoUtilisateur());
		
		// Rediriger sur la page profile
	
		response.sendRedirect(request.getContextPath() + "/BidPageServlet");
		
	}

}
