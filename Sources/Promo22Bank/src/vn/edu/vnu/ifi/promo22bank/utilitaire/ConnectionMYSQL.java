/**
 * 
 */
package vn.edu.vnu.ifi.promo22bank.utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Cette Class permet de se connecter � la base de donn�es
 * 
 * @author KENGNI Hippolyte
 * @version 0.1 Promo22Bank
 */
public class ConnectionMYSQL {

	// Information d'acc�s � la base de donn�es
	public static Connection connection;
	public static String url = "jdbc:mysql://localhost/promo22bank";
	public static String user = "root";
	public static String password = "01659948108313495";

	/**
	 * M�thode de connexion Elle ne prend pas de param�tre
	 * 
	 * @return connection
	 */
	public static Connection getInstance() {

		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Probl�me de connexion!!!");
			}
		}
		return connection;

	}

}
