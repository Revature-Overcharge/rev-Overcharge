package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimerWidget extends PageFrame {
	
	@FindBy(id = "timerStatus")
	public WebElement status;
	@FindBy(id = "mode_Text")
	public WebElement mode;
	@FindBy(id = "timerContainer")
	public WebElement timerContainer;
	
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
