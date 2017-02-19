package br.com.itsstecnologia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
					"postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
