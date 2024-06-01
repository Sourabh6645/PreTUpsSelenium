package angular.pageobjects.Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;



public class ServiceManagement_PageObject extends BaseTest {

	@FindBy(xpath = "(//h6[@id='updateCacheLabel']//following::img[@src='assets/images/updateCache/svg/Path 16.svg'])[8]")
	private WebElement serviceManagementButton;
	
	@FindBy(xpath = "//label[@class='operatorHeading']")
	private WebElement serviceManagementHeading;
	
	@FindBy(xpath = "//label[@for='services']//following::div[contains(@class,'ng-select-container')]")
	private WebElement servicesFilterButton;
	
	@FindBy(xpath = "(//button[@name='Reset']//span)[1]")
	private WebElement resetFilter;
	
	@FindBy(xpath = "(//button[@name='Proceed']//span)[1]")
	private WebElement proceedFilter;
	
	@FindBy(xpath = "(//button[@name='Reset']//span)[2]")
	private WebElement resetValue;
	
	@FindBy(xpath = "(//button[@name='Proceed']//span)[2]")
	private WebElement proceedValue;
	
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	public ServiceManagement_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void clickOnServiceManagementButton() {
		Log.info("Trying to click on service management link");
		wait.until(ExpectedConditions.visibilityOf(serviceManagementButton)).click();
		Log.info("Clicked on service management link");
	}
	
	public void clickOnFilterResetButton() {
		Log.info("Trying to reset filter");
		wait.until(ExpectedConditions.visibilityOf(resetFilter)).click();
		Log.info("Clicked on filter reset button");
	}
	
	public void clickOnFilterProceedButton() {
		Log.info("Trying to proceed filter");
		wait.until(ExpectedConditions.visibilityOf(proceedFilter)).click();
		Log.info("Clicked on filter proceed button");
	}
	
	public void clickOnResetValueButton() {
		Log.info("Trying to reset value");
		wait.until(ExpectedConditions.visibilityOf(resetValue)).click();
		Log.info("Clicked on value reset button");
	}
	
	public void clickOnProceedValueButton() {
		Log.info("Trying to proceed value");
		wait.until(ExpectedConditions.visibilityOf(proceedValue)).click();
		Log.info("Clicked on value proceed button");
	}
	
	public boolean checkVisibilityServiceManagementValue() {
		Log.info("Checking if service management values are loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(resetValue));
			wait.until(ExpectedConditions.visibilityOf(proceedValue));
			Log.info("Service management values are loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Service management values are not loaded successfully");
			return false;
		}
	}
	

}
