package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC051POM;
import com.training.pom.RTTC052POM;
import com.training.pom.RTTC053POM;
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

public class RTTC053Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC053POM rttc053POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResultmsg;
	private String expectedResultmsg = "Success: You have modified orders!\n" + 
			"×";
	
  @Test
  public void AddHistoryToOrder() throws InterruptedException 
  {
	  rttc053POM.clickViewButtonforOrder();  // click View button from Latest Orders table.
	  rttc053POM.clickGenerateIcon();  // click on Generate icon
	  Thread.sleep(2000);
	  System.out.println("Invoice Number is: " + rttc053POM.getInvoiceNumber());  // print the invoice number generated.
	  screenShot.captureScreenShot();
	  
	  rttc053POM.selectOrderStatus("Complete"); // select "Complete" from Order status dropdown.
	  rttc053POM.clickAddHistoryButton();
      Thread.sleep(3000);
	  actualResultmsg = rttc053POM.getSuccessMsg(); 
	  Thread.sleep(2000);
	  assertEquals(actualResultmsg, expectedResultmsg);
	  screenShot.captureScreenShot();
	  System.out.println("Status of Order added successfully.");
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
rttc053POM = new RTTC053POM(driver);
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
