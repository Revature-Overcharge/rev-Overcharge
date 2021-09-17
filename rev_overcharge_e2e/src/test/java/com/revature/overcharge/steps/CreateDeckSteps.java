package com.revature.overcharge.steps;

import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.CreateDeck;
import com.revature.overcharge.runners.CreateDeckRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class CreateDeckSteps {
	public static CreateDeck createDeck = CreateDeckRunner.createDeck;
	public static WebDriver driver = CreateDeckRunner.driver;

	@Given("Has nagivated to the website")
	public void has_nagivated_to_the_website() {
		driver.get("http://localhost:4200/home");
	}

	@Given("User Logs in")
	public void user_logs_in() throws InterruptedException {
		createDeck.login.click();
		Thread.sleep(3000);
		createDeck.inputUname.sendKeys("user" + "\n");
		Thread.sleep(3000);
		createDeck.inputPass.sendKeys("pass" + "\n");
		Thread.sleep(3000);
		createDeck.loginButton.click();
		Thread.sleep(3000);
	}

	@When("User has option to create a deck")
	public void user_has_option_to_create_a_deck() throws InterruptedException {
		createDeck.createset.click();
		Thread.sleep(3000);
	}

	@Then("User creates a deck")
	public void user_creates_a_deck() throws InterruptedException {
		createDeck.floatingInputValue.click();
		Thread.sleep(3000);
		createDeck.floatingInputValue.sendKeys("TestDeck");
		Thread.sleep(3000);
	}

	@Then("User enters proper values to create a deck")
	public void user_enters_proper_values_to_create_a_deck() throws InterruptedException {
		createDeck.addeditcards.click();
		Thread.sleep(3000);
		createDeck.addrow.click();
		Thread.sleep(3000);
		createDeck.cardquestion.click();
		Thread.sleep(3000);
		createDeck.cardquestion.sendKeys("TestQuestion");
		Thread.sleep(3000);
		createDeck.cardanswer.click();
		Thread.sleep(3000);
		createDeck.cardanswer.sendKeys("TestAnswer");
		Thread.sleep(3000);
		createDeck.savebutton.click();
		Thread.sleep(3000);
	}

	@Then("A new deck will be created")
	public void a_new_deck_will_be_created() throws InterruptedException {
		createDeck.createdeck.click();
		Thread.sleep(3000);
		createDeck.library.click();
		Thread.sleep(3000);
	}
}
