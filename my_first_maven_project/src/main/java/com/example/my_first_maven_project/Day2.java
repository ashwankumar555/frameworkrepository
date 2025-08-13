package com.example.my_first_maven_project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	@Test(dataProvider="getData")
	public void homeLoanWeb(String uname, String pwd)
	{
		System.out.println("homeLoanWeb");
		System.out.println(uname);
		System.out.println(pwd);
	}
	@Test
	public void homeLoanMobile()
	{
		System.out.println("homeLoanMobile");
	}
	
	@BeforeSuite
	public void beforeSuiteRun()
	{
		System.out.println("I am on Top");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("I will execute before all methods in this class");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("I will execute after each and every methods in this class");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("I will execute after all methods in this class");
	}
	@Test(groups= {"Smoke"})
	public void homeLoanAPI()
	{
		System.out.println("homeLoanAPI");
	}
	@AfterTest
	public void afterLoanAPI()
	{
		System.out.println("I will execute at the last of Test");
	}
	@Parameters({"URL","API"})
	@Test
	public void NewLogin(String urlname, String apiname)
	{
		System.out.println("New Login");
		System.out.println(urlname);
		System.out.println(apiname);
	}
	@DataProvider
	public Object[][] getData()
	{
	Object[][] data = new Object[3][2];
	//set1 of username and pwd
	data[0][0] ="firstusername";
	data[0][1] ="firstpassword";
	//set2 of username and pwd
	data[1][0] ="secondusername";
	data[1][1] ="secondpassword";
	//set3 of username and pwd
	data[2][0] ="thirdusername";
	data[2][1] ="thirdpassword";
	return data;
	}
}