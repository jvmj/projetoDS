package br.ufpe.cin.jvmj.essentials;

public class ConfEnvio {
	
	private int id;
	private int idOperadorAutorizado; //operador que criou a configuracao de envio
	
	private int idOperador;
	private int idTipoArquivo;
	private int idTipoAplicacaoCaptura;
	
	
	public ConfEnvio(int idOperadorAutorizado, int idOperador, int idTipoArquivo, int idTipoAplicacaoCaptura) {
		this.idOperadorAutorizado = idOperadorAutorizado;
		this.idOperador = idOperador;
		this.idTipoArquivo = idTipoArquivo;
		this.idTipoAplicacaoCaptura = idTipoAplicacaoCaptura;
	}
	
	
	public ConfEnvio() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdOperadorAutorizado() {
		return idOperadorAutorizado;
	}


	public void setIdOperadorAutorizado(int idOperadorAutorizado) {
		this.idOperadorAutorizado = idOperadorAutorizado;
	}


	public int getIdOperador() {
		return idOperador;
	}


	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
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
