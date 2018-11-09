package com.github.trolleydilemma.core;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class with method for loading XML file into List
 * @author Krzysztof Berda
 */
public class XMLUtility {

    /**
     * Load words from XML file
     * @param XMLPath path for XML file with vocabulary
     * @return list of all words contained in specified XML file
     */
    static List<Word> loadWords(String XMLPath) {

        List<Word> words = new ArrayList<>();
        try {
            File inputFile = new File(XMLPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("word");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    ArrayList<String> ljap = new ArrayList<String>();
                    for(int itemp=0;itemp < eElement.getElementsByTagName("jap").getLength();itemp++) {
                        ljap.add(eElement.getElementsByTagName("jap").item(itemp).getTextContent());
                    }
                    ArrayList<String> leng = new ArrayList<String>();
                    for(int itemp=0;itemp < eElement.getElementsByTagName("eng").getLength();itemp++) {
                        leng.add(eElement.getElementsByTagName("eng").item(itemp).getTextContent());
                    }
                    words.add(new Word(Integer.parseInt(eElement.getAttribute("id")),leng,ljap,
                            eElement.getElementsByTagName("lvl").item(0).getTextContent(),
                            eElement.getElementsByTagName("note").item(0).getTextContent()));
                }
            }
        }catch( ParserConfigurationException e){
            e.printStackTrace();
        }
        catch( IOException ioexception){
            ioexception.printStackTrace();
        }
        catch( SAXException saxexception){
            saxexception.printStackTrace();
        }
        return words;
    }

}
