package com.revature.overcharge.steps;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.Objectives;
import com.revature.overcharge.runners.ObjectivesRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ObjectivesSteps {

	public static Objectives objectives = ObjectivesRunner.objectives;
	public static WebDriver driver = ObjectivesRunner.driver;

	@Given("User is viewing the app")
	public void user_is_viewing_the_app() {
		driver.get("http://localhost:4200/home");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User is not logged in")
	public void user_is_not_logged_in() {
		// assertEquals("account_circle\r\n" + "Guest\r\n" + "keyboard_arrow_down",
		// objectives.userBtn.getText());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the Objectives topnav")
	public void user_clicks_the_objectives_topnav() {
		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Message to login in shown at top")
	public void message_to_login_in_shown_at_top() {
//		assertEquals("Login to See Objectives to get Points!", objectives.topNavBtnMessage.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the Objectives sidenav")
	public void user_clicks_the_objectives_sidenav() {
		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Message to login is shown in the middle")
	public void message_to_login_is_shown_in_the_middle() {
//		assertEquals("Login to See Objectives and Get Some Points!", objectives.tabBtnMessage.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User logs in for the first time")
	public void user_logs_in_for_the_first_time() {
		objectives.loginTab.click();

		objectives.inputUname.sendKeys("wblackley5" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.inputPass.sendKeys("D2BNKoim" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Login objective toast appears")
	public void login_objective_toast_appears() {
		// assertEquals("Received +10 points for Logging In!",
		// objectives.loginToastMessage.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User without a deck is logged in")
	public void user_without_a_deck_is_logged_in() {
		objectives.userBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.logoutBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginTab.click();

		for (int i = 0; i < 50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputUname.sendKeys("tholburn7" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("2E2LGtacW" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks on Library")
	public void user_clicks_on_library() {
		objectives.libraryTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks Study")
	public void user_clicks_study() {
		objectives.firstStudyBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User goes through a deck")
	public void user_goes_through_a_deck() {
		for (int i = 0; i < 19; i++) {
			objectives.nextQuestionBtn.click();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Given("User rates the deck {int} stars")
	public void user_rates_the_deck_stars(Integer int1) {
		int1 = 5;
		
		objectives.starFive.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.submitRatingBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Rate a Deck complete")
	public void tab_shows_rate_a_deck_complete() {
		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Rate a Deck complete")
	public void objectives_show_rate_a_deck_complete() {
		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User with a {int} star rating on their deck is logged in")
	public void user_with_a_star_rating_on_their_deck_is_logged_in(Integer int1) {
		int1 = 5;

		objectives.userBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.logoutBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputUname.sendKeys("snassey1" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("CwQOZeX" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("Tab shows Get a {int} Star Rating complete")
	public void tab_shows_get_a_star_rating_complete(Integer int1) {
		int1 = 5;

		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Get a {int} Star Rating complete")
	public void objectives_show_get_a_star_rating_complete(Integer int1) {
		int1 = 5;

		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User has not rated a deck, has a deck, and is logged in")
	public void user_has_not_rated_a_deck_has_a_deck_and_is_logged_in() {
		objectives.userBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.logoutBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginTab.click();

		for (int i = 0; i < 50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputUname.sendKeys("jbolsteridge2" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("APU1yVAJO9W" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Given("User clicks Study on a deck they own")
	public void user_clicks_study_on_a_deck_they_own() {
		objectives.libraryTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.secondStudyBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User goes through the deck")
	public void user_goes_through_the_deck() {
		for (int i = 0; i < 19; i++) {
			objectives.nextQuestionBtn.click();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Given("User rates the same deck {int} stars")
	public void user_rates_the_same_deck_stars(Integer int1) {
		int1 = 5;

//		assertEquals("You're all done with this set. Great work!", objectives.finishDeckText.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.returnToLibrary.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the objective topnav")
	public void user_clicks_the_objective_topnav() {
		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Rate a Deck incomplete")
	public void tab_shows_rate_a_deck_incomplete() {
		// assertEquals("0", objectives.rateDeckProgressBar.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Get a {int} Star Rating incomplete")
	public void tab_shows_get_a_star_rating_incomplete(Integer int1) {
		int1 = 5;

		// assertEquals("0", objectives.fiveStarRatingProgressBar.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the objective sidenav")
	public void user_clicks_the_objective_sidenav() {
		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Rate a Deck incomplete")
	public void objectives_show_rate_a_deck_incomplete() {
		// assertEquals("0", objectives.rateDeckProgressBar.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Get a {int} Star Rating incomplete")
	public void objectives_show_get_a_star_rating_incomplete(Integer int1) {
		int1 = 5;

		// assertEquals("0", objectives.fiveStarRatingProgressBar.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User is logged in one")
	public void user_is_logged_in() {

		objectives.userBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.logoutBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginTab.click();

		for (int i = 0; i < 50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputUname.sendKeys("tholburn7" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("2E2LGtacW" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks Mark as Mastered for {int} cards")
	public void user_clicks_mark_as_mastered_for_cards(Integer int1) {
		int1 = 4;

		for (int i = 0; i < 4; i++) {
			objectives.masterBtn.click();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Then("Tab shows Master {int} Cards almost filled")
	public void tab_shows_master_cards_almost_filled(Integer int1) {
		int1 = 5;

		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Mark as Mastered for {int} more card")
	public void user_clicks_mark_as_mastered_for_more_card(Integer int1) {
		int1 = 1;

		objectives.masterBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Master {int} Cards complete")
	public void tab_shows_master_cards_complete(Integer int1) {
		int1 = 5;

		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Master {int} Cards complete")
	public void objectives_show_master_cards_complete(Integer int1) {
		int1 = 5;

		objectives.tabBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User that has a deck is logged in")
	public void user_that_has_a_deck_is_logged_in() {

		objectives.userBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.logoutBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginTab.click();

		for (int i = 0; i < 50; i++) {
			objectives.inputUname.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputUname.sendKeys("snassey1" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			objectives.inputPass.sendKeys(Keys.BACK_SPACE);
		}

		objectives.inputPass.sendKeys("CwQOZeX" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.loginButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks add\\/edit cards")
	public void user_clicks_add_edit_cards() {
		objectives.libraryTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.addEditBtn.click();
	}

	@Given("User adds {int} cards")
	public void user_adds_cards(Integer int1) {
		int1 = 2;

		objectives.addCardBtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.addCardBtnAgain.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.questionInput.sendKeys("question" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.answerInput.sendKeys("answer" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.addCardBtnAgainAgain.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.questionInput2.sendKeys("question?" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.answerInput2.sendKeys("answer!" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.saveBtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Create {int} Cards as halfway")
	public void tab_shows_create_cards_as_halfway(Integer int1) {
		int1 = 4;

		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks add\\/edit cards again")
	public void user_clicks_add_edit_cards_again() {
		objectives.addEditBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User adds {int} more cards")
	public void user_adds_more_cards(Integer int1) {
		objectives.addCardBtnAgain3.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.questionInput3.sendKeys("question!" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.answerInput3.sendKeys("answer?" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.addCardBtnAgain4.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.questionInput4.sendKeys("questions" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.answerInput4.sendKeys("answers" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.saveBtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Create {int} Cards complete")
	public void tab_shows_create_cards_complete(Integer int1) {
		int1 = 4;

		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Create {int} Cards complete")
	public void objectives_show_create_cards_complete(Integer int1) {
		int1 = 4;

		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks on Create \\(should change to Deck rather than Sets)")
	public void user_clicks_on_create_should_change_to_deck_rather_than_sets() {
		objectives.createDeckTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User Creates a Deck")
	public void user_creates_a_deck() {
		objectives.deckTitleInput.sendKeys("Title" + "\n");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.createDeckBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Create a Deck complete")
	public void tab_shows_create_a_deck_complete() {
		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Create a Deck complete")
	public void objectives_show_create_a_deck_complete() {
		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Given("User clicks Mark as Mastered for all cards")
	public void user_clicks_mark_as_mastered_for_all_cards() {
		objectives.libraryTab.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.secondStudyBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 19; i++) {
			objectives.masterBtn.click();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Given("User rates the deck")
	public void user_rates_the_deck() {
		objectives.nextQuestionBtn.click();
		objectives.starFive.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectives.submitRatingBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tab shows Master a Deck complete")
	public void tab_shows_master_a_deck_complete() {
		objectives.topNavBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Objectives show Master a Deck complete")
	public void objectives_show_master_a_deck_complete() {
		objectives.tabBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
