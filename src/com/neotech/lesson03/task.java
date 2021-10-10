package com.neotech.lesson03;
//Mufasa Simsek
//10/5/2021

import org.testng.annotations.*;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;
import utils.ConfigsReader;

public class task extends CommonMethods {

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
	public void addEmp(String name,String lName)
	{
		LoginPageUsingFactory login= new LoginPageUsingFactory();

		sendText(login.username,ConfigsReader.getProperty("username"));
		
		sendText(login.password,ConfigsReader.getProperty("password"));
		
		click(login.loginBtn);
		
		click(login.pim);
		
		click(login.addButton);
		
		sendText(login.firstName,name);
		sendText(login.lastName,lName);
		
		click(login.saveBtn);
		
		wait(2);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] credentials=
			{
					{"Linus","Torvalds"},
					{"Albert Elion","Einstein"},
					{"Lebron","James"}
					};
	return credentials;
	}
}
