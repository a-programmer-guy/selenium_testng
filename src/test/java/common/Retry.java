package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// Implement the IRetryAnalyzer interface
public class Retry implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private static final int maxRetryCount = 3;
	// With this retry mechanism, the test will run 4 times total - 3 retries plus initial test run
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
