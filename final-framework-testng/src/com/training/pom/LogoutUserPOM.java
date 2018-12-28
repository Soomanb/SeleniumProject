package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutUserPOM 
{

private WebDriver driver; 
	
	public LogoutUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement usericon;
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[4]/a/span")
	private WebElement logout;
	
	public void moveCursorToUserIcon() {
		Actions action = new Actions(driver);
		action.moveToElement(this.usericon).build().perform();
	}
	
	public void ClickOnLogout() {
		this.logout.click();  
	}
}
