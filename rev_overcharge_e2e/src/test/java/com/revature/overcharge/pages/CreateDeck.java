package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDeck {

	public WebDriver driver;
	
	@FindBy(id = "loginNavLink")
	public WebElement login;
	
	@FindBy(id = "inputUname")
	public WebElement inputUname;
	
	@FindBy(id = "inputPass")
	public WebElement inputPass;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy(id = "createNavLink")
	public WebElement createset;
	
	@FindBy(id = "floatingInputValue")
	public WebElement floatingInputValue;
	
	@FindBy(id = "addeditcards")
	public WebElement addeditcards;
	
	@FindBy(id = "addrow")
	public WebElement addrow;
	
	@FindBy(id = "cardquestion")
	public WebElement cardquestion;
	
	@FindBy(id = "cardanswer")
	public WebElement cardanswer;
	
	@FindBy(id = "savebutton")
	public WebElement savebutton;
	
	@FindBy(id = "create-button")
	public WebElement createdeck;
	


	
	@FindBy(id = "libararyNavLink")
	public WebElement library;
	
	public CreateDeck(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
