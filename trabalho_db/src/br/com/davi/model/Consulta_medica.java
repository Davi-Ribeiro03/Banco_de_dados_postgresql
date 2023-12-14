package br.com.davi.model;

import java.util.Date;

public class Consulta_medica extends GenericModel {

	private String assinatura;
	private Date dt_consulta;
	private int id_paciente;
	private int id_medico;
	
	public Consulta_medica() {};
	public Consulta_medica(int id,String assinatura, Date dt_consulta, int id_paciente, int id_medico) {
		super.setId(id);
		this.assinatura = assinatura;
		this.dt_consulta = dt_consulta;
		this.id_paciente = id_paciente;
		this.id_medico = id_medico;
	}
	
	public String getAssinatura() {
		return assinatura;
	}
	public void setAssinatura(String assinatura) {
		this.assinatura = assinatura;
	}
	public Date getDt_consulta() {
		return dt_consulta;
	}
	public void setDt_consulta(Date dt_consulta) {
		this.dt_consulta = dt_consulta;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	
	
}
