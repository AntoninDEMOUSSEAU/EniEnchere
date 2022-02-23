package fr.eni.enchere.servlet;

import java.io.IOException;
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
 * Servlet implementation class NewSaleServlet
 */
@WebServlet("/NewSale")
public class NewSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSaleServlet() {
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
		
		
		
		getServletContext().getRequestDispatcher("/WEB-INF/NewSale.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String article = request.getParameter("article");
		int noCategorie = Integer.parseInt(request.getParameter("nocategorie"));
		String description = request.getParameter("description");
		int prixInitial = Integer.parseInt(request.getParameter("prixinitial"));
		String debutEnchere = request.getParameter("debutenchere");
		String finEnchere = request.getParameter("finenchere");
		
		Integer idUtilisateur = (Integer) session.getAttribute("idUtilisateur");
		
		int idCategorie = noCategorie;
		
		Article newArticle = new Article(article ,description,debutEnchere,finEnchere,prixInitial);
		
		ArticleManager am = new ArticleManager();
		
		am.insertArticle(newArticle, idUtilisateur, idCategorie);
		
	
		response.sendRedirect(request.getContextPath() + "/BidPageServlet");

	}

}
