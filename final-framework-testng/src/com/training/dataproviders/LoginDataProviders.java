package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.RetailDAO;
import com.training.readexcel.ApachePOIExcelRead;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new RetailDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName = "C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\SeleniumProject\\Testing.xlsx";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName);
		System.out.println("size " + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[2]; 
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));

			obj[0] = temp.get(0); 
     		obj[1] = temp.get(1); 
			
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
	
	//Data Provider for RTTC082Test
	
	@DataProvider(name = "excel-Customer-Return-inputs-positive")
	public Object[][] getExceldata(){
		String fileName = "./resources/TestData82.xlsx";

		List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName);
		System.out.println("size " + retVal.size());
		
		Object[][] result = new Object[retVal.size()][retVal.size()]; 
		int count = 0; 

		for(List<Object> temp : retVal){
			if(temp!=null){
			Object[]  obj = new Object[8]; 
			
			System.out.println(temp.get(0));
			System.out.println(temp.get(1));
			System.out.println(temp.get(2));
			System.out.println(temp.get(3));
			System.out.println(temp.get(4));
			System.out.println(temp.get(5));
			System.out.println(temp.get(6));
			System.out.println(temp.get(7));
						
     		obj[0] = temp.get(0);
     		obj[1] = temp.get(1);
     		obj[2] = temp.get(2);
     		obj[3] = temp.get(3);
     		obj[4] = temp.get(4);
     		obj[5] = temp.get(5);
     		obj[6] = temp.get(6);
     		obj[7] = temp.get(7);

     					
			result[count ++] = obj; 
			}
		}
		
		return result; 
	}
	
	//Data Provider for RTTC083Test
	
		@DataProvider(name = "excel-Customer-Return-inputs-negative")
		public Object[][] getExceldataInvalid(){
			String fileName = "./resources/TestData83.xlsx";

			List<List<Object>> retVal = ApachePOIExcelRead.getExcelContent(fileName);
			System.out.println("size " + retVal.size());
			
			Object[][] result = new Object[retVal.size()][retVal.size()]; 
			int count = 0; 

			for(List<Object> temp : retVal){
				if(temp!=null){
				Object[]  obj = new Object[8]; 
				
				System.out.println(temp.get(0));
				System.out.println(temp.get(1));
				System.out.println(temp.get(2));
				System.out.println(temp.get(3));
				System.out.println(temp.get(4));
				System.out.println(temp.get(5));
				System.out.println(temp.get(6));
				System.out.println(temp.get(7));
							
	     		obj[0] = temp.get(0);
	     		obj[1] = temp.get(1);
	     		obj[2] = temp.get(2);
	     		obj[3] = temp.get(3);
	     		obj[4] = temp.get(4);
	     		obj[5] = temp.get(5);
	     		obj[6] = temp.get(6);
	     		obj[7] = temp.get(7);

	     					
				result[count ++] = obj; 
				}
			}
			
			return result; 
		}
	
}
