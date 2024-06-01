package angular.pageobjects.Preferances;

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
import com.utils.ReusableMethods;


public class NetworkServiceControlPreferancesPage extends BaseTest {
	
	/* ---- WebElement For Network Service and Control Preferance Page ---- */
	
	//Preferences Side Pane Link
	@FindBy(xpath = "(//a[@href='/pretups-ui/nw-preference'])[1]")
	private WebElement preferancesLink;
	
	// Network Preferences Link
	@FindBy(xpath = "(//a[@href='/pretups-ui/nw-preference'])[2]")
	private WebElement networkPrefrancesLink;
	
	//Service Preference Link
	@FindBy(xpath = "//a[@href='/pretups-ui/sc-preference']")
	private WebElement servicePreferenceLink;
	
	//Control Preference Link
	@FindBy(xpath = "//a[@href='/pretups-ui/ctrl-preference']")
	private WebElement controlPreferenceLink;
	
	//search bar from network preference
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBarNetworkPreference;
	
	// Select button for entries per page
	@FindBy(xpath = "//div[@id='parentTable_length']//select")
	private WebElement showEntriesButton;
	
	// Select max for display entries
	@FindBy(xpath = "//option[@value='100']")
	private WebElement selectMaxDisplayOption;
	
	// Service Class Dropdown
	@FindBy(xpath = "//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper']")
	private WebElement serviceClassDropDown;
	
