package restassuredapi.test;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classes.BaseTest;
import com.classes.CaseMaster;
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

import restassuredapi.api.ChUserPaymentMethodAndRangeAPI;
import restassuredapi.api.categorylist.CategoryListAPI;
import restassuredapi.api.oauthentication.OAuthenticationAPI;
import restassuredapi.pojo.categorylistresponsepojo.CategoryListResposnePojo;
import restassuredapi.pojo.chuserpaymentmethodandrangeresponsepojo.ChUserPaymentMethodAndRangeResponsePojo;
import restassuredapi.pojo.oauthenticationrequestpojo.OAuthenticationRequestPojo;
import restassuredapi.pojo.oauthenticationresponsepojo.OAuthenticationResponsePojo;

@ModuleManager(name = Module.CH_USER_PAYMENT_METHOD_AND_RANGE)

public class ChUserPaymentMethodAndRange extends BaseTest{
	
	static String moduleCode;
	ChUserPaymentMethodAndRangeResponsePojo chuserpaymentmethodandrangeresponsepojo = new ChUserPaymentMethodAndRangeResponsePojo();
	OAuthenticationRequestPojo oAuthenticationRequestPojo= new OAuthenticationRequestPojo();
	OAuthenticationResponsePojo oAuthenticationResponsePojo = new OAuthenticationResponsePojo();
	
	@DataProvider(name ="userData")
	public Object[][] TestDataFeed(){
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.CHANNEL_USERS_HIERARCHY_SHEET);
		int rowCount = ExcelUtility.getRowCount();

