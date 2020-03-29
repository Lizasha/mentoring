package ActionsAndSeleniumGrid.CPPages;

import java.util.List;

import ActionsAndSeleniumGrid.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewArrivalsPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'listing')]//div[@aria-labelledby]")
	private List<WebElement> productContainer;

	public NewArrivalsPage(DriverManager driverManager) {
		super(driverManager);
	}

	public void clickOnProduct(){
		productContainer.get(1).click();
	}
}
