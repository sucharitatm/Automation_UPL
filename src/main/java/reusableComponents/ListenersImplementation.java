package reusableComponents;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import testBase.TestBase;

public class ListenersImplementation extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+" is Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		HashMap<String, String> testData=(HashMap<String, String>) result.getTestContext().getAttribute("mapTestData");
//		String exceptionString=result.getThrowable().toString()+testData;
		
		
//		test.generateLog(Status.FAIL, exceptionString);
		test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+" is Failed.");
		test.log(Status.FAIL,result.getThrowable());
		
		
		
		//add screenshot for failed test
		Utility.takeScreenShot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(Utility.dest," TestCase: "+result.getMethod().getMethodName()+" is Failed screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//
	}

	@Override
	public void onStart(ITestContext context) {
		// setup method call
		try {
			extent = ExtentReportSetup.setupExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// close the extent
		extent.flush();
	}

}
