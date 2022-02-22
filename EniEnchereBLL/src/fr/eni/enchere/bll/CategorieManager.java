package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManager {

	private CategorieDAO categorieDAO;

	public CategorieManager() {
		
		this.categorieDAO=DAOFactory.getCategorieDAO();
	}
	
	public List<Categorie> selectCategorie() throws DALException {
		
		List<Categorie> listeCategorie = new ArrayList<Categorie>();

		try {
			listeCategorie = DAOFactory.getCategorieDAO().selectAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listeCategorie;
	}
	
	public CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}

	public void setCategorieDAO(CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}
	
}
