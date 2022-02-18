package fr.eni.enchere.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		
		return new ArticleDAOImpl();
	}
}
	