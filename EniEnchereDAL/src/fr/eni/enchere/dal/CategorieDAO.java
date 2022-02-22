package fr.eni.enchere.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Categorie;

public interface CategorieDAO {
	public List<Categorie> selectAll () throws DALException, SQLException;
}
