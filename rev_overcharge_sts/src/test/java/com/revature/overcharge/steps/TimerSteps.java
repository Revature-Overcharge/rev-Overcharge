package com.revature.overcharge.steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.TimerWidget;
import com.revature.overcharge.runners.TimerRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimerSteps {
	
	final static Logger log = Logger.getLogger(TimerSteps.class);
	
	public static WebDriver driver = TimerRunner.driver;
	public static TimerWidget timer = TimerRunner.timer;

	@Given("User is logged in")
	public void user_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		timer.logoutBtn.isDisplayed();
	}

	@Given("Timer is not visible")
	@Then("Timer is not visible")
	public void timer_is_not_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    timer.timerContainer.getCssValue("display").equals("none");
	}

	@When("User clicks toggle visibility button")
	public void user_clicks_toggle_visibility_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("Timer is visible")
	@Then("Timer is visible")
	public void timer_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
		timer.timerContainer.getCssValue("display").equals("block");
	}

	@When("User clicks start button")
	public void user_clicks_start_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Timer starts counting down")
	public void timer_starts_counting_down() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Timer is active")
	public void timer_is_active() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks pause button")
	public void user_clicks_pause_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Timer activity is paused")
	public void timer_activity_is_paused() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Timer is not at initial value")
	public void timer_is_not_at_initial_value() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks reset button")
	public void user_clicks_reset_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Timer is reset to initial value")
	public void timer_is_reset_to_initial_value() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Timer cycle is complete")
	public void timer_cycle_is_complete() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Modal pops up to notify User")
	public void modal_pops_up_to_notify_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Timer is on Study Mode")
	@Then("Timer is on Study Mode")
	public void timer_is_on_study_mode() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks toggle mode button")
	public void user_clicks_toggle_mode_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("Timer is on Break Mode")
	@Then("Timer is on Break Mode")
	public void timer_is_on_break_mode() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Timer input is not visible")
	@Then("Timer input is not visible")
	public void timer_input_is_not_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks toggle input button")
	public void user_clicks_toggle_input_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("Timer input is visible")
	@Then("Timer input is visible")
	public void timer_input_is_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User inputs {int} hours")
	public void user_inputs_hours(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User inputs {int} minutes")
	public void user_inputs_minutes(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks set timer button")
	public void user_clicks_set_timer_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Timer initial value is {int}")
	public void timer_initial_value_is(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
