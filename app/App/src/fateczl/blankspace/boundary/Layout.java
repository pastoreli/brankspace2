package fateczl.blankspace.boundary;
import fateczl.blankspace.controller.AcessoController;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;

public class Layout extends BorderPane{
	
	public static Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
	
	public static BorderPane LAYOUTPANEL;
	
	public static Sidebar sidebar;
	public static Header header = new Header();
	public static Content content = new Content();
	public static PrimaryLayout primaryLayout;
	public static BorderPane admin;
	public static BorderPane contentPanel;
	
	public Layout() {
		
		admin = new BorderPane();
		
		getStyleClass().add("page");
		admin.setLeft(new Sidebar());
		
		contentPanel = new BorderPane();
		contentPanel.setTop(header);
		contentPanel.setCenter(content);
		admin.setCenter(contentPanel);
		
		setCenter(primaryLayout = new PrimaryLayout());
		
		LAYOUTPANEL = this;
		
//		AcessoController acessoController = new AcessoController();
//		if(acessoController.logar("pastoreli.igor@gmail.com", "123456") != null) {
//			login();
//		}else {
//			System.out.println("Não achou");
//		}
		
	}
	
	public static void changePage(String title, AnchorPane page) {
		App.PAGETITLE = title;
		header.updateTitle();
		content.changeContent(page);
	}
	
	public static void login() {
//		LAYOUTPANEL.setLeft(sidebar = new Sidebar());
//		LAYOUTPANEL.setCenter(contentPanel);
		LAYOUTPANEL.setCenter(admin);
		new Home();
	}
	
	public static void logout() {
//		LAYOUTPANEL.setLeft(null);
		LAYOUTPANEL.setCenter(primaryLayout = new PrimaryLayout());
	}
	
}
