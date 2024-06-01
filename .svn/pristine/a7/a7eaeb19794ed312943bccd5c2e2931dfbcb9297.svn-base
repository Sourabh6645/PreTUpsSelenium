package angular.pageobjects.GeographicalDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class GeographicalDomain_PageObject extends BaseTest {

	// geo domain link
	@FindBy(xpath = "//a[@href='/pretups-ui/geo-domain']")
	private WebElement geographicalDomainLink;

	// Network Name
	@FindBy(id = "networkName")
	private WebElement networkNameField;

	// Geographical Domain Type DD
	@FindBy(xpath = "//input[@id='geographicalDomainType']//following::span[@class=\"ng-arrow-wrapper\"]")
	private WebElement geographicalDomainTypeDD;

	// Zone
	@FindBy(xpath = "(//input[@id='geoListArray'])[1]")
	private WebElement zoneInput;

	// Area
	@FindBy(xpath = "(//input[@id='geoListArray'])[2]")
	private WebElement areaInput;

	// Zone Search Icon
	@FindBy(xpath = "(//img[@class='searchUser-staff'])[1]")
	private WebElement zoneSearchIcon;

	// Area Search Icon
	@FindBy(xpath = "(//img[@class='searchUser-staff'])[2]")
	private WebElement areaSearchIcon;
	
	// Pop Submit Button
	@FindBy(xpath = "//h4//following::button[@name='Proceed']//span")
	private WebElement submitButton;

	// Filter Reset Button
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement filterResetButton;

	// Filter Proceed Button
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement filterProceedButton;

	// Filter Result Search
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchFilterInput;

	// Add Button
	@FindBy(xpath = "//button[@id='addButton']//span")
	private WebElement addButton;

	// Geographical Domain Code
	@FindBy(id = "geoCode")
	private WebElement geoCodeInput;

	// Geographical Domain Name
	@FindBy(id = "geoName")
	private WebElement geoNameInput;

	// Geographical Domain Short Name
	@FindBy(id = "geoShortName")
	private WebElement geoShortNameInput;

	// Status DD
	@FindBy(xpath = "//input[@id='status']//following::span[@class='ng-arrow-wrapper']")
	private WebElement statusDDButton;

	// Geo status Active
	@FindBy(xpath = "(//div[contains(@class,'scroll-host')]//span)[1]")
	private WebElement active;

	// Geo status Suspend
	@FindBy(xpath = "(//div[contains(@class,'scroll-host')]//span)[2]")
	private WebElement suspend;

	// Description
	@FindBy(id = "description")
	private WebElement geoDomainDescription;

	// Default Yes
	@FindBy(xpath = "(//div[@class='mat-radio-inner-circle'])[1]")
	private WebElement defaultYesButton;

	// Default No
	@FindBy(xpath = "(//div[@class='mat-radio-inner-circle'])[2]")
	private WebElement defaultNoButton;

	// Success Pop
	@FindBy(xpath = "//div[@class='success1']")
	private WebElement successMessageWindow;

	// Success Message
	@FindBy(xpath = "//div[@class='status-change-successful1']")
	private WebElement successMessage;

	// Done Button
	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement doneButton;

	// Modify Button
	@FindBy(xpath = "(//a[@class='editRecord'])[2]")
	private WebElement modifyButton;

	// Delete Button
	@FindBy(xpath = "(//a[@class='deleteRecord'])[2]")
	private WebElement deleteButton;

	// Delete Confirmation No button
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[1]")
	private WebElement deleteConfirmatioNo;

	// Delete Confirmation Yes button
	@FindBy(xpath = "(//button[@id='doneBtn']//span)[2]")
	private WebElement deleteConfirmatioYes;

	/* ---- Driver Declaration ----- */
	WebDriver driver = null;
	WebDriverWait wait = null;

	public GeographicalDomain_PageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* ---- Basic Function ---- */

	public boolean checkVisibilityOfGeographicalDomain() {
		Log.info("Checking visibility of Geographical Domain Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(geographicalDomainLink));
			Log.info("Geographical Domain link is visible");
			return true;
		} catch (Exception e) {
			Log.info("Geographical Domain link is not visible");
			return false;
		}
	}

	public void clickOnGeographicalDomainLink() {
		if (checkVisibilityOfGeographicalDomain()) {
			Log.info("Trying to click on geographical domain link");
			wait.until(ExpectedConditions.visibilityOf(geographicalDomainLink)).click();
			Log.info("Clicked on geographical domain link");
		} else {
			Log.info("Not clicked on domain link");
		}
	}

	public boolean checkIfGeoDomainManagementPageLoadedSuccessfully() {
		Log.info("Checking if geo domain management page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(networkNameField));
			wait.until(ExpectedConditions.visibilityOf(geographicalDomainTypeDD));
			wait.until(ExpectedConditions.visibilityOf(filterProceedButton));
			wait.until(ExpectedConditions.visibilityOf(filterResetButton));
			Log.info("Geo domain management page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Geo domain management page not loaded successfully");
			return false;
		}
	}

	public void clickOnDomainTypeDD() {
		Log.info("Trying to click on geographical domain type DD");
		wait.until(ExpectedConditions.visibilityOf(geographicalDomainTypeDD)).click();
		Log.info("Clicked on geographical domain type DD");
	}

	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");
		wait.until(ExpectedConditions.visibilityOf(filterResetButton)).click();
		Log.info("Clicked on reset button");
	}

	public void clickOnProceedButton() {
		Log.info("Trying to click on proceed button");
		wait.until(ExpectedConditions.visibilityOf(filterProceedButton)).click();
		Log.info("Clicked on proceed button");
	}

	public void inputSearchField(String value) {
		Log.info("Inserting search value : " + value);
		wait.until(ExpectedConditions.visibilityOf(searchFilterInput));
		searchFilterInput.clear();
		searchFilterInput.sendKeys(value);
	}

	public void clickOnAddButton() {
		Log.info("Trying to clik on add geodomain button");
		wait.until(ExpectedConditions.visibilityOf(addButton)).click();
		Log.info("Clicked on add button");
	}

	public boolean checkAddGeographicalDomainPageLoadedSuccessfully() {
		Log.info("Checking if Add Geographical Domain Page Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(geoCodeInput));
			wait.until(ExpectedConditions.visibilityOf(geoNameInput));
			wait.until(ExpectedConditions.visibilityOf(geoShortNameInput));
			wait.until(ExpectedConditions.visibilityOf(statusDDButton));
			wait.until(ExpectedConditions.visibilityOf(geoDomainDescription));
			wait.until(ExpectedConditions.visibilityOf(defaultYesButton));
			wait.until(ExpectedConditions.visibilityOf(defaultNoButton));
			Log.info("Add geographical domain page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Add geographical domain page not loaded successfully");
			return false;
		}
	}

	public void insertGeoDomainCode(String value) {
		Log.info("Inserting geo domain code : " + value);
		wait.until(ExpectedConditions.visibilityOf(geoCodeInput)).sendKeys(value);
	}

	public void insertGeoDomainName(String value) {
		Log.info("Inserting geo domain name : " + value);
		wait.until(ExpectedConditions.visibilityOf(geoNameInput)).sendKeys(value);
	}

	public void insertGeoDomainShortName(String value) {
		Log.info("Inserting geo domain short name : " + value);
		wait.until(ExpectedConditions.visibilityOf(geoShortNameInput)).sendKeys(value);
	}

	public void clickOnStatusDD() {
		Log.info("Trying to click on status DD");
		wait.until(ExpectedConditions.visibilityOf(statusDDButton)).click();
		Log.info("Clicked on status DD");
	}

	public void selectGeoDomainStatusValue(String value) {

		if (value.equals("ACTIVE")) {
			wait.until(ExpectedConditions.visibilityOf(active)).click();
			Log.info("Selected drop down value as : " + value);
		} else if (value.equals("SUSPEND")) {
			wait.until(ExpectedConditions.visibilityOf(suspend)).click();
			Log.info("Selected drop down value as : " + value);
		} else {
			Log.info("Recieved value for status is incorrect : " + value);
		}
	}

	public void insertGeoDescription(String value) {
		Log.info("Inserting geo description : " + value);
		wait.until(ExpectedConditions.visibilityOf(geoDomainDescription)).sendKeys(value);
	}

	public void setDefaultGeographicalDomain(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(defaultYesButton)).click();
			Log.info("Selected geographical domain default value as YES");
		} else if (value.equals("NO")) {
			wait.until(ExpectedConditions.visibilityOf(defaultNoButton)).click();
			Log.info("Selected geographical domain default value as NO");
		} else {
			Log.info("Recieved value : " + value + " does not match");
		}
	}

	public boolean checkGeoDomainSuccessMessage() {

		Log.info("Check success window popup on geo domain screen");
		try {
			wait.until(ExpectedConditions.visibilityOf(successMessageWindow));
			Log.info("Success window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success window not loaded successfully");
			return false;
		}
	}

	public void clickOnPopUpWindowDoneButton() {
		Log.info("Trying to click on Done button");
		wait.until(ExpectedConditions.visibilityOf(doneButton)).click();
		Log.info("Clicked on done button");
	}

	public boolean checkModifyIconVisibility() {
		Log.info("Checking if modify icon is visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(modifyButton));
			Log.info("Modify icon is visible");
			return true;
		} catch (Exception e) {
			Log.info("Modify icon is not visible");
			return false;
		}
	}

	public void clickOnModifyIcon() {

		if (checkModifyIconVisibility()) {
			modifyButton.click();
			Log.info("Clicked on modify icon");
		} else {
			Log.info("Unable to click modify icon");
		}
	}

	public void checkModifyGeoDomainCodeIsNotEditable() {

		Log.info("Checking if geo domain code is not editable upon proceeding with modify");
		if (!geoCodeInput.isEnabled()) {
			Log.info("Geo domain code is not editable");
		} else {
			Log.info("Geo domain code is still editable");
		}
	}

	public boolean checkDeleteIconVisibility() {
		Log.info("Checking if delete icon is visible");
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteButton));
			Log.info("Delete icon is visible");
			return true;
		} catch (Exception e) {
			Log.info("Delete icon is not visible");
			return false;
		}
	}

	public void clickOnDeleteIcon() {

		if (checkModifyIconVisibility()) {
			deleteButton.click();
			Log.info("Clicked on delete icon");
		} else {
			Log.info("Unable to click delete icon");
		}
	}

	public void deleteConfirmation(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(deleteConfirmatioYes)).click();
			Log.info("Confirmed delete");
		} else {
			wait.until(ExpectedConditions.visibilityOf(deleteConfirmatioNo)).click();
			Log.info("Cancelled delete");
		}
	}
	
	public void inputZoneSearchField(String value) {
		wait.until(ExpectedConditions.visibilityOf(zoneInput)).sendKeys(value);
		Log.info("Inserted zone value as : "+value);
		wait.until(ExpectedConditions.visibilityOf(zoneSearchIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal-title']//following::li"))).click();
		wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
		Log.info("Zone value selected successfully");
	}
	
	public void inputAreaSearchField(String value) {
		wait.until(ExpectedConditions.visibilityOf(areaInput)).sendKeys(value);
		Log.info("Inserted area value as : "+value);
		wait.until(ExpectedConditions.visibilityOf(areaSearchIcon)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal-title']//following::li"))).click();
		wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
		Log.info("Area value selected successfully");
	}
	

}
