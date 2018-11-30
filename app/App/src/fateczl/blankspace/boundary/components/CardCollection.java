package fateczl.blankspace.boundary.components;

import java.text.SimpleDateFormat;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.HistoriesByColection;
import fateczl.blankspace.boundary.Read;
import fateczl.blankspace.controller.ColecaoController;
import fateczl.blankspace.entity.Colecao;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class CardCollection extends HBox{

	ColecaoController colecaoController = new ColecaoController();
	
	Label lblTitle, subtitle, lblAuthor, lblDate; 
	Button btnFavorite;
	
	boolean isFavorite;
	
	public CardCollection (Colecao colecao) {
		
		isFavorite = colecaoController.isFavorito(colecao, App.usuario);
		
		getStyleClass().add("card-container");

		AnchorPane card = new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("card-hitory");
		card.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				new HistoriesByColection(colecao);
			}
		});
		getChildren().add(card);
		
		lblTitle = new Label(colecao.getTitulo());
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("primary-text");
		lblTitle.getStyleClass().add("big-text-2");
		AnchorPane.setTopAnchor(lblTitle, (double)10);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		card.getChildren().add(lblTitle);
		
		subtitle = new Label(colecao.getDescricao());
		subtitle.getStyleClass().add("bspace-text");
		subtitle.getStyleClass().add("third-text");
		subtitle.getStyleClass().add("mini-text-2");
		AnchorPane.setTopAnchor(subtitle, (double)50);
		AnchorPane.setLeftAnchor(subtitle, (double)10);
		AnchorPane.setLeftAnchor(subtitle, (double)10);
		card.getChildren().add(subtitle);
		
//		lblAuthor = new Label(App.usuario.getNome());
//		lblAuthor.getStyleClass().add("bspace-text");
//		lblAuthor.getStyleClass().add("secundary-text");
//		lblAuthor.getStyleClass().add("mini-text");
//		AnchorPane.setBottomAnchor(lblAuthor, (double)25);
//		AnchorPane.setLeftAnchor(lblAuthor, (double)10);
//		AnchorPane.setLeftAnchor(lblAuthor, (double)10);
//		card.getChildren().add(lblAuthor);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		lblDate = new Label(format.format(colecao.getDataModificacao()));
		lblDate.getStyleClass().add("bspace-text");
		lblDate.getStyleClass().add("third-text");
		lblDate.getStyleClass().add("mini-text-small");
		AnchorPane.setBottomAnchor(lblDate, (double)10);
		AnchorPane.setLeftAnchor(lblDate, (double)10);
		AnchorPane.setLeftAnchor(lblDate, (double)10);
		card.getChildren().add(lblDate);
		
		btnFavorite = new Button();
		btnFavorite.getStyleClass().add("bspace-button-transparent");
		btnFavorite.setGraphic(new ImageView(new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png" , 15, 15, false, false)));
		AnchorPane.setBottomAnchor(btnFavorite, (double)0);
		AnchorPane.setRightAnchor(btnFavorite, (double)2);
		btnFavorite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				if(isFavorite)
					colecaoController.removerPublicacaoFavorito(colecao, App.usuario);
				else
					colecaoController.adicionarPublicacaoFavorito(colecao, App.usuario);
				
				isFavorite = !isFavorite;
				btnFavorite.setGraphic(new ImageView(new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png" , 15, 15, false, false)));
			}
		});
		card.getChildren().add(btnFavorite);
		
	}
	
}
