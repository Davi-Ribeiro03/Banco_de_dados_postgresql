package br.com.davi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Especialidade;

public class EspecialidadeDAO {

	public void insertEspecialidade(Especialidade especialidade) {
		String sql = "INSERT INTO especialidades(id,descricao,conselho) VALUES (?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Tenta conectar com o banco de dados
			conn =  Connectiondb.createConnectiondb();
			
			//Preparar o sql
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, especialidade.getId());
			pstm.setString(2, especialidade.getDescricao());
			pstm.setString(3, especialidade.getConselho());
			
			//Executar o sql
			pstm.execute();		
			
			System.out.println("Salvo no banco com sucesso!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
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

	public List<Especialidade> selectEspecialidades(){
		String sql = "SELECT * FROM especialidades";
		
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			//Tenta conectar com o banco de dados
			conn =  Connectiondb.createConnectiondb();
			
			//Preparar o sql
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Especialidade esp = new Especialidade();
				
				esp.setId(rset.getInt("id"));
				esp.setDescricao(rset.getString("descricao"));
				esp.setConselho(rset.getString("conselho"));
				
				especialidades.add(esp);
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
		
		return especialidades;
	}

	public void updateEspecialidade(Especialidade especialidade) {
		String sql = "UPDATE especialidades SET descricao = ?, conselho = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, especialidade.getDescricao());
			pstm.setString(2, especialidade.getConselho());
			pstm.setInt(3, especialidade.getId());
			
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

	public void deleteEspecialidadeById(int id) {
		String sql = "DELETE FROM especialidades WHERE id = ?";
		
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

