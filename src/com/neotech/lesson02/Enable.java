package com.neotech.lesson02;

import org.testng.annotations.Test;

public class Enable {

	@Test(enabled=false,priority = 2)
	public void firstMethod()
	{
		System.out.println("firstmethod");
	}
	@Test(priority=1)
	public void secondTest()
	{
		System.out.println("secondmethod");
	}
	@Test(priority=2)
	public void thirdTest()
	{
		System.out.println("thirdmethod");
	}
	@Test
	public void fourthTest()
	{
		System.out.println("fourthmethod");
	}
}
