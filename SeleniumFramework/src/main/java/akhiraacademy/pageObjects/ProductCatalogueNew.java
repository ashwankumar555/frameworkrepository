package akhiraacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class ProductCatalogueNew extends AbstractComponentNew{
	
	WebDriver driver;

	public ProductCatalogueNew(WebDriver driver) {
		
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".product_sort_container")
	WebElement staticDropdown;

	//By dynamic = By.xpath(getDynamicXpath());
	
	By filter = By.cssSelector(".product_sort_container");

	public List<WebElement> getProductsListByText(String text) {
		waitForElementToApprear(filter);
	    return driver.findElements(By.xpath("//div[text()='"+text+"']"));
	}
	public WebElement getProductByName(String productname)
	{
	WebElement prod = driver.findElements(By.xpath("//div[text()='"+productname+"']")).stream().filter(product->product.findElement(By.xpath("//div[text()='"+productname+"']")).getText().equals(productname)).findFirst().orElse(null);
	return prod;
	}
	
	public void addProductToCart(String productname)
	{
		WebElement prod = getProductByName(productname);
		prod.findElement(By.xpath("//div[text()='"+productname+"']/ancestor::div[2]/div[2]/button")).click();
	
	}
}
