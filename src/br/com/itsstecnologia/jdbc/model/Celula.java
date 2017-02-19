package br.com.itsstecnologia.jdbc.model;

public class Celula {

	private long id_celula;
	private String nome;
	private String descricao;
	
	public Celula(long id_celula, String nome, String descricao) {
		super();
		this.id_celula = id_celula;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public long getId_celula() {
		return id_celula;
	}
	
	public void setId_celula(long id_celula) {
		this.id_celula = id_celula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
