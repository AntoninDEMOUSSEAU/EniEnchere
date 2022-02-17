package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.enchere.bo.Utilisateur;


public class UtilisateurDAOImpl implements UtilisateurDAO{
	
	private static final String INSERT_UTILISATEUR = "insert into Utilisateur(pseudo, nom, prenom,email,telephone,rue,code_postal,ville,mot_de_passe) values(?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_UTILISATEUR_BY_EMAIL="select pseudo, nom, prenom, email, telephone, rue, code_postal,ville from Utilisateur where email=?";
	
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
			pstmt.setString(5, utilisateur.getNomRue());
			pstmt.setInt(6, utilisateur.getTelephone());
			pstmt.setInt(7, utilisateur.getCodePostale());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public  Utilisateur selectUtilisateurByEmail(String email) throws DALException{
		Utilisateur utilisateur = new Utilisateur();
		try {
			Connection cnx = JdbcTools.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR_BY_EMAIL);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			//vérifier si besoin d'un boolean pour travailler dans la boucle
			while(rs.next())
			{
				
					utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
					utilisateur.setPseudo(rs.getString("pseudo"));
					utilisateur.setNom(rs.getString("nom"));
					utilisateur.setPrenom(rs.getString("prenom"));
					utilisateur.setEmail(rs.getString("email"));
					utilisateur.setTelephone(rs.getInt("telephone"));
					utilisateur.setNomRue(rs.getString("rue"));
					utilisateur.setCodePostale(rs.getInt("code_postal"));
					utilisateur.setVille(rs.getString("ville"));
					utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
	
		
	}

}
