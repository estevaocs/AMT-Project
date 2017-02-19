package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.DiaSemana;
import br.com.itsstecnologia.jdbc.model.Horario;

public class HorarioDao {
	
	Connection connection;
	
	public HorarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Horario h) {
		String sql = "INSERT INTO horario (id_hoario, id_seg, id_ter, id_qua, id_qui, id_sex, id_sab, id_dom)"
				+ " VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, h.getId_horario());
			stmt.setLong(2, h.getSeg().id_dia);
			stmt.setLong(3, h.getTer().id_dia);
			stmt.setLong(4, h.getQua().id_dia);
			stmt.setLong(5, h.getQui().id_dia);
			stmt.setLong(6, h.getSex().id_dia);
			stmt.setLong(7, h.getSab().id_dia);
			stmt.setLong(8, h.getDom().id_dia);
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Horario> getList() {
		String sql = "SELECT * FROM horairo";
		ArrayList<Horario> list =  new ArrayList<>();
		DiaSemanaDao dao = new DiaSemanaDao();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Long id_horario = rs.getLong("id_horario");
				DiaSemana seg = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_seg")));
				DiaSemana ter = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_ter")));
				DiaSemana qua = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_qua")));
				DiaSemana qui = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_qui")));
				DiaSemana sex = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_sex")));
				DiaSemana sab = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_sab")));
				DiaSemana dom = dao.getList().get(getIndex(dao.getList(), rs.getLong("id_dom")));
				
				Horario h = new Horario(id_horario, seg, ter, qua, qui, sex, sab, dom);
				
				list.add(h);
			}
			
			rs.close();
			stmt.close();
			return list;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Horario h) {
		String sql = "DELET FROM horario WHERE id_horaio = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong( 1, h.getId_horario());
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private int getIndex(ArrayList<DiaSemana> list, long id){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId_dia() == id) return i;
		}
		return -1;
	}

}
