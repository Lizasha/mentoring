package ActionsAndSeleniumGrid.YandexDiskPages;

import ActionsAndSeleniumGrid.CPPages.AbstractPage;
import ActionsAndSeleniumGrid.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopup extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'button2_type_submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement loginField;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(@class,'header_has-notes-link')]")
	private WebElement pageHeader;

	private String userLogin = "*";
	private String userPassword = "*";


	public LoginPopup(DriverManager driverManager) {
		super(driverManager);
	}

	public LoginPopup login() {
		Actions action = new Actions(driverManager.getDriver());
		JavascriptExecutor jse = (JavascriptExecutor) driverManager;
		new WebDriverWait(driverManager.getDriver(), 5).until(ExpectedConditions.visibilityOf(submitButton));
		loginField.click();
		action.click(loginField).sendKeys(userLogin).click(submitButton).build().perform();
		new WebDriverWait(driverManager.getDriver(), 5).until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.click();
		action.click(passwordField).sendKeys(userPassword).click(submitButton).build().perform();
		new WebDriverWait(driverManager.getDriver(), 20).until(ExpectedConditions.visibilityOf(pageHeader));
		return this;
	}
}
