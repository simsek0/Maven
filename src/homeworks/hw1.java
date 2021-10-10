package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import utils.CommonMethods;
import utils.ConfigsReader;

public class hw1 extends CommonMethods {

	/**
	 * 
	 * 1. Open chrome browser
    2. Go to “https://opensource-demo.orangehrmlive.com/”
    3. Enter valid username
    4. Leave password field empty
    5. Verify error message with text “Password cannot be empty” is displayed.
	 */
	@BeforeMethod
	public void openBrowser()
	{
		setUp();
	}
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	@Test
	public void verifyResponse() throws Exception
	{
		WebElement username=driver.findElement(By.id("txtUsername"));
		sendText(username,ConfigsReader.getProperty("username"));
		
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password,"  ");
		
		click(driver.findElement(By.id("btnLogin")));
		
	
		WebElement response = driver.findElement(By.xpath("//div[@id='divLoginButton']/span"));

		if(response.getText().equals("Password cannot be empty"))
		{
			System.out.println("Test passed!!");
		}
		else
		{
			throw new Exception("Test failed...");
		}
	}
	
}
