package ui;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(priority = 1, description = "This is a login test")
	public void loginTest() {
		System.out.println("Login test successful...");
	}
	@Test(priority = 2, description = "This is a logout test")
	public void logoutTest() {
		System.out.println("Logoout test successful...");
	}
}
