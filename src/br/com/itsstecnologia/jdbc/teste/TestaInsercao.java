package br.com.itsstecnologia.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.itsstecnologia.jdbc.dao.AdminDao;
import br.com.itsstecnologia.jdbc.model.Admin;
import br.com.itsstecnologia.jdbc.model.User;

public class TestaInsercao {

	public static Scanner scn = new Scanner(System.in);
	public static AdminDao dao = new AdminDao();
	public static ArrayList<User> lista = new ArrayList<User>();
	private static Scanner sc;

	public static void main(String[] args) throws java.text.ParseException {
		try {
			sc = new Scanner(System.in);
			SimpleDateFormat formater =  new SimpleDateFormat("dd/MM/yyyy");
			
			long id = 1;
			String login;
			String password;
			String name;
			String lastName;
			String data;
			Calendar dt = Calendar.getInstance();
			String tel;
			String email;
			String sex;
			int nvl = 1;
		
			System.out.println("login:");
			login = sc.nextLine();
			System.out.println("password:");
			password = sc.nextLine();
			System.out.println("nome");
			name = sc.nextLine();
			System.out.println("sobrenome");
			lastName = sc.nextLine();
			System.out.println("data:");
			data = sc.nextLine();
			dt.setTime(formater.parse(data));
			System.out.println("tel");
			tel = sc.nextLine();
			System.out.println("email");
			email = sc.nextLine();
			System.out.println("sexo");
			sex = sc.nextLine();
		
		
		
			Admin adm = new Admin(id, login, password, name, lastName, dt, tel, email, sex, nvl);
			dao.add(adm);
			
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
