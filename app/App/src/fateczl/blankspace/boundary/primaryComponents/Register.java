package fateczl.blankspace.boundary.primaryComponents;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fateczl.blankspace.boundary.Layout;
import fateczl.blankspace.controller.AcessoController;
import fateczl.blankspace.controller.UsuarioController;
import fateczl.blankspace.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Register extends AnchorPane{

	TextField txtName, txtLastname, txtCarrer, txtBirth, txtEmail;
	PasswordField txtPassword;
	
	Button btnRegister;
	
	public Register() {
		
		Label lblTitle = new Label("Cadastre-se");
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("primary-text");
		lblTitle.getStyleClass().add("big-text-2");
		AnchorPane.setTopAnchor(lblTitle, (double)40);
		AnchorPane.setLeftAnchor(lblTitle, (double)20);
		AnchorPane.setRightAnchor(lblTitle, (double)20);
		getChildren().add(lblTitle);
		
		txtName = new TextField();
		txtName.getStyleClass().addAll("text-feild", "underline");
		txtName.setPromptText("Nome");
		AnchorPane.setTopAnchor(txtName, (double)80);
		AnchorPane.setLeftAnchor(txtName, (double)20);
		getChildren().add(txtName);
		
		txtLastname = new TextField();
		txtLastname.getStyleClass().addAll("text-feild", "underline");
		txtLastname.setPromptText("Sobrenome");
		AnchorPane.setTopAnchor(txtLastname, (double)80);
		AnchorPane.setRightAnchor(txtLastname, (double)20);
		getChildren().add(txtLastname);
		
		txtCarrer = new TextField();
		txtCarrer.getStyleClass().addAll("text-feild", "underline");
		txtCarrer.setPromptText("Carreira");
		AnchorPane.setTopAnchor(txtCarrer, (double)120);
		AnchorPane.setLeftAnchor(txtCarrer, (double)20);
		AnchorPane.setRightAnchor(txtCarrer, (double)20);
		getChildren().add(txtCarrer);
		
		txtBirth = new TextField();
		txtBirth.getStyleClass().addAll("text-feild", "underline");
		txtBirth.setPromptText("Data de nascimento");
		AnchorPane.setTopAnchor(txtBirth, (double)160);
		AnchorPane.setLeftAnchor(txtBirth, (double)20);
		AnchorPane.setRightAnchor(txtBirth, (double)20);
		getChildren().add(txtBirth);
		
		txtEmail = new TextField();
		txtEmail.getStyleClass().addAll("text-feild", "underline");
		txtEmail.setPromptText("E-mail");
		AnchorPane.setTopAnchor(txtEmail, (double)200);
		AnchorPane.setLeftAnchor(txtEmail, (double)20);
		AnchorPane.setRightAnchor(txtEmail, (double)20);
		getChildren().add(txtEmail);
		
		txtPassword = new PasswordField();
		txtPassword.getStyleClass().addAll("text-feild", "underline");
		txtPassword.setPromptText("Senha");
		AnchorPane.setTopAnchor(txtPassword, (double)240);
		AnchorPane.setLeftAnchor(txtPassword, (double)20);
		AnchorPane.setRightAnchor(txtPassword, (double)20);
		getChildren().add(txtPassword);
		
		VBox buttonContainer = new VBox();
		buttonContainer.setAlignment(Pos.CENTER);
		AnchorPane.setBottomAnchor(buttonContainer, (double)20);
		AnchorPane.setLeftAnchor(buttonContainer, (double)20);
		AnchorPane.setRightAnchor(buttonContainer, (double)20);
		getChildren().add(buttonContainer);
		
		btnRegister = new Button();
		btnRegister.setText("Cadastrar");
		btnRegister.getStyleClass().add("bspace-button");
		btnRegister.getStyleClass().add("btn-brand");
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				
				try {
					Usuario usuario = new Usuario();
					usuario.setEmail(txtEmail.getText());
					usuario.setNome(txtName.getText());
					usuario.setSobrenome(txtLastname.getText());
					usuario.setCarreira(txtCarrer.getText());
					
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					usuario.setNascimento(format.parse(txtBirth.getText()));
					
					usuario.setSenha(txtPassword.getText());
					
					UsuarioController usuarioController = new UsuarioController();
					usuarioController.cadastrarUsuario(usuario);
					
					AcessoController acessoController = new AcessoController();
					if(acessoController.logar(txtEmail.getText(), txtPassword.getText()) != null) {
						Layout.login();
					}else {
						System.out.println("Não encontrado");
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		buttonContainer.getChildren().add(btnRegister);
		
	}
	
}
