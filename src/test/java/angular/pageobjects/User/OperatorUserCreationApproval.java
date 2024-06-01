package angular.pageobjects.User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;

import jline.internal.Log;

public class OperatorUserCreationApproval extends BaseTest {
	
	//Operator User Link
	@FindBy( xpath = "//a[@href='/operatorUser']")
	private WebElement operatorUserLink;
	
	//Filter
	@FindBy(xpath = "//div[@id='ng-select-box-default']//input//following::span[@class='ng-arrow-wrapper']")
	private WebElement categoryFilterDDArrow;
	
	//Reset Button
	@FindBy(name = "Reset")
	private WebElement resetButton;
	
	//Proceed Button
	@FindBy(name = "Proceed")
	private WebElement proceedButtonOnView;
	
	//Add Single User Button
	@FindBy(id = "single")
	private WebElement addSingleUserButton;
	
	//Add Operator Select Category
	@FindBy(id = "selectCategory")
	private WebElement selectCategoryForAddUser;
	
	//Proceed after starting add user
	@FindBy(id = "proceedBtnId")
	private WebElement proceedAfterAddUser;
	
	//Personal Info Reset Button
	@FindBy(id = "resetPersonalInfo")
	private WebElement personalInfoReset;
	
	//Title Drop Down Arroe
	@FindBy(xpath = "//button[@id='resetPersonalInfo']//following::span[@class='ng-arrow-wrapper']")
	private WebElement titleDropDown;
	
	//First Name Input
	@FindBy(id = "firstName")
	private WebElement firstNameInput;
	
	//Last Name Input
	@FindBy(id = "lastName")
	private WebElement lastNameInput;
	
	//Short Name Input
	@FindBy(id = "shortName")
	private WebElement shortNameInput;
	
	//Mobile Number Input
	@FindBy(id = "mobileNumberHeader")
	private WebElement mobileNumberInput;
	
	//Email Id Input
	@FindBy(id = "emailID")
	private WebElement emailIdInput;
	
	//Subscriber Id Input
	@FindBy(id = "subscriberCode")
	private WebElement subscriberIdInput;
	
	//Geography Details All Network
	@FindBy(xpath = "((((//label[@class='denoTableHeader'])[2])//following::input[1])//following::div[@class='mat-checkbox-frame'])[1]")
	private WebElement networkDetailsCheckAll;
	
	//Division Drop Down Value
	@FindBy(xpath = "//input[@id='division']//following::span[@class='ng-arrow-wrapper']")
	private WebElement divisionDDValue;
	
	//Department Drop Down Value
	@FindBy(xpath = "//input[@id='department']//following::span[@class='ng-arrow-wrapper']")
	private WebElement departmentDDValue;
	
	//Cancel Button on personal details
	@FindBy(id = "cancelPersonalDetails")
	private WebElement personalDetailCancelButton;
	
	//Back Button on personal details
	@FindBy(id = "backPersonalDetails")
	private WebElement personalDetailBackButton;
	
	//Next Button on personal details
	@FindBy(id = "nextPersonalDetails")
	private WebElement personalDetailNextButton;
	
	//Web Login Id Input
	@FindBy(id = "webLoginID")
	private WebElement webLoginIdInput;
	
	//Web Password Input
	@FindBy(id = "password")
	private WebElement webPasswordInput;
	
	//Confirm Web Password Input
	@FindBy(id = "confirmPassword")
	private WebElement confirmWebPassword;
	
	
	//Web Login Cancel Button
	@FindBy(id = "cancelLoginbtn")
	private WebElement loginIdCancelButton;
	
	//Web Login Back Button
	@FindBy(id = "backLoginbtn")
	private WebElement loginIdBackButton;
	
	//Web Login Next Button
	@FindBy(id = "nextLoginbtn")
	private WebElement loginIdNextButton;
	
	//Role Type -- System Role
	@FindBy(id = "systemRoleBtnId")
	private WebElement systemRoleButton;
	
	//Select All System Role
	@FindBy(xpath = "((//button[@id='systemRoleBtnId']//following::input[1])//following::div[@class='mat-checkbox-frame'])[1]")
	private WebElement selectAllSystemRole;
	
	//Role Type -- Group Role
	@FindBy(id = "groupRoleBtnId")
	private WebElement groupRoleButton;
	
	//Group Role Radio Button
	@FindBy(xpath = "//div[@class='mat-radio-outer-circle']")
	private WebElement groupRoleRadioButton;
	
	//Next Roles Button
	@FindBy(id = "nextRolesbtn")
	private WebElement rolesPageNextButton;
	
	//Back Roles Button
	@FindBy(id = "backRolesbtn")
	private WebElement rolesPageBackButton;
	
	//Cancel Roles Button
	@FindBy(id = "cancelRolesbtn")
	private WebElement rolesPageCancelButton;
	
	//Service and Other Info Select All
	@FindBy(xpath = "(//button[@id='resetServicesInfo']//following::input[@type='checkbox']//following::div[@class='mat-checkbox-frame'])[1]")
	private WebElement serviceInfoAllSelect;
	
