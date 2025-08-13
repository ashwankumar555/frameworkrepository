package akhiraacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class CheckoutOverviewPage extends AbstractComponentNew
{	
	
	WebDriver driver;
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#finish")
	WebElement finishbutton;
	
	public CheckoutCompletePage clickOnFinishbutton()
	{
		finishbutton.click();
		CheckoutCompletePage checkoutcomplete = new CheckoutCompletePage(driver);
		return checkoutcomplete;
	}

}
