package br.com.davi.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectiondb {

	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/davi_oftaldb";
	
	public static Connection createConnectiondb() throws Exception {
		Class.forName("org.postgresql.Driver");
		
		Connection connection =  DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectiondb();
		
		if(con != null) {
			System.out.println("Conexão com o banco de dados gerada com sucesso! ");
			con.close();
		}
	}
}
