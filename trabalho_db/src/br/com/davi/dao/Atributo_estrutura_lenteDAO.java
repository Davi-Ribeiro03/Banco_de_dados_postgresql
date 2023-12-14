package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Atributo_estrutura_lente;

public class Atributo_estrutura_lenteDAO {
	
	
	public void insertAtributo_estrutura_lente(Atributo_estrutura_lente atributo_estrutura_lente) {
		String sql = "INSERT INTO atributos_estrutura_lente(id,descricao,lado_olho) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, atributo_estrutura_lente.getId());
			pstm.setString(2, atributo_estrutura_lente.getDescricao());
			pstm.setString(3, atributo_estrutura_lente.getLado_olho());
			
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

	public List<Atributo_estrutura_lente> selectAtributos_estrutura_lente(){
		String sql = "SELECT * FROM atributos_estrutura_lente";
		
		List<Atributo_estrutura_lente> atributos_estrutura_lente = new ArrayList<Atributo_estrutura_lente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Atributo_estrutura_lente atb = new Atributo_estrutura_lente();
				
				atb.setId(rset.getInt("id"));
				atb.setDescricao(rset.getString("descricao"));
				atb.setLado_olho(rset.getString("lado_olho"));
				
				atributos_estrutura_lente.add(atb);
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
		
		return atributos_estrutura_lente;
	}

	public void updateAtributo_estrutura_lente(Atributo_estrutura_lente atributo_estrutura_lente) {
		String sql = "UPDATE atributos_estrutura_lente SET nome = ?, crm = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, atributo_estrutura_lente.getDescricao());
			pstm.setString(2, atributo_estrutura_lente.getLado_olho());
			pstm.setInt(3, atributo_estrutura_lente.getId());
			
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

	public void deleteAtributo_estrutura_lenteById(int id) {
		String sql = "DELETE FROM atributos_estrutura_lente WHERE id = ?";
		
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