	// Control Preference Module Dropdown
	@FindBy(xpath = "(//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement contPrefModuleDD;
	
	// Control Preference Module Control Type Dropdown
	@FindBy(xpath = "(//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement contPrefTypeDD;
	
	// Control Preferences - Preferences Dropdown
	@FindBy(xpath = "(//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement contPrefDD;
	
	//Reset Button
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetButton;
	
	//Proceed Button
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement proceedButton;
	
	//Done Button
	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement doneButton;
	
	//Confirm Button
	@FindBy(xpath = "//button[@id='confirm']//span")
	private WebElement confirmButton;
	
	//Cancel Button
	@FindBy(xpath = "//button[@id='confirm']//preceding-sibling::button//span")
	private WebElement cancelmButton;
	
	
	
	
	/*----- WebDriver Declaration -----*/
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	
	public NetworkServiceControlPreferancesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	/*---- Basic Function ----*/
	
	public boolean visibiltyOfPreferenceLink() {
		try {
			wait.until(ExpectedConditions.visibilityOf(preferancesLink));
			Log.info("Preferances Link is available on UI");
			return true;
		}catch(Exception e) {
			Log.info("Preferances Link is not available on UI");
			return false;
		}
	}
	
	public WebElement getPreferenceLink() {
		return preferancesLink;
	}
	
	public void clickPreferencesLink() {
		Log.info("Trying to click on preferences link");
		wait.until(ExpectedConditions.visibilityOf(preferancesLink)).click();
		Log.info("Clicked on preferance link");
	}
	
	public boolean visibilityOfNetworkPreference() {
		Log.info("Checking for Network Preferance link is visibility");
		try {
			wait.until(ExpectedConditions.visibilityOf(networkPrefrancesLink));
			Log.info("Network Preferance link is visible");
			return true;
		}catch(Exception e) {
			Log.info("Network Preference link not found");
			return false;
		}
	}
	
	public void clickOnNetworkPreferences() {
		Log.info("Trying to click on network preferences link");
		wait.until(ExpectedConditions.visibilityOf(networkPrefrancesLink)).click();
		Log.info("Clicked on network preferences link");
	}
	
	public boolean visibilityOfServiceClassPreferences() {
		Log.info("Checking for visibility of Service Class Preferences Link");
		try {
				wait.until(ExpectedConditions.visibilityOf(servicePreferenceLink));
				Log.info("Service Class Preference Link is visible");
				return true;
		}catch(Exception e) {
			Log.info("Service Class Preference Link is not visible");
			return false;
		}
	}
	
	public void clickOnServiceClassPreferenceLink() {
		Log.info("Trying to click on Service Class Preference Link");
		wait.until(ExpectedConditions.visibilityOf(servicePreferenceLink)).click();
		Log.info("Clicked on Service Class Preference Link");
	}
	
	
	public boolean networkPrefernceLinkLoadedSuccessfully() {
		Log.info("Check if Network Prefernce Page is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchBarNetworkPreference));
			wait.until(ExpectedConditions.visibilityOf(showEntriesButton));
			Log.info("Network preferences page loaded successfully");
			return true;
		}catch (Exception e) {
			Log.info("Network Preferences page is not loaded successfully");
			return false;
		}
	}
	
	public void selectShowMaxEntriesOnPage() {
		Log.info("Trying to select 100 entries per page");
		wait.until(ExpectedConditions.visibilityOf(showEntriesButton)).click();
		wait.until(ExpectedConditions.visibilityOf(selectMaxDisplayOption)).click();
		Log.info("Selected 100 entries per page");
	}
	
	public boolean serviceClassPreferencesPageLoadedSuccessfully() {
		Log.info("Checking if Service Class Preferences");
		try {
			wait.until(ExpectedConditions.visibilityOf(serviceClassDropDown));
			Log.info("Service Class Prefernces Page Loaded Successfully");
			return true;
		}catch(Exception e) {
			Log.info("Service Class Preferences page not loaded successfully");
			return false;
		}
	}
	
	public void clickOnServiceClassDropDown() {
		
		Log.info("Trying to click on service class drop down");
		wait.until(ExpectedConditions.visibilityOf(serviceClassDropDown)).click();
		Log.info("Clicked on service class drop down");
	}
	
	public boolean checkVisibilityOfContrlPreferencesLink() {
		Log.info("Checking for visibility of Control Preferences Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(controlPreferenceLink));
			Log.info("Control Preference Link is visible");
			return true;
		}catch(Exception e) {
			Log.info("Control Preference Link is not visible");
			return false;
		}
	}
	
	public void clickonControlPreferencesLink() {
		Log.info("Trying to click on Control Preference Link");
		wait.until(ExpectedConditions.visibilityOf(controlPreferenceLink)).click();
		Log.info("Clicked on Control Preference Link");
	}
	
	public boolean controlPreferencePageLoadedSuccessfully() {
		Log.info("Checking if Control Preferences Page is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(contPrefDD));
			Log.info("Control Preferences Page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Control Preferences Page is not loaded successfully");
			return false;
		}
	}
	
	public void clickOnProceedButton() {
		Log.info("Trying to click on proceed button");
		wait.until(ExpectedConditions.visibilityOf(proceedButton)).click();;
		Log.info("Clicked on Proceed button successfully");
	}
	
	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");
		wait.until(ExpectedConditions.visibilityOf(resetButton));
		Log.info("Reset executed successfully");
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on done button");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doneButton);
		wait.until(ExpectedConditions.visibilityOf(doneButton)).click();;
		Log.info("Clicked on done button successfully");
	}
	
	public void clickOnConfirmButton() {
		Log.info("Trying to click on confirm button");
		wait.until(ExpectedConditions.visibilityOf(confirmButton)).click();
		Log.info("Clicked on confirm button");
	}
	
	
	public void clickOnCancelButton() {
		Log.info("Trying to click on cancel button");
		wait.until(ExpectedConditions.visibilityOf(cancelmButton)).click();
		Log.info("Clicked on cancel button");
	}
	
	public boolean 	preferencesLoadedSuccessfullyAfterProceed() {
		try {
			
			wait.until(ExpectedConditions.visibilityOf(searchBarNetworkPreference));
			Log.info("After proceeding with selection preferences loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("After proceding no preferences loaded");
			return false;
		}
	}
	
	public void clickOnControlModuleDD() {
		Log.info("Trying to click on module drop down");
		wait.until(ExpectedConditions.visibilityOf(contPrefModuleDD));
		Log.info("Clicked on module drop down");
	}
	
	public void clickOnControlTypeDD() {
		Log.info("Trying to click on control type drop down");
		wait.until(ExpectedConditions.visibilityOf(contPrefTypeDD));
		Log.info("Clicked on control type drop down");
	}
	
	public void clickOnControlPrefDD() {
		Log.info("Trying to click on control preference drop down");
		wait.until(ExpectedConditions.visibilityOf(contPrefDD));
		Log.info("Clicked on control preference drop down");
	}
}
