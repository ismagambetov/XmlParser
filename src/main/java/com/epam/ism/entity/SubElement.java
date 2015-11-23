package com.epam.ism.entity;


import java.util.List;

/**
 * Created by Damir Ismagambetov.
 */
public class SubElement extends DocElement {
    @Override
    public void add(DocElement element) {
        super.add(element);
    }

    @Override
    public void add(Attribute attribute) {
        super.add(attribute);
    }

    @Override
    public List<DocElement> getElementList() {
        return super.getElementList();
    }

    @Override
    public void setElementList(List<DocElement> elementList) {
        super.setElementList(elementList);
    }

    @Override
    public List<Attribute> getAttrList() {
        return super.getAttrList();
    }

    @Override
    public void setAttrList(List<Attribute> attrList) {
        super.setAttrList(attrList);
    }

    @Override
    public Value getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Value value) {
        super.setValue(value);
    }

    @Override
    public String getElementName() {
        return super.getElementName();
    }

    @Override
    public void setElementName(String elementName) {
        super.setElementName(elementName);
    }

    @Override
    public String getParentElement() {
        return super.getParentElement();
    }

    @Override
    public void setParentElement(String parentElement) {
        super.setParentElement(parentElement);
    }
}
