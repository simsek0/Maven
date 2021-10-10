package com.neotech.lesson02;

import org.testng.annotations.Test;

public class DependsDemo {
	
	@Test
	public void firstMethod()
	{
		System.out.println("firstmethod");
	}
	@Test()
	public void secondTest()
	{
		System.out.println("secondmethod");
	}
	@Test(dependsOnMethods = {"secondTest","firstMethod"})
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
