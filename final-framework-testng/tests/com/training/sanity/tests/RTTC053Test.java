// To verify whether application allows admin to generate invoice & change Order Status to complete for the order

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	private String actualResultmsg;
	private String expectedResultmsg = "Success: You have modified orders!\n" + 
			"×";
	
  @Test
  public void AddHistoryToOrder() throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   // implicit wait
	  try {
		  rttc053POM.clickViewButtonforOrder();  // click View button from Latest Orders table. 
		  rttc053POM.clickGenerateIcon();  // click on Generate icon
		  System.out.println("Invoice Number is: " + rttc053POM.getInvoiceNumber());  // print the invoice number generated. 
		  rttc053POM.selectOrderStatus("Complete"); // select "Complete" from Order status dropdown.
		  rttc053POM.clickAddHistoryButton();
		  actualResultmsg = rttc053POM.getSuccessMsg();
	  }
	  catch(Exception e) {
		  driver.findElement(By.id("button-ip-add")).click();  // click on AddAPI Button to handle exception
	  }
	   
	  assertEquals(actualResultmsg, expectedResultmsg);
	  System.out.println("Status of Order added successfully.");
	  System.out.println("Expected Result: " + expectedResultmsg);
	  System.out.println("Actual Result: " + actualResultmsg);
	    
  } 
  
  
  @BeforeClass
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc053POM = new RTTC053POM(driver);
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
