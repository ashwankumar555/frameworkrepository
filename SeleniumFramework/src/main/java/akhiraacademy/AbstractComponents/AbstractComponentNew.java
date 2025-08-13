package akhiraacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import akhiraacademy.pageObjects.CartPage;

public class AbstractComponentNew {

	WebDriver driver;
	public AbstractComponentNew(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "a[data-test='shopping-cart-link']")
	WebElement cartHeader;
	
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public void waitForElementToApprear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
}
