package br.com.itsstecnologia.jdbc.model;

public class Horario {
	
	private long id_horario;
	private DiaSemana seg;
	private DiaSemana ter;
	private DiaSemana qua;
	private DiaSemana qui;
	private DiaSemana sex;
	private DiaSemana sab;
	private DiaSemana dom;
	
	public Horario(long id_horario, DiaSemana seg, DiaSemana ter, DiaSemana qua, DiaSemana qui, DiaSemana sex,
			DiaSemana sab, DiaSemana dom) {
		
		this.id_horario = id_horario;
		this.seg = seg;
		this.ter = ter;
		this.qua = qua;
		this.qui = qui;
		this.sex = sex;
		this.sab = sab;
		this.dom = dom;
	}

	public long getId_horario() {
		return id_horario;
	}

	public void setId_horario(long id_horario) {
		this.id_horario = id_horario;
	}

	public DiaSemana getSeg() {
		return seg;
	}

	public void setSeg(DiaSemana seg) {
		this.seg = seg;
	}

	public DiaSemana getTer() {
		return ter;
	}

	public void setTer(DiaSemana ter) {
		this.ter = ter;
	}

	public DiaSemana getQua() {
		return qua;
	}

	public void setQua(DiaSemana qua) {
		this.qua = qua;
	}

	public DiaSemana getQui() {
		return qui;
	}

	public void setQui(DiaSemana qui) {
		this.qui = qui;
	}

	public DiaSemana getSex() {
		return sex;
	}

	public void setSex(DiaSemana sex) {
		this.sex = sex;
	}

	public DiaSemana getSab() {
		return sab;
	}

	public void setSab(DiaSemana sab) {
		this.sab = sab;
	}

	public DiaSemana getDom() {
		return dom;
	}

	public void setDom(DiaSemana dom) {
		this.dom = dom;
	}
	
}
