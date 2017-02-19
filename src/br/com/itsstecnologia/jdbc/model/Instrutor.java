package br.com.itsstecnologia.jdbc.model;

import java.util.Calendar;

public class Instrutor extends User {
	
	private String area;
	private Horario horario;

	public Instrutor(long id, String login, String password, String firstName, String lastName,
			Calendar dt, String tel, String email, String sex, int nvl, String area, Horario horario) {
		
		super(id, login, password, firstName, lastName, dt, tel, email, sex, nvl);
		
		this.area =  area;
		this.horario = horario;
		
	}
	
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario, String periodo) {
		if(periodo.equals("matutino")) {
			this.horario.getDom().setMt1(horario.getDom().mt1);
			this.horario.getDom().setMt2(horario.getDom().mt2);
			this.horario.getDom().setMt3(horario.getDom().mt3);
			this.horario.getSeg().setMt1(horario.getSeg().mt1);
			this.horario.getSeg().setMt2(horario.getSeg().mt2);
			this.horario.getSeg().setMt3(horario.getSeg().mt3);
			this.horario.getTer().setMt1(horario.getTer().mt1);
			this.horario.getTer().setMt2(horario.getTer().mt2);
			this.horario.getTer().setMt3(horario.getTer().mt3);
			this.horario.getQua().setMt1(horario.getQua().mt1);
			this.horario.getQua().setMt2(horario.getQua().mt2);
			this.horario.getQua().setMt3(horario.getQua().mt3);
			this.horario.getQui().setMt1(horario.getQui().mt1);
			this.horario.getQui().setMt2(horario.getQui().mt2);
			this.horario.getQui().setMt3(horario.getQui().mt3);
			this.horario.getSex().setMt1(horario.getSex().mt1);
			this.horario.getSex().setMt2(horario.getSex().mt2);
			this.horario.getSex().setMt3(horario.getSex().mt3);
			this.horario.getSab().setMt1(horario.getSab().mt1);
			this.horario.getSab().setMt2(horario.getSab().mt2);
			this.horario.getSab().setMt3(horario.getSab().mt3);

		} else if(periodo.equals("vespertino")) {
			this.horario.getDom().setVp1(horario.getDom().vp1);
			this.horario.getDom().setVp2(horario.getDom().vp2);
			this.horario.getDom().setVp3(horario.getDom().vp3);
			this.horario.getSeg().setVp1(horario.getSeg().vp1);
			this.horario.getSeg().setVp2(horario.getSeg().vp2);
			this.horario.getSeg().setVp3(horario.getSeg().vp3);
			this.horario.getTer().setVp1(horario.getTer().vp1);
			this.horario.getTer().setVp2(horario.getTer().vp2);
			this.horario.getTer().setVp3(horario.getTer().vp3);
			this.horario.getQua().setVp1(horario.getQua().vp1);
			this.horario.getQua().setVp2(horario.getQua().vp2);
			this.horario.getQua().setVp3(horario.getQua().vp3);
			this.horario.getQui().setVp1(horario.getQui().vp1);
			this.horario.getQui().setVp2(horario.getQui().vp2);
			this.horario.getQui().setVp3(horario.getQui().vp3);
			this.horario.getSex().setVp1(horario.getSex().vp1);
			this.horario.getSex().setVp2(horario.getSex().vp2);
			this.horario.getSex().setVp3(horario.getSex().vp3);
			this.horario.getSab().setVp1(horario.getSab().vp1);
			this.horario.getSab().setVp2(horario.getSab().vp2);
			this.horario.getSab().setVp3(horario.getSab().vp3);
		}
	}
	
	
}
