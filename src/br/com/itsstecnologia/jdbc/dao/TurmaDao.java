package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Horario;
import br.com.itsstecnologia.jdbc.model.Instrutor;
import br.com.itsstecnologia.jdbc.model.Turma;

public class TurmaDao {

	private Connection connection;

	public TurmaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Turma turma) {
		String sql = "INSERT INTO turma (id_turma, id_instrutor, id_horario, area, local, periodo)"
				+ " values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, turma.getId_turma());
			stmt.setLong(2, turma.getInstrutor().getId());
			stmt.setLong(3, turma.getHorario().getId_horario());
			stmt.setString(4, turma.getArea());
			stmt.setString(5, turma.getLocal());
			stmt.setString(6, turma.getPeriodo());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void edit(Turma turma) {
		String sql = "UPDATE turma SET id_instrutor = ?, id_horario = ?, area = ?, local = ?, periodo = ? "
				+ "WHERE id_turma = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, turma.getInstrutor().getId());
			stmt.setLong(2, turma.getHorario().getId_horario());
			stmt.setString(3, turma.getArea());
			stmt.setString(4, turma.getLocal());
			stmt.setString(5, turma.getPeriodo());
			stmt.setLong(6, turma.getId_turma());
			
			stmt.execute();
			stmt.close();
			
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Turma turma) {
		String sql = "DELET FROM turma WHERE id_turma = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, turma.getId_turma());
			
			stmt.execute();
			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
				
	}
	
	public ArrayList<Turma> getList() {
		ArrayList<Turma> list = new ArrayList<Turma>();
		String sql = "SELECT * FROM turma";
		InstrutorDao daoInst = new InstrutorDao();
		HorarioDao daoHor = new HorarioDao();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				long id = rs.getLong("id_turma");
				Instrutor inst = daoInst.getLista().get(getIndexInst(daoInst.getLista(), rs.getLong("id_instrutor")));
				Horario hor = daoHor.getList().get(getIndex(daoHor.getList(), rs.getLong("id_horario")));
				String area = rs.getString("area");
				String local = rs.getString("local");
				String periodo = rs.getString("periodo");
				
				Turma turma = new Turma(id, inst, hor, area, local, periodo);
				
				list.add(turma);
			}

			rs.close();
			stmt.close();
			return list;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private int getIndexInst(ArrayList<Instrutor> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) return i;
		}
		return -1;
	}
	
	private int getIndex(ArrayList<Horario> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId_horario() == id) return i;
		}
		return -1;
	}
}
