package angular.feature.ProfileManagement;

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
import angular.pageobjects.ProfileManagement.TransferControlProfile_PageObject;

public class TransferControlProfile_Feature extends BaseTest {
	
	public WebDriver driver;
	LoginRevamp login;
	TransferControlProfile_PageObject tcp;
	WebDriverWait wait;
	RandomGeneration randomgen;
	
	
	public TransferControlProfile_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		tcp = new TransferControlProfile_PageObject(driver);
		randomgen = new RandomGeneration();
		wait = new WebDriverWait(driver, 20);
	}
	
	
	public String selectValueFromDD() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> ddValueList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		String value = ddValueList.get(0).getText();
		ddValueList.get(0).click();
		
		return value;
	}
	
	public void modifyTransferControlProfile(String profileName) {
		Log.info("Trying to perform Modify Transfer Control Profile");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tcp.inputSearchData(profileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tcp.clickOnEditRecoedButton();
		tcp.checkTransferControlProfilePageLoadedSuccessfully();
		tcp.checkDeleteIconOnModifyPage();
		tcp.clickOnDailyTransferControlPreferences();
		tcp.clickOnWeeklyTransferControlPreferences();
		tcp.clickOnMonthlyTransferControlPreferences();
		tcp.clickOnSaveButton();
		tcp.checkReviewAndConfirmPage();
		tcp.clickOnConfirmButton();
		tcp.checkTransferControlProfileSuccessMessage();
		tcp.clickOnSuccessDoneButton();
		Log.info("Performed Modify Transfer Control Profile");
	}
	
	public void deleteTransferControlProfile(String profileName) {
		
		Log.info("Trying to perform delete transfer control profile");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tcp.inputSearchData(profileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tcp.clickOnDeleteRecoedButton();
		tcp.checkDeleteConfirmationWindow();
		tcp.clickOnDeleteConfirmation();
		tcp.checkDeleteSuccesstDeleteWindow();
		tcp.clickOnSuccessDoneButton();
		
		Log.info("Performed delete transfer control profile");
	}
	
	public void checkNoFieldIsEditableOnReviewAndConfirmPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popup-body']//following::input")));
			Log.info("Editable fields found on review and confirm page");
		}catch(Exception e) {
			Log.info("No editable fields found on review and confirm page");
		}
	}
	
	public String addTransferControlProfile() {
		Log.info("Trying to perform add Transfer Control Profile");
		tcp.checkTransferControlProfilePageLoadedSuccessfully();
		tcp.clickOnFiltersDomainDD();
		String domain = selectValueFromDD();
		tcp.clickOnFilterCategoryDD();
		String category = selectValueFromDD();
		tcp.clickOnFilterStatusDD();
		selectValueFromDD();
		tcp.clickOnFilterProceedButton();
		tcp.checkTransferControlProfileResultLoadedSuccessfully();
		tcp.clickOnAddTransferControlProfileButton();
		tcp.checkAddPageLoadedSuccessfully();
		tcp.validateDomainOnAddPage(domain);
		tcp.validateCategoryOnAddPage(category);
		String profile = randomgen.randomAlphabets(6);
		tcp.insertProfileName(profile);
		tcp.insertShortName(profile);
		tcp.insertDescription(profile);
		tcp.clickOnStatusDropDown();
		selectValueFromDD();
		tcp.setDefaultProfileStatus("NO");
		tcp.clickOnDailyTransferControlPreferences();
		tcp.clickOnWeeklyTransferControlPreferences();
		tcp.clickOnMonthlyTransferControlPreferences();
		tcp.clickOnSaveButton();
		tcp.checkReviewAndConfirmPage();
		checkNoFieldIsEditableOnReviewAndConfirmPage();
		tcp.checkCloseButtonIsVisible();
		tcp.clickOnConfirmButton();
		tcp.checkTransferControlProfileSuccessMessage();
		tcp.clickOnSuccessDoneButton();
		Log.info("Performed add Transfer Control Profile");
		
		return profile;
	}
	
	
	public void checkErrorMessageIsProvidedUponNotProvidingMandatoryDetails() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'errorMessage')]")));
		List<WebElement> errorMessages = driver.findElements(By.xpath("//span[contains(@class,'errorMessage')]"));
		String[] profileNameError = {"Profile name is required","Short name is required","Description is required.","Status is required","Default is required"};
		/*profileNameError = "Profile name is required";
		shortNameError = "Short name is required";
		descriptionError = "Description is required.";
		statusError = "Status is required";
		defaultProfileError = "Default is required";*/
		for(int i = 0;i<errorMessages.size();i++) {
			if(errorMessages.get(i).getText().equals(profileNameError[i])) {
				Log.info("Error message expected and found on screen are the same");
				Log.info("Error message : "+errorMessages.get(i).getText());
			}else {
				Log.info("Expected and actual message didn't matched : Actual Message : "+errorMessages.get(i).getText()+" : Expected Message : "+profileNameError[i]);
			}
		}		
	}
	
	public void checkErrorMessageUponInsertingIncorrectGraterValue(String type) {
		String maxValue = "999999999";
		Log.info("Verifing Error Message upon Daily value Greater than Weekly Value");
		
		tcp.inputChannelTransferInCount(type,maxValue);
		tcp.inputChannelTransferOutCount(type, maxValue);
		tcp.inputSubscriberTransferInCount(type, maxValue);
		tcp.inputSubscriberTransferOutCount(type, maxValue);
		
		tcp.inputChannelTransferInAlertingCount(type, maxValue);
		tcp.inputChannelTransferOutAlertingCount(type, maxValue);
		tcp.inputSubscriberTransferInAlertingCount(type, maxValue);
		tcp.inputSubscriberTransferOutAlertingCount(type, maxValue);
		
		tcp.inputChannelTransferInValue(type, maxValue);
		tcp.inputChannelTransferOutValue(type, maxValue);
		tcp.inputSubscriberTransferInValue(type, maxValue);
		tcp.inputSubscriberTransferOutValue(type, maxValue);
		
		tcp.inputChannelTransferInAlertingValue(type, maxValue);
		tcp.inputChannelTransferOutAlertingValue(type, maxValue);
		tcp.inputSubscriberTransferInAlertingValue(type, maxValue);
		tcp.inputSubscriberTransferOutAlertingValue(type, maxValue);
		
		tcp.clickOnSaveButton();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'display-error-div')]//li")));
		
		List<WebElement> errorValue = driver.findElements(By.xpath("//div[contains(@class,'display-error-div')]//li"));
		
		if(errorValue.size() == 32) {
			Log.info("Found all error message");
			for(int i = 0;i<errorValue.size();i++) {
				Log.info("Error message found : "+errorValue.get(i).getText());
			}
			
			tcp.clickOnSuccessDoneButton();
		}else {
			Log.info("Incorrect number of error message found on screen");
		}
		
	}
	
	//SC01
	public void performAddModifyDeleteTransferControlProfile(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		tcp.selecteTopUpTab();
		tcp.clickOnProfileManagementLink();
		tcp.clickOnTransferControlProfile();
		
		String profile = addTransferControlProfile();
		try {
			modifyTransferControlProfile(profile);
		}catch(Exception e) {
			Log.info("Modify functionality failed");
		}
		
		try {
			deleteTransferControlProfile(profile);
		}catch(Exception e) {
			Log.info("Modify functionality failed");
		}
			
	}
	
	//SC02
	public void verifyThatProperErrorMessageIsDisplayedUponMissingMandatoryField(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		tcp.selecteTopUpTab();
		tcp.clickOnProfileManagementLink();
		tcp.clickOnTransferControlProfile();
		tcp.checkTransferControlProfilePageLoadedSuccessfully();
		tcp.clickOnFiltersDomainDD();
		selectValueFromDD();
		tcp.clickOnFilterCategoryDD();
		selectValueFromDD();
		tcp.clickOnFilterStatusDD();
		selectValueFromDD();
		tcp.clickOnFilterProceedButton();
		tcp.checkTransferControlProfileResultLoadedSuccessfully();
		tcp.clickOnAddTransferControlProfileButton();
		tcp.checkAddPageLoadedSuccessfully();
		WebElement save = driver.findElement(By.xpath("//button[@class='save-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		tcp.clickOnSaveButton();
		checkErrorMessageIsProvidedUponNotProvidingMandatoryDetails();
	}
	
	//SC03
	public void verifyDailyValueIsLessThanWeeklyValues(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		Log.info("Trying to Verify Daily, Weekly and Monthly Value");
		tcp.clickOnProfileManagementLink();
		tcp.clickOnTransferControlProfile();
		tcp.checkTransferControlProfilePageLoadedSuccessfully();
		tcp.clickOnFiltersDomainDD();
		String domain = selectValueFromDD();
		tcp.clickOnFilterCategoryDD();
		String category = selectValueFromDD();
		tcp.clickOnFilterStatusDD();
		selectValueFromDD();
		tcp.clickOnFilterProceedButton();
		tcp.checkTransferControlProfileResultLoadedSuccessfully();
		tcp.clickOnAddTransferControlProfileButton();
		tcp.checkAddPageLoadedSuccessfully();
		tcp.validateDomainOnAddPage(domain);
		tcp.validateCategoryOnAddPage(category);
		String profile = randomgen.randomAlphabets(6);
		tcp.insertProfileName(profile);
		tcp.insertShortName(profile);
		tcp.insertDescription(profile);
		tcp.clickOnStatusDropDown();
		selectValueFromDD();
		tcp.setDefaultProfileStatus("NO");
		tcp.clickOnDailyTransferControlPreferences();
		
		checkErrorMessageUponInsertingIncorrectGraterValue("Daily");
		
		//tcp.clickOnWeeklyTransferControlPreferences();
		//tcp.clickOnMonthlyTransferControlPreferences();
		
		
	}
	
}
