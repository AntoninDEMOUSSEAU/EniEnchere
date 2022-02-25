package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Article;

public interface ArticleDAO {
	public void insertArticle(Article article, int idUtilisateur, int idCategorie) throws DALException,SQLException;
	public  List<Article> selectArticle() throws DALException, SQLException;
	public List<Article> selectArticleByCategory(int noCategorie) throws DALException, SQLException;
	public List<Article> selectArticleByName(String libelle) throws DALException, SQLException;
	public Article selectArticleById(int idArticle) throws DALException, SQLException;
	public List<Article> selectArticleByUser(int idUtilisateur) throws DALException,SQLException;
	public Article updateArticleById(int idUtilisateur)throws DALException,SQLException;
}
