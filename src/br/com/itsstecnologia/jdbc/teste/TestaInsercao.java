package br.com.itsstecnologia.jdbc.teste;

import java.util.Scanner;

import br.com.itsstecnologia.jdbc.dao.UserDao;

public class TestaInsercao {

	public static void main(String[] args) {
		String login;
		String password;
		
		Scanner scn = new Scanner(System.in);
		UserDao dao = new UserDao();
		
		System.out.println("login: ");
		login = scn.nextLine();
		
		System.out.println("password: ");
		password = scn.nextLine();
		
		if(dao.login(login, password)) {
			System.out.println("logado com sucesso");
		} else {
			System.out.println("usuario ou senha invalido");
		}
		
		scn.close();
	}
	
}
