package br.com.davi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.davi.factory.Connectiondb;
import br.com.davi.model.Paciente;

public class PacienteDAO {
	public void insertPaciente(Paciente paciente) {
		String sql = "INSERT INTO pacientes(id,nome,cpf,dt_nascimento) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, paciente.getId());
			pstm.setString(2, paciente.getNome());
			pstm.setString(3, paciente.getCpf());
			pstm.setDate(4, (Date) paciente.getDt_nascimento());
			
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

	public List<Paciente> selectPacientes(){
		String sql = "SELECT * FROM pacientes";
		
		List<Paciente> pacientes = new ArrayList<Paciente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		
		try {
			conn =  Connectiondb.createConnectiondb();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Paciente pct = new Paciente();
				
				pct.setId(rset.getInt("id"));
				pct.setNome(rset.getString("nome"));
				pct.setCpf(rset.getString("cpf"));
				pct.setDt_nascimento(rset.getDate("dt_nascimento"));
				
				pacientes.add(pct);
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
		
		return pacientes;
	}

	public void updatePaciente(Paciente paciente) {
		String sql = "UPDATE pacientes SET nome = ?, cpf = ?, dt_nascimento = ?"+" WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Connectiondb.createConnectiondb();
		
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, paciente.getNome());
			pstm.setString(2, paciente.getCpf());
			pstm.setDate(3, (Date) paciente.getDt_nascimento());
			pstm.setInt(4, paciente.getId());
			
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

	public void deletePacienteById(int id) {
		String sql = "DELETE FROM pacientes WHERE id = ?";
		
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
