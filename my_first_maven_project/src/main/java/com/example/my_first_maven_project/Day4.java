package com.example.my_first_maven_project;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day4 {
	@Test
	public void MobileLoanWeb()
	{
		System.out.println("MobileLoanWeb");
	}
	@Test
	public void MobileLoanMobile()
	{
		System.out.println("MobileLoanMobile");
	}
	@Test(groups= {"Smoke"})
	public void MobileLoanAPI()
	{
		System.out.println("MobileLoanAPI");
	}
	@Test
	public void cellLoanAPI()
	{
		System.out.println("cellLoanAPI");
	}
	@AfterSuite
	public void afterSuiteRun()
	{
		System.out.println("I am at bottom");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("I will execute before every method in this class");
	}
	@BeforeTest
	public void beforeLoanAPI()
	{
		System.out.println("I will execute befor Test");
	}
}
