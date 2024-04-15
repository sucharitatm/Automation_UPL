package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
//import pageObjects.AddUserPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PrerequisitePageObject;
//import pageObjects.RegistrationPageObject;
//import pageObjects.HomePageObjects;
//import pageObjects.LoginPageObjects;
//import pageObjects.SalesManagerObjects;
//import pageObjects.VerificationManPageObjects;
//import reusableComponents.CommonMethods;
//import pageObjects.EnterInsurantDataPageObjects;
//import pageObjects.EnterProductDataPageObjects;
//import pageObjects.EnterVehicalDataPageObjects;
//import pageObjects.HomePageObjects;
//import pageObjects.SelectPriceOptionsPageObjects;
//import pageObjects.SearchPrerequisite;
import reusableComponents.PropertiesOperations;

public class TestBase {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public LoginPageObjects loginpage;
	public PrerequisitePageObject prerequisitePage;
	//public SearchPrerequisite searchPrerequisite;
	//public RegistrationPageObject registrationpageobject;
	//public AddUserPageObjects adduserpageobjects;

	public void LaunchBrowserAndNavigate() throws Exception {

		// read prop file and get browser and url
		String browser = PropertiesOperations.getPropertyValueByKey("browser");

		String url = PropertiesOperations.getPropertyValueByKey("url");
		System.out.println(browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			 driver = new FirefoxDriver();
//		} else if(browser.equalsIgnoreCase("ie")) {
//			WebDriverManager.iedriver().setup();
//			 driver = new InternetExplorerDriver();
//		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get(url);
		Thread.sleep(1000);
	}

	@BeforeMethod /// it will get execute before each test method within current class
	public void setupMethod() throws Exception {
		LaunchBrowserAndNavigate();
		loginpage = new LoginPageObjects();
		prerequisitePage = new PrerequisitePageObject();
		//searchPrerequisite = new SearchPrerequisite();
	}
}
	/*
	@AfterMethod
	public void cleanUp() {
		 driver.quit();
	}
}
*/

