package restassuredapi.pojo.pendingapprovaltxncountresponsepojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"errorMap",
"errorcode",
"message",
"messageCode",
"referenceId",
"service",
"status",
"successList",
"totlaTrnxCount"
})
public class PendingTxnListResponsePojo {

@JsonProperty("errorMap")
private ErrorMap errorMap;
@JsonProperty("errorcode")
private String errorcode;
@JsonProperty("message")
private String message;
@JsonProperty("messageCode")
private String messageCode;
@JsonProperty("referenceId")
private String referenceId;
@JsonProperty("service")
private String service;
@JsonProperty("status")
private String status;
@JsonProperty("successList")
private List<SuccessList> successList = null;
@JsonProperty("totlaTrnxCount")
private String totlaTrnxCount;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("errorMap")
public ErrorMap getErrorMap() {
return errorMap;
}

@JsonProperty("errorMap")
public void setErrorMap(ErrorMap errorMap) {
this.errorMap = errorMap;
}

@JsonProperty("errorcode")
public String getErrorcode() {
return errorcode;
}

@JsonProperty("errorcode")
public void setErrorcode(String errorcode) {
this.errorcode = errorcode;
}

@JsonProperty("message")
public String getMessage() {
return message;
}

@JsonProperty("message")
public void setMessage(String message) {
this.message = message;
}

@JsonProperty("messageCode")
public String getMessageCode() {
return messageCode;
}

@JsonProperty("messageCode")
public void setMessageCode(String messageCode) {
this.messageCode = messageCode;
}

@JsonProperty("referenceId")
public String getReferenceId() {
return referenceId;
}

@JsonProperty("referenceId")
public void setReferenceId(String referenceId) {
this.referenceId = referenceId;
}

@JsonProperty("service")
public String getService() {
return service;
}

@JsonProperty("service")
public void setService(String service) {
this.service = service;
}

@JsonProperty("status")
public String getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(String status) {
this.status = status;
}

@JsonProperty("successList")
public List<SuccessList> getSuccessList() {
return successList;
}

@JsonProperty("successList")
public void setSuccessList(List<SuccessList> successList) {
this.successList = successList;
}

@JsonProperty("totlaTrnxCount")
public String getTotlaTrnxCount() {
return totlaTrnxCount;
}

@JsonProperty("totlaTrnxCount")
public void setTotlaTrnxCount(String totlaTrnxCount) {
this.totlaTrnxCount = totlaTrnxCount;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

