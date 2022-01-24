
package scopus.raoufi.ershad.scopus.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;


@JsonPropertyOrder({
    "@_fa",
    "affilname",
    "affiliation-city",
    "affiliation-country"
})
public class Affiliation {

    @JsonProperty("@_fa")
    private String fa;
    @JsonProperty("affilname")
    private String affilname;
    @JsonProperty("affiliation-city")
    private String affiliationCity;
    @JsonProperty("affiliation-country")
    private String affiliationCountry;
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
	
	

    @JsonProperty("affilname")
    public String getAffilname() {
        return affilname;
    }

    @JsonProperty("affilname")
    public void setAffilname(String affilname) {
        this.affilname = affilname;
    }

    @JsonProperty("affiliation-city")
    public String getAffiliationCity() {
        return affiliationCity;
    }

    @JsonProperty("affiliation-city")
    public void setAffiliationCity(String affiliationCity) {
        this.affiliationCity = affiliationCity;
    }

    @JsonProperty("affiliation-country")
    public String getAffiliationCountry() {
        return affiliationCountry;
    }

    @JsonProperty("affiliation-country")
    public void setAffiliationCountry(String affiliationCountry) {
        this.affiliationCountry = affiliationCountry;
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
