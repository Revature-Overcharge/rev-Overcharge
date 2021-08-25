package com.revature.overcharge.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.revature.overcharge.pages.TimerWidget;
import com.revature.overcharge.runners.TimerRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimerSteps {
	
	final static Logger log = Logger.getLogger(TimerSteps.class);
	
	public static WebDriver driver = TimerRunner.driver;
	public static TimerWidget timer = TimerRunner.timer;

    @Given("^User has navigated to the website$")
    public void user_has_navigated_to_the_website() throws Throwable {
    	driver.get(timer.url);
    }
    
    @Given("^User shows Timer$")
    public void user_shows_timer() throws Throwable {
    	timer.timerLink.click();
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
    	}
    	assertEquals(css,timer.timerContainer.getCssValue("display"));
    }

    @When("^User clicks \"([^\"]*)\"$")
    public void user_clicks_something(String button) throws Throwable {
    	switch (button) {
		case "Timer":
			timer.timerLink.click();
			break;
		case "Play":
			timer.playTimer.click();
			break;
		case "Pause":
			timer.pauseTimer.click();
			break;
		case "Reset":
			timer.resetTimer.click();
			break;
		case "Change Mode":
			timer.modeToggle.click();
			break;
		case "Display Input":
			timer.inputToggle.click();
			break;
    	}
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @When("^Timer display is \"([^\"]*)\"$")
    public void timer_display_is_something(String display) throws Throwable {
    	assertEquals(display, timer.display.getText());
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
    	assertEquals(css,timer.timerContainer.getCssValue("display"));
    }

    @Then("^Timer status is \"([^\"]*)\"$")
    public void timer_status_is_something(String status) throws Throwable {
    	assertEquals(status, timer.status.getText());
    }

    @Then("^Timer mode changes to \"([^\"]*)\"$")
    public void timer_mode_changes_to_something(String mode) throws Throwable {
        assertEquals(mode, timer.mode.getText());
    }

    @Then("^Timer is set to (.+)$")
    public void timer_is_set_to(String newTime) throws Throwable {
    	assertEquals(newTime, timer.display.getText());
    }

    @And("^User inputs (.+) and (.+)$")
    public void user_inputs_and(String hours, String minutes) throws Throwable {
    	timer.hoursInput.sendKeys(hours);
    	timer.minInput.sendKeys(minutes);
	    timer.setTimer.click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @And("^Timer mode is \"([^\"]*)\"$")
    public void timer_mode_is_something(String mode) {
    	assertEquals(mode, timer.mode.getText());
    }
}
