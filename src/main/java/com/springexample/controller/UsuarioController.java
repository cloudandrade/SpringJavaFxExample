package com.springexample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springexample.main.AplicacaoUtil;
import com.springexample.model.Usuario;
import com.springexample.service.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

@Component
public class UsuarioController implements Initializable{

	  	@FXML
	    private TableColumn<Usuario, Integer> tbcId;

	    @FXML
	    private Button btnSearch;

	    @FXML
	    private Button btnDelete;

	    @FXML
	    private Button btnEdit;

	    @FXML
	    private TableView<Usuario> tbUser;

	    @FXML
	    private TableColumn<Usuario, String> tbcNome;

	    @FXML
	    private TextField txtSearch;

	    @FXML
	    private Button btnCreate;

	    @FXML
	    private TableColumn<Usuario,String> tbcEmail;
	    
	    @Autowired
	    private UsuarioService usuarioService;

	    private static Usuario usuarioSelecionado;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//initListeners();
			initLayout();
			
		}
		
		  @FXML
		    void CreateUser(ActionEvent event) {
				AplicacaoUtil.getInstancia().irParaTela("CriarUsuarioFXML.fxml");
		    }

		    @FXML
		    void EditUser(ActionEvent event) {
		    	usuarioSelecionado = tbUser.getSelectionModel().getSelectedItem();
				if (usuarioSelecionado == null) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Informação");
					alert.setHeaderText(null);
					alert.setContentText("Nenhum Usuário foi Selecionado!");
					alert.showAndWait();
				} else {
					
					EditarUsuarioController.setSelecao(usuarioSelecionado);
					AplicacaoUtil.getInstancia().irParaTela("EditarUsuarioFXML.fxml");
				}
		    	
		    }

		    @FXML
		    void DeleteUser(ActionEvent event) {
		    	usuarioSelecionado = tbUser.getSelectionModel().getSelectedItem();
				if (usuarioSelecionado == null) {
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Atenção!");
					alert.setHeaderText(null);
					alert.setContentText("Nenhum Usuario foi Selecionado!");
					alert.showAndWait();
				} else {
					//EditarUsuarioController.setSelecao(usuarioSelecionado);
					//EditarUsuarioController.setTelaFechada(1);
					usuarioService.excluir(usuarioSelecionado);
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Informação!");
					alert.setHeaderText(null);
					alert.setContentText("O usuário foi excluido dos registros!");
					alert.showAndWait();
					initLayout();
				}
		    }

		    @FXML
		    void Pesquisar(ActionEvent event) {

		    }
		    
		    
		    @FXML
			void clicouTabela(MouseEvent event) {
				usuarioSelecionado = tbUser.getSelectionModel().getSelectedItem();
				//EditarUsuarioController.setSelecao(usuarioSelecionado);
				//CriarUsuarioController.setTelaFechada(1);
				//Stage stage = (Stage) btnFechar.getScene().getWindow(); // Obtendo a janela atual
				//stage.close(); // Fechando o Stage
				System.out.println("usuario selecionado: " + usuarioSelecionado);
			}
		    
		    
		    public void initLayout() {
				tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
				tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
				tbcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
				tbUser.setItems(listaUsuarios());
			}

		    public void initListeners() {
		    	
		    	
		    	
		    	
		    	
		    }

			private ObservableList<Usuario> listaUsuarios() {
				return FXCollections.observableArrayList(usuarioService.buscarTodos());
			}
	
}
