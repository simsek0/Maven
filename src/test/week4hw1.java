package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;
import utils.ConfigsReader;

public class week4hw1 extends CommonMethods {

	@Test
	public void validLogin()
	{
		LoginPageUsingFactory login = new LoginPageUsingFactory();
		
		sendText(login.username,ConfigsReader.getProperty("username"));
		wait(1);
		
		sendText(login.password,ConfigsReader.getProperty("password"));
		wait(1);
		
		jsClick(login.loginBtn);
		
		boolean displayed=login.welcomeMsg.isDisplayed();
		
		//hard assertion
		Assert.assertTrue(displayed,"Welcome message is not displayed");
		
		
	}
	
}
