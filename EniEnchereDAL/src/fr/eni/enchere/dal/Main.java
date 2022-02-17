package fr.eni.enchere.dal;

import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;

public class Main {

	public static void main(String[] args) {
		UtilisateurDAO utilisateurDAO=DAOFactory.getUtilisateurDAO();
		Utilisateur utilisateur=null;
		try {
			 utilisateur=utilisateurDAO.selectUtilisateurById(2);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("yes");
		
	}

}
