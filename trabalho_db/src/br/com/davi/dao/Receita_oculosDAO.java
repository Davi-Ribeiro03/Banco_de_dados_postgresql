package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Receita_oculos;

public class Receita_oculosDAO {

	
	public void insertReceita_oculos(Receita_oculos receita_oculos) {
		String sql = "INSERT INTO receitas_oculos(id,detalhamento,dt_consulta,id_consulta_medica) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, receita_oculos.getId());
			pstm.setString(2, receita_oculos.getDetalhamento());
			pstm.setDate(3, (java.sql.Date) receita_oculos.getDt_consulta());
			pstm.setInt(4, receita_oculos.getId_consulta_medica());
			
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

	public List<Receita_oculos> selectReceitas_oculos(){
		String sql = "SELECT * FROM receitas_oculos";
		
		List<Receita_oculos> receitas_oculos = new ArrayList<Receita_oculos>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Receita_oculos rcto = new Receita_oculos();
				
				rcto.setId(rset.getInt("id"));
				rcto.setDetalhamento(rset.getString("detalhamento"));
				rcto.setDt_consulta(rset.getDate("dt_consulta"));
				rcto.setId_consulta_medica(rset.getInt("id_consulta_medica"));
				
				
				receitas_oculos.add(rcto);
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
		
		return receitas_oculos;
	}

	public void updateReceita_oculos(Receita_oculos receita_oculos) {
		String sql = "UPDATE receitas_oculos SET detalhamento = ?, dt_consulta = ?, id_consulta_medica = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, receita_oculos.getDetalhamento());
			pstm.setDate(2, (java.sql.Date) receita_oculos.getDt_consulta());
			pstm.setInt(3, receita_oculos.getId_consulta_medica());
			pstm.setInt(5, receita_oculos.getId());
			
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

	public void deleteReceita_oculosById(int id) {
		String sql = "DELETE FROM receitas_oculos WHERE id = ?";
		
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
