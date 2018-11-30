package fateczl.blankspace.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Sidebar extends ScrollPane{

	AnchorPane menu;
	
	Button btnProfile, btnHome, btnFavorites, btnWrite, btnPublished, btnDraft, btnArchived, btnLogout;
	
	public Sidebar() {
		
		getStyleClass().add("sidebar");
		
		menu = new AnchorPane();
		setContent(menu);
		
		//profile buttons
		btnProfile = new Button();
//		btnProfile.setText("P");
		btnProfile.getStyleClass().add("btn-menu");
		btnProfile.setGraphic(new ImageView("user_icon.png"));
		btnProfile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Profile(null);
			}
		});
		addToSidebar(btnProfile/*component*/, 10/*top*/, 6/*left*/, 6/*right*/, -1);
		
//		menu buttons
		btnHome = new Button();
//		btnHome.setText("H");
		btnHome.getStyleClass().add("btn-menu");
		btnHome.setGraphic(new ImageView("feed_icon.png"));
		btnHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Home();
			}
		});
		addToSidebar(btnHome, 120, 6, 6, -1);
		
		btnFavorites = new Button();
//		btnFavorites.setText("F");
		btnFavorites.getStyleClass().add("btn-menu");
		btnFavorites.setGraphic(new ImageView("star_icon.png"));
		btnFavorites.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Favorites();
			}
		});
		addToSidebar(btnFavorites, 180, 6, 6, -1);
		
		btnWrite = new Button();
//		btnWrite.setText("W");
		btnWrite.getStyleClass().add("btn-menu");
		btnWrite.setGraphic(new ImageView("write_icon.png"));
		btnWrite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Write(null, null);
			}
		});
		addToSidebar(btnWrite, 240, 6, 6, -1);
		
		btnPublished = new Button();
//		btnPublished.setText("P");
		btnPublished.getStyleClass().add("btn-menu");
		btnPublished.setGraphic(new ImageView("published_icon.png"));
		btnPublished.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Published();
			}
		});
		addToSidebar(btnPublished, 300, 6, 6, -1);
		
		btnDraft = new Button();
//		btnDraft.setText("R");
		btnDraft.getStyleClass().add("btn-menu");
		btnDraft.setGraphic(new ImageView("draft_icon.png"));
		btnDraft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Drafts();
			}
		});
		addToSidebar(btnDraft, 360, 6, 6, -1);
		
		btnArchived = new Button();
//		btnArchived.setText("A");
		btnArchived.getStyleClass().add("btn-menu");
		btnArchived.setGraphic(new ImageView("archive_icon.png"));
		btnArchived.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//add to content pane
				new Archiveds();
			}
		});
		addToSidebar(btnArchived, 420, 6, 6, -1);
		
		//logout buttons
		btnLogout = new Button();
//		btnLogout.setText("L");
		btnLogout.getStyleClass().add("btn-menu");
		btnLogout.setGraphic(new ImageView("logout_icon.png"));
		btnLogout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Layout.logout();
			}
		});
		addToSidebar(btnLogout, 510, 6, 6, -1);
		
	}
	
	void addToSidebar(Button button, double top, double right, double left, double bottom) {
		
		if(top >= 0)
			AnchorPane.setTopAnchor(button, top);
		
		if(left >= 0)
			AnchorPane.setLeftAnchor(button, left);
		
		if(right >= 0)
			AnchorPane.setRightAnchor(button, right);
		
		if(bottom >= 0)
			AnchorPane.setBottomAnchor(button, bottom);
		
		menu.getChildren().add(button);
		
	}
	
}
