package br.ufpe.cin.jvmj.util;

import java.util.Random;
import java.util.Vector;

import org.apache.commons.lang3.RandomStringUtils;


public class Mock implements IMock {
	
	/*Tratei a imagem como String apenas como prova de conceito. 
	 * O correto seria um array de bytes, porem precisaria de tempo para 
	 * investigar uma forma de povoar esse formato no banco de dados.
	 * 
	 * O metodo criado apenas recebe uma imagem e retorna 100 ocorrencias strings e numeros aleatorios no formato de 
	 * tuplas do tipo (palavra, numOcorrencias).
	 */
	public Vector<ObjetoMock> contarPalavras (String imagem) {
		
			Vector<ObjetoMock> contagens = new Vector<ObjetoMock>();
			
			Random rn = new Random();

			int tamanhoPalavra = 5;
			
			for (int i=0;i<100;i++) {
				String stringAleatoria = RandomStringUtils.random(tamanhoPalavra,true,false);
				contagens.add(new ObjetoMock(stringAleatoria, rn.nextInt(100)));
			}
			
			return contagens;
	}

}
