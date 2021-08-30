package com.revature.overcharge.steps;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.overcharge.pages.LoginModal;
import com.revature.overcharge.pages.PageFrame;
import com.revature.overcharge.runners.LoginRunner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private static WebDriver driver = LoginRunner.driver;
	private static WebDriverWait wait = new WebDriverWait(driver, 10);
	private static PageFrame page = LoginRunner.page;
	private static LoginModal modal = LoginRunner.modal;

    @Given("^User has nagivated to the website for login$")
    public void user_has_nagivated_to_the_website_for_login() throws Throwable {
        page.navigateTo(page.getURL());
        Thread.sleep(2000);
    }

    @Given("^User opens the login modal$")
    public void user_opens_the_login_modal() throws Throwable {
        page.loginNav.click();
        wait.withTimeout(Duration.ofSeconds(1));
        Thread.sleep(2000);
    }

    @Given("^User is logged in$")
    public void user_is_logged_in() throws Throwable {
        user_opens_the_login_modal();
        user_logs_in_with_something_credentials("valid");
        username_is_displayed();
        
    }

    @When("^User clicks \"([^\"]*)\" for login$")
    public void user_clicks_something_for_login(String button) throws Throwable {
        switch (button) {
        case "Sidenav Login":
        	page.loginNav.click();
        	break;
        case "Header Login":
        	page.menuBtn.click();
        	wait.withTimeout(Duration.ofSeconds(1));
        	page.loginHeader.click();
        	break;
        case "Logout":
        	page.menuBtn.click();
        	wait.withTimeout(Duration.ofSeconds(1));
        	page.logoutBtn.click();
        	break;
        case "Login":
        	modal.loginButton.click();
        	Thread.sleep(2000);
        	user_clicks_something_for_login("Exit");
        	break;
        case "Exit":
        	modal.exitButton.click();
        	break;
        }
        Thread.sleep(2000);
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
        case "error":
        	// Attempted login with empty strings will produce an error
        	break;
        }
    	modal.usernameInput.sendKeys(username);
    	modal.passwordInput.sendKeys(password);
    	user_clicks_something_for_login("Login");
    	Thread.sleep(2000);
    	
    }

    @When("^User produces a login error$")
    public void user_produces_a_login_error() throws Throwable {
    	user_logs_in_with_something_credentials("error");
    }

    @Then("^Login modal is displayed$")
    public void login_modal_is_displayed() throws Throwable {
    	ExpectedConditions.visibilityOf(modal.loginModal);
    }

    @Then("^Modal displays \"([^\"]*)\" message$")
    public void modal_displays_something_message(String msgType) throws Throwable {
    	Thread.sleep(2000);
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
        
        user_clicks_something_for_login("Logout");
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
