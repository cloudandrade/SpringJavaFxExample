package com.springexample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springexample.main.AplicacaoUtil;
import com.springexample.model.Usuario;
import com.springexample.service.UsuarioService;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
public class EditarUsuarioController implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField pswConfirmation1;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnVoltar;

    @FXML
    private PasswordField pswConfirmation;

    @FXML
    private TextField txtEmail;
    
    private static Usuario usuarioSelecionado;
    
    @Autowired
    private UsuarioService usuarioService;

    @FXML
    void Edit(ActionEvent event) {
    	usuarioSelecionado.setNome(txtName.getText());
    	usuarioSelecionado.setEmail(txtEmail.getText());
    	usuarioSelecionado.setSenha(pswConfirmation.getText());
    	try {
    		usuarioService.salvar(usuarioSelecionado);
    		Alert alert = new Alert(Alert.AlertType.INFORMATION);
    		alert.setTitle("Informação");
    		alert.setHeaderText(null);
    		alert.setContentText("Dados de Usuário Editados com Sucesso!");
    		alert.showAndWait();
    		AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");
    		
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Erro!");
    		alert.setHeaderText(null);
    		alert.setContentText("Não Foi Possível Alterar Dados de Usuário!");
    		alert.showAndWait();
    		e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void Voltar(ActionEvent event) {
    	AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");
    
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtName.setText(usuarioSelecionado.getNome());
		txtEmail.setText(usuarioSelecionado.getEmail());
		pswConfirmation.setText(usuarioSelecionado.getSenha());
		pswConfirmation1.setDisable(true);
		
		
		initListeners();
	}
	
	public static void setSelecao(Usuario usuario) {
		usuarioSelecionado = usuario;
	}

	public void initListeners() {
		
		pswConfirmation.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				
				pswConfirmation1.setDisable(false);
			}

		});

	
		
		
	}

	
}

