package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	private WebDriver driver;
	private By myModulesIcon = By.xpath("//a[@href='/ap/courses']");
	private By meetingsIcon = By.xpath("//a[@href='/ap/#/meetings']");
	private By groupsIcon = By.xpath("//a[@href='/local/groups/searchgroups.php']");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickMyModules() {
		driver.findElement(myModulesIcon).click();
	}
	
	public void clickMeetings() {
		driver.findElement(meetingsIcon).click();
	}
	
	public void clickGroups() {
		driver.findElement(groupsIcon).click();
	}

}
