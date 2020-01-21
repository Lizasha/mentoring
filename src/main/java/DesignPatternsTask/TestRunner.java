package DesignPatternsTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRunner {
	private HomePage homePage = new HomePage(DriverManager.getInstance().getDriver());
	private AbstractPage abstractPage = new AbstractPage(DriverManager.getInstance().getDriver());
	private NewArrivalsPage newArrivalsPage = new NewArrivalsPage(DriverManager.getInstance().getDriver());
	private ProductPage productPage = new ProductPage(DriverManager.getInstance().getDriver());

	@BeforeClass
	public void initBrowser() {
		DriverManager.getInstance();
	}

	@Test(description = "Check add item to bag")
	public void checkAddingToBag() {

		homePage.openPage();
		abstractPage.clickOnBurgerMenu().clickOnNewArrivals();
		newArrivalsPage.clickOnProduct();
		productPage.clickAddToBagButton();
		Assert.assertTrue(abstractPage.isProductInBag(), "Product wasn't added in the bag!");

	}

	@Test(description = "Check authorization")
	public void checkLogin() {

		homePage.openPage();
		abstractPage.openLoginForm();


	}

	@AfterTest
	private void quitBrowser() {
		DriverManager.getInstance().closeDriver();
	}

}
