package akhiraacademy.Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		String productName = "Sauce Labs Onesie";
		String firstname = "Ashwin";
		String lastname  = "Kumar";
		String zipcode = "502032";
		ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--incognito");  // Optional
        WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[id='login-button']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement staticDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		
		driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();
		
		Thread.sleep(5000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[text()='"+productName+"']"));
		WebElement prod = products.stream().filter(product->product.findElement(By.xpath("//div[text()='"+productName+"']")).getText().equals(productName)).findFirst().orElse(null);
		Assert.assertEquals(prod.getText(), productName);
		driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[2]/div[2]/button")).click();
		driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();
		driver.findElement(By.cssSelector(".checkout_button")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(zipcode);
		driver.findElement(By.cssSelector("#continue")).click();
		driver.findElement(By.cssSelector("#finish")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".checkout_complete_container h2")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	}
}
