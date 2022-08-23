package ui;

import org.testng.annotations.Test;

import utility.DataProviderExternalFile;

public class DataProviderDemoTest {
	
	// Passes in the method annotated with the name "create" from the DataProviderExternalFile.class 
	@Test(dataProvider = "create", dataProviderClass = DataProviderExternalFile.class)
	public void test(String username, String password) {
		
		System.out.println(username + "------" + password);
	}
	
	@Test(dataProvider = "create", dataProviderClass = DataProviderExternalFile.class)
	public void test2(String username, String password, String test) {
		System.out.println(username + "---" + password + "---" + test);
	}
	
	@Test(dataProvider = "create", dataProviderClass = DataProviderExternalFile.class)
	public void test3(String username, String password, String test, String testString) {
		System.out.println(username + "---" + password + "---" + test + "---" + testString);
	}
}
