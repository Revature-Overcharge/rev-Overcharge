package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFrame {
	public WebDriver driver;
	
	//Specific SideNav and Header elements
	
	public PageFrame(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
