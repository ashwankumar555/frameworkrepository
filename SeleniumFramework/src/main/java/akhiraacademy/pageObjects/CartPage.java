package akhiraacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class CartPage extends AbstractComponentNew{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".inventory_item_name")
	private List<WebElement> cartItemList;

	
	@FindBy(css = ".checkout_button")
	WebElement checkOutButton;
	
	public Boolean verifyDisplayItems(String productname)
	{
		
		Boolean match = cartItemList.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
			return match;
	}
	
	public CheckoutPage goToCheckOutPage()
	{
		checkOutButton.click();
		CheckoutPage checkoutPage =new CheckoutPage(driver);
		return checkoutPage;
		
	}
	
}
