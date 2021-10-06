package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import com.google.common.io.Files;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.PropertyManager;

public class BaseTests {

	static String environment = PropertyManager.getInstance().getEnvironment();
	static String browser = PropertyManager.getInstance().getBrowser();
	static String user = PropertyManager.getInstance().getUser();
	static String password = PropertyManager.getInstance().getPassword();
	static String loginUrl = PropertyManager.getInstance().getLoginUrl();
	protected static WebDriver driver;
	protected static HomePage homePage;

	@BeforeTest
	public static void setup() {

		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("safari")){
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		System.out.println("Test browser is " + browser);
		goHome();

	}

	@AfterMethod
	public void recordFailure(ITestResult result) {

		if(ITestResult.FAILURE == result.getStatus())
		{
			var camera = (TakesScreenshot)driver;
			File screenshot = camera.getScreenshotAs(OutputType.FILE);
			try {
				Files.move(screenshot, new File("resources/screenshots" + result.getName() + ".png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public static void tearDown() {
		driver.quit();
		System.out.println("Browser teardown completed.");
	}

	private static void goHome() {

		driver.get(loginUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
		System.out.println("Browser setup completed for " + environment);
		
	}

	public static void main(String[] args) {

		setup();
		tearDown();
	}

}
