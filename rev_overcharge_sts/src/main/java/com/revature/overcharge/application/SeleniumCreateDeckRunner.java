package com.revature.overcharge.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCreateDeckRunner {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:/Sts_Workspace/ChromeDriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		
		//Creates a Deck, adds a card then views display
		createDeckAutomation1(driver);
		//Adds Cards to Deck

	}

	private static void createDeckAutomation1(WebDriver driver) throws InterruptedException {
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
		
		WebElement createset = driver.findElement(By.id("createNavLink"));
		createset.click();
		Thread.sleep(3000);
		
		WebElement floatingInputValue = driver.findElement(By.id("floatingInputValue"));
		floatingInputValue.click();
		Thread.sleep(1000);
		floatingInputValue.sendKeys("TestDeck");
		Thread.sleep(3000);

		WebElement addeditcards = driver.findElement(By.id("addeditcards"));
		addeditcards.click();
		Thread.sleep(3000);
		
		WebElement addrow = driver.findElement(By.id("addrow"));
		addrow.click();
		Thread.sleep(3000);

		WebElement cardquestion = driver.findElement(By.id("cardquestion"));
		cardquestion.click();
		cardquestion.sendKeys("TestQuestion");
		Thread.sleep(2000);

		WebElement cardanswer = driver.findElement(By.id("cardanswer"));
		cardanswer.click();
		cardanswer.sendKeys("TestAnswer");
		Thread.sleep(2000);

		WebElement savebutton = driver.findElement(By.id("savebutton"));
		savebutton.click();
		Thread.sleep(3000);
		
		WebElement createdeck = driver.findElement(By.id("create-button"));
		createdeck.click();
		Thread.sleep(3000);
		
		WebElement library = driver.findElement(By.id("libararyNavLink"));
		library.click();
		Thread.sleep(3000);
	}

}