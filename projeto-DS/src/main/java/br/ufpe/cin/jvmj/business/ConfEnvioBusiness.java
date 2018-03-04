package br.ufpe.cin.jvmj.business;

import java.util.Vector;

import br.ufpe.cin.jvmj.essentials.ConfEnvio;
import br.ufpe.cin.jvmj.essentials.Operador;
import br.ufpe.cin.jvmj.persistence.ConfEnvioPersistence;

public class ConfEnvioBusiness {
	
	private ConfEnvioPersistence confEnvioPersistence;
	
	public ConfEnvioBusiness() {
		super();
		this.confEnvioPersistence = new ConfEnvioPersistence();
	}
	
	
	public void addConfEnvio (ConfEnvio confEnvio) {
		
		OperadorBusiness operadorBusiness = new OperadorBusiness();
		
		Operador operador = operadorBusiness.buscarOperadorPorId(confEnvio.getIdOperadorAutorizado());
		
		//Testa se o operador que vai adicionar a configuracao eh do tipo 1 (administrador)
		if (operador.getIdOperadorTipo() != 1) {
			try {
				throw new Exception("Este operador nao esta autorizado a adicionar configuracao de envio!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else { 
			confEnvioPersistence.addConfEnvio(confEnvio);
		}
		
	}
	
	
	public Vector<ConfEnvio> buscarConfsEnvio (int idOperador, int idTipoArquivo, int idTipoAplicacaoCaptura){
		
		Vector<ConfEnvio> confsEnvio = confEnvioPersistence.buscarConfsEnvio(idOperador, idTipoArquivo, idTipoAplicacaoCaptura);
		
		if (confsEnvio == null) {
			try {
				throw new Exception("Configuracao de envio nao encontrada!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return confsEnvio;
		}
		
		return null;
	}
	
	
	public int findMaxIdConfEnvio() {
		
		return confEnvioPersistence.findMaxIdConfEnvio();
	}

}
