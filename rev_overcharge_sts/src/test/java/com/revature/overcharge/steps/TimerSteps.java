package com.revature.overcharge.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	@Given("User is on any page")
	public void user_is_on_any_page() {
		driver.get(timer.url);
	}
	
	@Given("User is logged in")
	public void user_is_logged_in() {
		assertTrue(timer.logoutBtn.isDisplayed());
	}

	@Given("Timer is not visible")
	@Then("Timer is not visible")
	public void timer_is_not_visible() {
	    assertEquals("none",timer.timerContainer.getCssValue("display"));
	}

	@When("User clicks toggle visibility button")
	public void user_clicks_toggle_visibility_button() {
	    timer.timerLink.click();
	}
	
	@Given("Timer is visible")
	@Then("Timer is visible")
	public void timer_is_visible() {
		assertEquals("block", timer.timerContainer.getCssValue("display"));
	}

	@When("User clicks start button")
	public void user_clicks_start_button() {
	    timer.playTimer.click();
	}

	@Then("Timer starts counting down")
	public void timer_starts_counting_down() {
		assertEquals("Active", timer.status.getText());
	}

	@Given("Timer is active")
	public void timer_is_active() {
		assertEquals("Active", timer.status.getText());
	}

	@When("User clicks pause button")
	public void user_clicks_pause_button() {
	    timer.pauseTimer.click();
	}

	@Then("Timer activity is paused")
	public void timer_activity_is_paused() {
	    assertEquals("Paused", timer.status.getText());
	}

	@Given("Timer is not at initial value")
	public void timer_is_not_at_initial_value() {
	    assertNotEquals("Inactive", timer.status.getText());
	}

	@When("User clicks reset button")
	public void user_clicks_reset_button() {
	    timer.resetTimer.click();
	}

	@Then("Timer is reset to initial value")
	public void timer_is_reset_to_initial_value() {
	    assertEquals("Inactive", timer.status.getText());
	}

	@When("Timer cycle is complete")
	public void timer_cycle_is_complete() {
	    assertEquals("00:00:00", timer.display.getText());
	}

	@Then("Timer is complete")
	public void timer_is_complete() {
	    assertEquals("Complete", timer.status.getText());
	}

	@Given("Timer is on Study Mode")
	@Then("Timer is on Study Mode")
	public void timer_is_on_study_mode() {
	    assertEquals("Study", timer.mode.getText());
	}

	@When("User clicks toggle mode button")
	public void user_clicks_toggle_mode_button() {
	    timer.modeToggle.click();
	}
	
	@Given("Timer is on Break Mode")
	@Then("Timer is on Break Mode")
	public void timer_is_on_break_mode() {
	    assertEquals("Break", timer.mode.getText());
	}

	@Given("Timer input is not visible")
	@Then("Timer input is not visible")
	public void timer_input_is_not_visible() {
	    assertFalse(timer.inputContainer.isDisplayed());
	}

	@When("User clicks toggle input button")
	public void user_clicks_toggle_input_button() {
	    timer.inputToggle.click();
	}
	
	@Given("Timer input is visible")
	@Then("Timer input is visible")
	public void timer_input_is_visible() {
	    assertTrue(timer.inputContainer.isDisplayed());
	}

	@When("User inputs {int} hours")
	public void user_inputs_hours(String str) {
	    timer.hoursInput.sendKeys(str);
	}

	@When("User inputs {int} minutes")
	public void user_inputs_minutes(String str) {
		timer.minInput.sendKeys(str);
	}

	@When("User clicks set timer button")
	public void user_clicks_set_timer_button() {
	    timer.setTimer.click();
	}

	@Then("Timer initial value is {int}")
	public void timer_initial_value_is(String str) {
		assertEquals(str, timer.display.getText());
	}
}
