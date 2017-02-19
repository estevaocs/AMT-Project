package br.com.itsstecnologia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.itsstecnologia.jdbc.ConnectionFactory;
import br.com.itsstecnologia.jdbc.model.Celula;

public class CelulaDao {
	
	private Connection connection;
	
	public CelulaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void add(Celula celula) {
		String sql = "INSERT INTO celula (id_celula, nome, descricao) VALUES (?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, celula.getId_celula());
			stmt.setString(2, celula.getNome());
			stmt.setString(3, celula.getDescricao());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Celula> getList() {
		String sql = "SELECT * FROM celula";
		ArrayList<Celula> list = new ArrayList<Celula>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				long id = rs.getLong("id_celula");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				
				Celula cel = new Celula(id, nome, descricao);
				
				list.add(cel);
			}
			
			rs.close();
			stmt.close();
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void edit(Celula celula) {
		String sql = "UPDATE celula SET nome = ?, descricao =? WHERE id_celula = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, celula.getNome());
			stmt.setString(2, celula.getDescricao());
			stmt.setLong(3, celula.getId_celula());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Celula celula) {
		String sql = "DELETE FROM celula WHERE id_celula = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, celula.getId_celula());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
