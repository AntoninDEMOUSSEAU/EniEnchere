package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class BidDetail
 */


@WebServlet("/BidDetail")

public class BidDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle  = Integer.parseInt(request.getParameter("id"));
		ArticleManager articleManager = new ArticleManager();
		Article article = new Article();
		Utilisateur utilisateur = new Utilisateur();
		Enchere enchere = new Enchere();
		Retrait retrait = new Retrait();
		Categorie categorie = new Categorie();
		
		article.setUtilisateur(utilisateur);
		article.setRetrait(retrait);
		article.setEnchere(enchere);
		article.setCategorie(categorie);
		
		article=articleManager.selectArticleById(idArticle);
		
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/BidDetail.jsp");
		rd.forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
