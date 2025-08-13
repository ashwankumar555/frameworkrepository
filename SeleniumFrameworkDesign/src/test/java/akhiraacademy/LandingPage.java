package akhiraacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// WebElement password = driver.findElement(By.id("userPassword"));
	// driver.findElement(By.cssSelector(".login-btn")).click();
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public String getErrorMessage()
	{
		waitForElementToAppearElement(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {
		driver.get("https://www.saucedemo.com");
	}

	public void loginapplication(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
	}
	public ProductCatalogue goToProductCatelogue()
	{
		return new ProductCatalogue(driver);
	}
}
