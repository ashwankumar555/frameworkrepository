package akhiraacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class PlaceOrder extends AbstractComponent {
	WebDriver driver;

	public PlaceOrder(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement selCountry;	
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement taitemButton;
	
	@FindBy(css=".action__submit")
	WebElement actionsubmit;	
	
	@FindBy(css=".hero-primary")
	WebElement finalText;	
	
	By taResults = By.cssSelector(".ta-results");
	
	public WebElement getplacedOrder()
	{		
		//waitForElementToAppear(taResults);
		return taitemButton;
		
	}
	public WebElement getActionSubmit()
	{
		return actionsubmit;
	}
	public String getFinalAck()
	{
		return finalText.getText();
	}
	
	public WebElement getSelectedCountry()
	{
		return selCountry;
	}
	public void doActionPlaceOrder(WebElement selCty, String contry)
	{
	
	Actions actions = new Actions(driver);
	actions.sendKeys(selCountry, contry).build().perform();
	}
	public void doActionSubmit()
	{
	
	Actions actions = new Actions(driver);
	actions.moveToElement(actionsubmit).click(actionsubmit).build().perform();
	
	}
	}
	
