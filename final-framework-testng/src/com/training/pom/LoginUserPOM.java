package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUserPOM 
{

private WebDriver driver; 
	
	public LoginUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement usericon; 
	
	@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]/a/span")
	private WebElement loginregister;
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input")
	private WebElement loginBtn; 
	
	
	public void moveCursorToUserIcon() {
		Actions action = new Actions(driver);
		action.moveToElement(this.usericon).build().perform();
	}
	
	public void ClickLoginOrRegister() {
		this.loginregister.click();  
	}
	
	public void sendEmail(String emailid) {
		this.email.clear();
		this.email.sendKeys(emailid);
	}
	
	public void sendPassword(String pswrd) {
		this.password.clear();
		this.password.sendKeys(pswrd);
	}
	
	public void ClickLoginButton() {
		this.loginBtn.click();
	}
}
