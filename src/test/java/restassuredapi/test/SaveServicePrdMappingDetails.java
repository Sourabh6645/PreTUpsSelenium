package restassuredapi.test;

import static com.utils.GenerateToken.getAcccessToken;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.classes.Login;
import com.commons.ExcelI;
import com.commons.MasterI;
import com.dbrepository.DBHandler;
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils.RandomGeneration;
import com.utils._masterVO;
import com.utils.constants.Module;

import restassuredapi.api.SaveServicePrdMapingAPI.SaveServicePrdMappingAPI;
import restassuredapi.pojo.BaseResponsePojo;
import restassuredapi.pojo.addchanneluserrequestpojo.AddChannelUserDetails;
import restassuredapi.pojo.oauthenticationrequestpojo.OAuthenticationRequestPojo;
import restassuredapi.pojo.oauthenticationresponsepojo.OAuthenticationResponsePojo;
import restassuredapi.pojo.saveServicePrdMaping.SaveServicePrdMappingReqVO;

@ModuleManager(name = Module.REST_SERVICE_PRD_MAPPING_DATA)
public class SaveServicePrdMappingDetails extends BaseTest{
	DateFormat df = new SimpleDateFormat("dd/MM/YY");
    Date dateobj = new Date();
    String currentDate=df.format(dateobj);   
	static String moduleCode;
	private  SaveServicePrdMappingReqVO saveServicePrdMappingReqVO = new SaveServicePrdMappingReqVO();
	private BaseResponsePojo baseResponsePojo = new BaseResponsePojo();
	OAuthenticationRequestPojo oAuthenticationRequestPojo= new OAuthenticationRequestPojo();
	OAuthenticationResponsePojo oAuthenticationResponsePojo = new OAuthenticationResponsePojo();
	AddChannelUserDetails data = new AddChannelUserDetails();
	Login login = new Login();
	RandomGeneration randStr = new RandomGeneration();
	HashMap<String,String> transferDetails=new HashMap<String,String>();
	Map<String, Object> headerMap = new HashMap<String, Object>();
	private  String domainCode,domainName,parentCatCode,parentCatName,agentCategoryCode,previousUserIDPRefix=null;
	
	
	
	@DataProvider(name = "userData")
	public Object[][] TestDataFeed() {
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.OPERATOR_USERS_HIERARCHY_SHEET);
		int rowCount = ExcelUtility.getRowCount() ;

