package angular.pageobjects.voucher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.Log;

public class ViewBatchListVoucher {

	/* ---WebElements For Page--- */

	// Home Button
	@FindBy(id = "homeSidebarBtn")
	private WebElement HomeButton;

	// VMS Id
	@FindBy(id = "mat-tab-label-1-1")
	private WebElement vmsTab;

	// View Voucher BatchList Button 
	@FindBy(id = "viewBatchListBtn")
	private WebElement viewBatchListButton;

	// Search By Filter Mobile
	@FindBy(xpath = "//button[@value='mobNumber']")
	private WebElement filterByMobile;

	// Search By Filter Batch Number
	@FindBy(xpath = "//button[@value='batchNumber']")
	private WebElement filterByBatchNumber;

	// Search By Filter Schedule Period
	@FindBy(xpath = "//button[@value='scheduled']")
	private WebElement filterBySchedulePeriod;

	// Search By Filter Advance
	@FindBy(xpath = "//button[@value='advanced']")
	private WebElement filterByAdvance;

	// Mobile Number Input Field
	@FindBy(xpath = "//input[@formcontrolname='msisdn']")
	private WebElement mobileNumberInput;

	// Batch Number Input Field
	@FindBy(xpath = "//input[@formcontrolname='batchNo']")
	private WebElement batchNumberInput;

