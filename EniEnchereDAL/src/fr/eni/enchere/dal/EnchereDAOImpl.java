package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

public class EnchereDAOImpl implements EnchereDAO  {

	@Override
	public Enchere SelectBestBid(Article article) throws DALException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean InsertBid(Enchere enchere, Article article, Utilisateur utilisateur)
			throws DALException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
