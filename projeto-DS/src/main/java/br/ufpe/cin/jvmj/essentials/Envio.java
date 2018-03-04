package br.ufpe.cin.jvmj.essentials;


public class Envio {
	
	private int id;
	/*
	 * Foi utilizado o tipo String para prova de conceito. 
	 * O correto seria usar Date, mas precisaria verificar qual formato seria adequado em banco de dados.
	 */
	private String dataEnvio;
	
	private int idOperador;
	private int idArquivo;
	private int idTipoArquivo;
	private int idTipoAplicacaoCaptura;
	
	public Envio(String dataEnvio, int idOperador, int idArquivo, int idTipoArquivo, int idTipoAplicacaoCaptura) {
		this.dataEnvio = dataEnvio;
		this.idOperador = idOperador;
		this.idArquivo = idArquivo;
		this.idTipoArquivo = idTipoArquivo;
		this.idTipoAplicacaoCaptura = idTipoAplicacaoCaptura;
	}
	
	public Envio() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public int getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}

	public int getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(int idArquivo) {
		this.idArquivo = idArquivo;
	}
	
	public int getIdTipoArquivo() {
		return idTipoArquivo;
	}

	public void setIdTipoArquivo(int idTipoArquivo) {
		this.idTipoArquivo = idTipoArquivo;
	}

	public int getIdTipoAplicacaoCaptura() {
		return idTipoAplicacaoCaptura;
	}

	public void setIdTipoAplicacaoCaptura(int idTipoAplicacaoCaptura) {
		this.idTipoAplicacaoCaptura = idTipoAplicacaoCaptura;
	}
	
}
