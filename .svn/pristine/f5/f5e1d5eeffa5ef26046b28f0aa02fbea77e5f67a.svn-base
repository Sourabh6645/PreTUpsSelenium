package angular.feature.ProfileManagement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;
import com.utils.RandomGeneration;
import com.utils._masterVO;

import angular.classes.LoginRevamp;
import angular.pageobjects.ProfileManagement.Bulk_CategoryWise_DefaultProfiles_PageObject;
import angular.pageobjects.ProfileManagement.TransferControlProfile_PageObject;
import angular.pageobjects.RechargeBulk.RechargesBulk;

public class Bulk_CategoryWise_DefaultProfile_Feature extends BaseTest {

	WebDriver driver = null;
	WebDriverWait wait = null;
	LoginRevamp login = null;
	Bulk_CategoryWise_DefaultProfiles_PageObject bcdp;
	TransferControlProfile_PageObject tcp;
	RandomGeneration random = null;
	RechargesBulk rb;

	String uploadPath = null;
	String DDvalue = null;

	public Bulk_CategoryWise_DefaultProfile_Feature(WebDriver driver) {
		this.driver = driver;
		bcdp = new Bulk_CategoryWise_DefaultProfiles_PageObject(driver);
		tcp = new TransferControlProfile_PageObject(driver);
		rb = new RechargesBulk(driver);
		login = new LoginRevamp();
		wait = new WebDriverWait(driver, 20);
		random = new RandomGeneration();
	}

	public void updateTeplateFileToUpload() {
		String filename = null;
		String PathOfFile = _masterVO.getProperty("BulkCategoriesWiseDefaultprofile");
		filename = rb.getLatestFilefromDir(PathOfFile);
		File originalFile = new File(filename);
		File renamedFile = new File(System.getProperty("user.dir")
				+ "//src//test//resources//UploadDocuments//Bulk_CategoriesWise_Default_profile//" + "DISTUSRCNF_"
				+ random.randomNumeric(8) + "_" + random.randomNumeric(6) + ".xls");
		Log.info("Rename File name : " + renamedFile);
		try {
			FileUtils.copyFile(originalFile, renamedFile);
			FileUtils.forceDelete(originalFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String LatestPathOfFile = rb.getLatestFilefromDir(PathOfFile);
//		String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Prepaid");

		/*
		 * ExcelUtility.setExcelFileXLS(LatestPathOfFile, ExcelI.SHEET1);
		 * Log.info("Writing to excel ....");
		 * ExcelUtility.setExcelFileXLS(LatestPathOfFile, ExcelI.SHEET1);
		 * ExcelUtility.setCellDataXLS(SubMSISDN, 1, 0); // MSISDN
		 * ExcelUtility.setCellDataXLS("22", 1, 4); // SubService
		 */

		filename = rb.getLatestFileNamefromDir(PathOfFile);
		uploadPath = System.getProperty("user.dir") + _masterVO.getProperty("BulkCategoriesWiseDefaultprofileUpload")
				+ filename; // + _masterVO.getProperty("O2CMultiWalletBulkCommissionPayout")

		Log.info("Complete File Path : " + uploadPath);

	}

	public void selectSpecificDDValue(String DDValueText) {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + DDValueText + "')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		DDvalue = element.getText();
		Log.info("Selected value from DD : " + DDvalue);
		element.click();
	}

	public void Perform_Bulk_CategoryWise_DefaultProfile(String loginId, String passowrd) {
		login.LoginAsUser(driver, loginId, passowrd);
		tcp.clickOnProfileManagementLink();
		bcdp.clickOnBulkCatLink();
		bcdp.checkDefaultProfileLoadedSuccessfully();
		bcdp.clickOnDomainSelectionDD();
		selectSpecificDDValue("Distributor");
		bcdp.clickOnDownloadButton();
		updateTeplateFileToUpload();
		rb.uploadFile(uploadPath);
		bcdp.clickOnSubmitButton();
		bcdp.checkReviewWindowLoaded();
		bcdp.clickOnConfirmButton();
		bcdp.checkSuccessMessageWindowLoaded();
		bcdp.clickOnDoneButton();

	}
}
