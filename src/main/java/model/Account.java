package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class Account {
	private String usr,pwd;
	private int role;
	private String name,address,phoneString;
	private int check;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String usr, String pwd, int role, String name, String address, String phoneString, int check) {
		super();
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phoneString = phoneString;
		this.check = check;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneString() {
		return phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
	
	public boolean login(String email, String password, Connection connect,HttpSession s) throws SQLException {
		String sql = "select count(*) as count from Account where user_mail=? and password=?";
		
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			int count = 0;
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
			
			if(count==0) {
				return false;
			}
			else {
				String sql2 = "select * from Account where user_mail=? and password=?";
				
				PreparedStatement stmt2 = connect.prepareStatement(sql2);
				stmt2.setString(1, email);
				stmt2.setString(2, password);
				
				ResultSet rs2 = stmt2.executeQuery();
				if(rs2.next()) {
					String nul = rs2.getString(4);
					String aul = rs2.getString(5);
					s.setAttribute("nameUserLogin",nul );
					s.setAttribute("addressUserLogin",aul );
				}
				return true;
			}
		
	}
	
	public boolean exists(String email, Connection connect) throws SQLException{
		String sql = "select count(*) as count from Account where user_mail=? ";
		
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		
		int count=0;
		if(rs.next()) {
			count=rs.getInt("count");
		}
		if(count==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
