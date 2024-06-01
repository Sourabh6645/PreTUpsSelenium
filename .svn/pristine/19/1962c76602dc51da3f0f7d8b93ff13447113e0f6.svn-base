package angular.pageobjects.Preferances;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.utils.Log;

public class SystemPreferencesPageObject extends BaseTest {

	@FindBy(xpath = "//div[@id='mat-tab-label-1-0']")
	private WebElement eTopUpButton;

	@FindBy(xpath = "(//h6[@id='updateCacheLabel']//following::img[@id='Path16'])[8]")
	private WebElement preferencesButton;

	@FindBy(xpath = "(//label[@for='module']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement moduleDDButton;

	@FindBy(xpath = "(//label[@for='module']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement preferenceTypeButton;

	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetButton;

	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement proceedButton;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[1]")
	private WebElement peer2peerOption;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[2]")
	private WebElement channel2SubscriberOption;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[3]")
	private WebElement voucherManagementOption;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[1]")
	private WebElement systemPreferences;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[2]")
	private WebElement networkPreferences;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[3]")
	private WebElement servicePrefernces;

	@FindBy(xpath = "(//span[contains(@class,'ng-option-label')])[4]")
	private WebElement categoryPrefernces;

	@FindBy(xpath = "//select[@name='parentTable_length']")
	private WebElement showEntriesPage;

	@FindBy(xpath = "//option[@value='100']")
	private WebElement maxEntriesOnPage;

	@FindBy(xpath = "//span[@class='text']")
	private WebElement modifyPreferencesLabel;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchModifyPref;
	
	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement modifyButton;

	@FindBy(xpath = "(//h4[@id='modal-basic-title'])[1]")
	private WebElement reviewConfirmHeading;

	@FindBy(xpath = "//button[@id='closeImgButton']")
	private WebElement reviewConfirmCloseButton;

	@FindBy(id = "rejectConfirmNo")
	private WebElement rejectConfirmation;

	@FindBy(id = "rejectConfirmYes")
	private WebElement acceptConfirmation;

	@FindBy(xpath = "//img[@src='assets/images/success-icon/tick-inside-circle.png']")
	private WebElement successWindowIcon;

	@FindBy(xpath = "//button[@id='doneId']//span")
	private WebElement doneButton;

	WebDriver driver = null;
	WebDriverWait wait = null;

	public SystemPreferencesPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public boolean checkETopUpButton() {

		try {
			wait.until(ExpectedConditions.visibilityOf(eTopUpButton));
			Log.info("eTopUP button is visible");
			return true;
		} catch (Exception e) {
			Log.info("eTopUP button is not visible");
		}
		return false;
	}

	public void clickOnETopUpTab() {
		if (checkETopUpButton()) {
			eTopUpButton.click();
			Log.info("Clicked on eTopUp Tab");
		} else {
			Log.info("Unable to click on eTopUp Tab");
		}
	}

	public boolean checkPreferencesLinkVisibility() {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferencesButton);
			wait.until(ExpectedConditions.visibilityOf(preferencesButton));
			Log.info("Preferences button is visible");
			return true;
		} catch (Exception e) {
			Log.info("Preferences button is not visible");
		}
		return false;
	}

	public void clickOnPreferenceLink() {
		Log.info("Trying to click on Prefernces Button");
		if (checkPreferencesLinkVisibility()) {
			preferencesButton.click();
			Log.info("Clicked on preferences button");
		} else {
			Log.info("Unable to click on preferences button");
		}
	}

