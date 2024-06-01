package angular.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;

public class NetworkProductMapping extends BaseTest {

	// eTopUp Tab
	@FindBy(xpath = "//div[@id='mat-tab-label-1-0']//div")
	private WebElement eTopupTab;

	// Network product Mapping linksNetworkProductMappingLink
	@FindBy(xpath = "//span[contains(text(),'Network Product Mapping')]")
	private WebElement NetworkProductMappingLink;

	@FindBy(xpath = "//span[contains(text(),' Network Name')]")
	private WebElement NetworkNameLabel;

	@FindBy(xpath = "(//textarea[@formcontrolname='language1Message'])[1]")
	public WebElement Language1messageinput;

	@FindBy(xpath = "(//textarea[@formcontrolname='language2Message'])[1]")
	public WebElement Language2messageinput;

	@FindBy(xpath = "(//td[@id='usage']//span[contains(@class,'ng-value-label ng-star-inserted')])[1]")
	private WebElement UsageDDTextarea;

	@FindBy(xpath = "(//table//span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement UsageDropdown;

	@FindBy(xpath = "(//span[contains(text(),'Both')])[1]")
	private WebElement UsageDropdownBoth;

	@FindBy(xpath = "(//div[@role='option']//span[contains(text(),'Consumption')])[1]")
	private WebElement UsageDropdownConsumption;

	@FindBy(xpath = "(//span[contains(text(),'Distribution')])[1]")
	private WebElement UsageDropdownDistribution;

	@FindBy(xpath = "(//td//input[@id='alertingBalance'])[1]")
	private WebElement AlertingBalanceInput;

	@FindBy(xpath = "(//table//td[@id='status']//span[contains(@class,'ng-arrow-wrapper')])[1]")
	private WebElement StatusDropdown;

	@FindBy(xpath = "(//td[@id='status']//span[contains(@class,'ng-value-label ng-star-inserted')])[1]")
	private WebElement StatusDDTextarea;

	@FindBy(xpath = "(//span[contains(text(),'Active')])[1]")
	private WebElement StatusDropdownActive;

	@FindBy(xpath = "(//span[contains(text(),'Suspended')])[1]")
	private WebElement StatusDropdownSuspend;

	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement ResetButton;

	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement ProceedButton;

	@FindBy(xpath = "//div[@class = 'success1']//img")
	private WebElement SuccessSymbol;

	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement DoneButton;

	/* ----- WebDriver Declaration ----- */

	WebDriver driver = null;
	WebDriverWait wait = null;
	RandomGeneration random = null;
	String selectedvalue = null;

	public NetworkProductMapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		random = new RandomGeneration();
	}

	/* ----- Basic Function ------ */

	public boolean checkVisibilityOfETopUp() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Log.info("Checking visibility of eTopUp Tab");

