package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Published extends AnchorPane{
	//minha publicacoes
	Button btnHistory, btnColection;
	
	ContentCards contentCards;
	
	public Published() {
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		HBox buttonBox = new HBox();
		buttonBox.setAlignment(Pos.CENTER);
		
		btnHistory = new Button();
		btnHistory.setText("Histórias");
		btnHistory.getStyleClass().add("bspace-button");
		btnHistory.getStyleClass().add("btn-brand");
		btnHistory.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				if(btnHistory.getStyleClass().contains("bordered")){
					btnHistory.getStyleClass().remove("bordered");
					btnColection.getStyleClass().add("bordered");
					changeSection(3);
				}
				
			}
		});
		buttonBox.getChildren().add(btnHistory);
		
		btnColection = new Button();
		btnColection.setText("Coleções");
		btnColection.getStyleClass().add("bspace-button");
		btnColection.getStyleClass().add("btn-brand");
		btnColection.getStyleClass().add("bordered");
		btnColection.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				if(btnColection.getStyleClass().contains("bordered")){
					btnHistory.getStyleClass().add("bordered");
					btnColection.getStyleClass().remove("bordered");
					changeSection(2);
				}
			}
		});
		buttonBox.getChildren().add(btnColection);
		
		AnchorPane.setTopAnchor(buttonBox, (double)5);
		AnchorPane.setRightAnchor(buttonBox, (double)100);
		AnchorPane.setLeftAnchor(buttonBox, (double)100);
		getChildren().add(buttonBox);
		
		changeSection(3);
		
		//add to content pane
		Layout.changePage("Publicadas", this);
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
