package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.CommonMethods;
import utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods  {

	//
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
	public void titleValidation() throws Exception
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Title validation passed");
		}
		else
		{
			System.out.println("Title validation failed");
			throw new Exception();
		}
		wait(2);
	}
	@Test
	public void logoValidation() throws Exception
	{
		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		boolean isDisplayed = logo.isDisplayed();
		
		if(isDisplayed)
		{
			System.out.println("Logo Validation passed");
		}
		else
		{
			System.out.println("Logo Validation failed");
			throw new Exception();
		}
		wait(2);

	}
	@Test
	public void loginValidation() throws Exception
	{
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username,ConfigsReader.getProperty("username"));
		
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.id("btnLogin")));
		// Validate that Welcome Admin message is there
		// If not displayed, then the TestNG report must show it.
		WebElement text=driver.findElement(By.id("welcome"));
		
		if(text.getText().contains("Welcome"))
		{
			System.out.println("Test passed");
		}
		else
		{
			throw new Exception ("Test failed");
		}
		wait(2);
		
		
	}
}
