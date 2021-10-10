package homeworks;

import org.testng.annotations.*;

public class week2hw1 {

	@Test(priority=4)
	public void firstMethod()
	{
		System.out.println("First method");
	}

	@Test(priority=3)
	public void firstMethod1()
	{
		System.out.println("first method 1");
	}
	
	@Test(priority=2)
	public void secondMethod()
	{
		System.out.println("Second method");
	}
	@Test(priority=1)
	public void thirdMethod()
	{
		System.out.println("Third method");
	}
	@Test(priority=0)
	public void fourthMethod()
	{
		System.out.println("fourth Method");
	}

}
