package DesignPatternsTask;

import DesignPatternsTask.config.Environment;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	private Environment environment = new Environment();

	HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getUrl());
		return this;
	}
}
