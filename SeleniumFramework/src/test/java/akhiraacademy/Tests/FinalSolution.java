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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import akhiraacademy.TestComponents.BaseTest;
import akhiraacademy.pageObjects.CartPage;
import akhiraacademy.pageObjects.CheckoutCompletePage;
import akhiraacademy.pageObjects.CheckoutOverviewPage;
import akhiraacademy.pageObjects.CheckoutPage;
import akhiraacademy.pageObjects.LandingPageNew;
import akhiraacademy.pageObjects.LogoutPage;
import akhiraacademy.pageObjects.ProductCatalogueNew;

public class FinalSolution extends BaseTest {

	@Test(dataProvider="getData")
	public void submitOrder(String uname, String pwd, String productName, String firstname, String lastname, String zipcode) throws IOException, InterruptedException
	{
		//String productName = product;
		//String firstname = fname;
		//String lastname  = lname;
		//String zipcode = zcode;
		LandingPageNew landingPage = lanchapplication();
		ProductCatalogueNew newproductCatalogue = landingPage.loginapplication(uname, pwd);
		List<WebElement> products = newproductCatalogue.getProductsListByText(productName);
		Assert.assertEquals(newproductCatalogue.getProductByName(productName).getText(), productName);
		newproductCatalogue.addProductToCart(productName);
		newproductCatalogue.goToCartPage();
		List<WebElement>  cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		CartPage cartPage = newproductCatalogue.goToCartPage();
		Boolean match = cartPage.verifyDisplayItems(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOutPage();
		CheckoutOverviewPage checkoutoverview = checkoutPage.checkOutProducts(firstname, lastname, zipcode);
		Thread.sleep(1000);
		CheckoutCompletePage checkoutcomplete = checkoutoverview.clickOnFinishbutton();
		String confirmMessage = checkoutcomplete.getFinalAck();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void LogoutApplication() throws InterruptedException, IOException
	{
		//LandingPageNew landingPage = lanchapplication();
		//ProductCatalogueNew newproductCatalogue = landingPage.loginapplication("standard_user", "secret_sauce");
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnLogout();
	}
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"standard_user", "secret_sauce", "Sauce Labs Backpack", "Ashwin", "Kumar", "502032"}, {"visual_user", "secret_sauce", "Sauce Labs Backpack", "Akhira", "Kumar", "502032"}};
	}
}
