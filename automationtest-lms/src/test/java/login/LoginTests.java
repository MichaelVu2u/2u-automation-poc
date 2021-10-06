package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.PropertyManager;


public class LoginTests extends BaseTests {

	static String user = PropertyManager.getInstance().getUser();
	static String password = PropertyManager.getInstance().getPassword();

	@Test
	public void testSuccessfulLogin(){

		LoginPage loginPage = homePage.clickBanner();
		loginPage.setUsername(user);	
		loginPage.clickNextButton();
		loginPage.setPassword(password);
		loginPage.clickLoginButton();

	}
}
