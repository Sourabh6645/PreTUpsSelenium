package angular.feature;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;

import angular.classes.LoginRevamp;
import angular.pageobjects.NetworkServices.NetworkServices_PageObject;

public class NetworkServices_Feature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	NetworkServices_PageObject NS;
	WebDriverWait wait;
	RandomGeneration randomgen;

	ArrayList<String> LangvalueBeforeReset = new ArrayList<String>();
	ArrayList<String> LangvalueAfterReset = new ArrayList<String>();
	ArrayList<String> StatusvalueBeforeReset = new ArrayList<String>();
	ArrayList<String> StatusvalueAfterReset = new ArrayList<String>();
	String value;

	List<WebElement> ddValueList = null;
	List<WebElement> ddList = null;
	List<WebElement> errorMsg = null;
	List<WebElement> currentValue = null;
	List<WebElement> textBox = null;

	// Error messages
	String definedErrmsg1 = "Module is required.";
	String definedErrmsg2 = "Service type is required";

	public NetworkServices_Feature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		NS = new NetworkServices_PageObject(driver);
		randomgen = new RandomGeneration();
	}

	public String selectValueFromDD() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ddValueList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		String value = ddValueList.get(0).getText();
		ddValueList.get(0).click();

		return value;
	}

	public void RechargeServiceStatusDD() {
		Log.info("Trying to select Service status values from DD");
		ddList = driver
				.findElements(By.xpath("//td[@id = 'status']//following::span[contains(@class , 'ng-arrow-wrapper')]"));
		currentValue = driver.findElements(By.xpath("//td//following::span[contains(@class, 'ng-value-label')]"));
		for (int i = 0; i < ddList.size(); i++) {
			String currentStatusValue = currentValue.get(i).getText();
			StatusvalueBeforeReset.add(i, currentStatusValue);
			ddList.get(i).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ddValueList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
			if (StatusvalueBeforeReset.get(i).equals("Suspended")) {
				value = ddValueList.get(0).getText();
				ddValueList.get(0).click();
			} else {
				value = ddValueList.get(1).getText();
				ddValueList.get(1).click();
			}

		}

		Log.info("Values Selected in DD");
	}

	public void getStatusValueAfterReset() {
		ddList = driver
				.findElements(By.xpath("//td[@id = 'status']//following::span[contains(@class , 'ng-arrow-wrapper')]"));
		currentValue = driver.findElements(By.xpath("//td//following::span[contains(@class, 'ng-value-label')]"));
		for (int i = 0; i < ddList.size(); i++) {

			StatusvalueAfterReset.add(i, currentValue.get(i).getText());
			value = currentValue.get(i).getText();
		}
		Log.info("Status value stored After Reset");

	}

	public void compareStatusValuesBeforeAndAfterReset() {
		for (int i = 0; i < StatusvalueBeforeReset.size(); i++) {
			String valuesBeforeReset = StatusvalueBeforeReset.get(i);
			String valuesAfterReset = StatusvalueAfterReset.get(i);

			if (valuesBeforeReset.equals(valuesAfterReset)) {
				Log.info("Value at index " + i + " remains the same after reset: " + StatusvalueBeforeReset);
			} else {
				Log.info("Value at index " + i + " changed after reset. Before: " + StatusvalueBeforeReset + ", After: "
						+ StatusvalueAfterReset);
			}
		}
		Log.info("Before and after status values compared");
	}

	public void InputLanguage() {
		Log.info("Entering language values");
		textBox = driver.findElements(By.xpath("//textarea"));

		for (int i = 0; i < textBox.size(); i++) {

			textBox.get(i).clear();
			String valueLang = randomgen.randomAlphabets(20);
			textBox.get(i).sendKeys(valueLang);
		}
		Log.info("Entered language values");
	}

	public void getLangValueBeforeReset() {
		textBox = driver.findElements(By.xpath("//textarea"));
		for (int i = 0; i < textBox.size(); i++) {
			value = textBox.get(i).getText();
			LangvalueBeforeReset.add(i, value);
		}
		Log.info("Language value before reset stored");
	}

	public void getLangValueAfterReset() {
		textBox = driver.findElements(By.xpath("//textarea"));
		for (int i = 0; i < textBox.size(); i++) {
			value = textBox.get(i).getText();
			LangvalueAfterReset.add(i, value);
		}
		Log.info("Language value after reset stored");
	}

	public void compareLangValuesBeforeAndAfterReset() {
		for (int i = 0; i < LangvalueBeforeReset.size(); i++) {
			String valuesBeforeReset = LangvalueBeforeReset.get(i);
			String valuesAfterReset = LangvalueAfterReset.get(i);

			if (valuesBeforeReset.equals(valuesAfterReset)) {
				Log.info("Value at index " + i + " remains the same after reset: " + LangvalueBeforeReset);
			} else {
				Log.info("Value at index " + i + " changed after reset. Before: " + LangvalueBeforeReset + ", After: "
						+ LangvalueAfterReset);
			}
		}
		Log.info("Before and after language values compared");
	}

	public void ValidationCheck() {
		errorMsg = driver.findElements(By.xpath("(//span[contains(@class, 'errorMessage')])"));

		String Errvalue1 = errorMsg.get(0).getText();
		String Errvalue2 = errorMsg.get(1).getText();
		if (Errvalue1.equals(definedErrmsg1) && Errvalue2.equals(definedErrmsg2)) {
			Log.info("Getting error messages when proceeding without selecting values from DD");
		} else {
			Log.info("error messages not validated");
		}
	}

	public void ModifyNetworkServices(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		NS.clickOnNetworkServices();
		NS.checkNetworkServicesPageLoadedSuccessfully();
		NS.clickOnModuleDD();
		String module = selectValueFromDD();
		NS.clickOnSerivceTypeDD();
		String ServiceType = selectValueFromDD();
		NS.clickOnFiltersProceedbtn();
		NS.checkVisibilityOfModifyServicesStatus();
		RechargeServiceStatusDD();
		InputLanguage();
		NS.clickOnModifyServiceStatusBtn();
		NS.checkVisibilityOfSuccessWindow();
		NS.clickOnDoneBtn();
	}

	public void ResetmodifyServices_And_ResetFilter(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		NS.clickOnNetworkServices();
		NS.clickOnModuleDD();
		String module = selectValueFromDD();
		NS.clickOnSerivceTypeDD();
		String ServiceType = selectValueFromDD();
		NS.clickOnFiltersProceedbtn();
		RechargeServiceStatusDD();
		Log.info("Status value stored before Reset");
		getLangValueBeforeReset();
		InputLanguage();
		NS.clickOnResetServiceStatusBtn();
		getStatusValueAfterReset();
		compareStatusValuesBeforeAndAfterReset();
		getLangValueAfterReset();
		compareLangValuesBeforeAndAfterReset();
		NS.clickOnFiltersResetbtn();
		Log.info("Click on Proceed button without selecting any values from DD");
		NS.clickOnFiltersProceedbtn();
		ValidationCheck();
	}
}
