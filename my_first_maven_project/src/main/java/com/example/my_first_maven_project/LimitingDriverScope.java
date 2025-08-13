package com.example.my_first_maven_project;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingDriverScope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int allLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(allLinks);
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int footerLinks = footerdriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinks);
		WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnLinks = columndriver.findElements(By.tagName("a")).size();
		System.out.println(columnLinks);
		for(int i=1;i<columnLinks;i++)
		{
			String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			Thread.sleep(5000L);
		}
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}	
}
