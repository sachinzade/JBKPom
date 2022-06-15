package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.UtilityMethod;


public class LogInPage {
	
	public WebDriver lpdriver;

	public LogInPage(WebDriver driver) 
	{
		this.lpdriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="img")
	private WebElement logo;
	
	@FindBy(id = "email")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(xpath = "//button")
	private WebElement logBtn;
	
	@FindBy(linkText = "LOGOUT")
	private WebElement logout;
	
	@FindBy(tagName = "b")
	private WebElement text1;
	
	@FindBy(tagName = "h4")
	private WebElement text2;
	
	@FindBy(xpath = "//*[text()='Register a new membership']")
	private WebElement register;
	
	public void jbkLogo()
	{
		boolean logo1 = UtilityMethod.isDesplayed(logo);
		Assert.assertTrue(logo1);
	}
	
	public void textOnLoginPage()
	{
		String act1 = "Java By Kiran";
		String exp1 = UtilityMethod.getText(text1);
		Assert.assertEquals(act1, exp1);
		String act2 = "JAVA | SELENIUM | PYTHON"; 
		String exp2 = UtilityMethod.getText(text2);
		Assert.assertEquals(act2, exp2);
	}
	
	public void checkEmailBox()
	{
		boolean email = UtilityMethod.isEnab(uname);
		Assert.assertTrue(email);
	}
	
	public void checkPasswordBox()
	{
		boolean password = UtilityMethod.isEnab(pass);
		Assert.assertTrue(password);
	}
	
	public void emailError()
	{
		UtilityMethod.sendKeys(uname, "");
		
	} 
	
	
	
	public void login(String userName, String password)
	{
		uname.sendKeys(userName);
		pass.sendKeys(password);
		logBtn.click();
		boolean logout1 = logout.isEnabled();
		Assert.assertTrue(logout1);
	}
	
	public RegistrationPage signIn()
	{
		register.click();
		return new RegistrationPage(lpdriver);
	}
}

