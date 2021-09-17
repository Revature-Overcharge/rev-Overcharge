package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.overcharge.pages.CreateDeck;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/revature/overcharge/features/CreateDeck.feature", 
		glue = {"com.revature.overcharge.steps", "CreateDeckSteps"})
public class CreateDeckRunner {

	public static WebDriver driver;
	public static CreateDeck createDeck;
	
	@BeforeClass
	public static void setUp() {
		String path = "C:/SeleniumStuff/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		createDeck = new CreateDeck(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
