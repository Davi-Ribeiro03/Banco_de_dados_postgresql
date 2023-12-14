package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Medico;

public class MedicoDAO {

	
	public void insertMedico(Medico medico) {
		String sql = "INSERT INTO medicos(id,nome,crm) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, medico.getId());
			pstm.setString(2, medico.getNome());
			pstm.setString(3, medico.getCrm());
			
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

	public List<Medico> selectMedicos(){
		String sql = "SELECT * FROM medicos";
		
		List<Medico> medicos = new ArrayList<Medico>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Medico mdc = new Medico();
				
				mdc.setId(rset.getInt("id"));
				mdc.setNome(rset.getString("nome"));
				mdc.setCrm(rset.getString("crm"));
				
				medicos.add(mdc);
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
		
		return medicos;
	}

	public void updateMedico(Medico medico) {
		String sql = "UPDATE medicos SET nome = ?, crm = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, medico.getNome());
			pstm.setString(2, medico.getCrm());
			pstm.setInt(3, medico.getId());
			
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

	public void deleteMedicoById(int id) {
		String sql = "DELETE FROM medicos WHERE id = ?";
		
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
