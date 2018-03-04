package br.ufpe.cin.jvmj.business;

import java.util.Vector;

import br.ufpe.cin.jvmj.essentials.Operador;
import br.ufpe.cin.jvmj.persistence.OperadorPersistence;

public class OperadorBusiness {
	
	private OperadorPersistence operadorPersistence;
	
	public OperadorBusiness() {
		super();
		this.operadorPersistence = new OperadorPersistence();
	}
	
	public void addOperador(Operador operador) {
		
		operadorPersistence.addOperador(operador);
	}
	
	
	public Vector<Operador> buscarOperadorPorTipo(int idOperadorTipo){
		
		Vector<Operador> operadores = operadorPersistence.buscarOperadorPorTipo(idOperadorTipo);;
	
		if (operadores == null) {
			try {
				throw new Exception("Operadores nao encontrados!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			return operadores;
		}
		
		return null;
	}
	
	public Operador buscarOperadorPorId (int idOperador) {
		
		Operador operador = operadorPersistence.buscarOperadorPorId(idOperador);
		
		if (operador == null) {
			try {
				throw new Exception("Operador nao encontrado!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return operador;
		}
		
		return null;
	}
	
	
	//TODO
	public boolean exists(Operador operador) {
		
			return true;
	}

}
