package br.ufpe.cin.jvmj.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import br.ufpe.cin.jvmj.essentials.Envio;
import br.ufpe.cin.jvmj.util.ConexaoBD;

public class EnvioPersistence {
	
	public void addEnvio(Envio envio) {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		
		String sql = "INSERT INTO Envio (dataEnvio, idOperador, idArquivo, idTipoArquivo, idTipoAplicacaoCaptura) VALUES (?,?,?,?,?)";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, envio.getDataEnvio());
			pstm.setInt(2, envio.getIdOperador());
			pstm.setInt(3, envio.getIdArquivo());
			pstm.setInt(4, envio.getIdTipoArquivo());
			pstm.setInt(5, envio.getIdTipoAplicacaoCaptura());
			pstm.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, null);
		}
	}

	
	public Vector<Envio> filtrarEnvios(int idTipoAplicacaoCaptura, int idTipoArquivo, String data){
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Vector<Envio> resultadoFinal = new Vector<Envio>();
		
		String sql = "SELECT * FROM envio WHERE idTipoAplicacaoCaptura = ? OR idArquivo = ? OR dataEnvio = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idTipoAplicacaoCaptura);
			pstm.setInt(2, idTipoArquivo);
			pstm.setString(3, data);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Envio envio = new Envio();
				envio.setId(rs.getInt("id"));
				envio.setDataEnvio(rs.getString("dataEnvio"));
				envio.setIdOperador(rs.getInt("idOperador"));
				envio.setIdArquivo(rs.getInt("idArquivo"));
				envio.setIdTipoArquivo(rs.getInt("idTipoArquivo"));
				envio.setIdTipoAplicacaoCaptura(rs.getInt("idTipoAplicacaoCaptura"));
				
				resultadoFinal.add(envio);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, rs);
		}
		
		return resultadoFinal;
	}
	
	
	public int findMaxIdEnvio() {
			
			Connection conexao = ConexaoBD.conectarBD();
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			String sql = "SELECT MAX(id) FROM Envio";
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

}
