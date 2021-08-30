package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CardPage {
	
	public WebDriver driver;
	
	public CardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
