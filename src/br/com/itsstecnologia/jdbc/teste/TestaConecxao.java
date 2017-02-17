package br.com.itsstecnologia.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.itsstecnologia.jdbc.*;

public class TestaConecxao {
	
	public static void main(String[] args) throws SQLException {
		 Connection connection = new ConnectionFactory().getConnection();
		 System.out.println();
		 
	}
}
