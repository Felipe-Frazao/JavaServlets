package br.com.felipe.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

public class ListaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresa();
		
		
		//despacha a request para o arquivo jsp, com um apelido de uma variavel ou lista
		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";
	}
	
}
