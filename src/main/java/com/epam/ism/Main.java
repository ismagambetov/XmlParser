package com.epam.ism;

import com.epam.ism.XMLParser.Parser;
import com.epam.ism.entity.DocElement;
import com.epam.ism.tools.ConvertToXMLDocument;
import com.epam.ism.tools.Exporter;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import org.apache.log4j.Logger;

/**
 * <p>Task 3: XML document Parsing Project</p>
 *
 * <p>It is Main.class in which the following actions are carried out:
 * readings the XML document from resources, parsing stream by SAX, STAX and DOM methods.
 * Parsed object is converted to XML, and written to the output.xml file.
 * This class throws different exceptions that are called during code execution.</p>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.ism.XMLParser
 * @see         com.epam.ism.tools
 * @see         com.epam.ism.entity
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    /**
     * @param args
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream xmlStream = classLoader.getResourceAsStream("dance.xml");

        log.info("Start SAX parsing process");
        Parser parser = new Parser();
        DocElement xmlObject = parser.parse(SAXParserFactory.newInstance(), xmlStream);
        log.info("Get parsed object");
        //DocElement xmlObject = parser.parse(DocumentBuilderFactory.newInstance(), xmlStream);
        //DocElement xmlObject = parser.parse(STAXParserFactory.newInstance(), xmlStream);


        log.info("Convert xml object to string source");
        ConvertToXMLDocument converter = new ConvertToXMLDocument();
        String strXML = converter.convert(xmlObject);

        Exporter exporter = new Exporter();
        exporter.exportToFile(strXML);

        log.info("XML document is done!");

        System.out.println("C:/TMP/log_file.log");

    }
}
