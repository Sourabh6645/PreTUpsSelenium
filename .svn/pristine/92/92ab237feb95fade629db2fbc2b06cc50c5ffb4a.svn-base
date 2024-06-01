package angular.feature.Voucher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;

import angular.classes.LoginRevamp;
import angular.pageobjects.voucher.ResendVoucherPin_PageObject;
import jline.internal.Log;

public class VocuherPinResend_Feature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	ResendVoucherPin_PageObject pinResend;
	WebDriverWait wait;

	String fromSerialId = null;
	String toSerialId = null;
	List<String> listOfVoucher;

	public VocuherPinResend_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		pinResend = new ResendVoucherPin_PageObject(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void perfromVoucherPinResend_Via_MobileNumber(String loginId,String password) {
		
		login.LoginAsUser(driver, loginId, password);

		pinResend.checkVisibilityOfVoucherPinResendLink();
		pinResend.clickOnVoucherPinResend();
		pinResend.checkPinResendPageLoadedSuccessfully();
		pinResend.selectDate();
		pinResend.insertRetailerMobileNumber("7222212125");
		pinResend.clickOnProceedButton();
		pinResend.checkSearchResultLoadedSuccessfully();
		pinResend.clickOnPinResendButton();
		pinResend.checkReviewAndConfirmPageLoadedSuccessfully();
		pinResend.insertPinResendRemark("Automation Testing");
		pinResend.clickOnConfirmButton();
		pinResend.checkSuccessPageLoaded();
		pinResend.clickOnSuccessWindowDoneButton();
	}

	public void perfromVoucherPinResend_Via_TransactionID(String loginId,String password) {
		login.LoginAsUser(driver, loginId, password);
		pinResend.checkVisibilityOfVoucherPinResendLink();
		pinResend.clickOnVoucherPinResend();
		pinResend.checkPinResendPageLoadedSuccessfully();
		pinResend.selectFilterAsTransactionID();
		pinResend.insertTransactionId("E230227.1629.100001");
		pinResend.clickOnProceedButton();
		pinResend.checkSearchResultLoadedSuccessfully();
		pinResend.clickOnPinResendButton();
		pinResend.checkReviewAndConfirmPageLoadedSuccessfully();
		pinResend.insertPinResendRemark("Automation Testing");
		pinResend.clickOnConfirmButton();
		pinResend.checkSuccessPageLoaded();
		pinResend.clickOnSuccessWindowDoneButton();
	}

	public void errorMessageUponProceedingWithoutMobileNumber(String loginId,String password) {
		login.LoginAsUser(driver, loginId, password);
		pinResend.checkVisibilityOfVoucherPinResendLink();
		pinResend.clickOnVoucherPinResend();
		pinResend.checkPinResendPageLoadedSuccessfully();
		pinResend.clickOnProceedButton();
		String error1 = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'errorMessage')]//div[1])[1]")))
				.getText();
		String error2 = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'errorMessage')]//div[1])[2]")))
				.getText();
		Log.info("Error Meeage found on Screen : errorMessage1 : " + error1 + " | errorMessage2 : " + error2);
	}

	public void errorMessageUponProceedingWithoutTransactionId(String loginId,String password) {
		login.LoginAsUser(driver, loginId, password);
		pinResend.checkVisibilityOfVoucherPinResendLink();
		pinResend.clickOnVoucherPinResend();
		pinResend.checkPinResendPageLoadedSuccessfully();
		pinResend.clickOnProceedButton();
		String error1 = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'errorMessage')]//div[1])[1]")))
				.getText();
		Log.info("Error Meeage found on Screen : errorMessage1 : " + error1);
	}
	
}
