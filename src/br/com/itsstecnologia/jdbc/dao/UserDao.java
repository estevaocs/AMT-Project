package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.User;

public class UserDao {
	
	private Calendar cal;
	
	//conecxao com o banco de dados 
	private Connection connection;
	
	public UserDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(User user) {
		String sql = "insert into usuario "
				+ "(id_user,login,password,first_name,last_name,dt_birth,tel,email,sex,area)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";

		try {
			//Prepared Statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			//set os valores
			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			user.getCalendarBirth();
			stmt.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()), cal);
			stmt.setString(7, user.getTel());
			stmt.setString(8, user.getEmail());
			stmt.setString(9, user.getSex());
			stmt.setInt(10, user.getArea());
			
			//executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
