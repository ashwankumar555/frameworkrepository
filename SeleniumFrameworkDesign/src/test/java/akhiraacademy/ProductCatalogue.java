package akhiraacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	//ProductCatalogue productCatelogue = new ProductCatalogue(driver);
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;	

	@FindBy(css="[routerlink*='cart']")
	WebElement routerlink;	
	
	@FindBy(css=".cartSection h3")
	WebElement cartSection;	
	

	@FindBy(css=".cartSection h3")
	List<WebElement> cartSectionsList;	
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
	WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
	}
	public void addProductToCart(String productName) throws InterruptedException
	{	
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();	
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		routerlink.click();
	}
	//public void clickOnCart()
	//{
	//	routerlink.click();
	//}
	
	public String getCartText()
	{
		String cartSectionText = cartSection.getText();
		return cartSectionText;
	}
	public List<WebElement> getCartWebElement()
	{
		List<WebElement> cartWebElementsList = cartSectionsList;
		return cartWebElementsList;
	}
	public boolean getMatchTest()
	{
		Boolean match = cartSectionsList.stream().anyMatch(productslist1 -> productslist1.getText().equalsIgnoreCase(getCartText()));
		return match;
	}
	public CheckoutCart goToCheckoutCart()
	{
		return new CheckoutCart(driver);
	}

}