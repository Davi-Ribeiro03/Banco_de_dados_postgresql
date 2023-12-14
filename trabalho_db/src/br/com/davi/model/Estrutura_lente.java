package br.com.davi.model;

public class Estrutura_lente extends GenericModel {
	private String tipo_correcao;
	private int distancia_pupilar;
	private int id_receita_oculos;
	
	public Estrutura_lente() {};
	public Estrutura_lente(int id, String tipo_correcao, int distancia_pupilar, int id_receita_oculos) {
		super.setId(id);
		this.tipo_correcao = tipo_correcao;
		this.distancia_pupilar = distancia_pupilar;
		this.id_receita_oculos = id_receita_oculos;
	}
	
	public String getTipo_correcao() {
		return tipo_correcao;
	}
	public void setTipo_correcao(String tipo_correcao) {
		this.tipo_correcao = tipo_correcao;
	}
	public int getDistancia_pupilar() {
		return distancia_pupilar;
	}
	public void setDistancia_pupilar(int distancia_pupilar) {
		this.distancia_pupilar = distancia_pupilar;
	}
	public int getId_receita_oculos() {
		return id_receita_oculos;
	}
	public void setId_receita_oculos(int id_receita_oculos) {
		this.id_receita_oculos = id_receita_oculos;
	}	
}
