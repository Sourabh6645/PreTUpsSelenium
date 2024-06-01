package angular.pageobjects.TranferRule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;



public class O2CAddModifyDeleteTransferRule extends BaseTest {

	// Transfer Rule link
	@FindBy(xpath = "//span[text()='Transfer Rules']")
	private WebElement tranferRuleLink;

	// O2C Transfer Rule
	@FindBy(xpath = "//span[text()='Transfer Rules']//following::a[4]")
	private WebElement O2CTransferRuleLink;

	// Select Category Domain DD
	@FindBy(xpath = "//div[@class='ng-select-container']//span[@class='ng-arrow-wrapper']")
	private WebElement selectCategoryDomainDDbutton;

	// Select Category Reset
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement selectCategoryReset;

	// Select Category Proceed
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement selectCategoryProceed;

	// Add Associate and Transfer Rule
	@FindBy(xpath = "//button[@id='addTransferRuleButton']")
	private WebElement addAssociateTransferRuleButton;

	// Search result input
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;

	// Message Window
	@FindBy(xpath = "//div[@id='modal-basic-title']")
	private WebElement messageWindow;

	// Done button
	@FindBy(xpath = "//button[@id='anotherRecharge']//span")
	private WebElement doneButton;

	// Delete Icon
	@FindBy(xpath = "//span[@id='delete']//label")
	private WebElement deleteIcon;

	// Delete Rejection
	@FindBy(xpath = "//button[@id='rejectConfirmNo']//span")
	private WebElement deleteRejectConfirmation;

	// Delete Acceptance
	@FindBy(xpath = "//button[@id='rejectConfirmYes']//span")
	private WebElement deleteConfirmation;

	// To Category DD
	@FindBy(xpath = "//div[@class='subHeadingList']//following::span[@class='ng-arrow-wrapper']")
	private WebElement toCategoryDD;

	// Sales Allowed Yes
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[3]")
	private WebElement salesAllowedYes;

	// Sales Allowed No
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[4]")
	private WebElement salesAllowedNo;

	// Transfer FOC Allowed Yes
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[5]")
	private WebElement transferFOCYes;

	// Transfer FOC Allowed No
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[6]")
	private WebElement transferFOCNo;

	// Bulk Commission Payout Allowed Yes
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[7]")
	private WebElement bulkCommissionYes;

	// Bulk Commission Payout Allowed No
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[8]")
	private WebElement bulkCommissionNo;

	// Withdrawal Allowed Yes
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[1]")
	private WebElement withdrawalAllowedYes;

	// Withdrawal Allowed No
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[2]")
	private WebElement withdrawalAllowedNo;

	// Return Allowed Yes
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[9]")
	private WebElement returnAllowedYes;

	// Return Allowed No
	@FindBy(xpath = "(//div[@class='mat-radio-container'])[10]")
	private WebElement returnAllowedNo;

	// First Approval Limit Input
	@FindBy(xpath = "//input[@name='firstApprovalLimit']")
	private WebElement firstApprovalLimitInput;

	// Second Approval Limit Input
	@FindBy(xpath = "//input[@name='secondApprovalLimit']")
	private WebElement secondApprovalLimitInput;

	// Product Association eTopUP
	@FindBy(xpath = "(//label[@class='mat-checkbox-layout'])[1]")
	private WebElement eTopUPCheckBox;

	// Product Association eTopUP
	@FindBy(xpath = "(//label[@class='mat-checkbox-layout'])[2]")
	private WebElement posteTopUPCheckBox;
	
	// Modify Icon
	@FindBy(xpath = "//img[@src='assets/images/edit_icon/Editicon.png']")
	private WebElement modifyButton;

	// WebDriver Declaration

	WebDriver driver = null;
	WebDriverWait wait = null;

	// Constructor

	public O2CAddModifyDeleteTransferRule(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* ----- Basic UI Function ----- */

	// check visibility of Transfer rule

	public boolean checkVisibilityOfTransferRuleLink() {
		Log.info("Check for the visibility of Transfer Rule Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(tranferRuleLink));
			Log.info("Transfer Rule Link is visible");
			return true;
		} catch (Exception e) {
			Log.info("Transfer Rule Link is not visible");
			return false;
		}
	}

	public void clickOnTransferRuleLink() {
		Log.info("Trying to click on Transfer Rule Link");
		wait.until(ExpectedConditions.visibilityOf(tranferRuleLink)).click();
		Log.info("Clicked on Transfer Rule Link");
	}

	public boolean checkVisibilityOfO2CTransferLink() {
		Log.info("Checking visibility of O2C Transfer Rule Link");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Transfer Rules'][contains(@class,'expand')]")));
			Log.info("O2C Transfer Rule link is visible");
			return true;
		} catch (Exception e) {
			Log.info("O2C Transfer Rule link is not visible");
			return false;
		}
	}