	// Scheduled Period Input
	@FindBy(xpath = "//button[@value='scheduled']//following::div[@class='ng-input']//following::span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement schedulePeriodDropDown;

	// Select Schedule Period as last 3 days
	@FindBy(xpath = "(//button[@value='scheduled']//following::div[@class='ng-input']//following::div[contains(@class,'ng-dropdown-panel-items')]//span)[1]")
	private WebElement threeDaysPeriod;

	// Select Schedule Period as all
	@FindBy(xpath = "(//button[@value='scheduled']//following::div[@class='ng-input']//following::div[contains(@class,'ng-dropdown-panel-items')]//span)[2]")
	private WebElement schedulePeriodAll;

	// Status Input for Advance
	@FindBy(xpath = "((//button[@value='scheduled']//following::div[@class='ng-input'])[1])//following::span[contains(@class,'ng-arrow-wrapper')][1]")
	private WebElement advanceStatusInput;

	// Select Advance status all
	@FindBy(xpath = "(((//button[@value='scheduled']//following::div[@class='ng-input'])[1])//following::div[contains(@class,'ng-dropdown')]//following::span)[8]")
	private WebElement advanceStatusAll;

	// Select Advance Type all
	@FindBy(xpath = "(((//button[@value='scheduled']//following::div[@class='ng-input'])[2])//following::div[contains(@class,'ng-dropdown')]//following::span)[11]")
	private WebElement advanceTypeAll;

	// Type Input for Advance
	@FindBy(xpath = "((//button[@value='scheduled']//following::div[@class='ng-input'])[2])//following::span[contains(@class,'ng-arrow-wrapper')][1]")
	private WebElement advanceTypeInput;

	// Proceed Button
	@FindBy(id = "proceeedbtn")
	private WebElement submitButton;

	// Reset Button
	@FindBy(id = "resetbtn")
	private WebElement resetButton;

	// Batch Details Section
	@FindBy(xpath = "//label[@class='voucherDetails']")
	private WebElement batchDetailsSection;

	// Batch Details Tab
	@FindBy(xpath = "//label[@for='view_batch_list']")
	private WebElement batchDetailsTab;

	//View Batch Details bread crub link
	@FindBy(xpath = "//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]")
	private WebElement viewBatchDetailsBreadCrub;
	
	//View Batch List Return Link
	@FindBy(xpath = "//a[@href='/vmsui/viewBatch']")
	private WebElement viewBatchReturn;
	
	//Batch Number
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[7]")
	private WebElement batchNumberId;
	
	//Batch Type
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[9]")
	private WebElement batchType;
	
	//profile
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[13]")
	private WebElement profileName;
	
	//No Of Voucher
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[15]")
	private WebElement noVoucher;
	
	//From Serial Number
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[17]")
	private WebElement fromSerialNumber;
	
	//To Serial Number
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[19]")
	private WebElement toSerialNumber;
	
	//Success Count
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[21]")
	private WebElement successCount;
	
	//Fail Count
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[23]")
	private WebElement failCount;
	
	//Created On
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[25]")
	private WebElement createdOn;
	
	//User
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[27]")
	private WebElement userViewBtachDetail;
	
	//Mobile Number on View
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[29]")
	private WebElement mobileNumberOnView;
	
	//Message on Batch View
	@FindBy(xpath = "(//a[@href='/vmsui/viewBatch']//following::li[contains(@class,'active')]//following::span)[51]")
	private WebElement messageOnBatchView;
	
	
	
	/*----- WebDriver Declaration -----*/
	WebDriver driver = null;
	WebDriverWait wait = null;

	public ViewBatchListVoucher(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* -----View BatchList Basic Function----- */

	// Select VMS Page
	public void selectVMSTab() {
		Log.info("Trying to select VMS tab");
		wait.until(ExpectedConditions.visibilityOf(HomeButton));
		wait.until(ExpectedConditions.visibilityOf(vmsTab)).click();
		Log.info("VMS tab selected successfully");
	}

	// Select View Batch List Link
	public void selectViewBatchList() {
		Log.info("Clicking on view batch list");
		wait.until(ExpectedConditions.visibilityOf(viewBatchListButton)).click();
		Log.info("Clicked on view batch list");
	}

	//Search Result of batch details
	public boolean verifyBatchDetailsTabLoadedSuccessfully() {
		try {
			Log.info("Checking for Batch Detail page loaded upon search");
			wait.until(ExpectedConditions.visibilityOf(batchDetailsTab));
			Log.info("Batch Details page loaded successfully");
			return true;
		}catch (Exception e) {
			Log.info("Batch Details page not loaded successfully");
			return false;
		}		

	}

	// Verify view batch page loaded after clicking view batch link
	public void verifyViewBatchListPageLoadedSuccessfully() {
		Log.info("Checking if the view batch list page loaded successfully");
		wait.until(ExpectedConditions.visibilityOf(filterByMobile));
		Log.info("View Batch List Page Loaded successfully");
	}

	// Mobile filter tab selection
	public void serchFilterByMobile() {
		Log.info("Selecting filter Mobile");
		wait.until(ExpectedConditions.visibilityOf(filterByMobile)).click();
		Log.info("Selected filter as Mobile");
	}
	
	// Advance filter tab selection
		public void serchFilterByAdvance() {
			Log.info("Selecting filter Advance");
			wait.until(ExpectedConditions.visibilityOf(filterByAdvance)).click();
			Log.info("Selected filter as Advance");
		}

	//Input Mobile Number
	public void inputDataForMobile(String s) {
		Log.info("Trying input mobile number in search filter");
		wait.until(ExpectedConditions.visibilityOf(mobileNumberInput)).sendKeys(s);
		Log.info("Entered mobile Number");
	}

	// Batch filter selection
	public void selectFilterBatchNumber() {
		Log.info("Trying to select Batch Number as filter");
		wait.until(ExpectedConditions.visibilityOf(filterByBatchNumber)).click();
		Log.info("Selected Batch number as filter");
	}

	// Input Batch Number
	public void inputDataForBatchNumber(String s) {
		Log.info("Trying to input batch number");
		wait.until(ExpectedConditions.visibilityOf(batchNumberInput)).sendKeys(s);
		Log.info("Entered batchlist number");
	}

	// Select Filter Schedule
	public void selectFilterScheduledPeriod() {
		Log.info("Selecting filter as schedule period");
		wait.until(ExpectedConditions.visibilityOf(filterBySchedulePeriod)).click();
		Log.info("Selected filter as Scheduled Period");
	}

	//Selecting period from schedule
	public void selectDropDownFromSchedulePeriod() {
		Log.info("Trying to select dropdown");
		wait.until(ExpectedConditions.visibilityOf(schedulePeriodDropDown)).click();
		Log.info("Clicked on the select period dropdown");
	}

	//Selecting period as 3 days
	public void selectPeriodLastThreeDays() {
		Log.info("Trying to select period as 3 days");
		wait.until(ExpectedConditions.visibilityOf(threeDaysPeriod)).click();
		Log.info("Selected period as 3 days");
	}

	//Selecting period as All
	public void selectPeriodAll() {
		Log.info("Trying to select period as all");
		wait.until(ExpectedConditions.visibilityOf(schedulePeriodAll)).click();
		Log.info("Selected period as All");
	}

	//Click on status dropdown
	public void selectStatusDropDown() {
		Log.info("Trying to select status dropdown from advance page");
		wait.until(ExpectedConditions.visibilityOf(advanceStatusInput)).click();
		Log.info("Clicked on advance status dropdown");
	}

	// selecting dropdown as type on advance page
	public void selectTypeDropDown() {
		Log.info("Trying to select type dropdown from advance page");
		wait.until(ExpectedConditions.visibilityOf(advanceTypeInput)).click();
		Log.info("Clicked on type dropdown");
	}

	// Selecting advance status all
	public void selectAdvanceStatusAll() {
		Log.info("Trying to select advance status as ALL");
		wait.until(ExpectedConditions.visibilityOf(advanceStatusAll)).click();
		Log.info("Selected advance status as ALL");
	}

	public void selectAdvanceTypeAll() {
		Log.info("Trying to select advance type as ALL");
		wait.until(ExpectedConditions.visibilityOf(advanceTypeAll)).click();
		Log.info("Selected advance type as ALL");
	}

	// Click on Submit button
	public void clickOnsubmitButton() {
		Log.info("Trying to click on submit button");
		wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
		Log.info("Clicked on submit button");
	}

	//Click on reset button
	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");
		wait.until(ExpectedConditions.visibilityOf(resetButton));
		Log.info("Clicked on reset button");
	}
	
	//return from details view page
	public void returnFromViewBatchList() {
		Log.info("Trying to click on return link from header");
		wait.until(ExpectedConditions.visibilityOf(viewBatchReturn)).click();
		Log.info("Clicked on return link");
	}
	
	// Verify Complete View Batch list Page is loaded successfully
	public void verifyCompleteViewBatchListLoadedSuccessfully() {
		Log.info("Verifing complete batch details page loaded successfully");
		wait.until(ExpectedConditions.visibilityOf(batchNumberId));
		Log.info("Complete batch details loaded successfully");
	}
	
	// Get details from view batch list details page
	public List<String> getValueFromViewBatchDetailsUI(){
		List<String> value = new ArrayList<>();
		value.add(wait.until(ExpectedConditions.visibilityOf(batchNumberId)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(batchType)).getText());
		//value.add(wait.until(ExpectedConditions.visibilityOf(profileName)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(noVoucher)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(fromSerialNumber)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(toSerialNumber)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(successCount)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(failCount)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(createdOn)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(userViewBtachDetail)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(mobileNumberOnView)).getText());
		value.add(wait.until(ExpectedConditions.visibilityOf(messageOnBatchView)).getText());
		return value;
	}
}
