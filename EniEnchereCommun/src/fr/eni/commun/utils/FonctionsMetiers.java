package fr.eni.commun.utils;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

public class FonctionsMetiers {

	
	public static boolean VerifyIsVendeur(Article article, int idUtilisateur) {
		
		int vendeur = article.getUtilisateur().getNoUtilisateur();
		
		//Je compare les informations du vendeur et de l'article pour envoyer une valeur boolean pour afficher ou non certaines infos dans la JSP.
		
		
		
		return ( vendeur == idUtilisateur) ;//
	
	}
}
