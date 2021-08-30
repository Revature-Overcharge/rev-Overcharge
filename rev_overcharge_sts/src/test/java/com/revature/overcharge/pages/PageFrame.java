                 package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFrame {
	public WebDriver driver;
	public String url = "http://localhost:4200";
	
	//Specific SideNav and Header elements
	@FindBy(id = "homeNavLink")
	public WebElement homeLink;
	
	@FindBy(id = "libraryNavLink")
	public WebElement libraryLink;
	
	@FindBy(id = "objectiveNavLink")
	public WebElement objectiveLink;
	
	@FindBy(id = "createNavLink")
	public WebElement createLink;
	
	@FindBy(id = "timerNavLink")
	public WebElement timerLink;
	
	@FindBy(id = "loginNavLink")
	public WebElement loginNav;
	
	@FindBy(id = "menuHeaderBtn")
	public WebElement menuBtn;
	
	@FindBy(id = "logoutHeaderBtn")
	public WebElement logoutBtn;
	
	@FindBy(id = "loginHeaderBtn")
	public WebElement loginHeader;
	
	public PageFrame(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
