package br.com.felipe.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

/**
 * Servlet implementation class ListaEmpresaServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresa();
		
		
		//despacha a request para o arquivo jsp, com um apelido de uma variavel ou lista
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");		
		request.setAttribute("empresas", lista);
		rd.forward(request, response);
		
	}

}
