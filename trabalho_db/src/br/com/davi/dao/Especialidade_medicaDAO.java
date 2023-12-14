package br.com.davi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Especialidade_medica;

public class Especialidade_medicaDAO {

	
	public void insertEspecialidade_medica(Especialidade_medica especialidade_medica) {
		String sql = "INSERT INTO especialidades_medicas(id,observacao,dt_conclusao,id_especialidade,id_medico) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, especialidade_medica.getId());
			pstm.setString(2, especialidade_medica.getObservacao());
			pstm.setDate(3, (Date) especialidade_medica.getDt_conclusao());
			pstm.setInt(4, especialidade_medica.getId_especialidade());
			pstm.setInt(5, especialidade_medica.getId_medico());
			
			
			pstm.execute();		
			
			System.out.println("Salvo no banco com sucesso!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Especialidade_medica> selectEspecialidades_medicas(){
		String sql = "SELECT * FROM especialidades_medicas";
		
		List<Especialidade_medica> especialidades_medicas = new ArrayList<Especialidade_medica>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Especialidade_medica espm = new Especialidade_medica();
				
				espm.setId(rset.getInt("id"));
				espm.setObservacao(rset.getString("observacao"));
				espm.setDt_conclusao(rset.getDate("dt_conclusao"));
				espm.setId_especialidade(rset.getInt("id_especialidade"));
				espm.setId_medico(rset.getInt("id_medico"));
				
				especialidades_medicas.add(espm);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return especialidades_medicas;
	}

	public void updateEspecialidade_medica(Especialidade_medica especialidade_medica) {
		String sql = "UPDATE especialidades_medicas SET observacao = ?, dt_conclusao = ?, id_especialidade = ?, id_medico = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, especialidade_medica.getObservacao());
			pstm.setDate(2, (Date) especialidade_medica.getDt_conclusao());
			pstm.setInt(3, especialidade_medica.getId_especialidade());
			pstm.setInt(4, especialidade_medica.getId_medico());
			pstm.setInt(5, especialidade_medica.getId());
			
			pstm.execute();
			
			System.out.println("Update realizado com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteEspecialidade_medicaById(int id) {
		String sql = "DELETE FROM especialidades_medicas WHERE id = ?";
		
		Connection conn =  null;
		PreparedStatement pstm= null;
		
		try {
			conn = Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
		
			pstm.execute();
			
			System.out.println("Delete realizado com sucesso");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
