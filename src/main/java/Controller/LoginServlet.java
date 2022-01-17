package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			request.getSession(true).invalidate();
			//make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9!@#$%^&*]+";
			//collect data from login form
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			
			Connection con = context.DBcontext.getConnection();
			Account account = new Account();
			account.setName(user);
			account.setPwd(password);
			
			HttpSession session= request.getSession(true);
			if(!password.matches(regex) || !user.matches(regexMail)) {
				session.setAttribute("error", "invalid syntax");
				session.setAttribute("status_Login", "Login");
				response.sendRedirect("login.jsp");
			}
			
			
			// get data from database (Account)
		
			
			if(user !=null && account.login(user, password, con,session)==true )
			{
				// cookie
			      Cookie u = new Cookie("user", account.getName());
			      Cookie p = new Cookie("pass", account.getPwd());
			      if (request.getParameter("chkRemember") != null) {
			        u.setMaxAge(60 * 60 * 24);
			        p.setMaxAge(60 * 60 * 24);
			      } else {
			        u.setMaxAge(0);
			        p.setMaxAge(0);
			      }
			      response.addCookie(u);
			      response.addCookie(p);
				//set session
				session.setAttribute("user", user);
				session.setAttribute("status_Login", "Logout");
				//login is valid -> redirect to index
				response.sendRedirect("ListController");
			}else {
				session.setAttribute("error", "wrong user or password");
				session.setAttribute("status_Login", "Login");
				response.sendRedirect("login.jsp");
			}
			
			
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}

}
