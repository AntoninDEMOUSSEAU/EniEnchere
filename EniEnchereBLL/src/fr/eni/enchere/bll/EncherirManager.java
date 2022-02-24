package fr.eni.enchere.bll;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EncherirDAO;

public class EncherirManager {
	private EncherirDAO encherirDAO;

	public EncherirManager() {
		
		this.encherirDAO=DAOFactory.getEnchereDAO();
	}
	
	public void encherir (Article article, Utilisateur utilisateur, int prix) {
		try {
			this.encherirDAO.encherir(article, utilisateur, prix);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EncherirDAO getEncherirDAO() {
		return encherirDAO;
	}
	

	public void setEncherirDAO(EncherirDAO EncherirDAO) {
		this.encherirDAO = EncherirDAO;
	}
}
