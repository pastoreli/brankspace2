package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.UserHeaderContent;
import fateczl.blankspace.entity.Usuario;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Header extends AnchorPane{
	
	Text title;
	TextField txtSearch;
	
	UserHeaderContent userHeaderContent;
	
	Usuario usuario;
	
	public Header() {
		
		getStyleClass().add("header");
		
		title = new Text();
		title.setText("Home");
		title.getStyleClass().add("header-title");
		AnchorPane.setLeftAnchor(title, (double)20);
		AnchorPane.setTopAnchor(title, (double)10);
		getChildren().add(title);
		
		txtSearch = new TextField ();
		txtSearch.getStyleClass().add("text-feild");
		txtSearch.getStyleClass().add("filled");
		txtSearch.getStyleClass().add("txt-search");
		txtSearch.setPromptText("Pesquisar");
		txtSearch.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent  event) {
				if (event.getCode().equals(KeyCode.ENTER)) {
					new Search(((TextField)event.getSource()).getText());
				}	
			}
		});
		AnchorPane.setRightAnchor(txtSearch, (double)20);
		AnchorPane.setTopAnchor(txtSearch, (double)10);
		getChildren().add(txtSearch);
		
	}
	
	public void updateTitle() {
		if(userHeaderContent != null) {
			this.getChildren().remove(userHeaderContent);
			userHeaderContent = null;
		}
		
		title.setText(App.PAGETITLE);
		title.setVisible(true);
	}
	
	public void addUserHeader(Usuario usuario) {
		userHeaderContent = new UserHeaderContent(usuario);
		AnchorPane.setLeftAnchor(userHeaderContent, (double)10);
		AnchorPane.setRightAnchor(userHeaderContent, (double)10);
		this.getChildren().add(userHeaderContent);
		title.setVisible(false);
	}
	
}
