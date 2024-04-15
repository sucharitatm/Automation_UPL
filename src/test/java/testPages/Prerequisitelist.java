package testPages;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.observer.entity.NamedAttributeTestEntity;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.PrerequisitePageObject;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class Prerequisitelist extends TestBase {
    ExcelOperations excel = new ExcelOperations(
            System.getProperty("user.dir") + "\\src\\test\\resource\\testData\\prerequisite.xlsx", "Sheet1");
    //private HashMap<String, String> prtestdata;

public void setup() throws Exception {
    loginpage.login();
}

    @Test()
    public void addprereqdetails() throws Exception {
        loginpage.login();
        PrerequisitePageObject prerequisitePageObject = new PrerequisitePageObject();
        System.out.println("Row count: "+excel.getRowCount());
        for(int i=1;i<=excel.getRowCount();i++) {
            if(null != excel.prtestdata(i).get("Course")
                    && !"".equalsIgnoreCase(excel.prtestdata(i).get("Course")))
            prerequisitePageObject.addprereqdetails(excel.prtestdata(i));
        }
    }

   // @DataProvider(name = "getData")
    public Object[][] getTestData() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for(int i=1;i<=excel.getRowCount();i++) {
            HashMap<String, String> testData=excel.prtestdata(i);
            obj[i-1][0]=testData;
        }
        return obj;
    }

    }
