package br.ufpe.cin.jvmj.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* Classe responsavel por gerar as tabelas e alguns dados
 * 
 */
public class PopulaBD {

	public static void populaBD() {
		
		Connection conexao = ConexaoBD.conectarBD();
		PreparedStatement pstm = null;
		
		String sql = "CREATE TABLE Teste.dbo.operadorTipo (\n" + 
				"	idOperadorTipo int NOT NULL IDENTITY(1,1),\n" + 
				"	name varchar(100) NOT NULL,\n" + 
				"	CONSTRAINT operadorTipo_PK PRIMARY KEY (idOperadorTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.operadorTipo\n" + 
				"VALUES ('administrador'), ('comum');\n" + 
				"\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.operador (\n" + 
				"	idOperador int NOT NULL IDENTITY(1,1),\n" + 
				"	token varchar(100) NOT NULL,\n" + 
				"	idOperadorTipo int NOT NULL,\n" + 
				"	CONSTRAINT operador_PK PRIMARY KEY (idOperador),\n" + 
				"	CONSTRAINT operador_operadorTipo_FK FOREIGN KEY (idOperadorTipo) REFERENCES Teste.dbo.operadorTipo(idOperadorTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.operador\n" + 
				"VALUES ('tokenjulio',1), ('tokenbruna',1), ('tokenluna',2), ('tokenhercules',2);\n" + 
				"\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.aplicacaoTipo(\n" + 
				"	idAplicacaoTipo int NOT NULL IDENTITY(1,1),\n" + 
				"	name varchar(100) NOT NULL,\n" + 
				"	CONSTRAINT aplicacaoTipo_PK PRIMARY KEY (idAplicacaoTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.aplicacaoTipo\n" + 
				"VALUES ('web'), ('mobile'), ('desktop');\n" + 
				"\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.arquivoTipo (\n" + 
				"	idArquivoTipo int NOT NULL IDENTITY(1,1),\n" + 
				"	name varchar(100) NOT NULL,\n" + 
				"	CONSTRAINT arquivoTipo_PK PRIMARY KEY (idArquivoTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.arquivoTipo\n" + 
				"VALUES ('txt'), ('pdf'), ('docd'), ('jpg'), ('tif');\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.arquivo (\n" + 
				"	idArquivo int NOT NULL IDENTITY(1,1),\n" + 
				"	name varchar(100) NOT NULL,\n" + 
				"	imagem varchar(100) NOT NULL,\n" + 
				"	idArquivoTipo int NOT NULL,\n" + 
				"	CONSTRAINT arquivo_PK PRIMARY KEY (idArquivo),\n" + 
				"	CONSTRAINT arquivo_arquivoTipo_FK FOREIGN KEY (idArquivoTipo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo)\n" + 
				")\n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.arquivo\n" + 
				"VALUES ('arquivo1.pdf','arraydebytestestearquivo1',  2), ('foto_doc.jpg', 'arraydebytestestearquivofoto_doc', 4), ('teste3.txt', 'arraydebytestxt', 1), ('documento.pdf','arraydebytesdocumento', 2), ('digitalizar3.pdf', 'arraydebytesdigitalizar3', 2);\n" + 
				"\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.confEnvio (\n" + 
				"	id int NOT NULL IDENTITY(1,1),\n" + 
				"	idOperadorAutorizado int NOT NULL,\n" + 
				"	idOperador int NOT NULL,\n" + 
				"	idTipoArquivo int NOT NULL,\n" + 
				"	idTipoAplicacaoCaptura int NOT NULL,\n" + 
				"	CONSTRAINT confEnvio_PK PRIMARY KEY (id),\n" + 
				"	CONSTRAINT confEnvio_operadorAutorizado_FK FOREIGN KEY (idOperadorAutorizado) REFERENCES Teste.dbo.operador(idOperador),\n" + 
				"	CONSTRAINT confEnvio_operador_FK FOREIGN KEY (idOperador) REFERENCES Teste.dbo.operador(idOperador),\n" + 
				"	CONSTRAINT confEnvio_arquivoTipo_FK FOREIGN KEY (idTipoArquivo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo),\n" + 
				"	CONSTRAINT confEnvio_aplicacaoTipo_FK FOREIGN KEY (idTipoAplicacaoCaptura) REFERENCES Teste.dbo.aplicacaoTipo(idAplicacaoTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.confEnvio\n" + 
				"VALUES (1,1,2,1), (1,1,2,2), (1,1,2,3), (1,3,2,2), (2,2,4,2),(2,4,4,2);\n" + 
				"\n" + 
				"\n" + 
				"CREATE TABLE Teste.dbo.envio (\n" + 
				"	id int NOT NULL IDENTITY(1,1),\n" + 
				"	dataEnvio varchar(100) NOT NULL,\n" + 
				"	idOperador int NOT NULL,\n" + 
				"	idArquivo int NOT NULL,\n" + 
				"	idTipoArquivo int NOT NULL,\n" + 
				"	idTipoAplicacaoCaptura int NOT NULL,\n" + 
				"	CONSTRAINT envio_PK PRIMARY KEY (id),\n" + 
				"	CONSTRAINT envio_operador_FK FOREIGN KEY (idOperador) REFERENCES Teste.dbo.operador(idOperador),\n" + 
				"	CONSTRAINT envio_arquivo_FK FOREIGN KEY (idArquivo) REFERENCES Teste.dbo.arquivo(idArquivo),\n" + 
				"	CONSTRAINT envio_arquivoTipo_FK FOREIGN KEY (idTipoArquivo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo),\n" + 
				"	CONSTRAINT envio_aplicacaoTipo_FK FOREIGN KEY (idTipoAplicacaoCaptura) REFERENCES Teste.dbo.aplicacaoTipo(idAplicacaoTipo)\n" + 
				") \n" + 
				"\n" + 
				"INSERT INTO Teste.dbo.Envio\n" + 
				"VALUES ('2018-03-04',1,1,2,1), ('2018-02-01',3,5,2,1), ('2018-01-01',2,2,4,2);";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConexaoBD.closeConnection(conexao, pstm, null);
		}
	}
}
