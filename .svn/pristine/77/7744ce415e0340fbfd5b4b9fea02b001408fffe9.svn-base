package angular.feature.MessageGateway;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.MessageGateway.GatewayMappingPageObject;

public class GatewayMappingFeature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	WebDriverWait wait;
	GatewayMappingPageObject gmp;

	boolean nextButtonState = false;
	String elementFound = "false";
	WebElement nextButton;

	public GatewayMappingFeature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		gmp = new GatewayMappingPageObject(driver);
	}

	public void selectMaxEntryOnPage() {
		Log.info("Selecting max entry on page");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='parentTable_length']")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='100']"))).click();
		Log.info("Selected max entry on page");
	}

	public void clickOnNextButton() {
		try {
			Log.info("checking next button status");
			nextButton = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[contains(@class,'disabled')][contains(@class,'next')]")));
			Log.info("Next button status is enabled");
			nextButtonState = true;
		} catch (Exception e) {
			Log.info("Next button status is not enabled");
			nextButtonState = false;
		}

		if (nextButtonState) {
			nextButton.click();
		}
	}

	public void deleteGatewayMapping(String value) {

		Log.info("Trying to delete " + value + " gateway mapping");

		selectMaxEntryOnPage();
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//td[contains(text(),'" + value + "')])[2]")));
			Log.info("Gateway " + value + " found on screen");
		} catch (Exception e) {
			Log.info("Gateway " + value + " not found on screen");
		}

		WebElement deleteButton = driver.findElement(By
				.xpath("(((//td[contains(text(),'" + value + "')])[2]//following::label[@for='delete'])[1])//a//img"));
		
		Actions builder = new Actions(driver);
	     builder.moveToElement( deleteButton ).click( deleteButton );
	     builder.perform();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
		//deleteButton.click();
	     
	     
		Log.info("Initiated delete Gateway " + value + " found on screen");

		gmp.confirmDelete();

		gmp.clickOnSuccessWindowDoneButton();

	}
}
