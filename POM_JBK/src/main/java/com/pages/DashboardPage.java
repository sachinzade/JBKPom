package com.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.UtilityMethod;

public class DashboardPage extends UtilityMethod  {

	public WebDriver driver;
	//public WebElement element;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "More")
	List<WebElement> list ;
	
	@FindBy(xpath="//span[text()='kkUsers']")
	WebElement user;
	
	@FindBy(xpath = "//span[text()='Operators']")
	WebElement oper;
	
	@FindBy(xpath = "//span[text()='     Useful Links']")
	WebElement uLink;
	
	@FindBy(xpath = "//span[text()='Downloads']")
	WebElement down;
	
	@FindBy(xpath = "//span[text()='Logout']")
	WebElement log;
	
	public void clickMoreInfo()
	{
		switchToElement(list, 0, "dashboard", "Dashboerd Page");
		switchToElement(list, 4, "selenium-testing-syllabus", "Selenium Testing Syllabus page");
		switchToElement(list, 3, "java-j2ee-syllabus", "Java-J2EE Syllabus page");
		switchToElement(list, 2, "python-syllabus", "Python Syllabus Page");
		switchToElement(list, 1, "PHP", "PHP Syllabus Page");
		
	}
	
	public void clickMainNavigation()
	{
		//boolean user1 = isEnab(user);
		Assert.assertTrue(isEnab(user), "Users is not Enable");
		Assert.assertTrue(isEnab(oper), "Operator is not Enable");
		Assert.assertTrue(isEnab(uLink), "Useful Links is not Enable");
		Assert.assertTrue(isEnab(down), "Downloads is not Enable");
		Assert.assertTrue(isEnab(log), "Logout is not Enable");
	}
	
	
	
}
