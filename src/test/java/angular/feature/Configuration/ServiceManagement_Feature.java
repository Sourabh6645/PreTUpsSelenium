package angular.feature.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.Configuration.ServiceManagement_PageObject;

public class ServiceManagement_Feature extends BaseTest{
	
	public WebDriver driver = null;
	WebDriverWait wait = null;
	LoginRevamp login;
	ServiceManagement_PageObject smp = null;
	
	public ServiceManagement_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		wait = new WebDriverWait(driver, 20);
		smp = new ServiceManagement_PageObject(driver);
	}
	
	public void NavigateToServiceManagement_Update(String loginId,String password) {
		
		Log.info("Trying to navigate to Service Management and update");
		login.LoginAsUser(driver, loginId, password);
		smp.clickOnServiceManagementButton();
		smp.checkVisibilityServiceManagementValue();
	}

}
