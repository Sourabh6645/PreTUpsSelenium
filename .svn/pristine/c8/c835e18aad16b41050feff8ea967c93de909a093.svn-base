package angular.pageobjects.NetworkServices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class NetworkServices_PageObject extends BaseTest {

	// eTopUp Tab
	@FindBy(id = "mat-tab-label-1-0")
	private WebElement eTopUpTab;

	// Network Services Link
	@FindBy(xpath = "(//h6[contains(text(), 'Network Services')]//following-sibling::img)[2]")
	private WebElement NetworkServices;

	// Module DD
	@FindBy(xpath = "(//span [@class = 'ng-arrow-wrapper'])[3]")
	private WebElement ModuleDD;

	// Service type DD
	@FindBy(xpath = "(//span [@class = 'ng-arrow-wrapper'])[4]")
	private WebElement ServiceTypeDD;

	// Filter Reset Button
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement filterResetButton;

	// Filter Proceed Button
	@FindBy(xpath = "(//button[@name='Proceed']//span)[1]")
	private WebElement filterProceedButton;

	// Modify service status

	@FindBy(xpath = "//label[contains(text(), 'Reciever Network')]")
	private WebElement ReceiverNetwork;

	@FindBy(xpath = "//label[contains(text(), 'MODULE')]")
	private WebElement Module;

	@FindBy(xpath = "//label[contains(text(), 'SERVICE TYPE')]")
	private WebElement ServiceType;

	@FindBy(xpath = "(//th[contains(@class ,'sorting')])[1]")
	private WebElement SenderNetwork;

	@FindBy(xpath = "(//th[contains(@class ,'sorting')])[2]")
	private WebElement RechargeServiceStatus;

	// Language 1 message
	@FindBy(xpath = "(//th[contains(@class ,'sorting')])[3]")
	private WebElement Lang1RemarkInput;

	// Language 2 message
	@FindBy(xpath = "(//th[contains(@class ,'sorting')])[4]")
	private WebElement Lang2RemarkInput;

	@FindBy(xpath = "//select[@name='parentTable_length']")
	private WebElement showEntriesSelect;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[4]")
	private WebElement ModifyBtn;

	@FindBy(xpath = "(//span[@class='mat-button-wrapper'])[3]")
	private WebElement ResetServiceBtn;

	// Success Screen
	@FindBy(xpath = "(//div[@class= 'container'])[1]")
	private WebElement SuccessPage;

	@FindBy(xpath = "(//div[@class= 'container'])[2]")
	private WebElement Done;

	/* -----WebDriver Declaration----- */
	WebDriver driver = null;
	WebDriverWait wait = null;

	public NetworkServices_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnNetworkServices() {
		Log.info("Clicking on Network Services Tab");
		wait.until(ExpectedConditions.visibilityOf(NetworkServices)).click();
		Log.info("Clicked on Network Services tab Successfully");
	}

	public boolean checkNetworkServicesPageLoadedSuccessfully() {
		try {
			wait.until(ExpectedConditions.visibilityOf(ModuleDD));
			wait.until(ExpectedConditions.visibilityOf(ServiceTypeDD));
			wait.until(ExpectedConditions.visibilityOf(filterProceedButton));
			wait.until(ExpectedConditions.visibilityOf(filterResetButton));
			Log.info("Network Services page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Network Services page not loaded successfully");
		}
		return false;
	}

	public void clickOnModuleDD() {
		Log.info("Trying to click on Filters Module DD");
		wait.until(ExpectedConditions.visibilityOf(ModuleDD)).click();
		Log.info("Clicked on Filter Module DD");
	}

	public void clickOnSerivceTypeDD() {
		Log.info("Trying to click on Filters Service Type DD");
		wait.until(ExpectedConditions.visibilityOf(ServiceTypeDD)).click();
		Log.info("Clicked on Filter Service Type DD");
	}

	public void clickOnFiltersProceedbtn() {
		Log.info("Trying to click on Filter Proceed Button");
		wait.until(ExpectedConditions.visibilityOf(filterProceedButton)).click();
		Log.info("Clicked on Filter Proceed Button");
	}

	public boolean checkVisibilityOfModifyServicesStatus() {
		try {
			wait.until(ExpectedConditions.visibilityOf(ReceiverNetwork));
			wait.until(ExpectedConditions.visibilityOf(Module));
			wait.until(ExpectedConditions.visibilityOf(ServiceType));
			wait.until(ExpectedConditions.visibilityOf(SenderNetwork));
			wait.until(ExpectedConditions.visibilityOf(RechargeServiceStatus));
			wait.until(ExpectedConditions.visibilityOf(Lang1RemarkInput));
			wait.until(ExpectedConditions.visibilityOf(Lang2RemarkInput));
			wait.until(ExpectedConditions.visibilityOf(showEntriesSelect));
			wait.until(ExpectedConditions.visibilityOf(ModifyBtn));
			wait.until(ExpectedConditions.visibilityOf(ResetServiceBtn));
			Log.info("Modify Service Status page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Modify Service status page not loaded successfully");
		}
		return false;
	}

	public void clickOnFiltersResetbtn() {
		Log.info("Trying to click on Filter Reset Button");
		wait.until(ExpectedConditions.visibilityOf(filterResetButton)).click();
		Log.info("Clicked on Filter Reset Button");
	}

	public void clickOnModifyServiceStatusBtn() {
		Log.info("Trying to click on Modify Service Status Button");
		wait.until(ExpectedConditions.visibilityOf(ModifyBtn)).click();
		Log.info("Clicked on Modify Button");
	}

	public void clickOnResetServiceStatusBtn() {
		Log.info("Trying to click on Service Status Reset Button");
		wait.until(ExpectedConditions.visibilityOf(ResetServiceBtn)).click();
		Log.info("Clicked on Service Status Reset Button");
	}

	public boolean checkVisibilityOfSuccessWindow() {
		try {
			wait.until(ExpectedConditions.visibilityOf(SuccessPage));
			wait.until(ExpectedConditions.visibilityOf(Done));
			Log.info("Success popup displayed successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success popup displayed successfully");
		}
		return false;
	}

	public void clickOnDoneBtn() {
		Log.info("Trying to click on Done Button");
		wait.until(ExpectedConditions.visibilityOf(Done)).click();
		Log.info("Clicked on Done Button");
	}
}
