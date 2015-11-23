package com.epam.ism.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damir Ismagambetov.
 */
public abstract class DocElement {

    private List<DocElement> elementList = new ArrayList<>();
    private List<Attribute> attrList = new ArrayList<>();
    private Value value;
    private String elementName;
    private String parentElement;

    public void add(DocElement element) {
        elementList.add(element);
    }

    public void add(Attribute attribute) {
        attrList.add(attribute);
    }

    public List<DocElement> getElementList() {
        return elementList;
    }

    public void setElementList(List<DocElement> elementList) {
        this.elementList = elementList;
    }

    public List<Attribute> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<Attribute> attrList) {
        this.attrList = attrList;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getParentElement() {
        return parentElement;
    }

    public void setParentElement(String parentElement) {
        this.parentElement = parentElement;
    }

    public boolean isItLastElementInList(DocElement element) {
        boolean answer = false;

        DocElement lastElement = elementList.get(elementList.size()-1);
        if (lastElement.equals(element)) answer = true;
        return answer;
    }
}
