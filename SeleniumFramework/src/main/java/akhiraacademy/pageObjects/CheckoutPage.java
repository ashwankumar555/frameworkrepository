package akhiraacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class CheckoutPage extends AbstractComponentNew
{	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstname;

	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalcode;
	

	@FindBy(css = "#continue")
	WebElement continuebutton;

	public CheckoutOverviewPage checkOutProducts(String fname, String lname, String zcode)
	{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		postalcode.sendKeys(zcode);
		continuebutton.click();
		CheckoutOverviewPage checkoutoverview = new CheckoutOverviewPage(driver);
		return checkoutoverview;
	}
	

}
