package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Runner {
	
	public static WebDriver driver;
//	public static PageFrame genericPage;
	
	@BeforeClass
	public static void setup() {
		//TODO Ensure the correct setup
		String filePath = "your driver file path";
		
		driver = chromeSetup(filePath);
//		driver = firefoxSetup(filePath);
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
