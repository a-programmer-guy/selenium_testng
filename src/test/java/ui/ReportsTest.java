package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

public class ReportsTest extends BaseTest{
	
	@Test
	public void reporterTest1() {
		System.out.println("This is test1");
	}
	@Test
	public void reporterTest2() {
		driver.get("https://salesforce.com");
		System.out.println("This is test2 - fail");
		Assert.assertTrue(false);
	}
	@Test
	public void reporterTest3() {
		System.out.println("This is test3");
	}
	@Test
	public void reporterTest4() {
		System.out.println("This is test4");
	}
}
