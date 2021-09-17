package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public abstract class Runner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		// Input your filepath for your WebDriver executable
		String filePath = "C:/SeleniumStuff/chromedriver_win32";
		
		// Comment out the setup that you do not use.
		driver = chromeSetup(filePath+"/chromedriver.exe");
//		driver = firefoxSetup(filePath+"/geckodriver.exe");
		
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@SuppressWarnings("unused")
	 protected static WebDriver chromeSetup(String filePath) {
		System.setProperty("webdriver.chrome.driver", filePath);
		return new ChromeDriver();
	}

	@SuppressWarnings("unused")
	protected static WebDriver firefoxSetup(String filePath) {
		System.setProperty("webdriver.gecko.driver", filePath);
		return new FirefoxDriver();
	}
}
