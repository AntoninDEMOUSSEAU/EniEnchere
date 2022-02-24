package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

public interface EncherirDAO {

	public Enchere selectMeilleurEnchere(Article article) throws DALException, SQLException;
	public Utilisateur selectUserConnected (int id) throws DALException, SQLException;
	public void encherir (Article article, Utilisateur utilisateur, String date  ,int prix ) throws DALException, SQLException;
}
