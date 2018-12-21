package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class delCustPOM 
{
private WebDriver driver; 
	
	public delCustPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// locate Customer icon
	@FindBy(xpath="//*[@id=\"menu-customer\"]/a/i")
	private WebElement Customericon; 
	
	// locate Customers link after clicking customer icon
	@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[1]/a")
	private WebElement Customerslink;
	
	// locate checkbox of customer
	@FindBy(xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr[4]/td[1]/input")
	private WebElement chkbox; 
	
	// locate red coloured Delete button on top-right of the screen
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
	private WebElement dltbtn; 
	
	// locate the message displayed after deleting customer
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement successmsg; 
	
	// locate the table containing all customer details
	@FindBy(xpath="//*[@id=\"form-customer\"]/div")
	private WebElement custTable;
	
		public void clickCustomerIcon() throws InterruptedException {
		Thread.sleep(2000);	
		this.Customericon.click();
	}
	
	public void clickCustomersLink() {
		this.Customerslink.click(); 
		}
	
	// identifying rows of Customers table
	public void clickChkBox() {
		List<WebElement> allNames = this.custTable.findElements(By.tagName("tr"));  
		System.out.println(allNames.get(2).getText());
		WebElement namedel = allNames.get(2);
		namedel.findElement(By.name("selected[]")).click();
		
	}
	
	public void clickDltBtn() {
		this.dltbtn.click(); 
	}
	
	
	public void handleAlert() {
		this.driver.switchTo().alert().accept();
	}
	
	public String confirmationMsg() {
		return this.successmsg.getText();
	}

}
