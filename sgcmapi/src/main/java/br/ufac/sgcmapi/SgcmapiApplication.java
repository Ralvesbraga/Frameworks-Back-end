package br.ufac.sgcmapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController
public class SgcmapiApplication {

	@Autowired
	private ExemploService exemploService;
	// private final ExemploService exemploService;

	// public SgcmapiApplication(ExemploService exemploService){
	// 	this.exemploService = exemploService;
	// }

	@RequestMapping(value = "/teste")
	public String exemplo(){
		// return "SGCM";
		return exemploService.exibeMensagem();
	}

	@Service
	public static class ExemploService{
		public String exibeMensagem(){
			return "SGCM funcionando!";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SgcmapiApplication.class, args);
	}

}
