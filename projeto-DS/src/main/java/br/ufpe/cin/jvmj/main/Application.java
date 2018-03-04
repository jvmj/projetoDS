package br.ufpe.cin.jvmj.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufpe.cin.jvmj.util.PopulaBD;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	
    	//Povoando o banco de dados
    	PopulaBD.populaBD(); 
        SpringApplication.run(Application.class, args);
    }
}
