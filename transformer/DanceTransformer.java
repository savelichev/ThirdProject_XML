package transformer;


import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DanceTransformer {


    public static void transform(File xml, File xsl) {

        String outputFileName = "src/dances/foxtrot.html";

        Source xslSource = new StreamSource(xsl.getPath());
        Source xmlSource = new StreamSource(xml.getPath());

        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {
            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer transformer = transformerFactory.newTransformer(xslSource);
            transformer.transform(xmlSource, new StreamResult(htmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
