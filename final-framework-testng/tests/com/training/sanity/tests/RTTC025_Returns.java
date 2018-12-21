package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AllSalesPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RTTC025_Returns 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private AllSalesPOM returnsPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private int actualResult;
	private int expectedResult = 1;
  @Test
  public void TotalReturns() throws InterruptedException 
  {
	  returnsPOM.clickReports();
	  returnsPOM.clickSales();
	  Thread.sleep(3000);
	  returnsPOM.clickReturnslink();
	  returnsPOM.selectfromGroupbylist();
	  returnsPOM.clickFilterButton();
	  Thread.sleep(3000);
	  actualResult = returnsPOM.numberOfRows();
	  assertEquals((actualResult-1), expectedResult);  //actualresult-1 -> to exclude the heading row.
	  screenShot.captureScreenShot();
	  System.out.println("Numbers of returns for orders made is verified successfully.");
	  System.out.println("Expected Result: " + expectedResult);
	  System.out.println("Actual Result: " + (actualResult-1));
	  logoutPOM.clickLogoutBtn();
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
	                  // launch browser and open admin URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		logoutPOM = new LogoutPOM(driver);
		returnsPOM = new AllSalesPOM(driver);
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
