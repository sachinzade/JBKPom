package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.utility.UtilityMethod;


public class RegistrationPage extends UtilityMethod {
	
	public WebDriver driver;
	public RegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@name,'name')]")
	private WebElement name;

	@FindBy(xpath = "//*[contains(@name,'mobile')]")
	private WebElement mobile;

	@FindBy(xpath = "//*[contains(@name,'email')]")
	private WebElement email;

	@FindBy(xpath = "//*[contains(@type,'password')]")
	private WebElement password;

	@FindBy(xpath = "//*[contains(@type,'sub')]")
	private WebElement signIn;
	
	@FindBy(xpath = "//*[text()='Register a new membership']")
	private WebElement register;
	
	@FindBy(xpath = "//a[text()='I already have a membership']")
	private WebElement alreadyMember;
	
	public void newRegister(String nam, String mobil, String email1, String passw) 
	{
		click(register);
		sendKeys(name, nam);
		sendKeys(mobile, mobil);
		sendKeys(email, email1);
		sendKeys(password, passw);
		click(signIn);
		String act = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String exp = "User registered successfully.";
		Assert.assertEquals(act, exp);
		
	}
	
	public void backtoLoginPage()
	{
		click(register);
		click(alreadyMember);
		String act = getTitle();
		String exp = "JavaByKiran | Log in";
		Assert.assertEquals(act, exp);
		
	}

}
