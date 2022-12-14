package ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.DriverFactory;

public class VerifyTitleAndTextTest extends DriverFactory{
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	
	@BeforeClass
	public void setup() throws IOException {
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 0)
	public void titleTest() throws InterruptedException {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		// Hard assert title matches
		Assert.assertEquals(expectedTitle, actualTitle, "Title Verification");
	}
	
	@Test(priority = 1)
	public void textTest() throws InterruptedException {
		String expectedText = "Login";
		String actualText = driver.findElement(By.xpath("//*[@id='login-button']")).getAttribute("value");
		// Hard assert Text matches
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterClass
	public void tearDown() {
		df.closeAllDrivers();
	}
	
}
