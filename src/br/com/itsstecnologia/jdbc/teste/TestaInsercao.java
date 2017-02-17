package br.com.itsstecnologia.jdbc.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.itsstecnologia.jdbc.dao.UserDao;
import br.com.itsstecnologia.jdbc.model.User;

public class TestaInsercao {

	public static void main(String[] args) {
		try {
			String data = "13/03/1995";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(data));

			User usuario = new User(1, "admin", "admin", "Estev�o", "Cristino", cal, "(62) 9939-29119",
					"estevao.silva@itsstecnologica.com.br", "M", 1);

			// grave nessa conex�o!!!
			UserDao dao = new UserDao();

			// m�todo elegante
			dao.add(usuario);

			System.out.println("Gravado!");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
