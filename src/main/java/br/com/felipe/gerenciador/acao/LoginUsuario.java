package br.com.felipe.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.felipe.gerenciador.banco.Banco;
import br.com.felipe.gerenciador.models.Usuario;

public class LoginUsuario implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		        String login = request.getParameter("login");
		        String senha = request.getParameter("senha");

		        

		        Banco banco = new Banco();
		        Usuario usuario = banco.existeUsuario(login, senha); //o metodo verifica se o usuario enserido nosd campos existe
		        
		        if(usuario != null) {// se o metodo retornar um usuario, a pagina sera redirecionada para a lista de empresas 
		        	System.out.println("Usuario existe");
		        	HttpSession sessao = request.getSession();
		            sessao.setAttribute("usuarioLogado", usuario);
		            System.out.println("Logando " + login);
		        	return "redirect:entrada?acao=ListaEmpresa";
		        }

		        return "redirect:entrada?acao=LoginForm";//caso o metodo retorne um usuario null, a paginasera redirecionada novante para a mesma
	 }

}
