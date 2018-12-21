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
	
	@FindBy(xpath="//*[@id=\"menu-customer\"]/a/i")
	private WebElement Customericon; 
	
	@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[1]/a")
	private WebElement Customerslink;
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/div/table/tbody/tr[4]/td[1]/input")
	private WebElement chkbox; 
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
	private WebElement dltbtn; 
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement successmsg; 
	
	
	@FindBy(xpath="//*[@id=\"form-customer\"]/div")
	private WebElement custTable;
	
		public void clickCustomerIcon() throws InterruptedException {
		Thread.sleep(2000);	
		this.Customericon.click();
	}
	
	public void clickCustomersLink() {
		this.Customerslink.click(); 
		}
	
	public void clickChkBox() {
		List<WebElement> allNames = this.custTable.findElements(By.tagName("tr"));  // identifying rows of Customers table.
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