		Object[][] data = new Object[rowCount][6];
		int j = 0;
		for (int i = 1; i <= rowCount; i++) {
			if(ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, i).equalsIgnoreCase("NWADM")) {
				data[j][0] = ExcelUtility.getCellData(0, ExcelI.LOGIN_ID, i);
				data[j][1] = ExcelUtility.getCellData(0, ExcelI.PASSWORD, i);
				data[j][2] = ExcelUtility.getCellData(0, ExcelI.PIN, i);
				data[j][3] = ExcelUtility.getCellData(0, ExcelI.PARENT_CATEGORY_NAME, i);
				data[j][4] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i);
				data[j][5] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, i);
			j++;
		    }
		}
		Object[][] data2 = new Object[j][6];
		
		for(int k=0;k<data2.length;k++) {
		  for(int m=0;m<5;m++) {	
			  data2[k][m] = data[k][m];
		  }
		}
		
		return data2;
	}

	
	public void setHeaders() {
		headerMap.put("CLIENT_ID", _masterVO.getProperty("CLIENT_ID"));
		headerMap.put("CLIENT_SECRET", _masterVO.getProperty("CLIENT_SECRET"));
		headerMap.put("requestGatewayCode", _masterVO.getProperty("requestGatewayCode"));
		headerMap.put("requestGatewayLoginId", _masterVO.getProperty("requestGatewayLoginID"));
		headerMap.put("requestGatewayPsecure", _masterVO.getProperty("requestGatewayPasswordVMS"));
		headerMap.put("requestGatewayType",_masterVO.getProperty("requestGatewayType") );
		headerMap.put("scope", _masterVO.getProperty("scope"));
		headerMap.put("servicePort", _masterVO.getProperty("servicePort"));
	}
	
	

	public void setTestInitialDetails(String methodName, String loginID, String password, String categoryName,
			String caseId) throws Exception {
		Log.startTestCase(methodName);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID(caseId);
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(), categoryName));
		currentNode.assignCategory("REST");
	}
	
	
	@Test(dataProvider = "userData", priority = 1)
	@TestManager(TestKey = "PRETUPS-001")
	public void saveServicePrdDetailsPositve(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveServicePrdDetailsPositve";
		String message=null;
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVESERVICEPRDMAPPING01");
		
		SaveServicePrdMappingAPI saveServicePrdMappingAPI=new SaveServicePrdMappingAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		cleanOperation("GRC","1");
		saveServicePrdMappingReqVO.setSelectorCode("1");
		saveServicePrdMappingReqVO.setServiceType("GRC");
		saveServicePrdMappingReqVO.setAmount(10000);
		saveServicePrdMappingReqVO.setModifyAllowed("Y");
		saveServicePrdMappingAPI.addBodyParam(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.logRequestBody(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.setExpectedStatusCode(200);
		saveServicePrdMappingAPI.setContentType(_masterVO.getProperty("contentType"));
		saveServicePrdMappingAPI.perform();
		baseResponsePojo = saveServicePrdMappingAPI.getAPIResponseAsPOJO(BaseResponsePojo.class);
		Log.info("Exiting executeSaveProductmapping details ()" + baseResponsePojo.getMessage());
		message=baseResponsePojo.getMessage();
		Assertion.assertEquals(message, "Selector amount mapping is successfully added in the system.");
		Assert.assertEquals(message, "Selector amount mapping is successfully added in the system.");
		Assertion.completeAssertions();
		
		
		
	
	}

	
	
	
	@Test(dataProvider = "userData", priority = 2)
	@TestManager(TestKey = "PRETUPS-002")
	public void saveServicePrdDetailsNegative1(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveServicePrdDetailsPositve";
		String message=null;
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVESERVICEPRDMAPPING02");
		
		SaveServicePrdMappingAPI saveServicePrdMappingAPI=new SaveServicePrdMappingAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		saveServicePrdMappingReqVO.setSelectorCode("1");
		saveServicePrdMappingReqVO.setServiceType("GRC");
		saveServicePrdMappingReqVO.setAmount(10000);
		saveServicePrdMappingReqVO.setModifyAllowed("Y");
		saveServicePrdMappingAPI.addBodyParam(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.logRequestBody(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.setExpectedStatusCode(400);
		saveServicePrdMappingAPI.setContentType(_masterVO.getProperty("contentType"));
		saveServicePrdMappingAPI.perform();
		baseResponsePojo = saveServicePrdMappingAPI.getAPIResponseAsPOJO(BaseResponsePojo.class);
		Log.info("Exiting executeSaveProductmapping details ()" + baseResponsePojo.getMessage());
		message=baseResponsePojo.getMessage();
		Assertion.assertEquals(message, "Selector amount mapping already exist in the system.");
		Assert.assertEquals(message, "Selector amount mapping already exist in the system.");
		Assertion.completeAssertions();
		cleanOperation(saveServicePrdMappingReqVO.getServiceType(),saveServicePrdMappingReqVO.getSelectorCode());
		
		
	
	}
	
	
	
	@Test(dataProvider = "userData", priority = 3)
	@TestManager(TestKey = "PRETUPS-002")
	public void saveServicePrdDetailsNegative2(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveServicePrdDetailsPositve";
		String message=null;
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVESERVICEPRDMAPPING03");
		
		SaveServicePrdMappingAPI saveServicePrdMappingAPI=new SaveServicePrdMappingAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		saveServicePrdMappingReqVO.setSelectorCode("-1");
		saveServicePrdMappingReqVO.setServiceType("GRC");
		saveServicePrdMappingReqVO.setAmount(0);
		saveServicePrdMappingReqVO.setModifyAllowed("Y");
		saveServicePrdMappingAPI.addBodyParam(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.logRequestBody(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.setExpectedStatusCode(400);
		saveServicePrdMappingAPI.setContentType(_masterVO.getProperty("contentType"));
		saveServicePrdMappingAPI.perform();
		baseResponsePojo = saveServicePrdMappingAPI.getAPIResponseAsPOJO(BaseResponsePojo.class);
		Log.info("Exiting executeSaveProductmapping details ()" + baseResponsePojo.getMessage());
		message=baseResponsePojo.getMessage();
		Assertion.assertEquals(message, "Invalid amount");
		Assert.assertEquals(message, "Invalid amount");
		Assertion.completeAssertions();
		cleanOperation(saveServicePrdMappingReqVO.getServiceType(),saveServicePrdMappingReqVO.getSelectorCode());
		
		
	
	}
	
	
	
	@Test(dataProvider = "userData", priority = 4)
	@TestManager(TestKey = "PRETUPS-003")
	public void saveServicePrdDetailsNegative4(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveServicePrdDetailsPositve";
		String message=null;
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVESERVICEPRDMAPPING04");
		
		SaveServicePrdMappingAPI saveServicePrdMappingAPI=new SaveServicePrdMappingAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		saveServicePrdMappingReqVO.setSelectorCode("0");
		saveServicePrdMappingReqVO.setServiceType("GRC");
		saveServicePrdMappingReqVO.setAmount(0);
		saveServicePrdMappingReqVO.setModifyAllowed("Y");
		saveServicePrdMappingAPI.addBodyParam(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.logRequestBody(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.setExpectedStatusCode(400);
		saveServicePrdMappingAPI.setContentType(_masterVO.getProperty("contentType"));
		saveServicePrdMappingAPI.perform();
		baseResponsePojo = saveServicePrdMappingAPI.getAPIResponseAsPOJO(BaseResponsePojo.class);
		Log.info("Exiting executeSaveProductmapping details ()" + baseResponsePojo.getMessage());
		message=baseResponsePojo.getMessage();
		Assertion.assertEquals(message, "Invalid amount");
		Assert.assertEquals(message, "Invalid amount");
		Assertion.completeAssertions();
		
		
		
	
	}
	
	
	
	@Test(dataProvider = "userData", priority = 5)
	@TestManager(TestKey = "PRETUPS-004")
	public void saveServicePrdDetailsNegative5(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveServicePrdDetailsPositve";
		String message=null;
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVESERVICEPRDMAPPING04");
		
		SaveServicePrdMappingAPI saveServicePrdMappingAPI=new SaveServicePrdMappingAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		saveServicePrdMappingReqVO.setSelectorCode("1");
		saveServicePrdMappingReqVO.setServiceType("GRC1");
		saveServicePrdMappingReqVO.setAmount(10000);
		saveServicePrdMappingReqVO.setModifyAllowed("Y");
		saveServicePrdMappingAPI.addBodyParam(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.logRequestBody(saveServicePrdMappingReqVO);
		saveServicePrdMappingAPI.setExpectedStatusCode(400);
		saveServicePrdMappingAPI.setContentType(_masterVO.getProperty("contentType"));
		saveServicePrdMappingAPI.perform();
		baseResponsePojo = saveServicePrdMappingAPI.getAPIResponseAsPOJO(BaseResponsePojo.class);
		Log.info("Exiting executeSaveProductmapping details ()" + baseResponsePojo.getMessage());
		message=baseResponsePojo.getMessage();
		Assertion.assertEquals(message, "Invalid service type.");
		Assert.assertEquals(message, "Invalid service type.");
		Assertion.completeAssertions();
		
		
		
	
	}


	private void cleanOperation(String serviceType,String selectorCode) {
		
		Log.info("deleting category code : " + parentCatCode);
		DBHandler.AccessHandler.deleteServicePrdMappingData(serviceType,selectorCode);
		
	}

}
