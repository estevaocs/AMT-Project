package br.com.itsstecnologia.jdbc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.itsstecnologia.util.Criptografia;

/**
 * @author Estev�o Cristino
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
	private String sex;
	private int nvl_acesso;
	
	protected SimpleDateFormat formater =  new SimpleDateFormat("dd/MM/yyyy");
	
	public User(long id, String login, String password, String firstName, String lastName, Calendar dt, String tel,
			String email, String sex, int nvl) {
		this.id_user = id;
		this.login = login;
		this.password = Criptografia.criptografar(password);
		this.first_name = firstName;
		this.last_name = lastName;
		this.dt_birth = dt;
		this.tel = tel;
		this.email = email;
		this.sex = sex;
		this.nvl_acesso = nvl;

	}
	
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
	public Calendar getCalendarBirth() {
		return this.dt_birth;
	}
	
	/**
	 * Metodo que retorna a data de aniversario do usuario j� formatada.
	 * @return
	 */
	public String getCalendarBirthToString() {
		return formater.format(this.dt_birth);
	}
	
	public void setCalendarBirth(Calendar date) {
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
	
	public String getSex() {
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
	
	public int getNivel() {
		return this.nvl_acesso;
	}
	
	public void setNivel(int nvl) {
		this.nvl_acesso = nvl;
	}
	
}
