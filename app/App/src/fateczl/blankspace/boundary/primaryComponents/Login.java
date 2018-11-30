package fateczl.blankspace.boundary.primaryComponents;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.Layout;
import fateczl.blankspace.controller.AcessoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Login extends AnchorPane{

	TextField txtEmail;
	PasswordField txtPassword;
	Button btnLogin, btnForgotPassword;
	
	public Login() {
		
		Label lblTitle = new Label("Seja bem-vindo ao Blank Space");
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("primary-text");
		lblTitle.getStyleClass().add("big-text-2");
		AnchorPane.setTopAnchor(lblTitle, (double)40);
		AnchorPane.setLeftAnchor(lblTitle, (double)20);
		AnchorPane.setRightAnchor(lblTitle, (double)20);
		getChildren().add(lblTitle);
		
		txtEmail = new TextField();
		txtEmail.getStyleClass().addAll("text-feild", "underline");
		AnchorPane.setTopAnchor(txtEmail, (double)140);
		AnchorPane.setLeftAnchor(txtEmail, (double)20);
		AnchorPane.setRightAnchor(txtEmail, (double)20);
		getChildren().add(txtEmail);
		
		txtPassword = new PasswordField();
		txtPassword.getStyleClass().addAll("text-feild", "underline");
		AnchorPane.setTopAnchor(txtPassword, (double)220);
		AnchorPane.setLeftAnchor(txtPassword, (double)20);
		AnchorPane.setRightAnchor(txtPassword, (double)20);
		getChildren().add(txtPassword);
		
		VBox buttonContainer = new VBox();
		buttonContainer.setAlignment(Pos.CENTER);
		AnchorPane.setBottomAnchor(buttonContainer, (double)20);
		AnchorPane.setLeftAnchor(buttonContainer, (double)20);
		AnchorPane.setRightAnchor(buttonContainer, (double)20);
		getChildren().add(buttonContainer);
		
		btnLogin = new Button();
		btnLogin.setText("Logar");
		btnLogin.getStyleClass().add("bspace-button");
		btnLogin.getStyleClass().add("btn-brand");
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				AcessoController acessoController = new AcessoController();
				if(acessoController.logar(txtEmail.getText(), txtPassword.getText()) != null) {
					Layout.login();
				}else {
					System.out.println("Não encontrado");
				}
			}
		});
		buttonContainer.getChildren().add(btnLogin);
		
//		btnForgotPassword = new Button("Esqueceu sua senha?");
//		btnForgotPassword.getStyleClass().add("bspace-button-transparent");
//		btnForgotPassword.getStyleClass().add("bspace-text");
//		btnForgotPassword.getStyleClass().add("large");
//		btnForgotPassword.getStyleClass().add("secundary-text");
//		btnForgotPassword.getStyleClass().add("mini-text-2");
//		buttonContainer.getChildren().add(btnForgotPassword);
		
		
	}
	
}
