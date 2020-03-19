package ActionsAndSeleniumGrid.YandexDiskAutomation;

import ActionsAndSeleniumGrid.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeDirectoryPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'header_has-notes-link')]")
	private WebElement pageHeader;

	public HomeDirectoryPage(WebDriver driver) {
		super(driver);
	}


}
