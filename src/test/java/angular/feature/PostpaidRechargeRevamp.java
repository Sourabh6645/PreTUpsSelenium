package angular.feature;

import angular.classes.LoginRevamp;
import angular.pageobjects.recharge.Recharges;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.classes.BaseTest;
import com.classes.MessagesDAO;
import com.classes.UniqueChecker;
import com.commons.ExcelI;
import com.commons.MasterI;
import com.dbrepository.DBHandler;
import com.utils.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.utils.RandomGeneration.*;


public class PostpaidRechargeRevamp extends BaseTest{

	public WebDriver driver;
	LoginRevamp login;
	Recharges recharges;
	SoftAssert SAssert = new SoftAssert();

	/*C2STransferPage C2STransferPage;
	C2SRechargeConfirmPage C2SRechargeConfirmPage;
	C2SRechargeConfirmNotificationPage C2SRechargeConfirmNotificationPage;
	C2SRechargeNotificationDisplayedPage C2SRechargeNotificationDisplayedPage;
	C2STransferSubCategoriesPage C2STransferSubCategoriesPage;
	C2STransactionStatus C2STransactionStatus;
	RandomGeneration randomNum;
	SystemPreferencePage sysPref;
	ServicePreferencePage servPref;
	SuperAdminHomePage suHomepage;
	NetworkAdminHomePage naHomepage;
	PreferenceSubCategories naPref;
	ServiceClassPreference naServPref;
	SelectNetworkPage networkPage;*/

	public PostpaidRechargeRevamp(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		recharges = new Recharges(driver);
		
		/*C2STransferPage =new C2STransferPage(driver);
		C2SRechargeConfirmPage =new C2SRechargeConfirmPage(driver);
		C2SRechargeConfirmNotificationPage =new C2SRechargeConfirmNotificationPage(driver);
		C2SRechargeNotificationDisplayedPage =new C2SRechargeNotificationDisplayedPage(driver);
		C2STransferSubCategoriesPage =new C2STransferSubCategoriesPage(driver);
		C2STransactionStatus=new C2STransactionStatus();
		randomNum = new RandomGeneration();
		sysPref = new SystemPreferencePage(driver);
		servPref = new ServicePreferencePage(driver);
		suHomepage = new SuperAdminHomePage(driver);
		naHomepage = new NetworkAdminHomePage(driver);
		naPref = new PreferenceSubCategories(driver);
		naServPref = new ServiceClassPreference(driver);
		networkPage = new SelectNetworkPage(driver);*/
	}


