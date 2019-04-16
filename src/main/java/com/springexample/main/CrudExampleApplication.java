package com.springexample.main;


import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.springexample.service",
		"com.springexample.controller", "com.springexample.main" })
@EntityScan(basePackages = { "com.springexample.model" })
@EnableJpaRepositories(basePackages = { "com.springexample.repository" })
public class CrudExampleApplication extends Application{
	
	private static final Logger log = LoggerFactory.getLogger(CrudExampleApplication.class);

	private ConfigurableApplicationContext context;
	
	

	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage arg0) throws Exception {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CrudExampleApplication.class);
		context = builder.run(getParameters().getRaw().toArray(new String[0]));
		
		
		
		arg0.setTitle("Aplicação Spring Example");
		AplicacaoUtil.getInstancia().setContext(context);
		AplicacaoUtil.getInstancia().setTelaAtual(arg0);
		AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");

		
	}

	

}
