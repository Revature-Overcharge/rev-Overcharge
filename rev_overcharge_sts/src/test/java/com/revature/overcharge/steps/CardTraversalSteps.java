package com.revature.overcharge.steps;

import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.CreateDeck;
import com.revature.overcharge.runners.CreateDeckRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CardTraversalSteps {
	public static CreateDeck createDeck = CreateDeckRunner.createDeck;
	public static WebDriver driver = CreateDeckRunner.driver;

	@Given("Has nagivated to the website")
	public void has_nagivated_to_the_website() {
		driver.get("http://localhost:4200/home");
	}

	@Given("User Logs in")
	public void user_logs_in() {
		createDeck.login.click();
	}

	@When("User navigates to the library section in side nav")
	public void user_navigates_to_the_library_section_in_side_nav() {
		createDeck.inputUname.sendKeys("user" + "\n");
	}

	@Then("User has option to create a deck")
	public void user_has_option_to_create_a_deck() {
		createDeck.inputPass.sendKeys("pass" + "\n");
	}

	@Then("User creates a deck")
	public void user_creates_a_deck() {
		createDeck.loginButton.click();
	}

	@Then("User enters proper values to create a deck")
	public void user_enters_proper_values_to_create_a_deck() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("A new deck will be created")
	public void a_new_deck_will_be_created() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
