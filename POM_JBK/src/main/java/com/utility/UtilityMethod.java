package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UtilityMethod {

	public static WebDriver driver;
	// public static WebElement element = null;

	public static void initializeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(PropertiesUtility.readProperties("url"));
		driver.manage().window().maximize();
	}

	public static void loginToAppl(String uname, String pass) {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(PropertiesUtility.readProperties("url"));
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button")).click();
		driver.manage().window().maximize();
	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static String getText(WebElement element) {
		return element.getText();
	}
	
	public static String getTitle()
	{
		return driver.getTitle();
	}
	
	public static boolean isDesplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean isEnab(WebElement element) {
		return element.isEnabled();
	}

	public static void dropDewn(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public static void redioButton(List<WebElement> element, String value)
	{
		List<WebElement> RadioButt = element;
		// selecting the Radio buttons by Name

		int Size = RadioButt.size();// finding the number of Radio buttons

		for (int i = 0; i < Size; i++)// starts the loop from first Radio button  to the last one
		{
			String val = RadioButt.get(i).getAttribute("value");
			// Radio button name stored to the string variable, using 'Value'
			// attribute
			if (val.equalsIgnoreCase(value))// equalsIgnoreCase is ignore case(upper/lower)case(upper/lower)
			{ 
				// selecting the Radio button if its value is same as that we are looking for
				RadioButt.get(i).click();
				break;
			}
		}
	}
	

	public static void switchToElement(List<WebElement> elements , int index, String  act, String msg)
	{
		String mainWin = driver.getWindowHandle();
		for (WebElement element : elements)
		{
			click(element);
		}
		driver.switchTo().window(mainWin);
		Set<String> childs = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(childs);

		driver.switchTo().window(al.get(index));
		String url0 = driver.getCurrentUrl();
		System.out.println("url0" + url0);
		Assert.assertTrue(url0.contains(act), msg);
		driver.close();

	}
	public static String sheetPath = "D:/JAVA/HandsOnSession/POMEx/LoginTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
		DataFormatter df = new DataFormatter();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell cell = sheet.getRow(i + 1).getCell(j);
				data[i][j] = df.formatCellValue(cell);
			}
		}
		return data;
	}

	public static String takeScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + name + ".jpg";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
