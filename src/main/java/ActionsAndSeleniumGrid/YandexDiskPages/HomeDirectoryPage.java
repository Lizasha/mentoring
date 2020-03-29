package ActionsAndSeleniumGrid.YandexDiskPages;

import ActionsAndSeleniumGrid.CPPages.AbstractPage;
import ActionsAndSeleniumGrid.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomeDirectoryPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'header_has-notes-link')]")
	private WebElement pageHeader;

	@FindBy(xpath = "//*[contains(@class,'dialog__close')]")
	private WebElement closeDownloadPopupButton;

	@FindBy(xpath = "//*[contains(@class,'listing-item_type_file')]")
	private List<WebElement> files;

	@FindBy(xpath = "//*[contains(@class,'listing-item_type_dir')]")
	private List<WebElement> dirs;

	Actions action = new Actions(driverManager.getDriver());

	public HomeDirectoryPage(DriverManager driverManager) {
		super(driverManager);
	}

	public HomeDirectoryPage closeDownloadPopup() {
		if (closeDownloadPopupButton.isDisplayed()) {
			closeDownloadPopupButton.click();
		}
		return this;
	}

	public HomeDirectoryPage dragNDropFileToFolder() {
		action.dragAndDrop(files.get(0), dirs.get(0)).build().perform();
		return this;
	}

	public HomeDirectoryPage goToDirectory() {
		action.doubleClick(dirs.get(0)).build().perform();
		return this;
	}

	public boolean isFolderEmpty() {
		int countOfFiles = files.size();
		return countOfFiles == 0;
	}


	public boolean isImageInFolder() {
		new WebDriverWait(driverManager.getDriver(), 20).until(ExpectedConditions.visibilityOf(pageHeader));
		int countOfFiles = files.size();
		return countOfFiles > 0;
	}

	public void clickOnImage() {
		JavascriptExecutor executor = (JavascriptExecutor) driverManager.getDriver();
		executor.executeScript("arguments[0].click();", files.get(1));
		executor.executeScript("alert('Welcome to Yandex Disk');");
	}
}
