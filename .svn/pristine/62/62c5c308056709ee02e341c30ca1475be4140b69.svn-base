package angular.pageobjects.NetworkPrefixes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class NetworkPrefixes_PageObject extends BaseTest {

	// Network Prefixes Link
	@FindBy(xpath = "(//h6[contains(text(), 'Network Prefixes')]//following-sibling::img)[2]")
	private WebElement NetworkPrefixes;

	// Elements Present on Network Prefixes page
	@FindBy(xpath = "//textarea[@name = 'Prepaid Series Label']")
	private WebElement PrepaidSeriesLabel;

	@FindBy(xpath = "//textarea[@name = 'Postpaid Series Label']")
	private WebElement PostpaidSeriesLabel;

	@FindBy(xpath = "//textarea[@name = 'Other Series Label']")
	private WebElement OtherSeriesLabel;

	@FindBy(xpath = "//textarea[@name = 'Ported Series Label']")
	private WebElement PortedSeriesLabel;

	@FindBy(xpath = "//textarea[@name = 'Prepaid Series']")
	private WebElement PrepaidSeriesTextBox;

	@FindBy(xpath = "//textarea[@name = 'Postpaid Series']")
	private WebElement PostpaidSeriesTextBox;

	@FindBy(xpath = "//textarea[@name = 'Other Series']")
	private WebElement OtherSeriesTextBox;

	@FindBy(xpath = "//textarea[@name = 'Ported Series']")
	private WebElement PortedSeriesTextBox;

	@FindBy(xpath = "(//span[@class = 'mat-button-wrapper'])[1]")
	private WebElement ResetButton;

	@FindBy(xpath = "(//span[@class = 'mat-button-wrapper'])[2]")
	private WebElement SaveButton;

	// Success Screen
	@FindBy(xpath = "(//div[@class= 'container'])[1]")
	private WebElement SuccessPage;

	@FindBy(xpath = "(//span[@class= 'mat-button-wrapper'])[3]")
	private WebElement Done;

	/* -----WebDriver Declaration----- */
	WebDriver driver = null;
	WebDriverWait wait = null;

	public NetworkPrefixes_PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnNetworkPrefixes() {
		Log.info("Clicking on Network Prefixes Tab");
		wait.until(ExpectedConditions.visibilityOf(NetworkPrefixes)).click();
		Log.info("Clicked on Network Prefixes tab Successfully");
	}

	public boolean checkNetworkPrefixesPageLoadedSuccessfully() {
		try {
			wait.until(ExpectedConditions.visibilityOf(PrepaidSeriesLabel));
			wait.until(ExpectedConditions.visibilityOf(PostpaidSeriesLabel));
			wait.until(ExpectedConditions.visibilityOf(OtherSeriesLabel));
			wait.until(ExpectedConditions.visibilityOf(PortedSeriesLabel));
			wait.until(ExpectedConditions.visibilityOf(PrepaidSeriesTextBox));
			wait.until(ExpectedConditions.visibilityOf(PostpaidSeriesTextBox));
			wait.until(ExpectedConditions.visibilityOf(OtherSeriesTextBox));
			wait.until(ExpectedConditions.visibilityOf(PortedSeriesTextBox));
			wait.until(ExpectedConditions.visibilityOf(ResetButton));
			wait.until(ExpectedConditions.visibilityOf(SaveButton));
			Log.info("Network Prefixes page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Network Prefixes page not loaded successfully");
		}
		return false;
	}

	public void clickOnSavebtn() {
		Log.info("Trying to click on Save Button");
		wait.until(ExpectedConditions.visibilityOf(SaveButton)).click();
		Log.info("Clicked on Save Button");
	}

	public void clickOnResetbtn() {
		Log.info("Trying to click on Reset Button");
		wait.until(ExpectedConditions.visibilityOf(ResetButton)).click();
		Log.info("Clicked on Reset Button");
	}

	public boolean checkVisibilityOfSuccessWindow() {
		try {
			wait.until(ExpectedConditions.visibilityOf(SuccessPage));
			wait.until(ExpectedConditions.visibilityOf(Done));
			Log.info("Success popup displayed successfully");
			return true;
		} catch (Exception e) {
			Log.info("Success popup not displayed successfully");
		}
		return false;
	}

	public void clickOnDoneBtn() {
		Log.info("Trying to click on Done Button");
		wait.until(ExpectedConditions.visibilityOf(Done)).click();
		Log.info("Clicked on Done Button");
	}

}
