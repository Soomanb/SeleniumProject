package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC052POM 
{

private WebDriver driver; 
	
	public RTTC052POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// locator for table is same everywhere
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div[2]")
	private WebElement table;  
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement successmsg;  // locate the message displayed after modifying customer
	
	// click on the edit button against a specific customer
	public void ClickEditCustomer() {
      driver.findElement(By.xpath("//*[@id=\"form-customer\"]/div/table/tbody/tr[12]/td[8]/a/i")).click();
	}
	
	public void ChangeFirstname(String fname) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		}
	
	public void clickAddresstab() {
		driver.findElement(By.xpath("//*[@id=\"address\"]/li[2]/a")).click();
	}
	
	public void ChangeCustAddress(String postcode) {
		driver.findElement(By.id("input-postcode1")).clear();
		driver.findElement(By.id("input-postcode1")).sendKeys(postcode);
		}
	
	public void sendRewardPoints(String rewarddesc, String points) {
		driver.findElement(By.xpath("//*[@id=\"form-customer\"]/ul/li[4]/a")).click(); // click Reward Points tab
		driver.findElement(By.id("input-reward-description")).sendKeys(rewarddesc); // enter reward description
		driver.findElement(By.id("input-points")).sendKeys(points);   // enter reward points to be given to the customer
		driver.findElement(By.id("button-reward")).click();  // click Add Reward Points
		}
	
	public String getSuccessMsg() {
		return this.successmsg.getText();  // get text of the success message displayed.
	}
	
	
	public void clickOnRewardPointsReport( ) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/a/i")).click();  // click on Reports icon
		driver.findElement(By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/a")).click();	// click on Customers link	
	driver.findElement(By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/ul/li[5]/a")).click();  //click on Reward points link
	Thread.sleep(3000);
	}
	
	//verify the number of rows in the Reward points table
	public int CheckRewardPointsRow() {		
		List<WebElement> allRewards = this.table.findElements(By.tagName("tr"));
		return allRewards.size();	
		}
}
