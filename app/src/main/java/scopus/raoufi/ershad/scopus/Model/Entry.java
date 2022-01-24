package scopus.raoufi.ershad.scopus.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "@_fa",
    "link",
    "prism:url",
    "dc:identifier",
    "eid",
    "dc:title",
    "dc:creator",
    "prism:publicationName",
    "prism:issn",
    "prism:pageRange",
    "prism:coverDate",
    "prism:coverDisplayDate",
    "prism:doi",
    "citedby-count",
    "prism:aggregationType",
    "subtype",
    "subtypeDescription",
    "source-id",
    "prism:eIssn",
    "prism:volume",
    "pii",
    "affiliation",
    "prism:issueIdentifier",
    "article-number"
})
public class Entry {

    @JsonIgnore
    private int id;
    @JsonProperty("@_fa")
    private String fa;
    @JsonProperty("link")
    private List<Link_> link = null;
    @JsonProperty("prism:url")
    private String prismUrl;
    @JsonProperty("dc:identifier")
    private String dcIdentifier;
    @JsonProperty("eid")
    private String eid;
    @JsonProperty("dc:title")
    private String dcTitle;
    @JsonProperty("dc:creator")
    private String dcCreator;
    @JsonProperty("prism:publicationName")
    private String prismPublicationName;
    @JsonProperty("prism:issn")
    private String prismIssn;
    @JsonProperty("prism:pageRange")
    private String prismPageRange;
    @JsonProperty("prism:coverDate")
    private String prismCoverDate;
    @JsonProperty("prism:coverDisplayDate")
    private String prismCoverDisplayDate;
    @JsonProperty("prism:doi")
    private String prismDoi;
    @JsonProperty("citedby-count")
    private String citedbyCount;
    @JsonProperty("prism:aggregationType")
    private String prismAggregationType;
    @JsonProperty("subtype")
    private String subtype;
    @JsonProperty("subtypeDescription")
    private String subtypeDescription;
    @JsonProperty("source-id")
    private String sourceId;
    @JsonProperty("prism:eIssn")
    private String prismEIssn;
    @JsonProperty("prism:volume")
    private String prismVolume;
    @JsonProperty("pii")
    private String pii;
    @JsonProperty("affiliation")
    private List<Affiliation> affiliation = null;
    @JsonProperty("prism:issueIdentifier")
    private String prismIssueIdentifier;
    @JsonProperty("article-number")
    private String articleNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    
   @JsonIgnore
    public int getID()
    {
        return id;
    }
    @JsonIgnore
    void setID(int id) {
        this.id=id;
    }
    
    @JsonProperty("@_fa")
    public String getFa() {
        return fa;
    }

    @JsonProperty("@_fa")
    public void setFa(String fa) {
        this.fa = fa;
    }

    @JsonProperty("link")
    public List<Link_> getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(List<Link_> link) {
        this.link = link;
    }

    @JsonProperty("prism:url")
    public String getPrismUrl() {
        return prismUrl;
    }

    @JsonProperty("prism:url")
    public void setPrismUrl(String prismUrl) {
        this.prismUrl = prismUrl;
    }

    @JsonProperty("dc:identifier")
    public String getDcIdentifier() {
        return dcIdentifier;
    }

    @JsonProperty("dc:identifier")
    public void setDcIdentifier(String dcIdentifier) {
        this.dcIdentifier = dcIdentifier;
    }

    @JsonProperty("eid")
    public String getEid() {
        return eid;
    }

    @JsonProperty("eid")
    public void setEid(String eid) {
        this.eid = eid;
    }

    @JsonProperty("dc:title")
    public String getDcTitle() {
        return dcTitle;
    }

    @JsonProperty("dc:title")
    public void setDcTitle(String dcTitle) {
        this.dcTitle = dcTitle;
    }

    @JsonProperty("dc:creator")
    public String getDcCreator() {
        return dcCreator;
    }

    @JsonProperty("dc:creator")
    public void setDcCreator(String dcCreator) {
        this.dcCreator = dcCreator;
    }

    @JsonProperty("prism:publicationName")
    public String getPrismPublicationName() {
        return prismPublicationName;
    }

