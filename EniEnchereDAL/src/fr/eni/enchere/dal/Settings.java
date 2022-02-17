/**
 * 
 */
package fr.eni.enchere.dal;

import java.util.Properties;

/**
 * @author Eni Ecole //Utilisation du Settings et JDBC tools car probleme de connexion � SQL sur les PC de l'eni
 *
 */
public class Settings {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
			//properties.loadFromXML(Settings.class.getResourceAsStream("settings.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}
