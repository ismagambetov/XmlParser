package com.epam.ism.tools;

import com.epam.ism.entity.Attribute;
import com.epam.ism.entity.DocElement;
import com.epam.ism.entity.SubElement;

import java.util.List;

/**
 * Created by Damir Ismagambetov.
 */
public class ConvertToXMLDocument {

    private static final String OPEN_TAG = "<";
    private static final String CLOSE_TAG = ">";
    private static final String END_ELEMENT = "</";
    private static final String ENCODING_TYPE = "<?xml version =\"1.0\" encoding = \"UTF-8\"?>";
    private static final String WHITESPACE = " ";
    private static final String QUOTE = "\"";
    StringBuilder sb = new StringBuilder();

    public ConvertToXMLDocument() {
        sb.append(ENCODING_TYPE);
        sb.append('\n');
    }

    public String convert(DocElement xmlObject) {

        String elemName = xmlObject.getElementName();
        List<DocElement> list = xmlObject.getElementList();
        sb.append(OPEN_TAG);
        sb.append(elemName);
        List<Attribute> attrList = xmlObject.getAttrList();
        if(!attrList.isEmpty()) {
            sb.append(WHITESPACE);
            attr(attrList);
        }
        sb.append(CLOSE_TAG);

        if(xmlObject instanceof SubElement) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xmlObject.getValue().getValue());
            sb2.append(END_ELEMENT.concat(elemName).concat(CLOSE_TAG));
            sb2.append('\n');
            return sb2.toString();
        }

        for(DocElement element: list) {
            sb.append(convert(element));
        }

        sb.append(END_ELEMENT.concat(elemName).concat(CLOSE_TAG));
        if (elemName.equals(xmlObject.getParentElement())) {
            return sb.toString();
        }

        return "";

    }


    public void attr(List<Attribute> attrList) {
        for(int i = 0; i < attrList.size(); i++) {
            sb.append(attrList.get(i).getKey()); // название атрибута
            sb.append("=");
            sb.append(QUOTE);
            sb.append(attrList.get(i).getValue()); // сам атрибут
            sb.append(QUOTE);
            if(i != attrList.size()-1) {
                sb.append(WHITESPACE);
            }
        }
    }
}
