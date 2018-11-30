package fateczl.blankspace.boundary;

import fateczl.blankspace.controller.HistoriaController;
import fateczl.blankspace.entity.Historia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Read extends AnchorPane{
	
	HistoriaController historiaController = new HistoriaController();

	Label cover, lblTitle,lblHistory;

	Button btnSituation, btnEdit, btnDelete, btnFavorite;
	
	double withScreen = Layout.screenSize.getWidth();
	double HeightScreen = Layout.screenSize.getHeight();
	
	boolean isFavorite;
	
	public Read(int status, Historia historia) {
		
		isFavorite = historiaController.isFavorito(historia, App.usuario);
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		cover = new Label();
		cover.setGraphic(new ImageView("card_cover.jpg"));
		cover.getStyleClass().add("card-cover");
		cover.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(cover, (double)-10);
		AnchorPane.setLeftAnchor(cover, (double)0);
		AnchorPane.setRightAnchor(cover, (double)0);
		getChildren().add(cover);
		
		AnchorPane writeContent = new AnchorPane();
		AnchorPane.setTopAnchor(writeContent, (double)250);
		AnchorPane.setLeftAnchor(writeContent, (double)0);
		AnchorPane.setRightAnchor(writeContent, (double)0);
		AnchorPane.setBottomAnchor(writeContent, (double)10);
		writeContent.getStyleClass().add("container-page");
		writeContent.setPrefWidth(Layout.screenSize.getWidth()-60);
		getChildren().add(writeContent);
		
		HBox optionBox = new HBox();
		AnchorPane.setTopAnchor(optionBox, (double)0);
		AnchorPane.setRightAnchor(optionBox, (double)20);
		writeContent.getChildren().add(optionBox);
		
		if(historia.getIdUsuario() == App.usuario.getId()) {
			
			btnSituation = new Button("Arquivar");
			btnSituation.getStyleClass().add("bspace-button-transparent");
			btnSituation.getStyleClass().add("bspace-text");
			btnSituation.getStyleClass().add("third-text");
			btnSituation.getStyleClass().add("mini-text-2");
			optionBox.getChildren().add(btnSituation);
			
			btnEdit = new Button("Editar");
			btnEdit.getStyleClass().add("bspace-button-transparent");
			btnEdit.getStyleClass().add("bspace-text");
			btnEdit.getStyleClass().add("brand-text");
			btnEdit.getStyleClass().add("mini-text-2");
			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					new Write(historia, null);
				}
			});
			optionBox.getChildren().add(btnEdit);
			
			btnDelete = new Button("Excluir");
			btnDelete.getStyleClass().add("bspace-button-transparent");
			btnDelete.getStyleClass().add("bspace-text");
			btnDelete.getStyleClass().add("third-text");
			btnDelete.getStyleClass().add("mini-text-2");
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("cli");
					historiaController.removerPublicacao(historia);
					
					if(historia.getStatus() == 1) {
						new Published();
					}else if(historia.getStatus() == 2) {
						new Archiveds();
					}else if(historia.getStatus() == 3) {
						new Drafts();
					}
					
				}
			});
			optionBox.getChildren().add(btnDelete);
			
		}else {
			
			Image image = new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png", 25, 25, false, false);
			
			btnFavorite = new Button();
			btnFavorite.getStyleClass().add("bspace-button-transparent");
			btnFavorite.setGraphic(new ImageView(image));
			System.out.println(historia.getIdUsuario());
			if(historia.getIdUsuario() == App.usuario.getId()) {
				btnFavorite.setVisible(false);
			}
			AnchorPane.setBottomAnchor(btnFavorite, (double)0);
			AnchorPane.setRightAnchor(btnFavorite, (double)0);
			btnFavorite.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
					if(isFavorite)
						historiaController.removerPublicacaoFavorito(historia, App.usuario);
					else
						historiaController.adicionarPublicacaoFavorito(historia, App.usuario);
					
					isFavorite = !isFavorite;
					Image image = new Image(isFavorite? "fill_star_icon.png" : "empty_star_icon.png", 25, 25, false, false);
					btnFavorite.setGraphic(new ImageView(image));
				}
			});
			optionBox.getChildren().add(btnFavorite);
		}
		
		lblTitle = new Label(historia.getTitulo());
		lblTitle.getStyleClass().add("bspace-text");
		lblTitle.getStyleClass().add("bold");
		lblTitle.getStyleClass().add("primary-text");
		lblTitle.getStyleClass().add("big-text-2");
		AnchorPane.setTopAnchor(lblTitle, (double)20);
		AnchorPane.setLeftAnchor(lblTitle, (double)10);
		AnchorPane.setRightAnchor(lblTitle, (double)10);
		writeContent.getChildren().add(lblTitle);
		
		lblHistory = new Label(historia.getConteudo());
		lblHistory.getStyleClass().add("bspace-text");
		lblHistory.getStyleClass().add("secundary-text");
		lblHistory.getStyleClass().add("normal-text");
		lblHistory.setWrapText(true);
		AnchorPane.setTopAnchor(lblHistory, (double)70);
		AnchorPane.setLeftAnchor(lblHistory, (double)10);
		AnchorPane.setRightAnchor(lblHistory, (double)10);
		writeContent.getChildren().add(lblHistory);
//		
		Layout.changePage("Leitura", this);
		
	}
	
	String lore() {
		return "The standard Lorem Ipsum passage, used since the 1500s\r\n" + 
				"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\r\n" + 
				"\r\n" + 
				"Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\r\n" + 
				"\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\r\n" + 
				"\r\n" + 
				"1914 translation by H. Rackham\r\n" + 
				"\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\"\r\n" + 
				"\r\n" + 
				"Section 1.10.33 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\r\n" + 
				"\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"\r\n" + 
				"\r\n" + 
				"1914 translation by H. Rackham\r\n" + 
				"\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.\"";
	}
	
}
