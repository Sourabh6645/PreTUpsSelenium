package restassuredapi.test;

import static com.utils.GenerateToken.getAcccessToken;

import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.classes.BaseTest;
import com.classes.CaseMaster;
import com.classes.Login;
import com.commons.ExcelI;
import com.commons.MasterI;
import com.dbrepository.DBHandler;
import com.pretupsControllers.BTSLUtil;
import com.reporting.extent.entity.ModuleManager;
import com.testmanagement.core.TestManager;
import com.utils.Assertion;
import com.utils.ExcelUtility;
import com.utils.Log;
import com.utils.RandomGeneration;
import com.utils._masterVO;
import com.utils.constants.Module;

import restassuredapi.api.addagentapi.AddagentApi;
import restassuredapi.api.loadnetworkPrefixAPI.LoadNetworkPrefixAPI;
import restassuredapi.api.networkPrefixSaveapi.SaveNetworkPrefixAPI;
import restassuredapi.pojo.MasterErrorList;
import restassuredapi.pojo.addagentresponsepojo.AddagentResponsePojo;
import restassuredapi.pojo.addchanneluserrequestpojo.AddChannelUserDetails;
import restassuredapi.pojo.oauthenticationrequestpojo.OAuthenticationRequestPojo;
import restassuredapi.pojo.oauthenticationresponsepojo.OAuthenticationResponsePojo;
import restassuredapi.pojo.saveNetworkReqPojo.SaveNetworkRequestPojo;
import restassuredapi.pojo.saveNetworkRespPojo.NetworkPrefixRespVO;

@ModuleManager(name = Module.REST_SAVE_NETWORK_PREFIX_DETAILS)
public class SaveNetworkPrefixDetails  extends BaseTest {
	
	DateFormat df = new SimpleDateFormat("dd/MM/YY");
    Date dateobj = new Date();
    String currentDate=df.format(dateobj);   
	static String moduleCode;
	private  SaveNetworkRequestPojo saveNetworkRequestPojo = new SaveNetworkRequestPojo();
	private NetworkPrefixRespVO networkPrefixRespVO = new NetworkPrefixRespVO();
	OAuthenticationRequestPojo oAuthenticationRequestPojo= new OAuthenticationRequestPojo();
	OAuthenticationResponsePojo oAuthenticationResponsePojo = new OAuthenticationResponsePojo();
	
	Login login = new Login();
	RandomGeneration randStr = new RandomGeneration();
	Map<String, Object> headerMap = new HashMap<String, Object>();
	private  String domainCode,domainName,parentCatCode,parentCatName,agentCategoryCode,previousUserIDPRefix=null;
	
	
	
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
	public void saveNetworkPrefixdetails(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveNetworkPrefixdetails";
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVENETWORKPREFIX01");
		LoadNetworkPrefixAPI loadNetworkPrefixAPI=new LoadNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		loadNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		loadNetworkPrefixAPI.setNetworkCode(_masterVO.getMasterValue(MasterI.NETWORK_CODE));
		loadNetworkPrefixAPI.setExpectedStatusCode(200);
		loadNetworkPrefixAPI.perform();
		networkPrefixRespVO = loadNetworkPrefixAPI
				.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		 
		
		saveNetworkRequestPojo.setPrepaidSeries(networkPrefixRespVO.getPrepaidSeries());
		saveNetworkRequestPojo.setPostpaidSeries(networkPrefixRespVO.getPostpaidSeries());
		saveNetworkRequestPojo.setPortSeries(networkPrefixRespVO.getPortSeries());
		saveNetworkRequestPojo.setOtherSeries(networkPrefixRespVO.getOtherSeries());
		executeSaveNetworkPrefixAPI(200, loginID, password);
		String message = networkPrefixRespVO.getMessage();
		Assertion.assertEquals(message, "Network prefix successfully updated");
		Assert.assertEquals(message, "Network prefix successfully updated");
		Assertion.completeAssertions();
		
		Log.endTestCase(methodName);
	} 
	
	
	@Test(dataProvider = "userData", priority = 2)
	@TestManager(TestKey = "PRETUPS-002")
	public void saveNetworkPrefixdetailsEmpty(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveNetworkPrefixdetails";
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVENETWORKPREFIX02");
		LoadNetworkPrefixAPI loadNetworkPrefixAPI=new LoadNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		loadNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		loadNetworkPrefixAPI.setNetworkCode(_masterVO.getMasterValue(MasterI.NETWORK_CODE));
		loadNetworkPrefixAPI.setExpectedStatusCode(200);
		loadNetworkPrefixAPI.perform();
		networkPrefixRespVO = loadNetworkPrefixAPI
				.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		 
		
		saveNetworkRequestPojo.setPrepaidSeries("");
		saveNetworkRequestPojo.setPostpaidSeries("");
		saveNetworkRequestPojo.setPortSeries("");
		saveNetworkRequestPojo.setOtherSeries("");
		executeSaveNetworkPrefixAPI(400, loginID, password);
		String message = networkPrefixRespVO.getMessage();
		
		if(networkPrefixRespVO.getErrorMap()!=null && networkPrefixRespVO.getErrorMap().getMasterErrorList() !=null && networkPrefixRespVO.getErrorMap().getMasterErrorList().size()>0) {
			 for(int i=0;i<=networkPrefixRespVO.getErrorMap().getMasterErrorList().size();i++) {
				 MasterErrorList mstrErrlist =  networkPrefixRespVO.getErrorMap().getMasterErrorList().get(i);
				if(mstrErrlist.getErrorMsg().equalsIgnoreCase("Series cannot be left blank")) {
					message=mstrErrlist.getErrorMsg();
					break;
				}
				  
				
			 }
		 }
		 
		System.out.println("Response Message ::: --> " +message);
		Assertion.assertEquals(message, "Series cannot be left blank");
		Assertion.assertEquals(message, "Series cannot be left blank");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}
	

