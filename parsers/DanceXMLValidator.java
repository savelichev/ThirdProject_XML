package parsers;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DanceXMLValidator {

    public static Boolean validateDanceXml(File xsd, File xml) throws SAXException {

        Boolean isValid = false;

        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        Schema schema = factory.newSchema(xsd);

        Validator validator = schema.newValidator();

        Source source = new StreamSource(xml);

        try {
            validator.validate(source);
            isValid = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isValid;

    }
}
