package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Celula;
import br.com.itsstecnologia.jdbc.model.DiaSemana;

public class DiaSemanaDao {

	Connection connection;
	
	public DiaSemanaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void add(DiaSemana dia) {
		String sql = "INSERT INTO dia_semana (id_dia, id_mt1, id_mt2, id_mt3, id_vp1, id_vp2, id_vp3)"
				+ " VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, dia.getId_dia());
			stmt.setLong(2, dia.getMt1().getId_celula());
			stmt.setLong(3, dia.getMt2().getId_celula());
			stmt.setLong(4, dia.getMt3().getId_celula());
			stmt.setLong(5, dia.getVp1().getId_celula());
			stmt.setLong(6, dia.getVp2().getId_celula());
			stmt.setLong(7, dia.getVp3().getId_celula());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<DiaSemana> getList() {
		String sql = "SELECT * FROM dia_semana";
		ArrayList<DiaSemana> list = new ArrayList<>();
		CelulaDao dao = new CelulaDao();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				long id = rs.getLong("id_dia");
				Celula mt1 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_mt1")));
				Celula mt2 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_mt2")));
				Celula mt3 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_mt3")));
				Celula vp1 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_vp1")));
				Celula vp2 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_vp2")));
				Celula vp3 = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_vp3")));
				
				DiaSemana dia = new DiaSemana(id, mt1, mt2, mt3, vp1, vp2, vp3);
				
				list.add(dia);
			}
			
			rs.close();
			stmt.close();
			return list;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void edit(DiaSemana dia) {
		String sql = "UPDATE dia_semana SET id_mt1 = ?, id_mt2 = ?, id_mt3 = ?, id_vp1 = ?, id_vp2 = ?, id_vp3 = ?"
				+ "WHERE id_dia = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, dia.getMt1().getId_celula());
			stmt.setLong(2, dia.getMt2().getId_celula());
			stmt.setLong(3, dia.getMt3().getId_celula());
			stmt.setLong(4, dia.getVp1().getId_celula());
			stmt.setLong(5, dia.getVp2().getId_celula());
			stmt.setLong(6, dia.getVp3().getId_celula());
			stmt.setLong(7, dia.getId_dia());
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delet(DiaSemana dia) {
		String sql = "DELET FORM dia_semana WHERE id_dia = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, dia.getId_dia());
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getIndex(ArrayList<Celula> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId_celula() == id) return i;
		}
		return -1;
	}
}
