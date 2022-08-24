package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;

public class DependencyTest extends BaseTest{
	
	@Test(groups = "registration")
	public void userRegistration() {
		System.out.println("This is userRegistration Test -  desgined to fail");
		Assert.assertTrue(false);
	}
	
	// searchUser will be skipped as userRegistration fails - Hard Dependency
	@Test(dependsOnMethods = "userRegistration")
	public void searchUser() {
		System.out.println("This is searchUser Test");
		
	}
	// updateUser will always run even if userRegistration fails - Soft Dependency
	@Test(dependsOnMethods = "userRegistration", alwaysRun = true)
	public void updateUser() {
		System.out.println("This is updateUser Test");
	}
	@Test
	public void reporterTest4() {
		System.out.println("This is test4");
	}
}
