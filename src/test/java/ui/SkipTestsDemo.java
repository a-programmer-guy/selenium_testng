package ui;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestsDemo {

	Boolean dataLoaded = false;
	
	@Test(enabled = false)
	public void skipTest1() {
		System.out.println("Skip incomplete test using enabled = false annotation");
	}

	@Test
	public void skipTest2() {
		System.out.println("Skip test forcefully by throwing exception");
		throw new SkipException("Skipping this test forcefully");
	}
	
	@Test
	public void skipTestBasedOnCondition() {
		System.out.println("Skip test based on condition...");
		if(dataLoaded==true) {
			System.out.println("Data loaded successfully - Execute Test");
		} else {
			System.out.println("Data load unsuccessful - Do Not Execute Further Steps");
			throw new SkipException("Do not execute further steps.");
		}
	}
}
