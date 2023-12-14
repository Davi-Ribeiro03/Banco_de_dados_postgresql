package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Estrutura_lente;

public class Estrutura_lenteDAO {

	
	public void insertEstrutura_lente(Estrutura_lente estrutura_lente) {
		String sql = "INSERT INTO estruturas_lentes(id,tipo_correcao,distancia_pupilar,id_receita_oculos) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, estrutura_lente.getId());
			pstm.setString(2, estrutura_lente.getTipo_correcao());
			pstm.setInt(4, estrutura_lente.getDistancia_pupilar());
			pstm.setInt(5, estrutura_lente.getId_receita_oculos());
			
			
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

	public List<Estrutura_lente> selectEstruturas_lentes(){
		String sql = "SELECT * FROM estruturas_lentes";
		
		List<Estrutura_lente> estruturas_lentes = new ArrayList<Estrutura_lente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Estrutura_lente cst = new Estrutura_lente();
				
				cst.setId(rset.getInt("id"));
				cst.setTipo_correcao(rset.getString("tipo_correcao"));
				cst.setDistancia_pupilar(rset.getInt("distancia_pupilar"));
				cst.setId_receita_oculos(rset.getInt("id_receita_oculos"));
				
				estruturas_lentes.add(cst);
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
		
		return estruturas_lentes;
	}

	public void updateEstrutura_lente(Estrutura_lente estrutura_lente) {
		String sql = "UPDATE estruturas_lentes SET tipo_correcao = ?, dt_consulta = ?, distancia_pupilar = ?, id_receita_oculos = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, estrutura_lente.getTipo_correcao());
			pstm.setInt(3, estrutura_lente.getDistancia_pupilar());
			pstm.setInt(4, estrutura_lente.getId_receita_oculos());
			pstm.setInt(5, estrutura_lente.getId());
			
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

	public void deleteEstrutura_lenteById(int id) {
		String sql = "DELETE FROM estruturas_lentes WHERE id = ?";
		
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
