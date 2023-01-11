package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class handlingAlerts {
	private static final Duration WAIT_IN_SECONDS = null;
	WebDriver driver;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void handlealerts() throws InterruptedException
	{
		//Alert OK
		WebElement dis_al1 = driver.findElement(By.xpath("//div[@id='OKTab']"));
		dis_al1.click();
		Alert alert = driver.switchTo().alert();
		//Thread.sleep(2000);
		String al_t = alert.getText();
		System.out.println(al_t);
		alert.accept();
		WebElement dis_al2b = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
		dis_al2b.click();
		
		//Alert OK or Cancel
		WebElement dis_al2 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		dis_al2.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		//alert2.dismiss();
		alert2.accept();
		WebElement text_web = driver.findElement(By.xpath("//p[@id='demo']"));
		String text_w = text_web.getText();
		Thread.sleep(2000);
		System.out.println("Text is:"+text_w);
	
		//Alert with text
		driver.navigate().to("https://nxtgenaiacademy.com/alertandpopup/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,1500)");
        js.executeScript("window.scrollTo(0,2500)");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Prompt Alert Box']")).click();
	    driver.switchTo().alert().sendKeys("yes");
		driver.switchTo().alert().accept();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.switchTo().alert().sendKeys("ram");
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		String text_t = (driver.findElement(By.xpath("//p[@id='demo1']")).getText());
		System.out.println(text_t+":is contains enter text:"+text_t.contains("ram"));
		
		}
	public void closing()
	{
		driver.quit();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		handlingAlerts ha = new handlingAlerts();
		ha.setup();
		ha.handlealerts();
		ha.closing();

	}

}
