import entity.DanceMain;
import org.xml.sax.SAXException;
import parsers.DanceXMLValidator;
import parsers.ParserInitializer;
import transformer.DanceTransformer;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) throws SAXException {



        File xmlFile = new File("src/dances/foxtrot.xml");
        File xsdFile = new File("src/dances/dance.xsd");
        File xslFile = new File("src/dances/foxtrot.xsl");

        System.out.println("Result of validation file: \""+xmlFile+ "\" - "
                + DanceXMLValidator.validateDanceXml(xsdFile, xmlFile));

        DanceMain danceBySAX =ParserInitializer.parseBySAX(xmlFile);
        System.out.println("SAX result: "+danceBySAX);

        DanceMain danceByDOM = ParserInitializer.parseByDOM(xmlFile);
        System.out.println("DOM result: "+danceByDOM);

        DanceMain danseByStAX = ParserInitializer.parseByStAX(xmlFile);
        System.out.println("StAX result: "+danseByStAX);

        DanceTransformer.transform(xmlFile,xslFile);


    }
}
