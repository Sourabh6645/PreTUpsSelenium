
package restassuredapi.pojo.ownerUserListResponsepojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "categoryCode",
    "graphDomainCode",
    "graphDomainName",
    "graphDomainSequenceNumber",
    "graphDomainType",
    "graphDomainTypeName",
    "networkName",
    "parentGraphDomainCode",
    "userId"
})
public class GeographicalAreaList {

    @JsonProperty("categoryCode")
    private String categoryCode;
    @JsonProperty("graphDomainCode")
    private String graphDomainCode;
    @JsonProperty("graphDomainName")
    private String graphDomainName;
    @JsonProperty("graphDomainSequenceNumber")
    private int graphDomainSequenceNumber;
    @JsonProperty("graphDomainType")
    private String graphDomainType;
    @JsonProperty("graphDomainTypeName")
    private String graphDomainTypeName;
    @JsonProperty("networkName")
    private String networkName;
    @JsonProperty("parentGraphDomainCode")
    private String parentGraphDomainCode;
    @JsonProperty("userId")
    private String userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("categoryCode")
    public String getCategoryCode() {
        return categoryCode;
    }

    @JsonProperty("categoryCode")
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @JsonProperty("graphDomainCode")
    public String getGraphDomainCode() {
        return graphDomainCode;
    }

    @JsonProperty("graphDomainCode")
    public void setGraphDomainCode(String graphDomainCode) {
        this.graphDomainCode = graphDomainCode;
    }

    @JsonProperty("graphDomainName")
    public String getGraphDomainName() {
        return graphDomainName;
    }

    @JsonProperty("graphDomainName")
    public void setGraphDomainName(String graphDomainName) {
        this.graphDomainName = graphDomainName;
    }

    @JsonProperty("graphDomainSequenceNumber")
    public int getGraphDomainSequenceNumber() {
        return graphDomainSequenceNumber;
    }

    @JsonProperty("graphDomainSequenceNumber")
    public void setGraphDomainSequenceNumber(int graphDomainSequenceNumber) {
        this.graphDomainSequenceNumber = graphDomainSequenceNumber;
    }

    @JsonProperty("graphDomainType")
    public String getGraphDomainType() {
        return graphDomainType;
    }

    @JsonProperty("graphDomainType")
    public void setGraphDomainType(String graphDomainType) {
        this.graphDomainType = graphDomainType;
    }

    @JsonProperty("graphDomainTypeName")
    public String getGraphDomainTypeName() {
        return graphDomainTypeName;
    }

    @JsonProperty("graphDomainTypeName")
    public void setGraphDomainTypeName(String graphDomainTypeName) {
        this.graphDomainTypeName = graphDomainTypeName;
    }

    @JsonProperty("networkName")
    public String getNetworkName() {
        return networkName;
    }

    @JsonProperty("networkName")
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    @JsonProperty("parentGraphDomainCode")
    public String getParentGraphDomainCode() {
        return parentGraphDomainCode;
    }

    @JsonProperty("parentGraphDomainCode")
    public void setParentGraphDomainCode(String parentGraphDomainCode) {
        this.parentGraphDomainCode = parentGraphDomainCode;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
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
