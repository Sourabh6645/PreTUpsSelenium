package angular.testscripts.prereuisitesangular.Voucher;

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

import angular.feature.Voucher.VoucherExpiryDateUpdate;

@ModuleManager(name = Module.PREREQUISITE_Voucher_Update_ExpiryDate)
public class Voucher_ExpiryDateModification extends BaseTest {

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_01_Test_UserShouleBeAbleToUpdate_VoucherExpiryDateUpdate(String UserCat, String LoginId,
			String Password, String VouchCat) {
		final String methodName = "A_01_Test_UserShouleBeAbleToUpdate_VoucherExpiryDateUpdate";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate01");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), UserCat))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);
		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.performVoucherExpDateUpdate(LoginId, Password, VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_02_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithIncorrectFromAndToSerialSeries(
			String UserCat, String LoginId, String Password, String VouchCat) {
		final String methodName = "A_02_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithIncorrectFromAndToSerialSeries";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate02");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.verifyUserExpiryDateModificationFailesUponIncorrectFromAndToSerialId(LoginId, Password,
				VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_03_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithDifferentDenomination(String UserCat,
			String LoginId, String Password, String VouchCat) {
		final String methodName = "A_03_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithDifferentDenomination";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate03");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.userIsUnableToModifyExpiryDateWithDifferentDenomination(LoginId, Password, VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_04_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusConsumed(String UserCat,
			String LoginId, String Password, String VouchCat) {
		final String methodName = "A_04_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusConsumed";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate04");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.verifyUserIsUnableToModifyExpiryDateOfVoucherStatusConsumed(LoginId, Password, VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusStolen(String UserCat,
			String LoginId, String Password, String VouchCat) {
		final String methodName = "A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusStolen";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate05");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.verifyUserIsUnableToModifyExpiryDateOfVoucherStatusStolen(LoginId, Password, VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusOnHold(String UserCat,
			String LoginId, String Password, String VouchCat) {
		final String methodName = "A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusOnHold";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate06");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.verifyUserIsUnableToModifyExpiryDateOfVoucherStatusOnHold(LoginId, Password, VouchCat);

		Assertion.completeAssertions();
	}

	@Test(dataProvider = "categoryData")
	// @TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST
	// CASE
	public void A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusDamaged(String UserCat,
			String LoginId, String Password, String VouchCat) {
		final String methodName = "A_05_Test_UserShouleNotBeAbleToUpdate_VoucherExpiryDateUpdate_WithStatusDamaged";
		Log.startTestCase(methodName, UserCat, LoginId, Password, VouchCat);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSVoucherUpdateExpDate07");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), LoginId))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherExpiryDateUpdate vchExpDateUpdate = new VoucherExpiryDateUpdate(driver);

		Log.info("Voucher Category Being Passed : " + VouchCat);
		vchExpDateUpdate.verifyUserIsUnableToModifyExpiryDateOfVoucherStatusDamaged(LoginId, Password, VouchCat);

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

		Object[][] Data = new Object[6][4];

		String[] opCatName = { "Super Admin", "Network Admin" };

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

			String[] voucherType = { "Digital", "Physical", "Electronic" };
			for (int excelCounter = 0; excelCounter < voucherType.length; excelCounter++) {

				Data[k][0] = UserCat;
				Data[k][1] = UserLoginId;
				Data[k][2] = UserPassword;
				Data[k][3] = voucherType[excelCounter];

				Log.info("Data" + Data[k][0]);
				Log.info("Data" + Data[k][1]);
				Log.info("Data" + Data[k][2]);
				Log.info("Data" + Data[k][3]);
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
