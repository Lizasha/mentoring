package ActionsAndSeleniumGrid.YandexDiskPages;

import ActionsAndSeleniumGrid.DriverManager;
import ActionsAndSeleniumGrid.CPPages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'header__login-link')]")
	private WebElement enterButton;

	public StartPage(DriverManager driverManager) {
		super(driverManager);
	}

	public StartPage openPage() {
		driverManager.getDriver().get(driverManager.getBaseUrl());
		return this;
	}

	public StartPage enterToLoginForm() {
		new WebDriverWait(driverManager.getDriver(), 5).until(ExpectedConditions.visibilityOf(enterButton));
		enterButton.click();
		return this;
	}
}