	public void clickOnO2CTransferRuleLink() {
		boolean value = false;
		Log.info("Trying to click on O2C Transfer Rule Link");
		if (checkVisibilityOfO2CTransferLink()) {
			wait.until(ExpectedConditions.visibilityOf(O2CTransferRuleLink)).click();
		} else {
			clickOnTransferRuleLink();
			wait.until(ExpectedConditions.visibilityOf(O2CTransferRuleLink)).click();
		}
		Log.info("Clicked on O2C Transfer Rule Link");

	}

	public boolean checkAssociateO2CTransRulePageLoadedSuccessfully() {
		Log.info("Checking if associate o2c transfer rule page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(selectCategoryDomainDDbutton));
			Log.info("Associate O2C Transfer Rule Page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Associate O2C Transfer Rule page is not loaded");
			return false;
		}
	}
	
	public boolean checkAssociateTransferRulePageLoadedSuccessfully() {
		Log.info("Checking if Associate Transfer Rule Page Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(eTopUPCheckBox));
			Log.info("Associate Transfer Rule page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Associate Transfer Rule page loaded not successfully");
			return false;
		}
	}

	public void clickOnCategoryDomainDD() {
		Log.info("Trying to click on Select Category Domain DD");
		wait.until(ExpectedConditions.visibilityOf(selectCategoryDomainDDbutton)).click();
		Log.info("Clicked on select category domain DD");
	}

	public void clickOnCategoryDomainReset() {
		Log.info("Trying to click on Reset Button");
		wait.until(ExpectedConditions.visibilityOf(selectCategoryReset)).click();
		Log.info("Clicked on Reset Button");
	}

	public void clickOnCategoryDomainProceedButton() {
		Log.info("Trying to click on Procedd Button");
		wait.until(ExpectedConditions.visibilityOf(selectCategoryProceed)).click();
		Log.info("Clicked on Proceed Button");
	}

	public void clickOnAddAssociateTransferRuleButton() {
		Log.info("Trying to click on add associate transfer rule button");
		wait.until(ExpectedConditions.visibilityOf(addAssociateTransferRuleButton)).click();
		Log.info("Clicked on add associate transfer rule button");
	}

	public void clickOnToCategoryDD() {
		Log.info("Trying to click on To Category DD");
		wait.until(ExpectedConditions.visibilityOf(toCategoryDD)).click();
		Log.info("Clicked on To Category DD");
	}

	public void checkIfRadioButtonSelected(WebElement element) {
		if (element.isSelected()) {
			Log.info("Radio button selected successfully");
		} else {
			Log.info("Radio button is not selected");
		}
	}

	public void selectTransferSalesAllowedYes() {
		Log.info("Trying to select Sales Allowed Yes");
		wait.until(ExpectedConditions.visibilityOf(salesAllowedYes)).click();;
		checkIfRadioButtonSelected(salesAllowedYes);
	}

	public void selectTransferSalesAllowedNo() {
		Log.info("Trying to select Sales Allowed No");
		wait.until(ExpectedConditions.visibilityOf(salesAllowedNo)).click();
		checkIfRadioButtonSelected(salesAllowedNo);
	}

	public void selectFOCAllowedYes() {
		Log.info("Trying to select FOC Allowed as Yes");
		wait.until(ExpectedConditions.visibilityOf(transferFOCYes)).click();
		checkIfRadioButtonSelected(transferFOCYes);
	}

	public void selectFOCAllowedNo() {
		Log.info("Trying to select FOC Allowed as No");
		wait.until(ExpectedConditions.visibilityOf(transferFOCNo)).click();
		checkIfRadioButtonSelected(transferFOCNo);
	}

	public void selectBulkCommissionSelectYes() {
		Log.info("Trying to select Bulk Commission as Yes");
		wait.until(ExpectedConditions.visibilityOf(bulkCommissionYes)).click();
		checkIfRadioButtonSelected(bulkCommissionYes);
	}

