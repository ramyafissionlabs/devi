package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fremesgl {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void handlframes() throws InterruptedException
	{
		WebElement frmaeel = driver.findElement(By.xpath("//iframe[@name='globalSqa']"));
		driver.switchTo().frame(frmaeel);
		WebElement home = driver.findElement(By.xpath("//form//input[@id='s']"));
		home.sendKeys("rs");
		driver.switchTo().defaultContent();
	}
	public void closing()
	{
		driver.quit();
	}
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		fremesgl fg = new fremesgl();
		fg.setup();
		fg.handlframes();
		fg.closing();
		

	}

}
