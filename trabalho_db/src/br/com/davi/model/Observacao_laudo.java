package br.com.davi.model;

public class Observacao_laudo extends GenericModel {

	private String descricao;
	private int id_receita_oculos;
	
	public Observacao_laudo() {};
	public Observacao_laudo(int id, String descricao, int id_receita_oculos) {
		super.setId(id);
		this.descricao = descricao;
		this.id_receita_oculos = id_receita_oculos;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId_receita_oculos() {
		return id_receita_oculos;
	}
	public void setId_receita_oculos(int id_receita_oculos) {
		this.id_receita_oculos = id_receita_oculos;
	}
	
}
