package fr.eni.enchere.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
		//Je r�cupere l'ID de l'article et de l'utilisateur depuis le formulaire et depuis la session
		int idArticle  = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		int idUtilisateur= (int) session.getAttribute("idUtilisateur");
		
		//Je prepare ma variable qui me permettra de savoir si l'article appartient � l'utilisateur
		boolean compareIdArticleUtilisateur = false;
		
		//Je setup mes infos
		ArticleManager articleManager = new ArticleManager();
		Article article = new Article();
		Utilisateur utilisateur = new Utilisateur();
		Enchere enchere = new Enchere();
		Retrait retrait = new Retrait();
		Categorie categorie = new Categorie();
		
		//Je r�cupere les infos de la table Utilisateur, Retrait, Enchere et Categorie
		article.setUtilisateur(utilisateur);
		article.setRetrait(retrait);
		article.setEnchere(enchere);
		article.setCategorie(categorie);
		article.getUtilisateur().getNoUtilisateur();
		
		//Je selectionne l'ensemble des donn�es li�s � l'id de l'article.
		article=articleManager.selectArticleById(idArticle);
		int vendeur = article.getUtilisateur().getNoUtilisateur();
		
		//Je compare les informations du vendeur et de l'article pour envoyer une valeur boolean pour afficher ou non certaines infos dans la JSP.
		
		if( vendeur== idUtilisateur) {
			compareIdArticleUtilisateur = true;
		}
		
		//J'envoi les informations � ma JSP
		request.setAttribute("article", article);
		request.setAttribute("compareIdArticleUtilisateur", compareIdArticleUtilisateur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/BidDetail.jsp");
		rd.forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
