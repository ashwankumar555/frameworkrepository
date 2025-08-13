package com.example.my_first_maven_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class CalendarTest {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String monthNumber = "01";
		String date = "25";
		String year = "2024";
		String fulldate = year+"-"+monthNumber+"-"+date;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__tile.react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		//System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).getAttribute("value"));
		String datefromscript = driver.findElement(By.cssSelector("input[name='date']")).getAttribute("value");
		System.out.println(datefromscript);
		System.out.println(fulldate);
		Assert.assertEquals(datefromscript,fulldate);
	}
}
