package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import testBase.TestBase;

public class AddUserPageObjects extends TestBase {
	// Page Object
	@FindBy(xpath = "//button[text()='Add User']")
	WebElement addUser_Button;
	@FindBy(name = "username")
	WebElement user_name;
	@FindBy(name = "email")
	WebElement user_email;
	@FindBy(name = "password")
	WebElement user_password;
	@FindBy(name = "confirmPassword")
	WebElement user_ConfPwd;
	@FindBy(name = "phone_number")
	WebElement user_PhoneNo;
	@FindBy(xpath = "//*[@id=\"mui-component-select-roleName\"]")
	WebElement user_RollTypeField;
	@FindBy(xpath = "//*[@id=\"menu-roleName\"]/div[3]/ul/li")
	List<WebElement> user_RollList;
	@FindBy(xpath = "//button[contains(text(),'Create New User')]")
	WebElement submit_btn;
	@FindBy(xpath = "//div[contains(text(),'You have Registered Successfully')]")
	WebElement successMsg;
	@FindBy(xpath = "//div[contains(text(),'Email or phone number already exists Please TRY ag')]")
	WebElement errorMsg;

	public AddUserPageObjects() {
		PageFactory.initElements(driver, this);
	}

	// page Methods
	public void addUser(HashMap<String, String> testdata) throws InterruptedException {
		CommonMethods.click(addUser_Button);
		CommonMethods.sendKeysToElement(user_name, testdata.get("Username"));
		CommonMethods.sendKeysToElement(user_email, testdata.get("Email"));
		CommonMethods.sendKeysToElement(user_password, testdata.get("Password"));
		CommonMethods.sendKeysToElement(user_ConfPwd, testdata.get("ConfirmPassword"));
		CommonMethods.sendKeysToElement(user_PhoneNo, testdata.get("Phone Number"));
		CommonMethods.click(user_RollTypeField);
		CommonMethods.dynamicDropDown(user_RollList, testdata.get("RoleName"));
		CommonMethods.click(submit_btn);

	}

	public String testMessage() {
		if (successMsg.isDisplayed()) {
			return successMsg.getText();
		} else {
			return errorMsg.getText();
		}

	}
}