	//Service Info Cancel Button
	@FindBy(id = "cancelServicesbtn")
	private WebElement serviceInfoCancel;
	
	//Service Info Back Button
	@FindBy(id = "backServicesbtn")
	private WebElement serviceInfoBack;
	
	//Service Info save and review
	@FindBy(id = "saveAndReview")
	private WebElement serviceInfoSaveReview;
	
	//Service Info save and submit
	@FindBy(id = "saveAndSubmitBtn")
	private WebElement serviceInfoSaveButton;
	
	//Final Service Info
	@FindBy(id = "responseMsg")
	private WebElement responseMessage;
	
	//Done button on response message
	@FindBy(id = "doneBtn")
	private WebElement doneResponseButton;
	
	/*----- Approval Page -----*/
	
	//Approval Link
	@FindBy(xpath = "(//a[@href='/operatorUser/approve'])[1]")
	private WebElement approvalLink;
	
	//Login Id Filter Button
	@FindBy(xpath = "(//button[@value='loginDetails'])[1]")
	private WebDriver loginIdFilterButton;
	
	//Login Id Input Value
	@FindBy(id = "name")
	private WebElement inputFieldInputFilter;
	
	//Approval Reset
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement aprroveResetButton;
	
	//Approval Submit
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement approveSubmitButton;
	
	
	
	
	/*----- WebDriver Declaration -----*/
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public OperatorUserCreationApproval(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	/*---- Basic Function ----*/
	
	public boolean visibilityOfOperatorUserLink() {
		
		Log.info("Check visibility of Operator User Link");
		
		try {
			
			wait.until(ExpectedConditions.visibilityOf(operatorUserLink));
			Log.info("Operator User Creation Link is ");
			return true;
		}catch(Exception e) {
			
			Log.info("Operator User Creation Link Not Found");
			return false;
		}
	}
	
	public void clickOnOperatorUserLink() {
		
		Log.info("Trying to click on Operator User Link");
		wait.until(ExpectedConditions.visibilityOf(operatorUserLink)).click();
		Log.info("Clicked on Operator User Link");
	}
	
	public boolean visibilityOfSingleUserCreationLink() {
		Log.info("Checking visibility of single user creation link");
		
		try {
			wait.until(ExpectedConditions.visibilityOf(addSingleUserButton));
			Log.info("Single User Creation Button Is Visible");
			return true;
		}catch(Exception e) {
			Log.info("Single user creation button is not visible");
			return false;
		}
	}
	
	public void clickOnSingleUserCreationButton() {
		
		Log.info("Trying to click on Single User Creation Button");
		wait.until(ExpectedConditions.visibilityOf(addSingleUserButton)).click();
		Log.info("Clicked on Single User Creation Button");
	}
	
	public boolean visibilityOfAddUserCategory() {
		
		Log.info("Checking visibilty of add user category");		
		try {
			wait.until(ExpectedConditions.visibilityOf(selectCategoryForAddUser));
			Log.info("User category selection is available");
			return true;
		}catch(Exception e) {
			Log.info("User category selection is not available");
			return false;
		}
	}
	
	public void clickOnCategorySelection() {
		Log.info("Trying to click on category selection drop down");
		wait.until(ExpectedConditions.visibilityOf(selectCategoryForAddUser)).click();
		Log.info("Clicked on category selection drop down");
	}
	
	public void clickOnSelectCategoryProceed() {
		Log.info("Trying to click on proceed button after selecting category");
		wait.until(ExpectedConditions.visibilityOf(proceedAfterAddUser)).click();
		Log.info("Clicked on proceed button after selecting category");
	}
	
	public boolean visibilityOfPersonalDetailsPage() {
		Log.info("Checking of visibility personal details");
		try {
			wait.until(ExpectedConditions.visibilityOf(titleDropDown));
			Log.info("Personal details page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Personal details page is not loading");
			return false;
		}
	}
	
	public void clickOnTitleDropDownButton() {
		Log.info("Trying to click on title drop down button");
		wait.until(ExpectedConditions.visibilityOf(titleDropDown)).click();
		Log.info("Clicked on title drop down button");
	}
	
	public void inputFirstName(String firstName) {
		Log.info("Trying to input first name");
		wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
		Log.info("Input first name : "+firstName);
	}
	
	public void inputShortName(String shortName) {
		Log.info("Trying to input Short Name for user");
		wait.until(ExpectedConditions.visibilityOf(shortNameInput)).sendKeys(shortName);
		Log.info("Input short name : "+shortName);
	}
	
	public void inputMobileNumber(String mobileNumber) {
		Log.info("Trying to input mobile number");
		wait.until(ExpectedConditions.visibilityOf(mobileNumberInput)).sendKeys(mobileNumber);
		Log.info("Input mobile number : "+mobileNumber);
	}
	
	public void inputEmailId(String emailId) {
		Log.info("Trying to input email id");
		wait.until(ExpectedConditions.visibilityOf(emailIdInput)).sendKeys(emailId);
		Log.info("Input email Id : "+emailId);
	}
	
	public void clickOnDivisionDropDown() {
		Log.info("Trying to click on Division Drop Down");
		wait.until(ExpectedConditions.visibilityOf(divisionDDValue)).click();
		Log.info("Clicked on Division Drop Down ");
	}
	
	public void clickOnDepartmentDropDown() {
		Log.info("Trying to click on Department Drop Down");
		wait.until(ExpectedConditions.visibilityOf(departmentDDValue));
		Log.info("Clicked on Department Drop Down");
	}
	
	public void inputSubscriberCode(String subscriberCode) {
		Log.info("Trying to input subscriber code");
		wait.until(ExpectedConditions.visibilityOf(subscriberIdInput)).sendKeys(subscriberCode);
		Log.info("Input Subscriber Code : "+subscriberCode);
	}
	
	public void selectNetworkDetailsAll() {
		Log.info("Trying to select network details as all");
		wait.until(ExpectedConditions.visibilityOf(networkDetailsCheckAll)).click();
		if(networkDetailsCheckAll.isSelected()) {
			Log.info("Network details is selected as all");
		}else {
			Log.info("Network details is not selected as all");
		}
	}
	
	public void clickOnNextForPersonalDetails() {
		Log.info("Trying to click next button personal details");
		wait.until(ExpectedConditions.visibilityOf(personalDetailNextButton)).click();
		Log.info("Clicked on next button of personal details");
	}
	
	public boolean visibilityOfWebLogInId() {
		Log.info("Checking for visibility of Web Login Detail page");
		try {
			wait.until(ExpectedConditions.visibilityOf(webLoginIdInput));
			Log.info("Web Login Details page is visible");
			return true;
		}catch(Exception e) {
			Log.info("Web Login Details page is not loaded");
			return false;
		}
	}
	
	public void inputWebLoginId(String webLoginId) {
		Log.info("Trying to input web login Id");
		wait.until(ExpectedConditions.visibilityOf(webLoginIdInput)).sendKeys(webLoginId);
		Log.info("Input web login id : "+webLoginId);
		
	}
	
	public void inputWebPasswordAndConfirmPassword(String password) {
		Log.info("Trying to input web password");
		wait.until(ExpectedConditions.visibilityOf(webPasswordInput)).sendKeys(password);
		Log.info("Input web password : "+password);
		Log.info("Trying to input confirm web password");
		wait.until(ExpectedConditions.visibilityOf(confirmWebPassword)).sendKeys(password);
		Log.info("Confirm password input : "+password);
	}
	
	public void clickOnWebLoginNextButton() {
		Log.info("Trying to click on Web Login Next button");
		wait.until(ExpectedConditions.visibilityOf(loginIdNextButton)).click();
		Log.info("Clicked on web login next button");
	}
	
	public boolean visibilityOfRoleTypePage() {
		Log.info("Checking for visibility of role type page");
		try {
			wait.until(ExpectedConditions.visibilityOf(rolesPageBackButton));
			Log.info("Role type page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Role type page is not loaded");
			return false;
		}
	}

	public void clickOnSystemRoleButton() {
		Log.info("Trying to click on System Role Button");
		wait.until(ExpectedConditions.visibilityOf(systemRoleButton)).click();
		Log.info("Clicked System Role button");
	}
	
	public void selectAllSystemRole() {
		Log.info("Trying to select all system role type");
		wait.until(ExpectedConditions.visibilityOf(selectAllSystemRole)).click();
		Log.info("Selected system role as all");
	}
	
	public void selectGroupRoleButton() {
		Log.info("Trying to select group role button");
		wait.until(ExpectedConditions.visibilityOf(groupRoleButton)).click();
		Log.info("Selected group role button");
	}
	
	public void selectAllGroupNameButton() {
		Log.info("Trying to select all group name");
		wait.until(ExpectedConditions.visibilityOf(groupRoleRadioButton)).click();
		Log.info("Selected group name");
	}
	
	public void clickOnRoleTypeNextButton() {
		Log.info("Trying to click on role type next button");
		wait.until(ExpectedConditions.visibilityOf(rolesPageNextButton)).click();
		Log.info("Clicked on role type next button");
	}
	
	public boolean visibilityOfServiceOtherInformation() {
		Log.info("Checking for visibility of Service and Other Information");
		try {
			wait.until(ExpectedConditions.visibilityOf(serviceInfoSaveButton));
			Log.info("Service and Other information page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Service and other information page is not loaded successfully");
			return false;
		}
	}
	
	public void clickOnSelectAllServices() {
		Log.info("Trying to select all service and other information button");
		wait.until(ExpectedConditions.visibilityOf(serviceInfoAllSelect)).click();
		Log.info("Clicked on select all button of service and other information");
	}
	
	public void clickOnServiceOtherInfoSaveButton() {
		Log.info("Trying to click on save and submit button");
		wait.until(ExpectedConditions.visibilityOf(serviceInfoSaveButton)).click();
		Log.info("Cliked on save and submit button");
	}
}
