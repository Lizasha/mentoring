package ActionsAndSeleniumGrid;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import ActionsAndSeleniumGrid.CPPages.HomePage;
import ActionsAndSeleniumGrid.CPPages.LoginAndRegistrationPage;
import ActionsAndSeleniumGrid.CPPages.MyAccountPage;
import ActionsAndSeleniumGrid.CPPages.NewArrivalsPage;
import ActionsAndSeleniumGrid.CPPages.ProductPage;

import java.net.MalformedURLException;

public class CPTests {

	public DriverManager driverManager;
	private HomePage homePage;
	private NewArrivalsPage newArrivalsPage;
	private ProductPage productPage;
	private LoginAndRegistrationPage loginAndRegistrationPage;
	private MyAccountPage myAccountPage;

	private String validLogin = "colorpopuser@mailinator.com";
	private String validPassword = "password1";
	private String invalidLogin = "incorrectuser@mailinator.com";
	private String invalidPassword = "incorrect_password";


	@BeforeClass(alwaysRun = true)
	@Parameters({"os", "browser", "url", "node"})
	public void initBrowser(String os, String browser, String url, String node) throws MalformedURLException {
		driverManager = new DriverManager(os, browser, url, node);
		homePage = new HomePage(driverManager);
		newArrivalsPage = new NewArrivalsPage(driverManager);
		productPage = new ProductPage(driverManager);
		loginAndRegistrationPage = new LoginAndRegistrationPage(driverManager);
		myAccountPage = new MyAccountPage(driverManager);
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

	@Test
	public void checkJS() {
		homePage.openPage().executeSomeJS();
	}

	@AfterClass(alwaysRun = true)
	private void quitBrowser() {
		driverManager.closeDriver();
	}

}
