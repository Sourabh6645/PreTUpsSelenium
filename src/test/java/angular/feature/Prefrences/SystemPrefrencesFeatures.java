package angular.feature.Prefrences;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.commons.PretupsI;
import com.dbrepository.DBHandler;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.Preferances.SystemPreferencesPageObject;

public class SystemPrefrencesFeatures extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait = null;
	LoginRevamp login = null;
	SystemPreferencesPageObject spp = null;

	public SystemPrefrencesFeatures(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		spp = new SystemPreferencesPageObject(driver);
	}

	public void modifySystemPreferencesUnderPeer2Peer(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);

		spp.clickOnETopUpTab();
		spp.clickOnPreferenceLink();

		spp.checkPreferencesPageLoadedSuccessfully();

		spp.clickOnModuleTypeDD();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")));
		spp.selectPeer2PeerOptionFromDD();

		spp.clickOnPreferenceTypeDDButton();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")));
		spp.selectSystemPreferenceOptionFromDD();

		spp.clickOnProceedButton();

		spp.checkSearchResultsLoadedSuccessfully();
		spp.selectMaxEntriesOnPage();

		List<WebElement> valueModificationAllowed = driver
				.findElements(By.xpath("//td[@id='msisdn']//following-sibling::td[2]"));
		List<WebElement> valueField = driver.findElements(By.xpath("//input[@id='modifiedValue']"));

		Log.info("Size of modification allowed : " + valueModificationAllowed.size());
		Log.info("Size of value field : " + valueField.size());

		for (int i = 0; i < valueModificationAllowed.size(); i++) {
			Log.info("Value Found : " + valueModificationAllowed.get(i).getText());
			String readonly = valueField.get(i).getAttribute("readonly");
			Log.info("Input validation : " + readonly);

			if (valueModificationAllowed.get(i).getText().equals("N") && readonly.equals("true")) {
				Log.info("Field Is Disabled");
			} else if (valueModificationAllowed.get(i).getText().equals("Y")) {
				Log.info("Field Is Enabled");
			} else {
				Log.info("Unable to confirm the field");
			}
		}
	}

	public void SystemPreferences_errorMessageShown_IfUserProceed_WithoutSelectingDDValues(String loginId,
			String password) {

		login.LoginAsUser(driver, loginId, password);

		spp.clickOnETopUpTab();
		spp.clickOnPreferenceLink();

		spp.checkPreferencesPageLoadedSuccessfully();
	}
	
	
}
