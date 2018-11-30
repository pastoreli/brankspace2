package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import javafx.scene.layout.AnchorPane;

public class Drafts extends AnchorPane{

	public Drafts() {
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		ContentCards contentCards = new ContentCards(App.usuario, 3, 3, null, null);
		AnchorPane.setRightAnchor(contentCards, 100.0);
		AnchorPane.setLeftAnchor(contentCards, 100.0);
		
		getChildren().add(contentCards);
		
		//add to content pane
		Layout.changePage("Rascunhos", this);
	}
	
}
