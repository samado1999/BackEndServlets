package com.tiendavirtual.dao;

import java.sql.*;

public class DBConnection {
	private final String db = "tiendagenerica";
	private final String user = "root";
	private final String password = "admin";
	private final String url = "jdbc:mysql://localhost:3306/" + db
			+ "?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";

	private Connection con;

	public DBConnection() {
		this.con = null;
	}

	public Connection Conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(url, user, password);
			if (this.con != null) {
				System.out.println("Conectado");
				return con;
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}
		return null;
	}

	public void Cerrar() {
		try {
			this.con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
