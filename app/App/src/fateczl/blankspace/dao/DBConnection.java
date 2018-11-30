package fateczl.blankspace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection CONNECTION;
	
	public DBConnection() {
		createConnection();
	}
	
	public void createConnection() {
		if(CONNECTION == null) {
			try{
				CONNECTION = DriverManager.getConnection("jdbc:mysql://localhost/bdBlankSpace?useTimezone=true&serverTimezone=UTC","root" , "");
			}catch(SQLException e){		
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
}
