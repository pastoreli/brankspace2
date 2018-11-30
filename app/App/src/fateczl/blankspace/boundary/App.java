package fateczl.blankspace.boundary;

import fateczl.blankspace.controller.ColecaoController;
import fateczl.blankspace.controller.HistoriaController;
import fateczl.blankspace.entity.Usuario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;;

public class App extends Application{
	
	public static String PAGETITLE = "";
	public static Usuario usuario;
	
	HistoriaController hist = new HistoriaController();
	ColecaoController colec = new ColecaoController();
	
	@Override
	public void start(Stage stage) throws Exception {
		
//		StackPane raiz = new StackPane(); // 4
//		
//		raiz.getChildren().add(new Layout()); // 7

		Scene scene = new Scene(new Layout());
		scene.getStylesheets().add(getClass().getResource("./assets/main.css").toExternalForm());
		
		stage.setTitle("Blank Space");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
		
		//show dw git <3
		
	}

}
