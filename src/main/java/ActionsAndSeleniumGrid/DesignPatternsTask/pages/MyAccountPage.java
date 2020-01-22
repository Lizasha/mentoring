package ActionsAndSeleniumGrid.DesignPatternsTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage {


	@FindBy(xpath = "//*[contains(@class,'act-welcome__hi')]")
	private WebElement successfulSignInMessage;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public boolean isSuccessfulSignInMessageIsDisplayed() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(successfulSignInMessage));
		return successfulSignInMessage.isDisplayed();
	}
}
