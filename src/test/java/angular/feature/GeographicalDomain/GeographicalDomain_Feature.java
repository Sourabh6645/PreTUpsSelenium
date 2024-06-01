package angular.feature.GeographicalDomain;

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
import angular.pageobjects.GeographicalDomain.GeographicalDomain_PageObject;


public class GeographicalDomain_Feature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	GeographicalDomain_PageObject gdp;
	WebDriverWait wait;
	RandomGeneration random;

	String zone = null;
	String modifyZone = null;
	String area = null;
	String subArea = null;

	public GeographicalDomain_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		gdp = new GeographicalDomain_PageObject(driver);
		random = new RandomGeneration();
		wait = new WebDriverWait(driver, 20);
		zone = random.randomAlphabets(5);
		modifyZone = random.randomAlphabets(5);
		area = random.randomAlphabets(5);
		subArea = random.randomAlphabets(5);
	}

	public void navigateToGeographicalDomainManagementPage() {
		Log.info("Trying to navigate to Geographical Domain page");
		gdp.clickOnGeographicalDomainLink();
		gdp.checkIfGeoDomainManagementPageLoadedSuccessfully();
		Log.info("Navigated to Geographical Domain Page");
	}

	public void selectGeographicalDomainType(String value) {

		Log.info("Trying to select geographical domain type");

		gdp.clickOnDomainTypeDD();

		switch (value) {

		case "ZONE":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[1]"))).click();
			Log.info("Selected domain type as : " + value);
			break;

		case "AREA":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[2]"))).click();
			Log.info("Selected domain type as : " + value);
			break;

		case "SUBAREA":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='option'])[3]"))).click();
			Log.info("Selected domain type as : " + value);
			break;

		default:
			Log.info("Shared drop down option is not correct : " + value);
			break;
		}
	}

	public void insertCreateGeoDomainValue(String value) {
		Log.info("Inserting Geo Domain values for creation");
		gdp.checkAddGeographicalDomainPageLoadedSuccessfully();
		gdp.insertGeoDomainCode(value);
		gdp.insertGeoDomainName(value);
		gdp.insertGeoDomainShortName(value);
		gdp.insertGeoDescription(value);
		gdp.clickOnStatusDD();
		gdp.selectGeoDomainStatusValue("ACTIVE");
		gdp.setDefaultGeographicalDomain("NO");
		Log.info("Geo Domain value inserted successful");
	}

	public void navigateToModifyScreen() {
		Log.info("Trying to navigate to modify screen");
		if (!gdp.checkIfGeoDomainManagementPageLoadedSuccessfully()) {
			navigateToGeographicalDomainManagementPage();
		}
		selectGeographicalDomainType("ZONE");
		gdp.clickOnProceedButton();
		gdp.inputSearchField(zone);
		gdp.clickOnModifyIcon();
		gdp.checkAddGeographicalDomainPageLoadedSuccessfully();
		Log.info("Navigated to modify screen successfully");
	}

	public void navigateToDeleteScreen(String value) {
		Log.info("Trying to navigate to Delete screen");
		if (!gdp.checkIfGeoDomainManagementPageLoadedSuccessfully()) {
			navigateToGeographicalDomainManagementPage();
		}
		if(value.equals(zone) || value.equals(modifyZone)) {
			selectGeographicalDomainType("ZONE");
			gdp.clickOnProceedButton();
		}else if(value.equals(area)) {
			inputZoneAndProceedWithSelection("NONE");
		}else if(value.equals(subArea)) {
			inputZoneAndAreaForSubAreaCreation("NONE");
		}else {
			Log.info("Incorrect value recieved");
		}
		gdp.inputSearchField(value);
		gdp.clickOnDeleteIcon();
		Log.info("Navigated to delete screen successfully");
	}

	public void insertModifyCurrentValues() {
		Log.info("Trying to insert new modify values");
		gdp.checkModifyGeoDomainCodeIsNotEditable();
		gdp.insertGeoDomainName(modifyZone);
		gdp.insertGeoDomainShortName(modifyZone);
		gdp.insertGeoDescription(modifyZone);
		Log.info("Inserted modify value in the fields");
	}
	
	public void inputZoneAndProceedWithSelection(String action) {
		Log.info("Inserting zone value and proceeding to add process");
		gdp.inputZoneSearchField(zone);
		gdp.clickOnProceedButton();

		if(action.equals("ADD")) {
			gdp.clickOnAddButton();
		}
	}
	
	public void inputZoneAndAreaForSubAreaCreation(String action) {
		Log.info("Inserting zone and subarea value for add subarea process");
		gdp.inputZoneSearchField(zone);
		gdp.inputAreaSearchField(area);
		gdp.clickOnProceedButton();
		
		if(action.equals("ADD")) {
			gdp.clickOnAddButton();
		}
	}
	
	public void AddModifyDelete_GeoDomainZone(String user, String password) {
		Log.info("Creating Geo Domain Zone");
		login.LoginAsUser(driver, user, password);
		navigateToGeographicalDomainManagementPage();
		selectGeographicalDomainType("ZONE");
		gdp.clickOnProceedButton();
		gdp.clickOnAddButton();
		insertCreateGeoDomainValue(zone);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain Zone Created Successfully");

		Log.info("Modifying Geo Domain Zone Value");
		navigateToModifyScreen();
		insertModifyCurrentValues();
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo domain zone values modified successfully");

		Log.info("Deleting Geo Domain Zone value");
		navigateToDeleteScreen(modifyZone);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain Zone value");

	}
	
	public void resetGeoDomainZoneValue_CheckErrorForRequiredFieldError(String user, String password) {
		
		Log.info("Creating Geo Domain Zone");
		login.LoginAsUser(driver, user, password);
		navigateToGeographicalDomainManagementPage();
		selectGeographicalDomainType("ZONE");
		gdp.clickOnProceedButton();
		gdp.clickOnAddButton();
		insertCreateGeoDomainValue(zone);
		gdp.clickOnResetButton();
		gdp.clickOnProceedButton();
		
		List<WebElement> requiredErrorMessage = driver.findElements(By.xpath("//div[contains(@class,'errorMessage')]//following-sibling::div"));
		if(requiredErrorMessage.size() == 4) {
			Log.info("Validated error message is displayed upon missing required field");
		}else {
			Log.info("No error message is displayed as field are not reset");
		}
	}
	
	public void AddModifyDelete_GeoDomainArea(String user, String password) {
		Log.info("Creating Geo Domain Zone");
		login.LoginAsUser(driver, user, password);
		navigateToGeographicalDomainManagementPage();
		selectGeographicalDomainType("ZONE");
		gdp.clickOnProceedButton();
		gdp.clickOnAddButton();
		insertCreateGeoDomainValue(zone);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain Zone Created Successfully");

		Log.info("Creating Geo Domain Area");
		selectGeographicalDomainType("AREA");
		inputZoneAndProceedWithSelection("ADD");
		insertCreateGeoDomainValue(area);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain Area Created Successfully");

		Log.info("Deleting Geo Domain Area value");
		selectGeographicalDomainType("AREA");
		navigateToDeleteScreen(area);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain Area value");
		
		Log.info("Deleting Geo Domain Zone value");
		navigateToDeleteScreen(zone);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain Zone value");

	}
	
	public void AddModifyDelete_GeoDomainSubArea(String user, String password) {
		Log.info("Creating Geo Domain Zone");
		login.LoginAsUser(driver, user, password);
		navigateToGeographicalDomainManagementPage();
		selectGeographicalDomainType("ZONE");
		gdp.clickOnProceedButton();
		gdp.clickOnAddButton();
		insertCreateGeoDomainValue(zone);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain Zone Created Successfully");

		Log.info("Creating Geo Domain Area");
		selectGeographicalDomainType("AREA");
		inputZoneAndProceedWithSelection("ADD");
		insertCreateGeoDomainValue(area);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain Area Created Successfully");
		
		Log.info("Creating Geo Domain SubArea");
		selectGeographicalDomainType("SUBAREA");
		inputZoneAndAreaForSubAreaCreation("ADD");
		insertCreateGeoDomainValue(subArea);
		gdp.clickOnProceedButton();
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Geo Domain SubArea Created Successfully");
		
		Log.info("Deleting Geo Domain SubArea value");
		selectGeographicalDomainType("SUBAREA");
		navigateToDeleteScreen(subArea);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain SubArea value");
		
		Log.info("Deleting Geo Domain Area value");
		selectGeographicalDomainType("AREA");
		navigateToDeleteScreen(area);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain Area value");
		
		Log.info("Deleting Geo Domain Zone value");
		navigateToDeleteScreen(zone);
		gdp.deleteConfirmation("YES");
		gdp.checkGeoDomainSuccessMessage();
		gdp.clickOnPopUpWindowDoneButton();
		Log.info("Deleted Geo Domain Zone value");

	}

}
