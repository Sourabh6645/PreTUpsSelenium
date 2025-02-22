
package restassuredapi.pojo.focapprovalrequestpojo;

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
    "focApprovalRequests"
})
public class FOCApprovalRequestPojo {

    @JsonProperty("focApprovalRequests")
    private List<FocApprovalRequest> focApprovalRequests = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("focApprovalRequests")
    public List<FocApprovalRequest> getFocApprovalRequests() {
        return focApprovalRequests;
    }

    @JsonProperty("focApprovalRequests")
    public void setFocApprovalRequests(List<FocApprovalRequest> focApprovalRequests) {
        this.focApprovalRequests = focApprovalRequests;
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
