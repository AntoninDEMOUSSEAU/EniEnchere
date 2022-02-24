package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public class EncherirDAOImpl implements EncherirDAO{

	private static final String SELECT_USER_BY_ID = "select * from UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_ENCHERE_GAGNANTE = "select ENCHERES WHERE no_article = ARTICLES_VENDUS.no_article ORDER BY montant_enchere DESC LIMIT 1";
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES VALUES (?,?,?,?)";
		
	@Override
	public Utilisateur selectUserConnected(int id) throws DALException, SQLException {
		
		Utilisateur utilisateur = new Utilisateur();
		
		Connection cnx = null;
		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
					Utilisateur utilisateur = new Utilisateur();	
					Article article = new Article ();
					Retrait retrait = new Retrait();
					article.setUtilisateur(utilisateur);
					article.setRetrait(retrait);
					article.setNoArticle(rs.getInt("no_article"));
					article.setNomArticle(rs.getString("nom_article"));
					article.setDateFinEncheres(rs.getString("date_fin_encheres"));
					article.setPrixVente(rs.getString("prix_initial"));	
					article.getUtilisateur().setPseudo(rs.getString("pseudo"));
					article.getRetrait().setCodePostal(rs.getInt("code_postal"));
					article.getRetrait().setNomRue(rs.getString("rue"));
					article.getRetrait().setVille(rs.getString("ville"));
					
					listeArticle.add(article);
					
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnx.close();
		
		return listeArticle;
	}
		
		return null;
	}

	@Override
	public Enchere selectMeilleurEnchere(Article article) throws DALException, SQLException {
		return null;
	}


	@Override
	public void encherir(Article article, Utilisateur utilisateur, String date, int prix) throws DALException, SQLException {
		
	}

}