	@Test(dataProvider = "userData", priority = 3)
	@TestManager(TestKey = "PRETUPS-003")
	public void saveNetworkPrefixdetailsduplicate(String loginID, String password, String pin, String parentName, String categoryName,
			String categoryCode) throws Exception {
		final String methodName = "saveNetworkPrefixdetails";
		setTestInitialDetails(methodName, loginID, password, categoryName, "SAVENETWORKPREFIX03");
		LoadNetworkPrefixAPI loadNetworkPrefixAPI=new LoadNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER), getAcccessToken(loginID, password));
		loadNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		loadNetworkPrefixAPI.setNetworkCode(_masterVO.getMasterValue(MasterI.NETWORK_CODE));
		loadNetworkPrefixAPI.setExpectedStatusCode(200);
		loadNetworkPrefixAPI.perform();
		networkPrefixRespVO = loadNetworkPrefixAPI
				.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		
		String paramArgs[] = networkPrefixRespVO.getPrepaidSeries().split(",");
		String firstNumberseries =  paramArgs[0];
		
		saveNetworkRequestPojo.setPrepaidSeries(networkPrefixRespVO.getPrepaidSeries());
				saveNetworkRequestPojo.setPostpaidSeries(networkPrefixRespVO.getPostpaidSeries());
		saveNetworkRequestPojo.setPortSeries(firstNumberseries);
		saveNetworkRequestPojo.setOtherSeries(networkPrefixRespVO.getOtherSeries());
		executeSaveNetworkPrefixAPI(400, loginID, password);
		String message = networkPrefixRespVO.getMessage();
		
		
		
		
		
		
		if(networkPrefixRespVO.getErrorMap()!=null && networkPrefixRespVO.getErrorMap().getMasterErrorList() !=null && networkPrefixRespVO.getErrorMap().getMasterErrorList().size()>0) {
			 for(int i=0;i<=networkPrefixRespVO.getErrorMap().getMasterErrorList().size();i++) {
				 MasterErrorList mstrErrlist =  networkPrefixRespVO.getErrorMap().getMasterErrorList().get(i);
				if(mstrErrlist.getErrorMsg().indexOf(firstNumberseries)>0) {
					message=mstrErrlist.getErrorMsg();
					break;
				}
				  
				
			 }
		 }
		 
		System.out.println("Response Message ::: --> " +message);
		Assertion.assertEquals(message, "Port prepaid series " + firstNumberseries + "already exists in prepaid series");
		Assertion.completeAssertions();
		Log.endTestCase(methodName);
	}

		
	public void executeSaveNetworkPrefixAPI(int statusCode, String username, String password) throws IOException {

		Log.info("Entering executeAddAgentAPI()");
		SaveNetworkPrefixAPI saveNetworkPrefixAPI = new SaveNetworkPrefixAPI(_masterVO.getMasterValue(MasterI.WEB_URL_REST_SWAGGER),
				getAcccessToken(username, password));
		saveNetworkPrefixAPI.addBodyParam(saveNetworkRequestPojo);
		saveNetworkPrefixAPI.logRequestBody(saveNetworkRequestPojo);
		saveNetworkPrefixAPI.setExpectedStatusCode(statusCode);
		saveNetworkPrefixAPI.setContentType(_masterVO.getProperty("contentType"));
		saveNetworkPrefixAPI.perform();
		networkPrefixRespVO = saveNetworkPrefixAPI.getAPIResponseAsPOJO(NetworkPrefixRespVO.class);
		Log.info("Exiting executeAddAgentAPI()");

	}



	public void cleanOperation( ) {
		


	}

	

}
