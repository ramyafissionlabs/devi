package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import reusable.CommonMethods;
import zmq.ZError.IOException;

public class getAttributeValues {
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
	public void getattribute()
	{
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		String attribute = dropdown.getAttribute("data-test");
		System.out.println(attribute);
		Select odropdown = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		List<WebElement> options = odropdown.getOptions();
		for(WebElement opt:options)
		{
			opt.getText();
			System.out.println(opt.getText());
			if(opt.getText().contains("Price (low to high)"))
			{
				System.out.println("Price (low to high) displayed");
				break;
			}
		}
		
	}
 public void closing()
 {
	 driver.quit();
 }

	public static void main(String[] args) throws IOException, InterruptedException, java.io.IOException {
		// TODO Auto-generated method stub
		getAttributeValues gv = new getAttributeValues();
		gv.setup();
		gv.login();
		gv.getattribute();
		gv.closing();
		
		

	}

}
