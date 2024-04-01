package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.TestBase;

public class ExtentReportSetup extends TestBase{
	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date=new Date();
		String actualDate=dateformat.format(date);
		//or
		//String currentDate=new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		String reporterPath=System.getProperty("user.dir")+"/Reports/ExecutionReport"+actualDate+".html";
		
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(reporterPath);
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		sparkreporter.config().setDocumentTitle("UPL");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("UPL_Project_Report");
		
		extent.setSystemInfo("Executed On Environment: ", PropertiesOperations.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed On Browser:", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed On OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		
		return extent;
	}
}
