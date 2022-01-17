package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.Product;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("usermailR");
		String name = request.getParameter("usernameR");
		String password = request.getParameter("passwordR");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		try {
			Connection con = context.DBcontext.getConnection();
			Account account = new Account();
			
			if(account.exists(mail, con)==false) {
				//customer
				String sql4 = "insert into Account(user_mail,password,account_role,user_name,user_address,user_phone) values(?,?,?,?,?,?)";
				PreparedStatement stmt4 = con.prepareStatement(sql4);
				
				stmt4.setString(1,mail );
				stmt4.setString(2, password);
				stmt4.setInt(3,1);
				stmt4.setString(4,name);
				stmt4.setString(5,address );
				stmt4.setString(6,phone  );
			
				
				stmt4.executeUpdate();
				stmt4.close();
				request.setAttribute("errorRegister", "");
				response.sendRedirect("ListController");
			} else {
				request.setAttribute("errorRegister", "email has already exist!");
				response.sendRedirect("Register.jsp");
			}
			
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
