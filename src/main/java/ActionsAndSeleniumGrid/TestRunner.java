package ActionsAndSeleniumGrid;

import ActionsAndSeleniumGrid.YandexDiskAutomation.HomeDirectoryPage;
import ActionsAndSeleniumGrid.YandexDiskAutomation.YDStartPage;
import ActionsAndSeleniumGrid.YandexDiskAutomation.YDLoginPopup;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import ActionsAndSeleniumGrid.pages.HomePage;
import ActionsAndSeleniumGrid.pages.LoginAndRegistrationPage;
import ActionsAndSeleniumGrid.pages.MyAccountPage;
import ActionsAndSeleniumGrid.pages.NewArrivalsPage;
import ActionsAndSeleniumGrid.pages.ProductPage;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRunner {
	private HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
	private NewArrivalsPage newArrivalsPage = new NewArrivalsPage(DriverManager.getInstance().getDriver());
	private ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
	private LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage(DriverManager.getInstance().getDriver());
	private MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getInstance().getDriver());
	private YDStartPage ydStartPage = new YDStartPage(DriverManager.getInstance().getDriver());
	private YDLoginPopup ydLoginPopup = new YDLoginPopup(DriverManager.getInstance().getDriver());
	private HomeDirectoryPage homeDirectoryPage = new HomeDirectoryPage(DriverManager.getInstance().getDriver());


	private String validLogin = "colorpopuser@mailinator.com";
	private String validPassword = "password1";
	private String invalidLogin = "incorrectuser@mailinator.com";
	private String invalidPassword = "incorrect_password";


	@BeforeClass
	public void initBrowser() {
		DriverManager.getInstance();
	}

	@Test(description = "Check add item to bag")
	public void checkAddingToBag() {

		homePage.openPage().clickOnBurgerMenu().clickOnNewArrivals();
		newArrivalsPage.clickOnProduct();
		productPage.clickAddToBagButton();
		Assert.assertTrue(productPage.isProductInBag(), "Product wasn't added in the bag!");

	}

	@Test(description = "Check valid authorization")
	public void checkSuccessfulLogin() {

		homePage.openPage().openLoginForm();
		loginAndRegistrationPage.inputLogin(validLogin).inputPassword(validPassword).clickOnSignIn();
		Assert.assertTrue(myAccountPage.isSuccessfulSignInMessageIsDisplayed(), "Successful message after login was not display");

	}

	@Test(description = "Check invalid authorization")
	public void checkUnsuccessfulLogin() {

		homePage.openPage().openLoginForm();
		loginAndRegistrationPage.inputLogin(invalidLogin).inputPassword(invalidPassword).clickOnSignIn();
		Assert.assertTrue(loginAndRegistrationPage.isErrorMessageIsDisplayed(), "Successful message after login was not display");

	}

	// Module Actions and SeleniumGrid
	@Test(description = "take a file and move it in a folder by drag-n-drop action")
	public void checkMovingFileToFolder() {
		SoftAssert softAssert = new SoftAssert();

		//prepare test
		ydStartPage.openPage().enterToLoginForm();
		ydLoginPopup.login();

		//check that precondition is true
		homeDirectoryPage.goToDirectory();
		softAssert.assertTrue(homeDirectoryPage.isFolderEmpty(), "Folder should be empty");

		//perform checking
		//homeDirectoryPage.closeDownloadPopup();
		homeDirectoryPage.dragNDropFileToFolder().goToDirectory();
		Assert.assertTrue(homeDirectoryPage.isImageInFolder(),
				"Successful Subscription Message should be visible");
	}



	@AfterTest
	private void quitBrowser() {
		DriverManager.getInstance().closeDriver();
	}

}
