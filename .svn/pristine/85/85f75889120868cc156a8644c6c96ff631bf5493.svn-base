package angular.pageobjects.ProfileManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class Bulk_CategoryWise_DefaultProfiles_PageObject extends BaseTest{
	
	@FindBy(xpath = "//a[@href='/pretups-ui/userdefConfig-management']")
	private WebElement BulkCatDefaultLink;
	
	@FindBy(xpath = "//input[@id='level']//following::span[contains(@class,'ng-arrow-wrapper')]")
	private WebElement DomainDD;
	
	@FindBy(xpath = "//label[@class='download']")
	private WebElement downloadButton;
	
	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetButton;
	
	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement submitButton;
	
	@FindBy(xpath = "//h4[@id='modal-basic-title']")
	private WebElement reviewConfirmTitle;
	
	@FindBy(xpath = "//button[@id='closeId']")
	private WebElement closeButton;
	
	@FindBy(xpath = "(//button[@name='Proceed']//span)[2]")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//img[@src='assets/images/success-icon/tick-inside-circle.png']")
	private WebElement DoneButton;
	
	@FindBy(xpath = "//img[@src='assets/images/success-icon/tick-inside-circle.png']")
	private WebElement successIcon;
	
	
	WebDriver driver = null;
	WebDriverWait wait =  null;
	
	public Bulk_CategoryWise_DefaultProfiles_PageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBulkCatLink() {
		Log.info("Trying to click on Bulk Category-wise Default Profiles");
		BulkCatDefaultLink.click();
		Log.info("Clicked on Bulk Category-wise Default Profiles");
	}
	
	public boolean checkDefaultProfileLoadedSuccessfully() {
		
		Log.info("Checking if Bulk Category-wise Default Profiles");
		
		try {
			wait.until(ExpectedConditions.visibilityOf(DomainDD));
			wait.until(ExpectedConditions.visibilityOf(downloadButton));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(submitButton));
			Log.info("Bulk Category-wise Default Profiles page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Bulk Category-wise Default Profiles page not loaded successfully");
			return false;
		}
		
	}
	
	public void clickOnDomainSelectionDD() {
		Log.info("Trying to click on domain selection dd button");
		DomainDD.click();
		Log.info("Clicked on domain selection dd button");
	}
	
	public void clickOnSubmitButton() {
		Log.info("Trying to click on submit button");
		submitButton.click();
		Log.info("Clicked on Submit button");
	}
	
	public void clickOnDownloadButton() {
		Log.info("Trying to click on Download button");
		downloadButton.click();
		Log.info("Clicked on Download button");
	}
	
	public boolean checkReviewWindowLoaded() {
		Log.info("Checking If Review window is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewConfirmTitle));
			wait.until(ExpectedConditions.visibilityOf(confirmButton));
			Log.info("Review and confirm window loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Review and confirm window not loaded successfully");
			return false;
		}
	}
	
	public void clickOnConfirmButton() {
		Log.info("Trying to click on Download button");
		confirmButton.click();
		Log.info("Clicked on Download button");
	}
	
	public boolean checkSuccessMessageWindowLoaded() {
		Log.info("Checking If Success window is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(successIcon));
			wait.until(ExpectedConditions.visibilityOf(DoneButton));
			Log.info("Success Message window loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Success Message window not loaded successfully");
			return false;
		}
	}
	
	public void clickOnDoneButton() {
		Log.info("Trying to click on Done button");
		DoneButton.click();
		Log.info("Clicked on Done button");
	}
	
}
