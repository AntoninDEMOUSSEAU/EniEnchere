package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	private ArticleDAO articleDao;
	
	public ArticleManager() {
		this.articleDao=DAOFactory.getArticleDAO();
	}

	public void insertArticle(Article article, int idUtilisateur, int idCategorie) {
		//Article ajoutArticle = null;
		try {
			this.articleDao.insertArticle(article, idUtilisateur, idCategorie);
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Article> selectArticle() throws DALException {
		List<Article> listeArticle= new ArrayList<Article>();
		try {
			 listeArticle=this.articleDao.selectArticle();
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;
	}
	
	public List<Article> selectArticleByCategory(int noCategorie) throws DALException, SQLException {

		List<Article> listeArticle = null;
		
		try {
			 listeArticle = this.articleDao.selectArticleByCategory(noCategorie);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticle;
	}
	
	public List<Article> selectArticleByName(String libelle) throws DALException, SQLException {

		List<Article> listeArticle = null;
		
		try {
			 listeArticle = this.articleDao.selectArticleByName(libelle);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeArticle;
	}
	
	public Article selectArticleById(int idArticle) {
		Article article = new Article();
		try {
			article=this.articleDao.selectArticleById(idArticle);
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	
	
	//Methode Antonin pour la gestion des enchere
	public boolean encherir(Article article, Utilisateur utilisateur, int prix) {
		// DAO 1  SELECT USER récuperer l'ID de la session 
		
		// DAO 2  SelectBestBid depuis la factory
		
		// si les conditions sont ok DAO InsertBid
		
		return false;
		
		
		
		
	}
}
