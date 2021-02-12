package com.ipiecoles.horoscope;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.StringJoiner;

public class Horoscope {

    private String Horoscope;

    public HoroscopeOutPut getHoroscope(String donneesSigne){
        HoroscopeOutPut horoscopeOutPut = new HoroscopeOutPut();

        Document docXML = convertStringToXMLDocument(donneesSigne);

        String description = descriptionXML(docXML); // ecrire le parse pour recuperer la description

        horoscopeOutPut.setHoroscope(description);
        return horoscopeOutPut;
    }

    private static String descriptionXML(Document docXML){

        docXML.getDocumentElement().normalize();

        NodeList nList = docXML.getElementsByTagName("item");
        String description = "";
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                description = eElement.getElementsByTagName("description").item(0).getTextContent();

            }
        }
        description = description.replace("\n", " ");
        return description;
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

    public HoroscopeOutPut getHoroscopeFromSigne(String signe) throws IOException {


        String url = "https://www.asiaflash.com/horoscope/rss_horojour_"+signe+".xml";
        String donnée = getPageContents(url);
        HoroscopeOutPut horoscopeOutPut = getHoroscope(donnée);
        return horoscopeOutPut;

    }

/*    public HoroscopeData getHoroscope(String signe, String donneesSigne){
        if (signe == null){
            return null;
        }

        return null;
    }*/
}
