package fateczl.blankspace.boundary;

import fateczl.blankspace.boundary.components.CardHistory;
import fateczl.blankspace.boundary.components.ContentCards;
import fateczl.blankspace.boundary.components.FollowUserCard;
import fateczl.blankspace.controller.UsuarioController;
import fateczl.blankspace.entity.Historia;
import fateczl.blankspace.entity.Publicacao;
import fateczl.blankspace.entity.Usuario;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class FollowContent extends AnchorPane{
	
	UsuarioController usuarioController = new UsuarioController();
	
	public FollowContent(Usuario usuario, int type /*0 seguindores, 1 Seguindo*/) {
		
		getStyleClass().add("container-page");
		setPrefWidth(Layout.screenSize.getWidth()-60);
		
		GridPane grid = new GridPane();
		grid.setHgap(30);
		grid.setVgap(30);
		grid.setAlignment(Pos.CENTER);
		AnchorPane.setRightAnchor(grid, (double)100);
		AnchorPane.setLeftAnchor(grid, (double)100);	
		getChildren().add(grid);
		
		int c = 0, l = 0;
		int count = 0;
		for(Usuario u : type == 0 
				? usuarioController.listarSeguidores(usuario)
				: usuarioController.listarSeguintes(usuario)) {
			grid.add(new FollowUserCard(u, type), l, c);
			if(l < 3) {
				l++;
			}else {
				c++;
				l=0;
			}
		}
		
		Layout.changePage(type == 0? "Seguidores" : "Seguindo", this);
		
	}
	
}
