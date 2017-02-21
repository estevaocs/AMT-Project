package br.com.itsstecnologia.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroDeAudiotoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest reqst, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) reqst;
		String uri = req.getRequestURI();
		System.out.println("Usuario acessando a URI: " + uri);
		chain.doFilter(reqst, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}
