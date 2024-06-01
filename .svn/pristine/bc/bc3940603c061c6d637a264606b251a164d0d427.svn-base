package angular.testscripts.prereuisitesangular.MessageGateway;

import java.text.MessageFormat;

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

import angular.feature.MessageGateway.MessageGatewayFeature;

@ModuleManager(name = Module.PREREQUISITE_MessageGateway)
public class MessageGatewayTestScript extends BaseTest {

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_01_Test_MessageGateway_AddModifyAndDelete(String UserCat, String LoginId, String Password) {
		final String methodName = "A_01_Test_MessageGateway_AddModifyAndDelete";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSMessageGatway01");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		MessageGatewayFeature mgf = new MessageGatewayFeature(driver);

		mgf.AddModifyDelete_MessageGateway(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_02_Test_MessageGateway_CheckTableHeaders(String UserCat, String LoginId, String Password) {
		final String methodName = "A_02_Test_MessageGateway_CheckTableHeaders";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSMessageGatway02");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		MessageGatewayFeature mgf = new MessageGatewayFeature(driver);

		mgf.MessageGatewayTableHeading(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_03_Test_MessageGatewayCheck_ErrorMessage(String UserCat, String LoginId, String Password) {
		final String methodName = "A_03_Test_MessageGatewayCheck_ErrorMessage";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSMessageGatway03");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		MessageGatewayFeature mgf = new MessageGatewayFeature(driver);

		mgf.MessageGatewayCheck_ErrorMessage(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_04_Test_MessageGateway_VerifyErrorMessage_UponProviding_exitingGatewayName(String UserCat, String LoginId, String Password) {
		final String methodName = "A_04_Test_MessageGateway_VerifyErrorMessage_UponProviding_exitingGatewayName";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSMessageGatway03");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		MessageGatewayFeature mgf = new MessageGatewayFeature(driver);

		mgf.MessageGateway_VerifyErrorMessage_UponProviding_exitingGatewayName(LoginId, Password);

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

		Object[][] Data = new Object[1][3];

		String[] opCatName = { "Super Admin" };

		for (int j = 0, k = 0; j < opCatName.length; j++) {

			ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.OPERATOR_USERS_HIERARCHY_SHEET);
			int excelRowSize = ExcelUtility.getRowCount();
			String UserLoginId = null;
			String UserPassword = null;
			String UserCat = null;
			for (int i = 1; i <= excelRowSize; i++) {
				if (ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i).equals(opCatName[j])) {
					UserCat = ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i);
					UserLoginId = ExcelUtility.getCellData(0, ExcelI.LOGIN_ID, i);
					UserPassword = ExcelUtility.getCellData(0, ExcelI.PASSWORD, i);
					break;
				}
			}

			for (int excelCounter = 0; excelCounter < 1; excelCounter++) {

				Data[k][0] = UserCat;
				Data[k][1] = UserLoginId;
				Data[k][2] = UserPassword;

				Log.info("Data" + Data[k][0]);
				Log.info("Data" + Data[k][1]);
				Log.info("Data" + Data[k][2]);
				Log.info("Value of k" + k);
				k++;

			}

		}

		return Data;
	}
	/*
	 * -----------------------------------------------------------------------------
	 * -------------------
	 */

}
