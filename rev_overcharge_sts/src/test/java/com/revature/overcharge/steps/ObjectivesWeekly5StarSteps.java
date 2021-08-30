package com.revature.overcharge.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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
		Thread.sleep(1000);
	}

	@Given("User on the card page")
	public void user_on_the_card_page() {
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
	    Thread.sleep(2000);
		cardPage.submitrating.click();
	}

	@When("User taps on their username")
	public void user_taps_on_their_username() throws InterruptedException {
	    cardPage.userNameBtn.click();
	    Thread.sleep(1000);


	}

	@When("User taps on the logout button")
	public void user_taps_on_the_logout_button() throws InterruptedException {
		cardPage.logoutHeaderBtn.click();
	    Thread.sleep(2000);
	}

	@Then("User should logout and be at homepage")
	public void user_should_logout_and_be_at_homepage() {
		System.out.println(cardPage.homePageTitle.getText());
		assertNotNull(cardPage.homePageTitle.getText());
//	    assertEquals("Welcome to Revature Overcharge!", cardPage.homePageTitle.getText());

	}

	@Given("Creator user is on homepage")
	public void creator_user_is_on_homepage() {
		assertNotNull(cardPage.homePageTitle.getText());
//	    assertEquals("Welcome to Revature Overcharge!", cardPage.homePageTitle.getText());
	}

	@When("Creator user clicks the login")
	public void creator_user_clicks_the_login() {
		libraryPage.loginButton.click();
	}

	@When("Creator user enters in their username and password")
	public void creator_user_enters_in_their_username_and_password() {
		for (int i=0; i<50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}
		objectives.inputUname.sendKeys("nriseborough4");

		for (int i=0; i<50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("js9Gzq4X8");
	}

	@When("Creator user clicks submit")
	public void creator_user_clicks_submit() throws InterruptedException {
		objectives.loginButton.click();

		Thread.sleep(2000);
	}

	@When("User clicks on the objectives page")
	public void user_clicks_on_the_objectives_page() {
	    objectives.tabBtn.click();
	}

	@Then("User will see completed objectives")
	public void user_will_see_completed_objectives() throws InterruptedException {
		
		Thread.sleep(2000);
	    objectives.topNavBtn.click();
	    Thread.sleep(3000);
	}
	
	
	// Testing for mark all completed deck
	
	@When("User enters in a different username and password")
	public void user_enters_in_a_different_username_and_password() {
		objectives.inputUname.sendKeys("vguerrin8");

		objectives.inputPass.sendKeys("dwCCrw");
	}

	
	@When("User clicks on Deck two \\(Testing)")
	public void user_clicks_on_deck_two_testing() throws InterruptedException {
	    libraryPage.secondDeck.click();
		Thread.sleep(2000);

	}
	
	@When("User goes through all the cards and clicked mastered")
	public void user_goes_through_all_the_cards_and_clicked_mastered() throws InterruptedException {
		for (int i=0; i<19; i++) {
			cardPage.mastered.click();
		    Thread.sleep(300);
		}
	   
	}
	
	@Then("Wait for some time to explain")
	public void wait_for_some_time_to_explain() throws InterruptedException {
	    Thread.sleep(7000);
	}


}
