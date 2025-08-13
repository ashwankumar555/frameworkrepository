package akhiraacademy.Tests;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import akhiraacademy.TestComponents.BaseTest;
import akhiraacademy.pageObjects.CartPage;
import akhiraacademy.pageObjects.CheckoutCompletePage;
import akhiraacademy.pageObjects.CheckoutOverviewPage;
import akhiraacademy.pageObjects.CheckoutPage;
import akhiraacademy.pageObjects.LandingPageNew;
import akhiraacademy.pageObjects.ProductCatalogueNew;
import akhiraacademy.TestComponents.Retry;

public class ErrorValidations extends BaseTest {

	//@Test(groups= {"ErrorHandling"})
	@Test(retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName = "Sauce Labs Backpack";
		String firstname = "Ashwin";
		String lastname  = "Kumar";
		String zipcode = "502032";
		LandingPageNew landingPage = lanchapplication();
		landingPage.loginapplication("standard_user", "secret_");
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",landingPage.getErrorMessage());
			}
	
	//@Test(groups= {"ErrorHandling"})
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName = "Sauce Labs Backpack";
		String firstname = "Ashwin";
		String lastname  = "Kumar";
		String zipcode = "502032";
		LandingPageNew landingPage = lanchapplication();
		//landingPage.loginapplication("standard_user", "secret_sauce");
		ProductCatalogueNew newproductCatalogue = landingPage.loginapplication("standard_user", "secret_sauce");
		List<WebElement> products = newproductCatalogue.getProductsListByText(productName);
		Assert.assertEquals(newproductCatalogue.getProductByName(productName).getText(), productName);
	}
}
