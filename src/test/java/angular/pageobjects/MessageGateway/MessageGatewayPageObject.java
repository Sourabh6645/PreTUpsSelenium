package angular.pageobjects.MessageGateway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class MessageGatewayPageObject extends BaseTest{
		
	@FindBy(xpath = "//div[@id='mat-tab-label-1-0']")
	private WebElement eTopUpButton;
	
	@FindBy(xpath = "(//a[@href='/pretups-ui/Messages'])[1]")
	private WebElement messageGatewayLink;
	
	@FindBy(xpath = "//span[contains(@class,'expand')]")
	private WebElement chilMenuExpanded;
	
	@FindBy(xpath = "(//a[@href='/pretups-ui/Messages'])[2]")
	private WebElement messageGatewayChildLink;
	
	@FindBy(xpath = "//a[@href='/pretups-ui/operatorUser/Mapping']")
	private WebElement gatewayMappingLink;
	
	@FindBy(xpath = "//label[@class='operatorHeading']")
	private WebElement messageGatewayHeading;
	
	@FindBy(xpath = "//button[@id='single']//span")
	private WebElement addSingleMessageButton;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchMessageGateway;
	
	@FindBy(xpath = "parentTable_length")
	private WebElement showEntriesDD;
	
	@FindBy(xpath = "//option[@value='100']")
	private WebElement maxEntry;
	
	@FindBy(xpath = "(//img[@src='assets/images/edit_icon/Editicon.png'])[2]")
	private WebElement editAction;
	
	@FindBy(xpath = "(//img[@src='assets/images/delete_icon/png/delete.png'])[2]")
	private WebElement deleteAction;
	
	@FindBy(id =  "modal-basic-title")
	private WebElement deleteConfirmationWindow;
	
	@FindBy(xpath = "(//div[@id='modal-basic-title']//following::button[@id='doneBtn']//span)[1]")
	private WebElement cancelDelete;
	
	@FindBy(xpath = "(//div[@id='modal-basic-title']//following::button[@id='doneBtn']//span)[2]")
	private WebElement confirmDelete;
	
	@FindBy(xpath = "//input[@id='gatewayCode']")
	private WebElement gatewayCode;
	
	@FindBy(xpath = "//input[@id='gatewayname']")
	private WebElement gatewayName;
	
	@FindBy(xpath = "(//label[@for='gatewaytype']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement gatewayTypeDD;
	
	@FindBy(xpath = "(//label[@for='gatewaytype']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement gatewaySubTypeDD;
	
	@FindBy(xpath = "(//label[@for='gatewaytype']//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement protocolDD;
	
	@FindBy(id = "host")
	private WebElement hostInput;
	
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[1]")
	private WebElement requestDetailsCheckBox;
	
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[2]")
	private WebElement pushDetailsCheckBox;
	
	@FindBy(xpath = "(//label[@class='mat-checkbox-layout']//div//input)[1]")
	private WebElement requestDetailsCheckBoxStatus;
	
	@FindBy(xpath = "(//label[@class='mat-checkbox-layout']//div//input)[2]")
	private WebElement pushDetailsCheckBoxStatus;
	
	@FindBy(id = "serviceport")
	private WebElement requestDetailsServicePort;
	
	@FindBy(xpath = "(//label[@for='authtype']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement authorisationTypeDD;
	
	@FindBy(xpath = "(//input[@id='loginId'])[1]")
	private WebElement loginIdInput;
	
	@FindBy(xpath = "(//input[@id='password'])[1]")
	private WebElement passwordInput;
	
	@FindBy(xpath = "(//input[@id='confirnpassword'])[1]")
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath = "(//label[@for='status']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement requestDetailsStatusDD;
	
	@FindBy(xpath = "(//label[@for='contenttype']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement requestDetailsContentTypeDD;
	
	@FindBy(xpath = "(//label[@for='encryptionlevel']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement encryptionLevelDD;
	
	@FindBy(id = "key")
	private WebElement keyInput;
	
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[3]")
	private WebElement underProcessCheckRequired;
	
	@FindBy(xpath = "(//span[@class='mat-checkbox-label'])[4]")
	private WebElement EncryptPassword;
	
	@FindBy(id = "port")
	private WebElement pushDetailsPort;
	
	@FindBy(xpath = "(//label[@for='status']//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement pushDetailsStatusDD;
	
	@FindBy(xpath = "(//input[@id='loginId'])[2]")
	private WebElement pushDetailsLoginId;
	
	@FindBy(xpath = "(//input[@id='password'])[2]")
	private WebElement pushDetailsPassword;
	
	@FindBy(xpath = "(//input[@id='confirnpassword'])[2]")
	private WebElement pushDetailsConfirmPassword;
	
	@FindBy(id = "destination")
	private WebElement destinationNumberinput;
	
	@FindBy(id = "timeout")
	private WebElement timeOutInput;
	
	@FindBy(id = "path")
	private WebElement pathInput;
	
	@FindBy(xpath = "(//button[@name='Reset']//span)[1]")
	private WebElement gatewayDetailsReset;
	
	@FindBy(xpath = "(//button[@name='Reset']//span)[2]")
	private WebElement addMessageGatewayReset;
	
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement submitButton;
	
	@FindBy(xpath = "//div[@id='modal-basic-title']")
	private WebElement reviewAndConfirmHeading;
	
	@FindBy(xpath = "//button[@class='close']")
	private WebElement reviewAndConfirmCloseButton;
	
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[1]")
	private WebElement reviewConfirmCancel;
	
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[2]")
	private WebElement reviewConfirmConfirm;
	
	@FindBy(xpath = "//div[@class='success1']")
	private WebElement successMessageWindow;
	
	@FindBy(xpath = "//img[@src='assets/images/failed_icons/png/cancel.png']")
	private WebElement errorMessageWindow;
	
	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement doneButton;
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public MessageGatewayPageObject(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public boolean checkETopUpVisibilty() {
		try {
			wait.until(ExpectedConditions.visibilityOf(eTopUpButton));
			Log.info("eTopUp button is visible");
			return true;
		}catch(Exception e) {
			Log.info("eTopUp button is not visible");
		}
		return false;
	}
	
	public void clickOnETopUPButton() {
		Log.info("Trying to click on eTopUp button");
		eTopUpButton.click();
		Log.info("Clicked on eTopUp button");
	}
	
	public boolean checkMessageGatewayMenuExpanded() {
		try {
			wait.until(ExpectedConditions.visibilityOf(chilMenuExpanded));
			Log.info("Child menu is already visible");
			return true;
		}catch(Exception e) {
			Log.info("Child menu is not visible");
		}
		return false;
	}
	
	public boolean checkMessageGatewayPageLoadedSuccessfully() {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(messageGatewayHeading));
			wait.until(ExpectedConditions.visibilityOf(addSingleMessageButton));
			wait.until(ExpectedConditions.visibilityOf(searchMessageGateway));
			Log.info("Message gateway page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Message gateway page not loaded successfully");
		}
		return false;
	}
	
	public void clickOnMessageGatewayLink() {
		if(!checkMessageGatewayMenuExpanded()) {
			messageGatewayLink.click();
		}
		if(!checkMessageGatewayPageLoadedSuccessfully()) {
			messageGatewayChildLink.click();
		}
	}
	
	public void clickAddMessageGatewayDetailsButton(){
		Log.info("Trying to click on add single message gateway details page");
		wait.until(ExpectedConditions.visibilityOf(addSingleMessageButton)).click();
		Log.info("Clicked on add single message gateway details page");
	}
	
	public boolean checkAddMessageGatewayPageLoadedSuccessfully() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(gatewayCode));
			wait.until(ExpectedConditions.visibilityOf(gatewayName));
			wait.until(ExpectedConditions.visibilityOf(gatewayTypeDD));
			wait.until(ExpectedConditions.visibilityOf(gatewaySubTypeDD));
			wait.until(ExpectedConditions.visibilityOf(protocolDD));
			wait.until(ExpectedConditions.visibilityOf(hostInput));
			Log.info("Add gateway details page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Add gateway details page not loaded successfully");
		}
		
		return false;
	}
	
	public void insertGatewayCode(String value) {
		Log.info("Inserting gateway code : "+value);
		gatewayCode.sendKeys(value);
		Log.info("Gateway code inserted successfully");
	}
	
	public void insertGatewayName(String value) {
		Log.info("Inserting gateway name : "+value);
		gatewayName.sendKeys(value);
		Log.info("Gateway name inserted successfully");
	}
	
	public void clickOnGatewayTypeDDButton() {
		Log.info("Trying to click on gateway type dd button");
		gatewayTypeDD.click();
		Log.info("Clicked on Gateway Type DD Button");
	}
	
	public void clickOnGatewaySubTypeDDButton() {
		Log.info("Trying to click on gateway Subtype dd button");
		gatewaySubTypeDD.click();
		Log.info("Clicked on Gateway SubType DD Button");
	}
	
	public void clickOnGatewayProtocolDDButton() {
		Log.info("Trying to click on gateway Protocol dd button");
		protocolDD.click();
		Log.info("Clicked on Gateway Protocol DD Button");
	}
	
	public void insertHostValue(String value) {
		Log.info("Inserting Host Value : "+value);
		hostInput.sendKeys(value);
		Log.info("Host Value inserted successfully");
	}
	
	public void selectRequestDetailsCheckBox() {
		Log.info("Trying to select Requested details");
		requestDetailsCheckBox.click();
		Log.info("Clicked on requested details check box");
	}
	
	public void selectPushDetailsCheckBox() {
		Log.info("Trying to select Requested details");
		pushDetailsCheckBox.click();
		Log.info("Clicked on requested details check box");
	}
	
	public void clickOnGatewayDetailsResetButton() {
		Log.info("Trying to click on gateway details reset button");
		gatewayDetailsReset.click();
		Log.info("Clicked on gateway details reset button");
	}
	
	public void clickOnSubmitButton() {
		Log.info("Trying to click on submit button");
		submitButton.click();
		Log.info("Clicked on submit button");
	}
	
	public void insertPushDetailsPort(String value) {
		Log.info("Inserting Push details port Value : "+value);
		pushDetailsPort.sendKeys(value);
		Log.info("Push details port Value inserted successfully");
	}
	
	public void insertRequestDetailsPort(String value) {
		Log.info("Inserting Request details port Value : "+value);
		requestDetailsServicePort.sendKeys(value);
		Log.info("Request details port Value inserted successfully");
	}
	
	public void clickOnAuthrizationTypeDDButton() {
		Log.info("Trying to click on Authrization type dd button");
		authorisationTypeDD.click();
		Log.info("Clicked on Authrization Type DD Button");
	}
	
	public void insertRequestDetailsloginId(String value) {
		Log.info("Inserting Request details loginId Value : "+value);
		loginIdInput.sendKeys(value);
		Log.info("Request details loginId Value inserted successfully");
	}
	
	public void insertRequestDetailsPass(String value) {
		Log.info("Inserting Request details password Value : "+value);
		passwordInput.sendKeys(value);
		Log.info("Request details password Value inserted successfully");
	}
	
	public void insertRequestDetailsConfirmPass(String value) {
		Log.info("Inserting Request details confirm password Value : "+value);
		confirmPasswordInput.sendKeys(value);
		Log.info("Request details confirm password Value inserted successfully");
	}
	
	public void insertPushetDetailsloginId(String value) {
		Log.info("Inserting Push details loginId Value : "+value);
		pushDetailsLoginId.sendKeys(value);
		Log.info("Push details loginId Value inserted successfully");
	}
	
	public void insertPushDetailsPass(String value) {
		Log.info("Inserting Push details password Value : "+value);
		pushDetailsPassword.sendKeys(value);
		Log.info("Push details password Value inserted successfully");
	}
	
	public void insertPushDetailsConfirmPass(String value) {
		Log.info("Inserting Push details confirm password Value : "+value);
		pushDetailsConfirmPassword.sendKeys(value);
		Log.info("Push details confirm password Value inserted successfully");
	}
	
	public void clickOnRequestDetailsStatusDDButton() {
		Log.info("Trying to click on Request Details Status dd button");
		requestDetailsStatusDD.click();
		Log.info("Clicked on Request Details Status DD Button");
	}
	
	public void clickOnRequestDetailsContentTypeDDButton() {
		Log.info("Trying to click on Request Details Content Type dd button");
		requestDetailsContentTypeDD.click();
		Log.info("Clicked on Request Details Content Type DD Button");
	}
	
	public void clickOnRequestDetailsEncryptionLevelDDButton() {
		Log.info("Trying to click on Request Details Encryption Level dd button");
		encryptionLevelDD.click();
		Log.info("Clicked on Request Details Encryption Level DD Button");
	}
	
	public void insertRequestDetailsKey(String value) {
		Log.info("Inserting Request details Key Value : "+value);
		keyInput.sendKeys(value);
		Log.info("Request details Key Value inserted successfully");
	}
	
	public void selectUnderProcessRequiredCheckBox() {
		Log.info("Trying to select Under Process Required check box");
		underProcessCheckRequired.click();
		Log.info("Clicked on Under Process Required check box");
	}
	
	public void selectEncryptPasswordCheckBox() {
		Log.info("Trying to select Encrypt Password check box");
		underProcessCheckRequired.click();
		Log.info("Clicked on Encryp tPassword check box");
	}
	
	public void clickOnPushDetailsStatuesDDButton() {
		Log.info("Trying to click on Push Details Status dd button");
		pushDetailsStatusDD.click();
		Log.info("Clicked on Push Details Status DD Button");
	}
	
	public void insertPushetDetailsDestinationNumber(String value) {
		Log.info("Inserting Push details Destination Number Value : "+value);
		destinationNumberinput.sendKeys(value);
		Log.info("Push details Destination Number Value inserted successfully");
	}
	
	public void insertPushDetailsTimeOut(String value) {
		Log.info("Inserting Push details Time Out Value : "+value);
		timeOutInput.sendKeys(value);
		Log.info("Push details Time Out Value inserted successfully");
	}
	
	public void insertPushDetailsPath(String value) {
		Log.info("Inserting Push details Path Value : "+value);
		pathInput.sendKeys(value);
		Log.info("Push details Path Value inserted successfully");
	}
	
	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");
		addMessageGatewayReset.click();
		Log.info("Clicked on reset button");
	}
	
	public boolean CheckReviewAndConfirmPageLoadedSuccessfully() {
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmHeading));
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmCloseButton));
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmCancel));
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmConfirm));
			Log.info("Review and confirm page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Review and confirm page not loaded successfully");
		}
		return false;
	}
	
	public void clickOnReviewAndConfirmCloseWindowButton() {
		Log.info("Trying to close review and confirm window");
		reviewAndConfirmCloseButton.click();
		Log.info("Clicked on close button");
	}
	
	public void clickOnReviewAndConfirmCancelButton() {
		Log.info("Trying to Cancel review and confirm window");
		reviewConfirmCancel.click();
		Log.info("Clicked on cancel button");
	}
	
	public void clickOnReviewAndConfirmConfirmButton() {
		Log.info("Trying to Confirm review and confirm window");
		reviewConfirmConfirm.click();
		Log.info("Clicked on confirm button");
	}
	
	public boolean checkForSuccessMessageWindow() {
		try {
			wait.until(ExpectedConditions.visibilityOf(successMessageWindow));
			Log.info("Success Message window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success Message window not loaded successfully");
		}
		
		return false;
	}
	
	public boolean checkForErrorMessageWindow() {
		try {
			wait.until(ExpectedConditions.visibilityOf(errorMessageWindow));
			Log.info("Error Message window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Error Message window not loaded successfully");
		}
		
		return false;
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on success message window done button");
		doneButton.click();
		Log.info("Clicked on success message window done button");
	}
	
	public void insertSearchValue(String value) {
		Log.info("Trying to inser search Value : "+value);
		searchMessageGateway.sendKeys(value);
		Log.info("Search Value inserted successfully");
	}
	
	public void clickOnEditActionButton() {
		Log.info("Trying to click on Edit Action button");
		wait.until(ExpectedConditions.visibilityOf(editAction)).click();
		Log.info("Clicked on Edit Action button");
	}
	
	public void clickOnDeleteActionButton() {
		Log.info("Trying to click on Delete Action button");
		deleteAction.click();
		Log.info("Clicked on Delete Action button");
	}

	public boolean checkDeleteActionConfirmationprompt() {
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteConfirmationWindow));
			Log.info("Delete confirmation window loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Delete confirmation window not loaded successfully");
		}
		return false;
	}
	
	public void cancelDeleteAction() {
		Log.info("Trying to cancel delete action");
		cancelDelete.click();
		Log.info("Canceled delete action");
	}
	
	public void confirmDeleteAction() {
		Log.info("Trying to confirm delete action");
		confirmDelete.click();
		Log.info("Confirmed delete action");
	}
	
	public void modifyGatewayName(String value) {
		Log.info("Modifying gateway name : "+value);
		gatewayName.clear();
		gatewayName.sendKeys(value);
		Log.info("Modified Gateway name inserted successfully");
	}
	
	public void modifyHostValue(String value) {
		Log.info("Modifying Host Value : "+value);
		hostInput.clear();
		hostInput.sendKeys(value);
		Log.info("Modified Host Value inserted successfully");
	}
	
	public void modifyRequestDetailsPort(String value) {
		Log.info("Modifying Request details port Value : "+value);
		requestDetailsServicePort.clear();
		requestDetailsServicePort.sendKeys(value);
		Log.info("Modified Request details port Value inserted successfully");
	}
	
	public void modifyRequestDetailsloginId(String value) {
		Log.info("Modifying Request details loginId Value : "+value);
		loginIdInput.clear();
		loginIdInput.sendKeys(value);
		Log.info("Modified Request details loginId Value inserted successfully");
	}
	
	public void modifyRequestDetailsPass(String value) {
		Log.info("Modifying Request details password Value : "+value);
		passwordInput.clear();
		passwordInput.sendKeys(value);
		Log.info("Modified Request details password Value inserted successfully");
	}
	
	public void modifyRequestDetailsConfirmPass(String value) {
		Log.info("Modifying Request details confirm password Value : "+value);
		confirmPasswordInput.clear();
		confirmPasswordInput.sendKeys(value);
		Log.info("Modified Request details confirm password Value inserted successfully");
	}
	
	public void modifyRequestDetailsKey(String value) {
		Log.info("Modifying Request details Key Value : "+value);
		keyInput.clear();
		keyInput.sendKeys(value);
		Log.info("Modified Request details Key Value inserted successfully");
	}
	
	public void modifyPushDetailsPort(String value) {
		Log.info("Modifying Push details port Value : "+value);
		pushDetailsPort.clear();
		pushDetailsPort.sendKeys(value);
		Log.info("Modified Push details port Value inserted successfully");
	}
	
	public void modifyPushetDetailsloginId(String value) {
		Log.info("Modifying Push details loginId Value : "+value);
		pushDetailsLoginId.clear();
		pushDetailsLoginId.sendKeys(value);
		Log.info("Modified Push details loginId Value inserted successfully");
	}
	
	public void modifyPushDetailsPass(String value) {
		Log.info("Modifying Push details password Value : "+value);
		pushDetailsPassword.clear();
		pushDetailsPassword.sendKeys(value);
		Log.info("Modified Push details password Value inserted successfully");
	}
	
	public void modifyPushDetailsConfirmPass(String value) {
		Log.info("Modifying Push details confirm password Value : "+value);
		pushDetailsConfirmPassword.clear();
		pushDetailsConfirmPassword.sendKeys(value);
		Log.info("Modified Push details confirm password Value inserted successfully");
	}
	
	public void modifyPushetDetailsDestinationNumber(String value) {
		Log.info("Modifying Push details Destination Number Value : "+value);
		destinationNumberinput.clear();
		destinationNumberinput.sendKeys(value);
		Log.info("Modified Push details Destination Number Value inserted successfully");
	}
	
	public void modifyPushDetailsTimeOut(String value) {
		Log.info("Modifying Push details Time Out Value : "+value);
		timeOutInput.clear();
		timeOutInput.sendKeys(value);
		Log.info("Modified Push details Time Out Value inserted successfully");
	}
	
	public void modifyPushDetailsPath(String value) {
		Log.info("Modifying Push details Path Value : "+value);
		pathInput.clear();
		pathInput.sendKeys(value);
		Log.info("Modified Push details Path Value inserted successfully");
	}
	
	public boolean requestDetailsCheckBoxStatus() {
		Log.info("Checking request details check box status");
		if(requestDetailsCheckBoxStatus.isSelected()) {
			
			Log.info("Request details check box is selected");
			return true;
		}
		Log.info("Request details check box is not selected");
		return false;
	}
	
	public boolean pushDetailsCheckBoxStatus() {
		Log.info("Checking push details check box status");
		if(pushDetailsCheckBoxStatus.isSelected()) {
			
			Log.info("Push details check box is selected");
			return true;
		}
		Log.info("Push details check box is not selected");
		return false;
	}
	

}
