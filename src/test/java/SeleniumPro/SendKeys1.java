package SeleniumPro;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendKeys1 {
	@Test
	public void testHDFCLink() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/?dxid=Cj0KCQiA-4nuBRCnARIsAHwyuPq1vEjh0WXW1IbA9YVWPNHMoEWBaoZpVLDatWZAxSU2H4TMcpETnyUaAgYdEALw_wcB&gclid=Cj0KCQiA-4nuBRCnARIsAHwyuPq1vEjh0WXW1IbA9YVWPNHMoEWBaoZpVLDatWZAxSU2H4TMcpETnyUaAgYdEALw_wcB");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement fromcity=driver.findElement(By.id("FromTag"));
		
		Actions act1=new Actions(driver);
		//act1.sendKeys(fromcity, "hyd").pause(3000).sendKeys(Keys.ENTER).perform();
		act1.keyDown(fromcity, Keys.SHIFT).sendKeys("hyd").pause(3000).sendKeys(Keys.ENTER).perform();
		
	   WebElement toCity=driver.findElement(By.id("ToTag"));
	   toCity.sendKeys("ban");
	   //Thread.sleep(5000);
	   //Instead of sleep, we are using web wait 
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	   wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("ui-id-2"), By.className("list")));
	   WebElement ul=driver.findElement(By.id("ui-id-2"));
	   //List - import from UTL
	   //list add bcz we r searching in unorder list , not in web.
	   //findElements - list contains more than 1.
	   List<WebElement> li=ul.findElements(By.tagName("li"));
	   Assert.assertEquals(li.size(), 10);
	   for(WebElement e:li)
	   
	   {
		   
		   if(e.getText().contains("BKK"))
		   {
			   e.click();
			   break;
		   }
	   }
	   
	   
	
	}

}
