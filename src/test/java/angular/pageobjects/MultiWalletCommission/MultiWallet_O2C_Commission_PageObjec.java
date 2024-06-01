package angular.pageobjects.MultiWalletCommission;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;



public class MultiWallet_O2C_Commission_PageObjec extends BaseTest {
	
	@FindBy(xpath = "(//a[@href='/pretups-merger-ui/operatortochannel'])[1]//span")
	private WebElement operatorToChannelLink;
	
	@FindBy(xpath = "//a[@href='/pretups-merger-ui/commission']//span")
	private WebElement commissionLink;
	
	@FindBy(xpath = "//span[contains(@class,'childmenucss')][contains(@class,'expand')]")
	private WebElement childMenuExpanded;
	
	@FindBy(xpath = "//button[@id='singleToggle-button']//span")
	private WebElement singleOperationButton;
	
	@FindBy(xpath = "//button[@id='bulkToggle-button']")
	private WebElement bulkOperationButton;
	
	@FindBy(xpath = "(//form[@id='control']//div[1]//div)[2]")
	private WebElement bulkCommissionPayoutHeading;
	
	@FindBy(xpath = "(//label[contains(@class,'textAlign')]//following::span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement geographyDDButton;
	
	@FindBy(xpath = "(//label[contains(@class,'textAlign')]//following::span[contains(@class,'ng-arrow-wrapper')])[2]")
	private WebElement domainDDButton;
	
	@FindBy(xpath = "(//label[contains(@class,'textAlign')]//following::span[contains(@class,'ng-arrow-wrapper')])[3]")
	private WebElement userCategoryDDButton;
	
	@FindBy(xpath = "(//label[contains(@class,'textAlign')]//following::span[contains(@class,'ng-arrow-wrapper')])[4]")
	private WebElement productDDButton;
	
	@FindBy(xpath = "(//label[contains(@class,'textAlign')]//following::span[contains(@class,'ng-arrow-wrapper')])[5]")
	private WebElement operationDDButton;
	
	@FindBy(xpath = "//div[@id='userListId']//following-sibling::label[@class='download']")
	private WebElement downloadUserListButton;
	
	@FindBy(xpath = "//div[@id='userTemplateId']//following-sibling::label[@class='download']")
	private WebElement downloadTemplateButton;
	
	@FindBy(id = "batchNameId")
	private WebElement batchNameInput;
	
	@FindBy(xpath = "//label[@for='file']")
	private WebElement chooseFileButton;
	
	@FindBy(id = "resetId")
	private WebElement resetButton;
	
	@FindBy(id = "submitId")
	private WebElement submitButton;
	
	@FindBy(xpath = "//h4[@id='modal-basic-title']")
	private WebElement reviewConfirmWindow;
	
	@FindBy(xpath = "//button[@id='confirmId']//span")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//div[@class='success']")
	private WebElement successIcon;
	
	@FindBy(id = "doneId")
	private WebElement doneButton;
	
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public MultiWallet_O2C_Commission_PageObjec(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public boolean checkVisibilityOfO2CLink() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(operatorToChannelLink));
			Log.info("Operator to Channel link is visible");
			return true;
		}catch(Exception e) {
			Log.info("Operator to Channel link is not visible");
		}
		
		return false;
	}
	
	public boolean checkChildMenuIsVisible() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(childMenuExpanded));
			Log.info("Child menu is expanded");
			return true;
		}catch(Exception e) {
			Log.info("Child menu is not expanded");
		}
		
		return false;
	}
	
	public void clickOnCommissionLink() {
		if(checkVisibilityOfO2CLink() && checkChildMenuIsVisible()) {
			wait.until(ExpectedConditions.visibilityOf(commissionLink)).click();
		}else {
			wait.until(ExpectedConditions.visibilityOf(operatorToChannelLink)).click();
			wait.until(ExpectedConditions.visibilityOf(commissionLink)).click();
		}
		Log.info("Clicked on commission Link");
	}
	
	public void clickOnBulkOption() {
		Log.info("Trying to click on bulk option");
		wait.until(ExpectedConditions.visibilityOf(bulkOperationButton)).click();
		Log.info("Clicked on bulk operation button");
	}
	
	public boolean checkBulkCommissionPayoutPageLoadedSuccessfully() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(geographyDDButton));
			wait.until(ExpectedConditions.visibilityOf(domainDDButton));
			wait.until(ExpectedConditions.visibilityOf(userCategoryDDButton));
			wait.until(ExpectedConditions.visibilityOf(productDDButton));
			wait.until(ExpectedConditions.visibilityOf(operationDDButton));
			wait.until(ExpectedConditions.visibilityOf(downloadTemplateButton));
			wait.until(ExpectedConditions.visibilityOf(downloadUserListButton));
			Log.info("All the page elements are loaded successfully on Bulk Commission Payout Page");
			return true;
		}catch(Exception e) {
			Log.info("Bulk Comission Payout Page is not loaded successfully");
		}
		
		return false;
	}
	
	public void clickOnGeographyDDButton() {
		Log.info("Trying to click on geography DD Button");
		geographyDDButton.click();
		Log.info("Clicked on geography DD Button");
	}
	
	public void clickOnDomainDDButton() {
		Log.info("Trying to click on Domain DD Button");
		domainDDButton.click();
		Log.info("Clicked on Domain DD Button");
	}
	
	public void clickOnUserCategoryDDButton() {
		Log.info("Trying to click on User Category DD Button");
		userCategoryDDButton.click();
		Log.info("Clicked on User Category DD Button");
	}
	
	public void clickOnProductDDButton() {
		Log.info("Trying to click on Product DD Button");
		productDDButton.click();
		Log.info("Clicked on Product DD Button");
	}
	
	public void clickOnOperationDDButton() {
		Log.info("Trying to click on Operation DD Button");
		operationDDButton.click();
		Log.info("Clicked on Operation DD Button");
	}
	
	public void insertBatchName(String value) {
		Log.info("Trying to insert batch name");
		batchNameInput.sendKeys(value);
		Log.info("Inserted Batch Name as : "+value);
	}
	
	public void clickOnDownloadUserListButton() {
		Log.info("Trying to click on Download User List Button");
		downloadUserListButton.click();
		Log.info("Clicked on Download User List Button");
	}
	
	public void clickOnDownloadTemplateButton() {
		Log.info("Trying to click on Download Template Button");
		downloadTemplateButton.click();
		Log.info("Clicked on Download Template Button");
	}
	
	public void clickOnRejectButton() {
		Log.info("Trying to click on Reset Button");
		resetButton.click();
		Log.info("Clicked on Reset Button");
	}
	
	public void clickOnSubmitButton() {
		Log.info("Trying to click on Submit Button");
		submitButton.click();
		Log.info("Clicked on Submit Button");
	}
	
	public boolean checkSuccessWindow() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(successIcon));
			Log.info("Success window is visible");
			return true;
		}catch(Exception e) {
			Log.info("Success window is not visible");
		}
		
		return false;
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on Done Button");
		doneButton.click();
		Log.info("Clicked on Done Button");
	}
	
	public boolean checkReviewAndConfirmScreenLoadedSuccessfully() {
		Log.info("Checking if review and confirm page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmWindow));
			wait.until(ExpectedConditions.visibilityOf(confirmButton));
			Log.info("Review and Confirm page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Review and confirm tab not loaded");
		}
		
		return false;
	}
	
	public void clickOnConfirmButton() {
		Log.info("Trying to click on Confirm Button");
		confirmButton.click();
		Log.info("Clicked on Confirm Button");
	}
	
}
