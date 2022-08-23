package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.BaseTest;

public class TestUtilities extends BaseTest {

	public void getScreenShot() throws IOException {
		//Get the date
		Date currentDate = new Date();
		// Format file name
		String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":","-");
		System.out.println(screenshotFileName);
		// Take the screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copy and save the file into the local file location
		FileUtils.copyFile(screenshotFile, new File("./screenshots/" + screenshotFileName + ".png"));
	}
}
