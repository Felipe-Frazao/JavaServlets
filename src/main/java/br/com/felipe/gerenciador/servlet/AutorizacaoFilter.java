package br.com.felipe.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/entrada") //funcionando pelo xml
public class AutorizacaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Autorizacao filtro");
		
		HttpServletRequest request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		String acao = request.getParameter("acao");
		
		
		HttpSession sessao = request.getSession();
		 boolean naoLogado = (sessao.getAttribute("usuarioLogado") == null);
		 boolean Protegida = !(acao.equals("LoginUsuario") || acao.equals("LoginForm"));
		 
		if(naoLogado && Protegida) {
			
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
		

	}

}