	public void selectBulkCommissionSelectNo() {
		Log.info("Trying to select Bulk Commission as No");
		wait.until(ExpectedConditions.visibilityOf(bulkCommissionNo)).click();
		checkIfRadioButtonSelected(bulkCommissionNo);
	}

	public void selectWithdrawalAllowedYes() {
		Log.info("Trying to select withdrawal allowed as Yes");
		wait.until(ExpectedConditions.visibilityOf(withdrawalAllowedYes)).click();
		checkIfRadioButtonSelected(withdrawalAllowedYes);
	}

	public void selectWithdrawalAllowedNo() {
		Log.info("Trying to select withdrawal allowed as No");
		wait.until(ExpectedConditions.visibilityOf(withdrawalAllowedNo)).click();
		checkIfRadioButtonSelected(withdrawalAllowedNo);
	}

	public void selectReturnAllowedYes() {
		Log.info("Trying to select Return Allowed as Yes");
		wait.until(ExpectedConditions.visibilityOf(returnAllowedYes)).click();
		checkIfRadioButtonSelected(returnAllowedYes);
	}

	public void selectReturnAllowedNo() {
		Log.info("Trying to select Return Allowed as No");
		wait.until(ExpectedConditions.visibilityOf(returnAllowedNo)).click();
		checkIfRadioButtonSelected(returnAllowedNo);
	}
	
	public void inputFirstApporvalLimit(String s) {
		Log.info("Trying to input First Approval Limit");
		wait.until(ExpectedConditions.visibilityOf(firstApprovalLimitInput)).sendKeys(s);
		Log.info("Inserted First Approval Limit as : "+s);
	}
	
	public void inputSecondApprovalLimit(String s) {
		Log.info("Trying to input Second Approval Limit");
		wait.until(ExpectedConditions.visibilityOf(secondApprovalLimitInput)).sendKeys(s);
		Log.info("Inserted Second Approval Limit as : "+s);
	}
	
	public void selecteTopUpProductAssociation() {
		Log.info("Trying to associate eTopUp product");
		wait.until(ExpectedConditions.visibilityOf(eTopUPCheckBox)).click();
		Log.info("eTopUp Product associated successfully");
	}
	
	public void selectPosteTopUpProductAssociation() {
		Log.info("Trying to associate Post eTopUp product");
		wait.until(ExpectedConditions.visibilityOf(posteTopUPCheckBox)).click();
		Log.info("Post eTopUp Product associated successfully");
	}
	
	public boolean checkMessageWindowLoadedSuccessfully() {
		Log.info("Checking if message window loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(messageWindow));
			Log.info("Message window loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("No message window found");
			return false;
		}
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on message window done button");
		wait.until(ExpectedConditions.visibilityOf(doneButton)).click();
		Log.info("Clicked on done button");
	}
	
	public boolean checkSearchResultLoadedSuccessfully() {
		Log.info("Trying to check if the search result are loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchField));
			Log.info("Selected domain have transfer rules Associated with it");
			return true;
		}catch(Exception e) {
			Log.info("Selected domain don't have any transfer rule associated with it");
			return false;
		}
	}
	
	public void inputValueInSearchField(String s) {
		Log.info("Trying to insert value in search field");
		wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(s);
		Log.info("Inserted value : "+s);
	}
	
	public void clickOnDeleteIcon() {
		Log.info("Trying to click on delete button");
		wait.until(ExpectedConditions.visibilityOf(deleteIcon)).click();
		Log.info("Clicked on delete button");
	}
	
	public void clickOnAcceptDelete() {
		Log.info("Trying to proceed with accept delete");
		wait.until(ExpectedConditions.visibilityOf(deleteConfirmation)).click();
		Log.info("Clicked on confirm button");
	}
	
	public void clickOnRejectDelete() {
		Log.info("Trying to reject delete");
		wait.until(ExpectedConditions.visibilityOf(deleteRejectConfirmation)).click();
		Log.info("Clicked on reject button");
	}
	
	public void clickOnModifyIcon() {
		Log.info("Trying to click on modify Icon");
		wait.until(ExpectedConditions.visibilityOf(modifyButton)).click();
		Log.info("Clicked on modify icon");
	}
}
