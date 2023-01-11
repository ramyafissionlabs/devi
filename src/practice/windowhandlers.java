package practice;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import reusable.CommonMethods;
import zmq.ZError.IOException;

public class windowhandlers 
{
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void Login() throws InterruptedException, IOException, java.io.IOException
	{
		
		CommonMethods.screenshots(driver, "kbeforelogin");
		WebElement  uname = driver.findElement(By.id("user-name"));
		uname.clear();
		uname.sendKeys("standard_user");
		WebElement pwd = driver.findElement(By.name("password"));
		WebElement lb = driver.findElement(By.xpath("//input[@id='login-button']"));
		pwd.sendKeys("secret_sauce");
		lb.click();
		
		Thread.sleep(10);
		CommonMethods.screenshots(driver, "kafterlogin");
		
	}
	public void windowhandles() throws InterruptedException
	{
		String p_win = driver.getWindowHandle();
		System.out.println(p_win);
		System.out.println(driver.getTitle());
		
		WebElement t_ele = driver.findElement(By.xpath("//li[@class='social_twitter']//a"));
		t_ele.click();
		Set<String> twin = driver.getWindowHandles();
		for(String t_win:twin)
		{
			driver.switchTo().window(t_win);
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(p_win);
		WebElement f_ele = driver.findElement(By.xpath("//li[@class='social_facebook']//a"));
		f_ele.click();
		Set<String> fwin1 = driver.getWindowHandles();
		for(String f_win:fwin1)
		{
			driver.switchTo().window(f_win);
		}
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(p_win);
		WebElement l_ele = driver.findElement(By.xpath("//li[@class='social_linkedin']//a"));
		l_ele.click();
		Set<String> lwin2 = driver.getWindowHandles();
		for(String l_win:lwin2)
		{
		driver.switchTo().window(l_win);
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		Thread.sleep(2000);
	    driver.switchTo().window(p_win);
		driver.close();
		}
	public void closing()
	{
		driver.quit();
	}

	

	public static void main(String[] args) throws InterruptedException, IOException, java.io.IOException 
	{
		// TODO Auto-generated method stub
		windowhandlers wh =new windowhandlers();
		wh.setup();
		wh.Login();
		wh.windowhandles();
		//wh.closing();
		

	}
	}
	


