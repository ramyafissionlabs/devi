package reusable;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import zmq.ZError.IOException;


public class CommonMethods {

 public static void  screenshots(WebDriver driver,String screenshotname) throws InterruptedException,IOException, java.io.IOException
		{
		 File file =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file, new File("C:\\Users\\FL_LPT-475\\eclipse-workspace\\SeleniumTraining\\ScreenShots\\"+screenshotname+".png"));
		}

	}


