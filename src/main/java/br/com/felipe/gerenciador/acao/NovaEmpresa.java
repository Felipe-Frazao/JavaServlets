package br.com.felipe.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

public class NovaEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter(); // = response.getWriter().print("d");
				String nomeEmpresa = request.getParameter("nome");
				
				String dataAbertura = request.getParameter("data");
				
				SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
				Date dataFormated = null;
				try {
					dataFormated = stf.parse(dataAbertura);
				} catch (ParseException e) {
					throw new ServletException(e);
				}
				
				Empresa empresa = new Empresa();
				empresa.setNome(nomeEmpresa);
				empresa.setDataAbertura(dataFormated);
				
				Banco banco = new Banco();
				banco.adiciona(empresa);
				
				System.out.println(empresa.getNome());
//				RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
//				request.setAttribute("empresa", empresa.getNome());
//				rd.forward(request, response);
				
				return "redirect:entrada?acao=ListaEmpresa";
	}
	
}
