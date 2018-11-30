package fateczl.blankspace.boundary;
import java.sql.SQLException;

import fateczl.blankspace.dao.DBConnection;
import javafx.application.Application;

public class Main {

	public static void main(String []args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
		//here you call the main frame
		Application.launch(App.class, args); 
	}
	
}
