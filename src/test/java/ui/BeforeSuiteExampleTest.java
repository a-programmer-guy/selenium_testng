package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
public class BeforeSuiteExampleTest extends CommonDataSetup {
		
	public void setup() throws IOException {
		System.out.println("This function runs before the class");
	}
	
	@Test(priority = 0, groups = "regression")
	public void titleTest() throws InterruptedException {
		System.out.println("Assert Title Test - regression group");
	}
	
	@Test(priority = 1, groups = "smoke")
	public void textTest() throws InterruptedException {
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

	public void tearDown() {
		System.out.println("This function runs after the class");
	}
	public void beforeGroup() {
		System.out.println("Run this before the regression group");
	}
	
	public void afterGroup() {
		System.out.println("Run this after the regression group");
	}
}

