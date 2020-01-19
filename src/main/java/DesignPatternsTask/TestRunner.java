package DesignPatternsTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRunner {
	private static WebDriver driver;
	private AbstractPage abstractPage = new AbstractPage(driver);
	private NewArrivalsPage newArrivalsPage = new NewArrivalsPage(driver);
	private ProductPage productPage = new ProductPage(driver);

	@BeforeClass
	public void initBrowser() {
		driver = new ChromeDriver();
		driver.get("https://colourpop.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(description = "Check add item to bag")
	public void checkAddingToBag() {
		abstractPage.clickOnBurgerMenu();
		abstractPage.newArrivalsClick();
		newArrivalsPage.clickOnProduct();
		productPage.clickAddToBagButton();
		Assert.assertTrue(abstractPage.isProductInBag(), "Product wasn't added in the bag!");


	}

	@AfterTest
	private void quitBrowser() {
		driver.quit();
	}

}
