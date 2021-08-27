package com.revature.overcharge.application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:/Sts_Workspace/ChromeDriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		createDeckAutomation(driver);
		masterDeckAutomation(driver);
		logInAutomation(driver);

	}

	private static void createDeckAutomation(WebDriver driver) throws InterruptedException {
		driver.get("http://localhost:4200/home");

		WebElement login = driver.findElement(By.id("loginNavLink"));
		login.click();

		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("inputUname"));
		username.sendKeys("user");

		Thread.sleep(1000);

		WebElement password = driver.findElement(By.id("inputPass"));
		password.sendKeys("pass");

		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.id("loginButton"));
		submit.click();

		Thread.sleep(3000);

		WebElement library = driver.findElement(By.id("libararyNavLink"));
		library.click();

		Thread.sleep(3000);

		WebElement cardrunner = driver.findElement(By.id("cardrunner"));
		cardrunner.click();

		Thread.sleep(3000);

		WebElement nextquestion = driver.findElement(By.id("nextquestion"));
		WebElement prevquestion = driver.findElement(By.id("prevquestion"));
		nextquestion.click();
		Thread.sleep(2000);
		prevquestion.click();
		Thread.sleep(2000);
		nextquestion.click();
		Thread.sleep(2000);

		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(500);
		nextquestion.click();
		Thread.sleep(2000);
		nextquestion.click();
		Thread.sleep(3000);

		WebElement star5 = driver.findElement(By.id("star5"));
		star5.click();
		Thread.sleep(2000);

		WebElement submitrating = driver.findElement(By.id("submitrating"));
		submitrating.click();
		Thread.sleep(2000);

	}

	private static void masterDeckAutomation(WebDriver driver) throws InterruptedException {
		driver.get("http://localhost:4200/home");

		WebElement login = driver.findElement(By.id("loginNavLink"));
		login.click();

		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("inputUname"));
		username.sendKeys("user");

		Thread.sleep(1000);

		WebElement password = driver.findElement(By.id("inputPass"));
		password.sendKeys("pass");

		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.id("loginButton"));
		submit.click();

		Thread.sleep(3000);

		WebElement library = driver.findElement(By.id("libararyNavLink"));
		library.click();

		Thread.sleep(3000);

		WebElement cardrunner = driver.findElement(By.id("cardrunner"));
		cardrunner.click();

		Thread.sleep(3000);

		WebElement mastered = driver.findElement(By.id("mastered"));
		mastered.click();
		Thread.sleep(2000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);
		mastered.click();
		Thread.sleep(1000);

		WebElement star5 = driver.findElement(By.id("star5"));
		star5.click();
		Thread.sleep(2000);

		WebElement submitrating = driver.findElement(By.id("submitrating"));
		submitrating.click();
		Thread.sleep(2000);

		WebElement home = driver.findElement(By.id("homeNavLink"));
		home.click();
		Thread.sleep(3000);

		WebElement menuBtn = driver.findElement(By.id("menuBtn"));
		menuBtn.click();
		Thread.sleep(3000);

		WebElement logout = driver.findElement(By.id("logoutHeaderBtn"));
		logout.click();
		Thread.sleep(3000);

	}

	private static void logInAutomation(WebDriver driver) throws InterruptedException {
		driver.get("http://localhost:4200/home");

		WebElement login = driver.findElement(By.id("loginNavLink"));
		login.click();

		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("inputUname"));
		username.sendKeys("user");

		Thread.sleep(1000);

		WebElement password = driver.findElement(By.id("inputPass"));
		password.sendKeys("pass");

		Thread.sleep(1000);

		WebElement submit = driver.findElement(By.id("loginButton"));
		submit.click();

		Thread.sleep(3000);

		WebElement library = driver.findElement(By.id("libararyNavLink"));
		library.click();

		Thread.sleep(3000);

		WebElement cardrunner = driver.findElement(By.id("cardrunner"));
		cardrunner.click();

		Thread.sleep(3000);
	}
}
