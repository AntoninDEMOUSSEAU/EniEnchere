package fr.eni.enchere.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DALException;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/MesArticles")
public class MesArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesArticlesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Article> listeArticleByUser = null;
		ArticleManager am = new ArticleManager();
		
		HttpSession session = request.getSession();
		int idUtilisateur= (int) session.getAttribute("idUtilisateur");
		
		
		listeArticleByUser = am.selectArticleByUser(idUtilisateur);
							
		request.setAttribute("listeArticleByUser", listeArticleByUser);
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/MesArticles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		
		doGet(request, response);
	}

}
