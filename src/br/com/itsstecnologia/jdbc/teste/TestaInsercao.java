package br.com.itsstecnologia.jdbc.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import br.com.itsstecnologia.jdbc.dao.UserDao;
import br.com.itsstecnologia.jdbc.model.User;

public class TestaInsercao {

	public static Scanner scn = new Scanner(System.in);
	public static UserDao dao = new UserDao();
	public static ArrayList<User> lista = new ArrayList<User>();

	public static void main(String[] args) {
		int op;
		boolean sair = false;
		
		
		do {
			System.out.println("digite a opcao");
			System.out.println("1 - login");
			System.out.println("2 - cadastro");
			System.out.println("3 - ver todos os usuarios");
			System.out.println("0 - sair");
			
			op =  scn.nextInt();
			switch(op) {
				case 1:
					login(args);
					break;
				case 2:
					cadastro(args);
					break;
				case 3:
					verUsuarios(args);
					break;
				case 0:
					sair = true;
					break
				default:
					System.out.println("Tente novamente");
					main(args);
			}
		} while (sair == false);
		
		scn.close();
		System.exit(0);
	}

	private static void verUsuarios(String[] args) {
		
	}

	private static void cadastro(String[] args) {
		lista = dao.getLista();
		
		long id = Integer.toUnsignedLong(lista.size());
		String login;
		String password;
		String first_name;
		String last_name;
		Calendar dt_birth;
		String tel;
		String email;
		String sex;
		int area;
		
		System.out.println("Digite o usuario:");
		
	}

	private static void login() {
		String login;
		String senha;
		
		System.out.println("login: ");
		login = scn.nextLine();
		System.out.println("senha: ");
		senha = scn.nextLine();
		
		if(dao.login(login, senha)) {
			System.out.println("logado com sucesso");
		} else {
			System.out.println("usuario e senha invalidos");
		}
	}
	
}
