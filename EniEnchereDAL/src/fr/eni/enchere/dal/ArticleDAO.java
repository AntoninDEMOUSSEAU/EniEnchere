package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;

public interface ArticleDAO {
	public void insertArticle(Article article) throws DALException,SQLException;
	public  Article selectArticleId(int noArticle) throws DALException, SQLException;

}
