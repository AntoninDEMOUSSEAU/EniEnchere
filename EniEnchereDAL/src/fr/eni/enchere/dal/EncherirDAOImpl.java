package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.commun.utils.FonctionsMétiers;

public class EncherirDAOImpl implements EncherirDAO{

	private static final String SELECT_USER_BY_ID = "select * from UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_ENCHERE_GAGNANTE = "select * FROM ENCHERES WHERE ENCHERES.no_article = ARTICLES_VENDUS.no_article ORDER BY montant_enchere DESC LIMIT 1";
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES VALUES (?,?,?,?)";
		
	@Override
	public Utilisateur selectUserConnected(int id) throws DALException, SQLException {
		
		Connection cnx = null;
		Utilisateur utilisateur = new Utilisateur();	

		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
		
			
			while(rs.next())
			{
					
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setCredit(rs.getInt("credit"));
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnx.close();
		
		return utilisateur;		
			
	}

	@Override
	public Enchere selectMeilleurEnchere(String article) throws DALException, SQLException {
		
		Connection cnx = null;
		Enchere enchere = new Enchere();
		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ENCHERE_GAGNANTE);
			pstmt.setString(1, article);
			ResultSet rs = pstmt.executeQuery();
		
			
			while(rs.next())
			{
								
				enchere.setMontantEnchere(rs.getInt("montant_enchere"));
				enchere.getArticle().setNoArticle(rs.getInt("no_article"));
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnx.close();
		
		return enchere;		
			
	
	}


	@Override
	public void encherir(Article article, Utilisateur utilisateur, int prix) throws DALException, SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		boolean sucess = false;
		
		try {
			//Prepare la requête 
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(INSERT_ENCHERE, Statement.RETURN_GENERATED_KEYS);
			
			//Envoie les id des objets User et article pour les Foreign Keys
			rqt.setInt(1,  utilisateur.getNoUtilisateur());
			rqt.setInt(2,  article.getNoArticle());
			
			//date et montant
			Date date = new Date();  
			rqt.setDate(3, java.sql.Date.valueOf(FonctionsMétiers.convertDateToString(date)));
			rqt.setInt(4, prix);
			
			// Executer ma requête
			int result = rqt.executeUpdate();
			
			if(result == 1 ) {
				rs = rqt.getGeneratedKeys();
				
				sucess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
