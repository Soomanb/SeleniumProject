package com.training.pom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC054POM 
{

private WebDriver driver; 
	
	public RTTC054POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
			@FindBy(xpath="//*[@id=\"menu-sale\"]/a/i")
			private WebElement salesicon;   //locate Sales icon
			
			@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
			private WebElement orderslink;  // locate orders link
			
			@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")  // locator for AddNew button is same everywhere.
			private WebElement addnewbtn;
			
			// Customer details
			
			@FindBy(id="input-firstname")
			private WebElement fname;  // locate First name text box
			
			@FindBy(id="input-lastname")
			private WebElement lname;  // locate Last name text box
						
			@FindBy(id="input-email")
			private WebElement mail;  // locate E-mail text box
			
			@FindBy(id="input-telephone")
			private WebElement phn;  // locate telephone text box
			
			@FindBy(id="button-customer")
			private WebElement continue1;  // locate Continue button on Customer details tab
			
			// Products tab
			
			@FindBy(id="input-product")
			private WebElement prodname;  // locate Choose Product textbox on Products tab
			
			@FindBy(id="input-quantity")
			private WebElement qnty;  // locate Quantity textbox on Products tab
			
			@FindBy(id="button-product-add")
			private WebElement addprodbtn;  // locate Add Product button on Products tab
			
			@FindBy(id="button-cart")
			private WebElement continue2;  // locate Continue button on Products tab
			
			// Payment details tab
			
			@FindBy(id="input-payment-firstname")
			private WebElement payfirstname;  // locate First name text box in Payment details
			
			@FindBy(id="input-payment-lastname")
			private WebElement paylastname;  // locate Last name text box in Payment details
			
			@FindBy(id="input-payment-address-1")
			private WebElement payaddr1;  // locate Address1 text box in Payment details
			
			@FindBy(id="input-payment-address-2")
			private WebElement payaddr2;  // locate Address2 text box in Payment details
			
			@FindBy(id="input-payment-city")
			private WebElement paycity;  // locate city text box in Payment details
			
			@FindBy(id="input-payment-postcode")
			private WebElement payzip;  // locate postcode text box in Payment details
			
			@FindBy(id="input-payment-country")
			private WebElement paycountry;  // locate country dropdown in Payment details
			
			@FindBy(id="input-payment-zone")
			private WebElement paystate;  // locate state dropdown in Payment details
			
			@FindBy(id="button-payment-address")
			private WebElement continue3;  // locate Continue button on Payment details tab
			
			
			// Shipping details tab
			
						@FindBy(id="input-shipping-firstname")
						private WebElement shipfirstname;  // locate First name text box in shipping details
						
						@FindBy(id="input-shipping-lastname")
						private WebElement shiplastname;  // locate Last name text box in shipping details
						
						@FindBy(id="input-shipping-address-1")
						private WebElement shipaddr1;  // locate Address1 text box in shipping details
						
						@FindBy(id="input-shipping-address-2")
						private WebElement shipaddr2;  // locate Address2 text box in shipping details
						
						@FindBy(id="input-shipping-city")
						private WebElement shipcity;  // locate city text box in shipping details
						
						@FindBy(id="input-shipping-postcode")
						private WebElement shipzip;  // locate postcode text box in shipping details
						
						@FindBy(id="input-shipping-country")
						private WebElement shipcountry;  // locate country dropdown in shipping details
						
						@FindBy(id="input-shipping-zone")
						private WebElement shipstate;  // locate state dropdown in shipping details
			 
						@FindBy(id="button-shipping-address")
			            private WebElement continue4;  // locate Continue button on Shipping details tab
			
						
		// Totals tab
						
						@FindBy(id="input-shipping-method")
						private WebElement shipmethod;  // locate shipping method dropdown in Totals tab
						
						@FindBy(id="input-payment-method")
						private WebElement paymethod;  // locate payment method dropdown in Totals tab
						
						@FindBy(id="button-save")
						private WebElement savebtn;  // locate Save Button in Totals tab
						
						@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
						private WebElement confirmmsg;  // locate confirmation message: "Success: You have modified orders!"		
		
			// Methods
						
						public void clickSalesIcon() {
							this.salesicon.click();
						}
						
						public void clickOrdersLink() {
							this.orderslink.click();
						}
						
						public void clickToAddNewOrder() {
							this.addnewbtn.click();
						}
						
						public void sendCustomerDetailsAndClickContinue(String Firstname, String Lastname, String Email, String Telephone) {
							this.fname.sendKeys(Firstname);
							this.lname.sendKeys(Lastname);
							this.mail.sendKeys(Email);
							this.phn.sendKeys(Telephone);
							this.continue1.click();
						}
						
						public void sendProductDetailsAndClickContinue(String productname) throws InterruptedException {
							this.prodname.clear();    // clear the Choose Product textbox 
							this.prodname.click();            // click on the Choose Product textbox 
							this.prodname.sendKeys(productname);   // enter Productname in the Choose Product textbox 
							driver.findElement(By.linkText(productname)).click();  // click on the auto-generated option link
							Thread.sleep(2000);
							this.addprodbtn.click();
							Thread.sleep(2000);
							this.continue2.click();
						}
						
						public void sendPaymentDetailsAndClickContinue(String Payfname, String Paylname, String Address1, String Address2, String City, String Postcode, String Country, String State) {
							this.payfirstname.sendKeys(Payfname);
							this.paylastname.sendKeys(Paylname);
							this.payaddr1.sendKeys(Address1);
							this.payaddr2.sendKeys(Address2);
							this.paycity.sendKeys(City);
							this.payzip.sendKeys(Postcode);
							Select cntry = new Select(this.paycountry);
							cntry.selectByVisibleText(Country);
							Select stt = new Select(this.paystate);
							stt.selectByVisibleText(State);
							this.continue3.click();
						}
						
						public void sendShippingDetailsAndClickContinue(String Shipfname, String Shiplname, String SAddress1, String SAddress2, String SCity, String SPostcode, String SCountry, String SState) {
							this.shipfirstname.sendKeys(Shipfname);
							this.shiplastname.sendKeys(Shiplname);
							this.shipaddr1.sendKeys(SAddress1);
							this.shipaddr2.sendKeys(SAddress2);
							this.shipcity.sendKeys(SCity);
							this.shipzip.sendKeys(SPostcode);
							Select scntry = new Select(this.shipcountry);
							scntry.selectByVisibleText(SCountry);
							Select sstt = new Select(this.shipstate);
							sstt.selectByVisibleText(SState);
							this.continue4.click();
						}
						
						public void sendShippingAndPaymentMethod(String paymentmethod) {
							Select Shippingmethod = new Select(this.shipmethod);
							Shippingmethod.selectByVisibleText("Free Shipping - Rs.0");
							Select Paymentmethod = new Select(this.paymethod);
							Paymentmethod.selectByVisibleText(paymentmethod);
							
						}
						
						public void clickSaveButton() throws InterruptedException {
							this.savebtn.click();
							Thread.sleep(2000);
						}
						
						public String getConfirmationMsg() {
							return this.confirmmsg.getText();
						}
						
}

