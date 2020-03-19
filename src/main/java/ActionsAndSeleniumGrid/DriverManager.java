package ActionsAndSeleniumGrid;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Liza\\learn\\mentoring\\chromedriver.exe");
/*		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.WINDOWS);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void closeDriver() {
		driver.quit();
	}
}
