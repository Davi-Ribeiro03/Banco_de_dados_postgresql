package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Especificacao_lente;

public class Especificacao_lenteDAO {

	public void insertEspecificacao_lente(Especificacao_lente especificacao_lente) {
		String sql = "INSERT INTO especificacoes_lentes(id,valor,id_estrutura_lente,id_atributo_estrutura_lente) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, especificacao_lente.getId());
			pstm.setFloat(2, especificacao_lente.getValor());
			pstm.setInt(4, especificacao_lente.getId_estrutura_lente());
			pstm.setInt(5, especificacao_lente.getId_atributo_estrutura_lente());
			
			
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

	public List<Especificacao_lente> selectEspecificacoes_lentes(){
		String sql = "SELECT * FROM especificacoes_lentes";
		
		List<Especificacao_lente> especificacoes_lentes = new ArrayList<Especificacao_lente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Especificacao_lente cst = new Especificacao_lente();
				
				cst.setId(rset.getInt("id"));
				cst.setValor(rset.getFloat("valor"));
				cst.setId_estrutura_lente(rset.getInt("id_estrutura_lente"));
				cst.setId_atributo_estrutura_lente(rset.getInt("id_atributo_estrutura_lente"));
				
				especificacoes_lentes.add(cst);
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
		
		return especificacoes_lentes;
	}

	public void updateEspecificacao_lente(Especificacao_lente especificacao_lente) {
		String sql = "UPDATE especificacoes_lentes SET valor = ?, dt_consulta = ?, id_estrutura_lente = ?, id_atributo_estrutura_lente = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, especificacao_lente.getValor());
			pstm.setInt(3, especificacao_lente.getId_estrutura_lente());
			pstm.setInt(4, especificacao_lente.getId_atributo_estrutura_lente());
			pstm.setInt(5, especificacao_lente.getId());
			
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

	public void deleteEspecificacao_lenteById(int id) {
		String sql = "DELETE FROM especificacoes_lentes WHERE id = ?";
		
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
