package br.com.felipe.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

public class RemoveEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		banco.removeEmpresa(Integer.parseInt(request.getParameter("id")));
		
		
		return "redirect:entrada?acao=ListaEmpresa";
		
	}
	
}
