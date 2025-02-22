package com.apicontrollers.ussd.PrivateRechargeDeActivation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.apicontrollers.ussd.P2PRegistration.USSD_P2PREG_API;
import com.apicontrollers.ussd.PrivateRechargeRegistration.USSD_PRR_API;
import com.apicontrollers.ussd.PrivateRechargeRegistration.USSD_PRR_DP;
import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.commons.GatewayI;
import com.commons.ServicesControllerI;
import com.utils.RandomGeneration;
import com.utils.Validator;
import com.utils._APIUtil;
import com.utils._masterVO;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.XmlPath.CompatibilityMode;

public class USSD_PrivateRechargeDeactivation extends BaseTest{
	
	public static boolean TestCaseCounter = false;
	private final String extentCategory = "API";
	String SID;

	/**
	 * @throws ParseException 
	 * @throws SQLException 
	 *  USSDPRD01
	 * Positive Test Case For Private Recharge Deactivation
	 */
	@Test
	public void A1_PrivateRechargeAPI() throws SQLException, ParseException {
		
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD01");
		USSD_PRR_API privateRecharge = new USSD_PRR_API();
		USSD_P2PREG_API privateRechargeReg = new USSD_P2PREG_API();
		USSD_PRD_API privateRechargeDeactivation = new USSD_PRD_API();
		
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> preapiData = USSD_PRR_DP.getAPIdata();
		String MSISDN = preapiData.get("MSISDN");
		String sid = preapiData.get("SID");
		HashMap<String, String> preapiData2 =new HashMap<String, String>();
		preapiData2.put(privateRechargeReg.MSISDN, MSISDN);	
		preapiData2.put(privateRechargeReg.TYPE, "REGREQ");	
		preapiData2.put(privateRechargeReg.SUB_TYPE, "PRE");
		String preP2PAPI = privateRechargeReg.prepareAPI(preapiData2);
		_APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, preP2PAPI);
		
		String preAPI = privateRecharge.prepareAPI(preapiData);
		_APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, preAPI);
		
		HashMap<String, String> apiData = USSD_PRR_DP.getAPIdata();
		apiData.put(privateRechargeDeactivation.MSISDN, MSISDN);
		apiData.put(privateRechargeDeactivation.TYPE, "DELSID");	
		apiData.put(privateRechargeDeactivation.SID, sid);
		String API = privateRechargeDeactivation.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	}
	
	@Test
	public void B2_PrivateRechargeAPI() throws SQLException, ParseException {
		
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD02");
		USSD_PRD_API privateRecharge = new USSD_PRD_API();
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> apiData = USSD_PRD_DP.getAPIdata();
		String API = privateRecharge.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	}
	
	@Test
	public void C3_PrivateRechargeAPI() throws SQLException, ParseException {

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD03");
		USSD_PRD_API privateRecharge = new USSD_PRD_API();
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> apiData = USSD_PRD_DP.getAPIdata();
		apiData.put(privateRecharge
				.SID, "");
		String API = privateRecharge.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
		
	}
	
	@Test
	public void D4_PrivateRechargeAPI() throws SQLException, ParseException {
		
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD04");
		USSD_PRD_API privateRecharge = new USSD_PRD_API();
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> apiData = USSD_PRD_DP.getAPIdata();
		apiData.put(privateRecharge.MSISDN, "");
		String API = privateRecharge.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	
	}
	
	@Test
	public void E5_PrivateRechargeAPI() throws SQLException, ParseException {
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD05");
		USSD_PRR_API privateRecharge = new USSD_PRR_API();
		USSD_P2PREG_API privateRechargeReg = new USSD_P2PREG_API();
		USSD_PRD_API privateRechargeDeactivation = new USSD_PRD_API();
		  RandomGeneration randomGeneration = new RandomGeneration();
		
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> preapiData = USSD_PRR_DP.getAPIdata();
		String MSISDN = preapiData.get("MSISDN");
		String sid = preapiData.get("SID");
		HashMap<String, String> preapiData2 =new HashMap<String, String>();
		preapiData2.put(privateRechargeReg.MSISDN, MSISDN);	
		preapiData2.put(privateRechargeReg.TYPE, "REGREQ");	
		preapiData2.put(privateRechargeReg.SUB_TYPE, "PRE");
		String preP2PAPI = privateRechargeReg.prepareAPI(preapiData2);
		_APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, preP2PAPI);
		
		String preAPI = privateRecharge.prepareAPI(preapiData);
		_APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, preAPI);
		
		HashMap<String, String> apiData = USSD_PRR_DP.getAPIdata();
		apiData.put(privateRechargeDeactivation.MSISDN, MSISDN);
		apiData.put(privateRechargeDeactivation.TYPE, "DELSID");	
		apiData.put(privateRechargeDeactivation.SID, randomGeneration.randomNumeric(15));
		String API = privateRechargeDeactivation.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	}
	
	
	
	@Test
	public void F6_PrivateRechargeAPI() throws SQLException, ParseException {
		
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD06");
		USSD_PRD_API privateRecharge = new USSD_PRD_API();
        RandomGeneration randomGeneration = new RandomGeneration();
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> apiData = USSD_PRD_DP.getAPIdata();
		apiData.put(privateRecharge.TYPE, "");
		String API = privateRecharge.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	}
	
	@Test
	public void G7_PrivateRechargeAPI() throws SQLException, ParseException {
		
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("USSDPRD07");
		USSD_PRD_API privateRecharge = new USSD_PRD_API();
        RandomGeneration randomGeneration = new RandomGeneration();
		if (TestCaseCounter == false) {
			test = extent.createTest(CaseMaster.getModuleCode());
			TestCaseCounter = true;
		}
		
		currentNode = test.createNode(CaseMaster.getDescription());
		currentNode.assignCategory(extentCategory);
		
		HashMap<String, String> apiData = USSD_PRD_DP.getAPIdata();
		apiData.put(privateRecharge.TYPE, randomGeneration.randomAlphaNumeric(6));
		String API = privateRecharge.prepareAPI(apiData);
		String[] APIResponse = _APIUtil.executeAPI(GatewayI.USSD, ServicesControllerI.P2PReceiver, API);
		_APIUtil.addExecutionRecord(CaseMaster, APIResponse);
		XmlPath xmlPath = new XmlPath(CompatibilityMode.HTML, APIResponse[1]);
		Validator.messageCompare(xmlPath.get(USSD_PRD_API.TXNSTATUS).toString(), CaseMaster.getErrorCode());
	}
}
