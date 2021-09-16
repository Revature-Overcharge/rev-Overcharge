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

	@FindBy(xpath = "//*[@id=\"toastMessage\"]/div/b")
	public WebElement loginToastMessage;

	@FindBy(id = "inputUname")
	public WebElement inputUname;

	@FindBy(id = "inputPass")
	public WebElement inputPass;

	@FindBy(id = "loginButton")
	public WebElement loginButton;

	@FindBy(id = "logoutHeaderBtn")
	public WebElement logoutBtn;

	@FindBy(id = "libraryNavLink")
	public WebElement libraryTab;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[1]/td[4]/button")
	public WebElement firstStudyBtn;

	@FindBy(id = "nextquestion")
	public WebElement nextQuestionBtn;

	@FindBy(id = "star5")
	public WebElement starFive;

	@FindBy(id = "submitrating")
	public WebElement submitRatingBtn;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-cardrunner/div/div[2]/div[3]/h2")
	public WebElement finishDeckText;

	@FindBy(id = "return")
	public WebElement returnToLibrary;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[2]/td[4]/button")
	public WebElement secondStudyBtn;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-objectives/div/div[2]/div/div/div[2]/ul/div[3]/div")
	public WebElement fiveStarRatingProgressBar;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-objectives/div/div[2]/div/div/div[1]/ul/div[1]/div")
	public WebElement rateDeckProgressBar;

	@FindBy(id = "mastered")
	public WebElement masterBtn;

	@FindBy(xpath = "//*[@id=\"tableContainer\"]/table/tbody/tr[1]/td[5]/button")
	public WebElement addEditBtn;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[14]/td")
	public WebElement addCardBtn;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[15]/td")
	public WebElement addCardBtnAgain;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[16]/td")
	public WebElement addCardBtnAgainAgain;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[17]/td")
	public WebElement addCardBtnAgain3;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[18]/td")
	public WebElement addCardBtnAgain4;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[15]/td[2]/input")
	public WebElement questionInput;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[15]/td[3]/input")
	public WebElement answerInput;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[16]/td[2]/input")
	public WebElement questionInput2;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[16]/td[3]/input")
	public WebElement answerInput2;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[17]/td[2]/input")
	public WebElement questionInput3;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[17]/td[3]/input")
	public WebElement answerInput3;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[18]/td[2]/input")
	public WebElement questionInput4;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/table/tbody/tr[18]/td[3]/input")
	public WebElement answerInput4;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[3]/button")
	public WebElement saveBtn;

	@FindBy(id = "createNavLink")
	public WebElement createDeckTab;

	@FindBy(id = "floatingInputValue")
	public WebElement deckTitleInput;

	@FindBy(id = "create-button")
	public WebElement createDeckBtn;

	public Objectives(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
