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
	public void user_logs_in() {
		createDeck.login.click();
		createDeck.inputUname.sendKeys("user" + "\n");
		createDeck.inputPass.sendKeys("pass" + "\n");
		createDeck.loginButton.click();
	}

	@When("User has option to create a deck")
	public void user_has_option_to_create_a_deck() {
		createDeck.createset.click();
	}

	@Then("User creates a deck")
	public void user_creates_a_deck() {
		createDeck.floatingInputValue.click();
		createDeck.floatingInputValue.sendKeys("TestDeck");
	}

	@Then("User enters proper values to create a deck")
	public void user_enters_proper_values_to_create_a_deck() {
		createDeck.addeditcards.click();
		createDeck.addrow.click();
		createDeck.cardquestion.click();
		createDeck.cardquestion.sendKeys("TestQuestion");
		createDeck.cardanswer.click();
		createDeck.cardanswer.sendKeys("TestAnswer");
		createDeck.savebutton.click();
	}

	@Then("A new deck will be created")
	public void a_new_deck_will_be_created() {
		createDeck.createdeck.click();
		createDeck.library.click();
	}
}
