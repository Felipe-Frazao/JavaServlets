package br.com.felipe.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.acao.Acao;

public class ControladorFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("ControladorFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
		
		
        String acao = request.getParameter("acao");
		String frente = null;
		String caminho = "br.com.felipe.gerenciador.acao." + acao;		
		
		try {
			Acao classe = (Acao) Class.forName(caminho).newInstance();//carrega a classe com o nome 
			frente = classe.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		String[] quebraFrente = frente.split(":");
		
		if(quebraFrente[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + quebraFrente[1]);		
			rd.forward(request, response);
		}else {
			//redireciona para uma JSP, nao e necessario colocar o formato de arquivo
			response.sendRedirect(quebraFrente[1]);
		}
		
        
	}

}
