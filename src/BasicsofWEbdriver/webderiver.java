package BasicsofWEbdriver;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import reusable.CommonMethods;
import zmq.ZError.IOException;

public class webderiver {
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
		WebElement pwd = driver.findElement(By.name("password"));
		WebElement lb = driver.findElement(By.xpath("//input[@id='login-button']"));
		pwd.sendKeys("secret_sauce");
		lb.click();
		
		Thread.sleep(10);
		CommonMethods.screenshots(driver, "afterlogin");
		//driver.quit();
	}
	
	public void logout() throws InterruptedException 
	{
		WebElement mb = driver.findElement(By.xpath("//button[text()='Open Menu']"));
		mb.click();
		
		/*WebElement lb1 = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		lb1.click();*/
	}
	public void AddtoCart() throws InterruptedException 
	{
		WebElement ad = driver.findElement(By.xpath(" //a[@id='item_4_title_link']//div"));
		ad.click();
		WebElement ad1 = driver.findElement(By.xpath(" //button[text() = 'Add to cart']"));
		ad1.click();
		Thread.sleep(4000);
		driver.navigate().back();
		//WebElement bp = driver.findElement(By.xpath(" //button[@id=\'back-to-products\']"));
		//bp.click();
		Thread.sleep(4000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.navigate().back();
		WebElement textt = driver.findElement(By.xpath("//span[text() = 'Products']"));
		String pt =textt.getText();
		System.out.println(pt);
		
		driver.navigate().to("https://www.google.com/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(url);
		System.out.println(title);
     	driver.navigate().back();
     	String source_code = driver.getPageSource();
		System.out.println(source_code);
		Thread.sleep(4000);
		//driver.findElement(By.linkText("Twitter")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]")).click();
		Thread.sleep(4000);
		driver.navigate().back();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
		
		
	}
	public void addmultiplecart() throws InterruptedException
	{
		List<WebElement> mad = driver.findElements(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory\"]"));
		for (WebElement cart:mad)
		{
			cart.click();
			Thread.sleep(3000);
		}
		
	}
	
	public void dropdowns() throws InterruptedException
	{
		//WebElement dd = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
	   Select dd = new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
		//new Select(dd).selectByIndex(3);  //select by index
		//new Select(dd).selectByValue("za"); //select by visible text
		dd.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
	}
	public void closing()
	{
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException,java.io.IOException{
		// TODO Auto-generated method stub
		webderiver wb =  new webderiver();
		wb.setup();
		//CommonMethods.screenshots(driver, "beforelogin");
		wb.login();
		wb.addmultiplecart();
		//wb.logout();
		//wb.AddtoCart();
		//wb.dropdowns();
		wb.closing();
      
		
	}

}
