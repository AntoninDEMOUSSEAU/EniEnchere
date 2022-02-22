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
 * Servlet implementation class ForgottenPasswordServlet
 */
@WebServlet("/ForgottenPasswordServlet")
public class ForgottenPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/ForgottenPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		Utilisateur utilisateur = new Utilisateur();;

		String email = request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
		
		utilisateur.setMotDePasse(password);
		utilisateur.setEmail(email);
		
		utilisateurManager.ForgottenPassword(email, utilisateur);

		
		
		} catch (DALException e) {
			e.printStackTrace();
		
		}
		
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}
}
