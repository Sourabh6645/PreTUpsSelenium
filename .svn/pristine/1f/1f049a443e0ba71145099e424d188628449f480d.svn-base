package angular.feature.TransferRules;

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
import angular.pageobjects.TranferRule.C2SAddModifyDeleteTransferRule;

public class C2S_AddModifyDelete_TransferRule_Feature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	C2SAddModifyDeleteTransferRule transRule;
	WebDriverWait wait;

	public C2S_AddModifyDelete_TransferRule_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		transRule = new C2SAddModifyDeleteTransferRule(driver);
		wait = new WebDriverWait(driver, 20);
	}

	int k = 0;

	// Generic Select Value From DropDown other than ALL if available
	public String selectValueFromDropDown() {

		String value = null;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//span[contains(@class,'ng-option')]"));

		// dropDownListValue =

		if (dropDownListValue.size() == 1) {
			Log.info("Only default value is there to select");
			value = dropDownListValue.get(0).getText();
			dropDownListValue.get(0).click();
		} else if (!dropDownListValue.get(0).getText().equals("All")) {
			value = dropDownListValue.get(0).getText();
			Log.info("Selected value from DD :" + value);
			dropDownListValue.get(0).click();
		} else {
			value = dropDownListValue.get(1).getText();
			Log.info("Selected value from DD :" + value);
			dropDownListValue.get(1).click();

		}

		return value;
	}

	public String validateAllOptionIsSupported() {
		String value = null;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//span[contains(@class,'ng-option')]"));

		// dropDownListValue =

		if (dropDownListValue.size() == 1) {
			Log.info("Only ALL value is there to select");
			value = dropDownListValue.get(0).getText();
			dropDownListValue.get(0).click();
		} else if (dropDownListValue.get(0).getText().equals("All")) {
			value = dropDownListValue.get(0).getText();
			Log.info("Selected value from DD :" + value);
			dropDownListValue.get(0).click();
		} else if (!dropDownListValue.get(0).getText().equals("All")) {

			for (int i = 0; i < dropDownListValue.size(); i++) {
				if (dropDownListValue.get(i).equals("ALL")) {
					value = dropDownListValue.get(i).getText();
					Log.info("Selected value from DD :" + value);
					dropDownListValue.get(i).click();
					break;
				}
			}
		} else {

			Log.info("No Value found for ALL in dropdown");

		}

		return value;
	}

	// Select first value from DropDown i.e. ALL or first value
	public void selectValueAllFromDropDown() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//span[contains(@class,'ng-option')]"));

		// dropDownListValue =

		if (dropDownListValue.get(0).getText().equals("All")) {
			Log.info("Selected option as ALL");
			dropDownListValue.get(0).click();
		} else {
			Log.info("Selected value from DD :" + dropDownListValue.get(0).getText());
			dropDownListValue.get(0).click();
		}

	}

	// Select modification value card group or status
	public void selectValueFromDropDownForModification(String value) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'dropdown-item')]")));

		List<WebElement> dropDownListValue = driver
				.findElements(By.xpath("//button[contains(@class,'dropdown-item')]"));

		// dropDownListValue =

		switch (value) {
		case "cardGroupSet":
			Log.info("Modifying card group set value");
			dropDownListValue.get(3).click();
			break;

		case "status":
			int act = dropDownListValue.size() - 2;
			int suspend = dropDownListValue.size() - 1;
			String status = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("(//button[contains(@class,'btn-sm')])[2]//span")))
					.getText();
			if (status.equals("Active")) {
				dropDownListValue.get(suspend).click();
				Log.info("Transfer rule status updated as SUSPEND");
			} else {
				dropDownListValue.get(act).click();
				Log.info("Transfer rule status updated as ACTIVE");
			}

		}

	}

	// Select Receiver value from DD for add transfer rule
	public void selectReceiverValueFromDropDown(String receiverType) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//span[contains(@class,'ng-option')]"));

		switch (receiverType) {

		case "prepaid":
			Log.info("Selected value from DD :" + dropDownListValue.get(0).getText());
			dropDownListValue.get(0).click();
			break;

		case "postpaid":
			Log.info("Selected value from DD :" + dropDownListValue.get(1).getText());
			dropDownListValue.get(1).click();
			break;

		default:
			Log.info("No matching case found for receiver type DD");
			break;
		}

	}

	// Select card group set value from DD for add transfer rule
	public void selectCardGroupSetDDValue(String serviceType) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		switch (serviceType) {

		case "customer recharge":
			Log.info("Selecting Customer Recharge Drop Down");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Customer Recharge']")))
					.click();
			break;

		default:
			Log.info("No matching case found for service type DD");
			break;
		}
	}

	// Complete single value modification value
	public void selectAndModifyValue(String modifyVia) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<WebElement> searchResult = driver.findElements(By.xpath("//input[@type='checkbox']"));

		if (searchResult.size() > 3) {
			Log.info("Found more than one search result");
		} else {
			Log.info("Trying to select search result to be modified");
			Log.info("Size : " + searchResult.size());
			searchResult.get(2).click();
			try {

				searchResult.get(2).isSelected();
				Log.info("Selected checkbox for modification");
			} catch (Exception e) {
				Log.info("No element is selected for modification");
			}

			switch (modifyVia) {
			case "modifySelectedButton":
				transRule.clickOnModifySelectedButton();
				break;

			case "modifyIcon":
				transRule.clickOnModifyIconFromColumn();
				break;

			default:
				Log.info("Incorrect modification method");
				break;

			}

			transRule.clickOnModifyCardGroupSetDD();
			selectValueFromDropDownForModification("cardGroupSet");
			transRule.clickOnSaveButton();
			transRule.clickOnModifyYesButton();
			transRule.clickOnDoneChangesButton();

		}
	}

	// Complete single value deletion
	public void selectAndDeleteTransferValue(String deleteVia) {

		int countBeforeDelete = 0, countAfterDelete = 0;

		countBeforeDelete = DBHandler.AccessHandler.getC2STransferRuleDeleteCount();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<WebElement> searchResult = driver.findElements(By.xpath("//input[@type='checkbox']"));

		if (searchResult.size() > 3) {
			Log.info("Found more than one search result");
		} else {
			Log.info("Trying to select search result to be modified");
			searchResult.get(2).click();
			try {

				searchResult.get(2).isSelected();
				Log.info("Selected checkbox for modification");
			} catch (Exception e) {
				Log.info("No element is selected for modification");
			}

			switch (deleteVia) {
			case "deleteSelectedButton":
				transRule.clickOnDeleteSelectedButton();
				break;

			case "deleteIcon":
				transRule.clickOnDeleteIconFromColumn();
				break;

			default:
				Log.info("Incorrect modification method");
				break;

			}

			transRule.clickOnModifyYesButton();
			transRule.clickOnDoneChangesButton();

			countAfterDelete = DBHandler.AccessHandler.getC2STransferRuleDeleteCount();

			if ((countBeforeDelete + 1) == countAfterDelete) {
				Log.info("Deleted transfer rule updated to historry table successfully");
			} else {
				Log.info("Deleted transfer rule not updated to historry table successfully");
			}

		}

	}

	// Navigate to C2S Transfer Rule Page
	public void navigateToC2STransferRulePage() {

		if (transRule.visibilityOfChannelToSubscriber()) {
			transRule.clickOnChannelToSubscriberLink();
		} else {
			transRule.visibilityOFTransferRuleLink();
			transRule.clickOnTransferRuleLink();
			transRule.clickOnChannelToSubscriberLink();
		}
	}

	// Perform C2S Add Transfer Rule
	public void performC2SAddTransferRule() {

		Log.info("Performing Add Transfer Rule");

		String defaultGatewayDD = null;

		navigateToC2STransferRulePage();
		// Sender
		transRule.clickOnAddSingleTransferRule();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.checkForAddTransferRulePageLoadedSuccessfully();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		transRule.clickOnHomeButton();
		
		transRule.clickOnChannelToSubscriberLink();
		
		transRule.clickOnAddSingleTransferRule();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.checkForAddTransferRulePageLoadedSuccessfully();
		

		defaultGatewayDD = driver
				.findElement(By.xpath(
						"//div[@id='ng-select-box-default']//following::span[contains(@class,'ng-value-label')]"))
				.getText();

		Log.info("Request Gateway Code Default Selection is : " + defaultGatewayDD);

		transRule.clickOnSenderRequestGatewayCodeDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelDomainDD();
		selectValueFromDropDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transRule.clickOnSenderRequestChannelCategoryDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelGradeDD();
		selectValueFromDropDown();

		// Receiver
		transRule.clickOnReceiverDetailsReceiverTypeDD();
		selectReceiverValueFromDropDown("prepaid");

		transRule.clickOnReceiverDetailsReceiverServiceClassDD();
		selectValueFromDropDown();

		// Card Group
		transRule.clickOnCardGroupSetServiceType();
		selectCardGroupSetDDValue("customer recharge");

		transRule.clickOnCardGroupSetDD();
		selectValueFromDropDown();

		transRule.clickOnSaveButton();

		transRule.visibilityOfReviewAndConfirmTab();

		transRule.clickOnDoneButtonAfterAdd();

		transRule.clickOnTransRuleAddedSuccessfully();

		navigateToC2STransferRulePage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("single");

		String status = driver.findElement(By.xpath("//table[@id='parentTable']//following::td[13]")).getText();

		Log.info("Found status as : " + status);
		if (status.equals("Active")) {
			Log.info("Newly created transfer rule have status as active");
		} else {
			Log.info("Transfer rule status is not active");
		}

		Log.info("Added Transfer Rule Successfully");
	}

	// Calling single Modify
	public void performC2SViewAndModifyTransferRule(String modifyVia) {

		Log.info("Performing view and modify transfer rule");

		navigateToC2STransferRulePage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("single");

		selectAndModifyValue(modifyVia);

		Log.info("Performed View and Modify Transfer Rule");
	}

	// Calling Single Delete
	public void performC2SDeleteTransferRule(String deleteVia) {

		Log.info("Performing view and Delete transfer rule");

		navigateToC2STransferRulePage();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("single");

		selectAndDeleteTransferValue(deleteVia);

		Log.info("Performed View and Delete Transfer Rule");
	}

	// Select Multiple and modify
	public void performMultipleSelectAndUpdate() {

		Log.info("Performing Multiple select and update");

		navigateToC2STransferRulePage();
		// Sender
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("all");
		selectMaxValueOnScreen();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> listOfElements = driver.findElements(By.xpath("//input[@type='checkbox']"));

		listOfElements.get(0).click();

		checkIfAllElementsAreSelected(listOfElements);

		transRule.clickOnModifySelectedButton();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(@class,'btn-sm')]")));

		selectMaxValueOnScreen();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//button[contains(@class,'btn-sm')]"));

		checkIfElementIsEnabled(dropDownListValue);

		Log.info("Selecte multiple and update executed successfully");

	}

	public void performMultipleSelectAndDelete() {

		Log.info("Performing Multiple select and delete");

		navigateToC2STransferRulePage();
		// Sender
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("all");
		selectMaxValueOnScreen();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> listOfElements = driver.findElements(By.xpath("//input[@type='checkbox']"));

		listOfElements.get(0).click();

		checkIfAllElementsAreSelected(listOfElements);

		transRule.clickOnDeleteSelectedButton();

		transRule.clickOnModifyNoButton();

		Log.info("Selecte multiple and delete executed successfully");

	}

	public void checkIfElementIsEnabled(List<WebElement> list) {
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isEnabled()) {
				value++;
			}
		}
		if (value == list.size()) {
			Log.info("All the elements can be modified");
		}
	}

	public void checkIfAllElementsAreSelected(List<WebElement> list) {
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i != 1) {
				list.get(i).isSelected();
				value++;
			}
		}

		if (value == (list.size() - 1)) {
			Log.info("All elements are selected");
		}
	}

	public void selectMaxValueOnScreen() {
		WebElement showEntryDD = driver.findElement(By.xpath("//select[@name='parentTable_length']"));
		showEntryDD.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option")));
		List<WebElement> totalEntries = driver.findElements(By.xpath("//option"));
		totalEntries.get(totalEntries.size() - 1).click();
	}

	public void selectViewFilterValue(String value) {

		switch (value) {
		case "single":
			transRule.clickOnViewGatewayDD();
			selectValueFromDropDown();

			transRule.clickOnViewDomainDD();
			selectValueFromDropDown();

			transRule.clickOnViewCategoryDD();
			selectValueFromDropDown();

			transRule.clickOnViewGradeDD();
			selectValueFromDropDown();

			transRule.clickOnViewStatusDD();
			selectValueFromDropDown();

			break;

		case "all":
			transRule.clickOnViewGatewayDD();
			selectValueAllFromDropDown();

			transRule.clickOnViewDomainDD();
			selectValueAllFromDropDown();

			transRule.clickOnViewCategoryDD();
			selectValueAllFromDropDown();

			transRule.clickOnViewGradeDD();
			selectValueAllFromDropDown();

			transRule.clickOnViewStatusDD();
			selectValueAllFromDropDown();

			break;

		default:
			Log.info("No correct option found");
			break;
		}

		transRule.clickOnViewFilterProceed();
		transRule.checkForSearchResultVisible();
	}

	public void performAddModifyAndDeleteTransferRule(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		// Add Transfer Rule

		performC2SAddTransferRule();

		// View and Modify Transfer Rule

		performC2SViewAndModifyTransferRule("modifySelectedButton");

		performC2SDeleteTransferRule("deleteSelectedButton");

	}

	public void performAddModifyAndDeleteTransferRuleUingColumnIcon(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		// Add Transfer Rule

		performC2SAddTransferRule();

		// View and Modify Transfer Rule

		performC2SViewAndModifyTransferRule("modifyIcon");

		performC2SDeleteTransferRule("deleteIcon");
	}

	public void userIsAbleToSelectMultipleTransferRuleForModify(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		performMultipleSelectAndUpdate();
	}

	public void userIsAbleToSelectMultipleTransferRuleForDelete(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		performMultipleSelectAndDelete();
	}

	public void userIsAbleToResetAllViewFilterValue(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		navigateToC2STransferRulePage();

		// Sender
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		selectViewFilterValue("all");
		selectMaxValueOnScreen();

		transRule.clickOnViewFilterReset();

		if (transRule.checkForSearchResultVisible()) {
			Log.info("Page reset was not successful");
		} else {
			Log.info("Page reset was successful");
			List<WebElement> viewDD = driver.findElements(
					By.xpath("//label[contains(@for,'gatewayCode')]//following::div[@class='ng-placeholder']"));
			for (int i = 0; i < viewDD.size(); i++) {
				Log.info("Current Dropdown value : " + viewDD.get(i).getText());
			}
		}

	}

	public void userIsNotAbleToSubmitMultipleTransactionRuleWithDuplicateEntries(String loginid, String password) {
		login.LoginAsUser(driver, loginid, password);

		Log.info("Performing Add Multiple Transfer Rule");

		navigateToC2STransferRulePage();
		// Sender
		transRule.clickOnAddSingleTransferRule();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.checkForAddTransferRulePageLoadedSuccessfully();

		transRule.clickOnSenderRequestGatewayCodeDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelDomainDD();
		selectValueFromDropDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transRule.clickOnSenderRequestChannelCategoryDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelGradeDD();
		selectValueFromDropDown();

		// Receiver
		transRule.clickOnReceiverDetailsReceiverTypeDD();
		selectReceiverValueFromDropDown("prepaid");

		transRule.clickOnReceiverDetailsReceiverServiceClassDD();
		selectValueFromDropDown();

		// Card Group
		transRule.clickOnCardGroupSetServiceType();
		selectCardGroupSetDDValue("customer recharge");

		transRule.clickOnCardGroupSetDD();
		selectValueFromDropDown();

		// Adding extra rule
		transRule.clickOnAddExtraRuleButton();

		transRule.clickOnSenderRequestGatewayCodeDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelDomainDD();
		selectValueFromDropDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transRule.clickOnSenderRequestChannelCategoryDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelGradeDD();
		selectValueFromDropDown();

		// Receiver
		transRule.clickOnReceiverDetailsReceiverTypeDD();
		selectReceiverValueFromDropDown("prepaid");

		transRule.clickOnReceiverDetailsReceiverServiceClassDD();
		selectValueFromDropDown();

		// Card Group
		transRule.clickOnCardGroupSetServiceType();
		selectCardGroupSetDDValue("customer recharge");

		transRule.clickOnCardGroupSetDD();
		selectValueFromDropDown();

		// Final Validation

		transRule.clickOnSaveButton();

		WebElement alertIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='assets/images/failed_icons/png/cancel.png']")));

		if (alertIcon.isDisplayed()) {
			Log.info("No Duplicate Entries are allowed while adding transfer rule");
		} else {
			Log.info("User is able to add multiple duplicate entries");
		}

		transRule.clickOnDoneButtonAfterErrorOnAddTransferRule();
	}

	public void userIsAbleToUseDuplicateValueFeature(String loginid, String password) {

		login.LoginAsUser(driver, loginid, password);

		Log.info("Performing Add Multiple Transfer Rule");

		navigateToC2STransferRulePage();
		// Sender
		transRule.clickOnAddSingleTransferRule();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.checkForAddTransferRulePageLoadedSuccessfully();

		transRule.clickOnSenderRequestGatewayCodeDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelDomainDD();
		selectValueFromDropDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transRule.clickOnSenderRequestChannelCategoryDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelGradeDD();
		selectValueFromDropDown();

		// Receiver
		transRule.clickOnReceiverDetailsReceiverTypeDD();
		selectReceiverValueFromDropDown("prepaid");

		transRule.clickOnReceiverDetailsReceiverServiceClassDD();
		selectValueFromDropDown();

		// Card Group
		transRule.clickOnCardGroupSetServiceType();
		selectCardGroupSetDDValue("customer recharge");

		transRule.clickOnCardGroupSetDD();
		selectValueFromDropDown();

		// Adding Duplicate Rule

		transRule.clickOnDuplicateRuleButton();

		List<WebElement> transRuleValue = driver.findElements(By.xpath(
				"//label[contains(@for,'gatewayCode')]//following::div[@class='ng-placeholder']//following::span[2]"));

		List<WebElement> viewDD = driver.findElements(
				By.xpath("//label[contains(@for,'gatewayCode')]//following::div[@class='ng-placeholder']"));
		int selectCount = 0;
		for (int i = 15; i < viewDD.size(); i++) {
			if (viewDD.get(i).getText().equals("Select")) {
				selectCount++;
			}
		}

		int ruleDDSize = transRuleValue.size() / 2;
		int count = 0;
		for (int i = 0, j = 9; i < ruleDDSize - 3; i++, j++) {
			Log.info("Test Values i:" + i + " " + transRuleValue.get(i).getText() + " : j :" + j + " "
					+ transRuleValue.get(j).getText());
			if (transRuleValue.get(i).getText().equals(transRuleValue.get(j).getText())) {
				count++;
			}
		}
		Log.info("Valid values : " + selectCount + " " + count);
		if (count == 5 || selectCount == 3) {
			Log.info("Transfer Rule duplication verified successfully");
		} else {
			Log.info("Transfer Rule duplication failed");
		}
	}

	public void AllOptionSupportedForCategoryGradeAndReceiverServiceClass(String loginid, String password) {
		login.LoginAsUser(driver, loginid, password);

		Log.info("Performing Add Transfer Rule To Validate All Option For Category, Grade and Receiver Service Class");

		navigateToC2STransferRulePage();
		// Sender
		transRule.clickOnAddSingleTransferRule();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.checkForAddTransferRulePageLoadedSuccessfully();

		transRule.clickOnSenderRequestGatewayCodeDD();
		selectValueFromDropDown();

		transRule.clickOnSenderRequestChannelDomainDD();
		selectValueFromDropDown();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Validation
		transRule.clickOnSenderRequestChannelCategoryDD();
		validateAllOptionIsSupported();

		transRule.clickOnSenderRequestChannelGradeDD();
		validateAllOptionIsSupported();

		// Receiver
		transRule.clickOnReceiverDetailsReceiverTypeDD();
		selectReceiverValueFromDropDown("prepaid");

		transRule.clickOnReceiverDetailsReceiverServiceClassDD();
		validateAllOptionIsSupported();

		Log.info("Validation Successful for All Option For Category, Grade and Receiver Service Class");
	}
}