		Object[][] Data = new Object[rowCount][10];
		int j=0;
		for(int i=1;i<=rowCount;i++) {
			Data[j][0]= ExcelUtility.getCellData(0, ExcelI.LOGIN_ID,i);
			Data[j][1] = ExcelUtility.getCellData(0, ExcelI.PASSWORD, i);
			Data[j][2] = ExcelUtility.getCellData(0, ExcelI.MSISDN, i);
			Data[j][3] = ExcelUtility.getCellData(0, ExcelI.PIN, i);
			Data[j][4] = ExcelUtility.getCellData(0, ExcelI.PARENT_CATEGORY_NAME, i);
			Data[j][5] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i);
			Data[j][6] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, i);
			Data[j][7] = ExcelUtility.getCellData(0, ExcelI.EXTERNAL_CODE, i);
			Data[j][8] = ExcelUtility.getCellData(0, ExcelI.USER_NAME, i);
			Data[j][9] = ExcelUtility.getCellData(0, ExcelI.DOMAIN_NAME, i);
			j++;
		}
		return Data;
	}


	
	Map<String, Object> headerMap = new HashMap<String, Object>();


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
	protected static String accessToken;
    

	
	public void setupAuth(String data1, String data2) {
		oAuthenticationRequestPojo.setIdentifierType(_masterVO.getProperty("identifierType"));
		oAuthenticationRequestPojo.setIdentifierValue(data1);
		oAuthenticationRequestPojo.setPasswordOrSmspin(data2);


	}

	public void BeforeMethod(String data1, String data2,String categoryName) throws Exception
	{
		
		final String methodName = "Test_OAuthenticationTest";
		Log.startTestCase(methodName);

		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("OAUTHETICATION1");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));


		currentNode.assignCategory("REST");

		setHeaders();
		setupAuth(data1,data2);
		OAuthenticationAPI oAuthenticationAPI = new OAuthenticationAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER),headerMap);
		oAuthenticationAPI.setContentType(_masterVO.getProperty("contentType"));
		oAuthenticationAPI.addBodyParam(oAuthenticationRequestPojo);
		oAuthenticationAPI.setExpectedStatusCode(200);
		oAuthenticationAPI.perform();
		oAuthenticationResponsePojo = oAuthenticationAPI
				.getAPIResponseAsPOJO(OAuthenticationResponsePojo.class);
		long statusCode = oAuthenticationResponsePojo.getStatus();

		accessToken = oAuthenticationResponsePojo.getToken();
		Assert.assertEquals(statusCode, 200);
		Assertion.assertEquals(Long.toString(statusCode), "200");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}
		
    @Test(dataProvider = "userData")
	@TestManager(TestKey="PRETUPS-15538")
	public void A_01_Test_Login_Success(String loginID, String password, String msisdn, String PIN, String parentName, String categoryName, String categorCode,String externalCode,String userName, String domainName) throws Exception
	{
		final String methodName = "A_01_Test_Login_Success";
		Log.startTestCase(methodName);
		if(_masterVO.getProperty("identifierType").equals("loginid"))
			BeforeMethod(loginID, password,categoryName);
		else if(_masterVO.getProperty("identifierType").equals("msisdn"))
			BeforeMethod(msisdn, PIN,categoryName);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("CHUSERPYMTANDRNG01");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));
		currentNode.assignCategory("REST");
		ChUserPaymentMethodAndRangeAPI chUserPaymentMethodAndRangeAPI=new ChUserPaymentMethodAndRangeAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), accessToken);
		chUserPaymentMethodAndRangeAPI.setContentType(_masterVO.getProperty("contentType"));
		chUserPaymentMethodAndRangeAPI.setchannelUserId("NGD0000032308");
		chUserPaymentMethodAndRangeAPI.settransferType(_masterVO.getProperty("O2CtransferType"));
		chUserPaymentMethodAndRangeAPI.setExpectedStatusCode(200);
		chUserPaymentMethodAndRangeAPI.perform();
		chuserpaymentmethodandrangeresponsepojo = chUserPaymentMethodAndRangeAPI
				.getAPIResponseAsPOJO(ChUserPaymentMethodAndRangeResponsePojo.class);
		
		long statusCode = chuserpaymentmethodandrangeresponsepojo.getStatus();

		Assert.assertEquals(statusCode, 200);
		Assertion.assertEquals(Long.toString(statusCode), "200");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
		
			
	}
    
    @Test(dataProvider = "userData")
   	@TestManager(TestKey="PRETUPS-15539")
    public void A_02_Invalid_channelUserId(String loginID, String password, String msisdn, String PIN, String parentName, String categoryName, String categorCode,String externalCode,String userName, String domainName) throws Exception
	{
		final String methodName = "A_02_Invalid_channelUserId";
		Log.startTestCase(methodName);
		if(_masterVO.getProperty("identifierType").equals("loginid"))
			BeforeMethod(loginID, password,categoryName);
		else if(_masterVO.getProperty("identifierType").equals("msisdn"))
			BeforeMethod(msisdn, PIN,categoryName);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("CHUSERPYMTANDRNG02");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));
		currentNode.assignCategory("REST");
		ChUserPaymentMethodAndRangeAPI chUserPaymentMethodAndRangeAPI=new ChUserPaymentMethodAndRangeAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), accessToken);
		chUserPaymentMethodAndRangeAPI.setContentType(_masterVO.getProperty("contentType"));
		String channelUserId=new RandomGeneration().randomAlphabets(3);
		chUserPaymentMethodAndRangeAPI.setchannelUserId(channelUserId);
		chUserPaymentMethodAndRangeAPI.settransferType(_masterVO.getProperty("O2CtransferType"));
		chUserPaymentMethodAndRangeAPI.setExpectedStatusCode(200);
		chUserPaymentMethodAndRangeAPI.perform();
		chuserpaymentmethodandrangeresponsepojo = chUserPaymentMethodAndRangeAPI
				.getAPIResponseAsPOJO(ChUserPaymentMethodAndRangeResponsePojo.class);
		String message =chuserpaymentmethodandrangeresponsepojo.getMessage();
		
		Assert.assertEquals(message,"User ID is invalid.");
		Assertion.assertEquals(message, "User ID is invalid.");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
		
			
	}
    
    @Test(dataProvider = "userData")
  	@TestManager(TestKey="PRETUPS-15540")
    public void A_03_Test_invalid_transferType(String loginID, String password, String msisdn, String PIN, String parentName, String categoryName, String categorCode,String externalCode,String userName, String domainName) throws Exception
	{
		final String methodName = "A_03_Test_invalid_transferType";
		Log.startTestCase(methodName);
		if(_masterVO.getProperty("identifierType").equals("loginid"))
			BeforeMethod(loginID, password,categoryName);
		else if(_masterVO.getProperty("identifierType").equals("msisdn"))
			BeforeMethod(msisdn, PIN,categoryName);
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("CHUSERPYMTANDRNG03");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));
		currentNode.assignCategory("REST");
		ChUserPaymentMethodAndRangeAPI chUserPaymentMethodAndRangeAPI=new ChUserPaymentMethodAndRangeAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), accessToken);
		chUserPaymentMethodAndRangeAPI.setContentType(_masterVO.getProperty("contentType"));
		chUserPaymentMethodAndRangeAPI.setchannelUserId(loginID);
		chUserPaymentMethodAndRangeAPI.settransferType(new RandomGeneration().randomAlphabets(1));
		chUserPaymentMethodAndRangeAPI.setExpectedStatusCode(200);
		chUserPaymentMethodAndRangeAPI.perform();
		chuserpaymentmethodandrangeresponsepojo = chUserPaymentMethodAndRangeAPI
				.getAPIResponseAsPOJO(ChUserPaymentMethodAndRangeResponsePojo.class);

		String message =chuserpaymentmethodandrangeresponsepojo.getMessage();
		
		Assert.assertEquals(message,"TransferType is invalid.");
		Assertion.assertEquals(message, "TransferType is invalid.");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
		
			
	}


}
