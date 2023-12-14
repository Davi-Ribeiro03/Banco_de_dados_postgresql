package br.com.davi.model;

import java.util.Date;

public class Especialidade_medica extends GenericModel {
	private String observacao;
	private Date dt_conclusao;
	private int id_especialidade;
	private int id_medico;
	
	
	public Especialidade_medica() {};
	public Especialidade_medica(int id,String observacao, Date dt_conclusao, int id_especialidade, int id_medico) {
		super.setId(id);
		this.observacao = observacao;
		this.dt_conclusao = dt_conclusao;
		this.id_especialidade = id_especialidade;
		this.id_medico = id_medico;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Date getDt_conclusao() {
		return dt_conclusao;
	}
	public void setDt_conclusao(Date dt_conclusao) {
		this.dt_conclusao = dt_conclusao;
	}
	public int getId_especialidade() {
		return id_especialidade;
	}
	public void setId_especialidade(int id_especialidade) {
		this.id_especialidade = id_especialidade;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	
}
