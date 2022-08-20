package ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.DriverFactory;

public class VerifyTitleTest {
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	
	@BeforeClass
	public void setup() throws IOException {
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void titleTestAndTextTest() throws InterruptedException {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title Verification");
	}


	@AfterClass
	public void tearDown() {
		df.closeAllDrivers();
	}
	
}
