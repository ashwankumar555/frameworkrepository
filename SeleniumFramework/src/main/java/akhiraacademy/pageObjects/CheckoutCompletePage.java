package akhiraacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class CheckoutCompletePage  extends AbstractComponentNew
{	
	
	WebDriver driver;
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".checkout_complete_container h2")
	WebElement finalack;
	
	public String getFinalAck()
	{
		CheckoutCompletePage checkoutcomplete = new CheckoutCompletePage(driver); 
		//return finalack.getText();
		return getAck().getText();
	}	
	
	public WebElement getAck()
	{
		CheckoutCompletePage checkoutcomplete = new CheckoutCompletePage(driver);
		return finalack;
	}
}
