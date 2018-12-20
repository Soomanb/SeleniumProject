package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC022POM 
{
private WebDriver driver; 
	
	public RTTC022POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/ul/li[1]/a")
	private WebElement Orderslink; 
	
	//@FindBy(id="input-group")
	//private List<WebElement> Groupby;
	
	@FindBy(id="button-filter")
	private WebElement filterbtn; 

	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div[2]")
	private WebElement orderstable; 
	
public void clickOrderslink() {
	this.Orderslink.click();
}

public void selectfromGroupbylist() {
	Select groupbyweek = new Select(driver.findElement(By.id("input-group")));
	groupbyweek.selectByVisibleText("Weeks");
}

public void clickFilterButton() {
	this.filterbtn.click();
}

public int nmberOfOrders() {
	List<WebElement> allOrders = this.orderstable.findElements(By.tagName("tr"));
	int rows=allOrders.size();
	return rows;
}

}


