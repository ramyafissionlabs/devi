package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import reusable.CommonMethods;
import zmq.ZError.IOException;

public class keyboardkeys {
	WebDriver driver;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	public void login() throws InterruptedException, IOException, java.io.IOException
	{
		CommonMethods.screenshots(driver, "beforelogin");
		WebElement  uname = driver.findElement(By.id("user-name"));
		uname.clear();
		uname.sendKeys("standard_user");
		//WebElement pwd = driver.findElement(By.name("password"));
		//pwd.sendKeys("secret_sauce");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys("secret_sauce").build().perform();
		
		//WebElement lb = driver.findElement(By.xpath("//input[@id='login-button']"));
		//lb.click();
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(10);
		CommonMethods.screenshots(driver, "afterlogin");
		//driver.quit();
	}
 public void closing()
 {
	 driver.quit();
 }
	public static void main(String[] args) throws IOException, InterruptedException, java.io.IOException {
		// TODO Auto-generated method stub
		keyboardkeys kk = new keyboardkeys();
		kk.setup();
		kk.login();
		kk.closing();
		
      }
}
