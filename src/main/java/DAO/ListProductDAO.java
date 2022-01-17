package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ListProductDAO {
	public List<Product>search(String characters) throws Exception{
		List<Product> p = new ArrayList<>();
		Connection con;
		try {
			con = context.DBcontext.getConnection();
			String sql ="select * from Products";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
		          String name = rs.getString("product_name");
		          int id = rs.getInt("product_id");
	        	  String des = rs.getString("product_des");
	        	  float price = rs.getFloat("product_price");
	        	  String src = rs.getString("product_img_source");
	        	  String type = rs.getString("product_type");
	        	  String brand = rs.getString("product_brand");
		          if (characters=="") {
		        	  Product product = new Product(id, name, des, price, src, type, brand);
		        	  p.add(product);
		          }else if (name.contains(characters.trim())) {
		        	  Product product = new Product(id, name, des, price, src, type, brand);
		        	  p.add(product);
		          } 
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	
	public Product getProduct(String characters) throws Exception{
		Product p = null ;
		Connection con;
		try {
			con = context.DBcontext.getConnection();
			String sql ="select * from Products where product_id="+characters;
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 if(rs.next()) {
		          String name = rs.getString("product_name");
		          int id = rs.getInt("product_id");
	        	  String des = rs.getString("product_des");
	        	  float price = rs.getFloat("product_price");
	        	  String src = rs.getString("product_img_source");
	        	  String type = rs.getString("product_type");
	        	  String brand = rs.getString("product_brand");
		        
		           p = new Product(id, name, des, price, src, type, brand);
		    
		     }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	
}
