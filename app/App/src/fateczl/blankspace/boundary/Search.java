package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Search extends AnchorPane{
	
	String search;
	
	Button btnHistory, btnColection, btnUser;
	
	ContentCards contentCards;
	
	public Search(String search) {
		
		this.search = search;
		
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
				if(btnHistory.getStyleClass().contains("bordered"))
					btnHistory.getStyleClass().remove("bordered");
					
				if(!btnColection.getStyleClass().contains("bordered"))
					btnColection.getStyleClass().add("bordered");
					
				if(!btnUser.getStyleClass().contains("bordered"))
					btnUser.getStyleClass().add("bordered");
				
				changeSection(3);
				
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
				if(!btnHistory.getStyleClass().contains("bordered"))
					btnHistory.getStyleClass().add("bordered");
					
				if(btnColection.getStyleClass().contains("bordered"))
					btnColection.getStyleClass().remove("bordered");
					
				if(!btnUser.getStyleClass().contains("bordered"))
					btnUser.getStyleClass().add("bordered");
					changeSection(2);
			}
		});
		buttonBox.getChildren().add(btnColection);
		
		btnUser = new Button();
		btnUser.setText("Usuários");
		btnUser.getStyleClass().add("bspace-button");
		btnUser.getStyleClass().add("btn-brand");
		btnUser.getStyleClass().add("bordered");
		btnUser.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent event) {
				if(!btnHistory.getStyleClass().contains("bordered"))
					btnHistory.getStyleClass().add("bordered");
					
				if(!btnColection.getStyleClass().contains("bordered"))
					btnColection.getStyleClass().add("bordered");
					
				if(btnUser.getStyleClass().contains("bordered"))
					btnUser.getStyleClass().remove("bordered");

				changeSection(4);
				
			}
		});
		buttonBox.getChildren().add(btnUser);
		
		AnchorPane.setTopAnchor(buttonBox, (double)5);
		AnchorPane.setRightAnchor(buttonBox, 100.0);
		AnchorPane.setLeftAnchor(buttonBox, 100.0);
		getChildren().add(buttonBox);
		
		changeSection(3);
		
		Layout.changePage(search, this);
	}
	
	//change the card content
	public void changeSection(int type) {
		this.getChildren().remove(contentCards);
			System.out.println(search);
		contentCards = new ContentCards(App.usuario, type, 1, search, null);
		AnchorPane.setTopAnchor(contentCards, (double)60);
		AnchorPane.setRightAnchor(contentCards, (double)100);
		AnchorPane.setLeftAnchor(contentCards, (double)100);
		
		getChildren().add(contentCards);		
	}
	
}
