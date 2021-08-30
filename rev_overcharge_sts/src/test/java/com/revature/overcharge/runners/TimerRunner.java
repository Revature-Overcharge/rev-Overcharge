package com.revature.overcharge.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.revature.overcharge.pages.TimerWidget;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/overcharge/features/Timer.feature",
			glue = {"com.revature.overcharge.steps", "TimerSteps"})
public class TimerRunner extends Runner {

	public static TimerWidget timer;
	
	@BeforeClass
	public static void specificSetup() {
		timer = new TimerWidget(driver);
	}
}

