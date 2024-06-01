package angular.feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;

import angular.classes.LoginRevamp;
import angular.pageobjects.NetworkProductMapping;

public class NetworkProductMappingFeature extends BaseTest {
	
	public WebDriver driver;
	WebDriverWait wait;
	LoginRevamp login;
	NetworkProductMapping npm;
	
	public NetworkProductMappingFeature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		npm = new NetworkProductMapping(driver);
	}
	
	public void NavigateToNetworkProductMappingPage() {
		npm.clickOneTopUpTab();
		npm.clickOnNetworkProductMappingLink();
	}
	
	
	//SC-01
	public void Modify_Usage(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		
		
		npm.clickOnUsageDropdown();
		npm.UsageDDSelection();
		
		npm.clickOnProceedButton();
		npm.clickOnDoneButton();
		
		npm.ValidateUsage();
	}
	
	//SC-02
	//same changes as in SC-01
	public void Modify_Status(String loginId, String password){
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		
		npm.clickOnStatusDropdown();
		npm.StatusDDSelection();
		
		npm.clickOnProceedButton();
		npm.clickOnDoneButton();
		
	}
	
	//SC-03
	public void modify_Language1(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		
		npm.clickonLanguage1messageinput();
		npm.Language2messageinput.click();
		
		npm.clickOnProceedButton();
		
		npm.clickOnDoneButton();
		//value = inputvalue
	}
	//SC-04
	//same as in SC-03
	public void modify_Language2(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		
		npm.clickonLanguage2messageinput();
		npm.Language1messageinput.click();
		
		npm.clickOnProceedButton();
		npm.clickOnDoneButton();
	}

	
	//SC-05
	//same as in SC-03
	public void modify_AlertingBalance(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		
		npm.clickOnAlertingBalanceInput();
		npm.Language2messageinput.click();
		
		npm.clickOnProceedButton();
		npm.clickOnDoneButton();
	}
	
	//SC-06
	public void CheckResetButton(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToNetworkProductMappingPage();
		//create an array list, capture all value before changes
		npm.clickOnStatusDropdown();
		npm.StatusDDSelection();
		
		npm.clickOnResetButton();
		//capture all value after reset and compare
	}
}
