package com.revature.overcharge.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.CardPage;
import com.revature.overcharge.pages.CardTraversal;
import com.revature.overcharge.pages.LibraryPage;
import com.revature.overcharge.pages.Objectives;
import com.revature.overcharge.runners.ObjectivesWeekly5StarRuner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ObjectivesWeekly5StarSteps {
	
	
	public static WebDriver driver = ObjectivesWeekly5StarRuner.driver;
	
	public static Objectives objectives = ObjectivesWeekly5StarRuner.objectivesPage;
	public static LibraryPage libraryPage = ObjectivesWeekly5StarRuner.libraryPage;
	public static CardTraversal cardPage = ObjectivesWeekly5StarRuner.cardPage;
	
	
	@Given("User is on homepage")
	public void user_is_on_homepage() {
		String url = "http://localhost:4200";
		driver.get(url);
		
	}

	@When("User clicks the login")
	public void user_clicks_the_login() {
		libraryPage.loginButton.click();
	}

	@When("User enters in their username and password")
	public void user_enters_in_their_username_and_password() {
		objectives.inputUname.sendKeys("user");

		objectives.inputPass.sendKeys("pass");

		
	}

	@When("User clicks submit")
	public void user_clicks_submit() throws InterruptedException {
		objectives.loginButton.click();

		Thread.sleep(3000);
	}

	@Given("User on the Library Page")
	public void user_on_the_library_page() throws InterruptedException {
	    libraryPage.libraryPageBtn.click();
		Thread.sleep(1000);

	}

	@When("User clicks on Deck three \\(Spring)")
	public void user_clicks_on_deck_three_spring() throws InterruptedException {
	    libraryPage.thirdDeck.click();
		Thread.sleep(3000);

	}

	@Given("User on the card page")
	public void user_on_the_card_page() {
		System.out.println(cardPage.cardTitle.getText());
	    assertEquals("Cards", cardPage.cardTitle.getText());
	}

	@When("User goes through all the cards")
	public void user_goes_through_all_the_cards() throws InterruptedException {
		for (int i=0; i<17; i++) {
		    cardPage.nextquestion.click();
		    Thread.sleep(300);
		}
	}

	@Then("User rates the deck as five stars")
	public void user_rates_the_deck_as_five_stars() throws InterruptedException {
		cardPage.star5.click();
		cardPage.submitrating.click();
	    Thread.sleep(2000);
	}

	@When("User taps on their username")
	public void user_taps_on_their_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User taps on the logout button")
	public void user_taps_on_the_logout_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should logout and be at homepage")
	public void user_should_logout_and_be_at_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on the objectives page")
	public void user_clicks_on_the_objectives_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User will see")
	public void user_will_see() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
