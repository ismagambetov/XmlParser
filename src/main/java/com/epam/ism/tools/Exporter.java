package com.epam.ism.tools;

import java.io.*;

/**
 * Created by Damir Ismagambetov.
 */
public class Exporter {

    public void exportToFile(String strXML) throws IOException {

        OutputStream outputStream = new FileOutputStream("output.xml");
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(strXML);
        writer.close();

    }

}
