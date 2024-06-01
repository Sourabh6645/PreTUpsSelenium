package com.testscripts.sit;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.Features.O2CTransfer;
import com.classes.BaseTest;
import com.classes.CONSTANT;
import com.commons.RolesI;
import com.reporting.extent.entity.ModuleManager;
import com.sshmanager.SSHService;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.Log;
import com.utils._masterVO;
import com.utils.constants.Module;
import com.utils.constants.TestCategory;

@ModuleManager(name = Module.SIT_VOUCHER_TRACKING_REPORT)
public class SIT_VoucherConsumptionReport extends BaseTest {

	 @Test
	    @TestManager(TestKey = "PRETUPS-404") // TO BE UNCOMMENTED BY WITH JIRA TEST CASE ID
	    public void Test_CreateVoucherConsumptionReport() throws InterruptedException {
	        final String methodName = "Test_CreateVoucherConsumptionReport";
	        Log.startTestCase(methodName);
	        ArrayList<String> Array = new ArrayList<String>();
	        O2CTransfer o2cTrans = new O2CTransfer(driver);
	        Array= initializeTestData();

	        // Test Case Number 1: Network Admin Creation
	        
	        ScriptExecution();
	       for(int i=0;i<Array.size();i++) {
	    	   currentNode = test.createNode(MessageFormat.format(_masterVO.getCaseMasterByID("VCR1").getExtentCase(), Array.get(i)))
		                .assignCategory(TestCategory.SIT);
	        o2cTrans.voucherConsumptionReport(Array.get(i));
	       }
	        Assertion.completeAssertions();
	        Log.endTestCase(methodName);
	    }
	 
	    public void ScriptExecution()
		{
			Log.info("Trying to execute Script");
			SSHService.executeScript("VoucherConsumptionReport.sh");
			Log.info("Script executed successfully");
		}
	    
	    /* -----------------------  H   E   L   P   E   R       M   E   T   H   O   D   S ------------------ */
	    /* ------------------------------------------------------------------------------------------------- */
	    private ArrayList<String> initializeTestData() {
	      
	    	Log.info("Trying to get User with Access: " + RolesI.C2C_VOUCHERTRACKINGREPORT);
	    	ArrayList<String> Array = new ArrayList<String>();
	    	Map<String, String> resultMap = new HashMap<String, String>();
	    	for (int i = 0; i<CONSTANT.USERACCESSDAO.length; i++) {
	    		if (CONSTANT.USERACCESSDAO[i][3].equals(RolesI.C2C_VOUCHERTRACKINGREPORT)) {
	    			Array.add(CONSTANT.USERACCESSDAO[i][4].toString());
	    		}
	    	}
	    	
	    	
	    return Array;
	    }
	
	
}
