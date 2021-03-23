package com.gbss.framework.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;

/**
* Objects from any microservice will have this schema.
*/
public class DynamicObject extends Base {

    private Map<String, Object> extendedParameters = new HashMap<>();

    //@JsonIgnore
    private String collectionName;

    public Map<String, Object> getExtendedParameters() {
        return extendedParameters;
    }

    public void setExtendedParameters(Map<String, Object> extendedParameters) {
        this.extendedParameters = extendedParameters;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public String toString() {
        return super.toString() + ", DynamicObject [" +
                "extendedParameters=" + extendedParameters +
                ']';
    }
}
