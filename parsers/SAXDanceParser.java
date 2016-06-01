package parsers;


import entity.DanceMain;
import entity.DanceType;
import entity.MusicType;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SAXDanceParser extends DefaultHandler {

    private String thisElement;

    private DanceMain dance = new DanceMain();

    public DanceMain getDance() {
        return dance;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        if (thisElement.equals("dance")) {

            dance.setTitle(attributes.getValue(0));

            dance.setId(new Integer(attributes.getValue(1)));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (!(s.trim().equals(""))) {
            if (thisElement.equals("type")) {
                if (s.equals("ballroom")) {
                    dance.setType(DanceType.BALLROOM);
                } else if (s.equals("street")) {
                    dance.setType(DanceType.STREET);
                } else if (s.equals("ballet")) {
                    dance.setType(DanceType.BALLET);
                } else if (s.equals("latinos")) {
                    dance.setType(DanceType.LATINOS);
                } else if (s.equals("folk")) {
                    dance.setType(DanceType.FOLK);
                }
            }
            if (thisElement.equals("scene")) {
                dance.setScene(s);
            }
            if (thisElement.equals("numberOfDancers")) {
                dance.setNumberOfDancers(Integer.parseInt((s)));
            }

            if (thisElement.equals("number")) {
                dance.setNumber(new Integer(s));
            }

            if (thisElement.equals("music")) {
                if (s.equals("phonogram")) {
                    dance.setMusic(MusicType.PHONOGRAM);
                } else if (s.equals("live")) {
                    dance.setMusic(MusicType.LIVE);
                }
            }

            if (thisElement.equals("dancer")) {
                dance.getDancers().getDancer().add(s);
            }

        }
    }
}


