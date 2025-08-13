package AbstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> cartlist;	
	
	
	public Boolean VerifyOrderDisplay(String productname)
	{
		//waitForElementToAppearElement(myOrders);
		Boolean match = cartlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
		return match;
	}
}