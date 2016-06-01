
package entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the entity package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Dance_QNAME = new QName("", "dance");

    public DanceMain createDanceMain() {
        return new DanceMain();
    }

    public DancerInfo createDancerInfo() {
        return new DancerInfo();
    }

    @XmlElementDecl(namespace = "", name = "dance")
    public JAXBElement<DanceMain> createDance(DanceMain value) {
        return new JAXBElement<DanceMain>(_Dance_QNAME, DanceMain.class, null, value);
    }

}
