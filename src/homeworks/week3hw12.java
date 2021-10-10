package homeworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageFactory.LoginPageUsingFactory;
import utils.CommonMethods;
import utils.ConfigsReader;

public class week3hw12 extends CommonMethods{

	@BeforeMethod()
	public void openAndNavigate()
	{
		setUp();
	}
	
	@Test(dataProvider="getData")
	public void addEmployee(String fName,String lName,String uName,String password) throws IOException
	{
		LoginPageUsingFactory login=new LoginPageUsingFactory();

		//login to the website
		sendText(login.username,ConfigsReader.getProperty("username"));
		sendText(login.password,ConfigsReader.getProperty("password"));
		
		click(login.loginBtn);
		wait(3);
		
		
		click(login.pim);
		
		click(login.addButton);
		
		sendText(login.firstName,fName);
		sendText(login.lastName,lName);
		
		click(login.pinButtonDetails);
		
		wait(1);
		
		sendText(login.user_name,uName);
		sendText(login.user_password,password);
		sendText(login.user_password2,password);
		
		click(login.saveBtn);
		
		Actions action = new Actions(driver);
		wait(2);
		action.moveToElement(login.pim);
		click(login.empList);
		
		int size=driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr")).size();
		
		boolean inTheList=false;
		
		for(int i=1;i<=size;i++)
		{
			WebElement element=driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr["+i+"]"));
			String str=element.getText();
			if(str.contains(fName+" "+lName))
			{
				inTheList=true;
				scrollToElement(element);
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].style.backgroundColor='3px solid red'",element);
				TakesScreenshot scrShot=(TakesScreenshot)driver;
				
				File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("C:/Users/18329/Desktop/SeleniumSS/SS"+fName+".png"));
				
			}
		}
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertTrue(inTheList,fName+" "+lName+" is not present");
		sAssert.assertAll();
		
		
	}
	
	
	
	@DataProvider
	public Object getData () throws IOException
	{
		//I am going to get the data from excel file
		Object[][] data;
		String filePath="C:/Users/18329/Desktop/excelhw3.xlsx";
		FileInputStream fis = new FileInputStream(filePath);

		Workbook b = new XSSFWorkbook(fis);
		Sheet s = b.getSheetAt(0);
		
		int rows=s.getPhysicalNumberOfRows();
		
		int cols=s.getRow(0).getLastCellNum();
		
		String [][] arr=new String[rows][cols];
		for(int row= 0;row<rows;row++)
		{
		
			for(int col=0;col<cols;col++)
			{
				arr[row][col]=s.getRow(row).getCell(col).toString();
			}
		}
		data=arr;
		return data;
	}
	@AfterMethod()
	public void quitBrowser()
	{
		tearDown();
	}
}
