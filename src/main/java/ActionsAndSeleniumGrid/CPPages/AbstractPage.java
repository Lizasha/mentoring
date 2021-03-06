package ActionsAndSeleniumGrid.CPPages;

import ActionsAndSeleniumGrid.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	protected DriverManager driverManager;

	// Elements //

	@FindBy(xpath = "//*[contains(@class,'header__hamburger-container')]")
	private WebElement burgerMenu;

	@FindBy(xpath = "//*[contains(@class,'navigation__container')]//*[contains(@href,'/collections/new')]")
	private WebElement newArrivalsCategory;

	@FindBy(xpath = "//*[contains(@class,'side-cart__parent')]")
	private WebElement bagView;

	@FindBy(xpath = "//*[contains(@class,'link cart-button')]")
	private WebElement bagHeaderButton;

	@FindBy(xpath = "//*[contains(@class,'side-cart__container')]")
	private WebElement productInCart;

	@FindBy(xpath = "//*[contains(@class,'header__actions')]//*[contains(@class,'account')]")
	private WebElement accountIcon;

	@FindBy(xpath = "//descendant::*//*[contains(@aria-label,'My Account')]//li[1]")
	private WebElement myAccount;

	@FindBy(xpath = "//input[@id='login_email']")
	private WebElement loginField;

	// Lists //

	@FindBy(xpath = "//*[contains(@aria-label,'My Account')]")
	private WebElement accountOptionsList;


	public AbstractPage(DriverManager driverManager) {
		this.driverManager = driverManager;
		PageFactory.initElements(this.driverManager.getDriver(),this);
	}

	public AbstractPage clickOnBurgerMenu() {
		burgerMenu.click();
		return this;
	}

	public void clickOnNewArrivals() {
		newArrivalsCategory.click();
	}

	public boolean isProductInBag() {
		boolean waitingBagDissapearence = new WebDriverWait(driverManager.getDriver(), 5).until(ExpectedConditions.invisibilityOf(bagView));

		if (waitingBagDissapearence) {
			bagHeaderButton.click();
		}

		return productInCart.isDisplayed();
	}

	public void openLoginForm() {
		Actions action = new Actions(driverManager.getDriver());
		action.moveToElement(accountIcon).build().perform();
		new WebDriverWait(driverManager.getDriver(), 5).until(ExpectedConditions.visibilityOf(accountOptionsList));
		myAccount.click();
		new WebDriverWait(driverManager.getDriver(),5).until(ExpectedConditions.visibilityOf(loginField));
	}
}