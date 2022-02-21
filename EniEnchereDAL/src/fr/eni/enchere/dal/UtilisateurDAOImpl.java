package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.enchere.bo.Utilisateur;


public class UtilisateurDAOImpl implements UtilisateurDAO{
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO Utilisateurs(pseudo, nom, prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_UTILISATEUR_BY_EMAIL="SELECT * FROM Utilisateurs where email=? AND mot_de_passe=?";
	private static final String SELECT_UTILISATEUR_BY_ID="SELECT pseudo, nom, prenom, email, telephone, rue, code_postal,ville from Utilisateurs where no_utilisateur=?";
	private static final String UPDATE_UTILISATEUR_BY_ID="UPDATE Utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=? WHERE no_utilisateur=?";  
	private static final String DELETE_UTILISATEUR_BY_ID = "DELETE FROM Utilisateurs WHERE no_utilisateur=?";														
	
	
	
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException, SQLException{
	
		Connection cnx = JdbcTools.getConnection();
		try {	
		PreparedStatement pstmt;
		ResultSet rs;
		
		if(utilisateur.getNoUtilisateur()==0)
		{
			pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getNomRue());
			pstmt.setString(7, utilisateur.getCodePostale());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, 0);
			pstmt.setBoolean(11, false);
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setNoUtilisateur(rs.getInt(1));
				
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
	public  Utilisateur LoginByEmail(String email,String password) throws DALException, SQLException{
		Utilisateur utilisateur = new Utilisateur();
		Connection cnx = null;
		boolean error = false;
		try {


			cnx = JdbcTools.getConnection();

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_EMAIL);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			//v�rifier si besoin d'un boolean pour travailler dans la boucle
			while(rs.next())
			{
				
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setNomRue(rs.getString("rue"));
					utilisateur.setCodePostale(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
					utilisateur.setCredit(rs.getInt("credit"));
					utilisateur.setAdministrateur(rs.getInt("administrateur"));
					
			}
			
		} catch (SQLException e) {
			error = true;
			e.printStackTrace();
		}
		cnx.close();
		return utilisateur;
	
		
	}


	@Override
	public  Utilisateur selectUtilisateurById(int id) throws DALException, SQLException{
		Utilisateur utilisateur = new Utilisateur();
		Connection cnx=null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_ID);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getString("telephone"));
					utilisateur.setNomRue(rs.getString("rue"));
					utilisateur.setCodePostale(rs.getString("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cnx.close();
		return utilisateur;
	}

	@Override
	public void ModifyAccount(int id, Utilisateur utilisateur) throws SQLException {
		Connection cnx = JdbcTools.getConnection();
		try {	
		PreparedStatement pstmt;
		
			pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR_BY_ID);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getNomRue());
			pstmt.setString(7, utilisateur.getCodePostale());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setInt(11, utilisateur.getNoUtilisateur());		
			
			pstmt.executeUpdate();
			cnx.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cnx.close();
	}
	@Override
	public void DeleteAccount(int id) throws SQLException {
		try(Connection cnx = JdbcTools.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR_BY_ID);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
