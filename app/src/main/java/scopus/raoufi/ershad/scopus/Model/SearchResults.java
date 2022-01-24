package scopus.raoufi.ershad.scopus.Model;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "opensearch:totalResults",
    "opensearch:startIndex",
    "opensearch:itemsPerPage",
    "opensearch:Query",
    "link",
    "entry"
})

public class SearchResults {

    @JsonProperty("opensearch:totalResults")
    private String opensearchTotalResults;
    @JsonProperty("opensearch:startIndex")
    private String opensearchStartIndex;
    @JsonProperty("opensearch:itemsPerPage")
    private String opensearchItemsPerPage;
    @JsonProperty("opensearch:Query")
    private OpensearchQuery opensearchQuery;
    @JsonProperty("link")
    private List<Link> navigation = null;
    @JsonProperty("entry")
    private List<Entry> entry = null;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("opensearch:totalResults")
    public String getOpensearchTotalResults() {
        return opensearchTotalResults;
    }

    @JsonProperty("opensearch:totalResults")
    public void setOpensearchTotalResults(String opensearchTotalResults) {
        this.opensearchTotalResults = opensearchTotalResults;
    }

    @JsonProperty("opensearch:startIndex")
    public String getOpensearchStartIndex() {
        return opensearchStartIndex;
    }

    @JsonProperty("opensearch:startIndex")
    public void setOpensearchStartIndex(String opensearchStartIndex) {
        this.opensearchStartIndex = opensearchStartIndex;
    }

    @JsonProperty("opensearch:itemsPerPage")
    public String getOpensearchItemsPerPage() {
        return opensearchItemsPerPage;
    }

    @JsonProperty("opensearch:itemsPerPage")
    public void setOpensearchItemsPerPage(String opensearchItemsPerPage) {
        this.opensearchItemsPerPage = opensearchItemsPerPage;
    }

    @JsonProperty("opensearch:Query")
    public OpensearchQuery getOpensearchQuery() {
        return opensearchQuery;
    }

    @JsonProperty("opensearch:Query")
    public void setOpensearchQuery(OpensearchQuery opensearchQuery) {
        this.opensearchQuery = opensearchQuery;
    }

    @JsonProperty("link")
    public List<Link> getLink() {
        return navigation;
    }

    @JsonProperty("link")
    public void setLink(List<Link> link) {
        this.navigation = link;
    }

    @JsonProperty("entry")
    public List<Entry> getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(List<Entry> entry) {
        int id = 0;
        for (Entry item : entry) {
            switch (item.getSubtype()) {
                case "ar":
                    item.setSubtype("مقاله");
                    break;
                case "ab":
                    item.setSubtype("گزارش چکیده");
                    break;
                case "ip":
                    item.setSubtype("مقاله");
                    break;
                case "bk":
                    item.setSubtype("کتاب");
                    break;
                case "bz":
                    item.setSubtype("مقاله تجاری");
                    break;
                case "ch":
                    item.setSubtype("قسمتی از کتاب");
                    break;
                case "cp":
                    item.setSubtype("کنفرانس");
                    break;
                case "cr":
                    item.setSubtype("کنفرانس");
                    break;
                case "ed":
                    item.setSubtype("ویرایش شده");
                    break;
                case "le":
                    item.setSubtype("نامه");
                    break;
                case "no":
                    item.setSubtype("دست نوشته");
                    break;
                case "Press Release":
                    item.setSubtype("مطلب مطبوعاتی");
                    break;
                     case "Review":
                    item.setSubtype("مرور");
                    break;
                     case "sh":
                    item.setSubtype("مرور کوتاه");
                    break;

            }
            item.setID(++id);
        }
        this.entry  = entry;
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
