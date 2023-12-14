package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Consulta_medica;

public class Consulta_medicaDAO {
	
	public void insertConsulta_medica(Consulta_medica consulta_medica) {
		String sql = "INSERT INTO consultas_medicas(id,assinatura,dt_consulta,id_paciente,id_medico) VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, consulta_medica.getId());
			pstm.setString(2, consulta_medica.getAssinatura());
			pstm.setDate(3, (java.sql.Date) consulta_medica.getDt_consulta());
			pstm.setInt(4, consulta_medica.getId_paciente());
			pstm.setInt(5, consulta_medica.getId_medico());
			
			
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

	public List<Consulta_medica> selectConsultas_medicas(){
		String sql = "SELECT * FROM consultas_medicas";
		
		List<Consulta_medica> consultas_medicas = new ArrayList<Consulta_medica>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Consulta_medica cst = new Consulta_medica();
				
				cst.setId(rset.getInt("id"));
				cst.setAssinatura(rset.getString("assinatura"));
				cst.setDt_consulta(rset.getDate("dt_consulta"));
				cst.setId_paciente(rset.getInt("id_paciente"));
				cst.setId_medico(rset.getInt("id_medico"));
				
				consultas_medicas.add(cst);
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
		
		return consultas_medicas;
	}

	public void updateConsulta_medica(Consulta_medica consulta_medica) {
		String sql = "UPDATE consultas_medicas SET assinatura = ?, dt_consulta = ?, id_paciente = ?, id_medico = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, consulta_medica.getAssinatura());
			pstm.setDate(2, (java.sql.Date) consulta_medica.getDt_consulta());
			pstm.setInt(3, consulta_medica.getId_paciente());
			pstm.setInt(4, consulta_medica.getId_medico());
			pstm.setInt(5, consulta_medica.getId());
			
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

	public void deleteConsulta_medicaById(int id) {
		String sql = "DELETE FROM consultas_medicas WHERE id = ?";
		
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
