package WebDriverBasicsAndLocators;

import java.util.List;
import java.util.concurrent.TimeUnit;


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

public class TestRunner {
	private WebDriver driver;

	@BeforeClass
	public void initBrowser() {
		driver = new ChromeDriver();
	}

	@Test
	public void checkAddingToBag() {

		openPage();
		clickOnBurgerMenu();
		chooseNewArrivals();
		chooseProduct();
		addToBag();
		Assert.assertTrue(isProductInBag(), "Product wasn't added in the bag!");


	}

	private boolean isProductInBag() {
		WebElement bagView = driver.findElement(By.xpath("//*[contains(@class,'side-cart__parent')]"));
		WebElement bagHeaderButton = driver.findElement(By.xpath("//*[contains(@class,'link cart-button')]"));

		boolean waitingBagDissapearence  = new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(bagView));
		if (waitingBagDissapearence) {
			bagHeaderButton.click();
		}

		WebElement productInCart = driver.findElement(By.xpath("//*[contains(@class,'side-cart__container')]"));
		return productInCart.isDisplayed();
	}

	private void addToBag() {
		WebElement addToBagButton = driver.findElement(By.xpath("//*[contains(@class,'product-actions')]//input[@value='Add to Bag']"));
		addToBagButton.click();
	}

	private void chooseProduct() {
		List<WebElement> productContainer = driver.findElements(By.xpath("//*[contains(@class,'listing')]//div[@aria-labelledby]"));
		productContainer.get(1).click();
	}

	private void chooseNewArrivals() {
		WebElement newArrivalsCategory = driver.findElement(By.xpath("//*[contains(@class,'navigation__container')]//*[contains(@href,'/collections/new')]"));
		newArrivalsCategory.click();
	}

	private void clickOnBurgerMenu() {
		WebElement burgerMenu = driver.findElement(By.xpath("//*[contains(@class,'header__hamburger-container')]"));
		burgerMenu.click();
	}

	private void openPage() {
		driver.get("https://colourpop.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	private void quitBrowser() {
		driver.quit();
	}

}
