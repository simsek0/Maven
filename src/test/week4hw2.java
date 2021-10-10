package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;
import utils.ConfigsReader;

public class week4hw2 extends CommonMethods {

	@Test
	public void emptyPasswordLogin()
	{
		/**
		 * Open Chrome browser
		Go to https://opensource-demo.orangehrmlive.com/
		Enter valid username and leave password field empty
		Click on login button
		Verify error message with text "Password cannot be empty" is displayed.
		Quit the browser
		 */
		LoginPageUsingFactory login =new LoginPageUsingFactory();
		sendText(login.username,ConfigsReader.getProperty("username"));
		
		sendText(login.password,"");
		
		jsClick(login.loginBtn);
		
		wait(1);
		
		boolean message=login.loginMessage.getText().equals("Password cannot be empty");

		Assert.assertTrue(message,"Message does not match");
		}
}
