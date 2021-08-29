package com.revature.overcharge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Objectives {

	public WebDriver driver;

	@FindBy(id = "menuBtn")
	public WebElement userBtn;

	@FindBy(id = "objectivesBtn")
	public WebElement topNavBtn;

	@FindBy(xpath = "//*[@id=\"ngb-popover-0\"]/div[2]/div/b")
	public WebElement topNavBtnMessage;

	@FindBy(id = "objectivesNavLink")
	public WebElement tabBtn;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-objectives/div/div[2]/div/div/b")
	public WebElement tabBtnMessage;

	@FindBy(id = "loginNavLink")
	public WebElement loginTab;

	@FindBy(id = "inputUname")
	public WebElement inputUname;

	@FindBy(id = "inputPass")
	public WebElement inputPass;

	@FindBy(id = "loginButton")
	public WebElement loginButton;

	@FindBy(id = "libraryNavLink")
	public WebElement libraryTab;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[1]/td[3]/button")
	public WebElement firstStudyBtn;

	@FindBy(id = "nextquestion")
	public WebElement nextQuestionBtn;

	@FindBy(id = "star5")
	public WebElement starFive;

	@FindBy(id = "submitrating")
	public WebElement submitRatingBtn;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[2]/td[3]/button")
	public WebElement secondStudyBtn;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-objectives/div/div[2]/div/div/div[2]/ul/div[3]/div")
	public WebElement fiveStarRatingProgressBar;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-objectives/div/div[2]/div/div/div[1]/ul/div[1]/div")
	public WebElement rateDeckProgressBar;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[2]/td[3]/button")
	public WebElement secondStudyBtn1;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[2]/td[3]/button")
	public WebElement secondStudyBtn2;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[2]/td[3]/button")
	public WebElement secondStudyBtn3;

	public Objectives(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
