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
@CucumberOptions(features = "src/test/resources/com/revature/overcharge/features/CardTraversal.feature", glue = {"com.revature.overcharge.steps", "CardTraversalSteps"})
public class CardTraversalRunner {

	public static WebDriver driver;
	public static CardTraversal cardTraversal;
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/SeleniumStuff/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		cardTraversal = new CardTraversal(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
