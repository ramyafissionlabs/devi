package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileupload {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://www.monsterindia.com/seeker/registration");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void upload() throws InterruptedException
	{
	WebElement cv = driver.findElement(By.xpath("//input[@id='file-upload']"));
	cv.sendKeys("C:\\Users\\FL_LPT-475\\Downloads\\up_file.txt");
	Thread.sleep(2000);
	}
	public void closing()
	{
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		fileupload fv = new fileupload();
		fv.setup();
		fv.upload();
		fv.closing();

	}

}
