
package scopus.raoufi.ershad.scopus.Model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "search-results"
})
public class Model {

    @JsonProperty("search-results")
    private SearchResults searchResults;
    
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    @JsonProperty("search-results")
    public SearchResults getSearchResults() {
        return searchResults;
    }

    @JsonProperty("search-results")
    public void setSearchResults(SearchResults searchResults) {
        this.searchResults = searchResults;
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
