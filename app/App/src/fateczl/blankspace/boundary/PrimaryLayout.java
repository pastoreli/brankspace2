package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.primaryComponents.Login;
import fateczl.blankspace.boundary.primaryComponents.Register;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class PrimaryLayout extends AnchorPane{

	AnchorPane card;
	
	Login login;
	AnchorPane content;
	
	Button btnRegister;
	
	public PrimaryLayout() {
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		card =  new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("card-hitory");
		AnchorPane.setTopAnchor(card, (double)150);
		AnchorPane.setRightAnchor(card, (double)180);
		AnchorPane.setLeftAnchor(card, (double)180);
		AnchorPane.setBottomAnchor(card, (double)150);
		getChildren().add(card);
		
		//info card
		AnchorPane infoPanel = new AnchorPane();
		infoPanel.getStyleClass().add("register_layer");
		AnchorPane.setTopAnchor(infoPanel, (double)0);
		AnchorPane.setLeftAnchor(infoPanel, (double)500);
		AnchorPane.setRightAnchor(infoPanel, (double)0);
		AnchorPane.setBottomAnchor(infoPanel, (double)0);
		card.getChildren().add(infoPanel);
		
		Label logo = new Label("Logo");
		logo.getStyleClass().add("bspace-text");
		logo.getStyleClass().add("bold");
		logo.getStyleClass().add("primary-text");
		logo.getStyleClass().add("big-text-2");
		AnchorPane.setTopAnchor(logo, (double)40);
		AnchorPane.setLeftAnchor(logo, (double)40);
		AnchorPane.setRightAnchor(logo, (double)40);
		infoPanel.getChildren().add(logo);
		
		Label description = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut bibendum lacinia purus, in posuere erat tempor ac. Morbi aliquet.");
		description.getStyleClass().add("bspace-text");
		description.getStyleClass().add("secundary-text");
		description.getStyleClass().add("normal-text");
		description.setWrapText(true);
		AnchorPane.setTopAnchor(description, (double)100);
		AnchorPane.setLeftAnchor(description, (double)40);
		AnchorPane.setRightAnchor(description, (double)40);
		infoPanel.getChildren().add(description);
		
		btnRegister = new Button("Ainda não possuí uma conta?");
		btnRegister.getStyleClass().addAll("bspace-button-transparent", "bspace-text", "third-text", "mini-text-2", "underline");
		btnRegister.setCursor(Cursor.HAND);
		AnchorPane.setBottomAnchor(btnRegister, (double)20);
		AnchorPane.setLeftAnchor(btnRegister, (double)40);
		AnchorPane.setRightAnchor(btnRegister, (double)40);
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addForm(new Register());
			}
		});
		infoPanel.getChildren().add(btnRegister);
		
		addForm(new Login());
		
	}
	
	public void addForm(AnchorPane content) {
		
		if(card.getChildren().contains(this.content)) {
			card.getChildren().remove(this.content);
		}
		
		this.content = content;
		AnchorPane.setTopAnchor(this.content, (double)0);
		AnchorPane.setLeftAnchor(this.content, (double)20);
		AnchorPane.setRightAnchor(this.content, (double)420);
		AnchorPane.setBottomAnchor(this.content, (double)0);
		card.getChildren().add(this.content);
	}
	
}
