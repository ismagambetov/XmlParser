package com.epam.ism.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Damir Ismagambetov.
 */
public class Attribute {
    Map<String,String> attrMap = new HashMap<>();

    private String element;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Map<String,String> getAttrMap() {
        return attrMap;
    }

    public void setAttrMap(Map<String,String> attr) {
        this.attrMap = attr;
    }

    public void put(String key, String value) {
        attrMap.put(key,value);
    }

    public String getKey() {
        String key = new String();
        for (Map.Entry<String,String> map: attrMap.entrySet()) {
            key = map.getKey();
        }
        return key;
    }

    public String getValue() {
        String value = new String();
        for (Map.Entry<String,String> map: attrMap.entrySet()) {
            value = map.getValue();
        }
        return value;
    }


}
