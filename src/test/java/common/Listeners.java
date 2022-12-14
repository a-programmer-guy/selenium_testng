package common;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.TestUtilities;

/*
Extend the ITestListener interface to access Listener functionality
Right click on class name and select Source -> Override/Implement methods
to generate Listener methods automatically.
*/
public class Listeners extends TestUtilities implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// Change the name of the test in the ReportNG report
		System.setProperty("org.uncommons.reportng.title", "Programmer Guy Test Report");
		// To log the name of every test run in a suite
		Reporter.log("Method name is - " + result.getName());
		System.out.println("OnTestStart Listener, Test case is starting...");
	}
	// getStatus successful result returns a 1.
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is - " + result.getStatus());
	}
	// getStatus failure returns a 2 (int)
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Status of exectution is - " + result.getStatus());	
		System.out.println("OnTestFail Listener, Test failed - Screenshot captured.");
		try {
			getScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Add link to html report to show screen shot of failed test
		String directory = System.getProperty("user.dir");
		System.out.println("Directory is: " + directory);
		// To fix broken picture link after adding ReportNG - add the System.setProperty
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String link = String.format("<a href=%s/screenshots/Mon-Aug-22-22-18-37-CST-2022.png/>Test Results Screenshot</>", directory);
		Reporter.log(link);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
