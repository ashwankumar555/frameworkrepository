package akhiraacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import akhiraacademy.pageObjects.CartPage;
import akhiraacademy.pageObjects.CheckoutCompletePage;
import akhiraacademy.pageObjects.CheckoutOverviewPage;
import akhiraacademy.pageObjects.CheckoutPage;
import akhiraacademy.pageObjects.LandingPageNew;
import akhiraacademy.pageObjects.ProductCatalogueNew;
import akhiraacademy.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImplementation extends BaseTest {
	
	public LandingPageNew landingPage;
	public ProductCatalogueNew newproductCatalogue;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public CheckoutOverviewPage checkoutoverview;
	public CheckoutCompletePage checkoutcomplete;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = lanchapplication();
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String uname, String pwd)
	{
		newproductCatalogue = landingPage.loginapplication(uname, pwd);
	}
	
	@When("^I add product (.+) to Cart$")
	public void add_product_to_cart(String productname)
	{
		List<WebElement> products = newproductCatalogue.getProductsListByText(productname);
		Assert.assertEquals(newproductCatalogue.getProductByName(productname).getText(), productname);
		newproductCatalogue.addProductToCart(productname);
		newproductCatalogue.goToCartPage();
		List<WebElement>  cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
		cartPage = newproductCatalogue.goToCartPage();
		Boolean match = cartPage.verifyDisplayItems(productname);
		Assert.assertTrue(match);
	}
	@And("^Checkout by providing first name (.+) and last name (.+) and zipcode (.+) details and submit the order$")
	public void checkout_order_page(String firstname, String lastname, String zipcode) throws InterruptedException
	{
		
		checkoutPage = cartPage.goToCheckOutPage();
		CheckoutOverviewPage checkoutoverview = checkoutPage.checkOutProducts(firstname, lastname, zipcode);
		Thread.sleep(1000);
		CheckoutCompletePage checkoutcomplete = checkoutoverview.clickOnFinishbutton();
		Thread.sleep(1000);
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	
	public void message_displayed_confirmationPage(String string)
	{
		checkoutcomplete = new CheckoutCompletePage(driver);
		String confirmMessage = checkoutcomplete.getFinalAck();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void error_message_is_displayed(String str1) throws Throwable
	{
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",landingPage.getErrorMessage());
			
	}
}
