package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousehoveractions {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void mousehover() 
	{
		WebElement spicc = driver.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-le9fof r-1otgn73'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(spicc).build().perform();
		WebElement cred = driver.findElement(By.xpath("//div[text()='Credit Cards']"));
		cred.click();
		
		
	}
	public void closing()
	{
		driver.quit();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mousehoveractions ma = new mousehoveractions();
		ma.setup();
		ma.mousehover();
		//ma.closing();
		

	}

}
