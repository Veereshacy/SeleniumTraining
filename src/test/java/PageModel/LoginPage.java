package PageModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	@FindBy(how = How.ID,using = "Password")
	WebElement password;
	@FindBy(how = How.XPATH,using = "//input[@value='Log in']")
	WebElement loginbutton;
	@FindBy(how = How.LINK_TEXT,using = "Log out")
	WebElement logout;

	public void sendLoginInfo()
	{
		email.sendKeys("askmail@email.com");
		password.sendKeys("abc123");
		loginbutton.click();
	}
	public void logout()
	{
		logout.click();
	}
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
}
