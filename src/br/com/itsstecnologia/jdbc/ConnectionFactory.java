package br.com.itsstecnologia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/bd_cadastro", "postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
