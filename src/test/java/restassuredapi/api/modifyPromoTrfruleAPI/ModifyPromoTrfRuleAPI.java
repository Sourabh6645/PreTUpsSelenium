package restassuredapi.api.modifyPromoTrfruleAPI;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utils.Log;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import restassuredapi.api.BaseAPI;
import restassuredapi.pojo.addCateogryPojo.AddcategoryReqPojo;
import restassuredapi.pojo.addPromoRuleReqPojo.AddPromoTransferReqVO;
import restassuredapi.pojo.modifyPromoTrfReqPojos.ModifyPromoTrfRequestPojo;

public class ModifyPromoTrfRuleAPI extends BaseAPI {
	


	String apiPath = "/v1/networkadmin/updatePromoTransferData";
	String contentType;
	ModifyPromoTrfRequestPojo modifyPromoTransferReqVO = new ModifyPromoTrfRequestPojo();
	String accessToken;
	
	EncoderConfig encoderconfig = new EncoderConfig();


	public ModifyPromoTrfRuleAPI(String baseURI, String accessToken) {
		super(baseURI);
		this.accessToken = accessToken;
		// TODO Auto-generated constructor stub
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void addBodyParam(ModifyPromoTrfRequestPojo modifyPromoTransferReqVO) {
		this.modifyPromoTransferReqVO = modifyPromoTransferReqVO;
	}
	
	@JsonProperty("identifierType")
	private String identifierType;
	
	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	public String getIdentifierValue() {
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}

	@JsonProperty("identifierValue")
	private String identifierValue;
	
	
	@JsonProperty("idtype")
	private String idtype;
	
	@JsonProperty("idtype")
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("id")
	private String id;
	protected void createRequest() {
		requestSpecBuilder.setBaseUri(baseURI);
		requestSpecBuilder.setBasePath(apiPath);
		requestSpecBuilder.setConfig(RestAssured.config()
				.encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)));
		requestSpecBuilder.setContentType(contentType);
		requestSpecBuilder.setBody(modifyPromoTransferReqVO);
		requestSpecification = requestSpecBuilder.build();
		HashMap<String, String> queryParams = new HashMap<String, String>();
		HashMap<String, String> pathParams = new HashMap<String, String>();
		logApiUrlAndParameters(baseURI, apiPath, queryParams, pathParams);
	}

	@Override
	protected void executeRequest() {
		apiResponse = given().spec(requestSpecification).auth().oauth2(accessToken).post();
		String s = apiResponse.asString();
		Log.info(s);
		System.out.println(s);
	}

	@Override
	protected void validateResponse() {
		responseSpecBuilder.expectStatusCode(expectedStatusCode);
		responseSpecification = responseSpecBuilder.build();
	}



}
