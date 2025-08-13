package akhiraacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public  void LoginErrorValidation() throws IOException, InterruptedException {
		
		String productname = "ZARA COAT 3";
		landpage.loginapplication("ashwankumar555@gmail.com", "Star@1245");
		Assert.assertEquals("Incorrect email or password.", landpage.getErrorMessage());
		
	}
	
	@Test
	public  void ProductErrorValidation() throws IOException, InterruptedException {
		
		String productname = "ZARA COAT 3";
		String countryNameSelect = "india";
		LandingPage landpage = launchapplication();
		landpage.loginapplication("ashwankumar555@gmail.com", "Star@12345");
		ProductCatalogue productCatelogue = landpage.goToProductCatelogue();
		List<WebElement>products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(productname);
		List<WebElement> productslist = (List<WebElement>) productCatelogue.getCartWebElement();
		Boolean matchTure = productCatelogue.getMatchTest();
	}
}
