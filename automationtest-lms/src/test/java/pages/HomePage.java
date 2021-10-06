package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	public LoginPage clickBanner() {
		driver.findElement(By.xpath("//div[@class='navbar__brand logo-2']//img"));
		return new LoginPage(driver);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
