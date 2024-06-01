package angular.pageobjects.TranferRule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class C2SAddModifyDeleteTransferRule extends BaseTest {
	
	@FindBy(xpath = "//a[@href='/pretups-ui/home']//img")
	private WebElement homeButton;

	// Transfer Rule link
	@FindBy(xpath = "//span[text()='Transfer Rules']")
	private WebElement tranferRuleLink;

	// Channel to subscriber transfer rule link
	@FindBy(xpath = "//a[@href='/pretups-ui/trfRule-C2S']")
	private WebElement channelToSubscriberTransferRuleLink;

	// Single Operation Button
	@FindBy(id = "single1-button")
	private WebElement singleOperationButton;

	// View Gateway code filter
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement viewGatewayCodeFilter;

	// View Domain Code Filter
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement viewDomainFilter;

	// View Category Code Filter
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement viewCategoryFilter;

	// View Grade Filter
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement viewGradeFilter;

	// View Status Filter
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[5]")
	private WebElement viewStatusFilter;

	// Reset Button on view
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement viewResetButton;

	// Proceed Button on view
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement viewProceedButton;

	// Add Transfer Rule Button
	@FindBy(xpath = "//button[@id='addTransferRuleButton']//span")
	private WebElement addTransferRuleButton;

	// Sender Details Request Gateway Code
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement senderDetailsGatewayCodeDD;

	// Sender Details Channel Domain DD
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement senderDetailsChannelDomainDD;

	// Sender Details Channel Category DD
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement senderDetailsChannelCategoryDD;

	// Sender Details Channel Grade DD
	@FindBy(xpath = "(//label[@for='gatewayCode']//following::input//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement senderDetailsChannelGradeDD;

	// Receiver Details Receiver Type
	@FindBy(xpath = "(//label[@for='receiverType']//following::input//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement receiverDetailsReceiverTypeDD;

	// Receiver Details Receiver Service Class
	@FindBy(xpath = "(//label[@for='receiverType']//following::input//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement receiverDetailsReceiverServiceCallDD;

	// Select card group set Service Type
	@FindBy(xpath = "(//label[@for='serviceType']//following::input//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement selectGroupSetServiceTypeDD;

	// Select card group set Sub-Service
	@FindBy(xpath = "(//label[@for='serviceType']//following::input//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement selectGroupSetSubServiceDD;

	// Select card group set Card Group Set
	@FindBy(xpath = "(//label[@for='serviceType']//following::input//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement selectGroupSetCardGroupSetDD;

	// Add Transfer Rule Add Multi Rule
	@FindBy(xpath = "//label[@title='Add Record']//a")
	private WebElement addExtraRule;

	// Reset Button On Add Page
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetButtonAddPage;

	// Save Button On Add Page
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement saveButton;

	// Review and Confirm Tab
	@FindBy(id = "modal-basic-title")
	private WebElement reviewConfirmTab;

	// Review and Confirm button
	@FindBy(id = "confirmButton")
	private WebElement confirmButton;
	
	// Duplicate Record Done button
	@FindBy(xpath = "//button[@id='doneButton']//span")
	private WebElement doneButton;

	// Transfer rule added successfully
	@FindBy(id = "anotherRecharge")
	private WebElement doneTransRuleAdded;

	// View search Input
	@FindBy(xpath = "//input[@name='search']")
	private WebElement addRuleSearchInput;

	// Modify selected button
	@FindBy(xpath = "//button[@id='addTransferRuleButton']//img[@src='assets/images/edit_icon/Editicon.png']")
	private WebElement modifySelectedButton;

	// Delete selected button
	@FindBy(xpath = "//button[@id='addTransferRuleButton']//img[@src='assets/images/delete_icon/png/delete.png']")
	private WebElement deleteSelectedButton;

	// Modify Card Group set DD
	@FindBy(xpath = "(//button[contains(@class,'dropdown-toggle')])[1]")
	private WebElement modifyCardGroupDD;

	// Modify status DD
	@FindBy(xpath = "(//button[contains(@class,'dropdown-toggle')])[2]")
	private WebElement modifyStatusDD;

	// Modify Save Confirmation
	@FindBy(xpath = "//button[@id='rejectConfirmYes']//span")
	private WebElement modifyYesButton;
	
	// Modify No button
	@FindBy(xpath = "//button[@id='rejectConfirmNo']//span")
	private WebElement modifyNoButton;
	
	// Done changes button
	@FindBy(xpath = "//button[@id='anotherRecharge']//span")
	private WebElement doneChnagesButton;
	
	// Modify action from column
	@FindBy(xpath = "(//span[@id='editLink'])[2]")
	private WebElement modifyColumnAction;
	
	// Delete action from column
	@FindBy(xpath = "(//span[@id='delete'])[2]")
	private WebElement deleteColumnAction;
	
	// Copy/Duplicate button
	@FindBy(xpath = "//label[@title='Copy Record']//a//img")
	private WebElement duplicateButton;
	
	/* ----- WebDriver Declaration ----- */

	WebDriver driver = null;
	WebDriverWait wait = null;

	public C2SAddModifyDeleteTransferRule(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* ----- Basic UI Function ----- */

	public boolean visibilityOFTransferRuleLink() {
		Log.info("Checking for the visibility of Transfer Rule Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(tranferRuleLink));
			Log.info("Transfer Rule Link is available");
			return true;
		} catch (Exception e) {
			Log.info("Transfer Rule link is not visible");
			return false;
		}
	}
	
	public void clickOnHomeButton() {
		Log.info("Trying to click on home button");
		homeButton.click();
		Log.info("Clicked on home button");
	}

	public void clickOnTransferRuleLink() {
		Log.info("Trying to click on transfer rule link");
		wait.until(ExpectedConditions.visibilityOf(tranferRuleLink)).click();
		Log.info("Clicked on transfer rule link");
	}

	public boolean visibilityOfChannelToSubscriber() {
		Log.info("Checking for visibility of Channel to Subscriber Link");
		if (visibilityOFTransferRuleLink()) {
			try {
				wait.until(ExpectedConditions.visibilityOf(channelToSubscriberTransferRuleLink));
				Log.info("Channel to subscriber transfer rule link");
				return true;
			} catch (Exception e) {
				Log.info("Channel to subscriber transfer rule link is not visible");
				return false;
			}
		}

		return false;
	}

	public void clickOnChannelToSubscriberLink() {
		Log.info("Trying to click Channel to Subscriber link");
		wait.until(ExpectedConditions.visibilityOf(channelToSubscriberTransferRuleLink)).click();
		Log.info("Clicked on channel to subscriber link");
	}

	public boolean checkTransferRulePageLoadedSuccessfully() {
		Log.info("Checking Transfer Rule Page Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(singleOperationButton));
			Log.info("Transfer Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Transfer Page is not loaded");
			return false;
		}

	}

	public void clickOnViewGatewayDD() {
		Log.info("Trying to click on view filter Gateway Code DD");
		wait.until(ExpectedConditions.visibilityOf(viewGatewayCodeFilter)).click();
		Log.info("Clicked on view filter Gateway Code DD");
	}

	public void clickOnViewDomainDD() {
		Log.info("Trying to click on view filter Domain DD");
		wait.until(ExpectedConditions.visibilityOf(viewDomainFilter)).click();
		Log.info("Clicked on view filter Domain DD");
	}

	public void clickOnViewCategoryDD() {
		Log.info("Trying to click on view filter Category DD");
		wait.until(ExpectedConditions.visibilityOf(viewCategoryFilter)).click();
		Log.info("Clicked on view filter Category DD");
	}

	public void clickOnViewGradeDD() {
		Log.info("Trying to click on view filter Grade DD");
		wait.until(ExpectedConditions.visibilityOf(viewGradeFilter)).click();
		Log.info("Clicked on view filter Grade DD");
	}

	public void clickOnViewStatusDD() {
		Log.info("Trying to click on view filter Status DD");
		wait.until(ExpectedConditions.visibilityOf(viewStatusFilter)).click();
		Log.info("Clicked on view filter Status DD");
	}

	public void clickOnViewFilterReset() {
		Log.info("Trying to click on view filter reset button");
		wait.until(ExpectedConditions.visibilityOf(viewResetButton)).click();
		Log.info("Clicked on view filter reset button");
	}

	public void clickOnViewFilterProceed() {
		Log.info("Trying to click on view filter proceed button");
		wait.until(ExpectedConditions.visibilityOf(viewProceedButton)).click();
		Log.info("Clicked on view filter proceed button");
	}

	public void clickOnAddSingleTransferRule() {
		Log.info("Trying to click on add transfer rule button");
		wait.until(ExpectedConditions.visibilityOf(addTransferRuleButton)).click();
		Log.info("Clicked on add transfer rule button");
	}

	public boolean checkForAddTransferRulePageLoadedSuccessfully() {
		Log.info("Checking if add transfer rule page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(saveButton));
			Log.info("Add transfer rule page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Add transfer page is not loaded");
			return false;
		}
	}

	public void clickOnSenderRequestGatewayCodeDD() {
		Log.info("Trying to click on sender request gasteway code DD");
		wait.until(ExpectedConditions.visibilityOf(senderDetailsGatewayCodeDD)).click();
		Log.info("Clicked on sender request gateway code DD");
	}

	public void clickOnSenderRequestChannelDomainDD() {
		Log.info("Trying to click on sender request channel domain DD");
		wait.until(ExpectedConditions.visibilityOf(senderDetailsChannelDomainDD)).click();
		Log.info("Clicked on sender request channel domain DD");
	}

	public void clickOnSenderRequestChannelCategoryDD() {
		Log.info("Trying to click on sender request channel category DD");
		wait.until(ExpectedConditions.visibilityOf(senderDetailsChannelCategoryDD)).click();
		Log.info("Clicked on sender request channel category DD");
	}

	public void clickOnSenderRequestChannelGradeDD() {
		Log.info("Trying to click on sender request Channel Grade DD");
		wait.until(ExpectedConditions.visibilityOf(senderDetailsChannelGradeDD)).click();
		Log.info("Clicked on sender request Channel Grade DD");
	}

	public void clickOnReceiverDetailsReceiverTypeDD() {
		Log.info("Trying to click on receiver details receiver type DD");
		wait.until(ExpectedConditions.visibilityOf(receiverDetailsReceiverTypeDD)).click();
		Log.info("Clicked on receiver details receiver type DD");
	}

	public void clickOnReceiverDetailsReceiverServiceClassDD() {
		Log.info("Trying to click on receiver details receiver service class DD");
		wait.until(ExpectedConditions.visibilityOf(receiverDetailsReceiverServiceCallDD)).click();
		Log.info("Clicked on receiver details receiver service class DD");
	}

	public void clickOnCardGroupSetServiceType() {
		Log.info("Trying to click on card group set service type DD");
		wait.until(ExpectedConditions.visibilityOf(selectGroupSetServiceTypeDD)).click();
		Log.info("Clicked on card group set service type DD");
	}

	public void clickOnCardGroupSetSubService() {
		Log.info("Trying to click on card group set sub-service");
		wait.until(ExpectedConditions.visibilityOf(selectGroupSetSubServiceDD)).click();
		Log.info("Clicked on card group set sub-service");
	}

	public void clickOnCardGroupSetDD() {
		Log.info("Trying to click on card group set DD");
		wait.until(ExpectedConditions.visibilityOf(selectGroupSetCardGroupSetDD)).click();
		Log.info("Clicked on card group set DD");
	}

	public void clickOnAddExtraRuleButton() {
		Log.info("Trying to click on add extra rule button");
		wait.until(ExpectedConditions.visibilityOf(addExtraRule)).click();
		Log.info("Clicked on add extra rule button");
	}

	public void clickOnAddRuleResetButton() {
		Log.info("Trying to click on add rule reset button");
		wait.until(ExpectedConditions.visibilityOf(resetButtonAddPage)).click();
		Log.info("Clicked on add rule reset button");
	}

	public void clickOnSaveButton() {
		Log.info("Trying to click on add rule save button");
		wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
		Log.info("Clicked on add rule save button");
	}

	public boolean visibilityOfReviewAndConfirmTab() {
		Log.info("Checking for the visibilty of Review and Confirm tab");
		try {

			wait.until(ExpectedConditions.visibilityOf(reviewConfirmTab));
			Log.info("Review and Confrim tab is visible");
			return true;
		} catch (Exception e) {
			Log.info("Review and Confirm tab is visible");
			return false;
		}
	}

	public void clickOnDoneButtonAfterAdd() {
		Log.info("Trying to click on done button after confirmation");
		wait.until(ExpectedConditions.visibilityOf(confirmButton)).click();
		Log.info("Clicked on done button after confirmation");
	}

	public boolean checkForSearchResultVisible() {
		Log.info("Checking for visibility of search result visibility");
		try {
			wait.until(ExpectedConditions.visibilityOf(addRuleSearchInput));
			Log.info("Search result loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Search result is not available");
			return false;
		}
	}

	public void clickOnTransRuleAddedSuccessfully() {

		Log.info("Trying to click on done button after confirming");
		wait.until(ExpectedConditions.visibilityOf(doneTransRuleAdded)).click();
		Log.info("Clicked on done button after confirmation");
	}

	public void clickOnModifySelectedButton() {

		Log.info("Trying to click on modify selected button");
		wait.until(ExpectedConditions.visibilityOf(modifySelectedButton)).click();
		Log.info("Clicked on modify selected button");
	}

	public void clickOnDeleteSelectedButton() {
		Log.info("Trying to click on delete selected button");
		wait.until(ExpectedConditions.visibilityOf(deleteSelectedButton)).click();
		Log.info("Clicked on delete selected button");
	}

	public void clickOnModifyCardGroupSetDD() {
		Log.info("Trying to click on modify crad group DD");
		wait.until(ExpectedConditions.visibilityOf(modifyCardGroupDD)).click();
		Log.info("Clicked on modify card group DD");
	}

	public void clickOnModifyStatusDD() {
		Log.info("Trying to click on modify status DD");
		wait.until(ExpectedConditions.visibilityOf(modifyStatusDD)).click();
		Log.info("Clicked on modify status DD");
	}
	
	public void clickOnModifyYesButton() {
		Log.info("Trying to click on modify Yes button");
		wait.until(ExpectedConditions.visibilityOf(modifyYesButton)).click();
		Log.info("Clicked on yes button");
	}

	public void clickOnModifyNoButton() {
		Log.info("Trying to click on modify no button");
		wait.until(ExpectedConditions.visibilityOf(modifyNoButton)).click();
		Log.info("Clicked on modify no button");
	}
	
	public void clickOnDoneChangesButton() {
		Log.info("Trying to click on done button");
		wait.until(ExpectedConditions.visibilityOf(doneChnagesButton)).click();
		Log.info("Clicked on Done button");
	}
	
	public void clickOnModifyIconFromColumn() {
		Log.info("Trying to click on modify icon from column");
		wait.until(ExpectedConditions.visibilityOf(modifyColumnAction)).click();;
		Log.info("Clicked on modify action from column");
	}
	
	public void clickOnDeleteIconFromColumn() {
		Log.info("Trying to click on delete icon from column");
		wait.until(ExpectedConditions.visibilityOf(deleteColumnAction)).click();
		Log.info("Clicked on delete action from column");
	}
	
	public void clickOnDoneButtonAfterErrorOnAddTransferRule() {
		Log.info("Trying to click on done button");
		wait.until(ExpectedConditions.visibilityOf(doneButton)).click();
		Log.info("Clicked on done button");
	}
	
	public void clickOnDuplicateRuleButton() {
		Log.info("Trying to click On duplicate rule button");
		wait.until(ExpectedConditions.visibilityOf(duplicateButton)).click();
		Log.info("Clicked on duplicate rule button");
	}

}
