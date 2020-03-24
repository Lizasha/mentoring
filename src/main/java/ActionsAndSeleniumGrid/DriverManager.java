package ActionsAndSeleniumGrid;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
	private static DriverManager instance;
	private static WebDriver driver;

	private DriverManager() {
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static DriverManager getInstance() {
		if (instance == null) {
			instance = new DriverManager();
			initializationDriver();
		}
		return instance;
	}

	private static void initializationDriver() {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().version("80.0.3987.106").setup();
		options.addArguments("start-maximized");
		options.setCapability("platformName", Platform.WINDOWS);

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// add 2 nodes
		driver.manage().window().maximize();
	}

	public void closeDriver() {
		driver.quit();
	}
}
