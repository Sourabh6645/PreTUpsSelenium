package angular.testscripts.prereuisitesangular.Voucher;

import java.text.MessageFormat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.commons.ExcelI;
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils._masterVO;
import com.utils.constants.Module;
import com.utils.constants.TestCategory;

import angular.feature.Voucher.VoucherViewBatchList;

@ModuleManager(name = Module.PREREQUISITE_Voucher_View_Batch_List)
public class Voucher_ViewBatchList extends BaseTest {
	@Test(dataProvider = "categoryData")
	@TestManager(TestKey = "PRETUPS-000") // TO BE UNCOMMENTED WITH JIRA TEST CASE
	public void A_01_Test_UserShouldBeAbleTo_ViewBatchDetails(String userCat, String LoginId,
			String Password,String filterType) {
		
		final String methodName = "A_01_Test_UserShouldBeAbleTo_ViewBatchDetails";
		Log.startTestCase(methodName,LoginId,Password,filterType);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("PreTUPSViewBatchDetails01");
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),userCat, filterType))
				.assignCategory(TestCategory.PREREQUISITE);

		VoucherViewBatchList viewBatchList = new VoucherViewBatchList(driver);
		Log.info("Voucher Category Being Passed : " + filterType);
		viewBatchList.performViewBatchList(LoginId, Password, filterType);

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

		Object[][] Data = new Object[8][4];

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

			String[] filterType = { "Mobile", "Batch Number", "Schedule Period","Advanced" };
			for (int excelCounter = 0; excelCounter < filterType.length; excelCounter++) {

				Data[k][0] = UserCat;
				Data[k][1] = UserLoginId;
				Data[k][2] = UserPassword;
				Data[k][3] = filterType[excelCounter];

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
