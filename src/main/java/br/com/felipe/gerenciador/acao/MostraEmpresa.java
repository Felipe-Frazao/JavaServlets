package br.com.felipe.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		Empresa empresa = banco.alteraEmpresa(Integer.parseInt(request.getParameter("id")));
		

		request.setAttribute("empresa", empresa);

		
		return "forward:alteraEmpresa.jsp";
	}
		

}
