package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import fateczl.blankspace.controller.ColecaoController;
import fateczl.blankspace.entity.Colecao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class HistoriesByColection extends AnchorPane{

	ColecaoController colecaoController = new ColecaoController();
	
	ContentCards contentCards;
	
	Button btnDelete, btnWrite;
	
	public HistoriesByColection(Colecao colecao) {
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		HBox optionBox = new HBox();
		AnchorPane.setTopAnchor(optionBox, (double)20);
		AnchorPane.setRightAnchor(optionBox, (double)20);
		getChildren().add(optionBox);
		
		btnDelete = new Button("Excluir");
		btnDelete.getStyleClass().add("bspace-button-transparent");
		btnDelete.getStyleClass().add("bspace-text");
		btnDelete.getStyleClass().add("third-text");
		btnDelete.getStyleClass().add("mini-text-2");
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				colecaoController.removerPublicacao(colecao);
				
				if(colecao.getStatus() == 1) {
					new Published();
				}else if(colecao.getStatus() == 2) {
					new Archiveds();
				}else if(colecao.getStatus() == 3) {
					new Drafts();
				}
				
			}
		});
		optionBox.getChildren().add(btnDelete);
		
		btnWrite = new Button("Nova história");
		btnWrite.getStyleClass().add("bspace-button-transparent");
		btnWrite.getStyleClass().add("bspace-text");
		btnWrite.getStyleClass().add("brand-text");
		btnWrite.getStyleClass().add("mini-text-2");
		btnWrite.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				new Write(null, colecao);
				
			}
		});
		optionBox.getChildren().add(btnWrite);
		
		
		contentCards = new ContentCards(App.usuario, 3, colecao.getStatus(), null, colecao);
		AnchorPane.setTopAnchor(contentCards, (double)60);
		AnchorPane.setRightAnchor(contentCards, (double)100);
		AnchorPane.setLeftAnchor(contentCards, (double)100);
			
		getChildren().add(contentCards);		
		
		Layout.changePage(colecao.getTitulo(), this);
		
	}
	
}
