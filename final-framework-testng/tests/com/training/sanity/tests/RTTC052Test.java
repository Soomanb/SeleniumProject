// To verify whether application allows admin to add reward points to the customer & view reward points in Reports section

package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllSalesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC051POM;
import com.training.pom.RTTC052POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RTTC052Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC051POM rttc051POM;
	private RTTC052POM rttc052POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResultmsg;
	private String expectedResultmsg = "Success: You have modified customers!\n" + 
			"×";
	
  @Test
  public void GiveRewardPointstoCustomer() throws InterruptedException
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
	  
	  // Customers link is accessed using RTTC051POM class
	  rttc051POM.clickCustomerIcon();
	  rttc051POM.clickCustomersLink();
	  
	  rttc052POM.ClickEditCustomer();  // click on edit button against a customer
	  rttc052POM.ChangeFirstname("Ashimita");  //modify first name
	  rttc052POM.clickAddresstab();            // go to Address tab 
	  rttc052POM.ChangeCustAddress("8789545");  // modify postcode
	  rttc052POM.sendRewardPoints("reviewing", "60"); // go to Reward points tab and enter description and points
	  rttc051POM.ClickSave();                      // Save Button is again accessed using RTTC051POM class
	  actualResultmsg = rttc052POM.getSuccessMsg();
	 
	  assertEquals(actualResultmsg, expectedResultmsg);
	  
	  rttc052POM.clickOnRewardPointsReport();    // get Customer Reward points report   
	 // screenShot.captureScreenShot();
	  System.out.println("Numbers of customers rewarded with points is verified successfully.");
	  logoutPOM.clickLogoutBtn();
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc051POM = new RTTC051POM(driver);
rttc052POM = new RTTC052POM(driver);
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
	//	driver.quit();
	}

  @BeforeClass
  public void setUpBeforeClass() throws IOException
  {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);  
  }

 
}
