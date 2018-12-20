package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.delCustPOM;
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

public class RTTC021_deleteCustomer 
{
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private delCustPOM DelCusPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualResult;
	private String expectedResult = "Success: You have modified customers!\n" + 
			"×";
	
	@BeforeClass
	  public void setUpBeforeClass() throws IOException
	  {
		  properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);  
	  }
	
	@BeforeMethod
	  public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver); 
			DelCusPOM = new delCustPOM(driver);
			screenShot = new ScreenShot(driver);
			baseUrl = properties.getProperty("baseURL");
			// open the browser 
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
	  	  
  @Test
  public void CustomerDelete() throws InterruptedException 
  {
	  DelCusPOM.clickCustomerIcon();
	  DelCusPOM.clickCustomersLink();
	  Thread.sleep(2000);
	  DelCusPOM.clickChkBox();
	  screenShot.captureScreenShot();
	  DelCusPOM.clickDltBtn();
	  DelCusPOM.handleAlert();
	  Thread.sleep(2000);
	  actualResult = DelCusPOM.confirmationMsg();
	  assertEquals(actualResult, expectedResult);
	  screenShot.captureScreenShot();
	  System.out.println("Customer is successfully deleted");
	
  }
    

 }
