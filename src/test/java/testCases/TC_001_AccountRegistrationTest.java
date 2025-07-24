package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = {"Regression" , "Master"})
	public void verifyAccountRegistration()
	{
		logger.info("********Starting account rrgistration test ***************");
		try
		{
		HomePage hp = new HomePage(driver);
		logger.info("**********clicking on my account link ********************");
		hp.clickMyAccount();
		logger.info("***********clicked on resisterd link*************");
		hp.clickRegister();
		
		AccountRegistrationPage ap = new AccountRegistrationPage(driver);
		logger.info("**************providing customer details***************");
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		
		ap.setEmail(randomString()+"@gmail.com");
		
		String password=randomAlphaNumeric();
		ap.setPassword(password);
		ap.setConfirmPassword(password);
		
		ap.setTelephone(randomNumber());
		
		ap.setPrivacyPolicy();
		ap.clickContinue();
		
		logger.info("******Validating confirmation message********");
		Assert.assertEquals(ap.getConfirmationMsg(), "Your Account Has Been Created!");
		
		logger.info("Test passed");
		}
		catch(Exception e)
		{
			logger.error("Test failed:" + e.getMessage());
			Assert.fail("Test failed:" +e.getMessage());
		}
		finally
		{
			logger.info("******* finshed test case*********");
		}
		
		
		
	}

}
