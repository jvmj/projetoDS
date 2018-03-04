package br.ufpe.cin.jvmj.main;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufpe.cin.jvmj.essentials.ConfEnvio;
import br.ufpe.cin.jvmj.essentials.Envio;
import br.ufpe.cin.jvmj.facade.Facade;

@RestController
public class ApplicationController {
	
	Facade fachada = Facade.getInstance();

    
	/*Realiza a requisicao de uma nova configuracao de envio
	 * Exemplo de URL: http://localhost:8080/addConfEnvio?idOperadorAutorizado=1&idOperador=3&idTipoArquivo=2&idTipoAplicacaoCaptura=2
	*/
	@RequestMapping (value="/addConfEnvio", method = RequestMethod.GET)
	public void addConfEnvio (@RequestParam(value="idOperadorAutorizado") int idOperadorAutorizado, @RequestParam(value="idOperador") int idOperador, @RequestParam(value="idTipoArquivo") int idTipoArquivo, @RequestParam(value="idTipoAplicacaoCaptura") int idTipoAplicacaoCaptura) {
		ConfEnvio confEnvio = new ConfEnvio(idOperadorAutorizado, idOperador, idTipoArquivo, idTipoAplicacaoCaptura);
		/*Como os ids sao no formato inteiro e autoincrement, este metodo retorna o id maximo para salvar um novo objeto 
		 * com o id maior q o maximo encontrado
		 */
		confEnvio.setId(fachada.findMaxIdConfEnvio());
		
		fachada.addConfEnvio(confEnvio);
	}
	

	/*Realiza filtro de envios (somente usuarios do tipo administrador tem permissao para realizar este filtro)
	 * Exemplo de URL: http://localhost:8080/filtro?idOperador=1&idTipoAplicacaoCaptura=2&idTipoArquivo=0&data=2018-01-01
	 * 
	 * Retorna um json com o resultado do filtro
	 */
	@RequestMapping(value="/filtro", method = RequestMethod.GET)
	public Vector<Envio> filtrarEnvios (@RequestParam(value="idOperador") int idOperador, @RequestParam(value="idTipoAplicacaoCaptura") int idTipoAplicacaoCaptura, @RequestParam(value="idTipoArquivo") int idTipoArquivo, @RequestParam(value="data") String data) {
		
		return fachada.filtrarEnvios(idOperador, idTipoAplicacaoCaptura, idTipoArquivo, data);
		
	}
	
	
	/*Processa um envio
	 * Exemplo de URL: http://localhost:8080/enviar?data=2018-03-02&idOperador=3&idArquivo=4&idArquivoTipo=2&idTipoAplicacaoCaptura=2
	 * 
	 * Nesse caso, o browser retorna um arquivo para baixar.
	 */
	@RequestMapping (value="/enviar", method = RequestMethod.GET)
	public void enviar(HttpServletResponse response, @RequestParam(value="data") String dataEnvio, @RequestParam(value="idOperador") int idOperador, @RequestParam(value="idArquivo") int idArquivo, @RequestParam(value="idArquivoTipo") int idArquivoTipo ,@RequestParam(value="idTipoAplicacaoCaptura") int idTipoAplicacaoCaptura) throws IOException{
		Envio envio = new Envio(dataEnvio, idOperador, idArquivo, idArquivoTipo, idTipoAplicacaoCaptura);
		/*Como os ids sao no formato inteiro e autoincrement, este metodo retorna o id maximo para salvar um novo objeto 
		 * com o id maior q o maximo encontrado
		 */
		envio.setId(fachada.findMaxIdEnvio());
		
		fachada.addEnvio(envio, response);
		
	}
}
