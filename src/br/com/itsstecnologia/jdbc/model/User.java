package br.com.itsstecnologia.jdbc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.itsstecnologia.util.Criptografia;

/**
 * @author Estevão Cristino
 *
 */
public class User {

	private long id_user;
	private String login;
	private String password;
	private String first_name;
	private String last_name;
	private Calendar dt_birth;
	private String tel;
	private String email;
	private char sex;
	private int area;
	
	protected SimpleDateFormat formater =  new SimpleDateFormat("dd/MM/yyyy");

	
	//metodos geters e seters
	
	public long getId() {
		return this.id_user;
	}
	
	public String getFirstName() { 
		return this.first_name;
	}
	
	public void setFirstName(String name) {
		this.first_name = name;
	}
	
	public String getLastName() {
		return this.last_name;
	}
	
	public void setLastName(String name) {
		this.last_name = name;
	}
	
	public String getFullyName() {
		return "" + this.getFirstName() + " " + this.getLastName();
	}
	
	/**
	 * Metodo retorna a data de aniversario do usuario
	 * @return Calendar
	 */
	public Calendar getDateBirth() {
		return this.dt_birth;
	}
	
	/**
	 * Metodo que retorna a data de aniversario do usuario já formatada.
	 * @return
	 */
	public String getDateBirthToString() {
		return formater.format(this.dt_birth);
	}
	
	public void setDateBirth(Calendar date) {
		this.dt_birth = date;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	public char getSex() {
		return this.sex;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = Criptografia.criptografar(password);
	}
	
}
