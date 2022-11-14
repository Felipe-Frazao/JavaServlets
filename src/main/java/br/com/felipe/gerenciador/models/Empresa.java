package br.com.felipe.gerenciador.models;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public void setNome(String nomeEmpresa) {
		this.nome = nomeEmpresa;
		
	}
	
	public String getNome() {
		return this.nome;
	}

}
