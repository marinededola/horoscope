package com.ipiecoles.horoscope;



import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.StringJoiner;

public class Horoscope {

    private String Horoscope;

    public HoroscopeOutPut getHoroscope(String donneesSigne){
        HoroscopeOutPut horoscopeOutPut = new HoroscopeOutPut();

        String description ="";
        horoscopeOutPut.setDescription(description);
        return horoscopeOutPut;
    }

    private static Document convertStringToXMLDocument(String xmlString)
            // ATTETION 2 import possible (pas sur d'avoir pris le bon)
    {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try
        {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }
    public HoroscopeData getHoroscope(String signe, String donneesSigne){
        if (signe == null){
            return null;
        }

        return null;
    }
}
