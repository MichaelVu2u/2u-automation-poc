package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	private WebDriver driver;
	private By usernameField = By.id("username");
	private By loginNextButton = By.id("login-submit");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-submit");
	private By rememberUsernameCheckbox = By.id("save-username");
	private By showPasswordCheckbox = By.id("show-password");
	private By forgotPasswordLink = By.xpath("//a[contains(text(),'Forgot Password?')]");
	private By needHelpLink = By.xpath("//a[contains(text(),'Need help?')]");
//	WebDriverWait wait = new WebDriverWait(driver,30);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void setPassword(String password) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickNextButton() {
//		driver.findElement(loginNextButton).click();
		driver.findElement(By.id("login-submit")).click();
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void clickRememberUsername() {
		driver.findElement(rememberUsernameCheckbox).click();
	}

	public void clickShowPassword() {
		driver.findElement(showPasswordCheckbox).click();
	}

	public void clickForgotPassword() {
		driver.findElement(forgotPasswordLink).click();
	}

	public void clickNeedHelp() {
		driver.findElement(needHelpLink).click();
	}

}