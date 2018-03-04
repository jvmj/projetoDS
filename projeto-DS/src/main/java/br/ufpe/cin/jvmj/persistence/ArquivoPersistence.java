package br.ufpe.cin.jvmj.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufpe.cin.jvmj.essentials.Arquivo;
import br.ufpe.cin.jvmj.util.ConexaoBD;

public class ArquivoPersistence {

	
	
	public void addArquivo(Arquivo arquivo) {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		
		String sql = "INSERT INTO arquivo (name, imagem, idArquivoTipo) VALUES (?,?,?)";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, arquivo.getName());
			pstm.setString(2, arquivo.getImagem());
			pstm.setInt(3, arquivo.getIdArquivoTipo());
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, null);
		}
	}
	
	
	public Arquivo buscarArquivoPorId(int idArquivo) {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Arquivo arquivoResultado = new Arquivo();
		
		String sql = "SELECT * FROM arquivo WHERE idArquivo = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idArquivo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				arquivoResultado.setId(rs.getInt("idArquivo"));
				arquivoResultado.setName(rs.getString("name"));
				arquivoResultado.setImagem(rs.getString("imagem"));
				arquivoResultado.setIdArquivoTipo(rs.getInt("idArquivoTipo"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, rs);
		}
		
		return arquivoResultado;
		
	}
}
