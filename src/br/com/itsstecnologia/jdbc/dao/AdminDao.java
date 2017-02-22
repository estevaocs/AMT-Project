package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Admin;
import br.com.itsstecnologia.util.Criptografia;

public class AdminDao {
	private Calendar cal;

	// conecxao com o banco de dados
	private Connection connection;
	private UserDao dao = new UserDao();

	public AdminDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(Admin admin) {
		String sql = "insert into admin "
				+ "(id_user,login,password,first_name,last_name,dt_birth,tel,email,sex,permission_lvl)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		
		dao.add(admin);
		try {
			// Prepared Statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set os valores
			stmt.setLong(1, admin.getId());
			stmt.setString(2, admin.getLogin());
			stmt.setString(3, admin.getPassword());
			stmt.setString(4, admin.getFirstName());
			stmt.setString(5, admin.getLastName());
			admin.getCalendarBirth();
			stmt.setDate(6, new java.sql.Date(Calendar.getInstance().getTimeInMillis()), cal);
			stmt.setString(7, admin.getTel());
			stmt.setString(8, admin.getEmail());
			stmt.setString(9, admin.getSex());
			stmt.setInt(10, admin.getNivel());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Admin> getLista() {
	     try {
	         ArrayList<Admin> admins = new ArrayList<Admin>();
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
	        	 int nivel = rs.getInt("permission_lvl");
	        	 
	             Admin admin = new Admin(id, login, password, name, lastName, data, tel, email, sex, nivel);
	 
	             // adicionando o objeto � lista
	             admins.add(admin);
	         }
	         rs.close();
	         stmt.close();
	         return admins;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	public void edit(Admin admin) {
		String sql = "update usuario set login,password = ?, first_name = ?,"
				+ " last_name = ?, dt_birth = ?, tel =?, email = ?, sex = ?,"
				+ " permission_lvl = ? where id_user = ?";

		try {
			// Prepared Statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set os valores
			stmt.setLong(10, admin.getId());
			stmt.setString(1, admin.getLogin());
			stmt.setString(2, admin.getPassword());
			stmt.setString(3, admin.getFirstName());
			stmt.setString(4, admin.getLastName());
			stmt.setDate(5,new java.sql.Date(admin.getCalendarBirth().MILLISECOND()), cal);
			stmt.setString(6, admin.getTel());
			stmt.setString(7, admin.getEmail());
			stmt.setString(8, admin.getSex());
			stmt.setInt(9, admin.getNivel());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Admin admin) {
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement("delete from usuario where id_user=?");
	         stmt.setLong(1, admin.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
}
