package br.com.davi.model;

public class Medico extends GenericModel {
	private String nome;
	private String crm;
	
	
	public Medico(int id,String nome, String crm) {
		super.setId(id);
		this.nome = nome;
		this.crm = crm;
	}
	
	public Medico() {}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
}
