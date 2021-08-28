package com.revature.overcharge.steps;

import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.CardTraversal;
import com.revature.overcharge.runners.CardTraversalRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class CardTraversalSteps {
	public static CardTraversal cardTraversal = CardTraversalRunner.cardTraversal;
	public static WebDriver driver = CardTraversalRunner.driver;

	@Given("User has nagivated to the website")
	public void user_has_nagivated_to_the_website() {
		driver.get("http://localhost:4200/home");
	}

	@Given("User has Logged in")
	public void user_has_logged_in() {
		cardTraversal.login.click();
		cardTraversal.inputUname.sendKeys("user" + "\n");
		cardTraversal.inputPass.sendKeys("pass" + "\n");
		cardTraversal.loginButton.click();
	}

	@When("User navigates to the library section in side nav")
	public void user_navigates_to_the_library_section_in_side_nav() {
		cardTraversal.library.click();
	}

	@Then("User has option to click card runner")
	public void user_has_option_to_click_card_runner() {
		cardTraversal.cardrunner.click();
	}

	@Then("User traverses a deck")
	public void user_traverses_a_deck() {
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
		cardTraversal.nextquestion.click();
	}

	@Then("User clicks finish set")
	public void user_clicks_finish_set() {
		cardTraversal.nextquestion.click();
	}
	
	@Then("User enters a rating to submit")
	public void user_enters_a_rating_to_submit() {
		cardTraversal.star5.click();
		cardTraversal.submitrating.click();
	}
}
