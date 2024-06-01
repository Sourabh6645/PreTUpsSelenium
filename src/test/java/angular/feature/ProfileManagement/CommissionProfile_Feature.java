package angular.feature.ProfileManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;

import angular.classes.LoginRevamp;
import angular.pageobjects.ProfileManagement.CommissionProfile_PageObject;
import angular.pageobjects.ProfileManagement.TransferControlProfile_PageObject;

public class CommissionProfile_Feature extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait = null;
	LoginRevamp login = null;
	CommissionProfile_PageObject cpp;
	TransferControlProfile_PageObject tcp;
	RandomGeneration random = null;

	String profileName = null;
	String shortName = null;
	String modifiedName = null;
	String DDvalue = null;
	String notificationMessage = "Test";

	ArrayList<String> errorMessagesOnProfilePage = new ArrayList<>(Arrays.asList(" Domain is required. ",
			" Category is required. ", " Geography is required. ", " Grade is required ", " Status is required "));

	public CommissionProfile_Feature(WebDriver driver) {
		this.driver = driver;
		cpp = new CommissionProfile_PageObject(driver);
		tcp = new TransferControlProfile_PageObject(driver);
		login = new LoginRevamp();
		wait = new WebDriverWait(driver, 20);
		random = new RandomGeneration();
		shortName = profileName = random.randomAlphabets(6);
		modifiedName = random.randomAlphabets(6);
	}

	public String selectValueFromDD() {
		Log.info("Selecting value from dd");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> ddValueList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		DDvalue = ddValueList.get(0).getText();
		Log.info("Selected value from DD : " + DDvalue);
		ddValueList.get(0).click();

		return DDvalue;
	}

	public void selectSpecificDDValue(String DDValueText) {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + DDValueText + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		DDvalue = element.getText();
		Log.info("Selected value from DD : " + DDvalue);
		element.click();
	}

	public void selectApplicableFromDate() {
		Log.info("Selecting applicable from date");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ui-button')]")))
				.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@class,'ui-datepicker-today')]")))
				.click();
		Log.info("Selected applicable date as today");
	}

	public void selectModifiedApplicableFromDate() {
		WebElement nextDate;
		Log.info("Selecting applicable from date");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ui-button')]")))
				.click();
		try {
			nextDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[contains(@class,'ui-datepicker-today')]//following::td[1]")));
		} catch (Exception e) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[contains(@class,'ui-datepicker-next')]"))).click();
			nextDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[contains(@class,'ui-datepicker-today')]//following::td[1]")));
		}
		nextDate.click();
		Log.info("Selected applicable date as today");
	}

	public void baseCommissionConfirmationAfterADD() {
		Log.info("Checking base commission profile added successfully");
		List<WebElement> numberOfDisplayedLabels = driver
				.findElements(By.xpath("(//div[contains(@id,'ng-select-box-default')])[2]//label[@for='domain']"));
		int num = numberOfDisplayedLabels.size();
		if (num == 6) {
			Log.info("Elements added successfully");
		} else {
			Log.info("Elements not added successfully");
		}
	}

	public void baseCommissionReview() {
		Log.info("Checking base commission Review page loaded successfully");

		List<WebElement> numberOfListHeading = driver.findElements(By.xpath("//label[@class='listHeading']"));
		int num1 = numberOfListHeading.size();

		List<WebElement> numberOfListVal = driver.findElements(By.xpath("//p[@class='listVal']"));
		int num2 = numberOfListVal.size();
		if (num1 == 17 && num2 == 16) {
			Log.info("Review page loaded successfully");
		} else {
			Log.info("Review page not loaded successfully");
		}

	}

	public void AddCommissionProfile() {
		Log.info("Adding Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnAddCommissionProfileButton();
		cpp.checkAddCommissionProfilePageLoaded();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.inputCommissionProfileName(profileName);
		cpp.inputCommissionProfileShortName(shortName);
		cpp.clickOnCommissionTypeDDButton();
		selectValueFromDD();
		selectApplicableFromDate();
		cpp.clickOnTransactionTypeDDButton();
		selectValueFromDD();
		cpp.clickOnBaseCommissionProductDDButton();
		selectValueFromDD();
		cpp.clickOnBaseCommissionPaymentDDButton();
		selectSpecificDDValue("Cash");
		cpp.inputBaseCommMultipleOf("10");
		cpp.inputTransferValue_Min("10");
		cpp.inputTransferValue_Max("1000");
		cpp.selectFOCCheckBox();
		cpp.selectC2CTransferCheckBox();
		cpp.inputTransactionRangeValue_Min("100");
		cpp.inputTransactionRangeValue_Max("900");
		cpp.inputCommissionRateUnitValue("5");
		cpp.inputTransactionTax1("5");
		cpp.inputTransactionTax2("5");
		cpp.inputTransactionTax3("5");
		cpp.clickOnAddButton();
		baseCommissionConfirmationAfterADD();
		cpp.clickOnSaveAndReviewButton();
		baseCommissionReview();
		cpp.clickOnSubmitButton();
		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();
		Log.info("Commission Profile Added Successfully");
	}

	public void ModifyCommissionProfile() {
		Log.info("Modufying Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cpp.inputSearchCommissionProfile(profileName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']"))).click();
		cpp.clickOnEditIcon();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cpp.modifyCommissionProfileName(modifiedName);
		cpp.modifyCommissionProfileShortName(modifiedName);

		selectModifiedApplicableFromDate();

		cpp.clickOnSaveAndReviewButton();
		baseCommissionReview();
		cpp.clickOnSubmitButton();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();
		Log.info("Commission Profile Modified Successfully");
	}

	public void ModifyCommissionProfile_FromActionPane() {

		Log.info("Modufying Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();
		cpp.inputSearchCommissionProfile(profileName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']")));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//img[@src='assets/images/edit_icon/Editicon.png'])[2]")))
				.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cpp.modifyCommissionProfileName(modifiedName);
		cpp.modifyCommissionProfileShortName(modifiedName);

		selectModifiedApplicableFromDate();

		cpp.clickOnSaveAndReviewButton();
		baseCommissionReview();
		cpp.clickOnSubmitButton();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();
		Log.info("Commission Profile Modified Successfully");

	}

	public void DeleteCommissionProfile_FromActionPane() {

		Log.info("Modufying Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();
		cpp.inputSearchCommissionProfile(modifiedName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']")));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//img[@src='assets/images/edit_icon/Editicon.png'])[2]")))
				.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cpp.modifyCommissionProfileName(modifiedName);
		cpp.modifyCommissionProfileShortName(modifiedName);

		selectModifiedApplicableFromDate();

		cpp.clickOnSaveAndReviewButton();
		baseCommissionReview();
		cpp.clickOnSubmitButton();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();
		Log.info("Commission Profile Modified Successfully");

	}

	public void DeleteCommissionProfile() {

		Log.info("Deletinging Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnProfileResetButton();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();
		cpp.inputSearchCommissionProfile(modifiedName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']"))).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/delete_icon/png/delete.png']")))
				.click();

		cpp.checkDeleteConfirmationWindow();
		cpp.clickOnAccept();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();

		Log.info("Commission Profile Deleted Successfully");
	}

	public void suspendCommissionProfile() {

		Log.info("Suspending Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnProfileResetButton();
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();
		cpp.inputSearchCommissionProfile(modifiedName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']"))).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/suspend/svg/suspend@1.5x.svg']")))
				.click();

		cpp.checkSuspendConfirmationWindow();
		cpp.inputEnglishNotification(notificationMessage);
		cpp.inputFrenchNotification(notificationMessage);
		cpp.clickOnAccept();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();

		Log.info("Commission Profile Suspended Successfully");
	}

	public void ActivateSuspendedCommissionProfile() {

		Log.info("Activating suspended Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnProfileResetButton();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();
		cpp.inputSearchCommissionProfile(modifiedName);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']"))).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/suspend/svg/suspend@1.5x.svg']")))
				.click();

		cpp.checkSuspendConfirmationWindow();
		cpp.inputEnglishNotification(notificationMessage);
		cpp.inputFrenchNotification(notificationMessage);
		cpp.clickOnAccept();

		cpp.checkSuccessMessageWindow();
		cpp.clickOnDoneButton();

		Log.info("Commission Profile Activated Successfully");
	}

	// SC01
	public void Add_Modify_UpdateStatus_Delete_CommissionProfile(String loginId, String passowrd) {

		login.LoginAsUser(driver, loginId, passowrd);
		AddCommissionProfile();
		ModifyCommissionProfile();
		suspendCommissionProfile();
		ActivateSuspendedCommissionProfile();
		DeleteCommissionProfile();

	}

	// SC02
	public void Modify_CommissionProfile_FromActionPane(String loginId, String passowrd) {
		login.LoginAsUser(driver, loginId, passowrd);
		AddCommissionProfile();
		ModifyCommissionProfile_FromActionPane();
	}

	// SC03
	public void UnableToChangeStatus_Of_Default_CommissionProfile(String loginId, String passowrd) {
		login.LoginAsUser(driver, loginId, passowrd);

		Log.info("Checking if user is unable to change status of default Commission Profile");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnAddCommissionProfileButton();
		cpp.checkAddCommissionProfilePageLoaded();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@src='assets/images/greenTick_circle/png/greenTick_circle.png']")));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//span[@id='default']//following::label[contains(@class,'anchor-disabled')])[1]")));
			Log.info("Change status button is disabled, user is unable to change status of default commission profile");
		} catch (Exception e) {
			Log.info(
					"Change status button is not disabled, user is able to change status of default commission profile");
		}
	}

	// SC04
	public void CommissionProfile_LandingPage_ViewDetails(String loginId, String passowrd) {

		login.LoginAsUser(driver, loginId, passowrd);

		Log.info("Checking basic Landing Page details");
		tcp.clickOnProfileManagementLink();
		cpp.clickOnCommissionProfileLink();
		cpp.checkCommissionProfilePage();
		cpp.clickOnProfileProceedButton();
		
		//Verifying error message
		List<WebElement> errorMessage = driver.findElements(By.xpath("//span[contains(@class,'errorMessage')]"));
		
		if(errorMessage.size() == 5) {
			Log.info("All error Messages found on screen");
		}else {
			Log.info("No error Messages found on screen");
		}

		for (int i = 0; i < errorMessage.size(); i++) {
			String errorMessageText = errorMessage.get(i).getText();
			
			if(errorMessageText.equals(errorMessagesOnProfilePage.get(i))) {
				Log.info("Error Message verfied successfully on screen");
			}else {
				Log.info("Error Message not verfied successfully on screen");
			}
		}
		
		//Verifying Reset button
		cpp.clickOnDomainDDButton();
		selectSpecificDDValue("Distributor");
		cpp.clickOnStatusDDButton();
		selectValueFromDD();
		cpp.clickOnProfileProceedButton();

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='viewScreen-btn']")));
			Log.info("Commission Profiles data loaded successfully");
		} catch (Exception e) {
			Log.info("Commission Profiles data not loaded successfully");
		}

		cpp.clickOnProfileResetButton();

		List<WebElement> reset = driver.findElements(By.xpath(
				"//label[@for='domain']//following::div[contains(@class,'ng-placeholder')]//following::div[contains(@class,'ng-value')]"));

		if (reset.size() == 4) {
			Log.info("Reset was successful");
		} else {
			Log.info("Reset was not successful");
		}
	}
}
