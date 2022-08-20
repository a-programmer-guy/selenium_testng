package ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.DriverFactory;

public class VerifyTitleAndTextTestSoftAssert {
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	SoftAssert softAssert;
	
	@BeforeClass
	public void setup() throws IOException {
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void titleTestAndTextTest() throws InterruptedException {
		String expectedTitle = "Swag fdLabs";
		String actualTitle = driver.getTitle();
		// Hard assert title matches
//		Assert.assertEquals(actualTitle, expectedTitle, "Title Verification");
		softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle, "Title Verification:");
		String expectedText = "Logidsn";
		String actualText = driver.findElement(By.xpath("//*[@id='login-button']")).getAttribute("value");
		// Hard assert Text matches
//		Assert.assertEquals(actualText, expectedText);
		softAssert.assertEquals(actualText, expectedText, "Text Verification:");
		softAssert.assertAll();
	}


	@AfterClass
	public void tearDown() {
		df.closeAllDrivers();
	}
}
