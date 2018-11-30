package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import fateczl.blankspace.entity.Usuario;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Profile extends AnchorPane{

	Usuario usuario;
	
	public Profile(Usuario usuario) {
		
		this.usuario = (usuario == null? App.usuario : usuario);
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		Label lblLastPost = new Label("Ultimas Publicações");
		lblLastPost.getStyleClass().add("bspace-text");
		lblLastPost.getStyleClass().add("bold");
		lblLastPost.getStyleClass().add("third-text");
		lblLastPost.getStyleClass().add("normal-text");
		AnchorPane.setTopAnchor(lblLastPost, 5.0);
		AnchorPane.setLeftAnchor(lblLastPost, 100.0);
		getChildren().add(lblLastPost);
		
		ContentCards contentCards = new ContentCards(this.usuario, 2, 1, null, null);
		AnchorPane.setTopAnchor(contentCards, 40.0);
		AnchorPane.setRightAnchor(contentCards, 100.0);
		AnchorPane.setLeftAnchor(contentCards, 100.0);
		
		getChildren().add(contentCards);
		
		Layout.changePage("Perfíl", this);
		Layout.header.addUserHeader(this.usuario);
	}
	
}
