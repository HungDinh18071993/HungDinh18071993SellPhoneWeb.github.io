package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import DAO.ListProductDAO;
import model.Order_detail;

/**
 * Servlet implementation class SearchController2
 */
@WebServlet("/SearchController2")
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			Connection con = context.DBcontext.getConnection();
			HttpSession session= request.getSession(true);
			String sql = "select D.order_id,D.product_id,D.amount_product,D.price_product from Orders as O join Orders_detail as D on O.order_id = D.order_id where user_mail=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,(String) session.getAttribute("nameUserLogin"));
			ResultSet rs = stmt.executeQuery();
			List<Order_detail> odDetails =new ArrayList<Order_detail>();
			while(rs.next()) {
				odDetails.add(new Order_detail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			session.setAttribute("userLoginOrderDetail", odDetails);
			RequestDispatcher rd= request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.getWriter().println(e);
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
