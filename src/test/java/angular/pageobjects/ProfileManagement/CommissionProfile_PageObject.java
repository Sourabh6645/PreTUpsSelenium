package angular.pageobjects.ProfileManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class CommissionProfile_PageObject extends BaseTest {

	@FindBy(xpath = "//a[@href='/pretups-merger-ui/commission-Profile']")
	private WebElement commissionProfileLink;

	@FindBy(xpath = "(//button[@id='toggle-1-button'])[1]")
	private WebElement singleOperationButton;

	@FindBy(xpath = "(//button[@id='toggle-1-button'])[2]")
	private WebElement bulkOperationButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement domainDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[2]")
	private WebElement categoryDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[3]")
	private WebElement geographyDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[4]")
	private WebElement gradeDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[5]")
	private WebElement statusDDButton;

	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetProfileButton;

	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement proceedProfileButton;

	@FindBy(xpath = "//img[@src='assets/images/addcircle/png/Group 3.png']")
	private WebElement addCommissionProfileButton;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchInput;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[5]")
	private WebElement commissionTypeDDButton;

	@FindBy(xpath = "//input[@name='name1']")
	private WebElement profileNameInput;

	@FindBy(xpath = "//input[@name='name2']")
	private WebElement shortNameInput;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[6]")
	private WebElement transactionTypeDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[7]")
	private WebElement basecCommProduct;

	@FindBy(xpath = "(//label[@for='domain']//following::span[contains(@class,'ng-arrow-wrapper')])[8]")
	private WebElement baseCommPaymentMode;

	@FindBy(name = "multiple")
	private WebElement baseCommMultipleOfInput;

	@FindBy(name = "min")
	private WebElement transferValueMin;

	@FindBy(name = "max")
	private WebElement transferValueMax;

	@FindBy(xpath = "//input[@name='check1']")
	private WebElement focCheckBox;

	@FindBy(xpath = "//input[@name='check2']")
	private WebElement c2cTransferCheckBox;

	@FindBy(name = "amountRangeMin")
	private WebElement transactionAmountRange_Min;

	@FindBy(name = "amountRangeMax")
	private WebElement transactionAmountRange_Max;

	@FindBy(name = "unit")
	private WebElement commissionRateUnit_Input;

	@FindBy(name = "tax1unit")
	private WebElement tax1_Input;

	@FindBy(name = "tax2unit")
	private WebElement tax2_Input;

	@FindBy(name = "tax3unit")
	private WebElement tax3_Input;

	@FindBy(xpath = "//button[@class='reset-btn']")
	private WebElement resetButton;

	@FindBy(xpath = "//button[@class='save-btn']")
	private WebElement addButton;

	@FindBy(xpath = "(//span[@class='add-range'])[2]")
	private WebElement addRangeButton;

	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[1]")
	private WebElement baseCommissionTab;

	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[2]")
	private WebElement cumulativeBaseCommissionTab;

	@FindBy(xpath = "(//div[contains(@class,'selection-heading')])[3]")
	private WebElement additionalDetailsTab;

	@FindBy(xpath = "//button[@class='save-review-btn-new']")
	private WebElement saveReviewButton;

	@FindBy(xpath = "//button[@class='add-newcard-btn']")
	private WebElement backButton;

	@FindBy(xpath = "//button[@class='save-review-btn']")
	private WebElement submitButton;

	@FindBy(xpath = "//img[@src='assets/images/successTick.png']")
	private WebElement successTickIcon;

	@FindBy(id = "doneBtn")
	private WebElement doneButton;
	
	@FindBy(xpath = "//img[@src='assets/images/edit_icon/Editicon.png']")
	private WebElement editCommissionProfile;
	
	@FindBy(xpath = "//div[@id='modal-basic-title']")
	private WebElement deleteScreenConfirmation;
	
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[1]")
	private WebElement RejectConfirmPopUpButton;
	
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[2]")
	private WebElement ConfirmPopUpButton;
	
	@FindBy(xpath = "//input[@formcontrolname='englishText']")
	private WebElement englishNotificationInput;
	
	@FindBy(xpath = "//input[@formcontrolname='frenchText']")
	private WebElement frenchNotificationInput;
	
	

	WebDriver driver = null;
	WebDriverWait wait = null;

	public CommissionProfile_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnCommissionProfileLink() {
		Log.info("Trying to click on commission profile link");
		if (!checkCommissionProfilePage()) {
			wait.until(ExpectedConditions.visibilityOf(commissionProfileLink)).click();
			Log.info("Clicked on commission profile link");
		} else {
			Log.info("Commission Profile Page already loaded");
		}

	}

	public boolean checkCommissionProfilePage() {
		Log.info("Checking Commission Profile page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(domainDDButton));
			wait.until(ExpectedConditions.visibilityOf(categoryDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographyDDButton));
			wait.until(ExpectedConditions.visibilityOf(gradeDDButton));
			wait.until(ExpectedConditions.visibilityOf(statusDDButton));
			wait.until(ExpectedConditions.visibilityOf(resetProfileButton));
			wait.until(ExpectedConditions.visibilityOf(proceedProfileButton));
			wait.until(ExpectedConditions.visibilityOf(addCommissionProfileButton));
			Log.info("Commission profile page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Commission profile page not loaded successfully");
		}
		return false;
	}

	public void clickOnDomainDDButton() {
		Log.info("Trying to click on commission profile Domain DD button");
		domainDDButton.click();
		Log.info("Clicked on commission profile Domain DD button");
	}

	public void clickOnCategoryDDButton() {
		Log.info("Trying to click on commission profile Category DD button");
		categoryDDButton.click();
		Log.info("Clicked on commission profile Category DD button");
	}

	public void clickOnGeographyDDButton() {
		Log.info("Trying to click on commission profile Geography DD button");
		geographyDDButton.click();
		Log.info("Clicked on commission profile Geography DD button");
	}

	public void clickOnGradeDDButton() {
		Log.info("Trying to click on commission profile Grade DD button");
		gradeDDButton.click();
		Log.info("Clicked on commission profile Grade DD button");
	}

	public void clickOnStatusDDButton() {
		Log.info("Trying to click on commission profile Status DD button");
		statusDDButton.click();
		Log.info("Clicked on commission profile Status DD button");
	}

	public void clickOnProfileResetButton() {
		Log.info("Trying to click on commission profile reset button");
		resetProfileButton.click();
		Log.info("Clicked on commission profile reset button");
	}

	public void clickOnProfileProceedButton() {
		Log.info("Trying to click on commission profile Proceed button");
		proceedProfileButton.click();
		Log.info("Clicked on commission profile Proceed button");
	}

	public boolean checkCommissionProfilesLoadedSuccessfully() {
		Log.info("Checking if commission profiles loaded successfully after clicking on proceed button");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchInput));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//img[@src='assets/images/greenTick_circle/png/greenTick_circle.png']")));
			Log.info("Search result loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Search result not loaded successfully");
		}
		return false;
	}

	public void inputSearchCommissionProfile(String value) {
		Log.info("Inserting value for commission profile search");
		wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(value);
		Log.info("Inserted value in commission profile search : " + value);
	}

	public void clickOnAddCommissionProfileButton() {
		Log.info("Trying to click on add commission profile button");
		addCommissionProfileButton.click();
		Log.info("Clicked on add commission profile button");
	}

	public boolean checkAddCommissionProfilePageLoaded() {
		Log.info("Checking add commission profile page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(domainDDButton));
			wait.until(ExpectedConditions.visibilityOf(categoryDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographyDDButton));
			wait.until(ExpectedConditions.visibilityOf(gradeDDButton));
			wait.until(ExpectedConditions.visibilityOf(profileNameInput));
			wait.until(ExpectedConditions.visibilityOf(shortNameInput));
			wait.until(ExpectedConditions.visibilityOf(commissionTypeDDButton));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(addButton));
			Log.info("Add Commission Profile is loaded");
			return true;
		} catch (Exception e) {
			Log.info("Add Commission Profile is not loaded");
		}
		return false;
	}

	public void inputCommissionProfileName(String value) {
		Log.info("Inserting value in commission profile name");
		profileNameInput.sendKeys(value);
		Log.info("Inserted value in commission profile name : " + value);
	}

	public void inputCommissionProfileShortName(String value) {
		Log.info("Inserting value in commission profile short name");
		shortNameInput.sendKeys(value);
		Log.info("Inserted value in commission profile short name : " + value);
	}
	
	public void modifyCommissionProfileName(String value) {
		Log.info("Modifying value in commission profile name");
		profileNameInput.clear();
		profileNameInput.sendKeys(value);
		Log.info("Modifying value in commission profile name : " + value);
	}

	public void modifyCommissionProfileShortName(String value) {
		Log.info("Modifying value in commission profile short name");
		shortNameInput.clear();
		shortNameInput.sendKeys(value);
		Log.info("Modifying value in commission profile short name : " + value);
	}

	public void clickOnCommissionTypeDDButton() {
		Log.info("Trying to click on commission type DD button");
		statusDDButton.click();
		Log.info("Clicked on commission type DD button");
	}

	public void clickOnTransactionTypeDDButton() {
		Log.info("Trying to click on Transaction Type DD Button");
		transactionTypeDDButton.click();
		Log.info("Clicked on Transaction Type DD Button");
	}

	public void clickOnBaseCommissionProductDDButton() {
		Log.info("Trying to click on Base Commission Product DD Button");
		basecCommProduct.click();
		Log.info("Clicked on Base Commission Product DD Button");
	}

	public void clickOnBaseCommissionPaymentDDButton() {
		Log.info("Trying to click on Base Commission Payment DD Button");
		baseCommPaymentMode.click();
		Log.info("Clicked on Base Commission Payment DD Button");
	}

	public void inputBaseCommMultipleOf(String value) {
		Log.info("Inserting value in multiple of");
		baseCommMultipleOfInput.sendKeys(value);
		Log.info("Inserted value in multiple : " + value);
	}

	public void inputTransferValue_Min(String value) {
		Log.info("Inserting minimum transfer value");
		transferValueMin.sendKeys(value);
		Log.info("Inserted minimum transfer value : " + value);
	}

	public void inputTransferValue_Max(String value) {
		Log.info("Inserting maximum transfer value");
		transferValueMax.sendKeys(value);
		Log.info("Inserted maximum transfer value : " + value);
	}

	public void selectFOCCheckBox() {
		Log.info("Trying to select FOC check box tax calculation");
		focCheckBox.click();
		Log.info("Selected FOC check box tax calculation");
	}

	public void selectC2CTransferCheckBox() {
		Log.info("Trying to select C2C Transfer check box tax calculation");
		c2cTransferCheckBox.click();
		Log.info("Selected C2C Transfer check box tax calculation");
	}

	public void inputTransactionRangeValue_Min(String value) {
		Log.info("Inserting minimum Transaction Range value");
		transactionAmountRange_Min.sendKeys(value);
		Log.info("Inserted minimum Transaction Range value : " + value);
	}

	public void inputTransactionRangeValue_Max(String value) {
		Log.info("Inserting maximum Transaction Range value");
		transactionAmountRange_Max.sendKeys(value);
		Log.info("Inserted maximum Transaction Range value : " + value);
	}

	public void inputCommissionRateUnitValue(String value) {
		Log.info("Inserting Commission Rete Unit value");
		commissionRateUnit_Input.sendKeys(value);
		Log.info("Inserted Commission Rete Unit value : " + value);
	}

	public void inputTransactionTax1(String value) {
		Log.info("Inserting Tax1 value");
		tax1_Input.sendKeys(value);
		Log.info("Inserted Tax1 value : " + value);
	}

	public void inputTransactionTax2(String value) {
		Log.info("Inserting Tax2 value");
		tax2_Input.sendKeys(value);
		Log.info("Inserted Tax2 value : " + value);
	}

	public void inputTransactionTax3(String value) {
		Log.info("Inserting Tax3 value");
		tax3_Input.sendKeys(value);
		Log.info("Inserted Tax3 value : " + value);
	}

	public void clickOnAddButton() {
		Log.info("Trying to click on Add Button");
		addButton.click();
		Log.info("Clicked on Add Button");
	}

	public void clickOnResetButton() {
		Log.info("Trying to click on Reset Button");
		resetButton.click();
		Log.info("Clicked on Reset Button");
	}

	public void clickOnSaveAndReviewButton() {
		Log.info("Trying to click on save and review Button");
		saveReviewButton.click();
		Log.info("Clicked on save and review Button");
	}

	public void clickOnSubmitButton() {
		Log.info("Trying to click on Submit Button");
		submitButton.click();
		Log.info("Clicked on Submit Button");
	}

	public boolean checkSuccessMessageWindow() {
		Log.info("Checking success message loaded");
		try {
			wait.until(ExpectedConditions.visibilityOf(successTickIcon));
			Log.info("Success message window loaded ");
			return true;
		} catch (Exception e) {
			Log.info("Success message window is not loaded");
		}

		return false;
	}

	public void clickOnDoneButton() {
		Log.info("Trying to click on Done Button");
		doneButton.click();
		Log.info("Clicked on Done Button");
	}
	
	public void clickOnEditIcon() {
		Log.info("Trying to click on Edit icon");
		wait.until(ExpectedConditions.visibilityOf(editCommissionProfile)).click();
		Log.info("Clicked on Edit icon");
	}
	
	public boolean checkDeleteConfirmationWindow() {
		Log.info("Checking delete confirmation screen loaded");
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteScreenConfirmation));
			wait.until(ExpectedConditions.visibilityOf(RejectConfirmPopUpButton));
			wait.until(ExpectedConditions.visibilityOf(ConfirmPopUpButton));
			Log.info("Delete confirmation screen window loaded ");
			return true;
		} catch (Exception e) {
			Log.info("Success delete confirmation screen is not loaded");
		}

		return false;
	}
	
	public void clickOnReject() {
		Log.info("Trying to click on No Button");
		wait.until(ExpectedConditions.visibilityOf(RejectConfirmPopUpButton)).click();
		Log.info("Clicked on No Button");
	}
	
	public void clickOnAccept() {
		Log.info("Trying to click on Yes Button");
		wait.until(ExpectedConditions.visibilityOf(ConfirmPopUpButton)).click();
		Log.info("Clicked on Yes Button");
	}
	
	public boolean checkSuspendConfirmationWindow() {
		Log.info("Checking suspend confirmation screen loaded");
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteScreenConfirmation));
			wait.until(ExpectedConditions.visibilityOf(englishNotificationInput));
			wait.until(ExpectedConditions.visibilityOf(frenchNotificationInput));
			Log.info("Suspend confirmation screen window loaded ");
			return true;
		} catch (Exception e) {
			Log.info("Success suspend confirmation screen is not loaded");
		}

		return false;
	}
	
	public void inputEnglishNotification(String value) {
		Log.info("Inserting English Notification value");
		englishNotificationInput.sendKeys(value);
		Log.info("Inserted English Notification value : " + value);
	}
	
	public void inputFrenchNotification(String value) {
		Log.info("Inserting French Notification value");
		frenchNotificationInput.sendKeys(value);
		Log.info("Inserted French Notification value : " + value);
	}

}
