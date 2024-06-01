package angular.pageobjects.MessageGateway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class GatewayMappingPageObject extends BaseTest {

	@FindBy(xpath = "//a[@href='/pretups-ui/operatorUser/Mapping']")
	private WebElement gatwayMappingLink;

	@FindBy(xpath = "//label[@class='operatorHeading']")
	private WebElement gatwayMappingHeading;

	@FindBy(xpath = "//table[@id='parentTable']")
	private WebElement dataTable;

	@FindBy(xpath = "//div[@class='deletepop']")
	private WebElement deleteMessagePopUp;

	@FindBy(xpath = "//button[contains(@class,'yes')]//span")
	private WebElement deleteConfirm;

	@FindBy(xpath = "//div[@class='success1']")
	private WebElement successMessageWindow;

	@FindBy(xpath = "//div[@class='success1']//following::button[@id='doneBtn']//span")
	private WebElement successDoneButton;

	WebDriver driver = null;
	WebDriverWait wait = null;

	public GatewayMappingPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public boolean checkGatewayMappingLoadedSuccessfully() {

		try {
			wait.until(ExpectedConditions.visibilityOf(gatwayMappingHeading));
			wait.until(ExpectedConditions.visibilityOf(dataTable));
			Log.info("Gateway mapping loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Gateway mapping not loaded successfully");
		}
		return false;
	}

	public void clickOnGatewayMappingLink() {
		Log.info("Trying to click on gateway mapping link");
		gatwayMappingLink.click();
		Log.info("Clicked on Gateway Mapping Link");
	}

	public boolean checkDeletePopUp() {

		Log.info("Checking for delete message Pop-Up");
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteMessagePopUp));
			Log.info("Delete message pop-up is visible");
			return true;
		} catch (Exception e) {
			Log.info("Delete message pop-up is not visible");
		}

		return false;
	}

	public void confirmDelete() {
		Log.info("Confirming delete gateway mapping");

		if (checkDeletePopUp()) {
			deleteConfirm.click();
		}

		Log.info("Confirmed delete of gateway mapping");
	}

	public boolean checkConfirmMessagePopUp() {

		Log.info("Checking for Confirm Message message Pop-Up");
		try {
			wait.until(ExpectedConditions.visibilityOf(successMessageWindow));
			Log.info("Success message pop-up is visible");
			return true;
		} catch (Exception e) {
			Log.info("Success message pop-up is not visible");
		}

		return false;
	}

	public void clickOnSuccessWindowDoneButton() {
		Log.info("Confirming success message");

		if (checkConfirmMessagePopUp()) {
			successDoneButton.click();
		}

		Log.info("Confirmed Success Message");
	}

}
