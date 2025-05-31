package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mywebsite";
			String username = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
