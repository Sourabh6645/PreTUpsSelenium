package angular.pageobjects.ProfileManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import com.utils.Log;

public class TransferControlProfile_PageObject extends BaseTest {

	// eTopUp Tab
	@FindBy(id = "mat-tab-label-1-0")
	private WebElement eTopUpTab;

	// Profile Management Link
	@FindBy(xpath = "//span[text()='Profile Management']")
	private WebElement profileManagementLink;

	// Transfer Control Profile Link
	@FindBy(xpath = "//a[@href='/pretups-ui/trfContl-Profile']")
	private WebElement transferControlProfileLink;

	// Profile Management Menus expanded
	@FindBy(xpath = "//span[text()='Profile Management'][contains(@class,'expand')]")
	private WebElement profileManagementExpanded;

	// Domain Filter DD
	@FindBy(xpath = "(//h5//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement domainFilterDD;

	// Category Filter DD
	@FindBy(xpath = "(//h5//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement categoryFilterDD;

	// Status Filter DD
	@FindBy(xpath = "(//h5//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement statusFilterDD;

	// Filter Reset Button
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement filterResetButton;

	// Filter Proceed Button
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement filterProceedButton;

	// Add Transfer Control Profile Button
	@FindBy(id = "add")
	private WebElement addTransferProfileButton;

	// Transfer Control Profile Search
	@FindBy(xpath = "//input[@name='search']")
	private WebElement transferProfileSearchInput;

	// Select Show Entries
	@FindBy(xpath = "//select[@name='parentTable_length']")
	private WebElement showEntriesSelect;

	// Edit Action Button
	@FindBy(xpath = "(//label[@title='Edit TCP'])[1]")
	private WebElement editActionButton;

	// Delete Action Button
	@FindBy(xpath = "(//label[@title='Delete TCP'])[1]")
	private WebElement deleteActionButton;

	// Profile Name input
	@FindBy(xpath = "//input[@name='name1']")
	private WebElement profileNameInput;

	// Short Name input
	@FindBy(xpath = "//input[@name='name2']")
	private WebElement shortNameInput;

	// Description input
	@FindBy(xpath = "//input[@name='description']")
	private WebElement descriptionInput;

	// Select Status DD
	@FindBy(xpath = "//label[@for='status']//following::span[@class='ng-arrow-wrapper']")
	private WebElement statusDDButton;

	// Default Profile Radio Button Yes
	@FindBy(xpath = "//input[@value='Y']")
	private WebElement defaultProfileYes;

	// Default Profile Radio Button No
	@FindBy(xpath = "//input[@value='N']")
	private WebElement defaultProfileNo;

	// Selected Domain on Add Page
	@FindBy(xpath = "(//label[@for='domain'][2])[1]")
	private WebElement selectedDomainOnAddPage;

	// Selected Category On Add Page
	@FindBy(xpath = "(//label[@for='domain'][2])[2]")
	private WebElement selectedCategoryOnAddPage;

	// ETOPUP Residual Minimum Balance
	@FindBy(xpath = "(//input[@name='minBalance'])[1]")
	private WebElement etopupResidualMinimumBalance;

	// POSTETOPUP Residual Minimum Balance
	@FindBy(xpath = "(//input[@name='minBalance'])[2]")
	private WebElement postEtopupResidualMinimumBalance;

	// VOUCHTRACK Residual Minimum Balance
	@FindBy(xpath = "(//input[@name='minBalance'])[3]")
	private WebElement vouchTrackResidualMinimumBalance;

	// ETOPUP Residual Maximum Balance
	@FindBy(xpath = "(//input[@name='maxBalance'])[1]")
	private WebElement etopupResidualMaximumBalance;

	// POSTETOPUP Residual Maximum Balance
	@FindBy(xpath = "(//input[@name='maxBalance'])[2]")
	private WebElement postEtopupResidualMaximumBalance;

	// VOUCHTRACK Residual Maximum Balance
	@FindBy(xpath = "(//input[@name='maxBalance'])[3]")
	private WebElement vouchTrackResidualMaximumBalance;

	// ETOPUP Per Channel to subscriber transaction amount Minimum Balance
	@FindBy(xpath = "(//input[@name='c2sMinTxnAmt'])[1]")
	private WebElement etopupC2SMinimumBalance;

	// POSTETOPUP Per Channel to subscriber transaction amount Minimum Balance
	@FindBy(xpath = "(//input[@name='c2sMinTxnAmt'])[2]")
	private WebElement postEtopupC2SMinimumBalance;

	// VOUCHTRACK Per Channel to subscriber transaction amount Minimum Balance
	@FindBy(xpath = "(//input[@name='c2sMinTxnAmt'])[3]")
	private WebElement vouchTrackC2SMinimumBalance;

	// ETOPUP Per Channel to subscriber transaction amount Maximum Balance
	@FindBy(xpath = "(//input[@name='c2sMaxTxnAmt'])[1]")
	private WebElement etopupC2SMaximumBalance;

	// POSTETOPUP Per Channel to subscriber transaction amount Maximum Balance
	@FindBy(xpath = "(//input[@name='c2sMaxTxnAmt'])[2]")
	private WebElement postEtopupC2SMaximumBalance;

	// VOUCHTRACK Per Channel to subscriber transaction amount Maximum Balance
	@FindBy(xpath = "(//input[@name='c2sMaxTxnAmt'])[3]")
	private WebElement vouchTrackC2SMaximumBalance;

	// ETOPUP Alerting Balance
	@FindBy(xpath = "(//input[@name='altBalance'])[1]")
	private WebElement etopupAlertingBalance;

	// POSTETOPUP Alerting Balance
	@FindBy(xpath = "(//input[@name='altBalance'])[2]")
	private WebElement postEtopupAlertingBalance;

	// VOUCHTRACK Alerting Balance
	@FindBy(xpath = "(//input[@name='altBalance'])[3]")
	private WebElement vouchTrackAlertingBalance;

	// ETOPUP Allowed Max Percentage
	@FindBy(xpath = "(//input[@name='allowedMaxPercentage'])[1]")
	private WebElement etopupAllowedMaxPercentage;

	// POSTETOPUP Allowed Max Percentage
	@FindBy(xpath = "(//input[@name='allowedMaxPercentage'])[2]")
	private WebElement postEtopupAllowedMaxPercentage;

	// VOUCHTRACK Allowed Max Percentage
	@FindBy(xpath = "(//input[@name='allowedMaxPercentage'])[3]")
	private WebElement vouchTrackAllowedMaxPercentage;

	// Transfer Control Preferences Daily Filter
	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[1]")
	private WebElement dailyTransferControlFilter;

	// Transfer Control Preferences Weekly Filter
	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[2]")
	private WebElement weeklyTransferControlFilter;

	// Transfer Control Preferences Monthly Filter
	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[3]")
	private WebElement monthlyTransferControlFilter;

	// Channel Transfer In Count
	@FindBy(xpath = "(//input[@name='channelInCount'])[1]")
	private WebElement channelTransferinCount;

	// Channel Transfer Out Count
	@FindBy(xpath = "(//input[@name='channelInCount'])[2]")
	private WebElement channelTransferOutCount;

	// Subscriber Transfer In Count
	@FindBy(xpath = "(//input[@name='channelInCount'])[3]")
	private WebElement subscriberTransferInCount;

	// Subscriber Transfer Out Count
	@FindBy(xpath = "(//input[@name='channelInCount'])[4]")
	private WebElement subscriberTransferOutCount;

	// Channel Transfer In Alerting Count
	@FindBy(xpath = "(//input[@name='channelInAlert'])[1]")
	private WebElement channelTransferinAlertingCount;

	// Channel Transfer Out Alerting Count
	@FindBy(xpath = "(//input[@name='channelInAlert'])[2]")
	private WebElement channelTransferOutAlertingCount;

	// Subscriber Transfer In Alerting Count
	@FindBy(xpath = "(//input[@name='channelInAlert'])[3]")
	private WebElement subscriberTransferInAlertingCount;

	// Subscriber Transfer Out Alerting Count
	@FindBy(xpath = "(//input[@name='channelInAlert'])[4]")
	private WebElement subscriberTransferOutAlertingCount;

	// Channel Transfer In Value
	@FindBy(xpath = "(//input[@name='channelInValue'])[1]")
	private WebElement channelTransferinValue;

	// Channel Transfer Out Value
	@FindBy(xpath = "(//input[@name='channelInValue'])[2]")
	private WebElement channelTransferOutValue;

	// Subscriber Transfer In Value
	@FindBy(xpath = "(//input[@name='channelInValue'])[3]")
	private WebElement subscriberTransferInValue;

	// Subscriber Transfer Out Value
	@FindBy(xpath = "(//input[@name='channelInValue'])[4]")
	private WebElement subscriberTransferOutValue;

	// Channel Transfer In Alerting Value
	@FindBy(xpath = "(//input[@name='channelInAlertValue'])[1]")
	private WebElement channelTransferinAlertingValue;

	// Channel Transfer Out Alerting Value
	@FindBy(xpath = "(//input[@name='channelInAlertValue'])[2]")
	private WebElement channelTransferOutAlertingValue;

	// Subscriber Transfer In Alerting Value
	@FindBy(xpath = "(//input[@name='channelInAlertValue'])[3]")
	private WebElement subscriberTransferInAlertingValue;

	// Subscriber Transfer Out Alerting Value
	@FindBy(xpath = "(//input[@name='channelInAlertValue'])[4]")
	private WebElement subscriberTransferOutAlertingValue;

	// Add Cancel Button
	@FindBy(xpath = "//button[@class='reset-btn']")
	private WebElement cancelButton;

	// Add Cancel Button
	@FindBy(xpath = "//button[@class='save-btn']")
	private WebElement saveButton;

	// Pop-Up Window
	@FindBy(xpath = "//div[@class='popup-body']")
	private WebElement popUpWindow;

	// Confirm Button
	@FindBy(xpath = "(//button[@name='Proceed'])[3]")
	private WebElement confirmButton;

	// Review and Confirm Cancel Button
	@FindBy(xpath = "//div[@class='close-btn']")
	private WebElement closeButton;

	// Transfer Success Window
	@FindBy(xpath = "//div[@class='success12']")
	private WebElement transferControlAddedSuccessfully;

	// Success Window Done Button
	@FindBy(id = "doneBtn")
	private WebElement successDoneButton;

	// Edit Record button
	@FindBy(xpath = "(//a[@class='editRecord'])[2]")
	private WebElement editRecordButton;

	// Modify Delete Icon
	@FindBy(xpath = "//img[@class='dlt-img']")
	private WebElement modifyDeleteIcon;
	
	// Delete Record Button
	@FindBy(xpath = "(//a[@class='deleteRecord'])[2]")
	private WebElement deleteRecoedButton;

	// Delete Pop up
	@FindBy(xpath = "//div[@class='deletepop']")
	private WebElement deletePopUpWindow;

	// Delete No Button
	@FindBy(xpath = "(//button[@id='doneBtn'][1])//span")
	private WebElement deleteCancelButton;

	// Delete confirm Button
	@FindBy(xpath = "(//button[@id='doneBtn'][2])//span")
	private WebElement deleteConfirmButton;

	// Delete Success PopUp
	@FindBy(xpath = "//div[@class='status-change-successful1']")
	private WebElement deleteSuccessPopUp;

	/* -----WebDriver Declaration----- */
	WebDriver driver = null;
	WebDriverWait wait = null;
	JavascriptExecutor jsDriver;

	public TransferControlProfile_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		jsDriver = (JavascriptExecutor) driver;
		
	}

	/* -----Basic Function----- */

	public void selecteTopUpTab() {
		Log.info("Selecting eTopUp Tab");
		wait.until(ExpectedConditions.visibilityOf(eTopUpTab)).click();
		Log.info("Selected eTopUp Tab Successfully");
	}

	public boolean checkVisibilityOfProfileManagementLink() {
		Log.info("Checking Visibility of Profile Management Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(profileManagementLink));
			Log.info("Profile management link is available");
			return true;
		} catch (Exception e) {
			Log.info("Profile Management Link is not available");
			return false;
		}
	}

	public boolean checkProfileManagementMenuOptionsAreVisible() {
		Log.info("Checking if Profile Management Menu Option are visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(profileManagementExpanded));
			Log.info("Menu options are visible");
			return true;
		} catch (Exception e) {
			Log.info("Menu options are not visible");
			return false;
		}
	}

	public void clickOnProfileManagementLink() {
		Log.info("Trying to click on profile Management link");
		if (checkVisibilityOfProfileManagementLink()) {
			if (!checkProfileManagementMenuOptionsAreVisible()) {
				wait.until(ExpectedConditions.visibilityOf(profileManagementLink)).click();
				Log.info("Clicked on Profile Management Link");
			} else {
				Log.info("Profile Management Menu Option is already visible");
			}
		}
	}
	
	public void clickOnTransferControlProfile() {
		Log.info("Trying to click on Transfer Control Profile Link");
		if(checkProfileManagementMenuOptionsAreVisible()) {
			if(!checkTransferControlProfilePageLoadedSuccessfully()) {
				wait.until(ExpectedConditions.visibilityOf(transferControlProfileLink)).click();
				Log.info("Clicked on transfer control profile link successfully");
			}else {
				Log.info("Transfer Control Profile Page is already visible");
			}
		}else {
			clickOnProfileManagementLink();
			wait.until(ExpectedConditions.visibilityOf(transferControlProfileLink)).click();
			Log.info("Clicked on transfer control profile link successfully");
		}
	}

	public boolean checkTransferControlProfilePageLoadedSuccessfully() {
		Log.info("Checking if Transfer Control Profile Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(domainFilterDD));
			wait.until(ExpectedConditions.visibilityOf(categoryFilterDD));
			wait.until(ExpectedConditions.visibilityOf(statusFilterDD));
			wait.until(ExpectedConditions.visibilityOf(filterProceedButton));
			wait.until(ExpectedConditions.visibilityOf(filterResetButton));
			Log.info("Transfer Control Profile Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Transfer Control Profile page loaded successfully");
			return false;
		}
	}

	public void clickOnFiltersDomainDD() {
		
		jsDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Log.info("Trying to click on Filters Domain DD");
		wait.until(ExpectedConditions.visibilityOf(domainFilterDD)).click();
		Log.info("Clicked on Filter Domain DD");
	}

	public void clickOnFilterCategoryDD() {
		Log.info("Trying to click on Filter Category DD");
		wait.until(ExpectedConditions.visibilityOf(categoryFilterDD)).click();
		Log.info("Clicked on Filter Category DD");
	}

	public void clickOnFilterStatusDD() {
		Log.info("Trying to click on Filter Status DD");
		wait.until(ExpectedConditions.visibilityOf(statusFilterDD)).click();
		Log.info("Clicked on Filter Status DD");
	}

	public void clickOnFilterProceedButton() {
		Log.info("Trying to click on Filter Proceed Button");
		wait.until(ExpectedConditions.visibilityOf(filterProceedButton)).click();
		Log.info("Clicked on Filter Proceed Button");
	}

	public void clickOnFilterResetButton() {
		Log.info("Trying to click on Filter Reset Button");
		wait.until(ExpectedConditions.visibilityOf(filterResetButton)).click();
		Log.info("Clicked on Filter Reset Button");
	}

	public boolean checkTransferControlProfileResultLoadedSuccessfully() {
		Log.info("Checking transfer control profile result loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("parentTable_wrapper")));
			Log.info("Transfer Control Profile result loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("No result found");
			return false;
		}

	}

	public void clickOnAddTransferControlProfileButton() {
		Log.info("Trying to click on Add Transfer Profile Button");
		wait.until(ExpectedConditions.visibilityOf(addTransferProfileButton)).click();
		Log.info("Clicked on Add Transfer Profile Button");
	}

	public void inputSearchData(String value) {
		Log.info("Inserting data into search bar : " + value);
		wait.until(ExpectedConditions.visibilityOf(transferProfileSearchInput)).sendKeys(value);
	}

	public boolean checkAddPageLoadedSuccessfully() {
		Log.info("Checking if Add Transfer Control Profile Page Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			Log.info("Add Transfer Control Profile Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Add Transfer Control Profile Page not loaded");
			return false;
		}
	}

	public boolean validateDomainOnAddPage(String value) {
		String domain = selectedDomainOnAddPage.getText();
		if (domain.equals(value)) {
			Log.info("Prepopulated domain value is correct");
			return true;
		} else {
			Log.info("Prepopulated domain value is different than selected filter value");
			return false;
		}
	}

	public boolean validateCategoryOnAddPage(String value) {
		String category = selectedCategoryOnAddPage.getText();
		if (category.equals(value)) {
			Log.info("Prepopulated category value is correct");
			return true;
		} else {
			Log.info("Prepopulated category value is different than selected filter value");
			return false;
		}
	}

	public void insertProfileName(String value) {
		Log.info("Inserting Profile Value as : " + value);
		profileNameInput.sendKeys(value);
	}

	public void insertShortName(String value) {
		Log.info("Inserting short name value as : " + value);
		shortNameInput.sendKeys(value);
	}

	public void insertDescription(String value) {
		Log.info("Inserting description value as : " + value);
		descriptionInput.sendKeys(value);
	}

	public void clickOnStatusDropDown() {
		Log.info("Trying to click on status DD");
		statusDDButton.click();
		Log.info("Clicked on status DD");
	}

	public void setDefaultProfileStatus(String value) {
		Log.info("Setting Default Profile Status");
		if (value.equals("YES")) {
			defaultProfileYes.click();
			Log.info("Default Profile Status is selected as YES");
		} else {
			defaultProfileNo.click();
			Log.info("Default Profile Status is selected as NO");
		}
	}

	/* ---- Residual Balance---- */
	public void inputEtopupMinimumResidualBalance(String value) {
		Log.info("Inserting ETOPUP minimum Residual Balance value as : " + value);
		etopupResidualMinimumBalance.sendKeys(value);
	}

	public void inputPostEtopupMinimumResidualBalance(String value) {
		Log.info("Inserting POSTETOPUP minimum Residual Balance value as : " + value);
		postEtopupResidualMinimumBalance.sendKeys(value);
	}

	public void inputVouchTrackMinimumResidualBalance(String value) {
		Log.info("Inserting VOUCHTRACK minimum Residual Balance value as : " + value);
		vouchTrackResidualMinimumBalance.sendKeys(value);
	}

	public void inputEtopupMaximumBalace(String value) {
		Log.info("Inserting ETOPUP maximum Residual Balance value as : " + value);
		etopupResidualMaximumBalance.sendKeys(value);
	}

	public void inputPostEtopupMaximumBalance(String value) {
		Log.info("Inserting POSTETOPUP maximum Residual Balance value as : " + value);
		postEtopupResidualMaximumBalance.sendKeys(value);
	}

	public void inputVouchTrackMaximumBalance(String value) {
		Log.info("Inserting VOUCHTRACK maximum Residual Balance value as : " + value);
		vouchTrackResidualMaximumBalance.sendKeys(value);
	}

	/* ---- C2S Transaction Amount ---- */
	public void inputEtopupC2STransactionMinimumAmount(String value) {
		Log.info("Inserting ETOPUP C2S Transaction Minimum Amount as : " + value);
		etopupC2SMinimumBalance.sendKeys(value);
	}

	public void inputPostEtopupC2STransactionMinimumAmount(String value) {
		Log.info("Inserting POSTETOPUP C2S Transaction Minimum Amount as : " + value);
		postEtopupC2SMinimumBalance.sendKeys(value);
	}

	public void inputVouchTrackC2STransactionMinimumAmount(String value) {
		Log.info("Inserting VOUCHTRACK C2S Transaction Minimum Amount as : " + value);
		vouchTrackC2SMinimumBalance.sendKeys(value);
	}

	public void inputEtopupC2STransactionMaximumAmount(String value) {
		Log.info("Inserting ETOPUP C2S Transaction Maximum Amount as : " + value);
		etopupC2SMaximumBalance.sendKeys(value);
	}

	public void inputPostEtopupC2STransactionMaximumAmount(String value) {
		Log.info("Inserting POSTETOPUP Transaction Maximum Amount as : " + value);
		postEtopupC2SMinimumBalance.sendKeys(value);
	}

	public void inputVouchTrackC2STransactionMaximumAmount(String value) {
		Log.info("Inserting VOUCHTRACK Transaction Maximum Amount as : " + value);
		vouchTrackC2SMinimumBalance.sendKeys(value);
	}

	/* ---- Alerting Balance---- */
	public void inputEtopupAlertingBalance(String value) {
		Log.info("Inserting ETOPUP Alerting Balance : " + value);
		etopupAlertingBalance.sendKeys(value);
	}

	public void inputPostEtopupAlertingBalance(String value) {
		Log.info("Inserting POSTETOPUP Alerting Balance : " + value);
		postEtopupAlertingBalance.sendKeys(value);
	}

	public void inputVouchTrackAlertingBalance(String value) {
		Log.info("Inserting VOUCHTRACK Alerting Balance : " + value);
		vouchTrackAlertingBalance.sendKeys(value);
	}

	/* ---- Allowed max percent ---- */
	public void inputEtopupAllowedMaxPercent(String value) {
		Log.info("Inserting ETOPUP Allowed max percent : " + value);
		etopupAllowedMaxPercentage.sendKeys(value);
	}

	public void inputPostEtopupAllowedMaxPercent(String value) {
		Log.info("Inserting POSTETOPUP Allowed max percent : " + value);
		postEtopupAllowedMaxPercentage.sendKeys(value);
	}

	public void inputVouchTrackAllowedMaxPercent(String value) {
		Log.info("Inserting VOUCHTRACK Allowed max percent : " + value);
		vouchTrackAllowedMaxPercentage.sendKeys(value);
	}

	/* ---- Transfer Control Preference Daily/Weekly/Monthly Value ---- */

	public void inputChannelTransferInCount(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer In Count :" + value);
		channelTransferinCount.clear();
		channelTransferinCount.sendKeys(value);
	}

	public void inputChannelTransferOutCount(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer Out Count :" + value);
		channelTransferOutCount.clear();
		channelTransferOutCount.sendKeys(value);
	}

	public void inputSubscriberTransferInCount(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer In Count :" + value);
		subscriberTransferInCount.clear();
		subscriberTransferInCount.sendKeys(value);
	}

	public void inputSubscriberTransferOutCount(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer Out Count :" + value);
		subscriberTransferOutCount.clear();
		subscriberTransferOutCount.sendKeys(value);
	}

	public void inputChannelTransferInAlertingCount(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer In Count :" + value);
		channelTransferinAlertingCount.clear();
		channelTransferinAlertingCount.sendKeys(value);
	}

	public void inputChannelTransferOutAlertingCount(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer Out Count :" + value);
		channelTransferOutAlertingCount.clear();
		channelTransferOutAlertingCount.sendKeys(value);
	}

	public void inputSubscriberTransferInAlertingCount(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer In Count :" + value);
		subscriberTransferInAlertingCount.clear();
		subscriberTransferInAlertingCount.sendKeys(value);
	}

	public void inputSubscriberTransferOutAlertingCount(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer Out Count :" + value);
		subscriberTransferOutAlertingCount.clear();
		subscriberTransferOutAlertingCount.sendKeys(value);
	}

	public void inputChannelTransferInValue(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer In Value :" + value);
		channelTransferinValue.clear();
		channelTransferinValue.sendKeys(value);
	}

	public void inputChannelTransferOutValue(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer Out Value :" + value);
		channelTransferOutValue.clear();
		channelTransferOutValue.sendKeys(value);
	}

	public void inputSubscriberTransferInValue(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer In Value :" + value);
		subscriberTransferInValue.clear();
		subscriberTransferInValue.sendKeys(value);
	}

	public void inputSubscriberTransferOutValue(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer Out Value :" + value);
		subscriberTransferOutValue.clear();
		subscriberTransferOutValue.sendKeys(value);
	}

	public void inputChannelTransferInAlertingValue(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer In Value :" + value);
		channelTransferinAlertingValue.clear();
		channelTransferinAlertingValue.sendKeys(value);
	}

	public void inputChannelTransferOutAlertingValue(String type, String value) {
		Log.info("Inserting " + type + " Channel Transfer Out Value :" + value);
		channelTransferOutAlertingValue.clear();
		channelTransferOutAlertingValue.sendKeys(value);
	}

	public void inputSubscriberTransferInAlertingValue(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer In Value :" + value);
		subscriberTransferInAlertingValue.clear();
		subscriberTransferInAlertingValue.sendKeys(value);
	}

	public void inputSubscriberTransferOutAlertingValue(String type, String value) {
		Log.info("Inserting " + type + " Subscriber Transfer Out Value :" + value);
		subscriberTransferOutAlertingValue.clear();
		subscriberTransferOutAlertingValue.sendKeys(value);
	}

	public void clickOnDailyTransferControlPreferences() {
		Log.info("Trying to click on Daily Transfer Control Tab");
		dailyTransferControlFilter.click();
		Log.info("Clicked on Daily Transfer Control Tab");
	}

	public void clickOnWeeklyTransferControlPreferences() {
		Log.info("Trying to click on Weekly Transfer Control Tab");
		weeklyTransferControlFilter.click();
		Log.info("Clicked on Weekly Transfer Control Tab");
	}

	public void clickOnMonthlyTransferControlPreferences() {
		Log.info("Trying to click on Monthly Transfer Control Tab");
		monthlyTransferControlFilter.click();
		Log.info("Clicked on Monthly Transfer Control Tab");
	}

	public void clickOnCancelButton() {
		Log.info("Trying to click on Cancel Button");
		cancelButton.click();
		Log.info("Clicked on Cancel Button");
	}

	public void clickOnSaveButton() {
		Log.info("Trying to click on Save Button");
		jsDriver.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
		Log.info("Clicked on Save Button");
	}

	public boolean checkReviewAndConfirmPage() {
		Log.info("Checking if Review and Confirm Page is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(popUpWindow));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='ng-select-box-default'])[4]")));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='ng-select-box-default'])[5]")));
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='ng-select-box-default'])[6]")));
			wait.until(ExpectedConditions.visibilityOf(confirmButton));
			Log.info("Review and Confirm page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Review and Confirm page not loaded");
			return false;
		}

	}

	public void clickOnConfirmButton() {
		Log.info("Trying to click on review confirm button");
		wait.until(ExpectedConditions.visibilityOf(confirmButton)).click();
		Log.info("Clicked on confirm button");
	}

	public boolean checkTransferControlProfileSuccessMessage() {
		Log.info("Checking for success window prompt");
		try {
			wait.until(ExpectedConditions.visibilityOf(transferControlAddedSuccessfully));
			Log.info("Success window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success window not found");
			return false;
		}
	}

	public void clickOnSuccessDoneButton() {
		Log.info("Trying to click on success window done button");
		wait.until(ExpectedConditions.visibilityOf(successDoneButton)).click();
		Log.info("Clicked on Done Button");
	}

	public void clickOnEditRecoedButton() {
		Log.info("Trying to click on edit recoed button");
		wait.until(ExpectedConditions.visibilityOf(editRecordButton)).click();
		Log.info("Clicked on edit recoed button");
	}

	public boolean checkDeleteIconOnModifyPage() {
		Log.info("Checking if delete icon is visible on modify page");
		try {
			wait.until(ExpectedConditions.visibilityOf(modifyDeleteIcon));
			Log.info("Delete icon is visible on modify page");
			return true;
		}catch(Exception e) {
			Log.info("Delete button is not visible on modify page");
			return false;
		}
	}
	
	public void clickOnDeleteRecoedButton() {
		Log.info("Trying to click on delete recoed button");
		wait.until(ExpectedConditions.visibilityOf(deleteRecoedButton)).click();
		Log.info("Clicked on delete recoed button");
	}

	public boolean checkDeleteConfirmationWindow() {
		Log.info("Checking for delete confirmation pop-up");
		try {
			wait.until(ExpectedConditions.visibilityOf(deletePopUpWindow));
			Log.info("Delete confirmation pop-up window is visible");
			return true;
		} catch (Exception e) {
			Log.info("Delete confirmation pop-up window is not visible");
			return false;
		}
	}

	public void clickOnCancelDeleteConfirmation() {
		Log.info("Trying to cancel delete confirmation");
		wait.until(ExpectedConditions.visibilityOf(deleteCancelButton)).click();
		Log.info("Canceled delete operation");
	}

	public void clickOnDeleteConfirmation() {
		Log.info("Trying to delete confirmation");
		wait.until(ExpectedConditions.visibilityOf(deleteConfirmButton)).click();
		Log.info("Delete operation is successful");
	}

	public boolean checkDeleteSuccesstDeleteWindow() {
		Log.info("Checking delete operation success window");
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteSuccessPopUp));
			Log.info("Delete success pop up window launched successfully");
			return true;
		} catch (Exception e) {
			Log.info("Delete success pop up window not launched successfully");
			return false;
		}
	}
	
	public boolean checkCloseButtonIsVisible() {
		Log.info("Checking if close button is visible on review and confirm screen");
		try {
			wait.until(ExpectedConditions.visibilityOf(closeButton));
			Log.info("Close button is visible on review and confirm screen");
			return true;
		}catch(Exception e) {
			Log.info("Close button is not visible on review and confirm screen");
			return false;
		}
	}

}
