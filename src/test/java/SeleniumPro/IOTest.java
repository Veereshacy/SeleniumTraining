package SeleniumPro;




	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStream;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class IOTest {
		static WebDriver driver;
		public static void testExcelData() throws IOException
		{
			File file=new File("src/test/resources/testdata/Book1.xlsx");
			try {
				InputStream is=new FileInputStream(file);
				XSSFWorkbook workbook=new XSSFWorkbook(is);
				XSSFSheet sheet1=workbook.getSheet("Sheet1");
				for(int i=1;i<=sheet1.getLastRowNum();i++)
				{
					String username=sheet1.getRow(i).getCell(0).getStringCellValue();
					String password=sheet1.getRow(i).getCell(1).getStringCellValue();
					testLoginInfo(username, password);
					/*
					 * for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++) {
					 * System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue()); }
					 * System.out.println("");
					 */
				}
				workbook.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		public void testLogin() throws IOException {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://demowebshop.tricentis.com/login");
			driver.manage().window().maximize();
			testExcelData();
		}

		public static void testLoginInfo(String email,String password)
		{
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.cssSelector("input[value='Log in']")).click();
			Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
			driver.findElement(By.linkText("Log out")).click();
			driver.findElement(By.linkText("Log in")).click();
		}

	}

