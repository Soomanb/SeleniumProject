package com.training.pom;

import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class validAdminUserPOM 
{
private WebDriver driver; 
	
	public validAdminUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	public void sendUserName(String userName)
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public String getUsernameText()
	{
		return this.userName.getAttribute("value");
	}
	
	public void chkUserName() {
		String nametxt = this.userName.getAttribute("value");
		int namesize = nametxt.length();
		
		// check the length of the admin username and check if alphabetical only.
		
		if((namesize<=6) && (Pattern.matches("[a-zA-Z]+", nametxt)))   
		{
			System.out.println(userName);
			System.out.println("Admin User name is valid.");
		} 
		else
	   
		{
			System.out.println(userName);
			System.out.println("Admin User name is invalid.");
		}
	}
	
	
}
