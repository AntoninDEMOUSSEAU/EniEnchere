package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

public class ArticleDAOImpl implements ArticleDAO{

	private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?);";
	private static final String SELECT_ALL = "select * from ARTICLES_VENDUS a, UTILISATEURS u  where a.no_utilisateur = u.no_utilisateur ";
	private static final String SELECT_BY_CATEGORIE = "select * from ARTICLES_VENDUS a LEFT OUTER JOIN RETRAITS ON (a.no_article = RETRAITS.no_article), UTILISATEURS u where a.no_utilisateur = u.no_utilisateur AND a.no_categorie=?";
	private static final String SELECT_BY_NAME= "select * from ARTICLES_VENDUS a LEFT OUTER JOIN RETRAITS ON (a.no_article = RETRAITS.no_article), UTILISATEURS u where a.no_utilisateur = u.no_utilisateur AND a.nom_article LIKE ?";
	private static final String SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS a LEFT OUTER JOIN RETRAITS r ON a.no_article=r.no_article LEFT OUTER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur LEFT OUTER JOIN ENCHERES e ON a.no_article=e.no_article LEFT OUTER JOIN CATEGORIES c ON a.no_categorie=c.no_categorie WHERE a.no_article=?";
	private static final String SELECT_ARTICLE_BY_USER = "SELECT * FROM ARTICLES_VENDUS a LEFT OUTER JOIN RETRAITS r ON a.no_article=r.no_article LEFT OUTER JOIN UTILISATEURS u ON a.no_utilisateur=u.no_utilisateur LEFT OUTER JOIN ENCHERES e ON a.no_article=e.no_article LEFT OUTER JOIN CATEGORIES c ON a.no_categorie=c.no_categorie WHERE u.no_utilisateur=?";
	private static final String UPDATE_ARTICLE_BY_ID ="UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, no_categorie=? WHERE no_article=?";

	
	@Override
	public void insertArticle(Article article, int idUtilisateur, int idCategorie) throws DALException, SQLException {
		
		Connection cnx = JdbcTools.getConnection();
		PreparedStatement pstmt;
		ResultSet rs;
		try {
		if(article.getNoArticle()==0)
		{
			pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, article.getDatedebutEncheres());
			pstmt.setString(4, article.getDateFinEncheres());
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setString(6, article.getPrixVente());
			pstmt.setInt(7, idUtilisateur);
			pstmt.setInt(8, idCategorie);
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
	public List<Article> selectArticle() throws DALException, SQLException {
		List<Article> listeArticle = new ArrayList<Article>();
		
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

	@Override
	public List<Article> selectArticleByCategory(int noCategorie) throws DALException, SQLException {				
				Connection cnx = null;
				List<Article> listeArticle = new ArrayList<Article>();
				
				try {
					cnx = JdbcTools.getConnection();
					PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
					pstmt.setInt(1, noCategorie);
					ResultSet rs = pstmt.executeQuery();
				
					
					while(rs.next())
					{
							Article article = new Article ();
						
							Utilisateur utilisateur = new Utilisateur();	
							
							Retrait retrait = new Retrait();

							article.setUtilisateur(utilisateur);
							article.setNoArticle(rs.getInt("no_article"));
							article.setRetrait(retrait);
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
			
	
	@Override
	public List<Article> selectArticleByName(String libelle) throws DALException, SQLException {				
				Connection cnx = null;
				List<Article> listeArticle = new ArrayList<Article>();
				
				try {
					cnx = JdbcTools.getConnection();
					PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NAME);
					pstmt.setString(1, "%" + libelle + "%");
					ResultSet rs = pstmt.executeQuery();
				
					
					while(rs.next())
					{
							Article article = new Article ();
						
							Utilisateur utilisateur = new Utilisateur();	
							
							Retrait retrait = new Retrait();

							article.setUtilisateur(utilisateur);
							article.setNoArticle(rs.getInt("no_article"));
							article.setRetrait(retrait);
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
	

	@Override
	public Article selectArticleById(int idArticle) throws DALException, SQLException {
		Article article = new Article();
		Retrait retrait = new Retrait();
		Categorie categorie = new Categorie();
		Utilisateur utilisateur=new Utilisateur();
		Enchere enchere = new Enchere();
		
		article.setRetrait(retrait);
		article.setCategorie(categorie);
		article.setUtilisateur(utilisateur);
		article.setEnchere(enchere);
		
		Connection cnx=null;
	
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_BY_ID);
			pstmt.setInt(1, idArticle);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setDescription(rs.getString("description"));
				article.setDateFinEncheres(rs.getString("date_fin_encheres"));
				article.setPrixVente(rs.getString("prix_initial"));	
				article.getRetrait().setCodePostal(rs.getInt("code_postal"));
				article.getRetrait().setNomRue(rs.getString("rue"));
				article.getRetrait().setVille(rs.getString("ville"));
				article.getUtilisateur().setPseudo(rs.getString("pseudo"));
				article.getUtilisateur().setNoUtilisateur(rs.getInt("no_utilisateur"));
				article.getCategorie().setLibelle(rs.getString("libelle"));
				article.getEnchere().setMontantEnchere(rs.getInt("montant_enchere"));
			}	
		
		cnx.close();
		return article;
	}

	@Override
	public List<Article> selectArticleByUser(int idUtilisateur) throws DALException, SQLException {
		Connection cnx = null;
		List<Article> listeArticleByUser = new ArrayList<Article>();
		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLE_BY_USER);
			pstmt.setInt(1,idUtilisateur);
			ResultSet rs = pstmt.executeQuery();
		
			
			while(rs.next())
			{
				Article article = new Article();
				Retrait retrait = new Retrait();
				Categorie categorie = new Categorie();
				Utilisateur utilisateur=new Utilisateur();
				Enchere enchere = new Enchere();
				
				article.setUtilisateur(utilisateur);
				article.setCategorie(categorie);
				article.setEnchere(enchere);
				article.setRetrait(retrait);
				article.setNomArticle(rs.getString("nom_article"));
				article.setNoArticle(rs.getInt("no_article"));
				article.setDescription(rs.getString("description"));
				article.setDatedebutEncheres(rs.getString("date_debut_encheres"));
				article.setDateFinEncheres(rs.getString("date_fin_encheres"));
				article.setPrixVente(rs.getString("prix_initial"));	
				article.getRetrait().setCodePostal(rs.getInt("code_postal"));
				article.getRetrait().setNomRue(rs.getString("rue"));
				article.getRetrait().setVille(rs.getString("ville"));
				article.getUtilisateur().setPseudo(rs.getString("pseudo"));
				article.getCategorie().setLibelle(rs.getString("libelle"));
				article.getEnchere().setMontantEnchere(rs.getInt("montant_enchere"));
				
				listeArticleByUser.add(article);
					
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnx.close();
		
		return listeArticleByUser;
	}

	@Override
	public Article updateArticleById(int idArticle, Article article) throws DALException, SQLException {
		Connection cnx = null;
		Categorie categorie = new Categorie();
		
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ARTICLE_BY_ID);
			
		
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, article.getDatedebutEncheres());
			pstmt.setString(4, article.getDateFinEncheres());
			pstmt.setString(6, article.getPrixVente());
			pstmt.setInt(5, categorie.getNoCategorie());
			pstmt.setInt(7, article.getNoArticle());

			pstmt.executeUpdate();	
	
			cnx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cnx.close();
		
		return article;
	}
		
		
}
	
			
		


