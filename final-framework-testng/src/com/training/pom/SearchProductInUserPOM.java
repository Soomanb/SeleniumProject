package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductInUserPOM 
{

private WebDriver driver; 
	
	public SearchProductInUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// LOCATORS
	
	@FindBy(linkText="SHOP NOW")
	private WebElement ShopNowIcon;   //locate Shop Now icon
	
	@FindBy(linkText="ETHNIC")
	private WebElement EthnicLink;   //locate Ethnic link
	
	@FindBy(linkText="Earrings")
	private WebElement EarringsLink;   //locate EarringsLink
	
	@FindBy(id="search_button")
	private WebElement searchBtn;   //locate Search Button
	
	@FindBy(id="filter_keyword")
	private WebElement searchBox;   //locate Search Box
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div/div/div[3]/div/div/div[1]/h4/a")
	private WebElement searchedProduct;   //locate name of searched product
	
	
	// METHODS
	
	public void clickOnShopNowIcon() {
		this.ShopNowIcon.click();
	}
	
	public void moveCursorToEthnic() {
		Actions action = new Actions(driver);
		action.moveToElement(this.EthnicLink).build().perform();
	}
	
	public void clickOnEarrings() {
		Actions action = new Actions(driver);
		action.moveToElement(this.EarringsLink).click();
	}
	
	public void clickOnSearchButton() {
		this.searchBtn.click();
	}
	
	public void sendSearchKeyword(String Keyword) {
		this.searchBox.sendKeys(Keyword);
		this.searchBox.sendKeys(Keys.ENTER);
	}
	public String getNameOfSearchedProduct() {
		return this.searchedProduct.getText();
	}
	
}
