
package com.example.demo.rest;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Data implements Serializable
{

    @JsonIgnore
    private HashMap<Object, Details> additionalProperties = new HashMap<Object, Details>();
    private final static long serialVersionUID = 9157564475648604870L;

    @JsonAnyGetter
    public HashMap<Object, Details> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public Details getProperty(String name) { return this.additionalProperties.get(name); }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Details value) {
        this.additionalProperties.put(name, value);
    }

}
