package fateczl.blankspace.boundary;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Content extends ScrollPane{

	public Content() {
		getStyleClass().add("content");
//		getStyleClass().add("scroll-page");
	}
	
	public void changeContent(AnchorPane page) {
		setContent(page);
	}
	
}
