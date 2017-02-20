package br.com.itsstecnologia.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.itsstecnologia.jdbc.dao.UserDao;
import br.com.itsstecnologia.jdbc.model.User;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		User usuario = new UserDao().doLogin(login, password);
		PrintWriter wrt = resp.getWriter();
		if(usuario ==  null) {
			wrt.println("<html><body>Usuário Invalido</body></html>");
		} else {
			Cookie cookie = new Cookie("Usuário.logado", usuario.getFullyName());
			resp.addCookie(cookies);
			wrt.println("<html><body>Usuário logado: " + usuario.getFullyName() +"</body></html>");
		}
	}
	
}
