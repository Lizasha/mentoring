package ActionsAndSeleniumGrid;

import ActionsAndSeleniumGrid.YandexDiskPages.HomeDirectoryPage;
import ActionsAndSeleniumGrid.YandexDiskPages.LoginPopup;
import ActionsAndSeleniumGrid.YandexDiskPages.StartPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class YDTests {

	private StartPage startPage = new StartPage(DriverManager.getInstance().getDriver());
	private LoginPopup loginPopup = new LoginPopup(DriverManager.getInstance().getDriver());
	private HomeDirectoryPage HomeDirectoryPage = new HomeDirectoryPage(DriverManager.getInstance().getDriver());

	@BeforeClass
	public void initBrowser() {
		DriverManager.getInstance();
	}

	// Module Actions and SeleniumGrid
	@Test(description = "take a file and move it in a folder by drag-n-drop action")
	public void checkMovingFileToFolder() {
		SoftAssert softAssert = new SoftAssert();

		//prepare test
		startPage.openPage().enterToLoginForm();
		loginPopup.login();

		//check that preconditions are ready
		HomeDirectoryPage.goToDirectory();
		softAssert.assertTrue(HomeDirectoryPage.isFolderEmpty(), "Folder should be empty");
		DriverManager.getInstance().getDriver().navigate().back();

		//perform checking
		HomeDirectoryPage.dragNDropFileToFolder().goToDirectory();
		Assert.assertTrue(HomeDirectoryPage.isImageInFolder(),
				"File in directory should be visible");
	}

	@Test
	public void clickUsingJS() {
		startPage.openPage().enterToLoginForm();
		loginPopup.login();
		HomeDirectoryPage.clickOnImage();
	}

	@AfterClass
	private void quitBrowser() {
		DriverManager.getInstance().closeDriver();
	}
}
