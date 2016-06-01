package parsers;


import entity.DanceMain;
import entity.DanceType;
import entity.MusicType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMDanceParser {

    DanceMain dance = new DanceMain();

    public DanceMain parseByDOM() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src\\dances\\foxtrot.xml"));

        NodeList nodeList = document.getElementsByTagName("dance");
        for (int i = 0; i < nodeList.getLength(); i++) {

            Element element = (Element) nodeList.item(i);

            dance.setId(Integer.parseInt(element.getAttributes().getNamedItem("id").getNodeValue()));
            dance.setTitle(element.getAttributes().getNamedItem("title").getNodeValue());

            setDanceType(element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue());

            dance.setScene(element.getElementsByTagName("scene").item(0).getChildNodes().item(0).getNodeValue());

            dance.setNumberOfDancers(Integer.parseInt(element.getElementsByTagName("numberOfDancers").item(0).getChildNodes().item(0).getNodeValue()));

            setDancers(element);

            setMusicType(element.getElementsByTagName("music").item(0).getChildNodes().item(0).getNodeValue());

            dance.setNumber(Integer.parseInt(element.getElementsByTagName("number").item(0).getChildNodes().item(0).getNodeValue()));
            return dance;
        }

        return null;
    }

    public void setDanceType(String danceType) {
        switch (danceType) {
            case "ballroom":
                dance.setType(DanceType.BALLROOM);
                break;
            case "street":
                dance.setType(DanceType.STREET);
                break;
            case "ballet":
                dance.setType(DanceType.BALLET);
                break;
            case "latinos":
                dance.setType(DanceType.LATINOS);
                break;
            case "folk":
                dance.setType(DanceType.FOLK);
                break;
        }

    }

    public void setMusicType(String musicType) {
        switch (musicType) {
            case "phonogram":
                dance.setMusic(MusicType.PHONOGRAM);
                break;
            case "live":
                dance.setMusic(MusicType.LIVE);
                break;
        }
    }

    public void setDancers(Element element) {

        NodeList dancers = element.getElementsByTagName("dancer");
        for (int i = 0; i < dancers.getLength(); i++) {
            dance.getDancers().getDancer().add(dancers.item(i).getChildNodes().item(0).getNodeValue());
        }
    }


}





