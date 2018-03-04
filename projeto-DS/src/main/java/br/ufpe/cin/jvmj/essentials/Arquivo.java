package br.ufpe.cin.jvmj.essentials;

public class Arquivo {
	
	private int id;
	private String name;
	private String imagem; // foi utilizado o tipo String para prova de conceito. Eh preciso investigar o formato melhor adequado no banco de dados, uma vez que em java seria um array de bytes.
	
	private int idArquivoTipo;
	

	public Arquivo(String name, String imagem, int idArquivoTipo) {
		this.name = name;
		this.imagem = imagem;
		this.idArquivoTipo = idArquivoTipo;
	}

	public Arquivo() {
		super();
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public int getIdArquivoTipo() {
		return idArquivoTipo;
	}


	public void setIdArquivoTipo(int idArquivoTipo) {
		this.idArquivoTipo = idArquivoTipo;
	}
	
}
