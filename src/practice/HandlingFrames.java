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

public class HandlingFrames {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void handlframes() throws InterruptedException
	{
	WebElement f_webele = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
	driver.switchTo().frame(f_webele);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tr");
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
    WebElement n1 = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
    driver.switchTo().frame(n1);
    WebElement n2 = driver.findElement(By.xpath("//div[@class='iframe-container']//iframe"));
    driver.switchTo().frame(n2);
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//div[@class='col-xs-6 col-xs-offset-5']//input[@type='text'])")).sendKeys("RS");
    Thread.sleep(2000);
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//li//a[text()='Home']")).click();
    Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("RE");
	}
	
	public  void  closing()
	{
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		HandlingFrames hf = new HandlingFrames();
		hf.setup();
		hf.handlframes();
		hf.closing();

	}

}
