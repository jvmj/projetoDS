package br.ufpe.cin.jvmj.business;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import br.ufpe.cin.jvmj.essentials.Arquivo;
import br.ufpe.cin.jvmj.essentials.ConfEnvio;
import br.ufpe.cin.jvmj.essentials.Envio;
import br.ufpe.cin.jvmj.essentials.Operador;
import br.ufpe.cin.jvmj.persistence.EnvioPersistence;
import br.ufpe.cin.jvmj.util.Mock;
import br.ufpe.cin.jvmj.util.ObjetoMock;

public class EnvioBusiness {
	
	private EnvioPersistence envioPersistence;
	
	
	public EnvioBusiness() {
		super();
		this.envioPersistence = new EnvioPersistence();
	}
	
	public void addEnvio(Envio envio, HttpServletResponse response) {
		
		ArquivoBusiness arquivoBusiness = new ArquivoBusiness();
		
		Arquivo arquivo = arquivoBusiness.buscarArquivoPorId(envio.getIdArquivo());
		
		ConfEnvioBusiness confEnvioBusiness = new ConfEnvioBusiness();
		
		//Verificando as permissoes de envio
		Vector<ConfEnvio> confs = confEnvioBusiness.buscarConfsEnvio(envio.getIdOperador(), arquivo.getIdArquivoTipo(), envio.getIdTipoAplicacaoCaptura());
		
		//Se nao existir nenhuma permissao de envio, retorna a exception
		if (confs.size() == 0) {
			try {
				throw new Exception("Voce nao tem permissao para envio deste arquivo. Verifique as configuracoes com o administrador.");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			//Caso contrario, inicialmente cadastro o envio
			envioPersistence.addEnvio(envio);
			//Chamando o mock
			Mock mock = new Mock();
			Vector<ObjetoMock> resultados = mock.contarPalavras(arquivo.getImagem());
			
			//gerando o xls
			Workbook wb = new HSSFWorkbook();
		    Sheet sheet = wb.createSheet("new sheet");
		    
		    for (int i=0; i<resultados.size();i++) {
		    	
		    	Row linha = sheet.createRow(i);
		    	linha.createCell(0).setCellValue(resultados.get(i).palavra);
		    	linha.createCell(1).setCellValue(resultados.get(i).numOcorrencias);
		    }
		    		
		    try {
		    	//Escreve o arquivo com o resultado do processamento do mock
		    	FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		    	wb.write(fileOut);
		    	
		    	//Recupera o arquivo escrito para envio ao usuario que solicitou
		    	InputStream arquivoParaLer = new FileInputStream("workbook.xls");
			    
			    response.addHeader("Content-disposition", "attachment; filename=workbook.xls");
			    response.setContentType("application/vnd.ms-excel");
			    
			    //Enviando o arquivo para download
			    IOUtils.copy(arquivoParaLer, response.getOutputStream());
			    wb.close();
			    
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}
	
	public Vector<Envio> filtrarEnvios(int idOperador, int idTipoAplicacaoCaptura, int idTipoArquivo, String data){
		
		OperadorBusiness operadorBusiness = new OperadorBusiness();
		
		Operador operador = operadorBusiness.buscarOperadorPorId(idOperador);
		
		//Testa se o operador que vai adicionar a configuracao eh do tipo 1 (administrador)
		if (operador.getIdOperadorTipo() != 1) {
			try {
				throw new Exception("Este operador nao esta autorizado a filtrar envios!");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			
			return envioPersistence.filtrarEnvios(idTipoAplicacaoCaptura, idTipoArquivo, data);
		}
		
		return null;
	}
	
	
	public int findMaxIdEnvio() {
			
			return envioPersistence.findMaxIdEnvio();
		}

}
