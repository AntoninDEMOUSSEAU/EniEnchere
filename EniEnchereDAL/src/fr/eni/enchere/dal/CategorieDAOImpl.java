package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;

public class CategorieDAOImpl implements CategorieDAO{
	
	private static final String SELECT_ALL ="select * from CATEGORIES";

	@Override
	public List<Categorie> selectAll() throws DALException, SQLException {
		
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		Connection cnx = null;
		
		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Categorie categorie = new Categorie();
				
				categorie.setLibelle(rs.getString("libelle"));
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				
				listeCategorie.add(categorie);
			}
			
		} catch (Exception e) {
		}
		
		cnx.close();
				
		return listeCategorie;
	}
}
