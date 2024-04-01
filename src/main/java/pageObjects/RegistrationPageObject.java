package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import reusableComponents.Utility;
import testBase.TestBase;

public class RegistrationPageObject extends TestBase{
		//Page Objects
	
		@FindBy(xpath = "//a[@class='btn btn-primary py-4 px-lg-5 d-none d-lg-block']")	WebElement btn_register;
		
		@FindBy(xpath = "//input[@name='username']") WebElement txt_username;
		
		@FindBy(xpath = "//input[@name='password']")	WebElement txt_password;
		
		@FindBy(xpath = "//input[@name='email']")	WebElement txt_email;
		
		@FindBy(xpath = "//button[@type='submit']")	WebElement btn_submit;
		
		@FindBy(xpath = "//input[@name='phone_number']")	WebElement txt_phoneNo;
		
		@FindBy(xpath = "//*[@id=\"demo-simple-select\"]")	WebElement drp_programe;
		
		@FindBy(xpath = "/html/body/div/div/div[4]/div/div[2]/form/div/div/div/div/div/div[6]/div/div/div")	WebElement drp_subprograme;
		
		@FindBy(xpath = "//*[@id='menu-']/div[3]/ul/li")	List<WebElement> drp_listOfPrograms;
		
		@FindBy(xpath = "//*[@id='menu-']/div[3]/ul/li")	List<WebElement> drp_listOfSubPrograms;
		
		@FindBy(xpath = "//div[contains(text(),'You have submitted Successfully')]")  WebElement msg_successMsg;
			
		public RegistrationPageObject(){
			PageFactory.initElements(driver, this);
		}
		
		public void registration(HashMap<String, String> testdata) throws InterruptedException {
			CommonMethods.click(btn_register);
			CommonMethods.sendKeysToElement(txt_username,testdata.get("username"));
			CommonMethods.sendKeysToElement(txt_password,testdata.get("password") );
			CommonMethods.sendKeysToElement(txt_email, testdata.get("email"));
			CommonMethods.sendKeysToElement(txt_phoneNo, testdata.get("phoneNumber"));
			CommonMethods.click(drp_programe);
			CommonMethods.dynamicDropDown(drp_listOfPrograms,testdata.get("programs") );
			CommonMethods.click(drp_subprograme);
			CommonMethods.dynamicDropDown(drp_listOfSubPrograms, testdata.get("subPrograms"));
			Utility.waitForElementToBeVisible(driver, By.xpath("//button[@type='submit']"), 10);
			CommonMethods.clickUsingJS(btn_submit);
			Thread.sleep(2000);
					
			
		}
		public String successMessage() {
			return msg_successMsg.getText();
		}

	
}
