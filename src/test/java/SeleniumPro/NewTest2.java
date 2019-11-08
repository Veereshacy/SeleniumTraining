package SeleniumPro;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest2 {
	
	 @Test
		public void testHDFCLink() throws InterruptedException
		{
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
			driver.manage().window().maximize();
			
		
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Thread.sleep(6000);
			WebElement from=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
			WebElement to=driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));
			//js.executeScript("arguments[0].scrollIntoView();", Element);
			
			Actions act1=new Actions(driver);
			//act1.clickAndHold(from).pause(2000).release(to).perform();
			act1.dragAndDrop(from, to).perform();
		
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
			
			//Thread.sleep(6000);
			
			String priceMessage=driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
			System.out.println(priceMessage);
			Assert.assertTrue(priceMessage.contains("$3999"));
		}

}
