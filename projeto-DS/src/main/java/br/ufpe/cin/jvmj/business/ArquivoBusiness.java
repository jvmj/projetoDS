package br.ufpe.cin.jvmj.business;

import br.ufpe.cin.jvmj.essentials.Arquivo;
import br.ufpe.cin.jvmj.persistence.ArquivoPersistence;

public class ArquivoBusiness {
	
	private ArquivoPersistence arquivoPersistence;
	
	public ArquivoBusiness() {
		super();
		this.arquivoPersistence = new ArquivoPersistence();
	}
	
	
	public void addArquivo(Arquivo arquivo) {
		
		arquivoPersistence.addArquivo(arquivo);
	}
	
	public Arquivo buscarArquivoPorId(int idArquivo) {
		
		Arquivo arquivo = arquivoPersistence.buscarArquivoPorId(idArquivo);
		
		if(arquivo == null) {
			try {
				throw new Exception("Arquivo nao encontrado!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return arquivo;
		}
		
		return null;
	}

}
