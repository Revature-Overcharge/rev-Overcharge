package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.overcharge.pages.Objectives;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/overcharge/features/Objectives.feature", glue = {
		"com.revature.overcharge.steps", "ObjectivesSteps" })
public class ObjectivesRunner {

	public static WebDriver driver;
	public static Objectives objectives;

	@BeforeClass
	public static void setUp() {

		// DON'T FORGET TO CHANGE PATH TO YOURS
		String path = "C:/SeleniumStuff/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		objectives = new Objectives(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
