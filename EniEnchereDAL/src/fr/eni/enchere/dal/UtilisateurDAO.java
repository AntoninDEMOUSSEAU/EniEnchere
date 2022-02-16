package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws DALException;
	public  Utilisateur selectByID(int id) throws DALException;

}
