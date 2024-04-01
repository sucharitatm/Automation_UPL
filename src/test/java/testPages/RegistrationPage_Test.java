package testPages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import reusableComponents.ExcelOperations;
import testBase.TestBase;
//@Listeners(ListenerClass.class)
public class RegistrationPage_Test extends TestBase{
	ExcelOperations excel=new ExcelOperations(System.getProperty("user.dir")
			+"\\src\\test\\resource\\testData\\Registration.xlsx","Sheet1");
	
	
	@Test(dataProvider = "testData")
	public void registration(Object obj, ITestContext context) throws Exception {
		//loginpage.login();
		HashMap<String, String> testData=(HashMap<String, String>) obj;
		
		context.setAttribute("mapTestData", testData);
		
		registrationpageobject.registration(testData);
		String msg=registrationpageobject.successMessage();
		Assert.assertEquals(msg, "You have submitted Successfully");
	}
	
	@DataProvider(name = "testData")
	public Object[][] getExcelTestData() throws Exception {
		Object[][] obj=new Object[excel.getRowCount()][1];
		for(int i=1;i<=excel.getRowCount();i++) {
			HashMap<String, String> testData=excel.getTestDataInMap(i);
			obj[i-1][0]=testData;
		}
		return obj;
		
	}
	
}
