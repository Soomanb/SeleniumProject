
// This is a POM class for getting reports of Orders, Tax, Shipping, Returns


package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllSalesPOM 
{
private WebDriver driver; 
	
	public AllSalesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// locate Reports icon
	@FindBy(xpath="//*[@id=\"menu-report\"]/a/i")
	private WebElement Reports; 
	
	// locate Sales link
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/a")
	private WebElement Sales;
	
	// locate Orders link
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/ul/li[1]/a")
	private WebElement Orderslink; 
	
	// // locate Tax link
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/ul/li[2]/a")
	private WebElement Taxlink; 
	
	// locate Shipping link
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/ul/li[3]/a")
	private WebElement Shippinglink; 
	
	// // locate Returns link
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/ul/li[4]/a")
	private WebElement Returnslink; 
	
	// locate filter button
	@FindBy(id="button-filter")
	private WebElement filterbtn; 

	// locate webtable and xpath for webtable forOrders, Tax, Shipping and Returns is same.
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div[2]/div[2]")
	private WebElement table;                              
	
	public void clickReports() {
		this.Reports.click();
	}
	
	public void clickSales() {
		this.Sales.click(); 
	}
		
public void clickOrderslink() {
	this.Orderslink.click();
}

public void clickTaxlink() {
	this.Taxlink.click();
}

public void clickShippinglink() {
	this.Shippinglink.click();
}

public void clickReturnslink() {
	this.Returnslink.click();
}

// identify GroupBy combo box and select from it.
public void selectfromGroupbylist() {
	Select groupbyweek = new Select(driver.findElement(By.id("input-group")));
	groupbyweek.selectByVisibleText("Weeks");
}

public void clickFilterButton() {
	this.filterbtn.click();
}

public int numberOfRows() {
	List<WebElement> allOrders = this.table.findElements(By.tagName("tr"));
	int rows=allOrders.size();
	return rows;
}

}



