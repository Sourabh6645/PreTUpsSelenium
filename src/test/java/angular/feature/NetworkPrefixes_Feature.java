package angular.feature;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.NetworkPrefixes.NetworkPrefixes_PageObject;

public class NetworkPrefixes_Feature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	NetworkPrefixes_PageObject NP;
	WebDriverWait wait;

	ArrayList<String> valuesBeforeReset = new ArrayList<String>();
	ArrayList<String> valuesAfterReset = new ArrayList<String>();
	ArrayList<String> gettingErrMsg = new ArrayList<String>();

	String value;
	List<WebElement> textBox = null;
	List<WebElement> errorMsg = null;

	// values for testing
	String Inputseries1 = ",32,44,51";
	String Inputseries2 = ",91,42";
	String Inputseries3 = ",38,08";

	// original values
	String Originalseries1 = "69,76,72,74,00,01,02,89";
	String Originalseries2 = "63,65,75,74,89";
	String Originalseries3 = "90,04,09";
	String Originalseries4 = "64,07,10";

	// wrong values
	String wrongvalues = ",69,fds,312,12,*&";
	
	public NetworkPrefixes_Feature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		NP = new NetworkPrefixes_PageObject(driver);
	}

	public void InputPortValues() {

		textBox = driver.findElements(By.xpath("//textarea[contains(@class,'ng-valid')]"));
		// inserting new values

		Log.info("Entering Port values");

		valuesBeforeReset.add(0, textBox.get(0).getText());
		textBox.get(0).sendKeys(Inputseries1);

		valuesBeforeReset.add(1, textBox.get(1).getText());
		textBox.get(1).sendKeys(Inputseries1);

		valuesBeforeReset.add(2, textBox.get(2).getText());
		textBox.get(2).sendKeys(Inputseries2);

		valuesBeforeReset.add(3, textBox.get(3).getText());
		textBox.get(3).sendKeys(Inputseries3);

		Log.info("Values entered in all the ports");
		
	}
	
	public void FieldValidation() {
		textBox = driver.findElements(By.xpath("//textarea[contains(@class,'ng-valid')]"));
		
		// wrong values
		textBox.get(0).sendKeys(wrongvalues);
		textBox.get(1).sendKeys(wrongvalues);
		textBox.get(2).sendKeys(wrongvalues);
		textBox.get(3).sendKeys(wrongvalues);
		
		errorMsg = driver.findElements(By.xpath("((//div[contains(@class, 'errorMessageContainer')]//following::div[contains(@class, 'errorMessage')])//following::div[contains(@class, 'errorMessage')])"));
		
		if(errorMsg.size()==17) {
			Log.info("All error messages validated");
		}
	}
	
	
	// restoring original values	
	public void RestoringOriginalValues() {
		textBox = driver.findElements(By.xpath("//textarea[contains(@class,'ng-valid')]"));
		
		textBox.get(0).clear();
		textBox.get(0).sendKeys(Originalseries1);
		textBox.get(1).clear();
		textBox.get(1).sendKeys(Originalseries2);
		textBox.get(2).clear();
		textBox.get(2).sendKeys(Originalseries3);
		textBox.get(3).clear();
		textBox.get(3).sendKeys(Originalseries4);
		
		WebElement Savebtn = driver.findElement(By.xpath("(//span[@class = 'mat-button-wrapper'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(Savebtn)).click();
        
		Log.info("Original values restored");
	}
	
	

	public void getPortValuesAfterReset() {
		textBox = driver.findElements(By.xpath("//textarea[contains(@class,'ng-valid')]"));

		valuesAfterReset.add(0, textBox.get(0).getText());

		valuesAfterReset.add(1, textBox.get(1).getText());

		valuesAfterReset.add(2, textBox.get(2).getText());

		valuesAfterReset.add(3, textBox.get(3).getText());

		Log.info("Port values after reset");

	}

	public void comparePortValuesBeforeAndAfterReset() {
		for (int i = 0; i < valuesBeforeReset.size(); i++) {
			String valueBeforeReset = valuesBeforeReset.get(i);
			String valueAfterReset = valuesAfterReset.get(i);
			} 
		if (valuesBeforeReset.equals(valuesAfterReset)) {
			Log.info("Before and after reset, port values are same");
		}
		
	}

	public void ModificationNetworkPrefixes(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		NP.clickOnNetworkPrefixes();
		NP.checkNetworkPrefixesPageLoadedSuccessfully();
		InputPortValues();
		NP.clickOnSavebtn();
		NP.checkVisibilityOfSuccessWindow();
		NP.clickOnDoneBtn();
		RestoringOriginalValues();
	}

	public void ResetAndFieldValidationOfNetworkPrefixes(String loginId, String password) {
		login.LoginAsUser(driver, loginId, password);
		NP.clickOnNetworkPrefixes();
		FieldValidation();
		WebElement resetbtn = driver.findElement(By.xpath("(//span[@class = 'mat-button-wrapper'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(resetbtn)).click();
		InputPortValues();
		NP.clickOnResetbtn();
		getPortValuesAfterReset();
		comparePortValuesBeforeAndAfterReset();
	}

}
