package ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import common.CommonDataSetup;
import utility.DriverFactory;
/*
 * Extend the CommonDataSetup class from the common package to access and run its functions
*/
public class BeforeGroupBeforeClassTest extends CommonDataSetup {
	
	DriverFactory df = new DriverFactory();
	WebDriver driver = df.getBrowser("Chrome");
	
	@BeforeClass
	public void setup() throws IOException {
		System.out.println("This function runs before the class");
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 0, groups = "regression")
	public void titleTest() throws InterruptedException {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals("Title Verification", expectedTitle, actualTitle);
		System.out.println("Assert Title Test - regression group");
	}
	
	@Test(priority = 1, groups = "smoke")
	public void textTest() throws InterruptedException {
		String expectedText = "Login";
		String actualText = driver.findElement(By.xpath("//*[@id='login-button']")).getAttribute("value");
		AssertJUnit.assertEquals(actualText, expectedText);
		System.out.println("Assert Text Test - smoke group");
	}
	
	@Test(groups = "regression")
	public void groupTestExample() {
		System.out.println("Group test - regression");
	}

	@Test(groups = {"regression", "smoke"})
	public void groupTestRegressionSmoke() {
		System.out.println("Group test - regression, smoke group");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("This function runs after the class");
		df.closeAllDrivers();
	}
	// Run this function before certain tests in a group
	@BeforeGroups(value="regression")
	public void beforeGroup() {
		System.out.println("Run this before the regression group");
	}
	
	// Run this function before certain tests in a group
	@AfterGroups(value="regression")
	public void afterGroup() {
		System.out.println("Run this after the regression group");
	}
}

