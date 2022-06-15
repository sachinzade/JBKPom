package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pages.RegistrationPage;
import com.utility.UtilityMethod;

public class TestRegistrationPage extends UtilityMethod {
	
	public RegistrationPage rp = null;

	@BeforeMethod
	public void setUp()
	{
		UtilityMethod.initializeBrowser();
		rp = new RegistrationPage(driver);
		
	}
	@DataProvider
	public Object[][] getRegistrationData()
	{
		Object data[][] = UtilityMethod.getTestData("Sheet2");
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getRegistrationData")
	public void verifyUserRegistration(String name, String mobile, String email, String pass)
	{
		rp.newRegister(name, mobile, email, pass);

	}
	
	@Test(priority=2)
	public void verifyLinkToBackLoginPage()
	{
		rp.backtoLoginPage();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}
	
	
}
