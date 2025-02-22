package angular.pageobjects.TranferRule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class PromotinalTransferRule_PageObject extends BaseTest {

	@FindBy(xpath = "//a[@href='/pretups-ui/promotional']")
	private WebElement promotional;

	@FindBy(xpath = "(//button[@id='toggle-1-button'])[1]")
	private WebElement singleOperation;

	@FindBy(xpath = "(//button[@id='toggle-1-button'])[2]")
	private WebElement bulkOperation;

	@FindBy(xpath = "//button[@value='User']")
	private WebElement searchByUserButton;

	@FindBy(xpath = "//button[@value='Grade']")
	private WebElement searchByGradeButton;

	@FindBy(xpath = "//button[@value='Geography']")
	private WebElement searchByGeographyButton;

	@FindBy(xpath = "//button[@value='Category']")
	private WebElement searchByCategoryButton;

	@FindBy(xpath = "//button[contains(@value,'Cell')]")
	private WebElement searchByCellGroupButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement domainDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement categoryDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement geographicalDomainTypeDDButton;

	@FindBy(xpath = "(//label[@for='domain']//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement geographyDDButton;

	@FindBy(name = "search")
	private WebElement userSearchInput;

	@FindBy(xpath = "//img[@src='assets/images/search_icon/magnifying-glass.png']")
	private WebElement searchButton;

	@FindBy(name = "Reset")
	private WebElement resetButton;

	@FindBy(name = "Proceed")
	private WebElement proceedButton;

	@FindBy(xpath = "//div[contains(text(),'PROMOTIONAL TRANSFER DETAILS')]//following-sibling::div")
	private WebElement addPromotionalTransferRuleButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement promotionalLevelDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement domainAddDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement categoryAddDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement geographicalDomainTypeAddDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[5]")
	private WebElement geographyAddDDButton;

	@FindBy(name = "search")
	private WebElement userSearchInputAdd;

	@FindBy(xpath = "//h4[@id='modal-basic-title']")
	private WebElement PopUpHeading;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement submitButton;

	@FindBy(xpath = "//img[@src='assets/images/search_icon/magnifying-glass.png']")
	private WebElement searchButtonAdd;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[6]")
	private WebElement receiverDetailsTypeDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[7]")
	private WebElement receiverDetailsServiceClassDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[8]")
	private WebElement receiverDetailsSubscriberStatusDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[9]")
	private WebElement serviceProviderGroupDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[10]")
	private WebElement statusDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[11]")
	private WebElement serviceTypeDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[12]")
	private WebElement subServiceTypeDDButton;

	@FindBy(xpath = "(//label[@for='level']//following::span[@class='ng-arrow-wrapper'])[13]")
	private WebElement cardGroupSetDDButton;

	@FindBy(id = "confirmButton")
	private WebElement confirmButton;

	@FindBy(xpath = "//img[contains(@src,'close_icon')]")
	private WebElement closeIconButton;

	@FindBy(xpath = "//div[@class='success']")
	private WebElement successIcon;

	@FindBy(id = "anotherRecharge")
	private WebElement doneButton;

	@FindBy(xpath = "(//img[@src='assets/images/edit_icon/Editicon.png'])[2]")
	private WebElement editIcon;

	@FindBy(xpath = "(//img[@src='assets/images/delete_icon/png/delete.png'])[2]")
	private WebElement deleteIcon;

	@FindBy(xpath = "(//td//following::span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement modifyStatusDDButon;

	@FindBy(xpath = "(//td//following::span[contains(@class,'ng-arrow-wrapper')])[2]")
	private WebElement modifyCardGroupSetDDButton;

	@FindBy(xpath = "//div[contains(@class,'modal-body')]//div//label")
	private WebElement confirmationScreenWindowMessage;

	@FindBy(id = "rejectConfirmNo")
	private WebElement rejectConfirmation;

	@FindBy(id = "rejectConfirmYes")
	private WebElement acceptConfirmation;
	
	//Bulk Promotinal Level
	@FindBy(xpath = "//label[@for='domain']//following::span[@class='ng-arrow-wrapper']")
	private WebElement bulkPromotionalLevelDD;
	
	@FindBy(xpath = "//label[contains(@class, 'download')]")
	private WebElement downloadBulkTemplate;
	
	@FindBy(xpath = "//label[@for = 'file'][contains(@class, 'company-copy')]")
	private WebElement chooseFile;
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[4]")
	private WebElement resetBulk;
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[5]")
	private WebElement submitBulk;
	
	@FindBy(xpath = "(//span[@class = 'mat-button-wrapper'])[3]")
	private WebElement ConfirmBulk;
	
	@FindBy(xpath = "(//input[@id='level']//following::span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement clickPromotionalLevel;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')])[1]")
	private WebElement selectUserPromotionalLevel;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')])[2]")
	private WebElement selectGradePromotionalLevel;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')])[3]")
	private WebElement selectGeographyPromotionalLevel;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')])[4]")
	private WebElement selectCategoryPromotionalLevel;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')])[5]")
	private WebElement selectCellGroupPromotionalLevel;
	
	@FindBy(xpath = "(//span[@class = 'ng-arrow-wrapper'])[4]")
	private WebElement DomainDD;
	
	@FindBy(xpath = "(//span[@class = 'ng-arrow-wrapper'])[5]")
	private WebElement CategoryDD;
	
	@FindBy(xpath = "(//span[@class = 'ng-arrow-wrapper'])[6]")
	private WebElement GeographicalDomainDD;
	
	@FindBy(xpath = "(//span[@class = 'ng-arrow-wrapper'])[4]")
	private WebElement CellGroupDD;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Distributor')])")
	private WebElement DistributorDomain;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'P-Domain')])")
	private WebElement PDomain;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Super Distributor')])")
	private WebElement SuperDistributorCategory;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Dealer')])")
	private WebElement DealerCategory;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Agent')])")
	private WebElement AgentCategory;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Retailer')])")
	private WebElement RetailerCategory;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'P-category')])")
	private WebElement PCategory;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Zone')])")
	private WebElement ZoneGeographicalDomain;
	
	@FindBy(xpath = "")
	private WebElement AreaGeographicalDomain;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Sub Area')])")
	private WebElement SubAreaGeographicalDomain;
	
	@FindBy(xpath = "(//span[contains(@class, 'ng-option-label')][contains(text(),'Docomo Tower')])")
	private WebElement DocomoTowerCellGroup;
	
	@FindBy(xpath = "(//img[@class = 'ng-tns-c21-12'])[3]")
	private WebElement cancelBulk;
	
	@FindBy(xpath = "(//button[@class = 'ng-tns-c21-12'])")
	private WebElement viewErrorLog;
	
	@FindBy(xpath = "(//span[@class =  'mat-button-wrapper'])[3]")
	private WebElement Done;


	/* ----- WebDriver Declaration ----- */

	WebDriver driver = null;
	WebDriverWait wait = null;
	C2SAddModifyDeleteTransferRule transPo;

	public PromotinalTransferRule_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		transPo = new C2SAddModifyDeleteTransferRule(driver);
	}

	/* ----- Basic Function ------ */

	public void clickOnSingleOption() {
		Log.info("Trying to click on single option");
		wait.until(ExpectedConditions.visibilityOf(singleOperation)).click();
		Log.info("Clicked on Single Operation");
	}

	public void selectFilterValue(String value) {

		Log.info("Trying to select Filter value : " + value);

		switch (value) {
		case "User":
			searchByUserButton.click();
			break;

		case "Grade":
			searchByGradeButton.click();
			break;

		case "Geography":
			searchByGeographyButton.click();
			break;

		case "Category":
			searchByCategoryButton.click();
			break;

		case "Cell Group":
			searchByCellGroupButton.click();
			break;

		default:
			Log.info("Please send the correct Filter for Search By, shared value is incorrect : " + value);
			break;
		}
	}

	public void clickOnProceedButton() {
		Log.info("Trying to click on Proceed Button");
		proceedButton.click();
		Log.info("Clicked on Proceed Button");
	}
	
	public void clickOnResetButton() {
		Log.info("Trying to click on Reset Button");
		resetButton.click();
		Log.info("Clicked on Reset Button");
	}

	public boolean checkVisibilityChildMenu() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'expand')]")));
			return true;
		} catch (Exception e) {
			Log.info("Child menu is not visible");
		}

		return false;
	}

	public void clickOnPromotionalTransferRuleLink() {
		if (checkVisibilityChildMenu()) {
			promotional.click();
		} else {
			transPo.clickOnTransferRuleLink();
			wait.until(ExpectedConditions.visibilityOf(promotional)).click();
		}
	}

	public boolean checkPromotionalTransferRulePageLoadedSuccessFully() {

		Log.info("Checking if promotional transfer rule page is loaded successfully");

		try {
			wait.until(ExpectedConditions.visibilityOf(singleOperation));
			wait.until(ExpectedConditions.visibilityOf(bulkOperation));
			wait.until(ExpectedConditions.visibilityOf(searchByUserButton));
			wait.until(ExpectedConditions.visibilityOf(searchByGradeButton));
			wait.until(ExpectedConditions.visibilityOf(searchByGeographyButton));
			wait.until(ExpectedConditions.visibilityOf(searchByCategoryButton));
			wait.until(ExpectedConditions.visibilityOf(searchByCellGroupButton));
			wait.until(ExpectedConditions.visibilityOf(domainDDButton));
			wait.until(ExpectedConditions.visibilityOf(categoryDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographicalDomainTypeDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographyDDButton));
			wait.until(ExpectedConditions.visibilityOf(userSearchInput));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(proceedButton));
			wait.until(ExpectedConditions.visibilityOf(addPromotionalTransferRuleButton));
			Log.info("Promotional Transfer Rule page is loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Promotional Transfer Rule page not loaded successfully");
		}

		return false;
	}

	public void clickOnDomainDDButton() {
		domainDDButton.click();
		Log.info("Clicked on domain DD button");
	}

	public void clickOnCategoryDDButton() {
		categoryDDButton.click();
		Log.info("Clicked on category DD button");
	}

	public void clickOnGeographicalDomainTypeDDButton() {
		geographicalDomainTypeDDButton.click();
		Log.info("Clicked on Geographical Domain Type DD button");
	}

	public void clickOnGeographyDDButton() {
		geographyDDButton.click();
		Log.info("Clicked on Geography DD button");
	}

	public void clickOnAddPromotionalTransferDetails() {
		Log.info("Trying to click on Add Promotional Transfer Details Button");
		// addPromotionalTransferRuleButton.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addPromotionalTransferRuleButton);
		Log.info("Clicked on ADD Promotional Transfer Details Button");
	}

	public boolean checkVisibilityOfAddPromotionalTransferRuleDetailsPageLoadedSuccessfully() {

		Log.info("Checing if Add Promotional Transfer Rule Details Page loaded successfully");

		try {
			wait.until(ExpectedConditions.visibilityOf(promotionalLevelDDButton));
			wait.until(ExpectedConditions.visibilityOf(domainAddDDButton));
			wait.until(ExpectedConditions.visibilityOf(categoryAddDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographicalDomainTypeAddDDButton));
			wait.until(ExpectedConditions.visibilityOf(geographyAddDDButton));
			wait.until(ExpectedConditions.visibilityOf(userSearchInputAdd));
			wait.until(ExpectedConditions.visibilityOf(receiverDetailsTypeDDButton));
			wait.until(ExpectedConditions.visibilityOf(receiverDetailsServiceClassDDButton));
			wait.until(ExpectedConditions.visibilityOf(receiverDetailsSubscriberStatusDDButton));
			wait.until(ExpectedConditions.visibilityOf(serviceProviderGroupDDButton));
			wait.until(ExpectedConditions.visibilityOf(statusDDButton));
			wait.until(ExpectedConditions.visibilityOf(serviceTypeDDButton));
			wait.until(ExpectedConditions.visibilityOf(subServiceTypeDDButton));
			wait.until(ExpectedConditions.visibilityOf(cardGroupSetDDButton));
			Log.info("Add Promotional Transfer Rule Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Add Promotional Transfer Rule Page not Loaded Successfully");
		}

		return false;
	}

	public void clickOnPromotionalLevelDD() {
		Log.info("Trying to click on promotional level DD button");
		promotionalLevelDDButton.click();
		Log.info("Clicked on promotional level DD button");
	}

	public void clickOnAddDomainDD() {
		Log.info("Trying to click on Domain DD button");
		domainAddDDButton.click();
		Log.info("Clicked on Domain DD button");
	}

	public void clickOnAddCategoryDD() {
		Log.info("Trying to click on Category DD button");
		categoryAddDDButton.click();
		Log.info("Clicked on Category DD button");
	}

	public void clickOnAddGeographicalDomainTypeDD() {
		Log.info("Trying to click on Geographical Domain Type DD button");
		geographicalDomainTypeAddDDButton.click();
		Log.info("Clicked on Geographical Domain Type DD button");
	}

	public void clickOnGeographyDD() {
		Log.info("Trying to click on Geography DD button");
		geographyAddDDButton.click();
		Log.info("Clicked on Geography DD button");
	}

	public void insertUserInSearchField(String value) {
		userSearchInputAdd.sendKeys(value);
		Log.info("Inserted this value for search");
	}

	public void clickOnSearchIcon() {
		searchButtonAdd.click();
		Log.info("Clicked on search icon");
	}

	public String checkSearchUserList() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String user = null;

		WebElement userList = driver.findElement(By.xpath("//h4//following::li[contains(@class,'ng-tns')][1]"));
		wait.until(ExpectedConditions.visibilityOf(userList));

		user = userList.getText();

		userList.click();

		Log.info("Selected User from search list" + user);

		return user;
	}

	public void clickOnSubmitUserButton() {
		submitButton.click();
		Log.info("Clicked on submit button from user search list");
	}

	public void clickOnReceiverDetailsTypeDD() {
		Log.info("Trying to click on Receiver Details Type DD button");
		receiverDetailsTypeDDButton.click();
		Log.info("Clicked on Receiver Details Type DD button");
	}

	public void clickOnReceiverDetailsServiceClassDD() {
		Log.info("Trying to click on Receiver Details Service Class DD button");
		receiverDetailsServiceClassDDButton.click();
		Log.info("Clicked on Receiver Details Service Class DD button");
	}

	public void clickOnReceiverDetailsSubscriberStatusDD() {
		Log.info("Trying to click on Receiver Details Subscriber Status DD button");
		receiverDetailsSubscriberStatusDDButton.click();
		Log.info("Clicked on Receiver Details Subscriber Status DD button");
	}

	public void clickOnServiceProviderGroupDD() {
		Log.info("Trying to click on Service Provider Group DD button");
		serviceProviderGroupDDButton.click();
		Log.info("Clicked on Service Provider Group DD button");
	}

	public void clickOnCardGroupSetStatusDD() {
		Log.info("Trying to click on Card Group Set Status DD button");
		statusDDButton.click();
		Log.info("Clicked on Card Group Set Status DD button");
	}

	public void clickOnServiceTypeDD() {
		Log.info("Trying to click on Service Type DD button");
		serviceTypeDDButton.click();
		Log.info("Clicked on Service Type DD button");
	}

	public void clickOnSubServiceDD() {
		Log.info("Trying to click on Sub Service DD button");
		subServiceTypeDDButton.click();
		Log.info("Clicked on Sub Service DD button");
	}

	public void clickOnCardGroupSetDD() {
		Log.info("Trying to click on Sub Service DD button");
		cardGroupSetDDButton.click();
		Log.info("Clicked on Card Group Set DD button");
	}

	public void clickOnSaveRuleButton() {
		Log.info("Trying to click on Save button");
		proceedButton.click();
		Log.info("Clicked on Save button");
	}

	public boolean ReviewAndConfirmPopUpWindow() {

		try {
			wait.until(ExpectedConditions.visibilityOf(PopUpHeading));
			Log.info("Review and Confirm Pop-up window is visible");
			return true;
		} catch (Exception e) {
			Log.info("Review and Confirm Pop-up window is not visible");
		}

		return false;
	}

	public void clickOnConfirmRuleButton() {
		if (ReviewAndConfirmPopUpWindow()) {
			confirmButton.click();
			Log.info("Clicked on confirm button");
		} else {
			Log.info("Review and Confirm Pop-up window is not visible");
		}
	}

	public boolean checkSuccessWindow() {

		try {
			wait.until(ExpectedConditions.visibilityOf(successIcon));
			return true;
		} catch (Exception e) {
			Log.info("Success window not visible");
		}
		return false;
	}

	public void clickOnDoneButton() {
		if (checkSuccessWindow()) {
			doneButton.click();
			Log.info("Confirmed success message by clicking on done button");
		} else {
			Log.info("Unable to click on done button as success window is not visible");
		}
	}

	public boolean checkSearchResultLoadedSuccessfully() {

		try {
			wait.until(ExpectedConditions.visibilityOf(editIcon));
			wait.until(ExpectedConditions.visibilityOf(deleteIcon));
			Log.info("Search Results Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Search Result not loaded");
		}

		return false;
	}

	public void clickOnEditIcon() {

		if (checkSearchResultLoadedSuccessfully()) {
			editIcon.click();
			Log.info("Clicked on edit icon for modification");
		} else {
			Log.info("Unable to initiate modify");
		}

	}

	public void clickOnDeleteIcon() {

		if (checkSearchResultLoadedSuccessfully()) {
			deleteIcon.click();
			Log.info("Clicked on delete icon for modification");
		} else {
			Log.info("Unable to initiate delete");
		}

	}

	public void clickOnModifyStatusDDButton() {
		wait.until(ExpectedConditions.visibilityOf(modifyStatusDDButon)).click();
		Log.info("Clicked on modify status DD Button");
	}

	public void clickOnModifyCardGroupSetDDbutton() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modifyCardGroupSetDDButton);
		wait.until(ExpectedConditions.visibilityOf(modifyCardGroupSetDDButton)).click();
		Log.info("Clicked on modify Card Group Set DD Button");
	}

	public boolean checkConfirmationWindowLoadedSuccessfully() {
		try {
			wait.until(ExpectedConditions.visibilityOf(confirmationScreenWindowMessage));
			wait.until(ExpectedConditions.visibilityOf(rejectConfirmation));
			wait.until(ExpectedConditions.visibilityOf(acceptConfirmation));
			Log.info("Confirmation window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Confirmation window is not launched properly");
		}
		return false;
	}

	public void acceptConfirmation() {
		acceptConfirmation.click();
		Log.info("accepted actions from confirmation window");
	}

	public void rejectConfirmation() {
		rejectConfirmation.click();
		Log.info("Rejected actions from confirmation window");
	}
	
	public void clickOnBulkOperation() {
		Log.info("Trying to click on Bulk Operation");
		bulkOperation.click();
		Log.info("Clicked on bulk operation");
	}
	
	public boolean checkBulkOperationPageLoadedSuccessfully() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(bulkPromotionalLevelDD));
			wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
			Log.info("Bulk Operation Page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Bulk Operation Page not loaded successfully");
		}
		
		return false;
	}
	// Author kajal
	public void clickOnPromotionalLevel() {
		Log.info("Trying to click on promotional level dropdown");
		clickPromotionalLevel.click();
		Log.info("Clicked on promotional level");
	}
	public void selectPromotionalLevel(String value) {
		Log.info("Trying to select value from DD:"+value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'ng-option-label')][contains(text(),'"+value+"')]"))).click();
	}
	
	public boolean checkVisbilityOfUserChildMenu() {
		try {
		wait.until(ExpectedConditions.visibilityOf(DomainDD));
		wait.until(ExpectedConditions.visibilityOf(CategoryDD));
		wait.until(ExpectedConditions.visibilityOf(GeographicalDomainDD));
		wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		wait.until(ExpectedConditions.visibilityOf(resetBulk));
		wait.until(ExpectedConditions.visibilityOf(submitBulk));
		Log.info("User Child menu loaded successfully");
		return true;
		}
		catch(Exception e) {
			Log.info("User child menu not loaded successfully");
		}
		return false;
	}
	public void clickOnDomainDD(String domain) {
		Log.info("Trying to click on DomainDD");
		DomainDD.click();
		Log.info("Clicked on Domain DD");
	}
	public void clickOnCategoryDD(String category) {
		Log.info("Trying to click on Category DD");
		CategoryDD.click();
		Log.info("Clicked on Category DD");
	}
	public void clickOnGeographicalDomainDD(String geographical) {
		Log.info("Trying to click on Geographical domain DD");
		GeographicalDomainDD.click();
		Log.info("Clicked on geogrphical domain DD");
	}
	public void clickOnCellGroupDD(String cellgroup) {
		Log.info("Trying to click on cell group DD");
		CellGroupDD.click();
		Log.info("Clicked on cell group DD");
	}
	public boolean checkVisbilityOfGradeChildMenu() {
		try {
		wait.until(ExpectedConditions.visibilityOf(DomainDD));
		wait.until(ExpectedConditions.visibilityOf(CategoryDD));
		wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		wait.until(ExpectedConditions.visibilityOf(resetBulk));
		wait.until(ExpectedConditions.visibilityOf(submitBulk));
		Log.info("Grade Child menu loaded successfully");
		return true;
		}
		catch(Exception e) {
			Log.info("Grade child menu not loaded successfully");
		}
		return false;
	}
	
	public boolean checkVisbilityOfGeographyChildMenu() {
		try {
		wait.until(ExpectedConditions.visibilityOf(GeographicalDomainDD));
		wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		wait.until(ExpectedConditions.visibilityOf(resetBulk));
		wait.until(ExpectedConditions.visibilityOf(submitBulk));
		Log.info("Geopraphy Child menu loaded successfully");
		return true;
		}
		catch(Exception e) {
			Log.info("Geography child menu not loaded successfully");
		}
		return false;
	}
    
    public boolean checkVisbilityOfCategoryChildMenu() {
		try {
    	wait.until(ExpectedConditions.visibilityOf(DomainDD));
		wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		wait.until(ExpectedConditions.visibilityOf(resetBulk));
		wait.until(ExpectedConditions.visibilityOf(submitBulk));
		Log.info("Category Child menu loaded successfully");
		return true;
		}
		catch(Exception e) {
			Log.info("Category child menu not loaded successfully");
		}
		return false;
	}
    
    public boolean checkVisbilityOfCellGroupChildMenu() {
		try {
    	wait.until(ExpectedConditions.visibilityOf(CellGroupDD));
		wait.until(ExpectedConditions.visibilityOf(downloadBulkTemplate));
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		wait.until(ExpectedConditions.visibilityOf(resetBulk));
		wait.until(ExpectedConditions.visibilityOf(submitBulk));
		Log.info("Cell Group Child menu loaded successfully");
		return true;
		}
		catch(Exception e) {
			Log.info("Cell Group child menu not loaded successfully");
		}
		return false;
	}
    
    public void clickOnBulkSubmitButton() {
		Log.info("Trying to click on Proceed Button");
		submitBulk.click();
		Log.info("Clicked on Proceed Button");
	}
	
	public void clickOnBulkResetButton() {
		Log.info("Trying to click on Reset Button");
		resetBulk.click();
		Log.info("Clicked on Reset Button");
	}
	
	public void clickOnDownloadTemplate() {
		Log.info("Trying to click on download template");
		downloadBulkTemplate.click();
		Log.info("Clicked on download template");
	}
	
	public boolean ReviewAndConfirmBulkPopUpWindow() {

		try {
			wait.until(ExpectedConditions.visibilityOf(PopUpHeading));
			Log.info("Review and Confirm Pop-up window is visible");
			return true;
		} catch (Exception e) {
			Log.info("Review and Confirm Pop-up window is not visible");
		}

		return false;
	}

	public void clickOnConfirmBulk() {
		if (ReviewAndConfirmBulkPopUpWindow()) {
			ConfirmBulk.click();
			Log.info("Clicked on confirm button");
		} else {
			Log.info("Review and Confirm Pop-up window is not visible");
		}
	}
	public boolean checkBulkSuccessWindow() {

		try {
			wait.until(ExpectedConditions.visibilityOf(successIcon));
			return true;
		} catch (Exception e) {
			Log.info("Success window not visible");
		}
		return false;
	}
	public boolean checkBulkUploadAfterFailure() {
		try {
			wait.until(ExpectedConditions.visibilityOf(cancelBulk));
			wait.until(ExpectedConditions.visibilityOf(viewErrorLog));
			wait.until(ExpectedConditions.visibilityOf(Done));
			return true;
			
		}catch (Exception e) {}
		return false;
	}
	public void clickOnViewErrorLog() {	
		 viewErrorLog.click();
		 Log.info("Clicked on view error log");
	}
	
	public void clickOnDone() {
		Done.click();
		Log.info("Clicked on done");
	}
  
}
