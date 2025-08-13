package akhiraacademy.Tests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class FinalSolutionJson extends BaseTest {

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
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
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void LogoutApplication() throws InterruptedException, IOException
	{
		
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickOnLogout();
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\akhiraacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		//return new Object[][] {{"standard_user", "secret_sauce", "Sauce Labs Backpack", "Ashwin", "Kumar", "502032"}, {"visual_user", "secret_sauce", "Sauce Labs Backpack", "Akhira", "Kumar", "502032"}};
	}
}
