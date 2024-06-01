package angular.feature.MessageGateway;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;

import angular.classes.LoginRevamp;
import angular.pageobjects.MessageGateway.GatewayMappingPageObject;
import angular.pageobjects.MessageGateway.MessageGatewayPageObject;

public class MessageGatewayFeature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	WebDriverWait wait;
	MessageGatewayPageObject mgpo;
	GatewayMappingFeature gmf;
	GatewayMappingPageObject gmpo;
	RandomGeneration random;

	String gatewayCode = null;
	String gatewayName = null;
	String hostValue = "10.0.0.0";
	String requestDetailsServicePort = "10";
	String requestDetailsTextInput = "testLogin";
	String pushDetailsPort = "20";
	String pushDetailsTextInput = "testLogintest";
	String pushDetailsDestinationNumber = "30";
	String timeOut = "2000";
	String modifyiedGatewayValue = null;
	String readonly = null;

	public MessageGatewayFeature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		mgpo = new MessageGatewayPageObject(driver);
		gmf = new GatewayMappingFeature(driver);
		gmpo = new GatewayMappingPageObject(driver);
		random = new RandomGeneration();

		gatewayName = gatewayCode = random.randomAlphabets(6);
		modifyiedGatewayValue = random.randomAlphabets(6);
	}

	public void selectValueFromDD(int index) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")));
		List<WebElement> dropdownValues = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		if (dropdownValues.size() == 0) {
			Log.info("No Value Found");
		} else {
			String selectedValue = dropdownValues.get(index).getText();
			dropdownValues.get(index).click();
			Log.info("Selected value from DD list" + selectedValue);
		}
	}

	public void checkDisabledElementsDuringModiy() {
		Log.info("Checking if gateway code is readony");
		readonly = driver.findElement(By.id("gatewayCode")).getAttribute("readonly");
		Log.info("Input validation : " + readonly);

		Log.info("Checking if gateway type is readony");
		readonly = driver.findElement(By.id("domain")).getAttribute("disabled");
		Log.info("Input validation : " + readonly);

		Log.info("Checking if gateway sub type is readony");
		readonly = driver.findElement(By.id("category")).getAttribute("disabled");
		Log.info("Input validation : " + readonly);
	}

	public void addMessageGateway() {
		Log.info("Creating Message Gateway");
		mgpo.clickOnETopUPButton();
		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();
		mgpo.clickAddMessageGatewayDetailsButton();
		mgpo.checkAddMessageGatewayPageLoadedSuccessfully();
		mgpo.insertGatewayCode(gatewayCode);
		mgpo.insertGatewayName(gatewayName);
		mgpo.clickOnGatewayTypeDDButton();
		selectValueFromDD(0);
		mgpo.clickOnGatewaySubTypeDDButton();
		selectValueFromDD(0);
		mgpo.clickOnGatewayProtocolDDButton();
		selectValueFromDD(0);
		mgpo.insertHostValue(hostValue);

		if (!mgpo.requestDetailsCheckBoxStatus()) {
			mgpo.selectRequestDetailsCheckBox();
			mgpo.insertRequestDetailsPort(requestDetailsServicePort);
			mgpo.clickOnAuthrizationTypeDDButton();
			selectValueFromDD(1);
			mgpo.insertRequestDetailsloginId(requestDetailsTextInput);
			mgpo.insertRequestDetailsPass(requestDetailsTextInput);
			mgpo.insertRequestDetailsConfirmPass(requestDetailsTextInput);
			mgpo.clickOnRequestDetailsStatusDDButton();
			selectValueFromDD(0);
			mgpo.clickOnRequestDetailsContentTypeDDButton();
			selectValueFromDD(0);
			mgpo.clickOnRequestDetailsEncryptionLevelDDButton();
			selectValueFromDD(0);
			mgpo.insertRequestDetailsKey(requestDetailsTextInput);
		}

		if (!mgpo.pushDetailsCheckBoxStatus()) {
			mgpo.selectPushDetailsCheckBox();
			mgpo.insertPushDetailsPort(pushDetailsPort);
			mgpo.clickOnPushDetailsStatuesDDButton();
			selectValueFromDD(0);
			mgpo.insertPushetDetailsloginId(pushDetailsTextInput);
			mgpo.insertPushDetailsPass(requestDetailsTextInput);
			mgpo.insertPushDetailsConfirmPass(requestDetailsTextInput);
			mgpo.insertPushetDetailsDestinationNumber(pushDetailsDestinationNumber);
			mgpo.insertPushDetailsTimeOut(timeOut);
			mgpo.insertPushDetailsPath(pushDetailsTextInput);
		}

		mgpo.clickOnSubmitButton();
		mgpo.CheckReviewAndConfirmPageLoadedSuccessfully();

		List<WebElement> reviewAndConfirmLabel = driver
				.findElements(By.xpath("//div[@id='modal-basic-title']//following::label"));

		if (reviewAndConfirmLabel.size() == 44) {
			Log.info("Review and Confirm all elements loaded successfully");
		} else {
			Log.info("Review and Confirm all elements not loaded successfully");
		}

		mgpo.clickOnReviewAndConfirmConfirmButton();
		mgpo.checkForSuccessMessageWindow();
		mgpo.clickOnDoneButton();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

	}

	public void alreadyExistingGatewayName() {

		Log.info("Creating Message Gateway");
		mgpo.clickOnETopUPButton();
		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

		String gatewayUsedName = driver.findElement(By.xpath("(//tr[contains(@class,'denoTableHeader')])[3]//td[2]"))
				.getText();
		
		mgpo.clickAddMessageGatewayDetailsButton();
		mgpo.checkAddMessageGatewayPageLoadedSuccessfully();
		mgpo.insertGatewayCode(gatewayUsedName);
		mgpo.insertGatewayName(gatewayUsedName);
		mgpo.clickOnGatewayTypeDDButton();
		selectValueFromDD(0);
		mgpo.clickOnGatewaySubTypeDDButton();
		selectValueFromDD(0);
		mgpo.clickOnGatewayProtocolDDButton();
		selectValueFromDD(0);
		mgpo.insertHostValue(hostValue);

		mgpo.clickOnSubmitButton();
		mgpo.CheckReviewAndConfirmPageLoadedSuccessfully();

		mgpo.clickOnReviewAndConfirmConfirmButton();
		mgpo.checkForErrorMessageWindow();

		String errorMessage = driver.findElement(By.xpath("//div[contains(@id,'failuremsg')]")).getText();

		Log.info("Error Message Found on Screen" + errorMessage);

		mgpo.clickOnDoneButton();

	}

	public void modifyMessageGateway() {
		Log.info("Modifying Message Gateway");
		mgpo.clickOnETopUPButton();
		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

		mgpo.insertSearchValue(gatewayName);
		mgpo.clickOnEditActionButton();
		mgpo.checkAddMessageGatewayPageLoadedSuccessfully();

		checkDisabledElementsDuringModiy();
		mgpo.modifyGatewayName(modifyiedGatewayValue);

		if (mgpo.requestDetailsCheckBoxStatus()) {
			mgpo.clickOnRequestDetailsStatusDDButton();
			selectValueFromDD(1);
		}

		if (mgpo.pushDetailsCheckBoxStatus()) {
			mgpo.clickOnPushDetailsStatuesDDButton();
			selectValueFromDD(1);
		}

		mgpo.clickOnSubmitButton();
		mgpo.CheckReviewAndConfirmPageLoadedSuccessfully();
		mgpo.clickOnReviewAndConfirmConfirmButton();
		mgpo.checkForSuccessMessageWindow();
		mgpo.clickOnDoneButton();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();
	}

	public void deleteMessageGateway() {
		Log.info("Deleting Message Gateway");

		mgpo.clickOnETopUPButton();

		gmpo.clickOnGatewayMappingLink();
		gmpo.checkGatewayMappingLoadedSuccessfully();
		gmf.deleteGatewayMapping(modifyiedGatewayValue);

		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

		mgpo.insertSearchValue(modifyiedGatewayValue);
		mgpo.clickOnDeleteActionButton();
		mgpo.checkDeleteActionConfirmationprompt();
		mgpo.confirmDeleteAction();
		mgpo.checkForSuccessMessageWindow();
		mgpo.clickOnDoneButton();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

	}

	public void AddModifyDelete_MessageGateway(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);
		addMessageGateway();
		modifyMessageGateway();
		deleteMessageGateway();
	}

	public void MessageGatewayTableHeading(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);
		mgpo.clickOnETopUPButton();

		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();

		List<WebElement> tableHeaders = driver.findElements(By.xpath("(//tr[@class='denoTableHeader'])[1]//th"));

		for (int i = 1; i < tableHeaders.size(); i++) {
			Log.info(i + "Table Hrader Found : " + tableHeaders.get(i).getText());
		}
	}

	public void MessageGatewayCheck_ErrorMessage(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);

		mgpo.clickOnETopUPButton();
		mgpo.clickOnMessageGatewayLink();
		mgpo.checkMessageGatewayPageLoadedSuccessfully();
		mgpo.clickAddMessageGatewayDetailsButton();
		mgpo.checkAddMessageGatewayPageLoadedSuccessfully();

		mgpo.clickOnSubmitButton();

		List<WebElement> errorMessageList = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'errorMessage')]//div")));

		if (errorMessageList.size() == 6) {
			Log.info("All error messages loaded successfully");
		} else {
			Log.info("All error messages not loaded successfully");
		}

		for (int i = 0; i < errorMessageList.size(); i++) {
			Log.info("Error message found on screen" + errorMessageList.get(i).getText());
		}
	}

	public void MessageGateway_VerifyErrorMessage_UponProviding_exitingGatewayName(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);

		alreadyExistingGatewayName();
	}

}
