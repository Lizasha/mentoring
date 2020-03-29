package ActionsAndSeleniumGrid.CPPages;

import ActionsAndSeleniumGrid.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'product-actions')]//input[@value='Add to Bag']")
	private WebElement addToBagButton;

	public ProductPage(DriverManager driverManager) {
		super(driverManager);
	}

	public void clickAddToBagButton() {
		addToBagButton.click();
	}

}
