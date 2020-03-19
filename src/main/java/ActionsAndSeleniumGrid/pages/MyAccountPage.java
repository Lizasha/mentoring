package ActionsAndSeleniumGrid.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage {


	@FindBy(xpath = "//*[contains(@class,'act-welcome__hi')]")
	private WebElement successfulSignInMessage;

	@FindBy(xpath = "//*[contains(@class,'act-info__info')]")
	private WebElement personalInfoEmail;

	@FindBy(xpath = "//*[contains(@id,'footer-email')]")
	private WebElement inputToSubscribe;

	@FindBy(xpath = "//*[contains(@id,'footer__signup')]//*[contains(@type,'submit')]")
	private WebElement subscribeButton;

	@FindBy(xpath = "//*[contains(@class,'page__context')]")
	private WebElement subscriptionConfirmationImage;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public boolean isSuccessfulSignInMessageIsDisplayed() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(successfulSignInMessage));
		return successfulSignInMessage.isDisplayed();
	}
}
