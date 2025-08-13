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

public class FinalSolutionHashMap extends BaseTest {

	//@Test(dataProvider="getData",groups= {"Purchase"})
	@Test
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		//String productName = product;
		//String firstname = fname;
		//String lastname  = lname;
		//String zipcode = zcode;
		LandingPageNew landingPage = lanchapplication();
		ProductCatalogueNew newproductCatalogue = landingPage.loginapplication(input.get("uname"), input.get("pwd"));
		List<WebElement> products = newproductCatalogue.getProductsListByText(input.get("productName"));
		Assert.assertEquals(newproductCatalogue.getProductByName(input.get("productName")).getText(),input.get("productName"));
		newproductCatalogue.addProductToCart(input.get("productName"));
		newproductCatalogue.goToCartPage();
		List<WebElement>  cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		CartPage cartPage = newproductCatalogue.goToCartPage();
		Boolean match = cartPage.verifyDisplayItems(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckOutPage();
		CheckoutOverviewPage checkoutoverview = checkoutPage.checkOutProducts(input.get("firstname"),input.get("lastname"),input.get("zipcode"));
		Thread.sleep(1000);
		CheckoutCompletePage checkoutcomplete = checkoutoverview.clickOnFinishbutton();
		String confirmMessage = checkoutcomplete.getFinalAck();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	}
	
	//@Test(dependsOnMethods= {"submitOrder"})
	@Test
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
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("uname", "standard_user");
		map.put("pwd", "secret_sauce");
		map.put("productName", "Sauce Labs Backpack");
		map.put("firstname", "Ashwin");
		map.put("lastname", "Kumar");
		map.put("zipcode","502032");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("uname", "visual_user");
		map1.put("pwd", "secret_sauce");
		map1.put("productName", "Sauce Labs Backpack");
		map1.put("firstname", "Akhira");
		map1.put("lastname", "Kumar");
		map1.put("zipcode","502032");
		
		return new Object[][] {{map},{map1}};
		//return new Object[][] {{"standard_user", "secret_sauce", "Sauce Labs Backpack", "Ashwin", "Kumar", "502032"}, {"visual_user", "secret_sauce", "Sauce Labs Backpack", "Akhira", "Kumar", "502032"}};
	}
}
