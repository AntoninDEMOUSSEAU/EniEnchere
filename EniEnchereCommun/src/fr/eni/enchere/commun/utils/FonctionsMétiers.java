package fr.eni.enchere.commun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

public class FonctionsMétiers {

	
	public boolean verifVendeur(HttpServletRequest request,Article article, int id) {
		
		int idUtilisateur= (int) request.getSession().getAttribute("idUtilisateur");
		
		return false;
	
	}
	
	//COnvertir une date String en date
	public static Date convertDate (String maDateSQLStr) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("EN"));
		
		try {
			return simpleDateFormat.parse(maDateSQLStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Convertir une Date en String
	public static String convertDateToString(Date maDate) {
			
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("EN"));
		
		return simpleDateFormat.format(maDate);
		
	}
}
