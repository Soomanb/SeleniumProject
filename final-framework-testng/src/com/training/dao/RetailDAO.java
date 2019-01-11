package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.UserBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class RetailDAO {
	
	Properties properties; 
	
	public RetailDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<LoginBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean temp = new LoginBean(); 
				temp.setUserName(gc.rs1.getString(1));
				temp.setPassword(gc.rs1.getString(2));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public List<UserBean> getUsers(){
		String sql = properties.getProperty("get.users"); 
		
		GetConnection gc  = new GetConnection(); 
		List<UserBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<UserBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				UserBean temp = new UserBean(); 
				temp.setOrderID(gc.rs1.getString(1));
				temp.setCustomer(gc.rs1.getString(2));
				temp.setFirstName(gc.rs1.getString(3));
				temp.setLastName(gc.rs1.getString(4));
				temp.setEmailID(gc.rs1.getString(5));
				temp.setPhone(gc.rs1.getString(6));
				temp.setProduct(gc.rs1.getString(7));
				temp.setModel(gc.rs1.getString(8));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
		
	}
	
	// to convert the List to String format
	public String ListToStringUsers() {
		String listString = "";

		for (UserBean s : this.getUsers())
		{
		    listString += s;
		}
		return listString;
	}
	
	
	public static void main(String[] args) {
		new RetailDAO().getLogins().forEach(System.out :: println);
		new RetailDAO().getUsers().forEach(System.out :: println);
		
	}
	
	
}
