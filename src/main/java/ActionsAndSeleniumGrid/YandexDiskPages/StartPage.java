package ActionsAndSeleniumGrid.YandexDiskPages;

import ActionsAndSeleniumGrid.DriverManager;
import ActionsAndSeleniumGrid.config.Environment;
import ActionsAndSeleniumGrid.CPPages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends AbstractPage {

	public Environment environment = new Environment();

	@FindBy(xpath = "//*[contains(@class,'header__login-link')]")
	private WebElement enterButton;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	public StartPage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getYandexDiskDomain());
		return this;
	}

	public StartPage enterToLoginForm() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(enterButton));
		enterButton.click();
		return this;
	}
}
