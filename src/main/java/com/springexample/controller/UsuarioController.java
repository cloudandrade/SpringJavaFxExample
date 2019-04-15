package com.springexample.controller;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Component
public class UsuarioController implements Initializable{

	  	@FXML
	    private TableColumn<?, ?> tbcId;

	    @FXML
	    private Button btnSearch;

	    @FXML
	    private Button btnDelete;

	    @FXML
	    private Button btnEdit;

	    @FXML
	    private TableView<?> tbUser;

	    @FXML
	    private TableColumn<?, ?> tbcNome;

	    @FXML
	    private TextField txtSearch;

	    @FXML
	    private Button btnCreate;

	    @FXML
	    private TableColumn<?, ?> tbcEmail;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			System.out.println("achou o controller");
			
		}
	
}
