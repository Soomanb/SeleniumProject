package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC053POM 
{

private WebDriver driver; 
	
	public RTTC053POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[3]/div[2]/div/div[2]/table/tbody/tr[5]/td[6]/a/i")
	private WebElement viewbtn;   //locate View Button of the order to be viewed.
	
	@FindBy(xpath="//*[@id=\"button-invoice\"]/i")
	private WebElement generateicon;  // locate Generate icon to generate Invoice number.
	
	@FindBy(id="input-order-status")
	private WebElement orderstatus;  // Locate Order status combo box 
	
	@FindBy(id="button-history")
	private WebElement addhistorybtn;  // locate Add History button
	
	@FindBy(xpath="//*[@id=\"tab-history\"]/div[1]")
	private WebElement successmsg;  // locate the message displayed after modifying order
	
	
	// Methods
	
	public void clickViewButtonforOrder() {
		this.viewbtn.click();  // click on View Button of the order to be viewed.
	}
	
	public void clickGenerateIcon() throws InterruptedException {
		this.generateicon.click();  // click on Generate icon to generate Invoice number.
		Thread.sleep(2000);
	}
	
	public String getInvoiceNumber() {
		return driver.findElement(By.id("invoice")).getText();  // get the invoice number generated
	}
	
	public void selectOrderStatus(String status) {
		Select OrdSts = new Select(this.orderstatus);
		OrdSts.selectByVisibleText(status);   // select from Order Status dropdown depending on VisibleText input 
	}
	
	public void clickAddHistoryButton() throws InterruptedException {
		this.addhistorybtn.click();  // click Add History Button
		Thread.sleep(5000);
	}
	
	public String getSuccessMsg() {
		return this.successmsg.getText();  // get text of the success message displayed.
	}
}
