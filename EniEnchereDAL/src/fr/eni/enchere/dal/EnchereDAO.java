package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;



public interface EnchereDAO {
	public Enchere SelectBestBid(Article article) throws DALException,SQLException;
	public  boolean InsertBid (Enchere enchere) throws DALException, SQLException;
	
}