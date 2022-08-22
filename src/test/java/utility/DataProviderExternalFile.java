package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderExternalFile {

	@DataProvider
	public Object[][] dataSet() {
		Object[][] dataset = new Object[4][2];

		// first row
		dataset[0][0] = "user1";
		dataset[0][1] = "pass1";

		// second row
		dataset[1][0] = "user2";
		dataset[1][1] = "pass2";

		// third row
		dataset[2][0] = "user3";
		dataset[2][1] = "pass3";

		// fourth row
		dataset[3][0] = "user4";
		dataset[3][1] = "pass4";

		return dataset;
	}

	// Pass in the Methods from the Test Class (DataProviderDemoTest)
	@DataProvider(name = "create")
	public Object[][] dataSet2(Method m) {
		// Instantiate null testData object
		Object[][] testData = null;
		/*
		 * Create conditional to check which method(test step) is being ran and provide the
		 * applicable data. If the test requires 3 string arguments return the
		 * dataObject that has the 3 strings, if its the test that requires two, return
		 * that dataIbject
		 */
		if(m.getName().equals("test2")) {
			testData = new Object[][]
				{
					{"username1", "password1", "test1"},
					{"username2", "password2", "test2"},
					{"username3", "password3", "test3"},
					{"username4", "password4", "test4"}
				};
		} else if(m.getName().equals("test")) {
			testData = new Object[][]
				{
					{"username1", "password1"},
					{"username2", "password2"},
					{"username3", "password3"},
					{"username4", "password4"}
				};
		} else if(m.getName().equals("test3")) {
			testData = new Object[][]
				{
					{"username1", "password1", "test1", "testString1"},
					{"username2", "password2", "test2", "testString2"},
					{"username3", "password3", "test3", "testString3"},
					{"username4", "password4", "test4", "testString4"}
				};
		}
		return testData;
	}
}
