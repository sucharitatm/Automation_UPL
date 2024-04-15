package testPages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

import java.util.HashMap;

public class test extends TestBase {
    ExcelOperations excel = new ExcelOperations(
            System.getProperty("user.dir") + "\\src\\test\\resource\\testData\\prerequisite.xlsx", "Sheet1");
    private java.util.HashMap<String, String> HashMap;


    @Test(dataProvider = "getData")
    public void addprereqdetails(Object[] obj) throws Exception {
        System.out.println(obj);

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