package testPages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class AddUserPage_Test extends TestBase {
	ExcelOperations excel = new ExcelOperations(
			System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\AddUser.xlsx", "Sheet1");

	@Test(dataProvider = "getData")
	public void addUser(Object obj) throws Exception {
		HashMap<String, String> testData=(HashMap<String, String>) obj;
		adduserpageobjects.addUser(testData);
		adduserpageobjects.testMessage();
		//Assert.ass
	}

	@DataProvider(name = "getData")
	public Object[][] getTestData() throws Exception {
		Object[][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testData=excel.getTestDataInMap(i);
			obj[i-1][0]=testData;
		}
		return obj;

	}
}
