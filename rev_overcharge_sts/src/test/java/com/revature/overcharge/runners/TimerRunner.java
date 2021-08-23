package com.revature.overcharge.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/overcharge/features/Timer.feature",
			glue = {"com.revature.steps", "LoginSteps"})
public class TimerRunner extends Runner {

	//TODO Add specific pages to the specific runner if needed.
	
	@BeforeClass
	public static void specificSetup() {
		// Make sure that super setup is also running...?
		
	}
	
}

