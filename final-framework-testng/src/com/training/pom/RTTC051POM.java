package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC051POM
{

private WebDriver driver; 
	
	public RTTC051POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Web Elements
	
	// locate Customer icon
		@FindBy(xpath="//*[@id=\"menu-customer\"]/a/i")
		private WebElement Customericon; 
		
		// locate Customers link after clicking customer icon
		@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[1]/a")
		private WebElement Customerslink;
	
		// locate Customers Group link after clicking customer icon
	@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[2]/a")
	private WebElement custgrplink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")  // locator for AddNew button is same everywhere.
	private WebElement addnewbtn; 
	
	@FindBy(name="customer_group_description[1][name]")
	private WebElement custgrpname; // customer group name
	
	@FindBy(name="customer_group_description[1][description]")
	private WebElement custgrpdesc; // customer group description 
	
	@FindBy(name="approval")
	private List<WebElement> custgrpapprv; //  radio button for Approval 
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
	private WebElement savebtn;	   // locator for Save button is same everywhere.
	
	//Methods
	
	public void clickCustomerIcon() throws InterruptedException {
		Thread.sleep(2000);	
		this.Customericon.click();
	}
	
	public void clickCustomerGroupsLink() {	
		this.custgrplink.click();
	}
	
	public void clickCustomersLink() {	
		this.Customerslink.click();
	}
	
	public void ClickAddNew() {	
		this.addnewbtn.click();
	}
		
	public void sendCustomerGrpName(String CustomerGroupName) {
		this.custgrpname.clear();
		this.custgrpname.sendKeys(CustomerGroupName);
	}
	
	public void sendCustomerGrpDescription(String CustomerGroupDesc) {
		this.custgrpdesc.clear(); 
		this.custgrpdesc.sendKeys(CustomerGroupDesc); 
	}
	
	public void ApproveNewCust() {
			this.custgrpapprv.get(0).click();
	}
	
	public void ClickSave() {
		this.savebtn.click();
    }
	
	// enter details of Customer in General tab
	public void sendCustomerGeneraldetails(String custgrp, String fname, String lname, String mail, String phn, String pswrd) {
		Select CustGroup = new Select(driver.findElement(By.id("input-customer-group")));
		CustGroup.selectByVisibleText(custgrp);
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-lastname")).sendKeys(lname);
		driver.findElement(By.id("input-email")).sendKeys(mail);
		driver.findElement(By.id("input-telephone")).sendKeys(phn);
		driver.findElement(By.id("input-password")).sendKeys(pswrd);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(pswrd);

}
	
	// get the value of firstname textbox
	public String getFirstName() {
		return driver.findElement(By.id("input-firstname")).getAttribute("value");
		}
	
	// get the value of lastname textbox
	public String getlastName() {
		return driver.findElement(By.id("input-lastname")).getAttribute("value");
	}
	
	public void ClickOnAddressTab() {
		driver.findElement(By.xpath("//*[@id=\"address-add\"]/a")).click();
    }
	
	// enter details of Customer in Address tab
	public void sendCustomerAddressdetails(String addr1, String addr2, String city, String zip, String country, String state) {
		driver.findElement(By.id("input-firstname1")).sendKeys(getFirstName());
		driver.findElement(By.id("input-lastname1")).sendKeys(getlastName());
		driver.findElement(By.id("input-address-11")).sendKeys(addr1);
		driver.findElement(By.id("input-address-21")).sendKeys(addr2);
		driver.findElement(By.id("input-city1")).sendKeys(city);
		driver.findElement(By.id("input-postcode1")).sendKeys(zip);
		Select cntry = new Select(driver.findElement(By.id("input-country1")));
		cntry.selectByVisibleText(country);
		Select stt = new Select(driver.findElement(By.id("input-zone1")));
		stt.selectByVisibleText(state);
	}
	
	// get the text of the message displayed after successfully creating customer
	public String confirmationMsg() {
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]")).getText();
	}
	
	
	}
	

