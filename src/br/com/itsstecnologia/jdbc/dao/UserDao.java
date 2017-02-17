package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;

import br.com.itsstecnologia.jdbc.ConnectionFactory;

public class UserDao {
	
	//conecxao com o banco de dados 
	private Connection connection;
	
	public UserDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

}
