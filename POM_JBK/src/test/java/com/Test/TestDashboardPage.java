package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.singlePages.DashboardPage;
import com.utility.UtilityMethod;

public class TestDashboardPage extends UtilityMethod{
	
	DashboardPage dp = null;
	
	@BeforeMethod
	public void setUp()
	{
		UtilityMethod.loginToAppl("kiran@gmail.com", "123456");
		dp = new DashboardPage(driver);
	}
	
	@Test(priority = 1)
	public void verifyCourses()
	{
		dp.clickMoreInfo();
	}
	
	@Test(priority = 2)
	public void verifyMainNavigation()
	{
		dp.clickMainNavigation();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
