package common;

import java.io.IOException;

import org.apache.commons.logging.Log;
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
		// To log the name of every test run in a suite
		Reporter.log("Method name is - " + result.getName());
		System.out.println("OnTestStart Listener, Test case is starting...");
	}
	// Successful status is set to a 1.
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is - " + result.getStatus());
	}
	// Failure status is set to 2.
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Status of exectution is - " + result.getStatus());	
		System.out.println("OnTestFail Listener, Test failed - Screenshot captured.");
		try {
			getScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
