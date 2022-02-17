package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

	
	private static  String urldb;
	private static String userdb;
	private static String passworddb;
	
	static {
		
		try {
			Class.forName(Settings.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
		System.out.println("urldb="+urldb+";userdb="+userdb+";passworddb="+passworddb);
	}
	
	
	
	public static Connection getConnection() throws SQLException{
		String url = String.format("%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true", urldb, userdb, passworddb);  
		Connection cnx = DriverManager.getConnection(url);
		return cnx;
	}
	


}


