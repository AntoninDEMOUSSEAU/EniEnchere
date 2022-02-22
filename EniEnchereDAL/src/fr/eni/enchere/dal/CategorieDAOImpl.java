package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Categorie;

public class CategorieDAOImpl implements CategorieDAO {
	
	private static final String SELECT_ALL ="select * from CATEGORIES";

	@Override
	public List<Categorie> selectAll() throws DALException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
