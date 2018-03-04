CREATE TABLE Teste.dbo.operadorTipo (
	idOperadorTipo int NOT NULL IDENTITY(1,1),
	name varchar(100) NOT NULL,
	CONSTRAINT operadorTipo_PK PRIMARY KEY (idOperadorTipo)
) 

INSERT INTO Teste.dbo.operadorTipo
VALUES ('administrador'), ('comum');


CREATE TABLE Teste.dbo.operador (
	idOperador int NOT NULL IDENTITY(1,1),
	token varchar(100) NOT NULL,
	idOperadorTipo int NOT NULL,
	CONSTRAINT operador_PK PRIMARY KEY (idOperador),
	CONSTRAINT operador_operadorTipo_FK FOREIGN KEY (idOperadorTipo) REFERENCES Teste.dbo.operadorTipo(idOperadorTipo)
) 

INSERT INTO Teste.dbo.operador
VALUES ('tokenjulio',1), ('tokenbruna',1), ('tokenluna',2), ('tokenhercules',2);


CREATE TABLE Teste.dbo.aplicacaoTipo(
	idAplicacaoTipo int NOT NULL IDENTITY(1,1),
	name varchar(100) NOT NULL,
	CONSTRAINT aplicacaoTipo_PK PRIMARY KEY (idAplicacaoTipo)
) 

INSERT INTO Teste.dbo.aplicacaoTipo
VALUES ('web'), ('mobile'), ('desktop');


CREATE TABLE Teste.dbo.arquivoTipo (
	idArquivoTipo int NOT NULL IDENTITY(1,1),
	name varchar(100) NOT NULL,
	CONSTRAINT arquivoTipo_PK PRIMARY KEY (idArquivoTipo)
) 

INSERT INTO Teste.dbo.arquivoTipo
VALUES ('txt'), ('pdf'), ('docd'), ('jpg'), ('tif');

CREATE TABLE Teste.dbo.arquivo (
	idArquivo int NOT NULL IDENTITY(1,1),
	name varchar(100) NOT NULL,
	imagem varchar(100) NOT NULL,
	idArquivoTipo int NOT NULL,
	CONSTRAINT arquivo_PK PRIMARY KEY (idArquivo),
	CONSTRAINT arquivo_arquivoTipo_FK FOREIGN KEY (idArquivoTipo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo)
)

INSERT INTO Teste.dbo.arquivo
VALUES ('arquivo1.pdf','arraydebytestestearquivo1',  2), ('foto_doc.jpg', 'arraydebytestestearquivofoto_doc', 4), ('teste3.txt', 'arraydebytestxt', 1), ('documento.pdf','arraydebytesdocumento', 2), ('digitalizar3.pdf', 'arraydebytesdigitalizar3', 2);


CREATE TABLE Teste.dbo.confEnvio (
	id int NOT NULL IDENTITY(1,1),
	idOperadorAutorizado int NOT NULL,
	idOperador int NOT NULL,
	idTipoArquivo int NOT NULL,
	idTipoAplicacaoCaptura int NOT NULL,
	CONSTRAINT confEnvio_PK PRIMARY KEY (id),
	CONSTRAINT confEnvio_operadorAutorizado_FK FOREIGN KEY (idOperadorAutorizado) REFERENCES Teste.dbo.operador(idOperador),
	CONSTRAINT confEnvio_operador_FK FOREIGN KEY (idOperador) REFERENCES Teste.dbo.operador(idOperador),
	CONSTRAINT confEnvio_arquivoTipo_FK FOREIGN KEY (idTipoArquivo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo),
	CONSTRAINT confEnvio_aplicacaoTipo_FK FOREIGN KEY (idTipoAplicacaoCaptura) REFERENCES Teste.dbo.aplicacaoTipo(idAplicacaoTipo)
) 

INSERT INTO Teste.dbo.confEnvio
VALUES (1,1,2,1), (1,1,2,2), (1,1,2,3), (1,3,2,2), (2,2,4,2),(2,4,4,2);


CREATE TABLE Teste.dbo.envio (
	id int NOT NULL IDENTITY(1,1),
	dataEnvio varchar(100) NOT NULL,
	idOperador int NOT NULL,
	idArquivo int NOT NULL,
	idTipoArquivo int NOT NULL,
	idTipoAplicacaoCaptura int NOT NULL,
	CONSTRAINT envio_PK PRIMARY KEY (id),
	CONSTRAINT envio_operador_FK FOREIGN KEY (idOperador) REFERENCES Teste.dbo.operador(idOperador),
	CONSTRAINT envio_arquivo_FK FOREIGN KEY (idArquivo) REFERENCES Teste.dbo.arquivo(idArquivo),
	CONSTRAINT envio_arquivoTipo_FK FOREIGN KEY (idTipoArquivo) REFERENCES Teste.dbo.arquivoTipo(idArquivoTipo),
	CONSTRAINT envio_aplicacaoTipo_FK FOREIGN KEY (idTipoAplicacaoCaptura) REFERENCES Teste.dbo.aplicacaoTipo(idAplicacaoTipo)
) 

INSERT INTO Teste.dbo.Envio
VALUES ('2018-03-04',1,1,2,1), ('2018-02-01',3,5,2,1), ('2018-01-01',2,2,4,2);