package angular.pageobjects.voucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;



public class ResendVoucherPin_PageObject extends BaseTest {

	@FindBy(xpath = "(//div[@id='approvalVoucherArr'])[3]")
	private WebElement voucherPinResendButton;

	@FindBy(xpath = "//button[@value='mobileNumber']")
	private WebElement filterMobileNumber;

	@FindBy(xpath = "//button[@value='advanced']")
	private WebElement filterTransactionId;

	@FindBy(id = "name")
	private WebElement filterInputField;

	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement filterResetButton;

	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement filterProceedBUtton;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;

	@FindBy(xpath = "//span[contains(@class,'ui-calendar')]//input")
	private WebElement datePicker;

	@FindBy(id = "textBox")
	private WebElement pinResendRemark;

	@FindBy(xpath = "//button[@id='resBtn']//span")
	private WebElement reviewConfirmButton;

	@FindBy(id = "modal-basic-title")
	private WebElement pinResentSuccessPage;

	@FindBy(xpath = "//button[@id='doneBtn']//span")
	private WebElement successDoneButton;
	
	@FindBy(xpath = "(//a[@class='reversalClass'])[2]")
	private WebElement pinResendButton;

	WebDriver driver = null;
	WebDriverWait wait = null;

	public ResendVoucherPin_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public boolean checkVisibilityOfVoucherPinResendLink() {
		Log.info("Checking for visibility of Voucher Pin Resend Button");
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='approvalVoucherArr'])[3]")));
			Log.info("Voucher Pin Resend Button is visible");
			return true;
		} catch (Exception e) {
			Log.info("Voucher Pin Resend Button is not visible");
			return false;
		}
	}

	public void clickOnVoucherPinResend() {
		Log.info("Trying to click on voucher pin resend button");
		voucherPinResendButton.click();
		Log.info("Clicked On Pin resend button");
	}

	public boolean checkPinResendPageLoadedSuccessfully() {
		Log.info("Checking if Pin Resend Button Loaded Successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(filterProceedBUtton));
			Log.info("Pin resend button page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Voucher pin resend page not loaded successfully");
			return false;
		}
	}

	public void selectDate() {
		Log.info("Selecting date from date picker");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(datePicker)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'ui-state-highlight')]"))).click();
		Log.info("Selected date");
	}

	public void insertRetailerMobileNumber(String value) {
		Log.info("Trying to input mobile number");
		wait.until(ExpectedConditions.visibilityOf(filterInputField)).sendKeys(value);
		Log.info("Inserted mobile number : " + value);
	}
	
	public void insertTransactionId(String value) {
		Log.info("Trying to input Transaction Id");
		wait.until(ExpectedConditions.visibilityOf(filterInputField)).sendKeys(value);
		Log.info("Inserted Transaction Id : " + value);
	}

	public void clickOnResetButton() {
		Log.info("Trying to click on filter reset button");
		wait.until(ExpectedConditions.visibilityOf(filterResetButton)).click();
		Log.info("Clicked on Reset button");
	}

	public void clickOnProceedButton() {
		Log.info("Trying to click on filter proceed button");
		wait.until(ExpectedConditions.visibilityOf(filterProceedBUtton)).click();
		Log.info("Clicked on proceed button");
	}

	public boolean checkSearchResultLoadedSuccessfully() {
		Log.info("Checking if search result loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchField));
			Log.info("Transaction Loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("No transaction found");
			return false;
		}
	}

	public void insertPinResendRemark(String value) {
		Log.info("Trying to insert pin resend remarks");
		wait.until(ExpectedConditions.visibilityOf(pinResendRemark)).sendKeys(value);
		Log.info("Pin resend remark : " + value);
	}

	public boolean checkReviewAndConfirmPageLoadedSuccessfully() {
		Log.info("Checking if Review and Cinfirm tab loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmButton));
			Log.info("Review and confirm page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Review and confirm page not loaded successfully");
			return false;
		}
	}

	public void clickOnConfirmButton() {
		Log.info("Trying to click on Confirm button");
		wait.until(ExpectedConditions.visibilityOf(reviewConfirmButton)).click();
		Log.info("Clicked on confirm button");
	}

	public boolean checkSuccessPageLoaded() {
		Log.info("Checking if success window loaded");
		try {
			wait.until(ExpectedConditions.visibilityOf(successDoneButton));
			Log.info("Success window loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success window not loaded");
			return false;
		}
	}

	public void clickOnSuccessWindowDoneButton() {
		Log.info("Clicking on Done button");
		wait.until(ExpectedConditions.visibilityOf(successDoneButton)).click();
		Log.info("Clicked on done button");
	}
	
	public void clickOnPinResendButton() {
		Log.info("Trying to perform pin resend of perticular transaction");
		wait.until(ExpectedConditions.visibilityOf(pinResendButton)).click();
		Log.info("Clicked on pin resend button successfully");
	}
	
	public void selectFilterAsTransactionID() {
		Log.info("Trying to select filter as Transaction Id");
		wait.until(ExpectedConditions.visibilityOf(filterTransactionId)).click();
		Log.info("Selected Filter as Transaction Id");
	}

}
