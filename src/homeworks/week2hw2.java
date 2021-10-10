package homeworks;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.CommonMethods;
import utils.ConfigsReader;

public class week2hw2 extends CommonMethods {

	/**
	 * Open chrome browser
    Go to “https://opensource-demo.orangehrmlive.com”
    Login into the application
    Click on Add Employee
    Verify labels: Full Name, Employee Id, Photograph are displayed
    Provide Employee First and Last Name
    Add a picture to the profile
    Verify Employee has been added successfully
    Close the browser
	 */
	@BeforeMethod 
	public void openBrowser()
	{
		setUp();
	}
	@Test(priority=0)
	public void login()
	{
		
		//Login into the application
		WebElement loginBar = driver.findElement(By.id("txtUsername"));
		WebElement password=driver.findElement(By.id("txtPassword"));
		WebElement lgnBtn=driver.findElement(By.id("btnLogin"));
		sendText(loginBar,ConfigsReader.getProperty("username"));
		
		sendText(password,ConfigsReader.getProperty("password"));
		
		click(lgnBtn);
		
		//Click on add Employee
		WebElement pim=driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b"));
		
		click(pim);		
		wait(2);
		WebElement addEmp = driver.findElement(By.id("menu_pim_addEmployee"));
		
		click(addEmp);
		
		//verify labels: Full Name, Employee Id, Photograph are displayed
		SoftAssert soft = new SoftAssert();

		WebElement name=driver.findElement(By.id("firstName"));
		soft.assertTrue(name.isDisplayed(),"name is not displayed");
		
		WebElement lastName=driver.findElement(By.id("lastName"));
		soft.assertTrue(lastName.isDisplayed(),"last Name is not displayed");
		
		WebElement id=driver.findElement(By.id("employeeId"));
		soft.assertTrue(id.isDisplayed(),"id is not displayed");
	
		
		//now send keys
		sendText(name,"Mufasa");
		sendText(lastName,"Simsek");
		
		//add a picture to the profile
	
		WebElement pic= driver.findElement(By.id("photofile"));
		sendText(pic,"C:/Users/18329/Desktop/charmender.png");
		
		
		wait(2);
		
		WebElement saveBtn=driver.findElement(By.id("btnSave"));
		
		click(saveBtn);
		

		Actions action = new Actions(driver);
		action.moveToElement(pim);
		
		WebElement empList=driver.findElement(By.id("menu_pim_viewEmployeeList"));
		
		click(empList);
		
		//verify Mufasa Simsek is here
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@id='tableWrapper']/table/tbody/tr"));
		Iterator <WebElement> it=list.iterator();
		System.out.println(list.size());
		boolean MufasaIsHere=false;
		while(it.hasNext())
		{
			String str=it.next().getText();
		
			if(str.contains("Mufasa Simsek"))
			{
				MufasaIsHere=true;
				break;
			}
		}
		soft.assertTrue(MufasaIsHere,"Mufasa Is not on the list...");
		
		
		//This will collect all soft test assertions
		//and will decide if test case passed or failed
		soft.assertAll();
	}
	
	
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
}
