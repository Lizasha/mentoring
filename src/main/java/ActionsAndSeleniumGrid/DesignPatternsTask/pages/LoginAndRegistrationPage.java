package ActionsAndSeleniumGrid.DesignPatternsTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.Action;

public class LoginAndRegistrationPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@id,'login_email')]")
	private WebElement loginField;

	@FindBy(xpath = "//*[contains(@id,'login_password')]")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(@value,'Sign In')]")
	private WebElement signInButton;

	@FindBy(xpath = "//*[contains(@class,'errors')]")
	private WebElement errorLoginMessage;

	public LoginAndRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public LoginAndRegistrationPage inputLogin(String login) {
		loginField.click();
		loginField.sendKeys(login);
		return this;
	}

	public LoginAndRegistrationPage inputPassword(String password) {
		passwordField.click();
		passwordField.sendKeys(password);
		return this;
	}

	public LoginAndRegistrationPage clickOnSignIn() {
		signInButton.click();
		return this;
	}

	public boolean isErrorMessageIsDisplayed() {
		return errorLoginMessage.isDisplayed();
	}
}
