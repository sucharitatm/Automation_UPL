package testPages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class LoginPage_Tests extends TestBase {

	
	@Test(priority = 1 )
	public void login() throws Exception {
		boolean message=loginpage.login();
		Assert.assertTrue(message);
	
	}
		
	@Test(priority = 2, dependsOnMethods = "login")
	public void testLoginPageTitle() {
		String title=loginpage.loginPageTitle();
		Assert.assertEquals(title, "Unlimited Power of Learning");
	}
	
}
