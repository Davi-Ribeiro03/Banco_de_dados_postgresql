package br.com.davi.model;

import java.util.Date;

public class Receita_oculos extends GenericModel {
	private String detalhamento;
	private Date dt_consulta;
	private int id_consulta_medica;
	
	public Receita_oculos() {};
	public Receita_oculos(int id,String detalhamento, Date dt_consulta, int id_consulta_medica) {
		super.setId(id);
		this.detalhamento = detalhamento;
		this.dt_consulta = dt_consulta;
		this.id_consulta_medica = id_consulta_medica;
	}
	public String getDetalhamento() {
		return detalhamento;
	}
	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}
	public Date getDt_consulta() {
		return dt_consulta;
	}
	public void setDt_consulta(Date dt_consulta) {
		this.dt_consulta = dt_consulta;
	}
	public int getId_consulta_medica() {
		return id_consulta_medica;
	}
	public void setId_consulta_medica(int id_consulta_medica) {
		this.id_consulta_medica = id_consulta_medica;
	}
	
}
