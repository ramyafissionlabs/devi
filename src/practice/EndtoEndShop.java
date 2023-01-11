package practice;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

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

public class EndtoEndShop {
	WebDriver driver ;
	public void setup()
	{
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new FirefoxDriver();
		driver.get("https://practice.automationtesting.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void register() throws InterruptedException
	{
		WebElement account = driver.findElement(By.xpath("//a[text()='My Account']"));
		account.click();
		WebElement email = driver.findElement(By.xpath("//input[@id=\"reg_email\"]"));
		email.sendKeys("test15s@yopmail.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@id=\"reg_password\"]"));
		pwd.sendKeys("test@yopmail.com");
		WebElement reg = driver.findElement(By.xpath("//input[@name=\"register\"]"));
		reg.click();
		
	}
	public void Login() throws InterruptedException, IOException, java.io.IOException
	{
		CommonMethods.screenshots(driver, "pbeforelogin");
		WebElement account = driver.findElement(By.xpath("//a[text()='My Account']"));
		account.click();
		
		WebElement lemail = driver.findElement(By.xpath("//input[@id=\'username\']"));
		lemail.sendKeys("test15s@yopmail.com");
		WebElement lpwd = driver.findElement(By.xpath("//input[@id=\'password\']"));
		lpwd.sendKeys("test@yopmail.com");
		WebElement loginn = driver.findElement(By.xpath("//input[@name=\'login\']"));
		loginn.click();
		CommonMethods.screenshots(driver, "pafterlogin");
		
	}
	public void shop() throws InterruptedException,NoSuchElementException
	{
		driver.manage().deleteAllCookies();
		WebElement shop = driver.findElement(By.xpath("//li[@class='menu-item menu-item-type-post_type menu-item-object-page']//a[text()='Shop']"));
		shop.click();
		Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,1500)");
        js.executeScript("window.scrollTo(0,2500)");
        Thread.sleep(3000);
		WebElement item  = driver.findElement(By.xpath("//a[@class='woocommerce-LoopProduct-link']//h3[text()='HTML5 WebApp Develpment']"));
		item.click();
		WebElement addtobasket = driver.findElement(By.xpath("//button[@class=\"single_add_to_cart_button button alt\"]"));
		addtobasket.click();
		Thread.sleep(3000);
		WebElement viewbsk = driver.findElement(By.xpath("//a[@class=\"button wc-forward\"]"));
		viewbsk.click();
		Thread.sleep(3000);
		WebElement qty = driver.findElement(By.xpath("//input[@class=\'input-text qty text\']"));
		if(qty != null)
		{
			WebElement updatecart = driver.findElement(By.xpath("//input[@name='update_cart']"));
			updatecart.click();
			
	        //js.executeScript("window.scrollBy(0,1500)");
	        js.executeScript("window.scrollTo(0,1000)");
			WebElement protocheck = driver.findElement(By.xpath("//a[@class=\"checkout-button button alt wc-forward\"]"));
			protocheck.click();
		}
		
	}
	public void billing() throws InterruptedException
	{
		WebElement fn = driver.findElement(By.xpath("//input[@id='billing_first_name']"));
		fn.sendKeys("Rsfg");
		WebElement ln = driver.findElement(By.xpath("//input[@id='billing_last_name']"));
		ln.sendKeys("Nsf");
		WebElement mail = driver.findElement(By.xpath("//input[@id='billing_email']"));
		mail.sendKeys("test15s@yopmail.com");
		WebElement phn = driver.findElement(By.xpath("//input[@id='billing_phone']"));
		phn.sendKeys("6767676767");
		WebElement city = driver.findElement(By.xpath("//input[@id='billing_city']"));
		city.sendKeys("Hyd");
		WebElement addres = driver.findElement(By.xpath("//input[@id='billing_address_1']"));
		addres.sendKeys("hyd");
		WebElement state = driver.findElement(By.xpath("//div[@class='select2-container state_select']"));
		state.click();
		List<WebElement> stateoption1 = driver.findElements(By.xpath("//ul[@id='select2-results-2']//li[@class=\'select2-results-dept-0 select2-result select2-result-selectable\']"));
		Random rand = new Random();
		int list= rand.nextInt(stateoption1.size());
		stateoption1.get(list).click();
		WebElement postalcode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
		postalcode.sendKeys("565656");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2400)");
		WebElement placeorder = driver.findElement(By.xpath("//input[@id='place_order']"));
		placeorder.click();
		}
	public void closing()
	{
		driver.quit();
	}

	

	public static void main(String[] args) throws InterruptedException, IOException, java.io.IOException {
		
		// TODO Auto-generated method stub
		EndtoEndShop en = new EndtoEndShop();
		en.setup();
		//en.register();
		en.Login();
		en.shop();
		en.billing();
		en.closing();
		

	}

}
