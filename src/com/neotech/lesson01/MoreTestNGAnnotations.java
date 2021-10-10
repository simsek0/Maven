package com.neotech.lesson01;

import org.testng.annotations.*;

public class MoreTestNGAnnotations {

	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite method");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After Suite method");
	}
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class method");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	@Test
	public void test1()
	{
		System.out.println("Test case 1 running...");
	}
	@Test
	public void test2()
	{
		System.out.println("Test case2 running...");
	}
}
