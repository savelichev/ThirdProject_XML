import entity.DanceMain;
import org.xml.sax.SAXException;
import parsers.DanceXMLValidator;
import parsers.ParserInitializer;

import java.io.File;

public class Main {

    public static void main(String[] args) throws SAXException {



        File xmlFile = new File("src/dances/foxtrot.xml");
        File xsdFile = new File("src/dances/dance.xsd");

        System.out.println("Result of validation file: \""+xmlFile+ "\" - "+ DanceXMLValidator.validateDanceXml(xsdFile, xmlFile));

        DanceMain danceBySAX =ParserInitializer.parseBySAX(xmlFile);
        System.out.println("SAX result: "+danceBySAX);

        DanceMain danceByDOM = ParserInitializer.parseByDOM(xmlFile);
        System.out.println("DOM result: "+danceByDOM);


    }
}
