package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locating myaccount element
	
	@FindBy(xpath = "//div/div/div/h2[1]")
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	// method : myaccount page heading display status
	/*
	 * why i put this on try catch block .
	 * Bcz trycatch block will catch the exception and return false . instead of
	 * terminating the execution . Bcz i am doing a datadriven test . so it will loop
	 * multiple times on same step .
	 */
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}catch (Exception e) 
		{
			return (false);
		}
	}
	
	//method : click on logout link
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	

}
