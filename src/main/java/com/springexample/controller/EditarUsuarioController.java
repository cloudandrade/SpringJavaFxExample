package com.springexample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.springexample.main.AplicacaoUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
    void Edit(ActionEvent event) {

    }

    @FXML
    void Voltar(ActionEvent event) {
    	AplicacaoUtil.getInstancia().irParaTela("UsuarioFXML.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

