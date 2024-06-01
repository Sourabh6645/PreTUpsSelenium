package angular.feature.Voucher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.dbrepository.DBHandler;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.voucher.ViewBatchListVoucher;


public class VoucherViewBatchList extends BaseTest {
	public WebDriver driver;
	LoginRevamp login;
	ViewBatchListVoucher viewBatchList;
	WebDriverWait wait;

	public VoucherViewBatchList(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		viewBatchList = new ViewBatchListVoucher(driver);
		wait = new WebDriverWait(driver, 20);
	}

	List<WebElement> batchData = null;
	
	// Returns the list of search result
	public List<WebElement> serachForBatchDetailsUsingMobileNumber(String mobile) {
		List<WebElement> result = null;
		viewBatchList.serchFilterByMobile();

		viewBatchList.inputDataForMobile(mobile);

		viewBatchList.clickOnsubmitButton();

		if(viewBatchList.verifyBatchDetailsTabLoadedSuccessfully()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batchNo")));

			result = driver.findElements(By.id("batchNo"));
		}

		

		return result;
	}

	public List<WebElement> searchForBatchDetailsUsingBatchID(String batchid){
		List<WebElement> result = null;
		viewBatchList.selectFilterBatchNumber();
		viewBatchList.inputDataForBatchNumber(batchid);
		viewBatchList.clickOnsubmitButton();
		
		if(viewBatchList.verifyBatchDetailsTabLoadedSuccessfully()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batchNo")));

			result = driver.findElements(By.id("batchNo"));
		}
		

		return result;
	}
	
	public List<WebElement> searchForBatchDetailsUsingSchedulePeriod(){
		List<WebElement> result = null;
		viewBatchList.selectFilterBatchNumber();
		
		viewBatchList.selectFilterScheduledPeriod();
		viewBatchList.selectDropDownFromSchedulePeriod();
		viewBatchList.selectPeriodAll();
		viewBatchList.clickOnsubmitButton();
		
		if(viewBatchList.verifyBatchDetailsTabLoadedSuccessfully()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batchNo")));

			result = driver.findElements(By.id("batchNo"));
		}
		

		return result;
	} 
	
	public List<WebElement> searchForBatchDetailsUsingAdvance(){
		List<WebElement> result = null;
		viewBatchList.selectFilterBatchNumber();
		
		viewBatchList.serchFilterByAdvance();
		viewBatchList.selectStatusDropDown();
		viewBatchList.selectAdvanceStatusAll();
		viewBatchList.selectTypeDropDown();
		viewBatchList.selectAdvanceTypeAll();
		viewBatchList.clickOnsubmitButton();
		
		if(viewBatchList.verifyBatchDetailsTabLoadedSuccessfully()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("batchNo")));

			result = driver.findElements(By.id("batchNo"));
		}
		

		return result;
	} 
	
	// View and verify data
	public void verifyViewBatchDetailsPageForSelectedData(String batchId) {
		List<String> uiValue = viewBatchList.getValueFromViewBatchDetailsUI();
		List<String> dbValue = DBHandler.AccessHandler.getBatchViewDetails(batchId);
		for (int i = 0; i < uiValue.size(); i++) {
			if (uiValue.get(i).equals(dbValue.get(i))) {
				Log.info("Found value on UI : " + uiValue.get(i) + " and found DB value : " + dbValue.get(i)
						+ " are equal");
			} else {
				Log.info("Found value on UI : " + uiValue.get(i) + " and found DB value : " + dbValue.get(i)
						+ " are not equal");
			}
		}
	}

	
	public boolean ifElementIsVisble(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Found Clickable Element");
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			Log.info("No Clickable Element Found");
			return false;
		}
	}
	
	
	public void performViewBatchList(String user, String password, String filter) {

		login.UserLoginSuperAdmin(driver, user, password);

		viewBatchList.selectVMSTab();

		viewBatchList.selectViewBatchList();

		viewBatchList.verifyViewBatchListPageLoadedSuccessfully();

		switch (filter) {
		case "Mobile":
			String mobile = "8966724535";
			batchData = serachForBatchDetailsUsingMobileNumber(mobile);

			if (batchData.isEmpty()) {
				Log.info("No Data found for the given number");
			} else {
				int size = batchData.size();
				Log.info("WebElement Size : "+size);
				for (int i=0;i<size;i++) {
					String batchid = null;
					if (ifElementIsVisble(batchData.get(i))) {
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					} else {
						batchData = serachForBatchDetailsUsingMobileNumber(mobile);
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					}

				}
			}

			break;

		case "Batch Number":
			String batchNumber = "I161222.0588";
			batchData = searchForBatchDetailsUsingBatchID(batchNumber);

			if (batchData.isEmpty()) {
				Log.info("No Data found for the given number");
			} else {
				int size = batchData.size();
				Log.info("WebElement Size : "+size);
				for (int i=0;i<size;i++) {
					String batchid = null;
					if (ifElementIsVisble(batchData.get(i))) {
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					} else {
						batchData = searchForBatchDetailsUsingBatchID(batchNumber);
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					}

				}
			}
			break;

		case "Schedule Period":
			batchData = searchForBatchDetailsUsingSchedulePeriod();

			if (batchData.isEmpty()) {
				Log.info("No Data found for the given number");
			} else {
				int size = batchData.size();
				Log.info("WebElement Size : "+size);
				for (int i=0;i<size;i++) {
					String batchid = null;
					if (ifElementIsVisble(batchData.get(i))) {
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					} else {
						batchData = searchForBatchDetailsUsingSchedulePeriod();
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					}

				}
			}

			break;

		case "Advanced":
			batchData = searchForBatchDetailsUsingAdvance();

			if (batchData.isEmpty()) {
				Log.info("No Data found for the given number");
			} else {
				int size = batchData.size();
				Log.info("WebElement Size : "+size);
				for (int i=0;i<size;i++) {
					String batchid = null;
					if (ifElementIsVisble(batchData.get(i))) {
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					} else {
						batchData = searchForBatchDetailsUsingAdvance();
						batchid = batchData.get(i).getText();
						batchData.get(i).click();
						verifyViewBatchDetailsPageForSelectedData(batchid);
						viewBatchList.returnFromViewBatchList();
					}

				}
			}
			break;

		default:
			Log.info("No matching case found");
			break;
		}

	}
}
