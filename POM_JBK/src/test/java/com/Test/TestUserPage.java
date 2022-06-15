package com.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pages.UserPage;
import com.utility.UtilityMethod;


public class TestUserPage extends UtilityMethod {

	UserPage up = null;
	
	@BeforeMethod
	public void setUp()
	{
		UtilityMethod.loginToAppl("kiran@gmail.com", "123456");
		up = new UserPage(driver);
	}
	
	@DataProvider
	public Object[][]getUserData()
	{
		Object data[][] = UtilityMethod.getTestData("Sheet4");
		return data;
	}
	
	@Test(dataProvider="getUserData")
	public void verifyAddUser(String username, String mobi, String email1, String course1, String gender1, String state1, String pass1, String frdMob1)
	{
		up.addUserInfo(username, mobi, email1, course1, gender1, state1, pass1, frdMob1);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
