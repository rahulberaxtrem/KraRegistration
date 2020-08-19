/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KRA;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Modi
 */
public class XMLParser {

    private String subRootElement;
    private String xml;
    private Element eElement;

    public XMLParser(String xml, String subRootElement) {
        this.subRootElement = subRootElement;
        this.xml = xml;
        initXMLParser();

    }

    private void initXMLParser() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
            Document doc = dBuilder.parse(bis);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(subRootElement);
            Node nNode = nodeList.item(0);
            eElement = (Element) nNode;
        } catch (Exception e) {
        }
    }
    
    public String getValue(String node){
        return eElement.getElementsByTagName(node).item(0).getTextContent();
    }

}
