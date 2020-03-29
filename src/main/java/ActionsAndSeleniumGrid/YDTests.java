package ActionsAndSeleniumGrid;

import ActionsAndSeleniumGrid.YandexDiskPages.HomeDirectoryPage;
import ActionsAndSeleniumGrid.YandexDiskPages.LoginPopup;
import ActionsAndSeleniumGrid.YandexDiskPages.StartPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class YDTests {
	public DriverManager driverManager;
	private StartPage startPage;
	private LoginPopup loginPopup;
	private HomeDirectoryPage HomeDirectoryPage;

	@BeforeClass(alwaysRun = true)
	@Parameters({"os", "browser", "url", "node"})
	public void initBrowser(String os, String browser, String url, String node) throws MalformedURLException {
		driverManager = new DriverManager(os, browser, url, node);
		startPage = new StartPage(driverManager);
		loginPopup = new LoginPopup(driverManager);
		HomeDirectoryPage = new HomeDirectoryPage(driverManager);
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
		driverManager.getDriver().navigate().back();

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

	@AfterClass(alwaysRun = true)
	private void quitBrowser() {
		driverManager.closeDriver();
	}
}
