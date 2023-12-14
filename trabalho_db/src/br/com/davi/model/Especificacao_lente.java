package br.com.davi.model;

public class Especificacao_lente extends GenericModel {

	private float valor;
	private int id_estrutura_lente;
	private int id_atributo_estrutura_lente;
	
	public Especificacao_lente() {};
	public Especificacao_lente(int id,float valor, int id_estrutura_lente, int id_atributo_estrutura_lente) {
		super.setId(id);
		this.valor = valor;
		this.id_estrutura_lente = id_estrutura_lente;
		this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getId_estrutura_lente() {
		return id_estrutura_lente;
	}
	public void setId_estrutura_lente(int id_estrutura_lente) {
		this.id_estrutura_lente = id_estrutura_lente;
	}
	public int getId_atributo_estrutura_lente() {
		return id_atributo_estrutura_lente;
	}
	public void setId_atributo_estrutura_lente(int id_atributo_estrutura_lente) {
		this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
	}	
}
