package br.ufpe.cin.jvmj.essentials;



public class Operador {
	
	private int id;
	private String token;
	
	private int idOperadorTipo;
	
	
	public Operador(String token, int idOperadorTipo) {
		this.token = token;
		this.idOperadorTipo = idOperadorTipo;
	}
	
	public Operador() {
		 	super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public int getIdOperadorTipo() {
		return idOperadorTipo;
	}


	public void setIdOperadorTipo(int idOperadorTipo) {
		this.idOperadorTipo = idOperadorTipo;
	}

	
	
}
