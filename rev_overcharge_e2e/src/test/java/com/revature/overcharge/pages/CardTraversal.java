package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardTraversal {

	public WebDriver driver;
	
	@FindBy(id = "loginNavLink")
	public WebElement login;
	
	@FindBy(id = "inputUname")
	public WebElement inputUname;
	
	@FindBy(id = "inputPass")
	public WebElement inputPass;
	
	@FindBy(id = "loginButton")
	public WebElement loginButton;
	
	@FindBy(id = "libararyNavLink")
	public WebElement library;
	
	@FindBy(id = "cardrunner")
	public WebElement cardrunner;
	
	@FindBy(id = "nextquestion")
	public WebElement nextquestion;
	
	@FindBy(id = "prevquestion")
	public WebElement prevquestion;
	
	@FindBy(id = "star5")
	public WebElement star5;
	
	@FindBy(id = "submitrating")
	public WebElement submitrating;
	
	@FindBy(id = "homeNavLink")
	public WebElement home;
	
	@FindBy(id = "mastered")
	public WebElement mastered;
	
	@FindBy(id = "menuBtn")
	public WebElement menuBtn;
	
	@FindBy(id = "logoutHeaderBtn")
	public WebElement logoutHeaderBtn;
	
	public CardTraversal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
