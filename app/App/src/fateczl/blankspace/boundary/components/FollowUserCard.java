package fateczl.blankspace.boundary.components;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.controller.UsuarioController;
import fateczl.blankspace.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class FollowUserCard extends HBox{

	UsuarioController usuarioController = new UsuarioController();
	
	Label userImage, lblUserName, lblUserEmail;
	Button btnAction;
	Label removedFollower;
	
	public FollowUserCard(Usuario usuario, int type /*0 seguindores, 1 Seguindo*/) {
		System.out.println(usuario.getNome());
		AnchorPane card = new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("mini");
		getChildren().add(card);
		
		Image image = new Image("user_dark_icon.png", 50, 50, false, false);
		userImage = new Label();
		userImage.setGraphic(new ImageView(image));
		userImage.getStyleClass().add("card-cover");
		AnchorPane.setTopAnchor(userImage, (double)25);
		AnchorPane.setLeftAnchor(userImage, (double)20);
		card.getChildren().add(userImage);
		
		lblUserName = new Label(usuario.getNome()+" "+usuario.getSobrenome());
		lblUserName.getStyleClass().add("bspace-text");
		lblUserName.getStyleClass().add("bold");
		lblUserName.getStyleClass().add("primary-text");
		lblUserName.getStyleClass().add("mini-text-2");
		lblUserName.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(lblUserName, (double)12);
		AnchorPane.setLeftAnchor(lblUserName, (double)80);
		AnchorPane.setRightAnchor(lblUserName, (double)10);
		card.getChildren().add(lblUserName);
		
		lblUserEmail = new Label(usuario.getEmail());
		lblUserEmail.getStyleClass().add("bspace-text");
		lblUserEmail.getStyleClass().add("secundary-text");
		lblUserEmail.getStyleClass().add("mini-text");
		lblUserEmail.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(lblUserEmail, (double)42);
		AnchorPane.setLeftAnchor(lblUserEmail, (double)80);
		AnchorPane.setRightAnchor(lblUserEmail, (double)10);
		card.getChildren().add(lblUserEmail);
		
		removedFollower = new Label("Removido");
		removedFollower.getStyleClass().add("bspace-text");
		removedFollower.getStyleClass().add("bold");
		removedFollower.getStyleClass().add("danger-text");
		removedFollower.getStyleClass().add("mini-text");
		removedFollower.setVisible(false);
		removedFollower.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(removedFollower, (double)70);
		AnchorPane.setLeftAnchor(removedFollower, (double)100);
		AnchorPane.setRightAnchor(removedFollower, (double)30);
		card.getChildren().add(removedFollower);
		
		btnAction = new Button();
		btnAction.getStyleClass().add("bspace-button");
		btnAction.getStyleClass().add("thin");
		btnAction.getStyleClass().add("btn-brand");
		if(type == 0) {
			btnAction.getStyleClass().add("btn-danger");
			btnAction.setText("Remover");
		} else {
			btnAction.setText("Deixar de seguir");
			btnAction.getStyleClass().add("btn-brand");
		}
		btnAction.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Button btn = ((Button)(event.getSource()));
				if(type == 0) {
					usuarioController.removerSeguidor(usuario, App.usuario);
					btn.setVisible(false);
					removedFollower.setVisible(true);
				}else {
					if(btn.getText().equals("Seguir")) {
						usuarioController.seguirUsuario(App.usuario, usuario);
						btn.setText("Deixar de seguir");
						btn.getStyleClass().remove("bordered");
					}else {
						usuarioController.deixarDeSeguirUsuario(App.usuario, usuario);
						btn.setText("Seguir");
						btn.getStyleClass().add("bordered");
					}
				}
				
			}
		});
		AnchorPane.setTopAnchor(btnAction, (double)62);
		AnchorPane.setLeftAnchor(btnAction, (double)100);
		AnchorPane.setRightAnchor(btnAction, (double)30);
		card.getChildren().add(btnAction);
		
	}
	
}
