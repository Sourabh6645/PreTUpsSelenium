package angular.pageobjects.CardGroup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;

public class BulkModifyC2SCG extends BaseTest {
	
	
	// eTopUp Tab
	@FindBy(xpath = "//div[@id='mat-tab-label-1-0']//div")
	private WebElement eTopupTab;
	
	@FindBy (xpath = "(//span[@class ='childmenucss ng-star-inserted'])[4]")
	private WebElement CardGroupLink;
	
	@FindBy (xpath = "(//span[contains(text(),'Channel To Subscriber')])[1]")
	private WebElement ChannelToSubscriberLink;
	
	@FindBy (xpath = "(//button[@id='toggle-1-button'])[2]")
	private WebElement BulkOperationButton;
	
	@FindBy (id="serviceType")
	private WebElement serviceType;
	
	@FindBy (xpath = "(//span[@class='ng-arrow-wrapper'])[3]")
	private WebElement ServiceDDArrow;
	
	@FindBy (xpath = "//span[contains(@class,'pi-calendar')]")
	private WebElement CalendarIcon;
	
	@FindBy (xpath = "//h4[@id='modal-basic-title']")
	private WebElement ReviewnConfirmLabel;
	
	@FindBy (xpath = "//span[@class='form-control-feedback']")
	private WebElement SearchBar;
	
	@FindBy (xpath = "//mat-checkbox[@id ='mat-checkbox-1']")
	private WebElement SelectAllCheckBox;
	
	@FindBy (xpath = "//div[@id='userListId']")
	private WebElement DownloadFileLink;
	
	@FindBy (xpath = "//label[@class='company-copy']")
	private WebElement UploadFileLink;
	
	@FindBy (xpath = "//button[@id='resetId']//span")
	private WebElement ResetButton;
	
	@FindBy (xpath = "//button[@id='submitId']//span")
	private WebElement SubmitButton;
	
	@FindBy (xpath = "//button[@id='closeId']")
	private WebElement CancelIcon;
	
	@FindBy (xpath = "//img[@id='downloadId']")
	private WebElement DownloadFileInConfirmScreen;
	
	@FindBy (xpath = "//button[@id='confirmId']//span")
	private WebElement ConfirmButton;
	
	@FindBy (xpath = "//img[@class='ng-tns-c22-22']")
	private WebElement SuccessIconInPopUp;
	
	@FindBy (xpath = "//button[@id='doneId']//span")
	private WebElement DoneButton;
	
	
	/* ----- WebDriver Declaration ----- */

	WebDriver driver = null;
	WebDriverWait wait = null;
	RandomGeneration random = null;
	List<WebElement> ddValueList = null;

