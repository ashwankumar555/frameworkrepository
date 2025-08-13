package akhiraacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class LogoutPage  extends AbstractComponentNew
{	
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#back-to-products")
	WebElement clickHome;
	

	@FindBy(css = "#react-burger-menu-btn")
	WebElement logoutmenu;
	

	@FindBy(css = "#logout_sidebar_link")
	WebElement logoutoption;
	
	public void clickOnLogout() throws InterruptedException
	{
		clickHome.click();
		Thread.sleep(500);
		logoutmenu.click();
		Thread.sleep(500);
		logoutoption.click();
	}	
}
