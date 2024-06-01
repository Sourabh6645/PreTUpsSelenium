package angular.pageobjects.voucher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.Log;

public class UpdateVoucherExpiryDate {

	/* ---Web Elements--- */

	// Left Pane Voucher Expiry Date Modification Option
	@FindBy(id = "vouchExpDateModification")
	private WebElement voucherExpDateModificationLink;

	// VMS option from header tab
	@FindBy(id = "mat-tab-label-1-1")
	private WebElement vmsHeaderTab;

	// Voucher Type Digital
	@FindBy(xpath = "(//div[@formcontrolname='selectedVoucherType']//input//following::p)[1]")
	private WebElement voucherTypeDigital;

	// Voucher Type Electronics
	@FindBy(xpath = "(//div[@formcontrolname='selectedVoucherType']//input//following::p)[3]")
	private WebElement voucherTypeElectronics;

	// Voucher Type Physical
	@FindBy(xpath = "(//div[@formcontrolname='selectedVoucherType']//input//following::p)[4]")
	private WebElement voucherTypePhysical;

	// Input From Serial Number
	@FindBy(xpath = "//input[@formcontrolname='fromSerialNo']")
	private WebElement fromSerialNumber;

	// Input To Serial Number
	@FindBy(xpath = "//input[@formcontrolname='toSerialNo']")
	private WebElement toSerialNumber;

	// Calendar Button
	@FindBy(xpath = "//button[contains(@class,'ui-calendar-button')]")
	private WebElement datePickerButton;

	// Calender Input Field
	@FindBy(xpath = "//span[contains(@class,'ui-calendar')]//input")
	private WebElement dateInputField;

	// Reset Button
	@FindBy(id = "//button[@id='reset_id']")
	private WebElement resetButton;

	// Submit Button
	@FindBy(id = "update_id")
	private WebElement submitButton;

	// Success Window
	@FindBy(xpath = "//img[@alt='success']")
	private WebElement successWindow;

	// Success Message
	@FindBy(xpath = "//img[@alt='success']//following::h4")
	private WebElement successMessage;

	// Success Done Button
	@FindBy(id = "done_id")
	private WebElement successDone;
	
	//Invalid Message
	@FindBy(xpath = "//div[contains(@class,'mat-card-header-text')]//mat-card-subtitle")
	private WebElement invalidMessageCard;

	WebDriver driver = null;
	WebDriverWait wait = null;

	public UpdateVoucherExpiryDate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* ---Voucher Expiry Date Update Basic Functions--- */

	public boolean isvouchExpDateModificationVisible() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException interrupted) {
			interrupted.printStackTrace();
		}
		try {
			WebElement expanded = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("vouchExpDateModification")));
			if (expanded.isDisplayed())
				return true;
		}

		catch (Exception e) {
			return false;
		}

		return false;
	}

	public void clickVouchExpDateModification() {
		Log.info("Trying to click on Voucher Expiry Date Link");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vouchExpDateModification"))).click();
		Log.info("Clicked on Voucher Expiry Date Link");
	}

	public boolean isvouchExpDateModificationPageVisible() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException interrupted) {
			interrupted.printStackTrace();
		}

		try {
			WebElement button = wait.until(ExpectedConditions.visibilityOf(submitButton));
			if (button.isDisplayed())
				return true;
		}

		catch (Exception e) {
			return false;
		}

		return false;
	}

	public void selectDigitalVoucherCategory() {
		Log.info("Trying to click on Digital Voucher Category");
		wait.until(ExpectedConditions.visibilityOf(voucherTypeDigital)).click();
		Log.info("Clicked on Digital Voucher Category");
	}

	public void selectElectronicsVoucherCategory() {
		Log.info("Trying to click on Electronic Voucher Category");
		try {
			wait.until(ExpectedConditions.visibilityOf(voucherTypeElectronics)).click();
		} catch (Exception e) {
			Log.info("Element is not visible");
		}

		Log.info("Clicked on Electronic Voucher Category");

	}

	public void selectPhysicalVoucherCategory() {
		Log.info("Trying to click on physical voucher category");
		wait.until(ExpectedConditions.visibilityOf(voucherTypePhysical)).click();
		Log.info("Clicked on physical voucher category");
	}

	public void inputFromSerialId(String SerialNumber) {
		Log.info("Trying to input from serial number");
		wait.until(ExpectedConditions.visibilityOf(fromSerialNumber));
		fromSerialNumber.sendKeys(SerialNumber);
		Log.info("Entered Starting Serial Number");
	}

	public void inputToSerialId(String SerialNumber) {
		Log.info("Trying to input to serial number");
		wait.until(ExpectedConditions.visibilityOf(toSerialNumber));
		toSerialNumber.sendKeys(SerialNumber);
		Log.info("Entered To Serial Number");

	}

	public void clickOnSubmitButton() {
		Log.info("Trying to click on submit button");

		wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
		Log.info("Clicked on submit button");

	}

	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");

		wait.until(ExpectedConditions.visibilityOf(resetButton)).click();
		Log.info("Clicked on reset button");

	}

	public void clickOnDatePickerButton() {
		Log.info("Trying to click on date picker button");
		wait.until(ExpectedConditions.visibilityOf(datePickerButton)).click();
		Log.info("Clicked on date picker button");
	}

	public boolean checkForSuccessWindow() {
		try {
			wait.until(ExpectedConditions.visibilityOf(successWindow));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public void isSuccessWindowVisible() {
		Log.info("Checking for success window visibility");
		wait.until(ExpectedConditions.visibilityOf(successWindow));
		Log.info("Success Window is visible");
	}

	public void closeSuccessWindow() {
		Log.info("Trying to click on done button");
		wait.until(ExpectedConditions.visibilityOf(successDone));
		Log.info("Clicked on done button");
	}

	public void checkSuccessWindowIsClosed() {
		String s = fromSerialNumber.getText();
		if (s.isEmpty()) {
			Log.info("From input field is empty");
		}
		String s2 = dateInputField.getText();
		if (s2.isEmpty()) {
			Log.info("To input field is empty");
		}
	}

	public void validateSuccessMessage(String actualMessage) {

		String s1 = successMessage.getText();
		Log.info("Actual Message : "+actualMessage);
		Log.info("Message Found : "+s1);
		if (s1.equals(actualMessage)) {
			Log.info("Success Message Assertion Successful");
		} else {
			Log.info("Success Message Assertion Failed");
		}

	}
	
	public boolean checkForIncorrectSerialIdErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(invalidMessageCard));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String geterrorMessageForInvalidFromandToSerialId() {
		String s = invalidMessageCard.getText();
		
		return s;
	}
}
