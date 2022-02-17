package fr.eni.echere.bll;

import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;


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
	
}
