package fateczl.blankspace.boundary.components;

import com.sun.glass.events.MouseEvent;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.FollowContent;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UserHeaderContent extends AnchorPane{

	UsuarioController usuarioController = new UsuarioController();
	
	Button btnImage;
	Label lblUserName, lblUserEmail, lblUserCareer;
	
	Label publiQtde, lblPubli, btnFollowers, lblFollowers, btnFollowing, lblFollowing;
	Button btnEdit;
	
	public UserHeaderContent(Usuario usuario) {
		
		Image image = new Image("user_dark_icon.png", 60, 60, false, false);
		btnImage = new Button();
		btnImage.getStyleClass().add("btn-menu");
		btnImage.setGraphic(new ImageView(image));
		AnchorPane.setTopAnchor(btnImage, (double)20);
		AnchorPane.setLeftAnchor(btnImage, (double)10);
		getChildren().add(btnImage);
		
		VBox userInfo = new VBox();
		userInfo.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(userInfo, (double)20);
		AnchorPane.setLeftAnchor(userInfo, 100.0);
		getChildren().add(userInfo);
		
		lblUserName = new Label(usuario.getNome());
		lblUserName.getStyleClass().add("bspace-text");
		lblUserName.getStyleClass().add("bold");
		lblUserName.getStyleClass().add("primary-text");
		lblUserName.getStyleClass().add("normal-text");
		userInfo.getChildren().add(lblUserName);
		
		lblUserEmail = new Label(usuario.getEmail());
		lblUserEmail.getStyleClass().add("bspace-text");
		lblUserEmail.getStyleClass().add("third-text");
		lblUserEmail.getStyleClass().add("mini-text-2");
		userInfo.getChildren().add(lblUserEmail);
		
		lblUserCareer = new Label(usuario.getCarreira());
		lblUserCareer.getStyleClass().add("badge");
		lblUserCareer.getStyleClass().add("badge-brand");
		lblUserCareer.getStyleClass().add("bspace-text");
		lblUserCareer.getStyleClass().add("primary-text");
		lblUserCareer.getStyleClass().add("mini-text");
		lblUserCareer.getStyleClass().add("margin-all");
		userInfo.getChildren().add(lblUserCareer);
		
		VBox centerItems = new VBox();
		centerItems.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(centerItems, (double)10);
		AnchorPane.setRightAnchor(centerItems, 100.0);
		AnchorPane.setLeftAnchor(centerItems, 100.0);
		getChildren().add(centerItems);
		
		HBox quantifiersBox = new HBox();
		quantifiersBox.setAlignment(Pos.CENTER);
		centerItems.getChildren().add(quantifiersBox);
		
		VBox infoBox = new VBox();
		infoBox.setAlignment(Pos.CENTER);
		infoBox.getStyleClass().add("margin-all");
		quantifiersBox.getChildren().add(infoBox);
		
		publiQtde = new Label(""+usuarioController.contarPublicacoes(usuario));
		publiQtde.getStyleClass().add("bspace-text");
		publiQtde.getStyleClass().add("bold");
		publiQtde.getStyleClass().add("primary-text");
		publiQtde.getStyleClass().add("mini-text-2");
		infoBox.getChildren().add(publiQtde);
		
		lblPubli = new Label("Publicações");
		lblPubli.getStyleClass().add("bspace-text");
		lblPubli.getStyleClass().add("third-text");
		lblPubli.getStyleClass().add("mini-text-small");
		infoBox.getChildren().add(lblPubli);
		
		VBox followersBox = new VBox();
		followersBox.getStyleClass().add("margin-all");
		followersBox.setAlignment(Pos.CENTER);
		quantifiersBox.getChildren().add(followersBox);
		
		btnFollowers = new Label(""+usuarioController.contarSeguidores(usuario));
		btnFollowers.getStyleClass().add("bspace-text");
		btnFollowers.getStyleClass().add("bold");
		btnFollowers.getStyleClass().add("primary-text");
		btnFollowers.getStyleClass().add("mini-text-2");
		btnFollowers.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				new FollowContent(usuario, 0);
			}
		});
		followersBox.getChildren().add(btnFollowers);
		
		lblFollowers = new Label("Seguidores");
		lblFollowers.getStyleClass().add("bspace-text");
		lblFollowers.getStyleClass().add("third-text");
		lblFollowers.getStyleClass().add("mini-text-small");
		followersBox.getChildren().add(lblFollowers);
		
		VBox followingBox = new VBox();
		followingBox.getStyleClass().add("margin-all");
		followingBox.setAlignment(Pos.CENTER);
		quantifiersBox.getChildren().add(followingBox);
		
		btnFollowing = new Label(""+usuarioController.contarSeguintes(usuario));
		btnFollowing.getStyleClass().add("bspace-text");
		btnFollowing.getStyleClass().add("bold");
		btnFollowing.getStyleClass().add("primary-text");
		btnFollowing.getStyleClass().add("mini-text-2");
		btnFollowing.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				new FollowContent(usuario, 1);
			}
		});
		followingBox.getChildren().add(btnFollowing);
		
		lblFollowing = new Label("Seguindo");
		lblFollowing.getStyleClass().add("bspace-text");
		lblFollowing.getStyleClass().add("third-text");
		lblFollowing.getStyleClass().add("mini-text-small");
		followingBox.getChildren().add(lblFollowing);
		
		//edit
		btnEdit = new Button();
		btnEdit.setText("Editar perfil");
		btnEdit.getStyleClass().add("bspace-button");
		btnEdit.getStyleClass().add("large");
		btnEdit.getStyleClass().add("thin");
		btnEdit.getStyleClass().add("btn-black");
		btnEdit.getStyleClass().add("bordered");
		centerItems.getChildren().add(btnEdit);
		
		
	}
	
}
