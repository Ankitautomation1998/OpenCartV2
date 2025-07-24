package testBase;
/*
 * Why i put all groups tag in both setup and teardown method?
 * Because everytime we execute a test case the setup method and teardown method will execute whether the test case belongs
  to any of these groups .
 -Although group name can be anything.
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
/* In BaseClass we store all the reusable methods.
 * and reuse  those methods in the textcase by extending this class(inheritance).
 * by doing this we can avoid duplication.
 */
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {
 static public  WebDriver driver;
    public Logger logger;
    public Properties p;
	
    
    @BeforeClass(groups = {"Master", "Sanity", "Regression"})
    @Parameters({"os", "browser"})
	public void setup( String os, String br) throws IOException
	{
    	
    	//Loading properties file 
    	FileReader file = new FileReader(".//src//test//resources/config.properties");
    	p = new Properties();
    	p.load(file);
    	
    	logger = LogManager.getLogger(this.getClass());
    	
    	
    	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
    	{
    		DesiredCapabilities capabilities = new DesiredCapabilities();
    		
    		//for selecting the os 
    		if(os.equalsIgnoreCase("windows"))
    		{
    			capabilities.setPlatform(Platform.WIN11);
    		}
    		else if(os.equalsIgnoreCase("mac"))
    		{
    			capabilities.setPlatform(Platform.MAC);
    		}
    		else
    		{
    			System.out.println("No matching os");
    		return;
    		}
    	}
    	
    	//for browser
    	
    	switch(br.toLowerCase())
    	{
    	case "chrome" : driver = new ChromeDriver(); break;
    	case "edge"   : driver = new EdgeDriver(); break;
    	case "firefox": driver = new FirefoxDriver(); break;
    	default : System.out.println("invalid browser name"); return;
    	}
    	
    	
    	
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
    
    @AfterClass(groups = {"Master", "Sanity", "Regression"})
    public void tearDown()
    {
    	driver.quit();
    }
    
    public String randomString()
    {
    	String generatedString = RandomStringUtils.randomAlphabetic(5);
    	return generatedString;
    }
    
    public String randomNumber()
    {
    	String generatedNumber= RandomStringUtils.randomNumeric(10);
    	return generatedNumber;
    }
    
    public String randomAlphaNumeric()
    {
    	String randomStr=RandomStringUtils.randomAlphabetic(3);
    	String generatedNum= RandomStringUtils.randomNumeric(4);
    	return (randomStr+"@"+generatedNum);
    	
    }
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
