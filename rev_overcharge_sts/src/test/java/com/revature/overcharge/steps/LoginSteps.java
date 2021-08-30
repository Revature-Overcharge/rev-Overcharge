package com.revature.overcharge.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.overcharge.pages.LoginModal;
import com.revature.overcharge.pages.PageFrame;
import com.revature.overcharge.runners.LoginRunner;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private static WebDriver driver = LoginRunner.driver;
	private static WebDriverWait wait = new WebDriverWait(driver, 10);
	private static PageFrame page = LoginRunner.page;
	private static LoginModal modal = LoginRunner.modal;

    @Given("^User has nagivated to the website$")
    public void user_has_nagivated_to_the_website() throws Throwable {
        page.navigateTo(page.getURL());
    }

    @Given("^User opens the login modal$")
    public void user_opens_the_login_modal() throws Throwable {
        page.loginNav.click();
        wait.withTimeout(Duration.ofSeconds(1));
    }

    @Given("^User is logged in$")
    public void user_is_logged_in() throws Throwable {
    	//TODO Finish this
        user_opens_the_login_modal();
        
    }

    @When("^User clicks \"([^\"]*)\"$")
    public void user_clicks_something(String button) throws Throwable {
        switch (button) {
        case "Sidenav Login":
        	page.loginNav.click();
        	break;
        case "Header Login":
        	page.loginHeader.click();
        	break;
        case "Logout":
        	page.logoutBtn.click();
        	break;
        case "Login":
        	modal.loginButton.click();
        	break;
        case "Exit":
        	modal.exitButton.click();
        	break;
        }
        wait.withTimeout(Duration.ofSeconds(1));
    }

    @When("^User logs in with \"([^\"]*)\" credentials$")
    public void user_logs_in_with_something_credentials(String credType) throws Throwable {
        String username = "";
        String password = "";
        
    	switch(credType) {
        case "valid":
        	username = "user";
        	password = "pass";
        	break;
        case "invalid":
        	username = "username";
        	password = "password";
        	break;
        }
    	modal.usernameInput.sendKeys(username);
    	modal.passwordInput.sendKeys(password);
    	user_clicks_something("Login");
    	wait.withTimeout(Duration.ofSeconds(1));
    	
    }

    @When("^User produces a login error$")
    public void user_produces_a_login_error() throws Throwable {
    	//TODO
        throw new PendingException();
    }

    @Then("^Login modal is displayed$")
    public void login_modal_is_displayed() throws Throwable {
    	ExpectedConditions.visibilityOf(modal.loginModal);
    }

    @Then("^Modal displays \"([^\"]*)\" message$")
    public void modal_displays_something_message(String msgType) throws Throwable {
        String message = "";
        
        switch (msgType) {
        case "Success":
        	message = "Success! Logging in...";
        	break;
        case "Failure":
        	message = "Incorrect credentials";
        	break;
        case "Error":
        	message = "Login Error...";
        	break;
        }
        
        ExpectedConditions.textToBePresentInElement(modal.responseMessage, message);
    }

    @Then("^Username is removed$")
    public void username_is_removed() throws Throwable {
        ExpectedConditions.textToBePresentInElement(page.menuBtn, "Guest");
    }
    
    @Then("^Modal closes$")
    public void modal_closes() throws Throwable {
        ExpectedConditions.invisibilityOf(modal.loginModal);
    }

    @And("^Username is displayed$")
    public void username_is_displayed() throws Throwable {
        ExpectedConditions.textToBePresentInElement(page.menuBtn, "user");
    }

    @And("^Login buttons disappear$")
    public void login_buttons_disappear() throws Throwable {
        ExpectedConditions.invisibilityOf(page.loginNav);
        ExpectedConditions.invisibilityOf(page.loginHeader);
        ExpectedConditions.visibilityOf(page.logoutBtn);
    }

    @And("^User is redirected$")
    public void user_is_redirected() throws Throwable {
        ExpectedConditions.urlToBe("http://localhost:4200/library");
    }

    @And("^Login buttons appear$")
    public void login_buttons_appear() throws Throwable {
        ExpectedConditions.visibilityOf(page.loginNav);
        ExpectedConditions.visibilityOf(page.loginHeader);
        ExpectedConditions.invisibilityOf(page.logoutBtn);
    }

}
