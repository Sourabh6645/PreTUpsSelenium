package angular.testscripts.prereuisitesangular.TransferRules;

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

import angular.feature.TransferRules.C2S_AddModifyDelete_TransferRule_Feature;

@ModuleManager(name = Module.PREREQUISITE_C2S_AddModifyDelete_TransferRule)
public class C2S_AddModifyDelete_TransferRule_TestScript extends BaseTest {
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_01_Test_C2S_TransferRuleAddModifyAndDelete(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_01_Test_UserShouleBeAbleToUpdate_VoucherExpiryDateUpdate";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule01");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.performAddModifyAndDeleteTransferRule(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_02_Test_C2S_TransferRuleModifyAndDeleteUsingTableIcon(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_02_Test_C2S_TransferRuleModifyAndDeleteUsingTableIcon";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule02");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.performAddModifyAndDeleteTransferRuleUingColumnIcon(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_03_Test_C2S_TransferRule_SelectMultiple_Modify(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_03_Test_C2S_TransferRule_SelectMultiple_Modify";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule03");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.userIsAbleToSelectMultipleTransferRuleForModify(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_04_Test_C2S_TransferRule_SelectMultiple_Delete(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_04_Test_C2S_TransferRule_SelectMultiple_Delete";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule04");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.userIsAbleToSelectMultipleTransferRuleForDelete(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_05_Test_C2S_TransferRule_ViewFilterReset(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_05_Test_C2S_TransferRule_ViewFilterReset";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule05");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.userIsAbleToResetAllViewFilterValue(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_06_Test_C2S_TransferRule_DuplicateEntriesNotAllowed_WhileAddingMultipleTransferRule(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_06_Test_C2S_TransferRule_DuplicateEntriesNotAllowed_WhileAddingMultipleTransferRule";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule06");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.userIsNotAbleToSubmitMultipleTransactionRuleWithDuplicateEntries(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_07_Test_C2S_TransferRule_CopyDuplicateFeature(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_07_Test_C2S_TransferRule_CopyDuplicateFeature";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule07");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.userIsAbleToUseDuplicateValueFeature(LoginId, Password);

		Assertion.completeAssertions();
	}
	
	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_08_Test_C2S_TransferRule_ALLOptionIsSupported_For_CategoryGradeReceiverServiceClass(String UserCat, String LoginId,
			String Password) {
		final String methodName = "A_08_Test_C2S_TransferRule_ALLOptionIsSupported_For_CategoryGradeReceiverServiceClass";
		Log.startTestCase(methodName, UserCat, LoginId, Password);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSC2STransferRule08");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		C2S_AddModifyDelete_TransferRule_Feature c2sTransRule = new C2S_AddModifyDelete_TransferRule_Feature(driver);
		
		c2sTransRule.AllOptionSupportedForCategoryGradeAndReceiverServiceClass(LoginId, Password);

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

		String[] opCatName = { "Network Admin" };

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
