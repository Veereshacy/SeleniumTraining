package SeleniumPro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class StaticDropDown {
	static WebDriver driver;

	@Test
	@Parameters("browser")
	public void testHDFCLink(String browserName) throws InterruptedException
	{
		if(browserName.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.contentEquals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src/test/resources/Drivers/IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
		}
		else if(browserName.contentEquals("firfox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
	
		WebElement accounts=driver.findElement(By.xpath("//li[contains(text(),'Accounts')]"));
		//Without clicking on selection action we can intract with the elelmts - invisible elemets
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("alert('welcome');alert('hello')");
		js.executeScript("arguments[0].click()", new Object[] {accounts});
		//js.executeScript("document.getElementById('chatTogglerImg').click()");

	}
}
