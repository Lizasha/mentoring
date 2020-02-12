package DesignPatternsTask;

import DesignPatternsTask.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRunner {
	private HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
	private NewArrivalsPage newArrivalsPage = new NewArrivalsPage(DriverManager.getInstance().getDriver());
	private ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());
	private LoginAndRegistrationPage loginAndRegistrationPage = new LoginAndRegistrationPage(DriverManager.getInstance().getDriver());
	private MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getInstance().getDriver());


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

	@AfterTest
	private void quitBrowser() {
		DriverManager.getInstance().closeDriver();
	}

}
