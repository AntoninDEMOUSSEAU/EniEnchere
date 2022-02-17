package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException,SQLException;
	public  Utilisateur selectUtilisateurByEmail(String email) throws DALException;

}