    @JsonProperty("prism:publicationName")
    public void setPrismPublicationName(String prismPublicationName) {
        this.prismPublicationName = prismPublicationName;
    }

    @JsonProperty("prism:issn")
    public String getPrismIssn() {
        return prismIssn;
    }

    @JsonProperty("prism:issn")
    public void setPrismIssn(String prismIssn) {
        this.prismIssn = prismIssn;
    }

    @JsonProperty("prism:pageRange")
    public String getPrismPageRange() {
        return prismPageRange;
    }

    @JsonProperty("prism:pageRange")
    public void setPrismPageRange(String prismPageRange) {
        this.prismPageRange = prismPageRange;
    }

    @JsonProperty("prism:coverDate")
    public String getPrismCoverDate() {
        return prismCoverDate;
    }

    @JsonProperty("prism:coverDate")
    public void setPrismCoverDate(String prismCoverDate) {
        this.prismCoverDate = prismCoverDate;
    }

    @JsonProperty("prism:coverDisplayDate")
    public String getPrismCoverDisplayDate() {
        return prismCoverDisplayDate;
    }

    @JsonProperty("prism:coverDisplayDate")
    public void setPrismCoverDisplayDate(String prismCoverDisplayDate) {
        this.prismCoverDisplayDate = prismCoverDisplayDate;
    }

    @JsonProperty("prism:doi")
    public String getPrismDoi() {
        return prismDoi;
    }

    @JsonProperty("prism:doi")
    public void setPrismDoi(String prismDoi) {
        this.prismDoi = prismDoi;
    }

    @JsonProperty("citedby-count")
    public String getCitedbyCount() {
        return citedbyCount;
    }

    @JsonProperty("citedby-count")
    public void setCitedbyCount(String citedbyCount) {
        this.citedbyCount = citedbyCount;
    }

    @JsonProperty("prism:aggregationType")
    public String getPrismAggregationType() {
        return prismAggregationType;
    }

    @JsonProperty("prism:aggregationType")
    public void setPrismAggregationType(String prismAggregationType) {
        this.prismAggregationType = prismAggregationType;
    }

    @JsonProperty("subtype")
    public String getSubtype() {
        return subtype;
    }

    @JsonProperty("subtype")
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @JsonProperty("subtypeDescription")
    public String getSubtypeDescription() {
        return subtypeDescription;
    }

    @JsonProperty("subtypeDescription")
    public void setSubtypeDescription(String subtypeDescription) {
        this.subtypeDescription = subtypeDescription;
    }

    @JsonProperty("source-id")
    public String getSourceId() {
        return sourceId;
    }

    @JsonProperty("source-id")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @JsonProperty("prism:eIssn")
    public String getPrismEIssn() {
        return prismEIssn;
    }

    @JsonProperty("prism:eIssn")
    public void setPrismEIssn(String prismEIssn) {
        this.prismEIssn = prismEIssn;
    }

    @JsonProperty("prism:volume")
    public String getPrismVolume() {
        return prismVolume;
    }

    @JsonProperty("prism:volume")
    public void setPrismVolume(String prismVolume) {
        this.prismVolume = prismVolume;
    }

    @JsonProperty("pii")
    public String getPii() {
        return pii;
    }

    @JsonProperty("pii")
    public void setPii(String pii) {
        this.pii = pii;
    }

    @JsonProperty("affiliation")
    public List<Affiliation> getAffiliation() {
        return affiliation;
    }

    @JsonProperty("affiliation")
    public void setAffiliation(List<Affiliation> affiliation) {
        this.affiliation = affiliation;
    }

    @JsonProperty("prism:issueIdentifier")
    public String getPrismIssueIdentifier() {
        return prismIssueIdentifier;
    }

    @JsonProperty("prism:issueIdentifier")
    public void setPrismIssueIdentifier(String prismIssueIdentifier) {
        this.prismIssueIdentifier = prismIssueIdentifier;
    }

    @JsonProperty("article-number")
    public String getArticleNumber() {
        return articleNumber;
    }

    @JsonProperty("article-number")
    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
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