	public boolean checkPreferencesPageLoadedSuccessfully() {

		Log.info("Checking if Prefrences page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(preferenceTypeButton));
			wait.until(ExpectedConditions.visibilityOf(voucherManagementOption));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(proceedButton));
			Log.info("Preferences page is loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Preferences page is not loaded successfully");
		}
		return false;
	}

	public void clickOnModuleTypeDD() {

		Log.info("Trying to click on module type DD button");
		moduleDDButton.click();
		Log.info("Clicked on module type DD button");
	}

	public void selectPeer2PeerOptionFromDD() {

		Log.info("Trying to select Peer to Peer value");
		peer2peerOption.click();
		Log.info("Selected peer to peer value from DD");
	}

	public void selectChannel2SubscriberOptionFromDD() {

		Log.info("Trying to select Channel to Subscriber value");
		channel2SubscriberOption.click();
		Log.info("Selected Channel to Subscriber value from DD");
	}
	
	public void selectVoucherManagementOptionFromDD() {

		Log.info("Trying to select Voucher Management value");
		channel2SubscriberOption.click();
		Log.info("Selected Voucher Management value from DD");
	}
	
	public void clickOnPreferenceTypeDDButton() {
		Log.info("Trying to click on preference type DD button");
		preferenceTypeButton.click();
		Log.info("Clicked on preference type DD button");
	}
	
	public void selectSystemPreferenceOptionFromDD() {
		Log.info("Trying to select System Preference value");
		systemPreferences.click();
		Log.info("Selected System Preference value from DD");
	}
	
	public void selectNetworkPreferenceOptionFromDD() {
		Log.info("Trying to select Network Preference value");
		networkPreferences.click();
		Log.info("Selected Network Preference value from DD");
	}
	
	public void selectServicePreferenceOptionFromDD() {
		Log.info("Trying to select Service Preference value");
		servicePrefernces.click();
		Log.info("Selected Service Preference value from DD");
	}
	
	public void selectCategoryPreferenceOptionFromDD() {
		Log.info("Trying to select Category Preference value");
		categoryPrefernces.click();
		Log.info("Selected Category Preference value from DD");
	}
	
	public void clickOnResetButton() {
		Log.info("Trying to click RESET button");
		resetButton.click();
		Log.info("Clicked on RESET button");
	}
	
	public void clickOnProceedButton() {
		Log.info("Trying to click Proceed button");
		proceedButton.click();
		Log.info("Clicked on Proceed button");
	}
	
	public boolean checkSearchResultsLoadedSuccessfully() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(modifyPreferencesLabel));
			wait.until(ExpectedConditions.visibilityOf(showEntriesPage));
			Log.info("Search result loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Search result not loaded successfully");
		}
		
		return false;
	}
	
	public void selectMaxEntriesOnPage() {
		Log.info("Clicked on show page entries DD button");
		showEntriesPage.click();
		Log.info("Clicked on show page entries DD");
		Log.info("Selecting max entries");
		maxEntriesOnPage.click();
		Log.info("Selected max entries on page");
	}
	
	public void clickOnModifyButton() {
		Log.info("Trying to click on modify button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modifyButton);
		modifyButton.click();
	}
	
	public boolean checkReviewAndConfirmPageLoadedSuccessfully() {
		Log.info("Checking if review and confirm page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmHeading));
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmCloseButton));
			wait.until(ExpectedConditions.visibilityOf(rejectConfirmation));
			wait.until(ExpectedConditions.visibilityOf(acceptConfirmation));
			Log.info("Review and Confirm page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Review and Confirm page not loaded successfully");
		}
		
		return false;
	}
	
	public void clickOnCancelButton() {
		Log.info("Trying to reject modify from Review and Confirm");
		rejectConfirmation.click();
		Log.info("Rejected modification");
	}
	
	public void clickOnConfirmButton() {
		Log.info("Trying to accept modification from Review and Confirm");
		acceptConfirmation.click();
		Log.info("Accepted modification");
	}
	
	public boolean checkSuccessWindowLoaded() {
		
		Log.info("Checking if success message screen loaded");
		try {
			wait.until(ExpectedConditions.visibilityOf(successWindowIcon));
			wait.until(ExpectedConditions.visibilityOf(doneButton));
			Log.info("Success message screen loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Success message screen not loaded successfully");
		}
		
		return false;
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to close message window by clicking on done button");
		doneButton.click();
		Log.info("Clicked on done button");
	}
}