	public void performC2STransferPostpaid(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaid";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		/*C2S Transfer Page*/

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		for(int i=1;i<=totalRow;i++){
		String []values={ExcelUtility.getCellData(0,ExcelI.NAME,i),ExcelUtility.getCellData(0,ExcelI.SELECTOR_NAME,i)};
		if(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i).equals(service)) {
			serviceMap.put(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i),values);
			
			if(recharges.isRechargeVisibile()){
				recharges.clickRecharge();
				recharges.clickPostpaidRecharge();
			}
			
			else {
				recharges.clickRechargeHeading();
				recharges.clickRecharge();
				recharges.clickPostpaidRecharge();
			}
			
		String serviceName= serviceMap.get(service)[0];
		Log.info("Service name is =" + serviceName);
		//C2STransferPage.selectService(serviceName);
			String SubMSISDN=UniqueChecker.generate_subscriber_MSISDN("Postpaid");
			recharges.enterSubMSISDN(SubMSISDN);
		double b=recharges.getCurrentBalance();
		int a= (int) (b*0.05);
		int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
		int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
		if(minCardSlab < a && a < midCardSlab);
		else if(a > midCardSlab){a = midCardSlab;}
		else if(a < minCardSlab){a = minCardSlab+1;}
		
		System.out.print(a); // added for test
			recharges.enterAmount(""+a);
			recharges.selectSubService(serviceMap.get(service)[1]);
			recharges.clickRechargeIcon();
			recharges.enterPin(PIN);

			recharges.clickPostpaidBillPaymentButton();
			String  successStatus = DBHandler.AccessHandler.getTransactionStatusByKey("200", "C2S_STATUS");
			
			
			boolean successPopUP=recharges.successPopUPVisibility(); 
			if (successPopUP==true){
				transferID = recharges.transferID();
				//trf_status = DBHandler.AccessHandler.fetchTransferStatus(transferID);
				transferStatus = recharges.transferStatus();
				
				if(transferStatus.toUpperCase().contains(successStatus)){
					ExtentI.Markup(ExtentColor.GREEN, "Transaction Status Found as: " + transferStatus + " with TXN ID: "+transferID+", hence Transaction Successful");
//					ExtentI.getChannelRequestDailyLogs(transferID);
//					ExtentI.getOneLineTXNLogsC2S(transferID);
//					ExtentI.attachCatalinaLogsForSuccess();
				}
				else 
					{currentNode.log(Status.FAIL, "Transaction is not successful. Transfer Status on WEB: "+transferStatus+" | TXN ID: "+transferID+" | DB TXN Status: "+trf_status);
					ExtentI.getChannelRequestDailyLogs(transferID);
					ExtentI.getOneLineTXNLogsC2S(transferID);
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();}
				recharges.clickDoneButton();
			
	}
			else
			{
				currentNode.log(Status.FAIL, "Transaction is not successful. Transfer Status on WEB: "+transferStatus+" | TXN ID: "+transferID+" | DB TXN Status: "+trf_status);
			ExtentI.getChannelRequestDailyLogs(transferID);
			ExtentI.getOneLineTXNLogsC2S(transferID);
			ExtentI.attachCatalinaLogs();
			ExtentI.attachScreenShot();}
		}
		}
			Log.methodExit(methodname);	
		
	}	

	/* NEGATIVE FUNCTIONALITY FOR C2STRASNFERREVAMP */


	public void performC2STransferPostpaidBlankAmount(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidBlankAmount";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");

		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);


		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		for(int i=1;i<=totalRow;i++)
		{
			String []values={ExcelUtility.getCellData(0,ExcelI.NAME,i),ExcelUtility.getCellData(0,ExcelI.SELECTOR_NAME,i)};
			if(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i),values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName= serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);

				recharges.enterAmount("");

				recharges.clickRechargeIcon();

				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				String expectedMessage = "Amount is required.";
				boolean flag = false ;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true ;
						break;
					}
				}
				if(flag)
				{
					Assertion.assertContainsEquals(actualMessage, expectedMessage) ;
					ExtentI.attachCatalinaLogsForSuccess();
				}
				else
				{
					currentNode.log(Status.FAIL, "Blank Amount Error not displayed on GUI");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}

			}
		}
		Log.methodExit(methodname);

	}




	public void performC2STransferPostpaidBlankSubservice(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidBlankSubservice";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		/*C2S Transfer Page*/

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);

				recharges.clickRechargeIcon();
				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				String expectedMessage = "Sub service is required";

				boolean flag = false;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					Assertion.assertContainsEquals(actualMessage, expectedMessage);
					ExtentI.attachCatalinaLogsForSuccess();
				} else {
					currentNode.log(Status.FAIL, "Blank SubService Error not displayed on GUI");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}

				Log.methodExit(methodname);

			}
		}
	}




	public void performC2STransferPostpaidAlphaNumericAmount(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidAlphaNumericAmount";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		RandomGeneration RandomGeneration = new RandomGeneration();
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);


		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();

		String expectedMessage = null ;

		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);

				//String amount = RandomGeneration.randomAlphaNumeric(3);
				String amount = "eeee" ;
				recharges.enterAmount(amount);

				recharges.clickRechargeIcon();

				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				expectedMessage = "Amount cannot be alphanumeric." ;
				boolean flag = false;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					Assertion.assertContainsEquals(actualMessage, expectedMessage);
					ExtentI.attachCatalinaLogsForSuccess();
				} else {
					currentNode.log(Status.FAIL, "Alphanumeric Error didnt display on GUI or Amount accepted Alphanumeric Value");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}

				Log.methodExit(methodname);

			}
		}
	}




	public void performC2STransferPostpaidNegativeAmount(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidNegativeAmount";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		/*C2S Transfer Page*/

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		for(int i=1;i<=totalRow;i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);

				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}


				recharges.enterAmount("" + (-a));

				recharges.clickRechargeIcon();
				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				String expectedMessage = "Amount cannot be alphanumeric.";
				boolean flag = false;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					Assertion.assertEquals(actualMessage, expectedMessage);
					ExtentI.attachCatalinaLogsForSuccess();
				} else {
					currentNode.log(Status.FAIL, "Negative Amount Error not displayed on GUI");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
				Log.methodExit(methodname);
			}
		}
	}




	public void performC2STransferPostpaidZeroAmount(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidZeroAmount";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		/*C2S Transfer Page*/

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		for(int i=1;i<=totalRow;i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				//C2STransferPage.selectService(serviceName);
				String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				recharges.enterAmount("0000");
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				recharges.enterPin(PIN);

				recharges.clickPostpaidBillPaymentButton();
				String expectedMessage = "ZERO" ;
				String actualMessage = null ;

				boolean flag = false;
				boolean successPopUP = recharges.failedPopUPVisibility();
				if (successPopUP == true) {
					transferStatus = recharges.transferStatusFailed();    //recharge failed
					if (transferStatus.toUpperCase().contains("FAIL")) {
						flag = true ;
					} else {
						flag = false ;
					}
				}

				if(flag)
				{
					actualMessage = recharges.getInvalidTextMessage().toUpperCase() ;
					Assertion.assertContainsEquals(expectedMessage, actualMessage);
					recharges.clicktryAgainForFailRecharges() ;
					ExtentI.Markup(ExtentColor.GREEN, "Transaction Not Successful with ZERO Amount");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				} else {

					currentNode.log(Status.FAIL, "Transaction went ahead with Zero amount") ;
					/*ExtentI.getChannelRequestDailyLogs(transferID);
					ExtentI.getOneLineTXNLogsC2S(transferID);*/
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();


				}
			}
		}
		Log.methodExit(methodname);
	}



	public void performC2STransferPostpaidBlankPIN(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidBlankPIN";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		for(int i=1;i<=totalRow;i++)
		{
			String []values={ExcelUtility.getCellData(0,ExcelI.NAME,i),ExcelUtility.getCellData(0,ExcelI.SELECTOR_NAME,i)};
			if(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i),values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName= serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				String SubMSISDN=UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				double b=recharges.getCurrentBalance();
				int a= (int) (b*0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if(minCardSlab < a && a < midCardSlab);
				else if(a > midCardSlab){a = midCardSlab;}
				else if(a < minCardSlab){a = minCardSlab+1;}
				recharges.enterAmount(""+a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				recharges.enterPin("");
				recharges.clickPostpaidBillPaymentButton();
				String  successStatus = DBHandler.AccessHandler.getTransactionStatusByKey("200", "C2S_STATUS");
				boolean rechargeButtonAvailable=recharges.checkRechargeButtonIsClickable();	//false

				if (!rechargeButtonAvailable){
					ExtentI.Markup(ExtentColor.GREEN, "RECHARGE BUTTON DISABLED WHEN BLANK PIN PROVIDED");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				}
				else if(rechargeButtonAvailable)
				{
					currentNode.log(Status.FAIL, "RECHARGE BUTTON AVAILABLE AFTER BLANK PIN PROVIDED");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
				recharges.clickCloseEnterPINPopup();
			}
		}
		Log.methodExit(methodname);
	}



	public void performC2STransferPostpaidCloseEnterPINPopup(String ParentCategory, String FromCategory,String PIN,String service) {
        final String methodname = "performC2STransferPostpaidCloseEnterPINPopup";
        Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
        String MasterSheetPath = _masterVO.getProperty("DataProvider");
        ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
        login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
        ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
        int totalRow = ExcelUtility.getRowCount();
        Map<String,String[]> serviceMap=new HashMap<String,String[]>();
        String transferID = null,transferStatus = null,trf_status = null;
        for(int i=1;i<=totalRow;i++)
        {
            String []values={ExcelUtility.getCellData(0,ExcelI.NAME,i),ExcelUtility.getCellData(0,ExcelI.SELECTOR_NAME,i)};
            if(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i).equals(service)) {
                serviceMap.put(ExcelUtility.getCellData(0,ExcelI.SERVICE_TYPE,i),values);
                if(recharges.isRechargeVisibile()){
    				recharges.clickRecharge();
    				recharges.clickPostpaidRecharge();
    			}
    			
    			else {
    				recharges.clickRechargeHeading();
    				recharges.clickRecharge();
    				recharges.clickPostpaidRecharge();
    			}
                String serviceName= serviceMap.get(service)[0];
                Log.info("Service name is =" + serviceName);
                String SubMSISDN=UniqueChecker.generate_subscriber_MSISDN("Postpaid");
                recharges.enterSubMSISDN(SubMSISDN);
                double b=recharges.getCurrentBalance();
                int a= (int) (b*0.05);
                int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
                int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
                if(minCardSlab < a && a < midCardSlab);
                else if(a > midCardSlab){a = midCardSlab;}
                else if(a < minCardSlab){a = minCardSlab+1;}
                recharges.enterAmount(""+a);
                recharges.selectSubService(serviceMap.get(service)[1]);
                recharges.clickRechargeIcon();
                recharges.clickCloseEnterPINPopup();

                boolean successPopUP=recharges.RechargeIconVisibility();
                if (successPopUP==true){
                    ExtentI.Markup(ExtentColor.GREEN, "Enter PIN Popup Closed Successfully") ;
                    ExtentI.attachCatalinaLogsForSuccess();

                }
                else
                {
                    currentNode.log(Status.FAIL, "Enter PIN Popup didnt close") ;
                    ExtentI.attachCatalinaLogs();
                    ExtentI.attachScreenShot();
                }
            }
        }
        Log.methodExit(methodname);
    }




	public void performC2STransferPostpaidInvalidPIN(String ParentCategory, String FromCategory,String PIN,String service) {
		final String methodname = "performC2STransferPostpaidInvalidPIN";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String,String[]> serviceMap=new HashMap<String,String[]>();
		String transferID = null,transferStatus = null,trf_status = null;
		RandomGeneration RandomGeneration = new RandomGeneration();

		for(int i=1;i<=totalRow;i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}

				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				//C2STransferPage.selectService(serviceName);
				String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}
				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				PIN = RandomGeneration.randomDecimalNumer(1,2);
				recharges.enterPin(PIN);
				Log.info("PIN Entered : "+PIN) ;
				recharges.clickPostpaidBillPaymentButton();
				String expectedMessage = "Invalid PIN" ;
				String actualMessage = null ;

				boolean flag = false;
				boolean successPopUP = recharges.failedPopUPVisibility();
				if (successPopUP == true) {
					transferStatus = recharges.transferStatusFailed();    //recharge failed
					if (transferStatus.toUpperCase().contains("FAIL")) {
						flag = true ;

					} else {
						flag = false ;
					}
				}

				if(flag)
				{
					actualMessage = recharges.getInvalidTextMessage() ;
					Assertion.assertContainsEquals(actualMessage, expectedMessage);
					recharges.clicktryAgainForFailRecharges() ;
					ExtentI.Markup(ExtentColor.GREEN, "Transaction Not Successful with Invalid(decimal digit) PIN");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				} else {
					currentNode.log(Status.FAIL, "Transaction went ahead with Invalid(decimal digit) PIN") ;
					ExtentI.getChannelRequestDailyLogs(transferID);
					ExtentI.getOneLineTXNLogsC2S(transferID);
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();

				}
			}
		}
		Log.methodExit(methodname);
	}


