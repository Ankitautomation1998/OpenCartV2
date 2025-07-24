package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity" , "Master"})
	public void verify_login()
	{
		logger.info("********Starting TC_002_LoginTest*******");
		logger.info("*******capturing application level logs ***********");
		try
		{
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("********* clicking on login Link**********");
			
			hp.clickLogin();
			logger.info("********* clicking on login Link**********");
			
			//login Page
			LoginPage lp = new LoginPage(driver);
			
			lp.setEmail(p.getProperty("email"));
			logger.info("********Providing email adress *********");
			
			lp.setPassword(p.getProperty("password"));
			logger.info("********providing password**********");
			
			Thread.sleep(3000);
			
			lp.clkLogin();
			logger.info("********* clicked on login link ***********");
			
			//MyAccountPage 
			
			MyAccountPage macc = new MyAccountPage(driver);
			
			boolean targetPage = macc.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true, "Login Failed");
			
		} catch (Exception e){
			Assert.fail();
		}
		    logger.info("************ Finshed  TC_002_LoginTest ******");
	}

}
