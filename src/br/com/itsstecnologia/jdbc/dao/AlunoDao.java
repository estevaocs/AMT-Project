package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Aluno;
import br.com.itsstecnologia.jdbc.model.Turma;

public class AlunoDao {
	
		private Connection connection;
		
		private UserDao dao = new UserDao();
		
		
		public AlunoDao() {
			this.connection = new ConnectionFactory().getConnection();
		}
		
		public void add(Aluno aluno) {
			String sql = "INSERT into aluno (id_user,login,password,first_name,last_name,"
					+ "dt_birth,tel,email,sex,permission_lvl,area,id_turma)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			dao.add(aluno);
			
			try {
				
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setLong(1, aluno.getId());
				stmt.setString(2, aluno.getLogin());
				stmt.setString(3, aluno.getPassword());
				stmt.setString(4, aluno.getFirstName());
				stmt.setString(5, aluno.getLastName());
				stmt.setDate(5,new java.sql.Date(aluno.getCalendarBirth().getTimeInMillis()));
				stmt.setString(7, aluno.getTel());
				stmt.setString(8, aluno.getEmail());
				stmt.setString(9, aluno.getSex());
				stmt.setInt(10, aluno.getNivel());
				stmt.setString(11, aluno.getArea());
				stmt.setLong(12, aluno.getId());
				
				stmt.execute();
				stmt.close();
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		public ArrayList<Aluno> getLista() throws Exception {
		     try {
		         ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		         PreparedStatement stmt = this.connection.
		                 prepareStatement("select * from aluno");
		         ResultSet rs = stmt.executeQuery();
		         
		         TurmaDao dao = new TurmaDao();
		 
		         while (rs.next()) {
		             // criando o objeto user
		        	 Aluno aluno = instaciaAluno(rs, dao);
		 
		             // adicionando o objeto � lista
		             alunos.add(aluno);
		         }
		         rs.close();
		         stmt.close();
		         return alunos;
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }

		private Aluno instaciaAluno(ResultSet rs, TurmaDao dao) throws SQLException, Exception {
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
			 String area = rs.getString("area");
			 long idTurma = rs.getInt("id_turma");
			 
			 Turma turma = dao.getList().get(getIndex(dao.getList(), idTurma));
			 
			 Aluno aluno = new Aluno(id, login, password, name, lastName, data, tel, email, sex, nivel, area,turma);
			return aluno;
		}
		
		public void edit(Aluno aluno) {
			String sql = "Update aluno set login = ? , password = ? , first_name = ?, last_name = ?, "
					+ "dt_birth = ?, tel = ?, email = ?, sex = ?, permission_lvl = ?, area = ?, id_tuma = ?"
					+ " where id_user = ?";
			
			dao.edit(aluno);

			try {
				// Prepared Statement para inser��o
				PreparedStatement stmt = connection.prepareStatement(sql);

				// set os valores
				stmt.setLong(10, aluno.getId());
				stmt.setString(1, aluno.getLogin());
				stmt.setString(2, aluno.getPassword());
				stmt.setString(3, aluno.getFirstName());
				stmt.setString(4, aluno.getLastName());
				stmt.setDate(5,new java.sql.Date(aluno.getCalendarBirth().getTimeInMillis()));
				stmt.setString(6, aluno.getTel());
				stmt.setString(7, aluno.getEmail());
				stmt.setString(8, aluno.getSex());
				stmt.setInt(9, aluno.getNivel());
				stmt.setString(10, aluno.getArea());
				stmt.setLong(11, aluno.getTurma().getId_turma());

				// executa
				stmt.execute();
				stmt.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		public void remove(Aluno aluno) {
			
			dao.remove(aluno);
			
		     try {
		         PreparedStatement stmt = connection
		                 .prepareStatement("delete from aluno where id_user=?");
		         stmt.setLong(1, aluno.getId());
		         stmt.execute();
		         stmt.close();
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		}
		
		private int getIndex(ArrayList<Turma> list, long id){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getId_turma() == id) return i;
			}
			return -1;
		}
}
