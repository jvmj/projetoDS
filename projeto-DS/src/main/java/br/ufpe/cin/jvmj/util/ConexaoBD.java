package br.ufpe.cin.jvmj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	
	
	public static Connection conectarBD(){
		

		String url = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=Teste;user=SA;password=password";
		Connection conexao = null;
		
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexao = DriverManager.getConnection(url);
			System.out.println("Conexao realizada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao carregar o driver");
			e.printStackTrace();
		}
		
		return conexao;

	}
	
	public static void closeConnection(Connection c, PreparedStatement pstm, ResultSet rs) {
		
		try {
			if (c != null) {
				c.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



