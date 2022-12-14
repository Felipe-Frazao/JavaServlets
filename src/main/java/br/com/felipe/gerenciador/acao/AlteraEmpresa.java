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

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		Date data = null;
		SimpleDateFormat sft = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = sft.parse(request.getParameter("data"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		Banco banco = new Banco();
		
		Empresa emp = banco.alteraEmpresa(id);
        emp.setNome(nome);
        emp.setDataAbertura(data);
		
		return "redirect:entrada?acao=ListaEmpresa";
		
	}
	
}
