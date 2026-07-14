package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_management";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "Shiva@8790";
	
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Database Connected Successfully : Shiva");
            return connection;
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return null;
	}
	
}
 