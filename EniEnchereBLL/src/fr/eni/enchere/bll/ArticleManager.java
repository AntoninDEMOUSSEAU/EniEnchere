package fr.eni.enchere.bll;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	
	private ArticleDAO articleDao;
	
	public ArticleManager() {
		this.articleDao=DAOFactory.getArticleDAO();
	}

	public void insertArticle(Article article) {
		/*
		try {
			DAOFactory.getArticleDAO().insertArticle(article); 
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}*/
	}
	public Article selectArticleId(int noArticle) throws DALException {
		Article article=null;
		try {
			 article=this.articleDao.selectArticleId(noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
}
