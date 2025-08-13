package com.example.my_first_maven_projec;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopupNew {
  public static void main(String[] args) {
    ChromeDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
    chromeDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(new CharSequence[] { "Akhira" });
    chromeDriver.findElement(By.xpath("//input[@id='alertbtn']")).click();
    System.out.println(chromeDriver.switchTo().alert().getText());
    chromeDriver.switchTo().alert().accept();
    chromeDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(new CharSequence[] { "Akhira" });
    chromeDriver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
    System.out.println(chromeDriver.switchTo().alert().getText());
    chromeDriver.switchTo().alert().dismiss();
  }
}