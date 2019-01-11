package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.CustReturnProductPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class RTTC083Test {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private CustReturnProductPOM returnsPOM;
	private static Properties properties;
	private String actualResult;
	
	 private String expectedResult = "Warning: Please check the form carefully for errors!\n" + 
			"×";	
	
	
	// fetch the data from the specified excel sheet
  @Test(dataProvider = "excel-Customer-Return-inputs-negative", dataProviderClass = LoginDataProviders.class)
  public void CustomerReturnsByAdminNegatv(String Orderid, String Customer, String fname, String lname, String Email, String Telphn, String Product, String Model) {
	  
	// clicking on Sales icon and navigating to Returns link has been done in @BeforeClass
	  
		  returnsPOM.clickAddNewButton();   // click on Add button
		  returnsPOM.sendOrderID(Orderid);  // enter order id from excel sheet
		  returnsPOM.sendCustomer(Customer); // enter customer from excel sheet
		  returnsPOM.sendFirstname(fname);  // enter firstname from excel sheet
		  returnsPOM.sendLastname(lname);   // enter lastname from excel sheet
		  returnsPOM.sendEmail(Email);		// enter email id from excel sheet
		  returnsPOM.sendTelephone(Telphn);		// enter telephone number from excel sheet
		  returnsPOM.sendProduct(Product);		// enter Product from excel sheet
		  returnsPOM.sendModel(Model);		// enter Model from excel sheet
		  returnsPOM.ClickOnSave();		// click Save
		  actualResult = returnsPOM.GetErrorMsg(); 
		  returnsPOM.ClickCancelButton();
		  
		  assertEquals(actualResult, expectedResult);   // to verify the confirmation message text
		  
  }
  
  @BeforeClass
  public void beforeTest() throws InterruptedException 
  {
	// launch browser and open admin URL
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
	  loginPOM = new LoginPOM(driver); 
	  logoutPOM = new LogoutPOM(driver);
	  returnsPOM = new CustReturnProductPOM(driver);
	  baseUrl = properties.getProperty("baseURL");
	  
	       // open the browser and login as admin
	  driver.get(baseUrl);
	  loginPOM.sendUserName("admin");
	  loginPOM.sendPassword("admin@123");
	  loginPOM.clickLoginBtn();
	  Thread.sleep(2000);
	  
	  // below two methods are invoked under BeforeClass annotation in order to avoid clicking on Sales icon and going to Returns link everytime a new customer is added
	  returnsPOM.clickSalesicon();
	  returnsPOM.clickReturnslink();
  }

  @BeforeTest
  public void setUpBeforeTest() throws IOException
  {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);  
  }

  @AfterTest
  public void closeBrowser() 
  {
	  logoutPOM.clickLogoutBtn();  // logout from application once all the customers are added and deleted successfully
	  driver.quit();
  }

}
