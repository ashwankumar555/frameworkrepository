package akhiraacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckoutCart extends AbstractComponent {
	WebDriver driver;

	public CheckoutCart(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".totalRow button")
	WebElement clickElement;	
	
	
	
	public WebElement checkoutCart()
	{	
	
		waitForElementToAppearElement(clickElement);
		return clickElement;
		//Actions actions = new Actions(driver);
		//actions.moveToElement(clickElement).click(clickElement).build().perform();

	}
	public void doAction(WebElement clickElement)
	{
	Actions actions = new Actions(driver);
	actions.moveToElement(clickElement).click(clickElement).build().perform();
	}
	public PlaceOrder goToPlaceOrder()
	{
		return new PlaceOrder(driver);
	}
}