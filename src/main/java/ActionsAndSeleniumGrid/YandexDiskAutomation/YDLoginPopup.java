package ActionsAndSeleniumGrid.YandexDiskAutomation;

import ActionsAndSeleniumGrid.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YDLoginPopup extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'button2_type_submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement loginField;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(@class,'header_has-notes-link')]")
	private WebElement pageHeader;

	private String userLogin = "testyyand";
	private String userPassword = "password1";


	public YDLoginPopup(WebDriver driver) {
		super(driver);
	}

	public YDLoginPopup login() {
		Actions action = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(submitButton));
		loginField.click();
		action.click(loginField).sendKeys(userLogin).click(submitButton).build().perform();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.click();
		action.click(passwordField).sendKeys(userPassword).click(submitButton).build().perform();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(pageHeader));
		return this;
	}
}
