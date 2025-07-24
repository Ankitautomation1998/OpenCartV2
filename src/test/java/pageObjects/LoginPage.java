package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
public class LoginPage extends BasePage {
	
	//initilizing the constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locating elements on login page
	@FindBy(xpath = "//input[@id ='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@id ='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	//method : pass email in email fild
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	//method : pass password value in the password value 
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	//method : click on login link 
	public void clkLogin()
	{
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnLogin);
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
		

		btnLogin.click();
	}
	

}
