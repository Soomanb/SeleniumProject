/* To verify whether application allows admin to return product of customer & delete from return list 
& same get displayed in DataBase  */

package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.dao.RetailDAO;
import com.training.pom.CustReturnProductPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC081Test
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private CustReturnProductPOM returnsPOM;
	private RetailDAO retaildao;
	private static Properties properties;
	private String actualResult;
		
	
  @Test
  public void CustomerReturnsByAdminDB() {
	    
	  // clicking on Sales icon and navigating to Returns link has been done in @BeforeClass
	  
	  returnsPOM.clickAddNewButton();   // click on Add button
	  returnsPOM.sendOrderID("90");  // enter order id 
	  returnsPOM.sendCustomer("sooman"); // enter customer 
	  returnsPOM.sendFirstname("sooman");  // enter firstname 
	  returnsPOM.sendLastname("bose");   // enter lastname 
	  returnsPOM.sendEmail("sbose@abc.com");		// enter email id 
	  returnsPOM.sendTelephone("9876543210");		// enter telephone number 
	  returnsPOM.sendProduct("Integer vitae iaculis massa");		// enter Product 
	  returnsPOM.sendModel("SKU-003");		// enter Model 
	  
	  //get the actual result from application by concatenating the values from the textboxes
	  actualResult=returnsPOM.getOrderID() + returnsPOM.getCustomer() + returnsPOM.getFirstName() + returnsPOM.getLastName() + returnsPOM.getEmail() + returnsPOM.getTelephone() + returnsPOM.getProduct() + returnsPOM.getModel();
	  
	  returnsPOM.ClickOnSave();		// click Save
	  returnsPOM.ClickCheckBox();     // check the checkbox for the lastest customer added
	  returnsPOM.ClickDeleteButton();   // click Delete button
	  returnsPOM.AcceptAlert();        // Click OK button in the alert
	  String expectedString = retaildao.ListToStringUsers();  // fetch the String format of the User details List
	  assertEquals(actualResult, expectedString); 
	  System.out.println("Expected Result: " + expectedString);
	  System.out.println("Actual Result: " + actualResult);
	  
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
  
  @BeforeClass
  public void beforeTest() throws InterruptedException 
  {
	// launch browser and open admin URL
	  driver = DriverFactory.getDriver(DriverNames.CHROME);
	  loginPOM = new LoginPOM(driver); 
	  logoutPOM = new LogoutPOM(driver);
	  returnsPOM = new CustReturnProductPOM(driver);
	  retaildao = new RetailDAO();
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

}
