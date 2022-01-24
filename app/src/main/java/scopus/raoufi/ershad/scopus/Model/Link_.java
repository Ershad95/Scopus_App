
package scopus.raoufi.ershad.scopus.Model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "@_fa",
    "@ref",
    "@href"
})
public class Link_ {

    @JsonProperty("@_fa")
    private String fa;
    @JsonProperty("@ref")
    private String ref;
    @JsonProperty("@href")
    private String href;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@_fa")
    public String getFa() {
        return fa;
    }

    @JsonProperty("@_fa")
    public void setFa(String fa) {
        this.fa = fa;
    }

    @JsonProperty("@ref")
    public String getRef() {
        return ref;
    }

    @JsonProperty("@ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty("@href")
    public String getHref() {
        return href;
    }

    @JsonProperty("@href")
    public void setHref(String href) {
        this.href = href;
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
