package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

public interface EncherirDAO {

	public Enchere selectMeilleurEnchere(String article) throws DALException, SQLException;
	public Utilisateur selectUserConnected (int id) throws DALException, SQLException;
	public void encherir (Article article, Utilisateur utilisateur, int prix) throws DALException, SQLException;
}