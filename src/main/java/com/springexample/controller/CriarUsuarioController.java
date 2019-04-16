package com.springexample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springexample.main.AplicacaoUtil;
import com.springexample.model.Usuario;
import com.springexample.service.UsuarioService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
public class CriarUsuarioController implements Initializable{

	  @FXML
	    private TextField txtName;

	    @FXML
	    private PasswordField pswConfirmation;

	    @FXML
	    private TextField txtEmail;

	    @FXML
	    private PasswordField pswPass;
	    
	    @FXML
	    private Button btnVoltar;
	    
	    @FXML
	    private Button btnCreate;
	    
	    @Autowired
	    private UsuarioService usuarioService;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void Voltar(ActionEvent event) {
    	AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");
    }
	
    @FXML
    void Create(ActionEvent event) {
    	Usuario user = new Usuario();
    	user.setNome(txtName.getText());
    	user.setEmail(txtEmail.getText());
    	user.setSenha(pswPass.getText());
    	if(txtName.getText().equals("")) {
    		
    		txtName.setStyle("-fx-text-box-border:red;");
    		txtName.setPromptText("Insira o seu Nome");
	
    	}else if(txtEmail.getText().equals("")) {
    	
    		txtEmail.setStyle("-fx-text-box-border:red;");
    		txtEmail.setPromptText("Insira o seu Email");
    	
    	}else if(!pswPass.getText().equals(pswConfirmation.getText())) {
    	
    		pswPass.clear();
    		pswConfirmation.clear();
    		pswPass.setStyle("-fx-text-box-border:red;");
    		pswPass.setPromptText("Senhas não conferem");
    
    	
    	}else {
    		
    		

        	try {
        		usuarioService.salvar(user);
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        		alert.setTitle("Informação");
        		alert.setHeaderText(null);
        		alert.setContentText("Novo Usuário Criado");
        		alert.showAndWait();
            	
        		AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");
        		
    		} catch (Exception e) {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle("Erro!");
        		alert.setHeaderText(null);
        		alert.setContentText("Não Foi Possível criar um novo usuário!");
        		alert.showAndWait();
        		e.printStackTrace();
    		}
    		
    		
    	}
    	
    	
    	
    	
    }

    
    
}
