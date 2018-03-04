package br.ufpe.cin.jvmj.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.ufpe.cin.jvmj.essentials.ConfEnvio;
import br.ufpe.cin.jvmj.util.ConexaoBD;

public class ConfEnvioPersistence {
	
	public void addConfEnvio(ConfEnvio confEnvio) {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		
		String sql = "INSERT INTO confEnvio (idOperadorAutorizado, idOperador, idTipoArquivo, idTipoAplicacaoCaptura) VALUES (?,?,?,?)";
		
		try {
			
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, confEnvio.getIdOperadorAutorizado());
			pstm.setInt(2, confEnvio.getIdOperador());
			pstm.setInt(3, confEnvio.getIdTipoArquivo());
			pstm.setInt(4, confEnvio.getIdTipoAplicacaoCaptura());
			pstm.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, null);
		}
		
	}
	
	public int findMaxIdConfEnvio() {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = "SELECT MAX(id) FROM confEnvio";
		int id = 1;
		
		try {
			pstm = conexao.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()) {
				id = rs.getInt(1);
				if (id == 0) return 1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, rs);
		}
		
		return id;
	}
	
	public Vector<ConfEnvio> buscarConfsEnvio (int idOperador, int idTipoArquivo, int idTipoAplicacaoCaptura){
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<ConfEnvio> resultadoFinal = new Vector<ConfEnvio>();
		
		String sql = "SELECT * FROM confEnvio  WHERE idOperador = ? AND idTipoArquivo = ? AND idTipoAplicacaoCaptura = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idOperador);
			pstm.setInt(2, idTipoArquivo);
			pstm.setInt(3, idTipoAplicacaoCaptura);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ConfEnvio confEnvio = new ConfEnvio();
				confEnvio.setId(rs.getInt("id"));
				confEnvio.setIdOperadorAutorizado(rs.getInt("idOperadorAutorizado"));
				confEnvio.setIdOperador(rs.getInt("idOperador"));
				confEnvio.setIdTipoArquivo(rs.getInt("idTipoArquivo"));
				confEnvio.setIdTipoAplicacaoCaptura(rs.getInt("idTipoAplicacaoCaptura"));
				
				resultadoFinal.add(confEnvio);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, rs);
		}
		
		return resultadoFinal;
	}
	

}
