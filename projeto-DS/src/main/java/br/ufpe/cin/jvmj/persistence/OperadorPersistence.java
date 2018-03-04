package br.ufpe.cin.jvmj.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.ufpe.cin.jvmj.essentials.Operador;
import br.ufpe.cin.jvmj.util.ConexaoBD;

public class OperadorPersistence {
	
	public void addOperador (Operador operador) {
		
			Connection conexao = ConexaoBD.conectarBD();
			
			PreparedStatement pstm = null;
			
			int id = operador.getId();
			String name = operador.getToken();
			int idOperadorTipo = operador.getIdOperadorTipo();
			
			String sql = "INSERT into Operador VALUES (?,?,?)";
			
			try {
				pstm = conexao.prepareStatement(sql);
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setInt(3, idOperadorTipo);
				pstm.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConexaoBD.closeConnection(conexao, pstm, null);
			}
	}


	
	public Vector<Operador> buscarOperadorPorTipo (int idOperadorTipo){
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<Operador> resultadoFinal = new Vector<Operador>();
		
		String sql = "SELECT * FROM Operador WHERE idOperadorTipo = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idOperadorTipo);
			rs = pstm.executeQuery();
				
			while (rs.next()) {
				Operador operador = new Operador();
				operador.setId(rs.getInt("idOperador"));
				operador.setToken(rs.getString("token"));
				operador.setIdOperadorTipo(rs.getInt("idOperadorTipo"));
				
				resultadoFinal.add(operador);
			}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConexaoBD.closeConnection(conexao, pstm, rs);
			
			}
		
		return resultadoFinal;
		}
	
	
	public Operador buscarOperadorPorId (int idOperador) {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Operador operadorResultado = new Operador();
		
		String sql = "SELECT * FROM operador WHERE idOperador = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idOperador);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				operadorResultado.setId(rs.getInt("idOperador"));
				operadorResultado.setToken(rs.getString("token"));
				operadorResultado.setIdOperadorTipo(rs.getInt("idOperadorTipo"));
				
			}
					
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, rs);
		}
		
		return operadorResultado;
	}
		
}
