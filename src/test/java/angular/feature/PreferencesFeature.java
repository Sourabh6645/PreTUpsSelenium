package angular.feature;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.dbrepository.DBHandler;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.Preferances.NetworkServiceControlPreferancesPage;

public class PreferencesFeature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	NetworkServiceControlPreferancesPage nscPreferences;
	WebDriverWait wait;

	String fromSerialId = null;
	String toSerialId = null;
	List<String> listOfVoucher;

	public PreferencesFeature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		nscPreferences = new NetworkServiceControlPreferancesPage(driver);
		wait = new WebDriverWait(driver, 20);
	}

	public void checkEditableFieldsAndPerformModify() {

		List<WebElement> inputFields = null;

		inputFields = driver.findElements(By.xpath("//input[@id='modifiedValue'][@type='undefined']"));

		Log.info("Total Number Of element found on screen" + inputFields.size());

		if (inputFields.isEmpty()) {
			Log.info("No Element Found on UI");
		} else {

			for (int i = 1; i <= inputFields.size(); i++) {

				String valueType = driver
						.findElement(By
								.xpath("(//input[@id='modifiedValue'][@type='undefined']/preceding::td[2])[" + i + "]"))
						.getText();
				String modificationAllowed = driver
						.findElement(By
								.xpath("(//input[@id='modifiedValue'][@type='undefined']/preceding::td[1])[" + i + "]"))
						.getText();
				String fieldName = driver
						.findElement(By
								.xpath("(//input[@id='modifiedValue'][@type='undefined']/preceding::td[5])[" + i + "]"))
						.getText();

				String dbModificationAction = DBHandler.AccessHandler.getPreferenceModificationStatus(fieldName);

				if (modificationAllowed.equals(dbModificationAction) && dbModificationAction.equals("Y")) {
					Log.info(fieldName + " is editable");

				} else if (modificationAllowed.equals(dbModificationAction) && dbModificationAction.equals("N")) {
					Log.info(fieldName + " is not editable");
				}

			}

		}

	}

	public void userModifesFieldInNetworkPreferences(String Pref) {

		String value = null;
		WebElement editableInput = null;
		String input = "18";
		WebElement actionValue = null;
		String action = null;
		String oldValue = null;
		String newValue = null;

		switch (Pref) {

		case "NetworkPreferences":
			Log.info("Trying to modify Gap between two SOS recharge ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Gap between two SOS recharge in days ']//following::input[1]")));
			value = editableInput.getText();

			break;

		case "ServiceClassPreferences":

			Log.info("Trying to modify Daily fail txn allowed ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Daily fail txn allowed ']//following::input[1]")));
			value = editableInput.getText();

			break;

		case "ControlPreferences":
			Log.info("Trying to modify Daily fail txn allowed ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Add subscriber card details ']//following::input[1]")));
			value = editableInput.getText();

			break;

		default:
			break;

		}

		Log.info("Already Available Value :" + value);

		Log.info("Trying to Input value : " + input);

		editableInput.clear();

		editableInput.sendKeys(input);

		nscPreferences.clickOnDoneButton();

		actionValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[8]")));

		action = actionValue.getText();

		Log.info("Action Being Performed :" + action);

		oldValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[6]")))
				.getText();

		Log.info("Old Value :" + oldValue);

		newValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[7]")))
				.getText();

		Log.info("New Value :" + newValue);

		// if(action.equals("Modify") && oldValue.equals(value) &&
		// newValue.equals(input)) {
		// Log.info("Action value, old value and new value are matching with provided
		// input");
		nscPreferences.clickOnConfirmButton();
		/*
		 * }else { Log.info("Action value, old value or new value is not matching"); }
		 */

	}

	public void userCancelsModifyProcedure(String Pref) {

		String value = null;
		WebElement editableInput = null;
		String input = "18";
		WebElement actionValue = null;
		String action = null;
		String oldValue = null;
		String newValue = null;

		switch (Pref) {

		case "NetworkPreferences":
			Log.info("Trying to modify Gap between two SOS recharge ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Gap between two SOS recharge in days ']//following::input[1]")));
			value = editableInput.getText();

			break;

		case "ServiceClassPreferences":

			Log.info("Trying to modify Daily fail txn allowed ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Daily fail txn allowed ']//following::input[1]")));
			value = editableInput.getText();

			break;

		case "ControlPreferences":
			Log.info("Trying to modify Daily fail txn allowed ");
			editableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Add subscriber card details ']//following::input[1]")));
			value = editableInput.getText();

			break;

		default:
			break;

		}

		Log.info("Already Available Value :" + value);

		Log.info("Trying to Input value : " + input);

		editableInput.clear();

		editableInput.sendKeys(input);

		nscPreferences.clickOnDoneButton();

		actionValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[8]")));

		action = actionValue.getText();

		Log.info("Action Being Performed :" + action);

		oldValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[6]")))
				.getText();

		Log.info("Old Value :" + oldValue);

		newValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[7]")))
				.getText();

		Log.info("New Value :" + newValue);

		if (action.equals("Modify") && oldValue.equals(value) && newValue.equals(input)) {
			Log.info("Action value, old value and new value are matching with provided input");
			nscPreferences.clickOnCancelButton();

		}
		/*
		 * else { Log.info("Action value, old value or new value is not matching"); }
		 */

		switch (Pref) {

		case "ServiceClassPreferences":

			nscPreferences.serviceClassPreferencesPageLoadedSuccessfully();

			break;

		case "ControlPreferences":

			nscPreferences.controlPreferencePageLoadedSuccessfully();

			break;
		}

	}

	public void checkIfUserIsAbleDeletePreferenceValue(String Pref) {

		WebElement fieldToDelete = null;

		WebElement actionValue = null;
		String action = null;

		nscPreferences.selectShowMaxEntriesOnPage();

		switch (Pref) {

		case "NetworkPreferences":
			Log.info("Trying to modify Gap between two SOS recharge ");
			fieldToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Gap between two SOS recharge in days ']//following::input[2]")));

			break;

		case "ServiceClassPreferences":

			Log.info("Trying to modify Daily fail txn allowed ");
			fieldToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Daily fail txn allowed ']//following::input[2]")));

			break;

		case "ControlPreferences":
			Log.info("Trying to modify Daily fail txn allowed ");
			fieldToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td[text()=' Add subscriber card details ']//following::input[2]")));

			break;

		default:
			break;

		}

		fieldToDelete.click();

		if (fieldToDelete.isSelected()) {
			Log.info("Field to delete is selected successfully");
		} else {
			Log.info("Field to delete is not selected successfully");
		}

		nscPreferences.clickOnDoneButton();

		actionValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@id='ng-select-box-default']//following::div[contains(@class,'ng-star-inserted')]//span[1])[8]")));

		action = actionValue.getText();

		Log.info("Action Being Performed :" + action);

		// if(action.equals("Modify") && oldValue.equals(value) &&
		// newValue.equals(input)) {
		// Log.info("Action value, old value and new value are matching with provided
		// input");
		nscPreferences.clickOnConfirmButton();
		/*
		 * }else { Log.info("Action value, old value or new value is not matching"); }
		 */
	}

	public void getSucessConfirmation() {

		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-basic-title']")));

		String expectedMessage = "Network Preference Updated Successfully";

		String actualMessage = successMessage.getText();

		if (actualMessage.equals(expectedMessage)) {
			Log.info("Modified the detail Successfully");
			Log.info("Trying to click on Done Button");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='anotherRecharge']//span")))
					.click();
			Log.info("Clicked on Done Button");
		} else {
			Log.info("Success Message is not matching");
		}

	}

	public void userSelectsFilterAndProceed(String Pref) {

		WebElement moduleValue = null;

		Log.info("Trying to select service class filter");

		switch (Pref) {
		case "ServiceClassPreferences":

			nscPreferences.clickOnServiceClassDropDown();

			Log.info("Selecting value from service drop down list");

			moduleValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper']//following::span)[1]")));

			moduleValue.click();

			Log.info("Value selected from drop down");

			break;

		case "ControlPreferences":

			nscPreferences.clickOnControlModuleDD();

			moduleValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper']//following::span)[1]")));

			moduleValue.click();

			nscPreferences.clickOnControlTypeDD();

			moduleValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"((//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper'])[2])//following::span[2]")));

			moduleValue.click();

			nscPreferences.clickOnControlPrefDD();

			moduleValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"((//div[@id='ng-select-box-default']//following::span[@class='ng-arrow-wrapper'])[3])//following::span[1]")));

			moduleValue.click();

			break;
		}

		nscPreferences.clickOnProceedButton();
		nscPreferences.preferencesLoadedSuccessfullyAfterProceed();

	}

	public void performModifyAndDeletePreferencesData(String user, String password, String Pref) {
		login.LoginAsUser(driver, user, password);

		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nscPreferences.visibiltyOfPreferenceLink();

		nscPreferences.clickPreferencesLink();

		switch (Pref) {
		case "NetworkPreferences":

			Log.info("Processding with Update Network Prefernces");

			nscPreferences.visibilityOfNetworkPreference();
			nscPreferences.clickOnNetworkPreferences();
			nscPreferences.selectShowMaxEntriesOnPage();

			checkEditableFieldsAndPerformModify();

			userModifesFieldInNetworkPreferences(Pref);

			break;

		case "ServiceClassPreferences":

			Log.info("Processding with Update Service Class Prefernces");

			nscPreferences.visibilityOfServiceClassPreferences();
			nscPreferences.clickOnServiceClassPreferenceLink();
			nscPreferences.serviceClassPreferencesPageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			checkEditableFieldsAndPerformModify();

			userModifesFieldInNetworkPreferences(Pref);

			break;

		case "ControlPreferences":

			Log.info("Processding with Update Control Prefernces");

			nscPreferences.checkVisibilityOfContrlPreferencesLink();
			nscPreferences.clickonControlPreferencesLink();
			nscPreferences.controlPreferencePageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			// checkEditableFieldsAndPerformModify();

			userModifesFieldInNetworkPreferences(Pref);

			break;

		default:
			Log.info("No matching preference was found");

			break;
		}

		getSucessConfirmation();

		Log.info("Preferences Updated Successfully");

		switch (Pref) {

		case "NetworkPreferences":

			checkIfUserIsAbleDeletePreferenceValue(Pref);

			break;

		case "ServiceClassPreferences":

			Log.info("Processding with Update Service Class Prefernces");

			nscPreferences.visibilityOfServiceClassPreferences();
			nscPreferences.clickOnServiceClassPreferenceLink();
			nscPreferences.serviceClassPreferencesPageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			checkIfUserIsAbleDeletePreferenceValue(Pref);

			break;

		case "ControlPreferences":

			Log.info("Processding with Update Control Prefernces");

			nscPreferences.checkVisibilityOfContrlPreferencesLink();
			nscPreferences.clickonControlPreferencesLink();
			nscPreferences.controlPreferencePageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			checkIfUserIsAbleDeletePreferenceValue(Pref);

			break;

		default:
			Log.info("No matching preference was found");
			break;

		}

		getSucessConfirmation();

		Log.info("Preferences Deleted Successfully");

	}

	public void performCancelAndResetPreferencesData(String user, String password, String Pref) {

		login.LoginAsUser(driver, user, password);

		nscPreferences.visibiltyOfPreferenceLink();

		nscPreferences.clickPreferencesLink();

		switch (Pref) {
		case "NetworkPreferences":

			Log.info("Processding with Update Network Prefernces");

			nscPreferences.visibilityOfNetworkPreference();
			nscPreferences.clickOnNetworkPreferences();
			nscPreferences.selectShowMaxEntriesOnPage();

			userCancelsModifyProcedure(Pref);

			break;

		case "ServiceClassPreferences":

			Log.info("Processding with Update Service Class Prefernces");

			nscPreferences.visibilityOfServiceClassPreferences();
			nscPreferences.clickOnServiceClassPreferenceLink();
			nscPreferences.serviceClassPreferencesPageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			userCancelsModifyProcedure(Pref);

			break;

		case "ControlPreferences":

			Log.info("Processding with Update Control Prefernces");

			nscPreferences.checkVisibilityOfContrlPreferencesLink();
			nscPreferences.clickonControlPreferencesLink();
			nscPreferences.controlPreferencePageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			nscPreferences.selectShowMaxEntriesOnPage();

			// checkEditableFieldsAndPerformModify();

			userCancelsModifyProcedure(Pref);

			break;

		default:
			Log.info("No matching preference was found");

			break;
		}

		Log.info("Performing reset and validating");

		switch (Pref) {

		case "NetworkPreferences":

			Log.info("No Reset Option for Network Preferences");

			break;

		case "ServiceClassPreferences":

			Log.info("Processding with Update Service Class Prefernces");

			nscPreferences.visibilityOfServiceClassPreferences();
			nscPreferences.clickOnServiceClassPreferenceLink();
			nscPreferences.serviceClassPreferencesPageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			break;

		case "ControlPreferences":

			Log.info("Processding with Update Control Prefernces");

			nscPreferences.checkVisibilityOfContrlPreferencesLink();
			nscPreferences.clickonControlPreferencesLink();
			nscPreferences.controlPreferencePageLoadedSuccessfully();

			userSelectsFilterAndProceed(Pref);

			break;

		default:

			break;
		}

		nscPreferences.clickOnResetButton();

		if (!nscPreferences.preferencesLoadedSuccessfullyAfterProceed()) {
			Log.info("Reset Executed Successfully");
		} else {
			Log.info("Reset was unscusseful");
		}
	}

}
