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

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DALException;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Article> listeArticle = new ArrayList<Article>();
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
//		ArticleManager am = new ArticleManager();
		CategorieManager cm = new CategorieManager();
		
		try {
			
//			listeArticle = am.selectArticle();
			listeCategorie = cm.selectCategorie();
		
//			request.setAttribute("listeArticle", listeArticle);
			request.setAttribute("listeCategorie", listeCategorie);        
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Article> listeArticle = null;
		ArticleManager am = new ArticleManager();
		
		int noCategorie = Integer.parseInt(request.getParameter("categorie"));
		String libelle = request.getParameter("rechercher");
		
		System.out.println(request.getParameter("rechercher"));
		
		if (request.getParameter("rechercher") != "") {
			try {
				listeArticle = am.selectArticleByName(libelle);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(listeArticle);
			
			request.setAttribute("listeArticle", listeArticle);
		} else {
			try {
				
				listeArticle = am.selectArticleByCategory(noCategorie);
							
				System.out.println(listeArticle);
				
				request.setAttribute("listeArticle", listeArticle);
				
			} catch (DALException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		doGet(request, response);
	}

}
