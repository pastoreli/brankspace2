package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.CardCollection;
import fateczl.blankspace.boundary.components.ContentCards;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Favorites extends AnchorPane{
	
	Button btnHistory, btnColection;
	ContentCards contentCards;
	
	public Favorites() {
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		HBox buttonBox = new HBox();
		buttonBox.setAlignment(Pos.CENTER);
		
		btnHistory = new Button();
		btnHistory.setText("Hist�rias");
		btnHistory.getStyleClass().add("bspace-button");
		btnHistory.getStyleClass().add("btn-brand");
		btnHistory.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				if(btnHistory.getStyleClass().contains("bordered")){
					btnHistory.getStyleClass().remove("bordered");
					btnColection.getStyleClass().add("bordered");
					changeSection(5);
				}
				
			}
		});
		buttonBox.getChildren().add(btnHistory);
		
		btnColection = new Button();
		btnColection.setText("Cole��es");
		btnColection.getStyleClass().add("bspace-button");
		btnColection.getStyleClass().add("btn-brand");
		btnColection.getStyleClass().add("bordered");
		btnColection.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				if(btnColection.getStyleClass().contains("bordered")){
					btnHistory.getStyleClass().add("bordered");
					btnColection.getStyleClass().remove("bordered");
					changeSection(6);
				}
			}
		});
		buttonBox.getChildren().add(btnColection);
		
		AnchorPane.setTopAnchor(buttonBox, (double)5);
		AnchorPane.setRightAnchor(buttonBox, 100.0);
		AnchorPane.setLeftAnchor(buttonBox, 100.0);
		getChildren().add(buttonBox);
		
		changeSection(5);
		
		//add to content pane
		Layout.changePage("Favoritos", this);
		
	}
	
	//change the card content
	public void changeSection(int type) {
		this.getChildren().remove(contentCards);
		
		contentCards = new ContentCards(App.usuario, type, 1, null, null);
		AnchorPane.setTopAnchor(contentCards, (double)60);
		AnchorPane.setRightAnchor(contentCards, (double)100);
		AnchorPane.setLeftAnchor(contentCards, (double)100);
		
		getChildren().add(contentCards);		
	}
	
}
