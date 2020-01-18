package DesignPatternsTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	protected WebDriver driver;

	@FindBy(xpath = "//*[contains(@class,'header__hamburger-container')]")
	private WebElement burgerMenu;

	@FindBy(xpath = "//*[contains(@class,'navigation__container')]//*[contains(@href,'/collections/new')]")
	WebElement newArrivalsCategory;

	@FindBy(xpath = "//*[contains(@class,'side-cart__parent')]")
	private WebElement bagView;

	@FindBy(xpath = "//*[contains(@class,'link cart-button')]")
	private WebElement bagHeaderButton;

	@FindBy(xpath = "//*[contains(@class,'side-cart__container')]")
	private WebElement productInCart;

	boolean waitingBagDissapearence  = new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(bagView));

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}

	public void clickOnBurgerMenu() {
		burgerMenu.click();
	}

	public void newArrivalsClick() {
		newArrivalsCategory.click();
	}

	public boolean isProductInBag() {
		boolean waitingBagDissapearence  = new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(bagView));

		if (waitingBagDissapearence) {
			bagHeaderButton.click();
		}

		return productInCart.isDisplayed();
	}

}
