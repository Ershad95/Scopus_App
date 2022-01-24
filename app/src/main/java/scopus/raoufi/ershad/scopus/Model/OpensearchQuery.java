
package scopus.raoufi.ershad.scopus.Model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "@role",
    "@searchTerms",
    "@startPage"
})
public class OpensearchQuery {

    @JsonProperty("@role")
    private String role;
    @JsonProperty("@searchTerms")
    private String searchTerms;
    @JsonProperty("@startPage")
    private String startPage;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@role")
    public String getRole() {
        return role;
    }

    @JsonProperty("@role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("@searchTerms")
    public String getSearchTerms() {
        return searchTerms;
    }

    @JsonProperty("@searchTerms")
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    @JsonProperty("@startPage")
    public String getStartPage() {
        return startPage;
    }

    @JsonProperty("@startPage")
    public void setStartPage(String startPage) {
        this.startPage = startPage;
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
