package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;
import utils.ConfigsReader;

public class week4hw3 extends CommonMethods {

	/**
	 * Open Chrome browser
Go to https://opensource-demo.orangehrmlive.com/
Enter valid username and invalid password
Click on login button
Verify error message with text "Invalid credentials" is displayed
Quit the browser
	 */
	
	@Test	
	public void invalidPasswordLogin() {
	LoginPageUsingFactory login = new LoginPageUsingFactory();
	sendText(login.username,ConfigsReader.getProperty("username"));
	sendText(login.password,"Invalid");
	
	click(login.loginBtn);
	
	wait(1);
	
	boolean msg=login.loginMessage.getText().equals("Invalid credentials");
	
	Assert.assertTrue(msg,"Does not match");
	}
	
}