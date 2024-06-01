package angular.feature.MultiWalletCommission;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.classes.UniqueChecker;
import com.commons.ExcelI;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils.RandomGeneration;
import com.utils._masterVO;

import angular.classes.LoginRevamp;
import angular.pageobjects.MultiWalletCommission.MultiWallet_O2C_Commission_PageObjec;
import angular.pageobjects.RechargeBulk.RechargesBulk;

public class MultiWallet_O2C_BulkCommission_Feature extends BaseTest {

	MultiWallet_O2C_Commission_PageObjec mpoc;
	LoginRevamp login;
	public WebDriver driver;
	WebDriverWait wait;
	RandomGeneration random;
	RechargesBulk rb;

	String batchName = null;
	List<WebElement> ddList = null;
	String uploadPath = null;

	public MultiWallet_O2C_BulkCommission_Feature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		mpoc = new MultiWallet_O2C_Commission_PageObjec(driver);
		random = new RandomGeneration();
		rb = new RechargesBulk(driver);
		batchName = random.randomAlphabets(6);
	}

	public void selectValueFromDD(int index) {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-item')]")));
		Log.info("Selecting value from DD");
		ddList = driver.findElements(By.xpath("//span[contains(@class,'ng-option-label')]"));
		String selectedValue = ddList.get(index).getText();
		ddList.get(index).click();
		Log.info("Selected value from DD : " + selectedValue);
	}

	public void updateTeplateFileToUpload() {
		String filename = null;
		String PathOfFile = _masterVO.getProperty("O2CMultiWalletBulkCommissionPayout");
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
		uploadPath = System.getProperty("user.dir")+_masterVO.getProperty("O2CMultiWalletBulkCommissionPayoutUpload") + filename; //+ _masterVO.getProperty("O2CMultiWalletBulkCommissionPayout")
		
		
		Log.info("Complete File Path : "+uploadPath);
		

	}

	public void performBulkCommissionPayOut(String loginId, String password,String PIN) {

		Log.info("Performing Bulk Commission Pay Out");

		login.LoginAsUser(driver, loginId, password);
		mpoc.clickOnCommissionLink();
		mpoc.clickOnBulkOption();
		mpoc.checkBulkCommissionPayoutPageLoadedSuccessfully();
		mpoc.clickOnGeographyDDButton();
		selectValueFromDD(0);
		mpoc.clickOnDomainDDButton();
		selectValueFromDD(1);
		mpoc.clickOnUserCategoryDDButton();
		selectValueFromDD(0);
		mpoc.clickOnProductDDButton();
		selectValueFromDD(0);
		mpoc.clickOnOperationDDButton();
		selectValueFromDD(0);
		mpoc.clickOnDownloadUserListButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mpoc.clickOnDownloadTemplateButton();
		updateTeplateFileToUpload();
		rb.uploadFile(uploadPath);
		mpoc.insertBatchName(batchName);
		mpoc.clickOnSubmitButton();
		mpoc.checkReviewAndConfirmScreenLoadedSuccessfully();		
		rb.enterPin(PIN);
		mpoc.clickOnConfirmButton();
		mpoc.checkSuccessWindow();
		mpoc.clickOnDoneButton();
	}

}
