package ActionsAndSeleniumGrid.CPPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import ActionsAndSeleniumGrid.DriverManager;
import ActionsAndSeleniumGrid.config.Environment;

public class HomePage extends AbstractPage {

	private Environment environment = new Environment();

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getUrl());
		return this;
	}

	public void executeSomeJS() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("alert('Welcome to Color pop site!');");
	}
}
