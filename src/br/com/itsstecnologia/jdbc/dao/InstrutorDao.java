package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Horario;
import br.com.itsstecnologia.jdbc.model.Instrutor;

public class InstrutorDao {
	
	private Calendar cal;
	
	private Connection connection;
	
	private UserDao dao = new UserDao();
	
	
	public InstrutorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Instrutor instrutor) {
		String sql = "INSERT into instrutor (id_user, id_horario, login, password, first_name, last_name,"
				+ "dt_birth, tel, email, sex, permission_lvl, area)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		dao.add(instrutor);
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, instrutor.getId());
			stmt.setLong(2, instrutor.getHorario().getId_horario());
			stmt.setString(3, instrutor.getLogin());
			stmt.setString(4, instrutor.getPassword());
			stmt.setString(5, instrutor.getFirstName());
			stmt.setString(6, instrutor.getLastName());
			stmt.setDate(5,(java.sql.Date) instrutor.getCalendarBirth().getTime(), cal);
			stmt.setString(8, instrutor.getTel());
			stmt.setString(9, instrutor.getEmail());
			stmt.setString(10, instrutor.getSex());
			stmt.setInt(11, instrutor.getNivel());
			stmt.setString(12, instrutor.getArea());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<Instrutor> getLista() {
	     try {
	         ArrayList<Instrutor> instrutores = new ArrayList<Instrutor>();
	         HorarioDao dao = new HorarioDao();
	         PreparedStatement stmt = this.connection.
	                 prepareStatement("select * from instrutor");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto user
	        	 Instrutor instrutor = instaciaInstrutor(dao, rs);	 
	             
	             // adicionando o objeto � lista
	             instrutores.add(instrutor);
	         }
	         rs.close();
	         stmt.close();
	         return instrutores;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	private Instrutor instaciaInstrutor(HorarioDao dao, ResultSet rs) throws SQLException {
		long id = rs.getLong("id_user");
		 Horario horario = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_horario")));
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
		 String area = rs.getString("area");
		 
		 Instrutor instrutor = new Instrutor(id, login, password, name, lastName, data, tel, email, sex,
				 nivel, area, horario);
		return instrutor;
	}
	
	public void edit(Instrutor inst) {
		String sql = "Update instrutor set login = ? , password = ? , first_name = ?, last_name = ?, dt_birth = ?,"
				+ " tel = ?, email = ?, sex = ?, permission_lvl = ?, area = ?, horario = ? where id_user = ?";
		
		dao.edit(inst);

		try {
			// Prepared Statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);

			// set os valores
			stmt.setLong(11, inst.getId());
			stmt.setString(1, inst.getLogin());
			stmt.setString(2, inst.getPassword());
			stmt.setString(3, inst.getFirstName());
			stmt.setString(4, inst.getLastName());
			stmt.setDate(5,new java.sql.Date(inst.getCalendarBirth().getTimeInMillis()));
			stmt.setString(6, inst.getTel());
			stmt.setString(7, inst.getEmail());
			stmt.setString(8, inst.getSex());
			stmt.setInt(9, inst.getNivel());
			stmt.setString(10, inst.getArea());

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void remove(Instrutor inst) {
		
		dao.remove(inst);
		
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement("delete from instrutor where id_user=?");
	         stmt.setLong(1, inst.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	private int getIndex(ArrayList<Horario> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId_horario() == id) return i;
		}
		return -1;
	}
}
