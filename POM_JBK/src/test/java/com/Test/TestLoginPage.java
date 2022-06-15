package com.Test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.singlePages.LogInPage;
import com.utilities.UtilityMethods;

public class TestLoginPage extends UtilityMethods
{
	public LogInPage lp = null;
	
	@BeforeMethod
	public void setUp()
	{
		UtilityMethods.initializeBrowser();
		lp = new LogInPage(driver);
	}
	
	
	
	@Test(priority=1)
	public void verifyLogo()
	{
		lp.jbkLogo();
	}
	
	@Test(priority=2)
	public void verifyTextOnPage()
	{
		lp.textOnLoginPage();
	}
	
	
	@Test(priority=3)
	public void verifyEmailBox()
	{
		lp.checkEmailBox();
	}
	
	@Test(priority=4)
	public void verifyPasswordBox()
	{
		lp.checkPasswordBox();
	}
	
	@Test(priority=5)
	public void verifyLogIn()
	{
		lp.login("kiran@gmail.com", "123456");
	}
	
	/*@DataProvider
	public Object[][] getRegistrationData()
	{
		Object data[][] = UtilityMethods.getTestData("Sheet2");
		return data;
	}
	
	
	@Test(priority=3, dataProvider="getRegistrationData")
	public void verifyUserRegistration(String name, String mobile, String email, String pass)
	{
		lp.signIn();
		rp.newRegister(name, mobile, email, pass);
		String actRsl = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expRsl = "User registered successfully.";
		Assert.assertEquals(actRsl, expRsl);
	}*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
