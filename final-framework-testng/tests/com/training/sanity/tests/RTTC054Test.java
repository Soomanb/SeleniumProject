package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC053POM;
import com.training.pom.RTTC054POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RTTC054Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC054POM rttc054POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResultmsg;
	private String expectedResultmsg = "Success: You have modified orders!\n" + 
			"×";
	
  @Test
  public void PlaceOrderByAdmin() throws InterruptedException 
  {
	  
	          // Admin places Order
	  rttc054POM.clickSalesIcon();
	  rttc054POM.clickOrdersLink();
	  rttc054POM.clickToAddNewOrder();
	  rttc054POM.sendCustomerDetailsAndClickContinue("manzoor", "mehadi", "manzoor@gmail.com", "9876543210");
	  rttc054POM.sendProductDetailsAndClickContinue("Nullam sodales in purus vel auctor");
	  rttc054POM.sendPaymentDetailsAndClickContinue("manzoor", "mehadi", "yeshwanthapur", "bangalore", "bangalore", "560022", "India", "Karnataka");
	  rttc054POM.sendShippingDetailsAndClickContinue("manzoor", "mehadi", "yeshwanthapur", "bangalore", "bangalore", "560022", "India", "Karnataka");
	  rttc054POM.sendShippingAndPaymentMethod("Cash On Delivery");
	  rttc054POM.clickSaveButton();	    
	  Thread.sleep(3000);
	  
	  actualResultmsg = rttc054POM.getConfirmationMsg();
	  assertEquals(actualResultmsg, expectedResultmsg);
	  screenShot.captureScreenShot();
	  System.out.println("Order placed by Admin successfully.");
	  System.out.println("Expected Result: " + expectedResultmsg);
	  System.out.println("Actual Result: " + actualResultmsg);
	  logoutPOM.clickLogoutBtn(); 
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc054POM = new RTTC054POM(driver);
screenShot = new ScreenShot(driver);
baseUrl = properties.getProperty("baseURL");

      // open the browser and login as admin
driver.get(baseUrl);
loginPOM.sendUserName("admin");
loginPOM.sendPassword("admin@123");
loginPOM.clickLoginBtn();
Thread.sleep(4000);
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
