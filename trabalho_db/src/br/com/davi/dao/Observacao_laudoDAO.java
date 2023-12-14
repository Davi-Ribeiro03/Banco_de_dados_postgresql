package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Observacao_laudo;

public class Observacao_laudoDAO {

	
	public void insertObservacao_laudo(Observacao_laudo observacao_laudo) {
		String sql = "INSERT INTO observacoes_laudos(id,descricao,id_receita_oculos) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, observacao_laudo.getId());
			pstm.setString(2, observacao_laudo.getDescricao());
			pstm.setInt(3, observacao_laudo.getId_receita_oculos());
			
			
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

	public List<Observacao_laudo> selectObservacoes_laudos(){
		String sql = "SELECT * FROM observacoes_laudos";
		
		List<Observacao_laudo> observacoes_laudos = new ArrayList<Observacao_laudo>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Observacao_laudo esp = new Observacao_laudo();
				
				esp.setId(rset.getInt("id"));
				esp.setDescricao(rset.getString("descricao"));
				esp.setId_receita_oculos(rset.getInt("id_receita_oculos"));
				
				observacoes_laudos.add(esp);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
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
		
		return observacoes_laudos;
	}

	public void updateObservacao_laudo(Observacao_laudo observacao_laudo) {
		String sql = "UPDATE observacoes_laudos SET descricao = ?, id_receita_oculos = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, observacao_laudo.getDescricao());
			pstm.setInt(2, observacao_laudo.getId_receita_oculos());
			pstm.setInt(3, observacao_laudo.getId());
			
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

	public void deleteObservacao_laudoById(int id) {
		String sql = "DELETE FROM observacoes_laudos WHERE id = ?";
		
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
