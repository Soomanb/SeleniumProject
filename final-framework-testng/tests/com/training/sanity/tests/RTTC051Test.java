package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllSalesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC051POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RTTC051Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC051POM rttc051POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Success: You have modified customers!\n" + 
			"×";
	
  @Test
  public void CreateNewCustGrp() throws InterruptedException 
  {
	                // create new customer group
	  rttc051POM.clickCustomerIcon();
	  rttc051POM.clickCustomerGroupsLink();
	  rttc051POM.ClickAddNew();
	  rttc051POM.sendCustomerGrpName("privileged customerSB");
	  rttc051POM.sendCustomerGrpDescription("privileged customerSB");
	  rttc051POM.ApproveNewCust();
	  rttc051POM.ClickSave();
	  screenShot.captureScreenShot();
	  System.out.println("New Customer Group created successfully.");
	  Thread.sleep(5000);
	                 // create new customer
	  rttc051POM.clickCustomerIcon();
	  rttc051POM.clickCustomersLink();
	  
	  // add new customer and enter details in General tab
	  rttc051POM.ClickAddNew();
	  rttc051POM.sendCustomerGeneraldetails("privileged customerSB","manzoor", "mehadi", "manzoorSB@gmail.com", "9876543210", "manzoor1");
	  
	  // go to Address tab and add details there
	  rttc051POM.ClickOnAddressTab();
	  rttc051POM.sendCustomerAddressdetails("yeshwanthapur", "bangalore", "bangalore", "560022", "India", "Karnataka");
	  
	  rttc051POM.ClickSave();
	  Thread.sleep(3000);
	  actualResult = rttc051POM.confirmationMsg();
	  assertEquals(actualResult, expectedResult);  
	  screenShot.captureScreenShot();
	  System.out.println("New Customer created successfully.");
	  System.out.println("Expected Result: " + expectedResult);
	  System.out.println("Actual Result: " + actualResult);
	  logoutPOM.clickLogoutBtn();
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc051POM = new RTTC051POM(driver);
screenShot = new ScreenShot(driver);
baseUrl = properties.getProperty("baseURL");

      // open the browser and login as admin
driver.get(baseUrl);
loginPOM.sendUserName("admin");
loginPOM.sendPassword("admin@123");
loginPOM.clickLoginBtn();
Thread.sleep(5000);
  }

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

  @BeforeClass
  public void setUpBeforeClass() throws IOException
  {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);  
  }

  
}
