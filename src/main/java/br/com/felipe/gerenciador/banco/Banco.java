package br.com.felipe.gerenciador.banco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.felipe.gerenciador.models.Empresa;

public class Banco {

	private static List<Empresa> list = new ArrayList<Empresa>();
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

}
