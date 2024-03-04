package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class Utility  extends TestBase {
	
	public static void takeScreenShot() {
		
		System.out.println("inside screenshot method");
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("after taking screenshot");
		try {
			//Using the time date time stamp to create unique file name for the each screenshot
			System.out.println("path before");
			FileUtils.copyFile(screenshotFile, new File ("E:\\Pavani Nadupalli\\Pavani_WorkSpace\\APMT_Automation\\screenshots"+timestamp()+".png"));
			System.out.println("path after");
		}catch (IOException e) {
			e.printStackTrace();
		  
	}
	}

	public static String timestamp() {
		
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	public static WebElement waitForElementToVisible(WebElement e, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
