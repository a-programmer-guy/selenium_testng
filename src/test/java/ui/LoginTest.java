package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DriverFactory;

@Test(enabled = false)
public class LoginTest {
	
	WebDriver driver = null;
	// TODO incorporate driver factory
	
	@BeforeTest
	public void setupDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void connectToDb() {
		System.out.println("DB connected...");
	}
	
	@AfterMethod
	public void disconnectFromDb() {
		System.out.println("DB disconnected...");
	}
	
	@Test(priority = 1, description = "This is a login test")
	public void loginTest() {
		System.out.println("Login test successful...");
	}
	
	@Test(priority = 2, description = "This is a logout test")
	public void logoutTest() {
		System.out.println("Logoout test successful...");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
