package com.example.my_first_maven_project;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day1 {
	@Test
	public void carLoanWeb()
	{
		System.out.println("carLoanWeb");
	}
	@Test(groups= {"Smoke"})
	public void carLoanMobile()
	{
		System.out.println("carLoanMobile");
		Assert.assertTrue(false);
	}
	@Test(dependsOnMethods= {"carLoanWeb"})
	public void carLoanAPI()
	{
		System.out.println("carLoanAPI");
	}
	@Test(timeOut=4000)
	public void finalAPI()
	{
		System.out.println("finalAPI");
	}
}