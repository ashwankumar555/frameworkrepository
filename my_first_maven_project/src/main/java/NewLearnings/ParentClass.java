package NewLearnings;

import org.testng.annotations.BeforeTest;

public class ParentClass {
	
	public void doThis()
	{
		System.out.println("I am from parent class");
	}
	@BeforeTest
	public void testBeforeRun()
	{
		System.out.println("run me first");
	}


}
