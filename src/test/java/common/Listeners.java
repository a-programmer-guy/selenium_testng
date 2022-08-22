package common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
Extend the ITestListener interface to access Listener functionality
Right click on class name and select Source -> Override/Implement methods
to generate Listener methods automatically.
*/
public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart Listener, Test case is starting...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestFail Listener, Test failed - Screenshot captured.");
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