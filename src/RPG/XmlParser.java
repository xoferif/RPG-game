package RPG;
import com.sun.org.apache.xml.internal.serializer.OutputPropertiesFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by Morten on 04-03-2016.
 */
public class XmlParser {
    IO io = new IO();
    public void XMLWriter(Game game) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        // Root elementet
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Game");
        doc.appendChild(rootElement);

        // Player element
        Element player = doc.createElement("Player");
        rootElement.appendChild(player);

        // set id attributen på student elementet
        player.setAttribute("id", "1");

        // Player name element
        Element playerName = doc.createElement("playerName");
        playerName.appendChild(doc.createTextNode(game.player.getName()));
        player.appendChild(playerName);

        // Player description element
        Element playerDescription = doc.createElement("playerDescription");
        playerDescription.appendChild(doc.createTextNode(game.player.getDescription()));
        player.appendChild(playerDescription);

        // Player level element
        Element level = doc.createElement("playerLevel");
        level.appendChild(doc.createTextNode(String.valueOf(game.player.getLevel())));
        player.appendChild(level);

        // Skriv indholdet til en xml fil
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;

        try{
            transformer = transformerFactory.newTransformer();
        }catch (TransformerConfigurationException TCE){
            TCE.printStackTrace();
        }
        transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "2");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("GameInformation.xml"));

        try{
            transformer.transform(source, result);
        }catch (TransformerException TE){
            TE.printStackTrace();
        }

        io.print("File saved!");
    }
    public void XMLReader(){
        //Opret Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try{
             builder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException PCE){
            PCE.printStackTrace();
        }

        //Byg dokumentet
        Document document = null;
        try {
            document = builder.parse(new File("GameInformation.xml"));
        }
        catch (IOException IOE){IOE.printStackTrace();}
        catch (SAXException SAX){SAX.printStackTrace();}

        //Normaliser XML Strukturen
        document.getDocumentElement().normalize();

        //Få fat i root noden
        Element root = document.getDocumentElement();
        io.print(root.getNodeName());

        //Hent alle studerende
        NodeList nList = document.getElementsByTagName("Player");
        io.print("=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            io.print("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                //Print detaljerne for hver student
                Element eElement = (Element) node;
                io.print("Player id : "  + eElement.getAttribute("id"));
                io.print("Player Name : "  + eElement.getElementsByTagName("playerName").item(0).getTextContent());
                io.print("Player Description : "   + eElement.getElementsByTagName("playerDescription").item(0).getTextContent());
                io.print("Player level : "    + eElement.getElementsByTagName("playerLevel").item(0).getTextContent());
            }
        }
    }

}
