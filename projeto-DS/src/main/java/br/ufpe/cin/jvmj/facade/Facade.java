package br.ufpe.cin.jvmj.facade;

import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import br.ufpe.cin.jvmj.business.ConfEnvioBusiness;
import br.ufpe.cin.jvmj.business.EnvioBusiness;
import br.ufpe.cin.jvmj.business.OperadorBusiness;
import br.ufpe.cin.jvmj.essentials.ConfEnvio;
import br.ufpe.cin.jvmj.essentials.Envio;

public class Facade {
	
	private ConfEnvioBusiness confEnvioBusiness;
	private EnvioBusiness envioBusiness;
	private static Facade fachada = null;
	
	/*
	 * Protegendo o construtor pra garantir que ninguem tente instanciar a
	 * fachada por ele.
	 */
	
	public Facade(){
		
		super();
		new OperadorBusiness();
		this.confEnvioBusiness = new ConfEnvioBusiness();
		this.envioBusiness = new EnvioBusiness();
	}
	
	/*
	 * Implementando o pattern Singleton para que nao seja possivel ter duas
	 * intancias da fachada na memoria.
	 */
	
	public static Facade getInstance() {
		if (fachada == null) {
			fachada = new Facade();
		}
		
		return fachada;
	}

	
	public void addConfEnvio (ConfEnvio confEnvio) {
		confEnvioBusiness.addConfEnvio(confEnvio);
	}
	
	public int findMaxIdConfEnvio() {
		return confEnvioBusiness.findMaxIdConfEnvio();
	}

	
	public void addEnvio(Envio envio, HttpServletResponse response) {
		envioBusiness.addEnvio(envio, response);
	}
	
	public Vector<Envio> filtrarEnvios(int idOperador, int idTipoAplicacaoCaptura, int idTipoArquivo, String data){
		return envioBusiness.filtrarEnvios(idOperador, idTipoAplicacaoCaptura, idTipoArquivo, data);
	}
	
	public int findMaxIdEnvio() {
		return envioBusiness.findMaxIdEnvio();
	}


}
