package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*********** clicked on my account link on homepage ***********");
			
			hp.clickLogin();
			logger.info("*********** clicked on login link in homepage");
			
			//login page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			logger.info("********* Providing Email address **************");
			
			lp.setPassword(password);
			logger.info("********** providing password **************");
			lp.clkLogin();
			logger.info("******* Clicked on login *************");
			
			//my account page
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage =macc.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage == true)
				{
					macc.clickLogout();
					Assert.assertTrue(true);
				}
				
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage == true)
				{
					macc.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
			
			
		}catch (Exception e)
		{
			Assert.fail("An Exception Occoured: " +e.getMessage());
		}
		
		logger.info("******Finshed ");
	}

}
