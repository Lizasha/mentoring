package ActionsAndSeleniumGrid.YandexDiskAutomation;

import ActionsAndSeleniumGrid.DriverManager;
import ActionsAndSeleniumGrid.config.Environment;
import ActionsAndSeleniumGrid.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDStartPage extends AbstractPage {

	public Environment environment = new Environment();

	@FindBy(xpath = "//*[contains(@class,'header__login-link')]")
	private WebElement enterButton;

	public YDStartPage(WebDriver driver) {
		super(driver);
	}

	public YDStartPage openPage() {
		DriverManager.getInstance().getDriver().get(environment.getYandexDiskDomain());
		return this;
	}

	public YDStartPage enterToLoginForm() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(enterButton));
		enterButton.click();
		return this;
	}

	public boolean isImageInFolder() {
		// implementation will be done here
		return false;
	}
}
