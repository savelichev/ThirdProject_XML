package parsers;


import entity.DanceMain;
import entity.DanceType;
import entity.MusicType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StAXDanceParser {

    DanceMain dance = new DanceMain();

    public void parse(InputStream input) {

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            process(reader);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }


    }

    private void process(XMLStreamReader reader) throws XMLStreamException {


        String name;

        while (reader.hasNext()) {

            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (StAXParserEnum.valueOf(name.toUpperCase())) {
                        case DANCE:
                            dance.setTitle(reader.getAttributeValue(0));
                            dance.setId(Integer.parseInt(reader.getAttributeValue(1)));
                            break;
                        case TYPE:
                            dance.setType(DanceType.valueOf(reader.getElementText().toUpperCase()));
                            break;
                        case SCENE:
                            dance.setScene(reader.getElementText());
                            break;
                        case NUMBEROFDANCERS:
                            dance.setNumberOfDancers(Integer.parseInt(reader.getElementText()));
                            break;
                        case MUSIC:
                            dance.setMusic(MusicType.valueOf(reader.getElementText().toUpperCase()));
                            break;
                        case DANCER:
                            dance.getDancers().getDancer().add(reader.getElementText());
                            break;
                        case NUMBER:
                            dance.setNumber(Integer.parseInt(reader.getElementText()));
                            break;
                    }
                    break;


            }
        }
    }

}
