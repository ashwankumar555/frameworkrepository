package akhiraacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import akhiraacademy.AbstractComponents.AbstractComponentNew;

public class LandingPageNew extends AbstractComponentNew {
	
	WebDriver driver;

	public LandingPageNew(WebDriver driver) {
		
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement passWord;
	
	@FindBy(css = "input[id='login-button']")
	WebElement submit;
	
	@FindBy(css = ".error-message-container h3")
	WebElement errorMessage;
	
	public void goTo() {
		driver.get("https://www.saucedemo.com");
	}

	public ProductCatalogueNew loginapplication(String email, String pwd) {
		userName.sendKeys(email);
		passWord.sendKeys(pwd);
		submit.click();
		
		ProductCatalogueNew newproductCatalogue = new ProductCatalogueNew(driver);
		return newproductCatalogue;
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}

}
