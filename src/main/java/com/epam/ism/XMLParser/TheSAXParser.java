package com.epam.ism.XMLParser;

import com.epam.ism.entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * Created by Damir Ismagambetov.
 */
public class TheSAXParser extends DefaultHandler {
    private static final Logger log = Logger.getLogger(TheSAXParser.class);

    private ParentElement parentElementObj;
    private Stack<String> elementStack = new Stack();
    private List<DocElement> subElementList = new ArrayList<>();
    private Iterator<DocElement> itElem;
    private Iterator<Attribute> itAttr;
    private List<Attribute> attrList = new ArrayList<>();
    private String parentElement;


    @Override
    public void startDocument() throws SAXException {
        log.info("Scanning document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //define an elements, and push to the stack
        elementStack.push(qName);
        //if elements have some attributes, we have to create Attribute object
        if (attributes.getLength() != 0) {
            createAttributeObject(attributes, qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //if process fall in this method, it means we have to create Value object,
        //and if value is not empty, program create SubElement object
        String value = new String(ch, start, length).trim();
        if (value.isEmpty()) {
            return;
        }
        DocElement elementObj = new SubElement();
        //fill created element
        fillElementObj(new Value(value), elementObj);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //find parent element and create it as object
        //then fill it by method addElementsToParentElementObj() and fillElementObj()
        if (qName.equals(currentElementParent(1))) {
            parentElementObj = new ParentElement();
            itElem = subElementList.iterator();
            addElementsToParentElementObj();
            fillElementObj(new Value(""),parentElementObj);
        }
    }


    @Override
    public void endDocument() throws SAXException {
        log.info("Scanning document has been finished");
    }

    public void createAttributeObject(Attributes attributes,String qName) {
        for (int i = 0; i < attributes.getLength(); i++) {
            Map<String, String> attrMap = new LinkedHashMap<>();
            Attribute attrObj = new Attribute();
            attrMap.put(attributes.getQName(i), attributes.getValue(i));
            attrObj.setAttrMap(attrMap);
            attrObj.setElement(qName);
            attrList.add(attrObj);
        }

    }

    public void fillElementObj(Value valueObj, DocElement elementObj) {
        String currentElement = currentElement();
        itAttr = attrList.iterator();
        addAttributesToElementObj(elementObj);

        elementObj.setValue(valueObj);
        elementObj.setElementName(currentElement);
        parentElement = currentElementParent(2);
        elementObj.setParentElement(parentElement);
        subElementList.add(elementObj);
        elementStack.pop();
    }

    public void addAttributesToElementObj(DocElement elementObj){
        String currentElement = currentElement();

        while(itAttr.hasNext()) {
            Attribute nextAttr = itAttr.next();
            if (currentElement.equals(nextAttr.getElement())) {
                elementObj.add(nextAttr);
                itAttr.remove();
            }
        }
    }

    public void addElementsToParentElementObj() {
        while (itElem.hasNext()) {
            DocElement nextElement = itElem.next();
            String parElement  = nextElement.getParentElement();
            if (parElement.equals(parentElement)) {
                parentElementObj.add(nextElement);
                itElem.remove();
            }
        }
    }

    public String currentElement() {
        return elementStack.peek();
    }

    private String currentElementParent(int i) {
        if (elementStack.size() == 1) return elementStack.get(0);
        return elementStack.get(elementStack.size()-i);
    }

    public DocElement getXMLObject() {
        return parentElementObj;
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {

    }

    @Override
    public void error(SAXParseException e) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {

    }
}

