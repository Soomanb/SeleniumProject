package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC053POM;
import com.training.pom.RTTC055POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RTTC055Test 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC055POM rttc055POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResultmsg1;
	private String expectedResultmsg1 = "Success: You have modified manufacturers!\n" + 
			"×";
	private String actualResultmsg2;
	private String expectedResultmsg2 = "Success: You have modified products!\n" + 
			"×";
	
  @Test
  public void CreateNewProduct()
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	             // add new manufacturer
	  rttc055POM.clickOnCatalogIcon();
	  rttc055POM.clickOnManufacturersLink();
	  rttc055POM.clickToAddNewManufacturer();
	  rttc055POM.sendNewManufacturerName("manzoor");
	  actualResultmsg1 = rttc055POM.getSuccessMsg();
	  assertEquals(actualResultmsg1, expectedResultmsg1);
	  screenShot.captureScreenShot();
	  System.out.println("Manufacturer added successfully.");
	  System.out.println("Expected Result: " + expectedResultmsg1);
	  System.out.println("Actual Result: " + actualResultmsg1);
	  
	                // add new product
	  rttc055POM.addNewProduct();
	  rttc055POM.enterInProductGeneralTab("Finger Ring", "Finger Ring for ladies");
	  rttc055POM.enterInProductDataTab("SKU-012", "500", "50");
	  rttc055POM.enterInProductLinksTab("manzoor", "EARRINGS");
	  rttc055POM.ClickSave();
	  actualResultmsg2 = rttc055POM.getSuccessMsg();
	  assertEquals(actualResultmsg2, expectedResultmsg2);
	  screenShot.captureScreenShot();
	  System.out.println("Product added successfully.");
	  System.out.println("Expected Result: " + expectedResultmsg2);
	  System.out.println("Actual Result: " + actualResultmsg2);
	  
	  // logout from admin
	  logoutPOM.clickLogoutBtn();  
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc055POM = new RTTC055POM(driver);
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
