package br.com.davi.main;

import java.sql.Date;
import java.util.List;

import br.com.davi.dao.Atributo_estrutura_lenteDAO;
import br.com.davi.dao.Consulta_medicaDAO;
import br.com.davi.dao.EspecialidadeDAO;
import br.com.davi.dao.Especialidade_medicaDAO;
import br.com.davi.dao.Especificacao_lenteDAO;
import br.com.davi.dao.Estrutura_lenteDAO;
import br.com.davi.dao.MedicoDAO;
import br.com.davi.dao.Observacao_laudoDAO;
import br.com.davi.dao.PacienteDAO;
import br.com.davi.dao.Receita_oculosDAO;
import br.com.davi.model.Atributo_estrutura_lente;
import br.com.davi.model.Especialidade;
import br.com.davi.model.Especialidade_medica;
import br.com.davi.model.Medico;
import br.com.davi.model.Paciente;

public class Main {

	public static void main(String[] args) {
		EspecialidadeDAO especialidadeDao = new EspecialidadeDAO();
		
		
		//INSERT ESPECIALIDADES
//		Especialidade especialidade = new Especialidade();
//		especialidade.setId(2);
//		especialidade.setDescricao("Concentra-se na miopia, hipermetropia, astigmatismo e presbiopia, muitas vezes utilizando procedimentos cirúrgicos, como LASIK.");
//		especialidade.setConselho("Conselho Brasileiro de Oftalmologia (CBO)");
		
//		
//		especialidadeDao.insertEspecialidade(especialidade);
		
		
		//SELECT ALL ESPECIALIDADES
//		for(Especialidade esp : especialidadeDao.selectEspecialidades()) {
//			System.out.println("Id: " +esp.getId());
//			System.out.println("Descrição: "+esp.getDescricao());
//			System.out.println("Conselho: "+esp.getConselho());
//		}
		
		
		//UPDATE ESPECIALIDADES
//		Especialidade esp = new Especialidade();
//		esp.setId(1);
//		esp.setDescricao("Descrição update teste");
//		esp.setConselho("Conselho update teste");
//		
//		especialidadeDao.updateEspecialidade(esp);
		
		
		//DELETE ESPECIALIDADE
//		especialidadeDao.deleteEspecialidadeById(1);
		
		
		
//***********************************************************************************************************************************************
		
		MedicoDAO medicoDao = new MedicoDAO();
		
		//INSERT MEDICO
//		Medico medico = new Medico(1,"Description Test","CRM/SP 123456");
//		
//		medicoDao.insertMedico(medico);
		
		
		//SELECT ALL MEDICOS
//		for(Medico mdc : medicoDao.selectMedicos()) {
//			System.out.println("Id: " +mdc.getId());
//			System.out.println("Nome: "+mdc.getNome());
//			System.out.println("Crm: "+mdc.getCrm());
//	}
		
		
		//UPDATE MEDICOS
//		Medico mdc = new Medico(1,"Descrição update teste","Conselho update teste");
//		
//		medicoDao.updateMedico(mdc);
		
		
		//DELETE MEDICO
//		medicoDao.deleteMedicoById(1);
		
		
		
		//***********************************************************************************************************************************************
		
				Atributo_estrutura_lenteDAO atributo_estrutura_lenteDAO = new Atributo_estrutura_lenteDAO();
				
				//INSERT Atributo_estrutura_lente
//				Atributo_estrutura_lente atributo_estrutura_lente = new Atributo_estrutura_lente(1,"Description Test atributo_estrutura_lente","Esquerdo");
//				
//				atributo_estrutura_lenteDAO.insertAtributo_estrutura_lente(atributo_estrutura_lente);
				
				
				//SELECT ALL Atributos_estrutura_lente
//				for(Atributo_estrutura_lente atb : Atributo_estrutura_lenteDAO.selectAtributos_estrutura_lente()) {
//					System.out.println("Id: " +atb.getId());
//					System.out.println("Descrição: "+atb.getDescricao());
//					System.out.println("Lado do olho: "+atb.getLado_olho());
//			}
				
				
				//UPDATE Atributo_estrutura_lente
//				Atributo_estrutura_lente atb = new Atributo_estrutura_lente(1,"Descrição update teste Atributo_estrutura_lente ","Conselho update teste Atributo_estrutura_lente");
//				
//				atributo_estrutura_lenteDAO.updateAtributo_estrutura_lente(atb);
				
				
				//DELETE Atributo_estrutura_lente
//				atributo_estrutura_lenteDAO.deleteAtributo_estrutura_lenteById(1);
			
		
		
//***********************************************************************************************************************************************
				
				PacienteDAO pacienteDAO = new PacienteDAO();
				
				//INSERT Paciente
//				Paciente paciente = new Paciente(1,"João","00000000000",new Date(2004, 1, 26));
//				
//				pacienteDAO.insertPaciente(paciente);
				
				
				//SELECT ALL Pacientes
//				for(Paciente pct : pacienteDAO.selectPacientes()) {
//					System.out.println("Id: " +pct.getId());
//					System.out.println("Nome: "+pct.getNome());
//					System.out.println("Cpf: "+pct.getCpf());
//					System.out.println("Data de nascimento: "+pct.getDt_nascimento());
//			}
				
				
				//UPDATE Paciente
//				Paciente pct = new Paciente(1,"João Update","00000000001",new Date(2000, 10, 21));
				
//				pacienteDAO.updatePaciente(pct);
				
				
				//DELETE Paciente
//				pacienteDAO.deletePacienteById(1);				
		
		
				
//***********************************************************************************************************************************************
		
		Especialidade_medicaDAO especialidade_medicaDAO = new Especialidade_medicaDAO();
//		
		//INSERT Especialidade_medica
//		Especialidade_medica especialidade_medica = new Especialidade_medica(1,"obs teste",new Date(20,10,2002), 1, 1);
//		
//		especialidade_medicaDAO.insertEspecialidade_medica(especialidade_medica);
		
		
		//SELECT ALL Especialidades_medicas
//		for(Especialidade_medica esp : especialidade_medicaDAO.selectEspecialidades_medicas()) {
//			System.out.println("Id: " +esp.getId());
//			System.out.println("Observação: "+esp.getObservacao());
//			System.out.println("Data de conclusão: "+esp.getDt_conclusão());
//			System.out.println("id_especialidade: "+esp.getId_especialidade());
//			System.out.println("id_medico: "+esp.getId_medico());
//	}
		
		//UPDATE Especialidade_medica
//		Especialidade_medica esp = new Especialidade_medica(1,"obs teste Update",new Date(2000, 10, 21),1,1);
		
//		especialidade_medicaDAO.updateEspecialidade_medica(esp);
		
		
		//DELETE Especialidade_medica
//		pacienteDAO.deleteEspecialidade_medicaById(1);	
		
		
//***********************************************************************************************************************************************
		
				Consulta_medicaDAO consulta_medicaDAO = new Consulta_medicaDAO();
//				
				//INSERT Consulta_medica
//				Consulta_medica consulta_medica = new Consulta_medica(1,"João",new Date(20,10,2002), 1, 1);
//				
//				consulta_medicaDAO.insertConsulta_medica(consulta_medica);
				
				
				//SELECT ALL Consulta_medica
//				for(Consulta_medica ctm : consulta_medicaDAO.selectConsultas_medicas()) {
//					System.out.println("Id: " +ctm.getId());
//					System.out.println("Assinatura: "+ctm.getAssinatura());
//					System.out.println("Data da consulta: "+ctm.getDt_consulta());
//					System.out.println("id_paciente: "+ctm.getId_paciente());
//					System.out.println("id_medico: "+ctm.getId_medico());
//			}
				
				//UPDATE Consulta_medica
//				Consulta_medica ctm = new Consulta_medica(1,"João Update",new Date(2000, 10, 21),1,1);
				
//				consulta_medicaDAO.updateConsulta_medica(ctm);
				
				
				//DELETE Consulta_medica
//				consulta_medicaDAO.deleteConsulta_medicaById(1);	
				
				
				
//***********************************************************************************************************************************************
				
				Receita_oculosDAO receita_oculosDAO = new Receita_oculosDAO();
//				
				//INSERT Receita_oculos
//				Receita_oculos receita_oculos = new Receita_oculos(1,"Detalhamento teste",new Date(20,10,2002), 1);
//				
//				receita_oculosDAO.insertReceita_oculos(receita_oculos);
				
				
				//SELECT ALL Receita_oculos
//				for(Receita_oculos rcto : receita_oculosDAO.selectReceitas_oculos()) {
//					System.out.println("Id: " +rcto.getId());
//					System.out.println("Detalhamento: "+rcto.getDetalhamento());
//					System.out.println("Data da consulta: "+rcto.getDt_consulta());
//					System.out.println("id_consulta_médica: "+rcto.getId_consulta_medica());
//			}
				
				//UPDATE Receita_oculos
//				Receita_oculos rcto = new Receita_oculos(1,"Detalhamento Update",new Date(2000, 10, 21),1);
				
//				receita_oculosDAO.updateReceita_oculos(rcto);
				
				
				//DELETE Receita_oculos
//				receita_oculosDAO.deleteReceita_oculosById(1);
				
				
//***********************************************************************************************************************************************
				
				Observacao_laudoDAO observacao_laudoDAO = new Observacao_laudoDAO();
//				
				//INSERT Observacao_laudo
//				Observacao_laudo observacao_laudo = new Observacao_laudo(1,"Observação teste", 1);
//				
//				observacao_laudoDAO.insertObservacao_laudo(observacao_laudo);
				
				
				//SELECT ALL Observacao_laudo
//				for(Observacao_laudo obsl : observacao_laudoDAO.selectObservacoes_laudos()) {
//					System.out.println("Id: " +obsl.getId());
//					System.out.println("Observação: "+obsl.getObservacao());
//					System.out.println("id_receita_oculos: "+obsl.getId_receita_oculos());
//			}
				
				//UPDATE Observacao_laudo
//				Observacao_laudo obsl = new Observacao_laudo(1,"Observação Update",1);
				
//				observacao_laudoDAO.updateObservacao_laudo(obsl);
				
				
				//DELETE Observacao_laudo
//				observacao_laudoDAO.deleteObservacao_laudoById(1);	
		
				
				
//***********************************************************************************************************************************************
				
				Estrutura_lenteDAO estrutura_lenteDAO = new Estrutura_lenteDAO();
//				
				//INSERT Estrutura_lente
//				Estrutura_lente estrutura_lente = new Estrutura_lente(1,"Tipo_correção teste", 1,1);
//				
//				estrutura_lenteDAO.insertEstrutura_lente(estrutura_lente);
				
				
				//SELECT ALL Estrutura_lente
//				for(Estrutura_lente etr : estrutura_lenteDAO.selectEstruturas_lentes()) {
//					System.out.println("Id: " +etr.getId());
//					System.out.println("Tipo_correção: "+etr.getTipo_correcao());
//					System.out.println("Distância pupilar: "+etr.getDistancia_pupilar());
//					System.out.println("id_receita_oculos: "+etr.getId_receita_oculos());
//			}
				
				//UPDATE Estrutura_lente
//				Estrutura_lente etr = new Estrutura_lente(1,"Tipo_correção Update",1,1);
				
//				estrutura_lenteDAO.updateEstrutura_lente(etr);
				
				
				//DELETE Estrutura_lente
//				estrutura_lenteDAO.deleteEstrutura_lenteById(1);	
		
				
				
//***********************************************************************************************************************************************
				
				Especificacao_lenteDAO especificacao_lenteDAO = new Especificacao_lenteDAO();
//				
				//INSERT Especificacao_lente
//				Especificacao_lente especificacao_lente = new Especificacao_lente(1,102, 1,1);
//				
//				especificacao_lenteDAO.insertEspecificacao_lente(especificacao_lente);
				
				
				//SELECT ALL Especificacao_lente
//				for(Especificacao_lente esp : especificacao_lenteDAO.selectEspecificacoes_lentes()) {
//					System.out.println("Id: " +esp.getId());
//					System.out.println("Valor: "+esp.getValor());
//					System.out.println("Id_estrutura_lente: "+esp.getId_estrutura_lente());
//					System.out.println("id_atributo_estrutura_lente: "+esp.getId_atributo_estrutura_lente());
//			}
				
				//UPDATE Especificacao_lente
//				Especificacao_lente esp = new Especificacao_lente(1,1000,1,1);
				
//				especificacao_lenteDAO.updateEspecificacao_lente(esp);
				
				
				//DELETE Especificacao_lente
//				especificacao_lenteDAO.deleteEspecificacao_lenteById(1);	
		
 }
}
