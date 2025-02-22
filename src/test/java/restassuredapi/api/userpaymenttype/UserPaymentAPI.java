package restassuredapi.api.userpaymenttype;



import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import restassuredapi.api.BaseAPI;
import restassuredapi.pojo.userpaymentrequestpojo.UserPaymentRequestpojo;
import restassuredapi.pojo.userpaymentresponsepojo.UserPaymentResponsepojo;

import java.util.HashMap;

public class UserPaymentAPI extends BaseAPI {
	

	
	
	String apiPath="/v1/c2sReceiver/usrpmtype";
	
	String contentType;
	String accessToken;
	UserPaymentRequestpojo userPaymentRequestpojo = new UserPaymentRequestpojo();
	EncoderConfig encoderconfig = new EncoderConfig();
	
	public UserPaymentAPI(String baseURI,String accessToken) {
		super(baseURI);
		this.accessToken=accessToken;
	}
	 public void setContentType(String contentType) {
	        this.contentType = contentType;
	    }
	 
	 public void addBodyParam(UserPaymentRequestpojo userPaymentRequestpojo) 
	 {
			this.userPaymentRequestpojo =userPaymentRequestpojo;
	 }
	 @Override
	protected void createRequest() {
		requestSpecBuilder.setBaseUri(baseURI);
		requestSpecBuilder.setBasePath(apiPath);
		requestSpecBuilder.setConfig(RestAssured.config()
                .encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)));
		requestSpecBuilder.setContentType(contentType);
		requestSpecBuilder.setBody(userPaymentRequestpojo);
		requestSpecification = requestSpecBuilder.build();
		 HashMap<String, String> queryParams = new HashMap<String, String>();
		 HashMap<String, String> pathParams = new HashMap<String, String>();
		 logApiUrlAndParameters(baseURI, apiPath, queryParams, pathParams);
	}

	@Override
	protected void executeRequest() {
		apiResponse = given().spec(requestSpecification).auth().oauth2(accessToken).post();
		String s=apiResponse.asString();
		System.out.println(s);
	}

	@Override
	protected void validateResponse() {
		responseSpecBuilder.expectStatusCode(expectedStatusCode);
		responseSpecification = responseSpecBuilder.build();
		apiResponse.then().spec(responseSpecification);
	}



}



