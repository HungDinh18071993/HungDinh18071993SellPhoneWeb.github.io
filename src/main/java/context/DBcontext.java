package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcontext {
	public static Connection getConnection() throws Exception{
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURl = "jdbc:sqlserver://DINHTRONGHUNG\\TRONGHUNG:1433;databaseName=ShoppingDB;integratedSecurity=true;";
			connection= DriverManager.getConnection(connectionURl);
			System.out.println("ket noi thanh cong!");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ket noi that bai!");
			System.err.println(e.getMessage()+"/n"+e.getClass()+"/n"+e.getCause());
		}
		return connection;
	}

}

