package fr.eni.enchere.servlet.utils;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import fr.eni.commun.utils.FonctionsMetiers;
import fr.eni.enchere.bo.Article;

public class utils {
	
	
	public boolean VerifyIsVendeur(HttpServletRequest request, Article article) {
		HttpSession session = request.getSession();
		
		int idUtilisateur= (int) session.getAttribute("idUtilisateur");
		
      
		return FonctionsMetiers.VerifyIsVendeur(article, idUtilisateur);
	
	}
}