		try {
			wait.until(ExpectedConditions.visibilityOf(eTopupTab));
			Log.info("eTopUp tab is visible");
			return true;
		} catch (Exception e) {
			Log.info("eTopUp tab is not visible");
			return false;
		}
	}

	public void clickOneTopUpTab() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.info("Trying to click on eTopUp tab");
		if (checkVisibilityOfETopUp()) {
			eTopupTab.click();
			Log.info("Clicked on eTopUp tab");
		} else {
			Log.info("Unable to click on eTopUp tab as its not visible");
		}
	}

	public boolean checkVisibilityOfNetworkProductMappingLink() {
		Log.info("Checking visibility of Network Product Mapping Link");
		try {
			wait.until(ExpectedConditions.visibilityOf(NetworkProductMappingLink));
			Log.info("Network Product Mapping link is vsisble");
			return true;
		} catch (Exception e) {
			Log.info("Network Product Mapping link is not vsisble");
			return false;
		}
	}

	public void clickOnNetworkProductMappingLink() {
		if (checkVisibilityOfNetworkProductMappingLink()) {
			NetworkProductMappingLink.click();
			Log.info("Clicked on Network Product mapping");
		} else {
			Log.info("Unable to click on Network Product mapping");
		}

	}

	public boolean checkVisibilityOfNetworkProductMappingPage() {
		Log.info("Checking if Associate Network Product Mapping page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(NetworkNameLabel));
			wait.until(ExpectedConditions.visibilityOf(Language1messageinput));
			wait.until(ExpectedConditions.visibilityOf(ResetButton));
			wait.until(ExpectedConditions.visibilityOf(ProceedButton));
			Log.info("Associate Network Product Mapping page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Associate Network Product Mapping page not loaded successfully");
			return false;
		}
	}

	public void clickonLanguage1messageinput() {
		String value = random.randomAlphabets(20);
		Log.info("Trying to click on Language1message field");
		Language1messageinput.clear();
		Log.info("clicked on Language1message field");
		Language1messageinput.sendKeys(value);

	}

	public void clickonLanguage2messageinput() {
		String value = random.randomAlphabets(20);
		Log.info("Trying to click on Language2message field");
		Language2messageinput.clear();
		Log.info("clicked on Language2message field");
		Language2messageinput.sendKeys(value);
	}

	public void clickOnUsageDropdown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Log.info("Trying to click on Usage Dropdown");
		UsageDropdown.click();
		Log.info("Clicked on  Usage Dropdown");
	}

	public void clickOnUsageDropdownBoth() {
		Log.info("Trying to click on Usage Dropdown Both option");
		UsageDropdownBoth.click();
		Log.info("Clicked on  Usage Dropdown Both option");
	}

	public void clickOnUsageDropdownConsumption() {
		Log.info("Trying to click on Usage Dropdown Consumption option");
		UsageDropdownConsumption.click();
		Log.info("Clicked on  Usage Dropdown Consumption option");

	}

	public void clickOnUsageDropdownDistribution() {
		Log.info("Trying to click on Usage Dropdown Distribution option");
		UsageDropdownDistribution.click();
		Log.info("Clicked on  Usage Dropdown Distribution option");
	}

	// To select options in Usage Dropdown
	public void UsageDDSelection() {

		Log.info("Trying to select Service status values from DD");

		String currentValue = UsageDDTextarea.getText();
		Log.info("Current status value on screen:" + currentValue);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> ddValueList = driver.findElements(By.xpath("(//span[contains(@class,'ng-option-label')])"));
		if (currentValue.equals("Both")) {
			ddValueList.get(1).click();
			Log.info("Usage selected as : Consumption");
			selectedvalue = "Consumption";
		} else if (currentValue.equals("Consumption")) {
			ddValueList.get(2).click();
			Log.info("Usage selected as : Distribution");
			selectedvalue = "Distribution";
		} else {
			ddValueList.get(0).click();
			Log.info("Usage selected as : Both");
			selectedvalue = "Both";
		}

	}
	
	public void ValidateUsage() {
		String displayedValue = UsageDDTextarea.getText();
		Assert.assertEquals(selectedvalue, displayedValue);
		Log.info("Test case validated Successfully");
	}


	public void clickOnAlertingBalanceInput() {
		String value = random.randomNumeric(8);
		Log.info("Trying to click on Alerting Balance field");
		AlertingBalanceInput.clear();
		Log.info("Clicked on Alerting Balance field");
		AlertingBalanceInput.sendKeys(value);
	}

	public void clickOnStatusDropdown() {
		Log.info("Trying to click on Status dropdown");
		StatusDropdown.click();
		Log.info("Clicked on Status Dropdown");
	}

	public void clickOnStatusDropdownActive() {
		Log.info("Trying to click on Status Dropdown Active option");
		StatusDropdownActive.click();
		Log.info("Clicked on Status Dropdown Active option");
	}

	public void clickOnStatusDropdownSuspend() {
		Log.info("Trying to click on Status Dropdown suspend option");
		StatusDropdownSuspend.click();
		Log.info("Clicked on Status Dropdown suspend option");
	}

	public void StatusDDSelection() {
		Log.info("Trying to fect data in Status Dropdown");
		String Statusdata = StatusDDTextarea.getText();
		Log.info("Data present in the field is : " + Statusdata);

		List<WebElement> ddValueList = driver.findElements(By.xpath("//div[contains(@class,'ng-option')]"));
		if (Statusdata.equals("Active")) {
			ddValueList.get(1).click();
			Log.info("Clicked on Suspend option");
		} else
			ddValueList.get(0).click();
		Log.info("Clicked on Active option");
		/*
		 * if(Statusdata =="Active") { StatusDropdownSuspend.click();
		 * Log.info("Clicked on Status Dropdown suspend option"); } else
		 * StatusDropdownActive.click();
		 * Log.info("Clicked on Status Dropdown Active option");
		 */
	}

	public void clickOnResetButton() {
		Log.info("Trying to click on Reset Button");
		ResetButton.click();
		Log.info("Clicked on Reset Button");
	}

	public void clickOnProceedButton() {
		Log.info("Trying to click on Proceed Button");
		// ProceedButton.isEnabled();
		ProceedButton.click();
		Log.info("Clicked on  Proceed Button");
	}

	public boolean checkVisibilityOfSuccessPopUpScreenLoadedSuccessfully() {
		Log.info("Checking if Success PopUp Screen loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(SuccessSymbol));
			wait.until(ExpectedConditions.visibilityOf(DoneButton));
			Log.info(" Success PopUp Screen Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success PopUp Screen not Loaded Successfully");
		}
		return false;
	}

	public void clickOnDoneButton() {
		Log.info("Trying to click on Done Button");
		DoneButton.click();
		Log.info("Clicked on Done Button");
	}

}
