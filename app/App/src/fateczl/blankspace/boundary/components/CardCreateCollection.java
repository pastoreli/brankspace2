package fateczl.blankspace.boundary.components;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.Archiveds;
import fateczl.blankspace.boundary.Layout;
import fateczl.blankspace.boundary.Published;
import fateczl.blankspace.controller.ColecaoController;
import fateczl.blankspace.entity.Colecao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class CardCreateCollection extends HBox{

	Label lblTitle, subtitle;
	TextField txtTitle, txtSubtitle;
	Button btnCreate;
	
	public CardCreateCollection(int status) {
		
		AnchorPane card = new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("brand-card");
		getChildren().add(card);
		
		lblTitle = new Label("Título");
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("font-times");
		lblTitle.getStyleClass().add("third-text");
		lblTitle.getStyleClass().add("normal-text-2");
		lblTitle.getStyleClass().add("left-border-mini");
		AnchorPane.setTopAnchor(lblTitle, (double)10);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		card.getChildren().add(lblTitle);
		
		subtitle = new Label("Descricão");
		subtitle.getStyleClass().add("bspace-text");
		subtitle.getStyleClass().add("font-times");
		subtitle.getStyleClass().add("fourth-text");
		subtitle.getStyleClass().add("normal-text");
		subtitle.getStyleClass().add("left-border-mini");
		AnchorPane.setTopAnchor(subtitle, (double)50);
		AnchorPane.setLeftAnchor(subtitle, (double)10);
		card.getChildren().add(subtitle);
		
		txtTitle = new TextField();
		txtTitle.getStyleClass().add("bspace-text");
		txtTitle.getStyleClass().add("bold");
		txtTitle.getStyleClass().add("font-times");
		txtTitle.getStyleClass().add("primary-text");
		txtTitle.getStyleClass().add("normal-text-2");
		txtTitle.getStyleClass().add("text-feild-empty");
		AnchorPane.setTopAnchor(txtTitle, (double)2);
		AnchorPane.setLeftAnchor(txtTitle, (double)100);
		AnchorPane.setRightAnchor(txtTitle, (double)0);
		card.getChildren().add(txtTitle);
		
		txtSubtitle = new TextField();
		txtSubtitle.getStyleClass().add("bspace-text");
		txtSubtitle.getStyleClass().add("bold");
		txtSubtitle.getStyleClass().add("font-times");
		txtSubtitle.getStyleClass().add("secundary-text");
		txtSubtitle.getStyleClass().add("normal-text");
		txtSubtitle.getStyleClass().add("text-feild-empty");
		AnchorPane.setTopAnchor(txtSubtitle, (double)43);
		AnchorPane.setLeftAnchor(txtSubtitle, (double)100);
		AnchorPane.setRightAnchor(txtSubtitle, (double)0);
		card.getChildren().add(txtSubtitle);
		
		btnCreate = new Button();
		btnCreate.setText("Criar");
		btnCreate.getStyleClass().add("bspace-button");
		btnCreate.getStyleClass().add("rounded");
		btnCreate.getStyleClass().add("btn-brand");
		btnCreate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Colecao colecao = new Colecao();
				colecao.setTitulo(txtTitle.getText());
				colecao.setDescricao(txtSubtitle.getText());
				
				ColecaoController colecaoController = new ColecaoController();
				colecaoController.criarPublicacao(colecao, App.usuario.getId(), status);
				
				if(status == 1) {
					((Published)Layout.content.getContent()).changeSection(2);
				}else {
					((Archiveds)Layout.content.getContent()).changeSection(2);
				}
				
			}
		});
		AnchorPane.setBottomAnchor(btnCreate, (double)10);
		AnchorPane.setRightAnchor(btnCreate, (double)10);
		card.getChildren().add(btnCreate);
		
	}
	
}
