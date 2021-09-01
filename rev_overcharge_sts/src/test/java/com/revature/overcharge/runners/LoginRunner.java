package com.revature.overcharge.runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.revature.overcharge.pages.LoginModal;
import com.revature.overcharge.pages.PageFrame;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/overcharge/features/Login.feature",
		glue = {"com.revature.overcharge.steps", "LoginSteps"})
public class LoginRunner extends Runner {
	
	public static PageFrame page;
	public static LoginModal modal;
	
	@BeforeClass
	public static void specificSetup() {
		page = new PageFrame(driver);
		modal = new LoginModal(driver);
	}

}
