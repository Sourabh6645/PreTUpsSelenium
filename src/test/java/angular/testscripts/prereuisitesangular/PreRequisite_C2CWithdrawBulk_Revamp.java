package angular.testscripts.prereuisitesangular;

import angular.feature.C2CWithdrawBulkRevamp;
import com.classes.BaseTest;
import com.classes.CONSTANT;
import com.classes.CaseMaster;
import com.commons.EventsI;
import com.commons.ExcelI;
import com.commons.RolesI;
import com.dbrepository.DBHandler;
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.*;
import com.utils.constants.Module;
import com.utils.constants.TestCategory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

@ModuleManager(name = Module.PREREQUISITE_C2C_BULK_WITHDRAW_REVAMP)
public class PreRequisite_C2CWithdrawBulk_Revamp extends BaseTest {

	public PreRequisite_C2CWithdrawBulk_Revamp() {
		CHROME_OPTIONS = CONSTANT.CHROME_OPTION_C2CBULKWITHDRAW ;
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_01_Test_C2CBulkWithdrawal(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_01_Test_C2CBulkWithdrawal";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW1");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawal(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_02_Test_C2CBulkWithdrawalBlankCategory(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_02_Test_C2CBulkWithdrawalBlankCategory";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW2");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalBlankCategory(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}



	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_03_Test_C2CBulkWithdrawalBlankBatchName(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_03_Test_C2CBulkWithdrawalBlankBatchName";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW3");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalBlankBatchName(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}


	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_04_Test_C2CBulkWithdrawalWithoutUpload(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_04_Test_C2CBulkWithdrawalWithoutUpload";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW4");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalWithoutUpload(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_05_Test_C2CBulkWithdrawalResetButton(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_05_Test_C2CBulkWithdrawResetButton";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW5");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalResetButton(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_06_Test_C2CBulkWithdrawalDownloadUserListWithoutCategory(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_06_Test_C2CBulkWithdrawalDownloadUserListWithoutCategory";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW6");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalDownloadUserListWithoutCategory(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_07_Test_C2CBulkWithdrawalDownloadTemplateWithoutCategory(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_07_Test_C2CBulkWithdrawalDownloadTemplateWithoutCategory";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW7");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalDownloadTemplateWithoutCategory(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_08_Test_C2CBulkWithdrawFileUploadType(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) throws InterruptedException {
		final String methodName = "A_08_Test_C2CBulkWithdrawFileUploadType";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW8");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalFileUploadType(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_09_Test_C2CBulkWithdrawBlankPIN(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_09_Test_C2CBulkWithdrawBlankPIN";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW9");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalBlankPIN(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdrawal is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}


	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_10_Test_C2CBulkWithdrawBlankFileUpload(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_10_Test_C2CBulkWithdrawBlankFileUpload";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW10");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalBlankFileUpload(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdrawal is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_11_Test_C2CBulkWithdrawInvalidMSISDN(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) throws InterruptedException {
		final String methodName = "A_11_Test_C2CBulkWithdrawInvalidMSISDN";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW11");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalInvalidMSISDN(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_12_Test_C2CBulkWithdrawBlankDataFileWithHeaderUpload(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) throws InterruptedException {
		final String methodName = "A_12_Test_C2CBulkWithdrawBlankDataFileWithHeaderUpload";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW12");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalBlankDataFileWithHeaderUpload(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_13_Test_C2CBulkWithdrawInvalidHeaderFileUpload(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) throws InterruptedException {
		final String methodName = "A_13_Test_C2CBulkWithdrawInvalidHeaderFileUpload";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW13");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalInvalidHeaderFileUpload(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}


	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_14_Test_C2CBulkWithdrawInvaliDataFileUpload(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) throws InterruptedException {
		final String methodName = "A_14_Test_C2CBulkWithdrawInvaliHeaderFileUpload";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW14");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CWithdraw = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CWithdraw.performC2CBulkWithdrawalInvalidDataFileUpload(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}



	/*@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_02_Test_C2CBulkWithdrawalBlankProduct(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_01_Test_C2CBulkWithdraw";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW3");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CTransfer = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CTransfer.performC2CBulkWithdrawalBlankProduct(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}
*/

	/*@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_04_Test_C2CBulkWithdrawalSymbolBatchName(String FromCategory, String ToCategory, String toMSISDN, String FromPIN, String Domain, String ParentCategory, String geoType, String catCode, int RowNum) {
		final String methodName = "A_04_Test_C2CBulkWithdraw";
		Log.startTestCase(methodName, FromCategory, ToCategory, toMSISDN, FromPIN, Domain, ParentCategory, geoType, RowNum);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PREVAMPC2CWDW4");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), FromCategory, ToCategory)).assignCategory(TestCategory.PREREQUISITE);

		if (CommonUtils.roleCodeExistInLinkSheetRevamp(RolesI.C2C_REVAMP, FromCategory,EventsI.C2CBULKWITHDRAW_EVENT)) {
			String webAccessAllowed = DBHandler.AccessHandler.webInterface(FromCategory);
			C2CWithdrawBulkRevamp C2CTransfer = new C2CWithdrawBulkRevamp(driver);

			if (webAccessAllowed.equals("Y")) {
				C2CTransfer.performC2CBulkWithdrawalSymbolBatchName(FromCategory, ToCategory, toMSISDN, FromPIN, catCode);
			} else {
				Assertion.assertSkip("As webaccess is not allowed for " + FromCategory + ", case is skipped.");
			}
		} else {
			Assertion.assertSkip("C2C Bulk Withdraw is not allowed to category[" + FromCategory + "].");
		}

		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}*/



	/* -----------------------  D   A   T   A       P   R   O   V   I   D   E   R ---------------------- */
	    /* ------------------------------------------------------------------------------------------------- */

	    @DataProvider(name = "categoryData")
	    public Object[][] TestDataFeed1() {
	        String C2CTransferCode = _masterVO.getProperty("C2CWithdrawCode");
	        String MasterSheetPath = _masterVO.getProperty("DataProvider");
			ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.TRANSFER_RULE_SHEET);
			int rowCount = ExcelUtility.getRowCount();
			/*
			 * Array list to store Categories for which C2C withdraw is allowed
			 */
			ArrayList<String> alist1 = new ArrayList<String>();
			ArrayList<String> alist2 = new ArrayList<String>();
			ArrayList<String> categorySize = new ArrayList<String>();
			ArrayList<String> transfer_rule_type = new ArrayList<String>();
			for (int i = 1; i <= rowCount; i++) {
				ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.TRANSFER_RULE_SHEET);
				String services = ExcelUtility.getCellData(0, ExcelI.SERVICES, i);
				ArrayList<String> aList = new ArrayList<String>(Arrays.asList(services.split("[ ]*,[ ]*")));
				if (aList.contains(C2CTransferCode) || aList.contains(C2CTransferCode + "[P]") ||
						aList.contains(C2CTransferCode + "[S]") || aList.contains(C2CTransferCode + "[O]") ||
						aList.contains(C2CTransferCode + "[D]")) {
					ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.TRANSFER_RULE_SHEET);
					alist1.add(ExcelUtility.getCellData(0, ExcelI.TO_CATEGORY, i));
					alist2.add(ExcelUtility.getCellData(0, ExcelI.FROM_CATEGORY, i));
					if (ExcelUtility.getCellData(0, ExcelI.TRF_RULE_TYPE, i).equals(""))
						transfer_rule_type.add("D");
					else
						transfer_rule_type.add(ExcelUtility.getCellData(0, ExcelI.TRF_RULE_TYPE, i));
				}
			}

			ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
			int channelUsersHierarchyRowCount = ExcelUtility.getRowCount();

			/*
			 * Calculate the Count of Users for each category
			 */
			int totalObjectCounter = 0;
			for (int i = 0; i < alist1.size(); i++) {
				int categorySizeCounter = 0;
				for (int excelCounter = 0; excelCounter <= channelUsersHierarchyRowCount; excelCounter++) {
					if (ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, excelCounter).equals(alist1.get(i))) {
						categorySizeCounter++;
					}
				}
				categorySize.add("" + categorySizeCounter);
				totalObjectCounter = totalObjectCounter + categorySizeCounter;
			}

			/*
			 * Counter to count number of users exists in channel users hierarchy sheet
			 * of Categories for which C2C Withdraw is allowed
			 */

			Object[][] Data = new Object[totalObjectCounter][9];

			for (int j = 0, k = 0; j < alist1.size(); j++) {

				ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
				int excelRowSize = ExcelUtility.getRowCount();//-3(for single user run)
				String ChannelUserPIN = null;
				for (int i = 1; i <= excelRowSize; i++) {
					if (ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i).equals(alist2.get(j))) {
						ChannelUserPIN = ExcelUtility.getCellData(0, ExcelI.PIN, i);
						break;
					}
				}

				for (int excelCounter = 1; excelCounter <= excelRowSize; excelCounter++) {
					if (ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, excelCounter).equals(alist1.get(j))) {
						Data[k][0] = alist2.get(j);
						Data[k][1] = alist1.get(j);
						Data[k][2] = ExcelUtility.getCellData(0, ExcelI.MSISDN, excelCounter);
						Data[k][3] = ChannelUserPIN;
						Data[k][4] = ExcelUtility.getCellData(0, ExcelI.DOMAIN_NAME, excelCounter);
						Data[k][5] = ExcelUtility.getCellData(0, ExcelI.PARENT_CATEGORY_NAME, excelCounter);
						Data[k][6] = ExcelUtility.getCellData(0, ExcelI.GRPH_DOMAIN_TYPE, excelCounter);
						Data[k][7] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, excelCounter);
						Data[k][8] = excelCounter;
						k++;
					}
				}

			}

			/*
			 * Clean data on the basis of transfer rules
			 */
			String trfUserLevelAlllow = DBHandler.AccessHandler.getSystemPreference(CONSTANT.TRF_RULE_USER_LEVEL_ALLOW);
			if (trfUserLevelAlllow.equalsIgnoreCase("FALSE")) {
				int q = 0;
				ArrayList<Integer> removeData = new ArrayList<Integer>();
				for (int i = 0; i < alist1.size(); i++) {
					if (transfer_rule_type.get(i).equals("P")) {
						Log.info("From: " + alist2.get(i) + "| To: " + alist1.get(i) + "| TYPE: " + transfer_rule_type.get(i));

						for (int p = 0; p < Data.length; p++) {
							if (Data[p][0].equals(alist2.get(i)) && Data[p][1].equals(alist1.get(i)) && !Data[p][5].equals(alist2.get(i))) {
								Log.info("Data to be removed:[" + p + "]");
								q++;
								removeData.add(p);
							}
						}
					}

					ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
					int excelRowSize = ExcelUtility.getRowCount();

					if (transfer_rule_type.get(i).equals("O")) {
						Log.info("From: " + alist2.get(i) + "| To: " + alist1.get(i) + "| TYPE: " + transfer_rule_type.get(i));
						for (int p = 0; p < Data.length; p++) {
							int k;
							for (k = 1; k <= excelRowSize; k++) {
								if (ExcelUtility.getCellData(0, ExcelI.SEQUENCE_NO, k).equals("1") && ExcelUtility.getCellData(0, ExcelI.DOMAIN_NAME, k).equals(Data[p][4])) {
									break;
								}
							}

							if ((Data[p][0].equals(alist2.get(i)) || Data[p][0].equals(ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, k)))
									&& Data[p][1].equals(alist1.get(i)) && !Data[p][5].equals(alist2.get(i))) {
								Log.info("Data to be removed:[" + p + "]");
								q++;
								removeData.add(p);
							}
						}
					}
				}

				int newObj = Data.length - q;
				Object[][] Data1 = new Object[newObj][8];
				for (int l = 0, m = 0; l < Data.length; l++) {
					if (!removeData.contains(l)) {
						for (int x = 0; x < 8; x++) {
							Data1[m][x] = Data[l][x];
						}
						Log.info(Data1);
						m++;
					}
				}


				return Data1;
			} else {
				return Data;
			}
	    }

	    /* ------------------------------------------------------------------------------------------------ */

	
}
