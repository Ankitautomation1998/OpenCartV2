package pageObjects;

/*
 * Base page contains only constructor.
 * Instead of writing constructo again and again in the text methods we write the inside the basepage .
 * Whenever required , we extend them to textcases.(Inheritance)
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class BasePage {
WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
