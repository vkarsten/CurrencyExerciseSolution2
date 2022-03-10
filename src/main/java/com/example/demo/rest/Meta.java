
package com.example.demo.rest;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "last_updated_at"
})
@Generated("jsonschema2pojo")
public class Meta implements Serializable
{

    @JsonProperty("last_updated_at")
    private String lastUpdatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9062663597748671184L;

    @JsonProperty("last_updated_at")
    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    @JsonProperty("last_updated_at")
    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
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
