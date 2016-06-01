package parsers;

import entity.DanceMain;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by savel_000 on 01.06.2016.
 */
public class ParserInitializer {

    public static DanceMain parseBySAX(File file) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXDanceParser mySaxDanceParser = new SAXDanceParser();
        try {
            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(file, mySaxDanceParser);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mySaxDanceParser.getDance();

    }

    public static  DanceMain parseByDOM(File file){

        DOMDanceParser dom = new DOMDanceParser();
        try {
            dom.parseByDOM();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return dom.dance;
    }

}
