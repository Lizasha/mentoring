package ActionsAndSeleniumGrid.CPPages;

import org.openqa.selenium.JavascriptExecutor;

import ActionsAndSeleniumGrid.DriverManager;

public class HomePage extends AbstractPage {

	public HomePage(DriverManager driverManager) {
		super(driverManager);
	}

	public HomePage openPage() {
		driverManager.getDriver().get(driverManager.getBaseUrl());
		return this;
	}

	public void executeSomeJS() {
		JavascriptExecutor executor = (JavascriptExecutor) driverManager.getDriver();
		executor.executeScript("alert('Welcome to Color pop site!');");
	}
}
