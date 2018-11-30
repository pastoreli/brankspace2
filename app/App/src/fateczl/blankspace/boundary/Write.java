package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.ContentCards;
import fateczl.blankspace.controller.HistoriaController;
import fateczl.blankspace.entity.Colecao;
import fateczl.blankspace.entity.Historia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Write extends AnchorPane{
	
	//left buttons options
	Button btnPicture;
	Label lblTitle, lblHistory;
	
	//Write area
	TextField txtTitle;
	TextArea txtHistory;
	
	//options buttons
	Button btnArquivar, btnSave;
	
	Colecao colecao;
	
	HistoriaController historiaController = new HistoriaController();
	
	public Write(Historia historia, Colecao colecao) {
		
		this.colecao = colecao;
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		HBox optionBox = new HBox();
		AnchorPane.setTopAnchor(optionBox, (double)-10);
		AnchorPane.setRightAnchor(optionBox, (double)20);
		getChildren().add(optionBox);
		
		btnArquivar = new Button("Arquivar");
		if(historia != null) btnArquivar.setVisible(false);
		btnArquivar.getStyleClass().add("bspace-button-transparent");
		btnArquivar.getStyleClass().add("bspace-text");
		btnArquivar.getStyleClass().add("third-text");
		btnArquivar.getStyleClass().add("mini-text-2");
		btnArquivar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				saveHistory(2);
				
				new Archiveds();
				
			}
		});
		optionBox.getChildren().add(btnArquivar);
		
		btnSave = new Button("Publicar");
		btnSave.getStyleClass().add("bspace-button-transparent");
		btnSave.getStyleClass().add("bspace-text");
		btnSave.getStyleClass().add("brand-text");
		btnSave.getStyleClass().add("mini-text-2");
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("click");
				if(historia == null) {
					saveHistory(1);
					new Published();
				}else {
					historia.setTitulo(txtTitle.getText());
					historia.setConteudo(txtHistory.getText());
					historiaController.editarPublicacao(historia);
					System.out.println("Edit");
					new Read(historia.getStatus(), historia);
				}
				
			}
		});
		optionBox.getChildren().add(btnSave);
		
		AnchorPane leftContent = new AnchorPane();
		AnchorPane.setTopAnchor(leftContent, (double)20);
		AnchorPane.setLeftAnchor(leftContent, (double)20);
		getChildren().add(leftContent);
		
//		btnPicture = new Button();
//		btnPicture.getStyleClass().add("bspace-image-button");
//		btnPicture.setGraphic(new ImageView("add_image_icon.png"));
//		AnchorPane.setTopAnchor(btnPicture, (double)10);
//		AnchorPane.setLeftAnchor(btnPicture, (double)10);
//		leftContent.getChildren().add(btnPicture);
		
		lblTitle = new Label("Título");
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("font-times");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("third-text");
		lblTitle.getStyleClass().add("big-text");
		lblTitle.getStyleClass().add("left-border");
		AnchorPane.setTopAnchor(lblTitle, (double)80);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		leftContent.getChildren().add(lblTitle);
		
		lblHistory = new Label("Sua história");
		lblHistory.getStyleClass().add("bspace-text");
		lblHistory.getStyleClass().add("font-times");
		lblHistory.getStyleClass().add("fourth-text");
		lblHistory.getStyleClass().add("normal-text");
		lblHistory.getStyleClass().add("left-border");
		AnchorPane.setTopAnchor(lblHistory, (double)140);
		AnchorPane.setLeftAnchor(lblHistory, (double)10);
		leftContent.getChildren().add(lblHistory);
		
		//write area
		AnchorPane writeContent = new AnchorPane();
		AnchorPane.setTopAnchor(writeContent, (double)20);
		AnchorPane.setLeftAnchor(writeContent, (double)200);
		AnchorPane.setRightAnchor(writeContent, (double)0);
		AnchorPane.setBottomAnchor(writeContent, (double)0);
		getChildren().add(writeContent);
		
		txtTitle = new TextField();
		txtTitle.getStyleClass().add("bspace-text");
		txtTitle.getStyleClass().add("bold");
		txtTitle.getStyleClass().add("font-times");
		txtTitle.getStyleClass().add("primary-text");
		txtTitle.getStyleClass().add("big-text");
		txtTitle.getStyleClass().add("text-feild-empty");
		AnchorPane.setTopAnchor(txtTitle, (double)70);
		AnchorPane.setLeftAnchor(txtTitle, (double)10);
		AnchorPane.setRightAnchor(txtTitle, (double)10);
		if(historia != null) txtTitle.setText(historia.getTitulo());
		writeContent.getChildren().add(txtTitle);
		
		txtHistory = new TextArea();
		txtHistory.getStyleClass().add("bspace-text");
		txtHistory.getStyleClass().add("font-times");
		txtHistory.getStyleClass().add("secundary-text");
		txtHistory.getStyleClass().add("normal-text");
		txtHistory.getStyleClass().add("text-feild-empty");
		AnchorPane.setTopAnchor(txtHistory, (double)130);
		AnchorPane.setLeftAnchor(txtHistory, (double)10);
		AnchorPane.setRightAnchor(txtHistory, (double)10);
		AnchorPane.setBottomAnchor(txtHistory, (double)10);
		if(historia != null) txtHistory.setText(historia.getConteudo());
		writeContent.getChildren().add(txtHistory);
		
		//add to content pane
		Layout.changePage(historia == null? "Escrever" : "Edição", this);
		
	}
	
	void saveHistory(int status) {
		
		Historia historia = new Historia();
		historia.setTitulo(txtTitle.getText());
		historia.setConteudo(txtHistory.getText());
		historia.setColecao(colecao);
	
		historiaController.criarPublicacao(historia, App.usuario.getId(), status);
		
	}
	
}
