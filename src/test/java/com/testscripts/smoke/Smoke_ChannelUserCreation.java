package com.testscripts.smoke;

import java.text.MessageFormat;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Features.ChannelUser;
import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.classes.MessagesDAO;
import com.classes.UserAccess;
import com.commons.ExcelI;
import com.commons.MasterI;
import com.dbrepository.DBHandler;
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils._masterVO;
import com.utils.constants.Module;
import com.utils.constants.TestCategory;

/*
 * @author PVG
 * This class is created to add Channel Users
 */
@ModuleManager(name = Module.SMOKE_CHANNEL_USER_CREATION)
public class Smoke_ChannelUserCreation extends BaseTest {

    @Test(dataProvider = "Domain&CategoryProvider")
    @TestManager(TestKey = "PRETUPS-411") //TO BE UNCOMMENTED WITH JIRA TEST CASE ID
    public void Test_ChannelUserCreation(int RowNum, String Domain, String Parent, String Category, String geotype) throws InterruptedException {
        final String methodName = "Test_ChannelUserCreation";
        Log.startTestCase(methodName, RowNum, Domain, Parent, Category, geotype);

        CaseMaster CaseMaster1 = _masterVO.getCaseMasterByID("PCHNLCREATION1");
        CaseMaster CaseMaster2 = _masterVO.getCaseMasterByID("PCHNLCREATION2");
        CaseMaster CaseMaster3 = _masterVO.getCaseMasterByID("PCHNLCREATION3");
        CaseMaster CaseMaster4 = _masterVO.getCaseMasterByID("PCHNLCREATION4");
        CaseMaster CaseMaster5 = _masterVO.getCaseMasterByID("PCHNLCREATION5");
        CaseMaster CaseMaster6 = _masterVO.getCaseMasterByID("PCHNLCREATION6");
        CaseMaster CaseMaster7 = _masterVO.getCaseMasterByID("SCHNLCREATION1");
        CaseMaster CaseMaster8 = _masterVO.getCaseMasterByID("SCHNLCREATION2");
        CaseMaster CaseMaster9 = _masterVO.getCaseMasterByID("SCHNLCREATION3");
        CaseMaster CaseMaster10 = _masterVO.getCaseMasterByID("SCHNLCREATION4");
        CaseMaster CaseMaster11 = _masterVO.getCaseMasterByID("SCHNLCREATION5");

        ChannelUser channelUserLogic = new ChannelUser(driver);

        // Test Case Number 1: Channel User Initiation
        currentNode = test.createNode(MessageFormat.format(CaseMaster1.getExtentCase(), Category, Parent)).assignCategory(TestCategory.SMOKE);
        String webAccessAllowed = DBHandler.AccessHandler.webInterface(Category);
        HashMap<String, String> channelresultMap = channelUserLogic.channelUserInitiate(RowNum, Domain, Parent, Category, geotype);

        // Test Case Number 2: Message Validation
        currentNode = test.createNode(MessageFormat.format(CaseMaster7.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
        String[] catCode = DBHandler.AccessHandler.fetchCategoryCodeAndGeographicalDomainType(Category);
        String networkCode = _masterVO.getMasterValue(MasterI.NETWORK_CODE);
        String APPLEVEL = DBHandler.AccessHandler.getPreference(catCode[0], networkCode, UserAccess.userapplevelpreference());

        String intChnlInitiateMsg;
        if (APPLEVEL.equals("0")) {
            intChnlInitiateMsg = MessagesDAO.prepareMessageByKey("user.addchanneluser.addsuccessmessage", channelresultMap.get("uName"));
        } else {
            intChnlInitiateMsg = MessagesDAO.prepareMessageByKey("user.addchanneluser.addsuccessmessageforrequest", channelresultMap.get("uName"));
        }

        Assertion.assertEquals(channelresultMap.get("channelInitiateMsg"), intChnlInitiateMsg);

        if (APPLEVEL.equals("2")) {
            currentNode = test.createNode(MessageFormat.format(CaseMaster2.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            channelresultMap = channelUserLogic.approveLevel1_ChannelUser();

            currentNode = test.createNode(MessageFormat.format(CaseMaster8.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            String intChnlApprove1Msg = MessagesDAO.prepareMessageByKey("user.addchanneluser.level1approvemessagerequiredleveltwoapproval", channelresultMap.get("uName"));
            Assertion.assertEquals(channelresultMap.get("channelApprovelevel1Msg"), intChnlApprove1Msg);

            currentNode = test.createNode(MessageFormat.format(CaseMaster3.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            channelresultMap = channelUserLogic.approveLevel2_ChannelUser();

            currentNode = test.createNode(MessageFormat.format(CaseMaster9.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            String intChnlApprove2Msg = MessagesDAO.prepareMessageByKey("user.addchanneluser.level1approvemessagenotrequiredleveltwoapproval", channelresultMap.get("uName"));
            Assertion.assertEquals(channelresultMap.get("channelApprovelevel2Msg"), intChnlApprove2Msg);

        } else if (APPLEVEL.equals("1")) {
            currentNode = test.createNode(MessageFormat.format(CaseMaster4.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            channelresultMap = channelUserLogic.approveLevel1_ChannelUser();

            currentNode = test.createNode(MessageFormat.format(CaseMaster10.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            String intChnlApproveMsg = MessagesDAO.prepareMessageByKey("user.addchanneluser.level1approvemessagenotrequiredleveltwoapproval", channelresultMap.get("uName"));
            //assertEquals(channelresultMap.get("channelApprovelevel1Msg"), intChnlApproveMsg);
            Assertion.assertEquals(channelresultMap.get("channelApproveMsg"), intChnlApproveMsg);
        } else {
            Log.info("Approval not required.");
        }

        if (webAccessAllowed.equalsIgnoreCase("Y")) {
            currentNode = test.createNode(MessageFormat.format(CaseMaster5.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
            channelUserLogic.changeUserFirstTimePassword();
        }

        currentNode = test.createNode(MessageFormat.format(CaseMaster6.getExtentCase(), Category)).assignCategory(TestCategory.SMOKE);
        channelresultMap = channelUserLogic.changeUserFirstTimePIN();

        currentNode = test.createNode(CaseMaster11.getExtentCase()).assignCategory(TestCategory.SMOKE);
        String intChnlChangePINMsg = MessagesDAO.prepareMessageByKey("user.changepin.msg.updatesuccess");
        Assertion.assertEquals(channelresultMap.get("changePINMsg"), intChnlChangePINMsg);

        Assertion.completeAssertions();
        Log.endTestCase(methodName);
    }

    /* -----------------------  D   A   T   A       P   R   O   V   I   D   E   R ---------------------- */
    /* ------------------------------------------------------------------------------------------------- */

    @DataProvider(name = "Domain&CategoryProvider")
    public Object[][] DomainCategoryProvider() {

        String MasterSheetPath = _masterVO.getProperty("DataProvider");
        ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
        int rowCount = ExcelUtility.getRowCount();
        Object[][] categoryData = new Object[rowCount][5];
        for (int i = 1, j = 0; i <= rowCount; i++, j++) {
            categoryData[j][0] = i;
            categoryData[j][1] = ExcelUtility.getCellData(0, ExcelI.DOMAIN_NAME, i);
            categoryData[j][2] = ExcelUtility.getCellData(0, ExcelI.PARENT_CATEGORY_NAME, i);
            categoryData[j][3] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i);
            categoryData[j][4] = ExcelUtility.getCellData(0, ExcelI.GRPH_DOMAIN_TYPE, i);
        }

        return categoryData;
    }

    /* ------------------------------------------------------------------------------------------------ */
}