package ActionsAndSeleniumGrid.DesignPatternsTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'product-actions')]//input[@value='Add to Bag']")
	private WebElement addToBagButton;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddToBagButton() {
		addToBagButton.click();
	}

}