	public BulkModifyC2SCG(WebDriver driver) {
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
	
	
	
	public boolean checkVisibilityOfCardGroupLink() {
		Log.info("Checking visibility of CardGroupLink");
		try {
			wait.until(ExpectedConditions.visibilityOf(CardGroupLink));
			Log.info("CardGroupLink link is vsisble");
			return true;
		}	catch (Exception e) {
			Log.info("CardGroupLink link is not vsisble");
			return false;
		}
	}
	
	public void clickOnCardGroupLink() {
		if (checkVisibilityOfCardGroupLink()) {
			CardGroupLink.click();
			Log.info("Clicked on Card Group");
		} else {
			Log.info("Unable to click on Card Group");
		}
		
	}
	
	public void clickOnChannelToSubscriberLink() {
		Log.info("Trying to click on ChannelToSubscriber Link");
		ChannelToSubscriberLink.click();
		Log.info("Clicked on ChannelToSubscriber Link");
		
	}
	
	public boolean checkVisibilityOfBulkOperationButton() {
		Log.info("Checking visibility of BulkOperation Button");
		try {
			wait.until(ExpectedConditions.visibilityOf(BulkOperationButton));
			Log.info("BulkOperation Button is vsisble");
			return true;
		}	catch (Exception e) {
			Log.info("BulkOperation Button is not vsisble");
			return false;
		}
	}
	
	public void clickOnBulkOperationButton() {
		Log.info("Trying to click on Bulk Operation button");
		BulkOperationButton.click();
		Log.info("Clicked on Bulk Operation button");	
	}
	
	public boolean checkVisibilityOfModifyCardGroupSetPageLoadedSuccessfully() {
		Log.info("Checing if Modify Card Group Set Page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(ServiceDDArrow));
			wait.until(ExpectedConditions.visibilityOf(CalendarIcon));
			wait.until(ExpectedConditions.visibilityOf(SearchBar));
			wait.until(ExpectedConditions.visibilityOf(SelectAllCheckBox));
			wait.until(ExpectedConditions.visibilityOf(DownloadFileLink));
			wait.until(ExpectedConditions.visibilityOf(UploadFileLink));
			wait.until(ExpectedConditions.visibilityOf(ResetButton));
			wait.until(ExpectedConditions.visibilityOf(SubmitButton));
			Log.info("Modify Card Group Set Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Modify Card Group Set Page not Loaded Successfully");
		}
		return false;
	}
	
	public String selectingServiceType() {
		
		Log.info("Trying to select Service Type");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serviceType.click();
		ddValueList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		String value = ddValueList.get(0).getText();
		ddValueList.get(0).click();
		Log.info("Selected value from DD :"+value);	
		return value;
	}
	
	public void clickOnCalendarIcon() {
		Log.info("Trying to click on Calendar Icon");
		CalendarIcon.click();
		Log.info("Clicked on Calendar Icon");	
	}
	
	//select date from calendar
	
	public void clickOnSearchBar() {
		Log.info("Trying to click on Search Bar");
		SearchBar.click();
		Log.info("Clicked on Search Bar");	
	}
	
	public void clickOnSelectAllCheckBox() {
		Log.info("Trying to click on SelectAll CheckBox");
		SelectAllCheckBox.click();
		Log.info("Clicked on SelectAll CheckBox");	
	}
	
	public void clickOnDownloadFileLink() {
		Log.info("Trying to click on DownloadFile Link");
		DownloadFileLink.click();
		Log.info("Clicked on DownloadFile Link");	
	}
	
	public void clickOnUploadFileLink() {
		Log.info("Trying to click on UploadFile Link");
		UploadFileLink.click();
		Log.info("Clicked on UploadFile Link");	
	}
	
	public void clickOnResetButton() {
		Log.info("Trying to click on Reset Button");
		ResetButton.click();
		Log.info("Clicked on Reset Button");	
	}
	
	public void clickOnSubmitButton() {
		Log.info("Trying to click on Submit Button");
		SubmitButton.click();
		Log.info("Clicked on Submit Button");	
	}
	
	public boolean checkVisibilityOfReviewAndConfirmPageLoadedSuccessfully() {
		Log.info("Checing if Review and Confirm Page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(ReviewnConfirmLabel));
			wait.until(ExpectedConditions.visibilityOf(CancelIcon));
			wait.until(ExpectedConditions.visibilityOf(DownloadFileInConfirmScreen));
			wait.until(ExpectedConditions.visibilityOf(ConfirmButton));
			Log.info("Modify Review and Confirm Page Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Modify Review and Confirm Page not Loaded Successfully");
		}
		return false;
	}
	
	public void clickOnCancelIcon() {
		Log.info("Trying to click on Cancel Icon");
		CancelIcon.click();
		Log.info("Clicked on Cancel Icon");	
	}
	
	public void clickOnDownloadFileInConfirmScreen() {
		Log.info("Trying to click on DownloadFile Icon In Confirm Screen");
		DownloadFileInConfirmScreen.click();
		Log.info("Clicked on DownloadFile Icon In Confirm Screen");	
	}
	
	public void clickOnConfirmButton() {
		Log.info("Trying to click on Confirm Button");
		ConfirmButton.click();
		Log.info("Clicked on Confirm Button");	
	}
	
	public boolean checkVisibilityOfSuccessPopUpScreenLoadedSuccessfully() {
		Log.info("Checing if Success PopUp Screen loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(SuccessIconInPopUp));
			wait.until(ExpectedConditions.visibilityOf(DoneButton));
			Log.info("Modify Success PopUp Screen Loaded Successfully");
			return true;
		} catch (Exception e) {
			Log.info("Modify Success PopUp Screen not Loaded Successfully");
		}
		return false;
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on Done Button");
		DoneButton.click();
		Log.info("Clicked on Done Button");	
	}

}
