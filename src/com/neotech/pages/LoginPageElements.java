package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;
import utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='mainMenu']/ul/li[2]/a/b")
	public WebElement pim;
	
	@FindBy(id="btnAdd")
	public WebElement addButton;
	
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empList;
	
	@FindBy(id="user_name")
	public WebElement user_name;
	
	@FindBy(id="user_password")
	public WebElement user_password;
	
	@FindBy(id="re_password")
	public WebElement user_password2;
	
	@FindBy(id="chkLogin")
	public WebElement pinButtonDetails;


	public LoginPageElements()
	{
		 PageFactory.initElements(BaseClass.driver, this);
	}
}
