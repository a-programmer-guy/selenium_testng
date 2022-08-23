package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

public class ListenerDemoTest extends BaseTest {

	@Test
	public void launchApp() {
		driver.get("https://www.ebay.com");
		// Purposefully fail test to get screenshot
		Assert.assertTrue(false);
	}
	
}
