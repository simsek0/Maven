package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.CommonMethods;
import utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods{

	//Open Application
	//Verify logo is displayed
	//Enter valid credentials
	//Verify user successfully logged in by verifying welcome msg

	@BeforeMethod
	public void openAndNavigate()
	{
		setUp();
	}
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	@Test
	public void logoAndWelcomeValidation()
	{
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		boolean logoDisplayed=logo.isDisplayed();
		
		//I am manually setting this variable to false,to fail to test
		logoDisplayed=false;
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed,"Logo is not displayed!");
		
		driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
		driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
		
		
		boolean msgDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		soft.assertTrue(msgDisplayed,"Welcome msg not displayed");
	
		//This will collect all soft test assertions
		//and will decide if test case passed or failed
		
		soft.assertAll();
		
		//If test case failed,execution will stop after assertAll
		//and will decide if teste case passes or fail
		System.out.println("After assertAll");
	}

}
