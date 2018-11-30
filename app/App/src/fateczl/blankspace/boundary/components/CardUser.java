package fateczl.blankspace.boundary.components;

import java.util.Random;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.Profile;
import fateczl.blankspace.boundary.Read;
import fateczl.blankspace.controller.UsuarioController;
import fateczl.blankspace.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class CardUser extends HBox{

	UsuarioController usuarioController = new UsuarioController();
	
	Random random = new Random();
	
	Label userImage, lblUserName, lblUserCareer;
	Button btnFollow;
	
	Usuario usuario;
	
	public CardUser(Usuario usuario) {
	
		this.usuario = (usuario == null? App.usuario : usuario);
		
		getStyleClass().add("card-container");
		
		AnchorPane card = new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("card-hitory");
		card.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				new Profile(usuario);
			}
		});
		getChildren().add(card);
		
		Image image = new Image("user_dark_icon.png", 70, 70, false, false);
		userImage = new Label();
		userImage.setGraphic(new ImageView(image));
		userImage.getStyleClass().add("card-cover");
		AnchorPane.setTopAnchor(userImage, (double)20);
		AnchorPane.setLeftAnchor(userImage, (double)80);
		AnchorPane.setRightAnchor(userImage, (double)80);
		card.getChildren().add(userImage);
		
		lblUserName = new Label(usuario.getNome() +" "+ usuario.getSobrenome());
		lblUserName.getStyleClass().add("bspace-text");
		lblUserName.getStyleClass().add("bold");
		lblUserName.getStyleClass().add("primary-text");
		lblUserName.getStyleClass().add("normal-text");
		lblUserName.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(lblUserName, (double)110);
		AnchorPane.setLeftAnchor(lblUserName, (double)10);
		AnchorPane.setRightAnchor(lblUserName, (double)10);
		card.getChildren().add(lblUserName);
		
		lblUserCareer = new Label(usuario.getCarreira());
		lblUserCareer.getStyleClass().add("bspace-text");
		lblUserCareer.getStyleClass().add("secundary-text");
		lblUserCareer.getStyleClass().add("mini-text-2");
		lblUserCareer.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(lblUserCareer, (double)140);
		AnchorPane.setLeftAnchor(lblUserCareer, (double)10);
		AnchorPane.setRightAnchor(lblUserCareer, (double)10);
		card.getChildren().add(lblUserCareer);
		
		btnFollow = new Button();
		btnFollow.getStyleClass().add("bspace-button");
		btnFollow.getStyleClass().add("btn-brand");
		if(usuarioController.isSeguindo(App.usuario, usuario)) {
			btnFollow.setText("Deixar de seguir");
		}else {
			btnFollow.setText("Seguir");
			btnFollow.getStyleClass().add("bordered");
		}
		btnFollow.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Button btn = ((Button)(event.getSource()));
				
				if(btn.getText().equals("Seguir")) {
					usuarioController.seguirUsuario(App.usuario, usuario);
					btn.setText("Deixar de seguir");
					btnFollow.getStyleClass().remove("bordered");
				}else {
					usuarioController.deixarDeSeguirUsuario(App.usuario, usuario);
					btn.setText("Seguir");
					btnFollow.getStyleClass().add("bordered");
				}
			}
		});
		AnchorPane.setTopAnchor(btnFollow, (double)180);
		AnchorPane.setLeftAnchor(btnFollow, (double)50);
		AnchorPane.setRightAnchor(btnFollow, (double)50);
		card.getChildren().add(btnFollow);
		
	}
	
}
