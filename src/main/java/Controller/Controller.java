package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Controller
 */
//@WebServlet("/Controller") 
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURl = "jdbc:sqlserver://DINHTRONGHUNG\\TRONGHUNG:1433;databaseName=ShoppingDB;integratedSecurity=true;";
			try {
				connection= DriverManager.getConnection(connectionURl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("ket noi thanh cong!");
			con = connection;
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ket noi that bai!");
			System.err.println(e.getMessage()+"/n"+e.getClass()+"/n"+e.getCause());
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws Exception{
		return con;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		doGet(request, response);
	}

}
