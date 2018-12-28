package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPOM 
{

private WebDriver driver; 
	
	public PlaceOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements
	
	@FindBy(linkText="ETHNIC")
	private WebElement ethniclink; 
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[1]/div/div[2]/div[1]/div[2]/a/img")
	private WebElement integeritem;
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[2]/div/div[2]/div[1]/div[2]/a/img")
	private WebElement loremitem; 
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[3]/div/div[2]/div[1]/div[2]/a/img")
	private WebElement nullamitem;
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[4]/div/div[2]/div[1]/div[1]/a/span/span/img")
	private WebElement quisitem;
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[5]/div/div[2]/div[1]/div[2]/a/img")
	private WebElement suspendisitem;
	
	@FindBy(id="input-quantity")
	private WebElement qnty;
	
	@FindBy(id="button-cart")
	private WebElement addtocartbtn;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/h3/a/i")
	private WebElement shoppingcarticon;
	
	@FindBy(xpath="//*[@id=\"System_V2Exp1o9\"]/div[3]/div[2]/a")
	private WebElement chkoutbtn;
	
	@FindBy(id="button-payment-address")
	private WebElement continue1;
	
	@FindBy(id="button-shipping-address")
	private WebElement continue2;
	
	@FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	private WebElement ordercomment;
	
	@FindBy(id="button-shipping-method")
	private WebElement continue3;
	
	@FindBy(name="agree")
	private WebElement termscondn;
	
	@FindBy(id="button-payment-method")
	private WebElement continue4;

	@FindBy(id="button-confirm")
	private WebElement confirmorder;

	// Methods
	
	public void ClickOnEthnic() {
		this.ethniclink.click();  
	}
	
	public void ClickOnItem(String itemname) 
	{
		  if(itemname=="Integer Vitae Iaculis Massa")
		  {
			  this.integeritem.click();
		  }
		  else if(itemname=="Lorem Ipsum Dolor Sit Amet")
		  {
			  this.loremitem.click();
		  }
		  else if(itemname=="Nullam Sodales In Purus Vel Auctor")
		  {
			  this.nullamitem.click();
		  }
		  else if(itemname=="Quis Venenatis Est Ultricies Et")
		  {
			  this.quisitem.click();
		  }
		  else if(itemname=="Suspendisse Ultrices Mi Nisl")
		  {
			  this.suspendisitem.click();
		  }
	}
	
	
	public void selectQuantity(int n) {
		String nStr = Integer.toString(n);
		this.qnty.clear();
		this.qnty.sendKeys(nStr);
	}
	
		
	public void ClickAddtocart() {
		this.addtocartbtn.click();
	}
	
	public void ClickShoppingCartIcon() {
		this.shoppingcarticon.click();
	}
	
	public void ClickCheckOutButton() {
		this.chkoutbtn.click();
	}
	
	public void ClickPaymentAddressContinue() {
		this.continue1.click();
	}
	
	public void ClickShippingAddressContinue() {
		this.continue2.click();
	}
	
	public void SendOrderComments(String comment) {
		this.ordercomment.clear();
		this.ordercomment.sendKeys(comment);
	}
	
	public void ClickShippingMethodContinue() {
		this.continue3.click();
	}
	
	public void ClickAgreeChkBox() {
		this.termscondn.click();
	}
	
	public void ClickPaymentMethodContinue() {
		this.continue4.click();
	}
	
	public void ClickConfirmOrder() {
		this.confirmorder.click();
	}
	
}



/* Your order has been successfully processed!

You can view your order history by going to the my account page and by clicking on history.

If your purchase has an associated download, you can go to the account downloads page to view them.

Please direct any questions you have to the store owner.

Thanks for shopping with us online! */


// xpath of the above text: //*[@id="System_epRD9Fax"]/div[1]
