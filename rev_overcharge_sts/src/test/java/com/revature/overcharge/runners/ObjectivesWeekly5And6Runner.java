package com.revature.overcharge.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.overcharge.pages.CardTraversal;
import com.revature.overcharge.pages.LibraryPage;
import com.revature.overcharge.pages.Objectives;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",  glue = { "com.revature.overcharge.steps", "ObjectivesWeekly5StarSteps" })
public class ObjectivesWeekly5And6Runner {
	
	public static WebDriver driver;
	public static Objectives objectivesPage;
	public static LibraryPage libraryPage;
	public static CardTraversal cardPage;


	@BeforeClass
	public static void setUp() {

		// YOU NEED TO PUT YOUR OWN CHROME OR FIREFOX DRIVER FOR PATH
//		String path = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		objectivesPage = new Objectives(driver);
		libraryPage = new LibraryPage(driver);
		cardPage = new CardTraversal(driver);		
		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
