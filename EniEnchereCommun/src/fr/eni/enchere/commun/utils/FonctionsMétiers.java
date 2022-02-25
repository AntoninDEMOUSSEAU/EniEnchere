package fr.eni.enchere.commun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import fr.eni.enchere.bo.Article;

public class FonctionsMétiers {

	
public static boolean VerifyIsVendeur(Article article, int idUtilisateur) {
		
		int vendeur = article.getUtilisateur().getNoUtilisateur();
		
		//Je compare les informations du vendeur et de l'article pour envoyer une valeur boolean pour afficher ou non certaines infos dans la JSP.
	
		
		return ( vendeur == idUtilisateur) ;//
	
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
