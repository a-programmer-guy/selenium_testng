package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLogin {
	
	public static WebDriver driver;
	/*
	 * With TestNG framework you do not need a public static void main method
	 * launchApp method will accept a string argument for the browser to use for 
	 * the tests. The string for the browser will come from the sauceDemo.xml file.
	 * To access this parameter from .xml file you ned to add the @Parameters annotation
	 * and then provide the name of the parameter you want the value for
	 */
	@Parameters({"browser"})
	@Test
	public void launchApp(String browser) {
		
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("http://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.close();
		driver.quit();
	}

}
