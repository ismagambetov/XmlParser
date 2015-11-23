package com.epam.ism.XMLParser;

import com.epam.ism.entity.DocElement;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 *In this class the method which parse the stream is invoked.
 * The type of parsing is chosen by the received parameter
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.ism
 */
public class Parser {

    public DocElement parse(Object obj, InputStream xmlStream) throws IOException, SAXException, ParserConfigurationException {
        DocElement xmlObject = null;

        if (obj instanceof SAXParserFactory) {
            SAXParserFactory factory = (SAXParserFactory) obj;

            factory.setValidating(false);
            SAXParser sp = factory.newSAXParser();
            TheSAXParser handler = new TheSAXParser();
            sp.parse(xmlStream, handler);
            xmlObject = handler.getXMLObject();
        }

        return xmlObject;

    }


}
