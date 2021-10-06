package compassnav;

import base.BaseTests;
import pages.LoginPage;
import utils.PropertyManager;
import pages.DashboardPage;
import org.testng.annotations.*;
import org.testng.Assert;

public class CompassTests extends BaseTests {

	static String user = PropertyManager.getInstance().getUser();
	static String password = PropertyManager.getInstance().getPassword();

//	@Test
//	public void testMyModulesIcon() {
//
//		LoginPage loginPage = new LoginPage(driver);
//		DashboardPage dashboard = new DashboardPage(driver);
//
//		loginPage.setUsername(user);	
//		loginPage.clickNextButton();
//		loginPage.setPassword(password);
//		loginPage.clickLoginButton();
//		dashboard.clickMyModules();
//		tearDown();
//	}
	
//	@Test
//	public void testMeetingsIcon() {
//		
//		LoginPage loginPage = new LoginPage(driver);
//		DashboardPage dashboard = new DashboardPage(driver);
//
//		loginPage.setUsername(user);	
//		loginPage.clickNextButton();
//		loginPage.setPassword(password);
//		loginPage.clickLoginButton();		
//		dashboard.clickMeetings();
//		tearDown();
//
//	}
	
	@Test
	public void testGroupsIcon() {

		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);

		loginPage.setUsername(user);	
		loginPage.clickNextButton();
		loginPage.setPassword(password);
		loginPage.clickLoginButton();
		dashboard.clickGroups();
		
	}

}
