package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	
	public static WebDriver driver;
	
	/**
	 * this method returns to a webdriver
	 * 
	 * @return driver
	 */
	@BeforeMethod(alwaysRun=true)
	public static WebDriver setUp()
	{
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		switch(ConfigsReader.getProperty("browser").toLowerCase())
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
				driver=new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_PATH);
				driver=new FirefoxDriver();
				break;
		
			default:
				throw new RuntimeException("Browser is not supported!");
		}
		
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		return driver;
	
	}
	
	/**
	 * this method quits the browser
	 * @throws InterruptedException 
	 */
	@AfterMethod(alwaysRun=true)
	public static void tearDown() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver !=null)
		{
			driver.quit();
		}
	}
}
