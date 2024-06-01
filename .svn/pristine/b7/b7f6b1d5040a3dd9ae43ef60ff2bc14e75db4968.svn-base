package angular.testscripts.prereuisitesangular.loginActivityLoad;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.commons.ExcelI;
import com.reporting.extent.entity.ModuleManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils._masterVO;
import com.utils.constants.Module;
import com.utils.constants.TestCategory;

import angular.classes.LoginRevamp;

@ModuleManager(name = Module.PREREQUISITE_UserLoginTest)
public class LoginActivityLoadTest extends BaseTest {

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void LoginActivityTest(String LoginId, String Password,int newTab) {
		final String methodName = "LoginActivityTest";
		Log.startTestCase(methodName, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSLoginTest01");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		LoginRevamp login = new LoginRevamp();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		if(newTab == 0) {
			login.LoginAsUser(driver, LoginId, Password);
		}else {
			((JavascriptExecutor)driver).executeScript("window.open()");
			
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(newTab));
			login.LoginAsUser(driver, LoginId, Password);
			//login.LoginAsUserInNewTab(driver, LoginId, Password);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()=' Configurations ']")));
		
		if(newTab == 49) {
			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Assertion.completeAssertions();
	}

	/* ----------------------- D A T A P R O V I D E R ---------------------- */
	/*
	 * -----------------------------------------------------------------------------
	 * --------------------
	 */

	@DataProvider(name = "categoryData")
	public Object[][] TestDataFeed1() {

		String MasterSheetPath = _masterVO.getProperty("DataProvider");

		/*
		 * Counter to count number of users exists in channel users hierarchy sheet of
		 * Categories for which C2C Withdraw is allowed
		 */
		
		int dataToUse =50;
		
		Object[][] Data = new Object[dataToUse][3];
		
		
		
			ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
			int excelRowSize = ExcelUtility.getRowCount();
			String UserLoginId = null;
			String UserPassword = null;
			for (int i = 0; i <dataToUse; i++) {
				UserLoginId = ExcelUtility.getCellData(0, ExcelI.LOGIN_ID, i+1);
				UserPassword = ExcelUtility.getCellData(0, ExcelI.PASSWORD, i+1);
				Data[i][0] = UserLoginId;
				Data[i][1] = UserPassword;
				
				Data[i][2] = i;

				Log.info("Data" + Data[i][0]);
				Log.info("Data" + Data[i][1]);
				Log.info("Data" + Data[i][2]);
				Log.info("Value of i" + i);
			}

		

		return Data;
	}
	/*
	 * -----------------------------------------------------------------------------
	 * -------------------
	 */

}
