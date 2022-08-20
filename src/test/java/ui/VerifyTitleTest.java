package ui;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.DriverFactory;

public class VerifyTitleTest {
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	@BeforeClass
	public void setup() throws IOException {
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void titleTest() throws InterruptedException {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		// Assert title matches
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void textTest() {
		String expectedText = "Login";
		String actualText = driver.findElement(By.xpath("//*[@id='login-button']")).getAttribute("value");
		// Assert Text matches
		Assert.assertEquals(actualText, expectedText);
	}
	@AfterClass
	public void tearDown() {
		df.closeAllDrivers();
	}
	
}
