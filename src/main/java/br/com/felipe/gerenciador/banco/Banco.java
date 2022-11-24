package br.com.felipe.gerenciador.banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.felipe.gerenciador.models.Empresa;
import br.com.felipe.gerenciador.models.Usuario;

public class Banco {

	private static List<Empresa> list = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Niken");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Uliana");
		
		list.add(empresa2);
		list.add(empresa1);
		
		Usuario u1 = new Usuario();
	    u1.setLogin("nico");
	    u1.setSenha("12345");

	    Usuario u2 = new Usuario();
	    u2.setLogin("ana");
	    u2.setSenha("12345");

	    listaUsuarios.add(u1);
	    listaUsuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.list.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.list;
	}

	public void removeEmpresa(int id) {
		
		Iterator<Empresa> it = list.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = (Empresa) it.next();
			
			if (id == empresa.getId()) {
				it.remove();
			}
		}
	}

	public Empresa alteraEmpresa(int id) {
		Iterator<Empresa> it = list.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = (Empresa) it.next();
			
			if (id == empresa.getId()) {
				return  empresa;
			}
		}
		
		return null;
		
	}

	public Usuario existeUsuario(String login, String senha) {
		//verificacao de usuario, se existe no banco de dados o usuario enserido
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
