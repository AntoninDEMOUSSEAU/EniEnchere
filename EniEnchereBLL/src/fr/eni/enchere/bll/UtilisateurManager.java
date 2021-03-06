package fr.eni.enchere.bll;

import java.sql.SQLException;

import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		
		this.utilisateurDAO=DAOFactory.getUtilisateurDAO();
	}
	
	public void Register(Utilisateur utilisateur) {
		try {
			DAOFactory.getUtilisateurDAO().insertUtilisateur(utilisateur);
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ModifyAccount(int id, Utilisateur utilisateur) throws DALException {
		try {
			DAOFactory.getUtilisateurDAO().ModifyAccount(id, utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void DeleteAccount(int id ) throws DALException {
		try {
			DAOFactory.getUtilisateurDAO().DeleteAccount(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Utilisateur AfficherCompteUtilisateurById(int id) throws DALException {
		Utilisateur utilisateur=null;
		try {
			 utilisateur=this.utilisateurDAO.selectUtilisateurById(id);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur LoginByEmail(String email, String password) throws DALException {
		Utilisateur utilisateur=null;
		try {
			 utilisateur=this.utilisateurDAO.LoginByEmail(email,password);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	public void ForgottenPassword(String email, Utilisateur utilisateur) throws DALException {
		try {
			DAOFactory.getUtilisateurDAO().ForgottenPassword(email, utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
