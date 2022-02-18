package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;

public class ArticleDAOImpl implements ArticleDAO{

	private static final String INSERT_ARTICLE = "insert into ARTICLES(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?);";

	
	@Override
	public void insertArticle(Article article, Utilisateur utilisateur, Categorie categorie) throws DALException, SQLException {
		
		Connection cnx = JdbcTools.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		try {
		if(article.getNoArticle()==0)
		{
			pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, (Date) article.getDatedebutEncheres());
			pstmt.setDate(4, (Date) article.getDateFinEncheres());
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, utilisateur.getNoUtilisateur());
			pstmt.setInt(8, categorie.getNoCategorie());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setNoArticle(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
		}
		cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cnx.close();
		
	}

	@Override
	public Article selectArticleId(int noArticle) throws DALException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}