package br.com.itsstecnologia.jdbc.model;

import java.util.Calendar;

public class Aluno extends User {

	private String area;
	private Turma turma;
	
	
	
	public Aluno(long id, String login, String password, String firstName, String lastName, Calendar dt, String tel,
			String email, String sex, int nvl, String area, Turma turma) {
		
		super(id, login, password, firstName, lastName, dt, tel, email, sex, nvl);
		
		this.area = area;
		this.turma = turma;
		
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public int getDayOfBirth() {
		return Integer.parseInt(getCalendarBirthToString().substring(0,3));
	}
	
	public int getMonthOfBirth() {
		return Integer.parseInt(getCalendarBirthToString().substring(4,6));
	}
	
	public int getYearOfBirth() {
		return Integer.parseInt(getCalendarBirthToString().substring(7));
	}
}
