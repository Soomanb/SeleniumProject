package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.RTTC055POM;
import com.training.pom.SearchProductInUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC084Test 
{
	
	private WebDriver driver;
	private String baseUrl;
	private String Url;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private RTTC055POM rttc055POM;
	private SearchProductInUserPOM searchprodPOM;
	private static Properties properties;
	private String actualResultmsg1;
	private String expectedResultmsg1 = "Success: You have modified products!\n" + 
			"×";
	private String actualResultmsg2;
	private String expectedResultmsg2 = "MRF BAT";
	
  @Test
  public void CreateProductInAdmin() 
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     // implicit wait
	 
	  // Launch the Admin application and login as admin
baseUrl = properties.getProperty("baseURL");
driver.get(baseUrl);
loginPOM.sendUserName("admin");
loginPOM.sendPassword("admin@123");
loginPOM.clickLoginBtn();
	  
         // add new product
rttc055POM.addNewProduct();
rttc055POM.enterInProductGeneralTab("MRF BAT", "Cricket Bat");
rttc055POM.enterInProductDataTab("SKU-012", "500", "50");
rttc055POM.enterCategoryInProductLinksTab("Sports");
rttc055POM.ClickSave();
actualResultmsg1 = rttc055POM.getSuccessMsg();
assertEquals(actualResultmsg1, expectedResultmsg1);
System.out.println("Product added successfully.");
System.out.println("Expected Result in Admin: " + expectedResultmsg1);
System.out.println("Actual Result in Admin: " + actualResultmsg1);

// logout from admin
logoutPOM.clickLogoutBtn();    
  }
  
  @Test(dependsOnMethods = { "CreateProductInAdmin" })
  public void VerifyProductInUserApp() 
  {
  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);     // implicit wait
		 
	  // Launch the User application
Url = properties.getProperty("URL");
driver.get(Url);

		// Verify Product in the User Application
searchprodPOM.clickOnShopNowIcon();
searchprodPOM.moveCursorToEthnic();
searchprodPOM.clickOnEarrings();
searchprodPOM.clickOnSearchButton();
searchprodPOM.sendSearchKeyword("MRF BAT");
actualResultmsg2 = searchprodPOM.getNameOfSearchedProduct();
assertEquals(actualResultmsg2, expectedResultmsg2);
System.out.println("Product verified successfully.");
System.out.println("Expected Result in User Application: " + expectedResultmsg2);
System.out.println("Actual Result in User Application: " + actualResultmsg2);
	  
  }
  
  @BeforeMethod
  public void setUp() throws Exception {
      // launch browser and open admin URL
driver = DriverFactory.getDriver(DriverNames.CHROME);
loginPOM = new LoginPOM(driver); 
logoutPOM = new LogoutPOM(driver);
rttc055POM = new RTTC055POM(driver);
searchprodPOM = new SearchProductInUserPOM(driver);
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
