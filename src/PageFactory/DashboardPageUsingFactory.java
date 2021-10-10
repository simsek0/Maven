package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class DashboardPageUsingFactory {

	@FindBy(id="welcome")
	WebElement welcome;
	
	public DashboardPageUsingFactory()
	{
		PageFactory.initElements(BaseClass.driver,this);
	}
	public String WelcomeDisplayed()
	{
		return welcome.isDisplayed() ? "Test Passed" : "Test Failed";
		
	}
 }
