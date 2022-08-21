package utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browsers
	 */
	@BeforeSuite
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		
		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "Edge":
			driver = drivers.get("Edge");
			if (driver == null) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				drivers.put("Edge", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
		return driver;
	}

	/*
	 * Method to iterate through drivers that have been set up and close them
	 */
	@AfterSuite
	public static void closeAllDrivers() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
