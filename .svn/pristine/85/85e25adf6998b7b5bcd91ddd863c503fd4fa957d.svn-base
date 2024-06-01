package restassuredapi.test;

import static com.utils.GenerateToken.getAcccessToken;

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
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils._masterVO;
import com.utils.constants.Module;

import restassuredapi.api.loadnetworkPrefixAPI.LoadNetworkPrefixAPI;
import restassuredapi.api.oauthentication.OAuthenticationAPI;
import restassuredapi.pojo.oauthenticationrequestpojo.OAuthenticationRequestPojo;
import restassuredapi.pojo.oauthenticationresponsepojo.OAuthenticationResponsePojo;
import restassuredapi.pojo.saveNetworkRespPojo.NetworkPrefixRespVO;

@ModuleManager(name = Module.REST_LOAD_NETWORK_PREFIX_DETAILS)
public class LoadNetworkPrefixDetailsTest extends BaseTest {
	
	static String moduleCode;
	NetworkPrefixRespVO networkPrefixRespVO = new NetworkPrefixRespVO();
	OAuthenticationRequestPojo oAuthenticationRequestPojo= new OAuthenticationRequestPojo();
	OAuthenticationResponsePojo oAuthenticationResponsePojo = new OAuthenticationResponsePojo();

	/*
	@DataProvider(name = "userData")
	public Object[][] TestDataFeed() {
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.OPERATOR_USERS_HIERARCHY_SHEET);
		int rowCount = ExcelUtility.getRowCount();

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
	} */
	
	
	
	
	
	@DataProvider(name ="userData")
	public Object[][] TestDataFeed(){
		String MasterSheetPath = _masterVO.getProperty("DataProvider");
		ExcelUtility.setExcelFile(MasterSheetPath, ExcelI.OPERATOR_USERS_HIERARCHY_SHEET);
		int rowCount = ExcelUtility.getRowCount();

		Object[][] data = new Object[rowCount][10];
		int j=0;
		for(int i=1;i<=rowCount;i++) {
			if(ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, i).equalsIgnoreCase("NWADM")) {
				data[j][0]= ExcelUtility.getCellData(0, ExcelI.LOGIN_ID,i);
				data[j][1] = ExcelUtility.getCellData(0, ExcelI.PASSWORD, i);
				data[j][2] = ExcelUtility.getCellData(0, ExcelI.MSISDN, i);
				data[j][3] = ExcelUtility.getCellData(0, ExcelI.PIN, i);
				data[j][4] = ExcelUtility.getCellData(0, ExcelI.PARENT_CATEGORY_NAME, i);
			data[j][5] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_NAME, i);
			data[j][6] = ExcelUtility.getCellData(0, ExcelI.CATEGORY_CODE, i);
			data[j][7] = ExcelUtility.getCellData(0, ExcelI.EXTERNAL_CODE, i);
			data[j][8] = ExcelUtility.getCellData(0, ExcelI.USER_NAME, i);
			data[j][9] = ExcelUtility.getCellData(0, ExcelI.DOMAIN_NAME, i);
			j++;
			}
		}
		
Object[][] data2 = new Object[j][10];
		
		for(int k=0;k<data2.length;k++) {
		  for(int m=0;m<10;m++) {	
			  data2[k][m] = data[k][m];
		  }
		}
		
		
		return data2;
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
	 
	 
	 
	 
	 
	    @Test(dataProvider = "userData")
		@TestManager(TestKey="PRETUPS-6175")
		public void A_01_Test_loadNetworkPrefixDetails_positive(String loginID, String password, String msisdn, String PIN, String parentName, String categoryName, String categorCode,String externalCode,String userName, String domainName) throws Exception
		{
	    	final String methodName ="loadNetworkPrefixDetails";
	 
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("LOADNETWORKPREFIX01");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));
		currentNode.assignCategory("REST");
		
		LoadNetworkPrefixAPI loadNetworkPrefixAPI=new LoadNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		loadNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		loadNetworkPrefixAPI.setNetworkCode(_masterVO.getMasterValue(MasterI.NETWORK_CODE));
		loadNetworkPrefixAPI.setExpectedStatusCode(200);
		loadNetworkPrefixAPI.perform();
		networkPrefixRespVO = loadNetworkPrefixAPI
				.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		int statusCode ;
		statusCode = networkPrefixRespVO.getStatus();
	
		Assert.assertEquals(statusCode,200);
		Assertion.assertEquals(Integer.toString(statusCode), "200");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	 

		}
	    
	    
	    @Test(dataProvider = "userData")
		@TestManager(TestKey="PRETUPS-6176")
		public void A_02_Test_loadNetworkPrefixDetails_norecord(String loginID, String password, String msisdn, String PIN, String parentName, String categoryName, String categorCode,String externalCode,String userName, String domainName) throws Exception
		{
	    	final String methodName ="A_02_Test_loadNetworkPrefixDetails_norecord";
	 
		CaseMaster CaseMaster = _masterVO.getCaseMasterByID("LOADNETWORKPREFIX02");
		moduleCode = CaseMaster.getModuleCode();
		currentNode = test.createNode(MessageFormat.format(CaseMaster.getExtentCase(),categoryName));
		currentNode.assignCategory("REST");
		
		LoadNetworkPrefixAPI loadNetworkPrefixAPI=new LoadNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		loadNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		loadNetworkPrefixAPI.setNetworkCode("Invalid network code");
		loadNetworkPrefixAPI.setExpectedStatusCode(200);
		loadNetworkPrefixAPI.perform();
		networkPrefixRespVO = loadNetworkPrefixAPI
				.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		int statusCode ;
		statusCode = networkPrefixRespVO.getStatus();
	
		Assert.assertEquals(statusCode,400);
		Assertion.assertEquals(Integer.toString(statusCode), "400");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	 

		}



	

}
