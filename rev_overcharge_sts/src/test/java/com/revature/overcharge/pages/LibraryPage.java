package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryPage {

	public WebDriver driver;
	
	@FindBy(id = "libraryNavLink")
	public WebElement libraryPageBtn;
	
	@FindBy(id = "loginNavLink")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[3]/td[4]/button")
	public WebElement thirdDeck;

	
	public LibraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
