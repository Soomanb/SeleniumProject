package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustReturnProductPOM 
{

private WebDriver driver; 
	
	public CustReturnProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// locate Sales icon
		@FindBy(xpath="//*[@id=\"menu-sale\"]/a/i")
		private WebElement Salesicon; 
		
		 // locate Returns link
		@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[3]/a")
		private WebElement Returnslink; 
		
		// locate Add icon
				@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
				private WebElement AddBtn;
		
		// locate Order id textbox
				@FindBy(id="input-order-id")
				private WebElement orderid;
				
		 // locate customer textbox
				@FindBy(id="input-customer")
				private WebElement customer;
				
		 // locate firstname textbox
				@FindBy(id="input-firstname")
				private WebElement firstname;
				
		 // locate lastname textbox
				@FindBy(id="input-lastname")
				private WebElement lastname;
				
		 // locate email textbox
				@FindBy(id="input-email")
				private WebElement emailid;
				
		  // locate telephone textbox
				@FindBy(id="input-telephone")
				private WebElement telephone;
				
			// locate product textbox
				@FindBy(id="input-product")
				private WebElement product;
				
			// locate model textbox
				@FindBy(id="input-model")
				private WebElement model;
				
			// locate save button
				@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
				private WebElement savebtn;
				
				// locate cancel button
				@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
				private WebElement cancelbtn;
				
				// locate checkbox
				@FindBy(xpath="//*[@id=\"form-return\"]/div/table/tbody/tr[1]/td[1]/input")
				private WebElement chkbox;
				
				// locate delete button
				@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
				private WebElement dltbtn;
				
				// locate confirmation message
				@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
				private WebElement successmsg;
				
				// locate error message on giving invalid data
				@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
				private WebElement errormsg;	
				
				
				
		// Methods
		public void clickSalesicon() {
			this.Salesicon.click();   // click on Sales icon
		}
				
		public void clickReturnslink() {
		this.Returnslink.click();		// click on Returns link
			}
		
		public void clickAddNewButton() {
			this.AddBtn.click();		// click on Add New Button
				}
		
		public void sendOrderID(String Orderid) {
			this.orderid.clear();
			this.orderid.sendKeys(Orderid);
				}
		public String getOrderID() {
			return this.orderid.getAttribute("value");
				}
		public void sendCustomer(String Customer) {
			this.customer.clear();
			this.customer.sendKeys(Customer);
		}
		public String getCustomer() {
			return this.customer.getAttribute("value");
				}
		public void sendFirstname(String fname) {
			this.firstname.clear();
			this.firstname.sendKeys(fname);
		}
		public String getFirstName() {
			return this.firstname.getAttribute("value");
				}
		public void sendLastname(String lname) {
			this.lastname.clear();
			this.lastname.sendKeys(lname);
		}
		public String getLastName() {
			return this.lastname.getAttribute("value");
				}
		public void sendEmail(String Email) {
			this.emailid.clear();
			this.emailid.sendKeys(Email);
		}
		public String getEmail() {
			return this.emailid.getAttribute("value");
				}
		public void sendTelephone(String Telphn) {
			this.telephone.clear();
			this.telephone.sendKeys(Telphn);
		}
		public String getTelephone() {
			return this.telephone.getAttribute("value");
				}
		public void sendProduct(String Product) {
			this.product.clear();
			this.product.sendKeys(Product);
		}
		public String getProduct() {
			return this.product.getAttribute("value");
				}
		public void sendModel(String Model) {
			this.model.clear();
			this.model.sendKeys(Model);
		}
		public String getModel() {
			return this.model.getAttribute("value");
				}
		
		public void ClickOnSave() {
			this.savebtn.click();  // click on save button
		}
		public void ClickCheckBox() {
			this.chkbox.click();   // check the check box of the customer just created
		}
		public void ClickDeleteButton() {
			this.dltbtn.click();     // click delete button
		}
		public void AcceptAlert() {
			driver.switchTo().alert().accept();  // To accept the alert, that is, to click OK button in the alert window
		}
		
		public String GetConfirmationMsg() {
			return this.successmsg.getText();  // fetch the text of the confirmation message
		}
		
		public String GetErrorMsg() {
			return this.errormsg.getText();  // fetch the text of the error message
		}
		public void ClickCancelButton() {
			this.cancelbtn.click();     // click Cancel button
		}
}
