package createtestdata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configs.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAdditionalTextPages {

	public static WebDriver driver = null;
	public static String environment = null;
	public static String browserName = null;
	public static String loginstagingurl = null;
	public static String loginUATurl = null;
	public static String loginUATuser = null;
	public static String loginstaginguser = null;
	public static String user = null;
	public static String password = null;
	public static String UATcourseWorkEditUrl = null;
	public static String stagingcourseWorkEditUrl = null;
	public static Date date = Calendar.getInstance().getTime();  
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS zzz"); 
	public static String strDate = dateFormat.format(date);

	@BeforeTest
	public static void setup() {

		PropertiesFile.getProperites();

		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		if(environment.contentEquals("uat")) {
			driver.get(loginUATurl);
		}else if(environment.contentEquals("staging")) {
			driver.get(loginstagingurl);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		if(environment.contentEquals("uat")) {
		
			driver.findElement(By.id("username")).sendKeys(loginUATuser);
			
		}else if(environment.contentEquals("staging")) {
			
			driver.findElement(By.id("username")).sendKeys(loginstaginguser);
			
		}

		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-submit")).click();

		if(environment.contentEquals("uat")) {

			driver.get(UATcourseWorkEditUrl);

		}else if(environment.contentEquals("staging")) {

			driver.get(stagingcourseWorkEditUrl);

		}


		if(environment.contentEquals("uat")) {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit Mode')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Edit Mode')]")).click();

		}else if(environment.contentEquals("staging")) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit Mode')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Edit Mode')]")).click();


		}
//		else if(environment.contentEquals("staging")) {
//			
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Roster')]")));
//			driver.findElement(By.xpath("//a[contains(text(),'Roster')]")).click();
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Krista Martinez')]")));
//			driver.findElement(By.xpath("//a[contains(text(),'Krista Martinez')]")).click();
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Login as')]")));
//			driver.findElement(By.xpath("//a[contains(text(),'Login as')]")).click();
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//input[1]")));
//			driver.findElement(By.xpath("//body//input[1]")).click();
//			
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//			driver.get(stagingcourseWorkEditUrl);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit Mode')]")));
//			driver.findElement(By.xpath("//a[contains(text(),'Edit Mode')]")).click();
//
//		}
	
		
		if(environment.contentEquals("uat")) {
			user = loginUATuser;
		}else if(environment.contentEquals("staging")) {
			user = loginstaginguser;
		}

		System.out.println("Set up completed for " + environment);
	}

	@Test(invocationCount = 2)
	public static void createTextPage() {

		WebDriverWait wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button add-segment-button']")));
		driver.findElement(By.xpath("//a[@class='button add-segment-button']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/course-customization[1]/main[1]/div[1]/div[1]/div[1]/form[1]/cc-input[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));
		driver.findElement(By.xpath("/html[1]/body[1]/course-customization[1]/main[1]/div[1]/div[1]/div[1]/form[1]/cc-input[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Text Page " + user + " " + strDate);
		driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Student-facing text " + strDate + " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rhoncus nisl nec urna ullamcorper, nec lacinia lacus consequat. Proin pulvinar, massa sed vestibulum sagittis, ante sem fermentum lacus, non porttitor quam dolor a augue. Cras id rhoncus tellus, eget laoreet risus. Etiam lectus ante, euismod feugiat nisi sit amet, bibendum pulvinar odio. Proin tristique ligula non leo tempus vulputate. Donec neque orci, vehicula et facilisis sed, dictum eu turpis. Cras vel erat sit amet lacus pulvinar eleifend nec sed tellus. Maecenas elit ligula, cursus nec neque in, aliquet facilisis justo. Nam ac arcu ac mi malesuada interdum tempus ac dolor. Cras ac ligula pellentesque purus placerat cursus. Etiam congue, nisi vitae feugiat imperdiet, odio lectus consequat purus, in pretium justo eros eu erat.");
		driver.findElement(By.xpath("//button[@class='button btn--save u--pull-right']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='published-status u--show-flex u--align-items-center ng-scope publish-changes']")));
		driver.findElement(By.xpath("//div[@class='published-status u--show-flex u--align-items-center ng-scope publish-changes']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast toast--success']")));

	}

	@AfterTest
	public static void teardownBrowser() {

		driver.quit();

	}

}