package com.neotech.lesson03;

import org.testng.annotations.Test;

public class GroupsDemo {

	@Test(groups="smoke")
	public void test1()
	{
		System.out.println("Inside test1 method");
	}
	
	@Test(groups = {"regression","smoke","sanity"})
	public void test2()
	{
		System.out.println("Inside test2 method");
	}
	
	@Test(groups= "sanity")
	public void test3()
	{
		System.out.println("Inside test3 method");
	}
	
	@Test(groups= {"smoke","broken"})
	public void test4()
	{
		System.out.println("Inside test4 method");
	}
	
}