/*

    public void performC2STransferPostpaidAlphanumericPIN(String ParentCategory, String FromCategory,String PIN,String service) {
        final String methodname = "performC2STransferPostpaidAlphanumericPIN";
        Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
        String MasterSheetPath = _masterVO.getProperty("DataProvider");
        ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
        login.UserLogin(driver,"ChannelUser",ParentCategory, FromCategory);
        ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
        int totalRow = ExcelUtility.getRowCount();
        //HashMap to fetch servicename from Excel
        Map<String,String[]> serviceMap=new HashMap<String,String[]>();
        String transferID = null,transferStatus = null,trf_status = null;
        RandomGeneration RandomGeneration = new RandomGeneration();

        for(int i=1;i<=totalRow;i++) {
            String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
            if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
                serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
                recharges.clickRechargeHeading();
                recharges.clickRecharge();
                recharges.clickPostpaidRecharge();

                String serviceName = serviceMap.get(service)[0];
                Log.info("Service name is =" + serviceName);
                //C2STransferPage.selectService(serviceName);
                String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
                recharges.enterSubMSISDN(SubMSISDN);
                double b = recharges.getCurrentBalance();
                int a = (int) (b * 0.05);
                int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
                int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
                if (minCardSlab < a && a < midCardSlab) ;
                else if (a > midCardSlab) {
                    a = midCardSlab;
                } else if (a < minCardSlab) {
                    a = minCardSlab + 1;
                }
                recharges.enterAmount("" + a);
                recharges.selectSubService(serviceMap.get(service)[1]);
                recharges.clickRechargeIcon();
                PIN = RandomGeneration.randomAlphaNumeric(4);
                recharges.enterPin(PIN);
                recharges.clickRechargeButton();

                boolean flag = false;
                boolean successPopUP = recharges.failedPopUPVisibility();
                if (successPopUP == true) {
                    transferStatus = recharges.transferStatusFailed();    //recharge failed
                    if (transferStatus.toUpperCase().contains("FAIL")) {
                        ExtentI.Markup(ExtentColor.GREEN, "Transaction Not Successful with Alphanumeric PIN");
                        ExtentI.attachCatalinaLogsForSuccess();
                        ExtentI.attachScreenShot();
                    } else {
                        currentNode.log(Status.FAIL, "Transaction went ahead with Alphanumeric PIN") ;
                        ExtentI.getChannelRequestDailyLogs(transferID);
                        ExtentI.getOneLineTXNLogsC2S(transferID);
                        ExtentI.attachCatalinaLogs();
                        ExtentI.attachScreenShot();
                    }
                }
            }
        }
        Log.methodExit(methodname);
    }
*/




    /* ----------------------- YASH -------------*/





	public void performC2STransferPostpaidBlankMSISDN(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransferPostpaidBlankMSISDN";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++)
		{
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				recharges.enterSubMSISDN("");
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}
				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				String expectedMessage = "Mobile number is required.";
				boolean flag = false;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true;
						break;
					}
				}
				if (flag)
				{
					Assertion.assertContainsEquals(actualMessage, expectedMessage);
					ExtentI.attachCatalinaLogsForSuccess();
				}
				else
				{
					currentNode.log(Status.FAIL, "Blank MSISDN error not shown");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
			}
		}
		Log.methodExit(methodname);

	}


	public void performC2STransferPostpaidInvalidMSISDN(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransfer";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		RandomGeneration RandomGeneration = new RandomGeneration();
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				String SubMSISDN = null;
				SubMSISDN = RandomGeneration.randomNumeric(5);
				recharges.enterSubMSISDN(SubMSISDN);
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}


				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
				String actualMessage = null;
				String expectedMessage = "Please enter valid Mobile Number.";
				boolean flag = false;
				for (WebElement ele : errorMessageCaptured) {
					actualMessage = ele.getText();
					if (expectedMessage.equals(actualMessage)) {
						flag = true;
						break;
					}
				}
				if (flag) {
					Assertion.assertEquals(actualMessage, expectedMessage);
					ExtentI.attachCatalinaLogsForSuccess();
				} else {
					currentNode.log(Status.FAIL, "Invalid MSISDN error not shown");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
			}
		}
		Log.methodExit(methodname);

	}

	public void performC2STransferPostpaidAlphaNumericMSISDN(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransferAlphaNumericMSISDN";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		RandomGeneration RandomGeneration = new RandomGeneration();

		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);

				recharges.enterSubMSISDN("eee");
					double b = recharges.getCurrentBalance();
					int a = (int) (b * 0.05);
					int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
					int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
					if (minCardSlab < a && a < midCardSlab) ;
					else if (a > midCardSlab) {
						a = midCardSlab;
					} else if (a < minCardSlab) {
						a = minCardSlab + 1;
					}

					recharges.enterAmount("" + a);
					recharges.selectSubService(serviceMap.get(service)[1]);
					recharges.clickRechargeIcon();
					List<WebElement> errorMessageCaptured = recharges.blankErrorMessages();
					String actualMessage = null;
					String expectedMessage = "Please enter valid Mobile Number.";
					for (WebElement ele : errorMessageCaptured) {
						actualMessage = ele.getText();
						Assertion.assertEquals(actualMessage, expectedMessage);
						if (expectedMessage.equals(actualMessage)) {
							ExtentI.Markup(ExtentColor.GREEN, "Validation Error Status Found as: " + actualMessage);
							ExtentI.attachCatalinaLogsForSuccess();
							ExtentI.attachScreenShot();
							break;
						} else {
							currentNode.log(Status.FAIL, "Transaction is not successful. Transfer Status on WEB: " + transferStatus + "  | DB TXN Status: " + trf_status);
							ExtentI.attachCatalinaLogs();
							ExtentI.attachScreenShot();
						}
					}
				}
		}
		Log.methodExit(methodname);

	}

	public void performC2STransferPostpaidResetButton(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransferResetButton";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				//C2STransferPage.selectService(serviceName);
				String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}
				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickResetButton();


				String blankMSISDN = recharges.getblanksubMSISDN();
				String blankAmount = recharges.getblanksubAmount();
				//String blanksubService = recharges.getblanksubService();

				Boolean checkMSISDN = blankMSISDN.equals("");
				Boolean checkAmount = blankAmount.equals("");
			//	Boolean checksubService = blanksubService.equals("");
				if(checkAmount&&checkMSISDN)
				{
					ExtentI.Markup(ExtentColor.GREEN, "All fields are blank hence Reset button click successful");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				}
				else{
					currentNode.log(Status.FAIL, "Fields are not blank hence Reset button failed.");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
			}
		}

		Log.methodExit(methodname);

	}

	public void performC2STransferPostpaidCopyButton(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransferCopyButton";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				if(recharges.isRechargeVisibile()){
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				
				else {
					recharges.clickRechargeHeading();
					recharges.clickRecharge();
					recharges.clickPostpaidRecharge();
				}
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				//C2STransferPage.selectService(serviceName);
				String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}
				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				recharges.enterPin(PIN);

				recharges.clickPostpaidBillPaymentButton();
				recharges.clickCopyButton();
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();
				String clipboard = null;
				try {
					clipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				transferID = recharges.transferID();
				Log.info("Copied Transfer ID fetched as : "+clipboard);
				if(clipboard.equals(transferID))
				{
					ExtentI.Markup(ExtentColor.GREEN, "Transaction ID Copied");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				} else {
					currentNode.log(Status.FAIL, "Transaction ID Copy failed");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
				recharges.clickRechargeDone() ;
			}
		}
		Log.methodExit(methodname);

	}

	/*public void performC2STransferPostpaidPrintButton(String ParentCategory, String FromCategory, String PIN, String service) {
		final String methodname = "performC2STransferPrint";
		Log.methodEntry(methodname, ParentCategory, FromCategory, PIN, service);
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		login.UserLogin(driver, "ChannelUser", ParentCategory, FromCategory);
		*//*C2S Transfer Page*//*
		recharges.clickRechargeHeading();
		recharges.clickRecharge();
		recharges.clickPostpaidRecharge();
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.C2S_SERVICES_SHEET);
		int totalRow = ExcelUtility.getRowCount();
		//HashMap to fetch servicename from Excel
		Map<String, String[]> serviceMap = new HashMap<String, String[]>();
		String transferID = null, transferStatus = null, trf_status = null;
		for (int i = 1; i <= totalRow; i++) {
			String[] values = {ExcelUtility.getCellData(0, ExcelI.NAME, i), ExcelUtility.getCellData(0, ExcelI.SELECTOR_NAME, i)};
			if (ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i).equals(service)) {
				serviceMap.put(ExcelUtility.getCellData(0, ExcelI.SERVICE_TYPE, i), values);
				recharges.clickRechargeHeading();
				recharges.clickRecharge();
				recharges.clickPostpaidRecharge();
				String serviceName = serviceMap.get(service)[0];
				Log.info("Service name is =" + serviceName);
				//C2STransferPage.selectService(serviceName);
				String SubMSISDN = UniqueChecker.generate_subscriber_MSISDN("Postpaid");
				recharges.enterSubMSISDN(SubMSISDN);
				double b = recharges.getCurrentBalance();
				int a = (int) (b * 0.05);
				int minCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab1"));
				int midCardSlab = Integer.parseInt(_masterVO.getProperty("CardGroupSlab3"));
				if (minCardSlab < a && a < midCardSlab) ;
				else if (a > midCardSlab) {
					a = midCardSlab;
				} else if (a < minCardSlab) {
					a = minCardSlab + 1;
				}

				recharges.enterAmount("" + a);
				recharges.selectSubService(serviceMap.get(service)[1]);
				recharges.clickRechargeIcon();
				recharges.enterPin(PIN);

				recharges.clickRechargeButton();
				recharges.clickRechargeButton();
				recharges.clickPrintButton();

				if(!recharges.printButton())
				{
					ExtentI.Markup(ExtentColor.GREEN, "Print clicked successfully");
					ExtentI.attachCatalinaLogsForSuccess();
					ExtentI.attachScreenShot();
				} else {
					currentNode.log(Status.FAIL, "Print click failed");
					ExtentI.attachCatalinaLogs();
					ExtentI.attachScreenShot();
				}
			}
		}
		Log.methodExit(methodname);

	}*/






}
	

