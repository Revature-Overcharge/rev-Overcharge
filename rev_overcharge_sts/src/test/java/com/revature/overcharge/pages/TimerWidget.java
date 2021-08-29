package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Jordan Hupp
 *
 * This class represents a widget in the sidenav.
 *
 */
public class TimerWidget extends PageFrame {
	
	@FindBy(id = "timerStatus")
	public WebElement status;
	@FindBy(id = "mode_Text")
	public WebElement mode;
	@FindBy(id = "timerContainer")
	public WebElement timerContainer;
	@FindBy(tagName = "countdown")
	public WebElement display;
	
	@FindBy(id = "hours_mins_container")
	public WebElement inputContainer;
	@FindBy(id = "hours")
	public WebElement hoursInput;
	@FindBy(id = "minutes")
	public WebElement minInput;
	
	@FindBy(id = "playTimer")
	public WebElement playTimer;
	@FindBy(id = "pauseTimer")
	public WebElement pauseTimer;
	@FindBy(id = "resetTimer")
	public WebElement resetTimer;
	
	@FindBy(id = "setTimer")
	public WebElement setTimer;
	@FindBy(id = "modeToggle")
	public WebElement modeToggle;
	@FindBy(id = "timerInputToggle")
	public WebElement inputToggle;

	public TimerWidget(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
