package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utility.UtilityMethod;

public class UserPage extends UtilityMethod{

	public WebDriver updriver;

	public UserPage(WebDriver driver) 
	{
		this.updriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Users']")
	WebElement user; 
	
	@FindBy(xpath = "//button[text()='Add User']")
	WebElement addUSer;
	
	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "mobile")
	WebElement mobileNumber;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "course")
	WebElement CourseNmae;

	@FindBy(xpath = "//input[@type='radio']")
	List<WebElement> gen;

	@FindBy(xpath = "//select[contains(@class, 'form-control')]")
	WebElement stat;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//*[contains(@placeholder, 'FriendMobile')]")
	WebElement friendMobile;

	@FindBy(id = "submit")
	WebElement submit;

	public void addUserInfo(String uname, String mob, String email, String course, String gender, String state, String pass, String frdMob) 
	{
		click(user);
		click(addUSer);
		sendKeys(userName, uname);
		sendKeys(mobileNumber, mob);
		sendKeys(emailId, email);
		sendKeys(CourseNmae, course);
		redioButton(gen, gender);
		redioButton(gen, gender);
		dropDewn(stat, state);
		sendKeys(password, pass);
		sendKeys(friendMobile, frdMob);
		click(submit);
		String actRsl = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expRsl = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(actRsl, expRsl);
	}
}
