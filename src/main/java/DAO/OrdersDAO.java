package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	public void insertOrder(Orders o,Cart c,HttpSession s ) throws Exception{
		Connection con;
		try {
			con = context.DBcontext.getConnection();
			String sql ="select count(*) as count from Orders";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("count");
			}
			stmt.close();
			System.out.println("count="+count);
			
			String sql2 = "insert into Orders(user_mail,order_status,order_date,order_discount_code,order_address) values(?,?,?,?,?)";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			
			if(s.getAttribute("user")!=null) {
				stmt2.setString(1, (String) s.getAttribute("nameUserLogin"));
				stmt2.setString(5, (String) s.getAttribute("addressUserLogin"));
			}else {
				stmt2.setString(1, o.getUserMail());
				stmt2.setString(5, o.getAddress());
			}
			
			stmt2.setInt(2,o.getStatus());
			stmt2.setDate(3, o.getReceivedDate());
			stmt2.setString(4, o.getDiscount());
			
			
			stmt2.executeUpdate();
			stmt2.close();
			
			// product order
			List<Product> list_p = c.getItem();
			for(int i=0; i< list_p.size();i++) {
				String sql3 = "insert into Orders_detail(order_id,product_id,amount_product,price_product) values(?,?,?,?)";
				PreparedStatement stmt3 = con.prepareStatement(sql3);
				
				stmt3.setInt(1,count+1 );
				stmt3.setInt(2, list_p.get(i).getId());
				stmt3.setInt(3,list_p.get(i).getNumber());
				stmt3.setInt(4,(int)list_p.get(i).getPrice() );
			
				
				stmt3.executeUpdate();
				stmt3.close();
			}
			
			//customer
			String sql4 = "insert into Account(user_mail,password,account_role,user_name) values(?,?,?,?)";
			PreparedStatement stmt4 = con.prepareStatement(sql4);
			
			if(s.getAttribute("user")==null) {
				stmt4.setString(1,o.getUserMail() );
				stmt4.setString(2, "123");
				stmt4.setInt(3,1);
				stmt4.setString(4,o.getUserMail() );
				stmt4.executeUpdate();
				
			}
			stmt4.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
