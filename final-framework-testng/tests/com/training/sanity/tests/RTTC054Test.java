// To verify whether application allows admin to place an order for customer

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
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class RTTC054Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC054POM rttc054POM;
	private static Properties properties;
	private String actualResultmsg;
	private String expectedResultmsg = "Success: You have modified orders!\n" + 
			"�";
	  
  @Test
  public void PlaceOrderByAdmin() throws InterruptedException 
  {
	          // Admin places Order
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
	  
	  try {
		  rttc054POM.clickSalesIcon();
		  rttc054POM.clickOrdersLink();
		  rttc054POM.clickToAddNewOrder();
		  rttc054POM.sendCustomerDetailsAndClickContinue("manzoor54", "mehadi", "manzoor54@gmail.com", "9876543211");
		  rttc054POM.sendProductDetailsAndClickContinue("Nullam sodales in purus vel auctor");
		  rttc054POM.sendPaymentDetailsAndClickContinue("manzoor54", "mehadi", "yeshwanthapur", "bangalore", "bangalore", "560022", "India", "Karnataka");
		  rttc054POM.sendShippingDetailsAndClickContinue("manzoor54", "mehadi", "yeshwanthapur", "bangalore", "bangalore", "560022", "India", "Karnataka");
		  rttc054POM.sendShippingAndPaymentMethod("Cash On Delivery");
		  rttc054POM.clickSaveButton();	   
	  }
	   catch(Exception e) {
			  driver.findElement(By.id("button-ip-add")).click();  // click on AddAPI Button to handle exception
	   }
	  	  
	  actualResultmsg = rttc054POM.getConfirmationMsg();
	  assertEquals(actualResultmsg, expectedResultmsg);
	  System.out.println("Order placed by Admin successfully.");
	  System.out.println("Expected Result: " + expectedResultmsg);
	  System.out.println("Actual Result: " + actualResultmsg);
	  
  }
  
  @BeforeClass
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc054POM = new RTTC054POM(driver);
baseUrl = properties.getProperty("baseURL");

      // open the browser and login as admin
driver.get(baseUrl);
loginPOM.sendUserName("admin");
loginPOM.sendPassword("admin@123");
loginPOM.clickLoginBtn();
Thread.sleep(4000);
  }

  @AfterTest
  public void tearDown() throws Exception {
		Thread.sleep(2000);
		logoutPOM.clickLogoutBtn(); 
		 driver.quit();
	}

  @BeforeTest
  public void setUpBeforeClass() throws IOException
  {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);  
  }

}
