package akhiraacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractComponents.OrderPage;
import TestComponents.BaseTest;

public class StandAloneFinal extends BaseTest {

	//String productname = "ZARA COAT 3";
	@Test(dataProvider="getData", groups= {"Purchase"})
	public  void SubmitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {
		
		
	
		String productname = input.get("product");
		//LandingPage landpage = launchapplication();
		LandingPage landpage = new LandingPage(driver);
		landpage.loginapplication(input.get("email"), input.get("password"));
		ProductCatalogue productCatelogue = landpage.goToProductCatelogue();
		List<WebElement>products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(input.get("product"));
		List<WebElement> productslist = (List<WebElement>) productCatelogue.getCartWebElement();
		Boolean matchTure = productCatelogue.getMatchTest();
		CheckoutCart checkout = productCatelogue.goToCheckoutCart();
		WebElement checkoutnew = checkout.checkoutCart();
		checkout.doAction(checkoutnew);
		PlaceOrder placeOrder = checkout.goToPlaceOrder();
		Thread.sleep(1000);
		WebElement selectedCountry = placeOrder.getSelectedCountry();
		Thread.sleep(1000);
		placeOrder.doActionPlaceOrder(selectedCountry, input.get("ctry"));
		Thread.sleep(1000);
		placeOrder.getplacedOrder().click();
		Thread.sleep(1000);
		placeOrder.doActionSubmit();
		String confirmMessage = placeOrder.getFinalAck();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.findElement(By.cssSelector("label[routerlink='/dashboard/myorders']")).click();
		//System.out.println(driver.findElement(By.cssSelector(".ng-star-inserted td[3]")).getText());
		
	}
	
	//@Test(dependsOnMethods={"SubmitOrderTest"})
	//public void OrderTestHistory() throws IOException
	//{
		//LandingPage landpage = launchapplication();
		//landpage.loginapplication("ashwankumar555@gmail.com", "Star@12345");
		//OrderPage orderPage = landpage.goToOrderPage();
		//Assert.assertTrue(orderPage.VerifyOrderDisplay(productname));
	//}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		map.put("email", "ashwankumar555@gmail.com");
		map.put("password", "Star@12345");
		map.put("product", "ZARA COAT 3");
		map.put("ctry", "india");
		
		map1.put("email", "ashwinkumarganji@gmail.com");
		map1.put("password", "King@12345");
		map1.put("product", "ADIDAS ORIGINAL");
		map1.put("ctry", "india");
		return new Object[][] {{map},{map1}};
		
		//return new Object[][] {{"ashwankumar555@gmail.com","Star@12345","ZARA COAT 3","india"}, {"ashwinkumarganji@gmail.com","King@12345","ADIDAS ORIGINAL","india"}};
	}
}
