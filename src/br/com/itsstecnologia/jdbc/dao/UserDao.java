package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.User;
import br.com.itsstecnologia.util.Criptografia;

public class UserDao {

	private Calendar cal;

	// conecxao com o banco de dados
	private Connection connection;

	public UserDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(User user) {
		String sql = "insert into usuario "
				+ "(id_user,login,password,first_name,last_name,dt_birth,tel,email,sex,area)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";

		try {
			// Prepared Statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set os valores
			stmt.setLong(1, user.getId());
			stmt.setString(2, user.getLogin());
			stmt.setString(3, Criptografia.criptografar(user.getPassword()));
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			user.getCalendarBirth();
			stmt.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()), cal);
			stmt.setString(7, user.getTel());
			stmt.setString(8, user.getEmail());
			stmt.setString(9, user.getSex());
			stmt.setInt(10, user.getArea());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean login(String login, String password) {
		String sql = "select * from usuario where login=? and password=?";
		boolean status = false;
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, Criptografia.criptografar(password));
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				status = true;
			}
			
			rs.close();
	        stmt.close();
			return status;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<User> getLista() {
	     try {
	         ArrayList<User> users = new ArrayList<User>();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from usuario");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto user
	        	 long id = rs.getLong("id_user");
	        	 String login = rs.getString("login");
	        	 String password = rs.getString("password");
	        	 String name = rs.getString("first_name");
	        	 String lastName = rs.getString("last_name");
	        	 Calendar data = Calendar.getInstance();
	        	 data.setTime(rs.getDate("dt_birth"));
	        	 String tel =  rs.getString("tel");
	        	 String email =  rs.getString("email");
	        	 String sex = rs.getString("sex");
	        	 int area = rs.getInt("area");
	        	 
	             User user = new User(id, login, password, name, lastName, data, tel, email, sex, area);
	 
	             // adicionando o objeto à lista
	             users.add(user);
	         }
	         rs.close();
	         stmt.close();
	         return users;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	public void edit(User user) {
		String sql = "update usuario set login,password = ?, first_name = ?,"
				+ " last_name = ?, dt_birth = ?, tel =?, email = ?, sex = ?,"
				+ " area = ? where id_user = ?";

		try {
			// Prepared Statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set os valores
			stmt.setLong(10, user.getId());
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			user.getCalendarBirth();
			stmt.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()), cal);
			stmt.setString(6, user.getTel());
			stmt.setString(7, user.getEmail());
			stmt.setString(8, user.getSex());
			stmt.setInt(9, user.getArea());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(User user) {
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement("delete from usuario where id_user=?");
	         stmt.setLong(1, user.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public void remove(int id) {
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement("delete from usuario where id_user=?");
	         stmt.setLong(1, Integer.toUnsignedLong(id));
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
