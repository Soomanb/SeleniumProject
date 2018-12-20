package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportSalesPOM 
{

private WebDriver driver; 
	
	public ReportSalesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/a/i")
	private WebElement Reports; 
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[1]/a")
	private WebElement Sales;
	
	public void clickReports() {
		this.Reports.click();
	}
	
	public void clickSales() {
		this.Sales.click(); 
	}
	
	
}
