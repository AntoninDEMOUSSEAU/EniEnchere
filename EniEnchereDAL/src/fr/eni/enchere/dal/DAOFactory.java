package fr.eni.enchere.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleDAO getArticleDAO() {
		
		return new ArticleDAOImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		
		return new CategorieDAOImpl();
	}
	
	public static EncherirDAO getEnchereDAO() {
		return new EncherirDAOImpl();
	}
}
	