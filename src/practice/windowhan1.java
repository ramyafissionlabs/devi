package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhan1 {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void windowhandling() throws InterruptedException
	{
	driver.findElement(By.xpath("//li[@id='Open New Window']"))	.click();
	String pw = driver.getWindowHandle();
	System.out.println(driver.getCurrentUrl());
	driver.findElement(By.xpath("(//div//a[text()='Click Here'])[2]")).click();
	Set<String> cw1 = driver.getWindowHandles();
	for(String c_w1:cw1)
	{
	driver.switchTo().window(c_w1);
	}
	String cw11 = driver.getWindowHandle();
	driver.findElement(By.xpath("(//div//a[@class=\"button e.g. button_hilite button_pale small_button\"])[1]")).click();
	System.out.println(driver.getCurrentUrl());
	Set<String> cw2 = driver.getWindowHandles();
    for(String c_w2:cw2)
    {
    	driver.switchTo().window(c_w2);
    }
    
    System.out.println(driver.getCurrentUrl());
    driver.close();
    Thread.sleep(2000);
    driver.switchTo().window(cw11).close();
    Thread.sleep(2000);
    driver.quit();
	}
	public void closing()
	{
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		windowhan1 wh1 = new windowhan1();
		wh1.setup();
		wh1.windowhandling();
		wh1.closing();

	}

}
