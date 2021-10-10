package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(utils.Listeners.class)

public class ListenerDemo {

	@BeforeMethod
	public void bMethod()
	{
		System.out.println("Before every method");
	}
	@Test
	public void test1()
	{
		System.out.println("this is test1");
		//making sure this method passes
		Assert.assertTrue(true);
	}
	@Test
	public void test2()
	{
		System.out.println("This is test2");
		
		//making sure this method fails
		Assert.assertTrue(false);
	}


}
