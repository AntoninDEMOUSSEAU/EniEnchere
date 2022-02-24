package fr.eni.enchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;

/**
 * Servlet implementation class ModifyBidServlet
 */
@WebServlet("/ModifyBidServlet")
public class ModifyBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle  = Integer.parseInt(request.getParameter("id"));
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
			//Je setup mes infos
		ArticleManager articleManager = new ArticleManager();
		CategorieManager cm = new CategorieManager();
		Article article = new Article();
		Utilisateur utilisateur = new Utilisateur();
		Enchere enchere = new Enchere();
		Retrait retrait = new Retrait();
		Categorie categorie = new Categorie();
		
		//Je récupere les infos de la table Utilisateur, Retrait, Enchere et Categorie
		article.setUtilisateur(utilisateur);
		article.setRetrait(retrait);
		article.setEnchere(enchere);
		article.setCategorie(categorie);
		article.getUtilisateur().getNoUtilisateur();
		
		//Je selectionne l'ensemble des données liés à l'id de l'article.
		
		try {
			article=articleManager.selectArticleById(idArticle);
			listeCategorie = cm.selectCategorie();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//		
		request.setAttribute("listeCategorie", listeCategorie);   
		request.setAttribute("article", article);
			
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ModifyBid.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager articleManager = new ArticleManager();
		CategorieManager cm = new CategorieManager();
		Article article = new Article();
		Utilisateur utilisateur = new Utilisateur();
		Enchere enchere = new Enchere();
		Retrait retrait = new Retrait();
		Categorie categorie = new Categorie();
		
		
		article.setNomArticle(request.getParameter("nomArticle"));
		categorie.setNoCategorie(Integer.parseInt( request.getParameter("nocategorie")));
		article.setDescription(request.getParameter("description"));
		article.setDescription(request.getParameter("prixinitial"));
		article.setDescription(request.getParameter("debutenchere"));
		article.setDescription(request.getParameter("finenchere"));
		articleManager.updateArticle();
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
