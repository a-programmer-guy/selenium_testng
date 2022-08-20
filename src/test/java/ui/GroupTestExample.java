package ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.DriverFactory;

@Test(groups = "group-example")
public class GroupTestExample {
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	
	@BeforeClass
	public void setup() throws IOException {
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 0, groups = "regression")
	public void titleTest() throws InterruptedException {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		// Hard assert title matches
		AssertJUnit.assertEquals("Title Verification", expectedTitle, actualTitle);
	}
	
	@Test(priority = 1, groups = "smoke")
	public void textTest() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		String expectedText = "Login";
		String actualText = driver.findElement(By.xpath("//*[@id='login-button']")).getAttribute("value");
		// Hard assert Text matches
		AssertJUnit.assertEquals(actualText, expectedText);
	}
	
	@Test(groups = "regression")
	public void groupTestExample() {
		System.out.println("Group test - regression");
	}

	@Test(groups = {"regression", "smoke"})
	public void groupTestRegressionSmoke() {
		System.out.println("Group test - regression, smoke");
	}

	@AfterClass
	public void tearDown() {
		df.closeAllDrivers();
	}
}
