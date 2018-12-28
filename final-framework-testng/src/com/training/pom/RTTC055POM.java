package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC055POM 
{

private WebDriver driver; 
	
	public RTTC055POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
		@FindBy(xpath="//*[@id=\"menu-catalog\"]/a/i")
		private WebElement catalogicon;   //locate catalog icon
		
		@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[7]/a")
		private WebElement manufacturerlink;  // locate manufacturers link
		
		@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
		private WebElement productslink;  // locate Products link
		
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")  // locator for AddNew button is same everywhere.
		private WebElement addnewbtn;
		
		@FindBy(id="input-name")
		private WebElement manufcname;  // Locate Manufacturer name textbox 
		
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button/i")
		private WebElement savebtn;	   // locator for Save button is same everywhere.
		
		@FindBy(id="input-name1")
		private WebElement productname;  // locate product name textbox
		
		@FindBy(id="input-meta-title1")
		private WebElement metatag;  // locate meta tag title textbox
		
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
		private WebElement datatab;  // locate the Data tab 
		
		@FindBy(id="input-model")
		private WebElement pmodel;  // locate Product model textbox 
		
		@FindBy(id="input-price")
		private WebElement pprice;  // locate Product price textbox 
		
		@FindBy(id="input-quantity")
		private WebElement pqty;  // locate Product quantity textbox  
		
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
		private WebElement linkstab;  // locate Links tab
		
		@FindBy(id="input-manufacturer")
		private WebElement linksmanufc;  // locate manufacturer textbox in Links tab
		
		@FindBy(id="input-category")
		private WebElement linkscateg;  // locate categories textbox in Links tab
		
		// Methods
		
		public void clickOnCatalogIcon() {
			this.catalogicon.click();
		}
		
		public void clickOnManufacturersLink() {
			this.manufacturerlink.click();
		}
		
		public void clickToAddNewManufacturer() {
			this.addnewbtn.click();
		}
		
		public void sendNewManufacturerName(String newmanufcname) {
			this.manufcname.sendKeys(newmanufcname);
			this.savebtn.click();
		}
			
		public void addNewProduct() {
			this.catalogicon.click();
			this.productslink.click();
			this.addnewbtn.click();
		}
		
		public void enterInProductGeneralTab(String prodname, String metatagtitle) {
			this.productname.sendKeys(prodname);
			this.metatag.sendKeys(metatagtitle);
		}
		
		public void enterInProductDataTab(String Model, String Price, String Quantity) {
			this.datatab.click();
			this.pmodel.sendKeys(Model);
			this.pprice.sendKeys(Price);
			this.pqty.clear();
			this.pqty.sendKeys(Quantity);
		}
		
		public void enterInProductLinksTab(String Manufacturer, String Categories) {
			this.linkstab.click();
			this.linksmanufc.sendKeys(Manufacturer);
			this.linkscateg.sendKeys(Categories);
		}
		
		public void ClickSave() {
			this.savebtn.click();
		}
		
		public String getSuccessMsg() {
			return driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]")).getText();
		}
		
		
}
