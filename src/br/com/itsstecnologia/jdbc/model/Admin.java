package br.com.itsstecnologia.jdbc.model;

import java.util.Calendar;

public class Admin extends User {

	public Admin(long id, String login, String password, String firstName, String lastName, Calendar dt, String tel,
			String email, String sex, int nvl) {
		super(id, login, password, firstName, lastName, dt, tel, email, sex, nvl);
	}
	

}
