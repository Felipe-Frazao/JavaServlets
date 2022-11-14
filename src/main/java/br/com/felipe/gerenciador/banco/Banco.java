package br.com.felipe.gerenciador.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.gerenciador.models.Empresa;

public class Banco {

	private static List<Empresa> list = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Niken");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Uliana");
		
		list.add(empresa2);
		list.add(empresa1);
	}
	
	public void adiciona(Empresa empresa) {
		Banco.list.add(empresa);
		
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.list;
	}

}
