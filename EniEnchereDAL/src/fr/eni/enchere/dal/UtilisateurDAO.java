package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException,SQLException;
	public  Utilisateur LoginByEmail(String email, String password) throws DALException, SQLException;
	public  Utilisateur selectUtilisateurById(int id) throws DALException, SQLException;
	void ModifyAccount(int id, Utilisateur utilisateur) throws SQLException;
	void DeleteAccount(int id ) throws SQLException;


}
