package angular.feature.CardGroup;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;
import com.utils._masterVO;

import angular.classes.LoginRevamp;
import angular.pageobjects.CardGroup.BulkModifyC2SCG;
import angular.pageobjects.RechargeBulk.RechargesBulk;
import junit.framework.Assert;

public class BulkModifyC2SCG_Feature extends BaseTest {

	public WebDriver driver;
	WebDriverWait wait;
	LoginRevamp login;
	BulkModifyC2SCG bmc2scg;
	RechargesBulk rb;
	RandomGeneration random;
	
	String uploadPath = null;

	public BulkModifyC2SCG_Feature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		rb = new RechargesBulk(driver);
		bmc2scg = new BulkModifyC2SCG(driver);
		random = new RandomGeneration();
	}

	public void NavigateToBulkModifyC2SCardGroupPage() {
		bmc2scg.clickOneTopUpTab();
		bmc2scg.clickOnCardGroupLink();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bmc2scg.clickOnChannelToSubscriberLink();
		bmc2scg.checkVisibilityOfBulkOperationButton();
		bmc2scg.clickOnBulkOperationButton();
	}
	
	public void selectDateAndTimeRange() {
		Log.info("Selecting date applicable from");
		WebElement fromDate = driver.findElement(By.xpath("//span[contains(@class,'ui-calendar')]//input"));
		fromDate.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'ui-state-highlight')]"))).click();
	}
	
	public void updateTeplateFileToUpload() {
		String filename = null;
		String PathOfFile = _masterVO.getProperty("BatchModifyC2SCardGroup");
		filename = rb.getLatestFilefromDir(PathOfFile);
		File originalFile = new File(filename);
		File renamedFile = new File(System.getProperty("user.dir")
				+ "//src//test//resources//UploadDocuments//MultiWallet_O2C_BulkCommission//" + "userTemplateList"
				+ random.randomAlphaNumeric(12) + ".xls");
		Log.info("Rename File name : "+renamedFile);
		try {
			FileUtils.copyFile(originalFile, renamedFile);
			FileUtils.forceDelete(originalFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String LatestPathOfFile = rb.getLatestFilefromDir(PathOfFile);
//		String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Prepaid");
		/*ExcelUtility.setExcelFileXLS(LatestPathOfFile, ExcelI.SHEET1);
		Log.info("Writing to excel ....");
		ExcelUtility.setExcelFileXLS(LatestPathOfFile, ExcelI.SHEET1);
		ExcelUtility.setCellDataXLS(SubMSISDN, 1, 0); // MSISDN
		ExcelUtility.setCellDataXLS("22", 1, 4); // SubService*/
		filename = rb.getLatestFileNamefromDir(PathOfFile);
		uploadPath = System.getProperty("user.dir")+_masterVO.getProperty("BatchModifyC2SCardGroupUpload") + filename; //+ _masterVO.getProperty("O2CMultiWalletBulkCommissionPayout")
		
		
		Log.info("Complete File Path : "+uploadPath);
		
	}

	public void BatchModifyC2SCardGroup_SuccessCase(String loginId, String password) {

		login.LoginAsUser(driver, loginId, password);
		NavigateToBulkModifyC2SCardGroupPage();

		bmc2scg.selectingServiceType();
		selectDateAndTimeRange();

		bmc2scg.clickOnSelectAllCheckBox();
		
		bmc2scg.clickOnDownloadFileLink();
		updateTeplateFileToUpload();
		rb.uploadFile(uploadPath);
		
		bmc2scg.clickOnSubmitButton();
		bmc2scg.clickOnConfirmButton();
		bmc2scg.clickOnDoneButton();
	}

	public void Error_messages_field_validations(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		NavigateToBulkModifyC2SCardGroupPage();
		
		bmc2scg.clickOnSubmitButton();
		
		String servicetypeerrormessage = driver.findElement(By.xpath("//div[contains(@Class,'errorMessage')]")).getText();
		String dateerrormessage = driver.findElement(By.xpath("(//div[contains(@Class,'invalid-feedback')])[1]")).getText();
		String uploadfileerrormessage = driver.findElement(By.xpath("(//div[contains(@Class,'invalid-feedback')])[2]")).getText();

		Assert.assertEquals(servicetypeerrormessage, "Service type is required");
		Assert.assertEquals(dateerrormessage, "Please Choose Date to proceed.");
		Assert.assertEquals(uploadfileerrormessage, "File is required.");
		
	}
}
