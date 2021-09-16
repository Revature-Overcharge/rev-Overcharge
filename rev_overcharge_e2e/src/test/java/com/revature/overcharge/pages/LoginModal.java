package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Jordan Hupp
 * 
 * This class represents a modal.
 *
 */
public class LoginModal {
	
	protected WebDriver driver;
	
	@FindBy(id = "loginModal")
	public WebElement loginModal;
	
	@FindBy(className = "close")
	public WebElement exitButton;
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy(id = "inputUname")
	public WebElement usernameInput;
	@FindBy(id = "inputPass")
	public WebElement passwordInput;
	
	@FindBy(id = "responseMessage")
	public WebElement responseMessage;

	public LoginModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}

}
