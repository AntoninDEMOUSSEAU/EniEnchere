package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;

public interface ArticleDAO {
	public void insertArticle(Article article, int idUtilisateur, int idCategorie) throws DALException,SQLException;
	public  Article selectArticleId(int noArticle) throws DALException, SQLException;

}
