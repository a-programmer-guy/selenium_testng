package common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

// Implement the IAnnotationTransformer
public class RetryListener implements IAnnotationTransformer {

	/*
	 * Right click RetryListener and select override/implement methods to auto generate the
	 * transform method Provide the class that implements the IRetryAnalyzer
	 * interface (Retry.Class) Must add listener to the .xml file
	 * (ListenersDemoTest.xml) Now this class will perform the retry a failed test
	 * as many times as have been set in the Retry class
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(Retry.class);
	}
	
	

}
