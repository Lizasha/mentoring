package DesignPatternsTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewArrivalsPage extends AbstractPage {

	@FindBy(xpath = "//*[contains(@class,'listing')]//div[@aria-labelledby]")
	private List<WebElement> productContainer;

	public NewArrivalsPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnProduct(){
		productContainer.get(1).click();
	}
}
