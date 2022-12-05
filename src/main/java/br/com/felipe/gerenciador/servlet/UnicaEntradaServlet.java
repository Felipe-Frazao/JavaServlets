package br.com.felipe.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.felipe.gerenciador.acao.Acao;
import br.com.felipe.gerenciador.acao.AlteraEmpresa;
import br.com.felipe.gerenciador.acao.ListaEmpresa;
import br.com.felipe.gerenciador.acao.MostraEmpresa;
import br.com.felipe.gerenciador.acao.NovaEmpresa;
import br.com.felipe.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada") utilizando o controladorFilter por hora
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
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
		
		
//		if(acao.equals("ListaEmpresa")) {
//			ListaEmpresa lista = new ListaEmpresa();
//			frente = lista.executa(request, response);
//		}else if(acao.equals("AlteraEmpresa")) {
//			AlteraEmpresa altera = new AlteraEmpresa();
//			frente = altera.executa(request, response);
//		}else if(acao.equals("RemoveEmpresa")) {
//			RemoveEmpresa removida = new RemoveEmpresa();
//			frente = removida.executa(request, response);
//		}else if(acao.equals("MostraEmpresa")) {
//			MostraEmpresa mostra = new MostraEmpresa();
//			frente = mostra.executa(request, response);
//		}else if(acao.equals("NovaEmpresa")) {
//			NovaEmpresa nova = new NovaEmpresa();
//			frente = nova.executa(request, response);
//		}else if(acao.equals("NovaEmpresaForm")) {
//			NovaEmpresaForm nova = new NovaEmpresaForm();
//			frente = nova.executa(request, response);
//		}
		
		
		
		
	}

}
