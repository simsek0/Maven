package com.neotech.lesson03;

import org.testng.annotations.*;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;

public class DataProviderDemo extends CommonMethods{

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
	@Test(dataProvider="getData")
	public void LoginFunctionality(String username1,String password1)
	{
		LoginPageUsingFactory login= new LoginPageUsingFactory();

		sendText(login.username,username1);
		
		sendText(login.password,password1);
		
		click(login.loginBtn);
	}
	@DataProvider
	public Object[][] getData()
	{
	/*	Object[][] credentials=
			{
					{"Admin","admin123"},
					{"Flori","Ediram123"},
					{"Mufasas","Simsek"}
					};
	return credentials;
/
 * 
 */
		Object[][] credentials;
		String arr [][] ={
				{"Admin","admin123"},
				{"Flori","Ediram123"},
				{"Mufasas","Simsek"}
				};
		credentials=arr;	
	return credentials;
	}
}

