package DesignPatternsTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegistrationPage extends AbstractPage {

	@FindBy(css = "//input[@id='login_email']")
	private WebElement loginField;

	@FindBy(css = "//input[@id='login_password']")
	private WebElement passwordField;

	@FindBy(css = "//input[@value='Sign In']")
	private WebElement signInButton;

	public LoginAndRegistrationPage(WebDriver driver) {
		super(driver);
	}

	public LoginAndRegistrationPage inputLogin(String login) {
		loginField.sendKeys(login);
		return this;
	}

	public LoginAndRegistrationPage inputPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public LoginAndRegistrationPage clickOnSignIn() {
		signInButton.click();
		return this;
	}


}
