package br.com.felipe.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Empresa;

public class NovaEmpresaForm {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "forward:formNovaEmpresa.jsp";
	}
		
	
}
