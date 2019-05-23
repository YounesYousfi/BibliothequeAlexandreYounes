package com.adaming.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {

	private static final String url = "jdbc:mysql://localhost:3306/bibliotheque";
	private static final String user = "root";
	private static final String password = "";

	private static Connection con;

	public ConnexionDB() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws ClassNotFoundException {
		if (con == null) {
			new ConnexionDB();
			System.out.println("Ouverture d'une nouvelle session");
			return con;
		} else {
			System.out.println("Une connexion est déjà existante");
			return con;
		}

	}

	public static void clearConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
