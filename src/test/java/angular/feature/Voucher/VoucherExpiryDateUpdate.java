package angular.feature.Voucher;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.dbrepository.DBHandler;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.voucher.UpdateVoucherExpiryDate;

public class VoucherExpiryDateUpdate extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	UpdateVoucherExpiryDate vochExpDateModify;
	WebDriverWait wait;
	
	String fromSerialId = null;
	String toSerialId = null;
	List<String> listOfVoucher;
	
	public VoucherExpiryDateUpdate(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		vochExpDateModify = new UpdateVoucherExpiryDate(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void selectVoucherCategory(String vouchCat) {
		switch (vouchCat) {
		case "Digital":
			vochExpDateModify.selectDigitalVoucherCategory();
			break;
		case "Electronic":
			vochExpDateModify.selectElectronicsVoucherCategory();
			break;
		case "Physical":
			vochExpDateModify.selectPhysicalVoucherCategory();
			break;
		default:
			Log.info("Either incorrect category code is recieved or element is not visible");
			break;
		}
	}

	public void selectNetworkCode() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='mat-tab-label-1-0']//following::div[@class='ng-input']//following::span)[1]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Network GGN']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='networkyes_id']//span")))
				.click();
	}

	public void selectNewExpiryDate() {

		System.out.println(java.time.LocalDate.now());
		LocalDate date1 = java.time.LocalDate.now();
		String date = date1.toString();
		String[] dateTime = date.split("-");
		int currentDate = Integer.parseInt(dateTime[2]);
		int currentMonth = Integer.parseInt(dateTime[1]);
		int currentYear = Integer.parseInt(dateTime[0]);
		Log.info("currentDate : " + currentDate);
		Log.info("currentMonth : " + currentMonth);
		Log.info("currentYear : " + currentYear);
		int montValue = 0;

		if (currentMonth == 12) {
			montValue = 0;

			currentYear = currentYear + 1;

		} else {
			montValue = montValue + 1;
		}

		// click datepicker button
		vochExpDateModify.clickOnDatePickerButton();

		// select new year if system on last month
		WebElement newYear = driver.findElement(By.xpath("//option[@value=" + currentYear + "]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newYear);
		newYear.click();

		// select month dropdown
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[contains(@class,'ui-datepicker-month')]"))).click();

		// select month from dropdown
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value=" + montValue + "]")))
				.click();

		// select date from date picker
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=" + currentDate + "]"))).click();
	}

	public void performVoucherExpDateUpdate(String LoginId, String Password, String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}
		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","GE","136", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","EN","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","GE","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		default:
			break;
		}

		selectNewExpiryDate();

		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "10 out of 10 requested vouchers expiry date modified successfully.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		vochExpDateModify.checkSuccessWindowIsClosed();

	}

	public void verifyUserExpiryDateModificationFailesUponIncorrectFromAndToSerialId(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","GE","136", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(toSerialId);
			vochExpDateModify.inputToSerialId(fromSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","EN","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(toSerialId);
			vochExpDateModify.inputToSerialId(fromSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","GE","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(toSerialId);
			vochExpDateModify.inputToSerialId(fromSerialId);
			break;
			
		default:
			break;
		}

		if(vochExpDateModify.checkForIncorrectSerialIdErrorMessage()) {
			String expectedMessage = "From serial no. cannot be greater than To Serial No.";
			String actualMessage = vochExpDateModify.geterrorMessageForInvalidFromandToSerialId();
			if(actualMessage.equals(null)) {
				Log.info("No Error Message Found");
			}else if(expectedMessage.equals(actualMessage)) {
				Log.info("Error Message Verified Successfully");
			}else {
				Log.info("Please Verify Both Message, Actual Mesage :"+actualMessage+" Expected Message :"+expectedMessage);
			}
		}
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "0 out of 0 requested vouchers expiry date modified successfully.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		
	}
	
	public void userIsUnableToModifyExpiryDateWithDifferentDenomination(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId("9920340000001173");
			vochExpDateModify.inputToSerialId("9920340000001171");
			break;
		case "Physical":
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId("9920100000000464");
			vochExpDateModify.inputToSerialId("9920100000000462");
			break;
		case "Electronic":
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId("9920330000000112");
			vochExpDateModify.inputToSerialId("9920330000000110");
			break;
		default:
			break;
		}

		if(vochExpDateModify.checkForIncorrectSerialIdErrorMessage()) {
			String expectedMessage = " From serial no. cannot be greater than To Serial No. ";
			String actualMessage = vochExpDateModify.geterrorMessageForInvalidFromandToSerialId();
			if(actualMessage.equals(null)) {
				Log.info("No Error Message Found");
			}else if(expectedMessage.equals(actualMessage)) {
				Log.info("Error Message Verified Successfully");
			}else {
				Log.info("Please Verify Both Message, Actual Mesage :"+actualMessage+" Expected Message :"+expectedMessage);
			}
		}
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		if(vochExpDateModify.checkForSuccessWindow()) {
			Log.info("User is able to submit update expiry date, even though from and to serial ids are incorrect");
		}else {
			Log.info("User is not able to submit update expiry date due to incorrect from and to serial ids");
		}
	}
	
	public void verifyUserIsUnableToModifyExpiryDateOfVoucherStatusConsumed(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","CU","113", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(7);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","CU","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","CU","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		default:
			break;
		}

		
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "0 out of 10 requested vouchers expiry date modified successfully.10 could not be modified as they are either consumed,on hold,stolen, suspended or damaged.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		
	}
	
	public void verifyUserIsUnableToModifyExpiryDateOfVoucherStatusStolen(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","ST","136", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(1);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","ST","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","ST","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		default:
			break;
		}

		
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "0 out of 10 requested vouchers expiry date modified successfully.10 could not be modified as they are either consumed,on hold,stolen, suspended or damaged.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		
	}
	
	public void verifyUserIsUnableToModifyExpiryDateOfVoucherStatusOnHold(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","OH","136", 5);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(1);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","OH","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","OH","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		default:
			break;
		}

		
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "0 out of 10 requested vouchers expiry date modified successfully.10 could not be modified as they are either consumed,on hold,stolen, suspended or damaged.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		
	}
	
	public void verifyUserIsUnableToModifyExpiryDateOfVoucherStatusDamaged(String LoginId, String Password,
			String voucherType) {

		login.UserLoginSuperAdmin(driver, LoginId, Password);

		if (vochExpDateModify.isvouchExpDateModificationVisible()) {
			Log.info("Voucher Expiry Date Modification Link is Visible");
			vochExpDateModify.clickVouchExpDateModification();
		} else {
			Log.info("Voucher Expiry Date Modification Link is not Visible");
		}

		if (vochExpDateModify.isvouchExpDateModificationPageVisible()) {
			Log.info("Voucher Expiry Date Modification Page Loaded Successfully");
		} else {
			Log.info("Voucher Expiry Date Modification Page Not Loaded Successfully");
		}

		WebElement networkElement = driver.findElement(By.xpath(
				"//div[@id='mat-tab-label-1-0']//following::div[@id='mlayout']//following::span[contains(@class,'ng-value-label')]"));
		String networkValue = networkElement.getText();
		
		if (!networkValue.equals("Network GGN")) {
			selectNetworkCode();
		}

		switch (voucherType) {
		case "Digital":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("digital","DA","136", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(1);
			
			selectVoucherCategory("Digital");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Physical":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("physical","DA","116", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Physical");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		case "Electronic":
			
			listOfVoucher =  DBHandler.AccessHandler.getMultipleVoucherSerialNumber("electronic","DA","135", 10);
			fromSerialId= listOfVoucher.get(0);
			toSerialId = listOfVoucher.get(9);
			
			selectVoucherCategory("Electronic");
			vochExpDateModify.inputFromSerialId(fromSerialId);
			vochExpDateModify.inputToSerialId(toSerialId);
			break;
			
		default:
			break;
		}

		
		
		selectNewExpiryDate();
		vochExpDateModify.clickOnSubmitButton();
		vochExpDateModify.isSuccessWindowVisible();
		String s = "0 out of 10 requested vouchers expiry date modified successfully.10 could not be modified as they are either consumed,on hold,stolen, suspended or damaged.";
		vochExpDateModify.validateSuccessMessage(s);
		vochExpDateModify.closeSuccessWindow();
		
	}
	
	

}
