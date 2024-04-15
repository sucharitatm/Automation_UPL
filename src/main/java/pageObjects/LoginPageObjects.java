package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import reusableComponents.PropertiesOperations;
import testBase.TestBase;

public class LoginPageObjects extends TestBase {

    // UPL
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement login;

    @FindBy(xpath = "//input[@name='identifier'] ")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='LOGIN']")
    WebElement loginbtn;

    @FindBy(xpath = "//div[contains(text(),'You have successfully LoggedIn')]") WebElement successMsg;




    // constructor - to use initElement method
    public LoginPageObjects() {
        PageFactory.initElements(driver, this);
    }

    public boolean login() throws Exception {
        //System.out.println(driver);
        login.click();
        Thread.sleep(2000);
        CommonMethods.sendKeysToElement(username, PropertiesOperations.getPropertyValueByKey("username"));
        Thread.sleep(2000);
        CommonMethods.sendKeysToElement(password, PropertiesOperations.getPropertyValueByKey("password"));
        Thread.sleep(2000);
        loginbtn.click();
        Thread.sleep(1000);

        return successMsg.isDisplayed();
    }

    public String loginPageTitle() {
        return driver.getTitle();
    }
}
