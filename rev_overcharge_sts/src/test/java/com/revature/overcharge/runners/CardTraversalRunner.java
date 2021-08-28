package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.overcharge.pages.CardTraversal;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.revature.overcharge.steps")
public class CardTraversalRunner {

	public static WebDriver driver;
	public static CardTraversal cardTraversal;
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/Sts_Workspace/ChromeDriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		cardTraversal = new CardTraversal(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
