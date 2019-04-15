package com.springexample.main;

import org.springframework.context.ConfigurableApplicationContext;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AplicacaoUtil {	

	// Instância única que será guardada
	private static AplicacaoUtil instancia = null;

	private ConfigurableApplicationContext context;

	private Stage telaAtual = null;

	private AplicacaoUtil() {
		this.telaAtual = new Stage();
	}

	public static AplicacaoUtil getInstancia() {
		if (instancia == null) {
			instancia = new AplicacaoUtil();
		}
		return instancia;
	}

	public void irParaTela(String nomeTela) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/".concat(nomeTela)));
			loader.setControllerFactory(context::getBean);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(null);
			scene.getStylesheets().clear();
			scene.getStylesheets().add("stylesheet2.css");
			telaAtual.setScene(scene);
			telaAtual.setResizable(false);
			telaAtual.centerOnScreen();
			if (!telaAtual.isShowing()) {
				telaAtual.show();
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

		

	public void setContext(ConfigurableApplicationContext context) {
		this.context = context;
	}

	public void setTelaAtual(Stage telaAtual) {
		this.telaAtual = telaAtual;
	}

	public Stage getTelaAtual() {
		return telaAtual;
	}

}
