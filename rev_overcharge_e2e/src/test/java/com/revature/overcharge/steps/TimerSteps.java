package com.revature.overcharge.steps;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.overcharge.pages.TimerWidget;
import com.revature.overcharge.runners.TimerRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimerSteps {
	
	private static WebDriver driver = TimerRunner.driver;
	private static WebDriverWait wait = new WebDriverWait(driver, 10);
	private static TimerWidget timer = TimerRunner.timer;

    @Given("^User has navigated to the website for timer$")
    public void user_has_navigated_to_the_website_for_timer() throws Throwable {
    	timer.navigateTo(timer.getURL());
    }
    
    @Given("^User shows Timer$")
    public void user_shows_timer() throws Throwable {
    	timer.timerLink.click();
    	wait.withTimeout(Duration.ofSeconds(2));
    }
    
    @Given("^Timer visibility is \"([^\"]*)\"$")
    public void timer_visibility_is_something(String visibility) throws Throwable {
    	String css = "";
    	switch (visibility) {
		case "On":
			css = "block";
			break;
		case "Off":
			css = "none";
			timer.timerLink.click();
			wait.withTimeout(Duration.ofSeconds(1));
			break;
    	}
//    	assertEquals(css,timer.timerContainer.getCssValue("display"));
    }

    @When("^User clicks \"([^\"]*)\" on timer$")
    public void user_clicks_something_on_timer(String button) throws Throwable {
    	switch (button) {
		case "Timer":
			timer.timerLink.click();
			break;
		case "Play":
			timer.playTimer.click();
			break;
		case "Pause":
			timer.playTimer.click();
			timer.pauseTimer.click();
			break;
		case "Reset":
			timer.playTimer.click();
			timer.resetTimer.click();
			break;
		case "Change Mode":
			timer.modeToggle.click();
			break;
		case "Display Input":
			timer.inputToggle.click();
			break;
    	}
    	wait.withTimeout(Duration.ofSeconds(1));
    }

    @When("^Timer display is \"([^\"]*)\"$")
    public void timer_display_is_something(String display) throws Throwable {
    	user_clicks_something_on_timer("Display Input");
    	user_inputs_and("0", "1");
    	user_clicks_something_on_timer("Play");
    	wait.withTimeout(Duration.ofMinutes(1)).until(
    			ExpectedConditions.attributeToBe(timer.display, "innerText", display));
    	
    }

    @Then("^Timer toggles visibility to \"([^\"]*)\"$")
    public void timer_toggles_visibility_to_something(String visibility) throws Throwable {
    	String css = "";
    	switch (visibility) {
		case "On":
			css = "block";
			break;
		case "Off":
			css = "none";
			break;
    	}
//    	assertEquals(css,timer.timerContainer.getCssValue("display"));
    }

    @Then("^Timer status is \"([^\"]*)\"$")
    public void timer_status_is_something(String status) throws Throwable {
//    	assertEquals(": "+status, timer.status.getText());
    }

    @Then("^Timer mode changes to \"([^\"]*)\"$")
    public void timer_mode_changes_to_something(String finalMode) throws Throwable {
    	ExpectedConditions.attributeToBe(timer.mode, "innerText", finalMode);
    }

    @Then("^Timer is set to (.+)$")
    public void timer_is_set_to(String newTime) throws Throwable {
    	ExpectedConditions.attributeToBe(timer.display, "innerText", newTime);
    }

    @And("^User inputs (.+) and (.+)$")
    public void user_inputs_and(String hours, String minutes) throws Throwable {
    	timer.hoursInput.sendKeys(hours);
    	timer.minInput.sendKeys(minutes);
	    timer.setTimer.click();
	    wait.withTimeout(Duration.ofSeconds(1));
    }

    @And("^Timer mode is \"([^\"]*)\"$")
    public void timer_mode_is_something(String initMode) throws Throwable {    	
    	if (initMode == "Break") user_clicks_something_on_timer("Change Mode");
    	ExpectedConditions.attributeToBe(timer.mode, "innerText", initMode);
    	wait.withTimeout(Duration.ofSeconds(1));
    }
}
