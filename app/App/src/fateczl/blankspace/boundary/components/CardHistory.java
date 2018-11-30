package fateczl.blankspace.boundary.components;

import java.text.SimpleDateFormat;

import fateczl.blankspace.boundary.App;
import fateczl.blankspace.boundary.Read;
import fateczl.blankspace.controller.HistoriaController;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class CardHistory extends HBox{

	HistoriaController historiaController = new HistoriaController();
	
	Label cover;
	Label lblTitle, lblAuthor, lblDate; 
	Button btnFavorite;
	
	boolean isFavorite;
	
	public CardHistory(Historia historia) {
		
		isFavorite = historiaController.isFavorito(historia, App.usuario);
		
		getStyleClass().add("card-container");
		
		AnchorPane card = new AnchorPane();
		card.getStyleClass().add("card");
		card.getStyleClass().add("card-hitory");
		card.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				new Read(1, historia);
			}
		});
		getChildren().add(card);
		
		Image image = new Image(historia.getImagem(), 230, 120, false, false);
		cover = new Label();
		cover.setGraphic(new ImageView(image));
		cover.getStyleClass().add("card-cover");
		AnchorPane.setTopAnchor(cover, (double)1);
		card.getChildren().add(cover);
		
		lblTitle = new Label(historia.getTitulo());
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("primary-text");
		lblTitle.getStyleClass().add("normal-text-2");
		AnchorPane.setTopAnchor(lblTitle, (double)130);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		card.getChildren().add(lblTitle);
		
//		lblAuthor = new Label(App.usuario.getNome());
//		lblAuthor.getStyleClass().add("bspace-text");
//		lblAuthor.getStyleClass().add("secundary-text");
//		lblAuthor.getStyleClass().add("mini-text");
//		AnchorPane.setBottomAnchor(lblAuthor, (double)25);
//		AnchorPane.setLeftAnchor(lblAuthor, (double)10);
//		card.getChildren().add(lblAuthor);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		lblDate = new Label(format.format(historia.getDataModificacao()));
		lblDate.getStyleClass().add("bspace-text");
		lblDate.getStyleClass().add("third-text");
		lblDate.getStyleClass().add("mini-text-small");
		AnchorPane.setBottomAnchor(lblDate, (double)10);
		AnchorPane.setLeftAnchor(lblDate, (double)10);
		card.getChildren().add(lblDate);
		
		btnFavorite = new Button();
		btnFavorite.getStyleClass().add("bspace-button-transparent");
		btnFavorite.setGraphic(new ImageView(new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png" , 15, 15, false, false)));
		System.out.println(historia.getIdUsuario());
		if(historia.getIdUsuario() == App.usuario.getId()) {
			btnFavorite.setVisible(false);
		}
		AnchorPane.setBottomAnchor(btnFavorite, (double)0);
		AnchorPane.setRightAnchor(btnFavorite, (double)2);
		btnFavorite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				if(isFavorite)
					historiaController.removerPublicacaoFavorito(historia, App.usuario);
				else
					historiaController.adicionarPublicacaoFavorito(historia, App.usuario);
				
				isFavorite = !isFavorite;
				btnFavorite.setGraphic(new ImageView(new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png" , 15, 15, false, false)));
			}
		});
		card.getChildren().add(btnFavorite);
		
	}
	
}
